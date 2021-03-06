/**
 * Column.java
 *
 */

package com.tracktopell.dao.builder.metadata;

import java.util.Hashtable;

/**
 *
 * @author Usuario
 */
public interface Column {
    int NOT_NUMBERFORMAT        = -1;
    int NUMBER_NUMBERFORMAT     = 1;
    int CURRENCY_NUMBERFORMAT   = 2;
    int PERCENT_NUMBERFORMAT    = 3;
    
    String getName();

    void setName(String name);

    String getSqlType();

    void setSqlType(String sqlType);

	void setSqlUnsigned(boolean sqlUnsigned);
	
	boolean isSqlUnsigned();
	
    String getJavaClassType();
	
	String getValueGetter();

    void setJavaClassType(String javaClassType) ;

    boolean isAutoIncremment() ;

    void setAutoIncremment(boolean autoIncremment) ;

    boolean isPrimaryKey() ;

    void setPrimaryKey(boolean primaryKey) ;

	boolean isUnique() ;

    void setUnique(boolean uniqe) ;

	boolean isIndex() ;

    void setIndex(boolean index) ;
    
	String getSqlDDL();

    void setSqlDDL(String sqlDDL);

    boolean isNullable() ;

    void setNullable(boolean nullable) ;

    int getPrecision() ;

    void setPrecision(int precision) ;

    int getScale() ;

    void setScale(int scale) ;

    boolean isForeignKey() ;

    void setForeignKey(boolean foreignKey) ;

    int getPosition() ;

    void setPosition(int position) ;

    int getTypeFormatingNumber() ;

    void setTypeFormatingNumber(int typeFormatingNumber) ;

    String getLabel() ;

    void setLabel(String label) ;

    boolean isForeignDescription() ;

    void setForeignDescription(boolean foreignDescription) ;
    
    void buildPosibleLabel() ;

    String getComments() ;

    void setComments(String comments) ;

    String getFarFKDescription() ;

    void setFarFKDescription(String farFKDescription) ;

    void fixBestJavaClassForSQLType();
    
    String getJavaDeclaredName();

    String getJavaDeclaredObjectName(); 
    
    void setJavaDeclaredName(String javaDeclaredName);

    boolean isIntegerJavaType();

    void setToStringConcatenable(boolean b);
    
    boolean isToStringConcatenable();

	void setMetaProperties(Hashtable<String, String> properties);
	
	void setHyperColumnName(String hc);
	
	String getHyperColumnName();
	
	String getHyperColumnObjectName();
	
	String getHyperColumnSetterName();
	
	String getHyperColumnGetterName();
	
	void setFTable(Table ft);
	
	Table getFTable();
	
	Hashtable<String, String>  getMetaProperties();

	String getValueCast();
	
	String getNativeGetter();
	
	String getGetterNative();
	
	String getNativeSetter();
	
	String getSetterNative();
	
	String getJsonObjValueGetter();
	
	String getJsonObjGetValue();
	
	String getNullableExpression(String n);

	void setJsonIgnored(boolean jsonIgnored);
	
	boolean isJsonIgnored();
}
