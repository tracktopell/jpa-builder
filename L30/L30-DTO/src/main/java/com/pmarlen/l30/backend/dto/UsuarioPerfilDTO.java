package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table USUARIO_PERFIL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
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
    // Simple: PK?true, FK?true, class=java.lang.Integer, o=usuarioId
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

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("UsuarioPerfilDTO{");
		sb.append("usuarioId" ).append("=").append(usuarioId).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
