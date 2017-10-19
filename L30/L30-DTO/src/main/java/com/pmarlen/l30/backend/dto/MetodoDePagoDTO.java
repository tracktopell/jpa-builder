package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table METODO_DE_PAGO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class MetodoDePagoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1915318863;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * descripcion
    */
    private String descripcion;

    /** 
     * Default Constructor
     */
    public MetodoDePagoDTO() {
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
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String v) {
        this.descripcion = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(descripcion).hashCode();
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
        if (!(o instanceof MetodoDePagoDTO)) {
            return false;
        }		
		MetodoDePagoDTO  other = (MetodoDePagoDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("descripcion", this.descripcion);
		return jsonObj.toString();
    }

	public static MetodoDePagoDTO create(String json) throws IllegalArgumentException{
		MetodoDePagoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.descripcion = (jObj.getString("descripcion"));
		
		return x;
	}

}
