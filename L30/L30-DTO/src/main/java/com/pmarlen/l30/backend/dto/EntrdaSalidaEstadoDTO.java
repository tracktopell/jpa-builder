package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table ENTRDA_SALIDA_ESTADO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class EntrdaSalidaEstadoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 135721597;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * entrada salida id
    */
    private int entradaSalidaId;
    
    /**
    * fecha
    */
    private Integer fecha;
    
    /**
    * comentarios
    */
    private String comentarios;
    
    /**
    * estado id
    */
    private int estadoId;
    
    /**
    * usuario id
    */
    private int usuarioId;

    /** 
     * Default Constructor
     */
    public EntrdaSalidaEstadoDTO() {
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
    public int getEntradaSalidaId() {
        return this.entradaSalidaId;
    }
    public void setEntradaSalidaId(int v) {
        this.entradaSalidaId = v;
    }
    public Integer getFecha() {
        return this.fecha;
    }
    public void setFecha(Integer v) {
        this.fecha = v;
    }
    public String getComentarios() {
        return this.comentarios;
    }
    public void setComentarios(String v) {
        this.comentarios = v;
    }
    public int getEstadoId() {
        return this.estadoId;
    }
    public void setEstadoId(int v) {
        this.estadoId = v;
    }
    public int getUsuarioId() {
        return this.usuarioId;
    }
    public void setUsuarioId(int v) {
        this.usuarioId = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(entradaSalidaId).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(comentarios).hashCode();
		hash += String.valueOf(estadoId).hashCode();
		hash += String.valueOf(usuarioId).hashCode();
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
        if (!(o instanceof EntrdaSalidaEstadoDTO)) {
            return false;
        }		
		EntrdaSalidaEstadoDTO  other = (EntrdaSalidaEstadoDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.entradaSalidaId, other.entradaSalidaId)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.comentarios, other.comentarios)) { return false; }		
		if (!Objects.equals(this.estadoId, other.estadoId)) { return false; }		
		if (!Objects.equals(this.usuarioId, other.usuarioId)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("entradaSalidaId", this.entradaSalidaId);
		jsonObj.put("fecha", this.fecha);
		jsonObj.put("comentarios", this.comentarios);
		jsonObj.put("estadoId", this.estadoId);
		jsonObj.put("usuarioId", this.usuarioId);
		return jsonObj.toString();
    }

	public static EntrdaSalidaEstadoDTO create(String json) throws IllegalArgumentException{
		EntrdaSalidaEstadoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.entradaSalidaId = (jObj.getInt("entradaSalidaId"));
		x.fecha = (jObj.getInt("fecha"));
		x.comentarios = (jObj.getString("comentarios"));
		x.estadoId = (jObj.getInt("estadoId"));
		x.usuarioId = (jObj.getInt("usuarioId"));
		
		return x;
	}

}
