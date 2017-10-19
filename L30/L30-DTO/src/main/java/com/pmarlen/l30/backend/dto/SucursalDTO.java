package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table SUCURSAL.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class SucursalDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2003749087;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * tipo
    */
    private int tipo;
    
    /**
    * clave
    */
    private String clave;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * direccion
    */
    private String direccion;
    
    /**
    * telefonos
    */
    private String telefonos;
    
    /**
    * descuento myoreo habilitado
    */
    private int descuentoMyoreoHabilitado;
    
    /**
    * venta reg habilitado
    */
    private int ventaRegHabilitado;
    
    /**
    * venta opo
    */
    private int ventaOpo;

    /** 
     * Default Constructor
     */
    public SucursalDTO() {
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
    public int getTipo() {
        return this.tipo;
    }
    public void setTipo(int v) {
        this.tipo = v;
    }
    public String getClave() {
        return this.clave;
    }
    public void setClave(String v) {
        this.clave = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public void setDireccion(String v) {
        this.direccion = v;
    }
    public String getTelefonos() {
        return this.telefonos;
    }
    public void setTelefonos(String v) {
        this.telefonos = v;
    }
    public int getDescuentoMyoreoHabilitado() {
        return this.descuentoMyoreoHabilitado;
    }
    public void setDescuentoMyoreoHabilitado(int v) {
        this.descuentoMyoreoHabilitado = v;
    }
    public int getVentaRegHabilitado() {
        return this.ventaRegHabilitado;
    }
    public void setVentaRegHabilitado(int v) {
        this.ventaRegHabilitado = v;
    }
    public int getVentaOpo() {
        return this.ventaOpo;
    }
    public void setVentaOpo(int v) {
        this.ventaOpo = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(tipo).hashCode();
		hash += String.valueOf(clave).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(direccion).hashCode();
		hash += String.valueOf(telefonos).hashCode();
		hash += String.valueOf(descuentoMyoreoHabilitado).hashCode();
		hash += String.valueOf(ventaRegHabilitado).hashCode();
		hash += String.valueOf(ventaOpo).hashCode();
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
        if (!(o instanceof SucursalDTO)) {
            return false;
        }		
		SucursalDTO  other = (SucursalDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.tipo, other.tipo)) { return false; }		
		if (!Objects.equals(this.clave, other.clave)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.direccion, other.direccion)) { return false; }		
		if (!Objects.equals(this.telefonos, other.telefonos)) { return false; }		
		if (!Objects.equals(this.descuentoMyoreoHabilitado, other.descuentoMyoreoHabilitado)) { return false; }		
		if (!Objects.equals(this.ventaRegHabilitado, other.ventaRegHabilitado)) { return false; }		
		if (!Objects.equals(this.ventaOpo, other.ventaOpo)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("tipo", this.tipo);
		jsonObj.put("clave", this.clave);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("direccion", this.direccion);
		jsonObj.put("telefonos", this.telefonos);
		jsonObj.put("descuentoMyoreoHabilitado", this.descuentoMyoreoHabilitado);
		jsonObj.put("ventaRegHabilitado", this.ventaRegHabilitado);
		jsonObj.put("ventaOpo", this.ventaOpo);
		return jsonObj.toString();
    }

	public static SucursalDTO create(String json) throws IllegalArgumentException{
		SucursalDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.tipo = (jObj.getInt("tipo"));
		x.clave = (jObj.getString("clave"));
		x.nombre = (jObj.getString("nombre"));
		x.direccion = (jObj.getString("direccion"));
		x.telefonos = (jObj.getString("telefonos"));
		x.descuentoMyoreoHabilitado = (jObj.getInt("descuentoMyoreoHabilitado"));
		x.ventaRegHabilitado = (jObj.getInt("ventaRegHabilitado"));
		x.ventaOpo = (jObj.getInt("ventaOpo"));
		
		return x;
	}

}
