package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table USUARIO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class UsuarioDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1747585824;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * email
    */
    private String email;
    
    /**
    * password
    */
    private String password;
    
    /**
    * telefonos
    */
    private String telefonos;
    
    /**
    * habilitado
    */
    private int habilitado;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * apellido paterno
    */
    private String apellidoPaterno;
    
    /**
    * apellido materno
    */
    private String apellidoMaterno;
    
    /**
    * fecha registro
    */
    private java.sql.Timestamp fechaRegistro;
    
    /**
    * fecha ult  cambio
    */
    private java.sql.Timestamp fechaUltCambio;
    
    /**
    * sucursal id
    */
    private int sucursalId;

    /** 
     * Default Constructor
     */
    public UsuarioDTO() {
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
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String v) {
        this.email = v;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String v) {
        this.password = v;
    }
    public String getTelefonos() {
        return this.telefonos;
    }
    public void setTelefonos(String v) {
        this.telefonos = v;
    }
    public int getHabilitado() {
        return this.habilitado;
    }
    public void setHabilitado(int v) {
        this.habilitado = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    public void setApellidoPaterno(String v) {
        this.apellidoPaterno = v;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    public void setApellidoMaterno(String v) {
        this.apellidoMaterno = v;
    }
    public java.sql.Timestamp getFechaRegistro() {
        return this.fechaRegistro;
    }
    public void setFechaRegistro(java.sql.Timestamp v) {
        this.fechaRegistro = v;
    }
    public java.sql.Timestamp getFechaUltCambio() {
        return this.fechaUltCambio;
    }
    public void setFechaUltCambio(java.sql.Timestamp v) {
        this.fechaUltCambio = v;
    }
    public int getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(int v) {
        this.sucursalId = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(password).hashCode();
		hash += String.valueOf(telefonos).hashCode();
		hash += String.valueOf(habilitado).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(apellidoPaterno).hashCode();
		hash += String.valueOf(apellidoMaterno).hashCode();
		hash += String.valueOf(fechaRegistro).hashCode();
		hash += String.valueOf(fechaUltCambio).hashCode();
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
        if (!(o instanceof UsuarioDTO)) {
            return false;
        }		
		UsuarioDTO  other = (UsuarioDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.password, other.password)) { return false; }		
		if (!Objects.equals(this.telefonos, other.telefonos)) { return false; }		
		if (!Objects.equals(this.habilitado, other.habilitado)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) { return false; }		
		if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) { return false; }		
		if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) { return false; }		
		if (!Objects.equals(this.fechaUltCambio, other.fechaUltCambio)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("email", this.email);
		jsonObj.put("password", this.password);
		jsonObj.put("telefonos", this.telefonos);
		jsonObj.put("habilitado", this.habilitado);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("apellidoPaterno", this.apellidoPaterno);
		jsonObj.put("apellidoMaterno", this.apellidoMaterno);
		jsonObj.put("fechaRegistro", this.fechaRegistro);
		jsonObj.put("fechaUltCambio", this.fechaUltCambio);
		jsonObj.put("sucursalId", this.sucursalId);
		return jsonObj.toString();
    }

	public static UsuarioDTO create(String json) throws IllegalArgumentException{
		UsuarioDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.email = (jObj.getString("email"));
		x.password = (jObj.getString("password"));
		x.telefonos = (jObj.getString("telefonos"));
		x.habilitado = (jObj.getInt("habilitado"));
		x.nombre = (jObj.getString("nombre"));
		x.apellidoPaterno = (jObj.getString("apellidoPaterno"));
		x.apellidoMaterno = (jObj.getString("apellidoMaterno"));
		x.fechaRegistro = new java.sql.Timestamp(jObj.getLong("fechaRegistro"));
		x.fechaUltCambio = new java.sql.Timestamp(jObj.getLong("fechaUltCambio"));
		x.sucursalId = (jObj.getInt("sucursalId"));
		
		return x;
	}

}
