package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table MOVIMIENTO_OPERATIVO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class MovimientoOperativoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 81628611;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * motivo
    */
    private String motivo;
    
    /**
    * fecha
    */
    private java.sql.Timestamp fecha;
    
    /**
    * sucursal id origen
    */
    private int sucursalIdOrigen;
    
    /**
    * almacen origen
    */
    private String almacenOrigen;
    
    /**
    * sucursal id destino
    */
    private int sucursalIdDestino;
    
    /**
    * almacen destino
    */
    private String almacenDestino;
    
    /**
    * tipo mov
    */
    private int tipoMov;

    /** 
     * Default Constructor
     */
    public MovimientoOperativoDTO() {
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
    public String getMotivo() {
        return this.motivo;
    }
    public void setMotivo(String v) {
        this.motivo = v;
    }
    public java.sql.Timestamp getFecha() {
        return this.fecha;
    }
    public void setFecha(java.sql.Timestamp v) {
        this.fecha = v;
    }
    public int getSucursalIdOrigen() {
        return this.sucursalIdOrigen;
    }
    public void setSucursalIdOrigen(int v) {
        this.sucursalIdOrigen = v;
    }
    public String getAlmacenOrigen() {
        return this.almacenOrigen;
    }
    public void setAlmacenOrigen(String v) {
        this.almacenOrigen = v;
    }
    public int getSucursalIdDestino() {
        return this.sucursalIdDestino;
    }
    public void setSucursalIdDestino(int v) {
        this.sucursalIdDestino = v;
    }
    public String getAlmacenDestino() {
        return this.almacenDestino;
    }
    public void setAlmacenDestino(String v) {
        this.almacenDestino = v;
    }
    public int getTipoMov() {
        return this.tipoMov;
    }
    public void setTipoMov(int v) {
        this.tipoMov = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(motivo).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(sucursalIdOrigen).hashCode();
		hash += String.valueOf(almacenOrigen).hashCode();
		hash += String.valueOf(sucursalIdDestino).hashCode();
		hash += String.valueOf(almacenDestino).hashCode();
		hash += String.valueOf(tipoMov).hashCode();
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
        if (!(o instanceof MovimientoOperativoDTO)) {
            return false;
        }		
		MovimientoOperativoDTO  other = (MovimientoOperativoDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.motivo, other.motivo)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.sucursalIdOrigen, other.sucursalIdOrigen)) { return false; }		
		if (!Objects.equals(this.almacenOrigen, other.almacenOrigen)) { return false; }		
		if (!Objects.equals(this.sucursalIdDestino, other.sucursalIdDestino)) { return false; }		
		if (!Objects.equals(this.almacenDestino, other.almacenDestino)) { return false; }		
		if (!Objects.equals(this.tipoMov, other.tipoMov)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("motivo", this.motivo);
		jsonObj.put("fecha", this.fecha);
		jsonObj.put("sucursalIdOrigen", this.sucursalIdOrigen);
		jsonObj.put("almacenOrigen", this.almacenOrigen);
		jsonObj.put("sucursalIdDestino", this.sucursalIdDestino);
		jsonObj.put("almacenDestino", this.almacenDestino);
		jsonObj.put("tipoMov", this.tipoMov);
		return jsonObj.toString();
    }

	public static MovimientoOperativoDTO create(String json) throws IllegalArgumentException{
		MovimientoOperativoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.motivo = (jObj.getString("motivo"));
		x.fecha = new java.sql.Timestamp(jObj.getLong("fecha"));
		x.sucursalIdOrigen = (jObj.getInt("sucursalIdOrigen"));
		x.almacenOrigen = (jObj.getString("almacenOrigen"));
		x.sucursalIdDestino = (jObj.getInt("sucursalIdDestino"));
		x.almacenDestino = (jObj.getString("almacenDestino"));
		x.tipoMov = (jObj.getInt("tipoMov"));
		
		return x;
	}

}
