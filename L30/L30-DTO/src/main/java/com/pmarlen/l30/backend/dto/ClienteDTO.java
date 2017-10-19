package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CLIENTE.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class ClienteDTO implements java.io.Serializable {
    private static final long serialVersionUID = 931919113;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * rfc
    */
    private String rfc;
    
    /**
    * razon social
    */
    private String razonSocial;
    
    /**
    * nombre establecimiento
    */
    private String nombreEstablecimiento;
    
    /**
    * direccion facturacion
    */
    private String direccionFacturacion;
    
    /**
    * telefonos
    */
    private String telefonos;
    
    /**
    * banco
    */
    private String banco;
    
    /**
    * num cuenta
    */
    private String numCuenta;
    
    /**
    * email
    */
    private String email;
    
    /**
    * referencia
    */
    private String referencia;
    
    /**
    * contacto
    */
    private String contacto;
    
    /**
    * ubicacion lat
    */
    private Double ubicacionLat;
    
    /**
    * ubicacion lon
    */
    private Double ubicacionLon;

    /** 
     * Default Constructor
     */
    public ClienteDTO() {
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
    public String getRfc() {
        return this.rfc;
    }
    public void setRfc(String v) {
        this.rfc = v;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    public void setRazonSocial(String v) {
        this.razonSocial = v;
    }
    public String getNombreEstablecimiento() {
        return this.nombreEstablecimiento;
    }
    public void setNombreEstablecimiento(String v) {
        this.nombreEstablecimiento = v;
    }
    public String getDireccionFacturacion() {
        return this.direccionFacturacion;
    }
    public void setDireccionFacturacion(String v) {
        this.direccionFacturacion = v;
    }
    public String getTelefonos() {
        return this.telefonos;
    }
    public void setTelefonos(String v) {
        this.telefonos = v;
    }
    public String getBanco() {
        return this.banco;
    }
    public void setBanco(String v) {
        this.banco = v;
    }
    public String getNumCuenta() {
        return this.numCuenta;
    }
    public void setNumCuenta(String v) {
        this.numCuenta = v;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String v) {
        this.email = v;
    }
    public String getReferencia() {
        return this.referencia;
    }
    public void setReferencia(String v) {
        this.referencia = v;
    }
    public String getContacto() {
        return this.contacto;
    }
    public void setContacto(String v) {
        this.contacto = v;
    }
    public Double getUbicacionLat() {
        return this.ubicacionLat;
    }
    public void setUbicacionLat(Double v) {
        this.ubicacionLat = v;
    }
    public Double getUbicacionLon() {
        return this.ubicacionLon;
    }
    public void setUbicacionLon(Double v) {
        this.ubicacionLon = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(rfc).hashCode();
		hash += String.valueOf(razonSocial).hashCode();
		hash += String.valueOf(nombreEstablecimiento).hashCode();
		hash += String.valueOf(direccionFacturacion).hashCode();
		hash += String.valueOf(telefonos).hashCode();
		hash += String.valueOf(banco).hashCode();
		hash += String.valueOf(numCuenta).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(referencia).hashCode();
		hash += String.valueOf(contacto).hashCode();
		hash += String.valueOf(ubicacionLat).hashCode();
		hash += String.valueOf(ubicacionLon).hashCode();
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
        if (!(o instanceof ClienteDTO)) {
            return false;
        }		
		ClienteDTO  other = (ClienteDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.rfc, other.rfc)) { return false; }		
		if (!Objects.equals(this.razonSocial, other.razonSocial)) { return false; }		
		if (!Objects.equals(this.nombreEstablecimiento, other.nombreEstablecimiento)) { return false; }		
		if (!Objects.equals(this.direccionFacturacion, other.direccionFacturacion)) { return false; }		
		if (!Objects.equals(this.telefonos, other.telefonos)) { return false; }		
		if (!Objects.equals(this.banco, other.banco)) { return false; }		
		if (!Objects.equals(this.numCuenta, other.numCuenta)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.referencia, other.referencia)) { return false; }		
		if (!Objects.equals(this.contacto, other.contacto)) { return false; }		
		if (!Objects.equals(this.ubicacionLat, other.ubicacionLat)) { return false; }		
		if (!Objects.equals(this.ubicacionLon, other.ubicacionLon)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("rfc", this.rfc);
		jsonObj.put("razonSocial", this.razonSocial);
		jsonObj.put("nombreEstablecimiento", this.nombreEstablecimiento);
		jsonObj.put("direccionFacturacion", this.direccionFacturacion);
		jsonObj.put("telefonos", this.telefonos);
		jsonObj.put("banco", this.banco);
		jsonObj.put("numCuenta", this.numCuenta);
		jsonObj.put("email", this.email);
		jsonObj.put("referencia", this.referencia);
		jsonObj.put("contacto", this.contacto);
		jsonObj.put("ubicacionLat", this.ubicacionLat);
		jsonObj.put("ubicacionLon", this.ubicacionLon);
		return jsonObj.toString();
    }

	public static ClienteDTO create(String json) throws IllegalArgumentException{
		ClienteDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.rfc = (jObj.getString("rfc"));
		x.razonSocial = (jObj.getString("razonSocial"));
		x.nombreEstablecimiento = (jObj.getString("nombreEstablecimiento"));
		x.direccionFacturacion = (jObj.getString("direccionFacturacion"));
		x.telefonos = (jObj.getString("telefonos"));
		x.banco = (jObj.getString("banco"));
		x.numCuenta = (jObj.getString("numCuenta"));
		x.email = (jObj.getString("email"));
		x.referencia = (jObj.getString("referencia"));
		x.contacto = (jObj.getString("contacto"));
		x.ubicacionLat = (jObj.getDouble("ubicacionLat"));
		x.ubicacionLon = (jObj.getDouble("ubicacionLon"));
		
		return x;
	}

}
