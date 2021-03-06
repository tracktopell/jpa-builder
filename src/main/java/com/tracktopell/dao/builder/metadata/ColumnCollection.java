package com.tracktopell.dao.builder.metadata;

import com.tracktopell.dao.builder.FormatString;
import java.util.Hashtable;

/**
 *
 * @author alfredo.estrada
 */
public class ColumnCollection implements Column {

	private String name;
	private Table  fTable;
	private String hyperColumnName;
	protected String javaDeclaredName;
	private String sqlType;
	private String javaClassType;
	private String label;
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
	private Hashtable<String, String> metaProperties;

	public ColumnCollection() {
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

	public String toString() {

		StringBuffer sb = new StringBuffer();
		if (isPrimaryKey()) {
			sb.append(this.autoIncremment ? "++[" : "[");
			sb.append(this.name);
			sb.append("]");
		} else {
			sb.append(this.name);
		}
		sb.append(" ");
		sb.append(this.sqlType);
		sb.append("(");
		sb.append(scale);
		sb.append(",");
		sb.append(precision);
		sb.append(")");
		if (farFKDescription != null) {
			sb.append("#");
			sb.append(farFKDescription);
			sb.append("#");
		}
		return sb.toString();
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
		for (String sn : nameParts) {
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

	public void fixBestJavaClassForSQLType() {
		if (!isNullable() && !isPrimaryKey()) {

			if (getSqlType().toLowerCase().equals("decimall")
					&& getPrecision() == 0) {
				setJavaClassType("long");
			} else {
				String bestJavaClass = SQLTypesToJavaTypes.getTypeFor(getSqlType().toLowerCase() + "_not_null");
				if (bestJavaClass != null) {
					setJavaClassType(bestJavaClass);
				}
			}
		}
	}

	/**
	 * @return the javaDeclaredName
	 */
	public String getJavaDeclaredName() {
		if (javaDeclaredName == null) {
			javaDeclaredName = FormatString.getCadenaHungara(name);
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

	@Override
	public boolean isIntegerJavaType() {
		return javaClassType.equals("int") || javaClassType.equals("java.lang.Integer")
				|| javaClassType.equals("long") || javaClassType.equals("java.lang.Long");
	}

	/**
	 * @return the toStringConcatenable
	 */
	public boolean isToStringConcatenable() {
		return toStringConcatenable;
	}

	@Override
	public String getHyperColumnName() {
		return hyperColumnName;
	}
	
	public String getHyperColumnObjectName() {
		if(hyperColumnName!= null){
			return FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(hyperColumnName));
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
	

	/**
	 * @param toStringConcatenable the toStringConcatenable to set
	 */
	public void setToStringConcatenable(boolean toStringConcatenable) {
		this.toStringConcatenable = toStringConcatenable;
	}

	/**
	 * @return the metaProperties
	 */
	public Hashtable<String, String> getMetaProperties() {
		if (metaProperties == null) {
			metaProperties = new Hashtable<String, String>();

			//COLUMN_ATTRIBUTES
			//-----------------
			metaProperties.put("tipo_campo", isPrimaryKey()?"1":isForeignKey()?"2":"3");
			metaProperties.put("componente", "1|2|3|4|5");
			metaProperties.put("descripcion", getLabel()!=null?getLabel():getName());
			metaProperties.put("tipo_dato", "1|2|3|4|5");

			//COLUMN_ATTRIBUTES_DECORATOR
			//---------------------------
			metaProperties.put("cols", "");
			metaProperties.put("disabled", "false");
			metaProperties.put("maxlength", String.valueOf(this.getScale()));
			metaProperties.put("required", this.isNullable()?"false":"true");
			metaProperties.put("rows", "");
			metaProperties.put("label", getLabel()!=null?getLabel():getName());
			metaProperties.put("size", String.valueOf(getScale()));
			metaProperties.put("rendered", "true");
			metaProperties.put("onblur", "");
			metaProperties.put("onkeyup", "");
			metaProperties.put("style", "");
			metaProperties.put("styleClass", "");
			metaProperties.put("selectItems", "");
		}
		return metaProperties;
	}

	/**
	 * @param metaProperties the metaProperties to set
	 */
	public void setMetaProperties(Hashtable<String, String> metaProperties) {
		this.metaProperties = metaProperties;
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
		throw new UnsupportedOperationException("Not supported for EmbeddeableColumn");
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
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
