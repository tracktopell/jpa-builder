package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CONFIGURACION_PROOVEDOR_CFD.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class ConfiguracionProovedorCfdDTO implements java.io.Serializable {
    private static final long serialVersionUID = 531885035;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * sucursal id
    */
    private int sucursalId;
    
    /**
    * prioridad
    */
    private int prioridad;
    
    /**
    * proveedor cfd
    */
    private String proveedorCfd;
    
    /**
    * usuario cfd
    */
    private String usuarioCfd;
    
    /**
    * password cfd
    */
    private String passwordCfd;
    
    /**
    * serie cfd
    */
    private String serieCfd;

    /** 
     * Default Constructor
     */
    public ConfiguracionProovedorCfdDTO() {
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
    public int getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(int v) {
        this.sucursalId = v;
    }
    public int getPrioridad() {
        return this.prioridad;
    }
    public void setPrioridad(int v) {
        this.prioridad = v;
    }
    public String getProveedorCfd() {
        return this.proveedorCfd;
    }
    public void setProveedorCfd(String v) {
        this.proveedorCfd = v;
    }
    public String getUsuarioCfd() {
        return this.usuarioCfd;
    }
    public void setUsuarioCfd(String v) {
        this.usuarioCfd = v;
    }
    public String getPasswordCfd() {
        return this.passwordCfd;
    }
    public void setPasswordCfd(String v) {
        this.passwordCfd = v;
    }
    public String getSerieCfd() {
        return this.serieCfd;
    }
    public void setSerieCfd(String v) {
        this.serieCfd = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
		hash += String.valueOf(prioridad).hashCode();
		hash += String.valueOf(proveedorCfd).hashCode();
		hash += String.valueOf(usuarioCfd).hashCode();
		hash += String.valueOf(passwordCfd).hashCode();
		hash += String.valueOf(serieCfd).hashCode();
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
        if (!(o instanceof ConfiguracionProovedorCfdDTO)) {
            return false;
        }		
		ConfiguracionProovedorCfdDTO  other = (ConfiguracionProovedorCfdDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
		if (!Objects.equals(this.prioridad, other.prioridad)) { return false; }		
		if (!Objects.equals(this.proveedorCfd, other.proveedorCfd)) { return false; }		
		if (!Objects.equals(this.usuarioCfd, other.usuarioCfd)) { return false; }		
		if (!Objects.equals(this.passwordCfd, other.passwordCfd)) { return false; }		
		if (!Objects.equals(this.serieCfd, other.serieCfd)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("sucursalId", this.sucursalId);
		jsonObj.put("prioridad", this.prioridad);
		jsonObj.put("proveedorCfd", this.proveedorCfd);
		jsonObj.put("usuarioCfd", this.usuarioCfd);
		jsonObj.put("passwordCfd", this.passwordCfd);
		jsonObj.put("serieCfd", this.serieCfd);
		return jsonObj.toString();
    }

	public static ConfiguracionProovedorCfdDTO create(String json) throws IllegalArgumentException{
		ConfiguracionProovedorCfdDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.sucursalId = (jObj.getInt("sucursalId"));
		x.prioridad = (jObj.getInt("prioridad"));
		x.proveedorCfd = (jObj.getString("proveedorCfd"));
		x.usuarioCfd = (jObj.getString("usuarioCfd"));
		x.passwordCfd = (jObj.getString("passwordCfd"));
		x.serieCfd = (jObj.getString("serieCfd"));
		
		return x;
	}

}
