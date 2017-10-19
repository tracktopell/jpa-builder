package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table PROMOCION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class PromocionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1705736037;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * regla aritmetica
    */
    private String reglaAritmetica;

    /** 
     * Default Constructor
     */
    public PromocionDTO() {
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
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getReglaAritmetica() {
        return this.reglaAritmetica;
    }
    public void setReglaAritmetica(String v) {
        this.reglaAritmetica = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(reglaAritmetica).hashCode();
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
        if (!(o instanceof PromocionDTO)) {
            return false;
        }		
		PromocionDTO  other = (PromocionDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.reglaAritmetica, other.reglaAritmetica)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("reglaAritmetica", this.reglaAritmetica);
		return jsonObj.toString();
    }

	public static PromocionDTO create(String json) throws IllegalArgumentException{
		PromocionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.nombre = (jObj.getString("nombre"));
		x.reglaAritmetica = (jObj.getString("reglaAritmetica"));
		
		return x;
	}

}
