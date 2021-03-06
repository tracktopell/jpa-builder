/*
 * Table.java
 */

package com.tracktopell.dao.builder.metadata;

import com.tracktopell.dao.builder.FormatString;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class EmbeddeableColumn extends Table implements Column{
	private Table  fTable;
	private String hyperColumnName;	
    private String sqlType;
    private String javaClassType;
    private boolean autoIncremment;
    private boolean primaryKey;
    private boolean foreignKey;
    private boolean nullable;
    private boolean foreignDescription;
    private boolean toStringConcatenable;
    private int precision;
    private int scale;
    private int position;
    private int typeFormatingNumber;
    private String comments;
    private String farFKDescription;


    /** Creates a new instance of Table */
    public EmbeddeableColumn() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    @Override
	public void setSqlDDL(String sqlDDL){
		throw new IllegalStateException("Can't has sqlDDL");
	}

	@Override
	public String getSqlDDL(){
		return null;
	}

	@Override
	public void setSqlUnsigned(boolean sqlUnsigned) {
		throw new IllegalStateException("Can't be sqlUnsigned");
	}

	@Override
	public boolean isSqlUnsigned() {
		return false;
	}
	
	@Override
	public void setIndex(boolean index) {
		throw new IllegalStateException("Can't be index");
	}

	@Override
	public boolean isIndex() {
		return false;
	}

    public String getJavaClassType() {
        return javaClassType;
    }

    public void setJavaClassType(String javaClassType) {
        this.javaClassType = javaClassType;
    }

    public boolean isAutoIncremment() {
        return autoIncremment;
    }

    public void setAutoIncremment(boolean autoIncremment) {
        this.autoIncremment = autoIncremment;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public boolean isForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(boolean foreignKey) {
        this.foreignKey = foreignKey;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTypeFormatingNumber() {
        return typeFormatingNumber;
    }

    public void setTypeFormatingNumber(int typeFormatingNumber) {
        this.typeFormatingNumber = typeFormatingNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isForeignDescription() {
        return foreignDescription;
    }

    public void setForeignDescription(boolean foreignDescription) {
        this.foreignDescription = foreignDescription;
    }

    public void buildPosibleLabel() {
        String[] nameParts = name.split("_");
        StringBuffer sb = new StringBuffer();
        for(String sn : nameParts) {
            sb.append(sn.substring(0, 1).toUpperCase());
            sb.append(sn.substring(1).toLowerCase());
            sb.append(" ");
        }
        label = sb.toString().trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFarFKDescription() {
        return farFKDescription;
    }

    public void setFarFKDescription(String farFKDescription) {
        this.farFKDescription = farFKDescription;
    }

	@Override
	public String getHyperColumnName() {
		return hyperColumnName;
	}

	public String getHyperColumnObjectName() {
		if(hyperColumnName!= null){
			return FormatString.getCadenaHungara(hyperColumnName);
		}
		return null;
	}

	public String getHyperColumnGetterName() {
		if(hyperColumnName!= null){
			return "get"+FormatString.getCadenaHungara(hyperColumnName);
		}
		return null;
	}
	
	public String getHyperColumnSetterName() {
		if(hyperColumnName!= null){
			return "set"+FormatString.getCadenaHungara(hyperColumnName);
		}
		return null;
	}	

	@Override
	public void setHyperColumnName(String hc) {
		this.hyperColumnName = hc;
	}
	
    //--------------------------------------------------------------------------

    public Iterator<Column> getSortedColumnsForJPA() {
        return getSortedColumns();
    }

    public void fixBestJavaClassForSQLType() {
        throw new IllegalStateException("This methos it's not to retrieve the JAva Class here, because is not Primitive Column");
    }

	@Override
	public boolean isIntegerJavaType() {
		return	javaClassType.equals("int") || javaClassType.equals("java.lang.Integer") ||
				javaClassType.equals("long") || javaClassType.equals("java.lang.Long");
	}

    /**
     * @return the toStringConcatenable
     */
    public boolean isToStringConcatenable() {
        return toStringConcatenable;
    }

    /**
     * @param toStringConcatenable the toStringConcatenable to set
     */
    public void setToStringConcatenable(boolean toStringConcatenable) {
        this.toStringConcatenable = toStringConcatenable;
    }
	
	
	@Override
	public void setFTable(Table ft) {
		this.fTable = ft;
	}

	@Override
	public Table getFTable() {
		return this.fTable;
	}

	@Override
	public String getValueGetter() {
		return null;
	}

	@Override
	public String getValueCast() {
		return null;
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	@Override
	public void setUnique(boolean uniqe) {
		throw new UnsupportedOperationException("Not supported for EmbeddeableColumn");
	}

	@Override
	public String getNativeGetter() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getNativeSetter() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getGetterNative() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getSetterNative() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getJsonObjValueGetter() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getJsonObjGetValue() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getNullableExpression(String n) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setJsonIgnored(boolean jsonIgnored) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isJsonIgnored() {
		return false;
	}
}
