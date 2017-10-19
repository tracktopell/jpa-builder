package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table OFERTA_PRODUCTO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class OfertaProductoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1096979270;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * producto codigo barras
    */
    private String productoCodigoBarras;
    
    /**
    * sucursal id
    */
    private int sucursalId;
    
    /**
    * promocion id
    */
    private int promocionId;
    
    /**
    * fecha inicial
    */
    private java.sql.Date fechaInicial;
    
    /**
    * fecha final
    */
    private java.sql.Date fechaFinal;

    /** 
     * Default Constructor
     */
    public OfertaProductoDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer v) {
        this.id = v;
    }
    public String getProductoCodigoBarras() {
        return this.productoCodigoBarras;
    }
    public void setProductoCodigoBarras(String v) {
        this.productoCodigoBarras = v;
    }
    public int getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(int v) {
        this.sucursalId = v;
    }
    public int getPromocionId() {
        return this.promocionId;
    }
    public void setPromocionId(int v) {
        this.promocionId = v;
    }
    public java.sql.Date getFechaInicial() {
        return this.fechaInicial;
    }
    public void setFechaInicial(java.sql.Date v) {
        this.fechaInicial = v;
    }
    public java.sql.Date getFechaFinal() {
        return this.fechaFinal;
    }
    public void setFechaFinal(java.sql.Date v) {
        this.fechaFinal = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(productoCodigoBarras).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
		hash += String.valueOf(promocionId).hashCode();
		hash += String.valueOf(fechaInicial).hashCode();
		hash += String.valueOf(fechaFinal).hashCode();
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
        if (!(o instanceof OfertaProductoDTO)) {
            return false;
        }		
		OfertaProductoDTO  other = (OfertaProductoDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.productoCodigoBarras, other.productoCodigoBarras)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
		if (!Objects.equals(this.promocionId, other.promocionId)) { return false; }		
		if (!Objects.equals(this.fechaInicial, other.fechaInicial)) { return false; }		
		if (!Objects.equals(this.fechaFinal, other.fechaFinal)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("productoCodigoBarras", this.productoCodigoBarras);
		jsonObj.put("sucursalId", this.sucursalId);
		jsonObj.put("promocionId", this.promocionId);
		jsonObj.put("fechaInicial", this.fechaInicial);
		jsonObj.put("fechaFinal", this.fechaFinal);
		return jsonObj.toString();
    }

	public static OfertaProductoDTO create(String json) throws IllegalArgumentException{
		OfertaProductoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.productoCodigoBarras = (jObj.getString("productoCodigoBarras"));
		x.sucursalId = (jObj.getInt("sucursalId"));
		x.promocionId = (jObj.getInt("promocionId"));
		x.fechaInicial = new java.sql.Date(jObj.getLong("fechaInicial"));
		x.fechaFinal = new java.sql.Date(jObj.getLong("fechaFinal"));
		
		return x;
	}

}
