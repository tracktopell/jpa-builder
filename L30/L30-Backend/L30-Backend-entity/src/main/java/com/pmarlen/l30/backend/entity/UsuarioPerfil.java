package com.pmarlen.l30.backend.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Embeddable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table USUARIO_PERFIL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

@Entity
@Table(name = "USUARIO_PERFIL")
@NamedQueries({
    @NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u")
    , @NamedQuery(name = "UsuarioPerfil.countAll", query = "SELECT COUNT(u) FROM UsuarioPerfil u")
    , @NamedQuery(name = "UsuarioPerfil.findByusuariousuario", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuariousuario = :usuariousuario")
    , @NamedQuery(name = "UsuarioPerfil.findByUsuarioPerfilPK", query = "SELECT u FROM UsuarioPerfil u WHERE u.usuarioPerfilPK = :usuarioPerfilPK")
})
public class UsuarioPerfil implements java.io.Serializable {
    private static final long serialVersionUID = 999966131;
    
    /**
    * The 'USUARIO ID' Maps to COLUMN 'USUARIO_ID'
    */
    
    @JoinColumn(name = "USUARIO_ID" , referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuariousuario;
    
    /**
    * The 'USUARIO PERFIL P K' Maps to COLUMN 'USUARIO_PERFIL_P_K'
    */
    
    @EmbeddedId
    private UsuarioPerfilPK usuarioPerfilPK;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public UsuarioPerfil() {
    }
    
    /**
     * Getters and Setters
     */
    public Usuario getUsuariousuario(){ return this.usuariousuario ; }
    public void setUsuariousuario(Usuario x){ this.usuariousuario = x; }
    
    public UsuarioPerfilPK getUsuarioPerfilPK() { return this.usuarioPerfilPK;}
    public void setUsuarioPerfilPK(UsuarioPerfilPK v) { this.usuarioPerfilPK = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(usuariousuario).hashCode();
		hash += String.valueOf(usuarioPerfilPK).hashCode();
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
        if (!(o instanceof UsuarioPerfil)) {
            return false;
        }		
		UsuarioPerfil other = (UsuarioPerfil ) o;
		if (!Objects.equals(this.usuariousuario, other.usuariousuario)) { return false; }		
		if (!Objects.equals(this.usuarioPerfilPK, other.usuarioPerfilPK)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("UsuarioPerfil{");
		sb.append("usuariousuario" ).append("=").append(usuariousuario).append("|");
		sb.append("usuarioPerfilPK" ).append("=").append(usuarioPerfilPK).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
