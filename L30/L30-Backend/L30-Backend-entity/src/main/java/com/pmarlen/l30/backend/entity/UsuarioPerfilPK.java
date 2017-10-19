package com.pmarlen.l30.backend.entity;

import java.util.Set;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// Hibernate Validator 5x is not compatible with validation-api 1.0.x
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class for mapping JPA Embedable PK of Table USUARIO_PERFIL_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Embeddable

@XmlRootElement
public class UsuarioPerfilPK implements java.io.Serializable {
    private static final long serialVersionUID = 1128032093;
    
    /**
    * The 'USUARIO ID' Maps to COLUMN 'USUARIO_ID'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "USUARIO_ID" , nullable=false)
    private Integer usuarioId;
    
    /**
    * The 'PERFIL' Maps to COLUMN 'PERFIL'
    */
    
    //@Basic(optional = false)
    //@Size(min = 1, max = 16)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PERFIL" , length=16, nullable=false  )
    private String perfil;

    /** 
     * Default Constructor
     */
    public UsuarioPerfilPK() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getUsuarioId() { return this.usuarioId;}
    public void setUsuarioId(Integer v) { this.usuarioId = v; }
    
    public String getPerfil() { return this.perfil;}
    public void setPerfil(String v) { this.perfil = v; }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(usuarioId).hashCode();
		hash += String.valueOf(perfil).hashCode();
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
        if (!(o instanceof UsuarioPerfilPK)) {
            return false;
        }		
		UsuarioPerfilPK other = (UsuarioPerfilPK ) o;
		if (!Objects.equals(this.usuarioId, other.usuarioId)) { return false; }		
		if (!Objects.equals(this.perfil, other.perfil)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("UsuarioPerfilPK{");
		sb.append("usuarioId" ).append("=").append(usuarioId).append("|");
		sb.append("perfil" ).append("=").append(perfil).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
