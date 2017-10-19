package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table USUARIO_PERFIL.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class UsuarioPerfilDTO implements java.io.Serializable {
    private static final long serialVersionUID = 999966131;

    
    /**
    * usuario perfil p k
    */
    // usuarioPerfilPK EmbedableColumn ID References: FKs {[[USUARIO_ID] integer(5,0)]}
    
    /**
    * usuario id
    */
    private Integer usuarioId;

    /** 
     * Default Constructor
     */
    public UsuarioPerfilDTO() {
    }

    /**
     * Getters and Setters
     */
    // usuarioPerfilPK EmbedableColumn ID References: FKs {[[USUARIO_ID] integer(5,0)]}
    // usuarioPerfilPK EmbedableColumn ID References: FKs {[[USUARIO_ID] integer(5,0)]}
    public Integer getUsuarioId() {
        return this.usuarioId;
    }
    public void setUsuarioId(Integer v) {
        this.usuarioId = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
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
        if (!(o instanceof UsuarioPerfilDTO)) {
            return false;
        }		
		UsuarioPerfilDTO  other = (UsuarioPerfilDTO ) o;
		if (!Objects.equals(this.usuarioId, other.usuarioId)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("usuarioId", this.usuarioId);
		return jsonObj.toString();
    }

	public static UsuarioPerfilDTO create(String json) throws IllegalArgumentException{
		UsuarioPerfilDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.usuarioId = (jObj.getInt("usuarioId"));
		
		return x;
	}

}
