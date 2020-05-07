/*
 * Table.java
 */
package com.tracktopell.dao.builder.metadata;

import com.tracktopell.dao.builder.FormatString;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class Table {

	protected String schemma;
	protected String name;
	protected String singularName;
	protected String javaDeclaredName;
	protected String label;
	protected boolean transactionalTable;
	protected boolean preferredSingularName;
	protected boolean auditable;	
	protected Hashtable<String, Column> columns;
	protected Hashtable<String, ReferenceTable> foreignKeys;
	protected List<Index> indexes;
	protected String comments;
	protected String toStringPattern;
	
	protected boolean DTOJsonProperty_SNAKE;
	protected boolean DTOJsonProperty_CAMEL;

	private Hashtable<String, String> metaProperties;
	
	private List<Column>            plainColumns;
	private List<EmbeddeableColumn> embededColumns;
	private List<Table>             m2mTableList;
	private List<Table>             o2mTableList;
	
	/**
	 * Creates a new instance of Table
	 */
	public Table() {
		this.preferredSingularName = true;
		this.DTOJsonProperty_SNAKE = false;
		this.DTOJsonProperty_CAMEL = true;

	}

	public void addColumn(Column col) {
		this.getColumns().put(col.getName(), col);
	}

	public Enumeration<String> getColumNames() {
		return this.getColumns().keys();
	}

	public Iterator<Column> getSortedColumns() {
		Collection<Column> c = this.getColumns().values();
		TreeSet treeSorter = new TreeSet<Column>(new Comparator<Column>() {

			public int compare(Column c1, Column c2) {
				return c1.getPosition() - c2.getPosition();
			}
		});
		treeSorter.addAll(c);

		return treeSorter.iterator();
	}

	public boolean isManyToManyTableWinthMoreColumns() {
		return countForeignKeys()==2
				&& countPrimaryKeys()==2
				&& columns.size()==2;
	}

	public Iterator<Column> getSortedColumnsForJPA() {
		Iterator<Column> icpks = null;
		Collection<Column> c = this.getColumns().values();
		TreeSet treeSorter = new TreeSet<Column>(new Comparator<Column>() {

			public int compare(Column c1, Column c2) {
				return c1.getPosition() - c2.getPosition();
			}
		});
		treeSorter.addAll(c);
		//----------------------------------------------
		icpks = treeSorter.iterator();
		ArrayList<Column> simpleColumns = new ArrayList<Column>();
		Collection<Column> pksColumns = new ArrayList<Column>();

		boolean shuldHasEmbeddeableColumn
				= //countForeignKeys() >= 1  &&
				countPrimaryKeys() >= 2
				&& countPrimaryKeys() <= columns.size();

		//System.err.println("\t\t-->> in Table: "+getName()+" -> shuldHasEmbeddeableColumn = "+shuldHasEmbeddeableColumn+" : pks.size= "+countPrimaryKeys()+" fks.size="+countForeignKeys()+", columns.size="+columns.size());
		while (icpks.hasNext()) {
			Column cpk = icpks.next();

			if (cpk.isPrimaryKey() && shuldHasEmbeddeableColumn) {
				pksColumns.add(cpk);
			} else {
				simpleColumns.add(cpk);
			}
		}
		int pos = 0;
		if (shuldHasEmbeddeableColumn) {
			EmbeddeableColumn embeddeablePK = new EmbeddeableColumn();

			embeddeablePK.setName(getName() + "_P_K");
			embeddeablePK.setJavaClassType(FormatString.getCadenaHungara(getName() + "_P_K"));
			embeddeablePK.buildPosibleLabel();
			embeddeablePK.setPrimaryKey(true);

			for (Column pkc : pksColumns) {
				Column internalColumn = new SimpleColumn();
				internalColumn.setAutoIncremment(pkc.isAutoIncremment());
				internalColumn.setComments(pkc.getComments());
				internalColumn.setFarFKDescription(pkc.getFarFKDescription());
				internalColumn.setForeignDescription(pkc.isForeignDescription());
				internalColumn.setForeignKey(pkc.isForeignKey());
				internalColumn.setJavaClassType(pkc.getJavaClassType());
				internalColumn.setLabel(pkc.getLabel());
				internalColumn.setName(pkc.getName());
				internalColumn.setNullable(pkc.isNullable());
				internalColumn.setPosition(pos++);
				internalColumn.setPrecision(pkc.getPrecision());
				internalColumn.setPrimaryKey(true);
				internalColumn.setScale(pkc.getScale());
				internalColumn.setSqlType(pkc.getSqlType());
				internalColumn.setTypeFormatingNumber(pkc.getTypeFormatingNumber());

				embeddeablePK.addColumn(internalColumn);
				if (pkc.isForeignKey()) {
					ReferenceTable referenceTable = getFKReferenceTable(pkc.getName());
					embeddeablePK.addForeignKey(pkc.getName(), referenceTable);
				}
			}
			simpleColumns.add(0, embeddeablePK);
		}
		pos = 0;
		for (Column pkcs : pksColumns) {
			if (pkcs.isPrimaryKey() && pkcs.isForeignKey() && pkcs instanceof SimpleColumn) {
				Column modifiedPKColumn = new SimpleColumn();
				modifiedPKColumn.setAutoIncremment(pkcs.isAutoIncremment());
				modifiedPKColumn.setComments(pkcs.getComments());
				modifiedPKColumn.setFarFKDescription(pkcs.getFarFKDescription());
				modifiedPKColumn.setForeignDescription(pkcs.isForeignDescription());
				modifiedPKColumn.setForeignKey(pkcs.isForeignKey());
				modifiedPKColumn.setJavaClassType(pkcs.getJavaClassType());
				modifiedPKColumn.setLabel(pkcs.getLabel());
				modifiedPKColumn.setName(pkcs.getName());
				modifiedPKColumn.setNullable(pkcs.isNullable());
				modifiedPKColumn.setPosition(pos++);
				modifiedPKColumn.setPrecision(pkcs.getPrecision());
				modifiedPKColumn.setPrimaryKey(true);
				modifiedPKColumn.setScale(pkcs.getScale());
				modifiedPKColumn.setSqlType(pkcs.getSqlType());
				modifiedPKColumn.setTypeFormatingNumber(pkcs.getTypeFormatingNumber());

				simpleColumns.add(modifiedPKColumn);
			}
		}

		return simpleColumns.iterator();
	}

	public Column getColumn(String columnName) {
		return this.getColumns().get(columnName);
	}

	protected Hashtable<String, Column> getColumns() {
		if (this.columns == null) {
			this.columns = new Hashtable<String, Column>();
		}
		return this.columns;
	}

	public void addForeignKey(String columnName, ReferenceTable fk) {
		this.getForeignKeys().put(columnName, fk);
	}

	public Enumeration<String> getFKColumnNames() {
		return this.getForeignKeys().keys();
	}

	public int countForeignKeys() {
		return this.getForeignKeys().size();
	}

	public int countPrimaryKeys() {
		int npks = 0;
		Collection<Column> cc = columns.values();
		for (Column c : cc) {
			if (c.isPrimaryKey() && c instanceof SimpleColumn) {
				npks++;
			}
		}
		return npks;
	}

	public ReferenceTable getFKReferenceTable(String columnName) {
		return this.getForeignKeys().get(columnName);
	}

	public Collection<ReferenceTable> getFKReferenceTables() {
		return this.getForeignKeys().values();
	}

	protected Hashtable<String, ReferenceTable> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new Hashtable<String, ReferenceTable>();
		}
		return foreignKeys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListColumnsNames() {
		StringBuffer sb = new StringBuffer("");

		Iterator<Column> ic = getSortedColumns();
		int nc = 0;
		while (ic.hasNext()) {
			if (nc > 0) {
				sb.append(" ,");
			}
			Column col = ic.next();
			sb.append(this.getName());
			sb.append(".");
			sb.append(col.getName());
			nc++;
		}
		return sb.toString();
	}

	public String getListColumnsNamesForInsert() {
		StringBuffer sb = new StringBuffer("");

		Iterator<Column> ic = getSortedColumns();
		int nc = 0;
		while (ic.hasNext()) {
			Column col = ic.next();
			if (col.isAutoIncremment()) {
				continue;
			}

			if (nc > 0) {
				sb.append(" ,");
			}
			sb.append(this.getName());
			sb.append(".");
			sb.append(col.getName());
			nc++;
		}
		return sb.toString();
	}

	public String getListFKTableNames() {
		StringBuffer sb = new StringBuffer("");

		Collection<ReferenceTable> rts = getFKReferenceTables();

		int nc = 0;
		for (ReferenceTable rt : rts) {
			if (nc > 0) {
				sb.append(" ,");
			}
			sb.append(rt.getTableName());

			nc++;
		}
		return sb.toString();
	}

	public String getListMatchers4PS() {
		StringBuffer sb = new StringBuffer("");

		Iterator<Column> ic = getSortedColumns();
		int nc = 0;
		while (ic.hasNext()) {
			if (nc > 0) {
				sb.append(" ,");
			}
			Column col = ic.next();
			sb.append("?");
			nc++;
		}
		return sb.toString();

	}

	public String getListMatchers4InsertPS() {
		StringBuffer sb = new StringBuffer("");

		Iterator<Column> ic = getSortedColumns();
		int nc = 0;
		while (ic.hasNext()) {
			Column col = ic.next();
			if (col.isAutoIncremment()) {
				continue;
			}
			if (nc > 0) {
				sb.append(" ,");
			}
			sb.append("?");
			nc++;
		}
		return sb.toString();

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		Iterator<Column> ic = getSortedColumns();
		sb.append("\t");
        if(auditable){
            sb.append("*[");
            sb.append(this.name);
            sb.append("]*");
        } else{
            sb.append(this.name);
        }
		
		sb.append(" {\n");
		while (ic.hasNext()) {
			sb.append("\t\t");
			Column col = ic.next();
			sb.append("[");
			sb.append(col.getPosition());
			sb.append("] ");
			sb.append(col.toString());
			if (getFKReferenceTable(col.getName()) != null) {
				sb.append(" FOREIGN_KEY_OF ");
				sb.append(getFKReferenceTable(col.getName()).getTableName());
				sb.append("(");
				sb.append(getFKReferenceTable(col.getName()).getColumnName());
				sb.append(")");
			}
			if (!col.isNullable()) {
				sb.append(" NOT NULL");
			}
			sb.append("\t\n");
		}

		sb.append("\t\t,Indexes {\n");
		Iterator<Index> iti = this.getIndexes();
		while (iti.hasNext()) {
			Index idx = iti.next();
			sb.append("\t\t\t");
			sb.append(idx.toString());
			sb.append("\n");
		}
		sb.append("\t\t}\n");
		sb.append("\t}\n");
		return sb.toString();
	}

	public Iterator<Column> getAutoIncrementColums() {
		Collection<Column> cc = columns.values();
		Collection<Column> autoC = new ArrayList<Column>();
		for (Column c : cc) {
			if (c.isAutoIncremment()) {
				autoC.add(c);
			}
		}
		return autoC.iterator();
	}

	public Collection<Column> getPrimaryKeys() {
		Collection<Column> cc = columns.values();
		Collection<Column> autoC = new ArrayList<Column>();
		for (Column c : cc) {
			if (c.isPrimaryKey()) {
				autoC.add(c);
			}
		}
		return autoC;
	}

	public ArrayList<Column> getFKs() {
		Collection<Column> cc = columns.values();
		ArrayList<Column> autoC = new ArrayList<Column>();
		for (Column c : cc) {
			if (c.isForeignKey()) {
				autoC.add(c);
			}
		}
		return autoC;
	}

	public HashMap<Integer,Column> getFKsForCreation() {
		Collection<Column> cc = columns.values();
		HashMap<Integer,Column> fksMap = new HashMap<Integer,Column>();
		for (Column c : cc) {
			if (c.isForeignKey()) {
				fksMap.put(c.getPosition(),c);
			}
		}
		return fksMap;
	}
    
	public Collection<Column> getForeignDescriptionColumns() {
		Collection<Column> cc = columns.values();
		Collection<Column> autoC = new ArrayList<Column>();
		for (Column c : cc) {
			if (c.isForeignDescription()) {
				autoC.add(c);
			}
		}
		return autoC;
	}

	public boolean isPrimaryTable() {
		return !isRelationalTable() && !isTransactionalTable();
	}

	public boolean isRelationalTable() {
		Iterator<Column> sc = getSortedColumns();
		int numRelCols = 0;
		while (sc.hasNext()) {
			Column scc = sc.next();
			if (scc.isForeignKey() && scc.isPrimaryKey()) {
				numRelCols++;
			}
		}
		return numRelCols >= 2;
	}

	public String getLabel() {
		if (label == null) {
			buildPosibleLabel();
		}
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isTransactionalTable() {
		return transactionalTable;
	}

	public void setTransactionalTable(boolean transactionalTable) {
		this.transactionalTable = transactionalTable;
	}

	public void buildPosibleLabel() {
		String[] nameParts = name.split("_");
		StringBuffer sb = new StringBuffer();
		for (String sn : nameParts) {
			sb.append(sn.substring(0, 1).toUpperCase());
			sb.append(sn.substring(1).toLowerCase());
			sb.append(" ");
		}
		label = sb.toString().trim();
		Iterator<Column> ic = getSortedColumns();

		while (ic.hasNext()) {
			Column col = ic.next();
			col.buildPosibleLabel();
		}
	}

	public void addIndex(Index i) {
		if (indexes == null) {
			indexes = new ArrayList<Index>();
		}
		indexes.add(i);
	}

	public Iterator<Index> getIndexes() {
		if (indexes == null) {
			indexes = new ArrayList<Index>();
		}
		return indexes.iterator();
	}

	public String getSingularName() {
		return singularName;
	}

	public void setSingularName(String singularName) {
		this.singularName = singularName;
	}
	
	public String getSingularNameJavaDeclaredName() {
		if(this.singularName != null){
			return FormatString.getCadenaHungara(this.singularName);
		}
		return null;
	}
	
	public String getSingularNameJavaDeclaredObjectName() {
		if(this.singularName != null){
			return FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(this.singularName));
		}
		return null;
	}

	public String getSingularNameGetter() {
		if(this.singularName != null){
			return "get"+FormatString.getCadenaHungara(this.singularName);
		}
		return null;
	}
	
	public String getSingularNameSetter() {
		if(this.singularName != null){
			return "set"+FormatString.getCadenaHungara(this.singularName);
		}
		return null;
	}
	
	public String getNameGetter() {
		if(this.name != null){
			return "get"+FormatString.getCadenaHungara(this.name);
		}
		return null;
	}
	
	public String getNameSetter() {
		if(this.name != null){
			return "set"+FormatString.getCadenaHungara(this.name);
		}
		return null;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean hasEmbeddedPK() {

		Collection<Column> pks = getPrimaryKeys();
		if (!(this instanceof EmbeddeableColumn) && pks.size() == 1) {
			return false;
		} else {
			Iterator<Column> sortedColumnsForJPAIterator = getSortedColumnsForJPA();
			while (sortedColumnsForJPAIterator.hasNext()) {
				Column c = sortedColumnsForJPAIterator.next();
				if (c instanceof EmbeddeableColumn) {
					return true;
				}
			}
			if (!(this instanceof EmbeddeableColumn) && pks.size() > 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	public String getJPAPK() {

		Collection<Column> pks = getPrimaryKeys();

		if (pks.size() == 1) {
			Column pk = pks.iterator().next();
			return pk.getName();
		} else if (pks.size() > 1) {
			Iterator<Column> sortedColumnsForJPAIterator = getSortedColumnsForJPA();
			while (sortedColumnsForJPAIterator.hasNext()) {
				Column c = sortedColumnsForJPAIterator.next();
				if (c instanceof EmbeddeableColumn) {
					return c.getName();
				}
			}
			throw new IllegalStateException("This is not elegible for JPA Entity: Table:" + toString());
		} else {
			throw new IllegalStateException("This is not elegible for JPA Entity");
		}
	}

	public String getJPAPKClass() {
		Collection<Column> pks = getPrimaryKeys();

		if (pks.size() == 1) {
			Column pk = pks.iterator().next();
			return pk.getJavaClassType();
		} else if (pks.size() > 1) {
			Iterator<Column> sortedColumnsForJPAIterator = getSortedColumnsForJPA();
			while (sortedColumnsForJPAIterator.hasNext()) {
				Column c = sortedColumnsForJPAIterator.next();
				if (c instanceof EmbeddeableColumn) {
					return c.getJavaClassType();
				}
			}
			return null;
			//throw new IllegalStateException("This is not elegible for JPA Entity: Table:"+toString());
		} else {
			throw new IllegalStateException("This is not elegible for JPA Entity");
		}
	}

	public String getHashCodeSumCode() {
		StringBuffer sbHashCodeSum = new StringBuffer();
		int numColumns = 0;
		
		sbHashCodeSum.append("(");

		Iterator<Column> simpleColumnsIterator = getSortedColumnsForJPA();

		while (simpleColumnsIterator.hasNext()) {
			Column c = simpleColumnsIterator.next();
			if (!c.isPrimaryKey()) {
				continue;
			}
			if (numColumns > 0) {
				sbHashCodeSum.append(" + \n\t\t\t");
			}
			String jpaPKClass = c.getJavaClassType();
			if (!(this instanceof EmbeddeableColumn) && jpaPKClass.equals("double") || jpaPKClass.equals("int") || jpaPKClass.equals("float") || jpaPKClass.equals("char") || jpaPKClass.equals("byte")) {
				sbHashCodeSum.append(" ( String.valueOf(");
				sbHashCodeSum.append(FormatString.renameForJavaMethod(c.getName()));
				sbHashCodeSum.append(").hashCode() )");
			} else {
				sbHashCodeSum.append(" (");
				sbHashCodeSum.append(FormatString.renameForJavaMethod(c.getName()));
				sbHashCodeSum.append(" != null ? ");
				sbHashCodeSum.append(FormatString.renameForJavaMethod(c.getName()));
				sbHashCodeSum.append(".hashCode() : 0 )");
			}

			numColumns++;
		}
		sbHashCodeSum.append(" )");

		return sbHashCodeSum.toString();
	}

	public String getEqualsCode() {
		StringBuffer sbEqualsCode = new StringBuffer();

		//sbEqualsCode.append(FormatString.getCadenaHungara(getName()) + " other = (");
		//sbEqualsCode.append(FormatString.getCadenaHungara(getName()) + " ) o;");
		//sbEqualsCode.append("\n");
		String jpaPKClass = null;

		Iterator<Column> simpleColumnsIterator = getSortedColumnsForJPA();
		int numColumns = 0;

		sbEqualsCode.append("        if ( ");

		while (simpleColumnsIterator.hasNext()) {
			Column c = simpleColumnsIterator.next();
			if (!c.isPrimaryKey()) {
				continue;
			}
			if (numColumns > 0) {
				sbEqualsCode.append(" || \n             ");
			}
			jpaPKClass = c.getJavaClassType();
			if (!(this instanceof EmbeddeableColumn) && jpaPKClass.equals("double") || jpaPKClass.equals("int") || jpaPKClass.equals("float") || jpaPKClass.equals("char") || jpaPKClass.equals("byte")) {
				sbEqualsCode.append(" ( this.");
				sbEqualsCode.append(c.getJavaDeclaredObjectName());
				sbEqualsCode.append(" != other.");
				sbEqualsCode.append(c.getJavaDeclaredObjectName());
				sbEqualsCode.append(" ) ");
			} else {
				sbEqualsCode.append("(this.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(" == null && other.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(" != null) || (this." + FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(" != null && !this.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(".equals(other.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append("))");
			}

			numColumns++;
		}
		sbEqualsCode.append(") {\n");
		sbEqualsCode.append("            return false;\n");
		sbEqualsCode.append("        }\n");


		return sbEqualsCode.toString();
	}

	public String getSimpleHashCodeSumCode() {
		StringBuffer sbHashCodeSum = new StringBuffer();
		int numColumns = 0;
		sbHashCodeSum.append("(");

		Iterator<Column> simpleColumnsIterator = getPrimaryKeys().iterator();

		while (simpleColumnsIterator.hasNext()) {
			Column c = simpleColumnsIterator.next();
			if (!c.isPrimaryKey()) {
				continue;
			}
			if (numColumns > 0) {
				sbHashCodeSum.append(" + \n\t\t\t");
			}
			String jpaPKClass = c.getJavaClassType();
			if ( jpaPKClass.equals("double") || jpaPKClass.equals("int") || jpaPKClass.equals("float") || jpaPKClass.equals("char") || jpaPKClass.equals("byte")) {
				sbHashCodeSum.append(" ( String.valueOf(");
				sbHashCodeSum.append(FormatString.renameForJavaMethod(c.getName()));
				sbHashCodeSum.append(").hashCode() )");
			} else {
				sbHashCodeSum.append(" (");
				sbHashCodeSum.append(FormatString.renameForJavaMethod(c.getName()));
				sbHashCodeSum.append(" != null ? ");
				sbHashCodeSum.append(FormatString.renameForJavaMethod(c.getName()));
				sbHashCodeSum.append(".hashCode() : 0 )");
			}

			numColumns++;
		}
		sbHashCodeSum.append(" )");

		return sbHashCodeSum.toString();
	}

	public String getSimpleEqualsCode() {
		StringBuffer sbEqualsCode = new StringBuffer();

		sbEqualsCode.append(FormatString.getCadenaHungara(getName()) + " other = (");
		sbEqualsCode.append(FormatString.getCadenaHungara(getName()) + " ) o;");
		sbEqualsCode.append("\n");
		String jpaPKClass = "";

		Iterator<Column> simpleColumnsIterator = getPrimaryKeys().iterator();
		int numColumns = 0;

		sbEqualsCode.append("        if ( ");

		while (simpleColumnsIterator.hasNext()) {
			Column c = simpleColumnsIterator.next();
			if (!c.isPrimaryKey()) {
				continue;
			}
			if (numColumns > 0) {
				sbEqualsCode.append(" || \n             ");
			}
			jpaPKClass = c.getJavaClassType();
			if (jpaPKClass.equals("double") || jpaPKClass.equals("int") || jpaPKClass.equals("float") || jpaPKClass.equals("char") || jpaPKClass.equals("byte")) {
				sbEqualsCode.append(" ( this.");
				sbEqualsCode.append(c.getJavaDeclaredObjectName());
				sbEqualsCode.append(" != other.");
				sbEqualsCode.append(c.getJavaDeclaredObjectName());
				sbEqualsCode.append(" ) ");
			} else {
				sbEqualsCode.append("(this.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(" == null && other.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(" != null) || (this." + FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(" != null && !this.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append(".equals(other.");
				sbEqualsCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbEqualsCode.append("))");
			}

			numColumns++;
		}
		sbEqualsCode.append(") {\n");
		sbEqualsCode.append("            return false;\n");
		sbEqualsCode.append("        }\n");

		return sbEqualsCode.toString();
	}

	private String getFirstToStringConcatenable() {
		String ts = null;
		Iterator<Column> simpleColumnsIterator = getSortedColumnsForJPA();
		int numColumns = 0;

		while (simpleColumnsIterator.hasNext()) {
			Column c = simpleColumnsIterator.next();
			if (c.isToStringConcatenable()) {
				ts = c.getName();
			}
		}
		return ts;
	}

	public String getToStringCode(DBTableSet dbSet, String packageName) {
		StringBuffer sbToStringCode = new StringBuffer();

		sbToStringCode.append("\"");
		sbToStringCode.append(packageName);
		sbToStringCode.append(".");
		sbToStringCode.append(FormatString.getCadenaHungara(getName()));
		sbToStringCode.append("[");

		String tsDefault = dbSet.getTableToStringConcatenable(this);
		if (tsDefault != null && tsDefault.length() > 1) {
			return tsDefault;
		} else if (countPrimaryKeys() == 1 || hasEmbeddedPK() || isManyToManyTableWinthMoreColumns()) {
			//System.err.println("\t=>getToStringCode:" + this.getName() + " for PK: " + getJPAPK() + "(" + (countPrimaryKeys() == 1) + "||" + hasEmbeddedPK() + "||" + isManyToManyTableWinthMoreColumns() + ")");
			int numFKembeddes = 0;
			Collection<Column> primaryKeys = getPrimaryKeys();

			for (Column column : primaryKeys) {
				if (numFKembeddes > 0) {
					//sbToStringCode.append(" + ");
					sbToStringCode.append(" + \", ");
				}
				if (column.isForeignKey()) {
					ReferenceTable fkReferenceTable = getFKReferenceTable(column.getName());
					if (fkReferenceTable != null) {
						//sbToStringCode.append("\"+");
						sbToStringCode.append(FormatString.renameForJavaMethod(fkReferenceTable.getTableName()));
						sbToStringCode.append(" = \"+");
						sbToStringCode.append(FormatString.renameForJavaMethod(fkReferenceTable.getTableName()));
					}
				} else {
					//sbToStringCode.append("\"+");
					sbToStringCode.append(column.getJavaDeclaredObjectName());
					sbToStringCode.append(" = \"+");
					sbToStringCode.append(column.getJavaDeclaredObjectName());
				}

				numFKembeddes++;
			}

//            sbToStringCode.append(FormatString.renameForJavaMethod(getName()));
//            sbToStringCode.append(" = \"+");
//            sbToStringCode.append(FormatString.renameForJavaMethod(getJPAPK()));
			sbToStringCode.append("+ \"]\"");
		} else {
			Iterator<Column> simpleColumnsIterator = getSortedColumnsForJPA();
			int numColumns = 0;

			while (simpleColumnsIterator.hasNext()) {
				Column c = simpleColumnsIterator.next();
				if (!c.isPrimaryKey()) {
					continue;
				}
				if (numColumns > 0) {
					sbToStringCode.append("+\" , ");
				}

				sbToStringCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbToStringCode.append(" = \"+");
				sbToStringCode.append(FormatString.renameForJavaMethod(c.getName()));
				numColumns++;
			}
			sbToStringCode.append("+ \"]\"");
		}

		return sbToStringCode.toString();
	}

	public String getToDTOStringCode(DBTableSet dbSet, String packageName) {
		StringBuffer sbToStringCode = new StringBuffer();

		sbToStringCode.append("\"");
		sbToStringCode.append(packageName);
		sbToStringCode.append(".");
		sbToStringCode.append(FormatString.getCadenaHungara(getName()));
		sbToStringCode.append("[");

		String tsDefault = dbSet.getTableToStringDTOConcatenable(this);
		if (tsDefault != null && tsDefault.length() > 1) {
			return tsDefault;
		} else if (countPrimaryKeys() == 1 || hasEmbeddedPK() || isManyToManyTableWinthMoreColumns()) {
			int numFKembeddes = 0;
			Collection<Column> primaryKeys = getPrimaryKeys();

			for (Column column : primaryKeys) {
				if (numFKembeddes > 0) {
					//sbToStringCode.append(" + ");
					sbToStringCode.append(" + \", ");
				}
				sbToStringCode.append(column.getJavaDeclaredObjectName());
				sbToStringCode.append(" = \"+");
				sbToStringCode.append(column.getJavaDeclaredObjectName());

				numFKembeddes++;
			}

			sbToStringCode.append("+ \"]\"");
		} else {
			Iterator<Column> simpleColumnsIterator = getSortedColumnsForJPA();
			int numColumns = 0;

			while (simpleColumnsIterator.hasNext()) {
				Column c = simpleColumnsIterator.next();
				if (!c.isPrimaryKey()) {
					continue;
				}
				if (numColumns > 0) {
					sbToStringCode.append("+\" , ");
				}

				sbToStringCode.append(FormatString.renameForJavaMethod(c.getName()));
				sbToStringCode.append(" = \"+");
				sbToStringCode.append(FormatString.renameForJavaMethod(c.getName()));
				numColumns++;
			}
			sbToStringCode.append("+ \"]\"");
		}

		return sbToStringCode.toString();
	}

	/**
	 * @return the schemma
	 */
	public String getSchemma() {
		return schemma;
	}

	/**
	 * @param schemma the schemma to set
	 */
	public void setSchemma(String schemma) {
		this.schemma = schemma;
	}

	/**
	 * @return the javaDeclaredName
	 */
	public String getJavaDeclaredName() {
		
		if (javaDeclaredName == null) {
			if(preferredSingularName && singularName!=null){
				javaDeclaredName = FormatString.getCadenaHungara(singularName);
			} else{
				javaDeclaredName = FormatString.getCadenaHungara(name);
			}
		}
		return javaDeclaredName;
	}

	/**
	 * @return the javaDeclaredMethod
	 */
	public String getJavaDeclaredObjectName() {
		return FormatString.firstLetterLowerCase(getJavaDeclaredName());
	}

	/**
	 * @param javaDeclaredName the javaDeclaredName to set
	 */
	public void setJavaDeclaredName(String javaDeclaredName) {
		this.javaDeclaredName = javaDeclaredName;
	}

	public void removeColumn(Column cpk) {
		if (columns.remove(cpk.getName()) == null) {
			throw new IllegalArgumentException("Column " + cpk.getName() + " not found for remove");
		}
	}

	/**
	 * @return the toStringPattern
	 */
	public String getToStringPattern() {
		return toStringPattern;
	}

	/**
	 * @param toStringPattern the toStringPattern to set
	 */
	public void setToStringPattern(String toStringPattern) {
		this.toStringPattern = toStringPattern;
	}

	public String getToStringCodeWithPattern(String packageName) {
		if (toStringPattern == null) {
			throw new IllegalStateException("toStringPattern is not set !");
		}

		String toStringPatternReplaced = toStringPattern;
		Set<String> keyColumnNamesSet = columns.keySet();
		for (String columnName : keyColumnNamesSet) {
			String varColumnName = "${" + columnName + "}";
			toStringPatternReplaced = toStringPatternReplaced.replace(varColumnName, "\"+" + getColumn(columnName).getJavaDeclaredName() + "+\"");
		}

		return toStringPatternReplaced;
	}

	/**
	 * @return the metaProperties
	 */
	public Hashtable<String, String> getMetaProperties() {
		if (metaProperties == null || (metaProperties != null && metaProperties.size() == 0)) {
			metaProperties = new Hashtable<String, String>();

			final Collection<Column> primaryKeys = this.getPrimaryKeys();
			int cc = 0;
			StringBuffer sb = new StringBuffer();
			for (Column c : primaryKeys) {
				if (cc > 0) {
					sb.append(", ");
				}
				sb.append(c.getName());
				cc++;
			}

			metaProperties.put("atributos_consulta", sb.toString());
			metaProperties.put("atributos_orderby", sb.toString());
			metaProperties.put("estilo_columnas", "");

			//@atributos_consulta="id_unidad, nombre"
			//@atributos_orderby="nombre"
			//@estilo_columnas="columnWidth20, columnWidth60 leftAlign, columnWidth10, columnWidth10"
		}
		return metaProperties;
	}

	/**
	 * @param metaProperties the metaProperties to set
	 */
	public void setMetaProperties(Hashtable<String, String> metaProperties) {
		this.metaProperties = metaProperties;
	}

	public Collection<Column> getColums() {
		return this.getColumns().values();
	}

	public int countReferencesToTable(String name) {
		Collection<ReferenceTable> fkReferenceTables = getFKReferenceTables();
		final Iterator<ReferenceTable> iteratorRFKs = fkReferenceTables.iterator();
		int ccrfk = 0;
		while (iteratorRFKs.hasNext()) {
			ReferenceTable rt = iteratorRFKs.next();
			if (rt.getTableName().equalsIgnoreCase(name)) {
				ccrfk++;
			}
		}
		return ccrfk;
	}

	public void setPlainColumns(List<Column> plainColumns) {
		this.plainColumns = plainColumns;
	}

	public List<Column> getPlainColumns() {
		return plainColumns;
	}

	public void setEmbededColumns(List<EmbeddeableColumn> embededColumns) {
		this.embededColumns = embededColumns;
	}

	public List<EmbeddeableColumn> getEmbededColumns() {
		return embededColumns;
	}
	/**
	 * @return the m2mTableList
	 */
	public List<Table> getM2mTableList() {
		if(m2mTableList == null){
			m2mTableList= new ArrayList<Table>();
		}
		return m2mTableList;
	}

	/**
	 * @param m2mTableList the m2mTableList to set
	 */
	public void setM2mTableList(List<Table> m2mTableList) {
		this.m2mTableList = m2mTableList;
	}

	/**
	 * @return the o2mTableList
	 */
	public List<Table> getO2mTableList() {
		if(o2mTableList == null){
			o2mTableList=new ArrayList<Table>();
		}
		return o2mTableList;
	}

	/**
	 * @param o2mTableList the o2mTableList to set
	 */
	public void setO2mTableList(List<Table> o2mTableList) {
		this.o2mTableList = o2mTableList;
	}

	public void setPreferredSingularName(boolean preferredSingularName) {
		this.preferredSingularName = preferredSingularName;
	}

	public boolean isPreferredSingularName() {
		return preferredSingularName;
	}
	
	public void setAuditable(boolean b) {
		this.auditable= b;
	}

	public boolean isAuditable() {
		return auditable;
	}
	
	public static void analizeTablesForOptomizeJPA(DBTableSet dbSet,ArrayList<Table> tablesForGeneration,List<Column> definitiveColumns){
	
		for (Table iterTable: tablesForGeneration) {
			System.err.println("-->> Analiznig Table: " + iterTable.getName());
			if(iterTable.getSingularName()!=null){				
				System.err.println("\tPreferred Java Name Table: " + iterTable.getSingularName());
			}
			List<Column>            plainColumns   = new ArrayList();
			List<EmbeddeableColumn> embededColumns = new ArrayList();
			
			iterTable.setPlainColumns(plainColumns);
			iterTable.setEmbededColumns(embededColumns);
			int countStringPrintable=0;
			if (! ( iterTable instanceof EmbeddeableColumn)) {
			
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();
				countStringPrintable = 0;
				while (itFKC.hasNext()) {
					Column column = itFKC.next();					
					if (column instanceof EmbeddeableColumn) {						
						embededColumns.add((EmbeddeableColumn)column);						
					} else {
						
						plainColumns.add(column);
						
						String suggestedHyperColumnName=null;
						String suggestedObjectName=null;
						String suggestedGettetObjectName=null;
						String suggestedSettetObjectName=null;
						Table fTable = null;
                        
                        if(column.isForeignDescription()){
                            countStringPrintable++;
                        }                        
                        
						if (column.isForeignKey() && !(iterTable instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(iterTable.getFKReferenceTable(column.getName()).getTableName());
							column.setFTable(fTable);
							System.err.println("\t\t-->>column:"+column.getName());
							final Collection<Column> ftPksCol = fTable.getPrimaryKeys();
							for(Column ftpk: ftPksCol){
								System.err.println("\t\t-->>fTable="+fTable.getName()+", ftpk="+ftpk.getName()+", column="+column.getName());
								if(column.getName().toUpperCase().equals(ftpk.getName().toUpperCase())){
									suggestedHyperColumnName = fTable.getName();
									System.err.println("\t\t\t1)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
									
									suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
									suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
									suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

									column.setHyperColumnName(suggestedHyperColumnName);
									break;
								} else if(column.getName().toUpperCase().contains(ftpk.getName().toUpperCase())){
									if(fTable.getSingularName()!=null){
										suggestedHyperColumnName = fTable.getSingularName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");
										//suggestedHyperColumnName = fTable.getSingularName();
										System.err.println("\t\t\t2)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
									} else if((fTable.getName()+"_"+ftpk.getName()).toUpperCase().equals(column.getName().toUpperCase())){
										suggestedHyperColumnName = column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");
										//suggestedHyperColumnName = fTable.getName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");										
										System.err.println("\t\t\t3A)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
									} else {
										//suggestedHyperColumnName = c.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");
										suggestedHyperColumnName = fTable.getName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");										
										System.err.println("\t\t\t3B)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
									}
									suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
									suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
									suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

									column.setHyperColumnName(suggestedHyperColumnName);
									break;
								}
							}
							if(suggestedHyperColumnName == null){
								suggestedHyperColumnName = fTable.getName();
								System.err.println("\t\t\t4)-->>suggestedHyperColumnName="+suggestedHyperColumnName);

								suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
								suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
								suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

								column.setHyperColumnName(suggestedHyperColumnName);
								break;
							}
							
						} else {
							fTable = null;
						}
						definitiveColumns.add(column);
						System.err.println("\t-->> DefinitiveColumn: " + column.getName()+"\tHyperColumnName:"+column.getHyperColumnName());						
					}
				}
				
                if(countStringPrintable==0){
                    Iterator<Column> itFKC2 = iterTable.getSortedColumnsForJPA();
                    int countTSx=0;
                    while(itFKC2.hasNext()){
                        Column cx2=itFKC2.next();
                        if(cx2.isPrimaryKey()){
                            cx2.setForeignDescription(true);
                            countTSx++;
                        }
                    }
                    if(countTSx==0){
                        throw new IllegalStateException("Table '"+iterTable.getName()+"', Needs PK's !");
                    }
                }
                
				Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(iterTable);

				for (Table m2mTable : m2mTables) {
					//System.err.println("\t\t\t* -- [M2M] "+m2mTable.getName()+" {"+(m2mOT!=null?m2mOT.getName():"-------")+"}");
					iterTable.getM2mTableList().add(m2mTable);
				}
				
				Collection<Table> o2mTables = dbSet.getOneToManyRelationTables(iterTable);
				for (Table o2mTable : o2mTables) {
					//System.err.println("\t\t\t* -- [O2M] "+o2mTable.getName());
					iterTable.getO2mTableList().add(o2mTable);
				}
				
			} else {				
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();				
				while (itFKC.hasNext()) {
					Column c = itFKC.next();
					plainColumns.add(c);
				}
			}
			
			
			for(Column dc:plainColumns){
				if(dc.isForeignKey()){
					//System.err.println("\t\t\tN " +(dc.isPrimaryKey()?"PK":"--")+" [M20] "+dc.getName());
				} else{
					//System.err.println("\t\t\tN " +(dc.isPrimaryKey()?"PK":"--")+" [---] "+dc.getName());
				}				
			}
			for(EmbeddeableColumn ec:embededColumns){
				//System.err.println("\t\t\tE " +(ec.isPrimaryKey()?"PK":"--")    +" [EMD] "+ec.getName());
			}
			
			for(Table m2mTable:iterTable.getM2mTableList()){
				Table m2mOT = dbSet.getTableOwnerManyToManyRelation(iterTable, m2mTable);
				//System.err.println("\t\t\t* -- [M2M] "+m2mTable.getName()+" {"+(m2mOT!=null?m2mOT.getName():"-------")+"}");
			}
			for(Table o2mTable:iterTable.getO2mTableList()){
				//System.err.println("\t\t\t* -- [O2M] "+o2mTable.getName());
			}
		}	
	}

	public boolean isDTOJsonProperty_CAMEL() {
		return DTOJsonProperty_CAMEL;
	}

	public void setDTOJsonProperty_CAMEL(boolean DTOJsonProperty_CAMEL) {
		this.DTOJsonProperty_CAMEL = DTOJsonProperty_CAMEL;
	}

	public boolean isDTOJsonProperty_SNAKE() {
		return DTOJsonProperty_SNAKE;
	}

	public void setDTOJsonProperty_SNAKE(boolean DTOJsonProperty_SNAKE) {
		this.DTOJsonProperty_SNAKE = DTOJsonProperty_SNAKE;
	}
	
}
