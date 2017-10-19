package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CORTE_CAJA.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class CorteCajaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1927950199;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * sucursal id
    */
    private int sucursalId;
    
    /**
    * tipo evento
    */
    private int tipoEvento;
    
    /**
    * usuario id
    */
    private int usuarioId;
    
    /**
    * fecha
    */
    private java.sql.Timestamp fecha;
    
    /**
    * fecha uap
    */
    private java.sql.Timestamp fechaUap;
    
    /**
    * saldo inicial
    */
    private Double saldoInicial;
    
    /**
    * saldo final
    */
    private Double saldoFinal;
    
    /**
    * usuario id autorizo
    */
    private int usuarioIdAutorizo;
    
    /**
    * comentarios
    */
    private String comentarios;
    
    /**
    * caja
    */
    private int caja;

    /** 
     * Default Constructor
     */
    public CorteCajaDTO() {
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
    public int getTipoEvento() {
        return this.tipoEvento;
    }
    public void setTipoEvento(int v) {
        this.tipoEvento = v;
    }
    public int getUsuarioId() {
        return this.usuarioId;
    }
    public void setUsuarioId(int v) {
        this.usuarioId = v;
    }
    public java.sql.Timestamp getFecha() {
        return this.fecha;
    }
    public void setFecha(java.sql.Timestamp v) {
        this.fecha = v;
    }
    public java.sql.Timestamp getFechaUap() {
        return this.fechaUap;
    }
    public void setFechaUap(java.sql.Timestamp v) {
        this.fechaUap = v;
    }
    public Double getSaldoInicial() {
        return this.saldoInicial;
    }
    public void setSaldoInicial(Double v) {
        this.saldoInicial = v;
    }
    public Double getSaldoFinal() {
        return this.saldoFinal;
    }
    public void setSaldoFinal(Double v) {
        this.saldoFinal = v;
    }
    public int getUsuarioIdAutorizo() {
        return this.usuarioIdAutorizo;
    }
    public void setUsuarioIdAutorizo(int v) {
        this.usuarioIdAutorizo = v;
    }
    public String getComentarios() {
        return this.comentarios;
    }
    public void setComentarios(String v) {
        this.comentarios = v;
    }
    public int getCaja() {
        return this.caja;
    }
    public void setCaja(int v) {
        this.caja = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
		hash += String.valueOf(tipoEvento).hashCode();
		hash += String.valueOf(usuarioId).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(fechaUap).hashCode();
		hash += String.valueOf(saldoInicial).hashCode();
		hash += String.valueOf(saldoFinal).hashCode();
		hash += String.valueOf(usuarioIdAutorizo).hashCode();
		hash += String.valueOf(comentarios).hashCode();
		hash += String.valueOf(caja).hashCode();
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
        if (!(o instanceof CorteCajaDTO)) {
            return false;
        }		
		CorteCajaDTO  other = (CorteCajaDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
		if (!Objects.equals(this.tipoEvento, other.tipoEvento)) { return false; }		
		if (!Objects.equals(this.usuarioId, other.usuarioId)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.fechaUap, other.fechaUap)) { return false; }		
		if (!Objects.equals(this.saldoInicial, other.saldoInicial)) { return false; }		
		if (!Objects.equals(this.saldoFinal, other.saldoFinal)) { return false; }		
		if (!Objects.equals(this.usuarioIdAutorizo, other.usuarioIdAutorizo)) { return false; }		
		if (!Objects.equals(this.comentarios, other.comentarios)) { return false; }		
		if (!Objects.equals(this.caja, other.caja)) { return false; }		
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
		jsonObj.put("tipoEvento", this.tipoEvento);
		jsonObj.put("usuarioId", this.usuarioId);
		jsonObj.put("fecha", this.fecha);
		jsonObj.put("fechaUap", this.fechaUap);
		jsonObj.put("saldoInicial", this.saldoInicial);
		jsonObj.put("saldoFinal", this.saldoFinal);
		jsonObj.put("usuarioIdAutorizo", this.usuarioIdAutorizo);
		jsonObj.put("comentarios", this.comentarios);
		jsonObj.put("caja", this.caja);
		return jsonObj.toString();
    }

	public static CorteCajaDTO create(String json) throws IllegalArgumentException{
		CorteCajaDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.sucursalId = (jObj.getInt("sucursalId"));
		x.tipoEvento = (jObj.getInt("tipoEvento"));
		x.usuarioId = (jObj.getInt("usuarioId"));
		x.fecha = new java.sql.Timestamp(jObj.getLong("fecha"));
		x.fechaUap = new java.sql.Timestamp(jObj.getLong("fechaUap"));
		x.saldoInicial = (jObj.getDouble("saldoInicial"));
		x.saldoFinal = (jObj.getDouble("saldoFinal"));
		x.usuarioIdAutorizo = (jObj.getInt("usuarioIdAutorizo"));
		x.comentarios = (jObj.getString("comentarios"));
		x.caja = (jObj.getInt("caja"));
		
		return x;
	}

}
