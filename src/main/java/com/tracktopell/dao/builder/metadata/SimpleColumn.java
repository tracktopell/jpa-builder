/**
 * Column.java
 *
 */
package com.tracktopell.dao.builder.metadata;

import com.tracktopell.dao.builder.FormatString;
import java.util.Hashtable;

/**
 *
 * @author alfred
 */
public class SimpleColumn implements Column {

	private String name;
	private Table  fTable;
	private String hyperColumnName;
	protected String javaDeclaredName;
	private String sqlType;
	private String javaClassType;
	private String label;
	private boolean autoIncremment;
	private boolean primaryKey;
	private boolean uniqe;
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

	public SimpleColumn() {
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
        if (foreignDescription ) {
			sb.append(" <-FK_Desk ");			
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
		label = name.replace("_"," ").toLowerCase().trim();		
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
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equals("Integer")){
			return "getInt";
		} else if(jc.equals("Double")){
			return "getDouble";
		} else if(jc.equals("Float")){
			return "getDouble";
		} else if(jc.equals("Long")){
			return "getInt";
		} else if(jc.equals("long")){
			return "getInt";
		} else if(jc.equals("Short")){
			return "getInt";
		} else if(jc.equals("short")){
			return "getInt";
		} else if(jc.equals("Byte")){
			return "getByte";
		} else if(jc.equals("Integer")){
			return "getInt";
		} else if(jc.equals("int")){
			return "getInt";
		} else if(jc.equals("String")){
			return "getString";
		} else if(jc.equals("Time")){
			return "getLong";
		} else  if(jc.equals("Date")){
			return "getLong";
		} else if(jc.equals("Timestamp")){
			return "getLong";
		}
		return "get"+jc;
	}

	@Override
	public String getJsonObjValueGetter() {
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equals("Integer")){
			return "getJsonNumber";
		} else if(jc.equals("Double")){
			return "getJsonNumber";
		} else if(jc.equals("Float")){
			return "getJsonNumber";
		} else if(jc.equals("Long")){
			return "getJsonNumber";
		} else if(jc.equals("long")){
			return "getJsonNumber";
		} else if(jc.equals("Short")){
			return "getJsonNumber";
		} else if(jc.equals("short")){
			return "getJsonNumber";
		} else if(jc.equals("Byte")){
			return "getByte";
		} else if(jc.equals("Integer")){
			return "getJsonNumber";
		} else if(jc.equals("int")){
			return "getJsonNumber";
		} else if(jc.equals("String")){
			return "getString";
		} else if(jc.equals("Time")){
			return "getInt";
		} else  if(jc.equals("Date")){
			return "getInt";
		} else if(jc.equals("Timestamp")){
			return "getInt";
		}
		return "get"+jc;
	}
	
	@Override
	public String getJsonObjGetValue() {
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equals("Double")){
			return ".doubleValue()";
		} else if(jc.equals("double")){
			return ".doubleValue()";
		} else if(jc.equals("Float")){
			return ".floatValue()";
		} else if(jc.equals("Long")){
			return ".longValue()";
		} else if(jc.equals("long")){
			return ".longValue()";
		} else if(jc.equals("Short")){
			return ".intValue()";
		} else if(jc.equals("short")){
			return ".intValue()";
		} else if(jc.equals("Byte")){
			return ".intValue()";
		} else if(jc.equals("Integer")){
			return ".intValue()";
		} else if(jc.equals("int")){
			return ".intValue()";
		} else if(jc.equals("String")){
			return "";
		} else if(jc.equals("Time")){
			return "";
		} else  if(jc.equals("Date")){
			return "";
		} else if(jc.equals("Timestamp")){
			return "";
		}
		return "get"+jc;
	}
	
	@Override
	public String getValueCast() {
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equalsIgnoreCase("Float")){
			return "(float)";
		} else if(jc.equalsIgnoreCase("Short")){
			return "(short)";
		} else if(jc.equalsIgnoreCase("Integer")){
			return "(int)";
		} else if(jc.equals("Int")){
			return "(int)";
		} else if(jc.equalsIgnoreCase("String")){
			return "";
		} else if(jc.equals("Date")){
			return "new java.sql.Date";
		} else if(jc.equals("Time")){
			return "new java.sql.Time";
		} else if(jc.equals("DateTime")){
			return "new java.sql.Date";
		} else if(jc.equals("Timestamp")){
			return "new java.sql.Timestamp";
		} else {
		}
		return "";
	}

	@Override
	public String getNativeGetter() {
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equalsIgnoreCase("Float")){
			return "getFloat()";
		} else if(jc.equalsIgnoreCase("Short")){
			return "getShort()";
		} else if(jc.equalsIgnoreCase("Integer")){
			return "getInt()";
		} else if(jc.equals("Date")){
			return "getDate().getTime()";
		} else if(jc.equals("Time")){
			return "getTime().getTime()";
		} else if(jc.equals("DateTime")){
			return "getDateTime().getTime()";
		} else if(jc.equals("Timestamp")){
			return "getTimestamp().getTime()";
		} else {
		}
		return "";
	}
	
	@Override
	public String getGetterNative() {
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equalsIgnoreCase("Float")){
			return "";
		} else if(jc.equalsIgnoreCase("Short")){
			return "";
		} else if(jc.equalsIgnoreCase("Integer")){
			return "";
		} else if(jc.equals("Date")){
			return ".getTime()";
		} else if(jc.equals("Time")){
			return ".getTime()";
		} else if(jc.equals("DateTime")){
			return ".getTime()";
		} else if(jc.equals("Timestamp")){
			return ".getTime()";
		} else {
		}
		return "";
	}
	
	@Override
	public String getNativeSetter() {
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equalsIgnoreCase("Float")){
			return "setFloat(";
		} else if(jc.equalsIgnoreCase("Short")){
			return "setShort(";
		} else if(jc.equalsIgnoreCase("Integer")){
			return "setInt(";
		} else if(jc.equals("Date")){
			return "setDate(new Date(";
		} else if(jc.equals("Time")){
			return "setTime(new Time(";
		} else if(jc.equals("DateTime")){
			return "setDate(new DateTime(";
		} else if(jc.equals("Timestamp")){
			return "setTimestamp(new Timestamp(";
		} else {
		}
		return "";
	}	

	@Override
	public String getSetterNative() {
		String jc = this.javaClassType.replace("java.lang.", "").replace("java.sql.", "");
		if(jc.equals("Float")){
			return "new Float(";
		} else if(jc.equals("float")){
			return "(";
		} else if(jc.equals("Double")){
			return "new Double(";
		} else if(jc.equals("double")){
			return "(";
		} else if(jc.equals("Long")){
			return "new Long(";
		} else if(jc.equals("long")){
			return "(";
		} else if(jc.equalsIgnoreCase("Short")){
			return "new Short((short)";
		} else if(jc.equalsIgnoreCase("short")){
			return "(";
		} else if(jc.equalsIgnoreCase("Integer")){
			return "new Integer(";
		} else if(jc.equalsIgnoreCase("int")){
			return "(";
		} else if(jc.equals("Date")){
			return "new Date(";
		} else if(jc.equals("Time")){
			return "new Time(";
		} else if(jc.equals("DateTime")){
			return "new DateTime(";
		} else if(jc.equals("Timestamp")){
			return "new Timestamp(";
		} else if(jc.equals("String")){
			return "(";
		} 
		return "(";
	}	

	@Override
	public boolean isUnique() {
		return uniqe;
	}

	@Override
	public void setUnique(boolean uniqe) {
		this.uniqe = uniqe;
	}
}
