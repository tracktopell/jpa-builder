package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CFD.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class CfdDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1826771953;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * cfd id origen
    */
    private Integer cfdIdOrigen;
    
    /**
    * entrada salida id
    */
    private int entradaSalidaId;
    
    /**
    * tipo
    */
    private String tipo;
    
    /**
    * num cfd
    */
    private String numCfd;
    
    /**
    * ultimo error
    */
    private String ultimoError;
    
    /**
    * contenido original
    */
    private byte[] contenidoOriginal;

    /** 
     * Default Constructor
     */
    public CfdDTO() {
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
    public Integer getCfdIdOrigen() {
        return this.cfdIdOrigen;
    }
    public void setCfdIdOrigen(Integer v) {
        this.cfdIdOrigen = v;
    }
    public int getEntradaSalidaId() {
        return this.entradaSalidaId;
    }
    public void setEntradaSalidaId(int v) {
        this.entradaSalidaId = v;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String v) {
        this.tipo = v;
    }
    public String getNumCfd() {
        return this.numCfd;
    }
    public void setNumCfd(String v) {
        this.numCfd = v;
    }
    public String getUltimoError() {
        return this.ultimoError;
    }
    public void setUltimoError(String v) {
        this.ultimoError = v;
    }
    public byte[] getContenidoOriginal() {
        return this.contenidoOriginal;
    }
    public void setContenidoOriginal(byte[] v) {
        this.contenidoOriginal = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(cfdIdOrigen).hashCode();
		hash += String.valueOf(entradaSalidaId).hashCode();
		hash += String.valueOf(tipo).hashCode();
		hash += String.valueOf(numCfd).hashCode();
		hash += String.valueOf(ultimoError).hashCode();
		hash += String.valueOf(contenidoOriginal).hashCode();
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
        if (!(o instanceof CfdDTO)) {
            return false;
        }		
		CfdDTO  other = (CfdDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.cfdIdOrigen, other.cfdIdOrigen)) { return false; }		
		if (!Objects.equals(this.entradaSalidaId, other.entradaSalidaId)) { return false; }		
		if (!Objects.equals(this.tipo, other.tipo)) { return false; }		
		if (!Objects.equals(this.numCfd, other.numCfd)) { return false; }		
		if (!Objects.equals(this.ultimoError, other.ultimoError)) { return false; }		
		if (!Objects.equals(this.contenidoOriginal, other.contenidoOriginal)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("cfdIdOrigen", this.cfdIdOrigen);
		jsonObj.put("entradaSalidaId", this.entradaSalidaId);
		jsonObj.put("tipo", this.tipo);
		jsonObj.put("numCfd", this.numCfd);
		jsonObj.put("ultimoError", this.ultimoError);
		jsonObj.put("contenidoOriginal", this.contenidoOriginal);
		return jsonObj.toString();
    }

	public static CfdDTO create(String json) throws IllegalArgumentException{
		CfdDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.cfdIdOrigen = (jObj.getInt("cfdIdOrigen"));
		x.entradaSalidaId = (jObj.getInt("entradaSalidaId"));
		x.tipo = (jObj.getString("tipo"));
		x.numCfd = (jObj.getString("numCfd"));
		x.ultimoError = (jObj.getString("ultimoError"));
		x.contenidoOriginal = (jObj.getbyte[]("contenidoOriginal"));
		
		return x;
	}

}
