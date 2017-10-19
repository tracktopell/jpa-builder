package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table ENTRADA_SALIDA.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class EntradaSalidaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 791452441;

    
    /**
    * id
    */
    private Integer id;
    
    /**
    * tipo mov
    */
    private int tipoMov;
    
    /**
    * fecha creo
    */
    private java.sql.Timestamp fechaCreo;
    
    /**
    * estado id actual
    */
    private int estadoIdActual;
    
    /**
    * cliente id
    */
    private int clienteId;
    
    /**
    * forma de pago id
    */
    private int formaDePagoId;
    
    /**
    * metodo de pago id
    */
    private int metodoDePagoId;
    
    /**
    * usuario id creo
    */
    private int usuarioIdCreo;
    
    /**
    * usuarioid
    */
    private int usuarioid;

    /** 
     * Default Constructor
     */
    public EntradaSalidaDTO() {
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
    public int getTipoMov() {
        return this.tipoMov;
    }
    public void setTipoMov(int v) {
        this.tipoMov = v;
    }
    public java.sql.Timestamp getFechaCreo() {
        return this.fechaCreo;
    }
    public void setFechaCreo(java.sql.Timestamp v) {
        this.fechaCreo = v;
    }
    public int getEstadoIdActual() {
        return this.estadoIdActual;
    }
    public void setEstadoIdActual(int v) {
        this.estadoIdActual = v;
    }
    public int getClienteId() {
        return this.clienteId;
    }
    public void setClienteId(int v) {
        this.clienteId = v;
    }
    public int getFormaDePagoId() {
        return this.formaDePagoId;
    }
    public void setFormaDePagoId(int v) {
        this.formaDePagoId = v;
    }
    public int getMetodoDePagoId() {
        return this.metodoDePagoId;
    }
    public void setMetodoDePagoId(int v) {
        this.metodoDePagoId = v;
    }
    public int getUsuarioIdCreo() {
        return this.usuarioIdCreo;
    }
    public void setUsuarioIdCreo(int v) {
        this.usuarioIdCreo = v;
    }
    public int getUsuarioid() {
        return this.usuarioid;
    }
    public void setUsuarioid(int v) {
        this.usuarioid = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(tipoMov).hashCode();
		hash += String.valueOf(fechaCreo).hashCode();
		hash += String.valueOf(estadoIdActual).hashCode();
		hash += String.valueOf(clienteId).hashCode();
		hash += String.valueOf(formaDePagoId).hashCode();
		hash += String.valueOf(metodoDePagoId).hashCode();
		hash += String.valueOf(usuarioIdCreo).hashCode();
		hash += String.valueOf(usuarioid).hashCode();
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
        if (!(o instanceof EntradaSalidaDTO)) {
            return false;
        }		
		EntradaSalidaDTO  other = (EntradaSalidaDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.tipoMov, other.tipoMov)) { return false; }		
		if (!Objects.equals(this.fechaCreo, other.fechaCreo)) { return false; }		
		if (!Objects.equals(this.estadoIdActual, other.estadoIdActual)) { return false; }		
		if (!Objects.equals(this.clienteId, other.clienteId)) { return false; }		
		if (!Objects.equals(this.formaDePagoId, other.formaDePagoId)) { return false; }		
		if (!Objects.equals(this.metodoDePagoId, other.metodoDePagoId)) { return false; }		
		if (!Objects.equals(this.usuarioIdCreo, other.usuarioIdCreo)) { return false; }		
		if (!Objects.equals(this.usuarioid, other.usuarioid)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("tipoMov", this.tipoMov);
		jsonObj.put("fechaCreo", this.fechaCreo);
		jsonObj.put("estadoIdActual", this.estadoIdActual);
		jsonObj.put("clienteId", this.clienteId);
		jsonObj.put("formaDePagoId", this.formaDePagoId);
		jsonObj.put("metodoDePagoId", this.metodoDePagoId);
		jsonObj.put("usuarioIdCreo", this.usuarioIdCreo);
		jsonObj.put("usuarioid", this.usuarioid);
		return jsonObj.toString();
    }

	public static EntradaSalidaDTO create(String json) throws IllegalArgumentException{
		EntradaSalidaDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.id = (jObj.getInt("id"));
		x.tipoMov = (jObj.getInt("tipoMov"));
		x.fechaCreo = new java.sql.Timestamp(jObj.getLong("fechaCreo"));
		x.estadoIdActual = (jObj.getInt("estadoIdActual"));
		x.clienteId = (jObj.getInt("clienteId"));
		x.formaDePagoId = (jObj.getInt("formaDePagoId"));
		x.metodoDePagoId = (jObj.getInt("metodoDePagoId"));
		x.usuarioIdCreo = (jObj.getInt("usuarioIdCreo"));
		x.usuarioid = (jObj.getInt("usuarioid"));
		
		return x;
	}

}
