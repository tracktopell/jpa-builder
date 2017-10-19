package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table PRODUCTO_SUCURSAL.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class ProductoSucursalDTO implements java.io.Serializable {
    private static final long serialVersionUID = 951007336;

    
    /**
    * producto sucursal p k
    */
    // productoSucursalPK EmbedableColumn ID References: FKs {[[SUCURSAL_ID] integer(10,0), [PRODUCTO_CODIGO_BARRAS] varchar(128,0)]}
    
    /**
    * cantidad 1ra
    */
    private int cantidad1ra;
    
    /**
    * precio 1ra
    */
    private double precio1ra;
    
    /**
    * cantidad opo
    */
    private int cantidadOpo;
    
    /**
    * precio opo
    */
    private double precioOpo;
    
    /**
    * cantidad reg
    */
    private int cantidadReg;
    
    /**
    * precio reg
    */
    private double precioReg;
    
    /**
    * producto codigo barras
    */
    private String productoCodigoBarras;
    
    /**
    * sucursal id
    */
    private Integer sucursalId;

    /** 
     * Default Constructor
     */
    public ProductoSucursalDTO() {
    }

    /**
     * Getters and Setters
     */
    // productoSucursalPK EmbedableColumn ID References: FKs {[[SUCURSAL_ID] integer(10,0), [PRODUCTO_CODIGO_BARRAS] varchar(128,0)]}
    // productoSucursalPK EmbedableColumn ID References: FKs {[[SUCURSAL_ID] integer(10,0), [PRODUCTO_CODIGO_BARRAS] varchar(128,0)]}
    public int getCantidad1ra() {
        return this.cantidad1ra;
    }
    public void setCantidad1ra(int v) {
        this.cantidad1ra = v;
    }
    public double getPrecio1ra() {
        return this.precio1ra;
    }
    public void setPrecio1ra(double v) {
        this.precio1ra = v;
    }
    public int getCantidadOpo() {
        return this.cantidadOpo;
    }
    public void setCantidadOpo(int v) {
        this.cantidadOpo = v;
    }
    public double getPrecioOpo() {
        return this.precioOpo;
    }
    public void setPrecioOpo(double v) {
        this.precioOpo = v;
    }
    public int getCantidadReg() {
        return this.cantidadReg;
    }
    public void setCantidadReg(int v) {
        this.cantidadReg = v;
    }
    public double getPrecioReg() {
        return this.precioReg;
    }
    public void setPrecioReg(double v) {
        this.precioReg = v;
    }
    public String getProductoCodigoBarras() {
        return this.productoCodigoBarras;
    }
    public void setProductoCodigoBarras(String v) {
        this.productoCodigoBarras = v;
    }
    public Integer getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(Integer v) {
        this.sucursalId = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(cantidad1ra).hashCode();
		hash += String.valueOf(precio1ra).hashCode();
		hash += String.valueOf(cantidadOpo).hashCode();
		hash += String.valueOf(precioOpo).hashCode();
		hash += String.valueOf(cantidadReg).hashCode();
		hash += String.valueOf(precioReg).hashCode();
		hash += String.valueOf(productoCodigoBarras).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
        return hash;
    }

	@Override
    public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}        
        if (!(o instanceof ProductoSucursalDTO)) {
            return false;
        }		
		ProductoSucursalDTO  other = (ProductoSucursalDTO ) o;
		if (!Objects.equals(this.cantidad1ra, other.cantidad1ra)) { return false; }		
		if (!Objects.equals(this.precio1ra, other.precio1ra)) { return false; }		
		if (!Objects.equals(this.cantidadOpo, other.cantidadOpo)) { return false; }		
		if (!Objects.equals(this.precioOpo, other.precioOpo)) { return false; }		
		if (!Objects.equals(this.cantidadReg, other.cantidadReg)) { return false; }		
		if (!Objects.equals(this.precioReg, other.precioReg)) { return false; }		
		if (!Objects.equals(this.productoCodigoBarras, other.productoCodigoBarras)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("cantidad1ra", this.cantidad1ra);
		jsonObj.put("precio1ra", this.precio1ra);
		jsonObj.put("cantidadOpo", this.cantidadOpo);
		jsonObj.put("precioOpo", this.precioOpo);
		jsonObj.put("cantidadReg", this.cantidadReg);
		jsonObj.put("precioReg", this.precioReg);
		jsonObj.put("productoCodigoBarras", this.productoCodigoBarras);
		jsonObj.put("sucursalId", this.sucursalId);
		return jsonObj.toString();
    }

	public static ProductoSucursalDTO create(String json) throws IllegalArgumentException{
		ProductoSucursalDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.cantidad1ra = (jObj.getInt("cantidad1ra"));
		x.precio1ra = (jObj.getDouble("precio1ra"));
		x.cantidadOpo = (jObj.getInt("cantidadOpo"));
		x.precioOpo = (jObj.getDouble("precioOpo"));
		x.cantidadReg = (jObj.getInt("cantidadReg"));
		x.precioReg = (jObj.getDouble("precioReg"));
		x.productoCodigoBarras = (jObj.getString("productoCodigoBarras"));
		x.sucursalId = (jObj.getInt("sucursalId"));
		
		return x;
	}

}
