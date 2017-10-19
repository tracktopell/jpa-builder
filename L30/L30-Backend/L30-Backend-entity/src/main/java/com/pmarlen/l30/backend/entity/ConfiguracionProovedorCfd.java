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

// Hibernate Validator 5x is not compatible with validation-api 1.0.x
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table CONFIGURACION_PROOVEDOR_CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "CONFIGURACION_PROOVEDOR_CFD")
@NamedQueries({
    @NamedQuery(name = "ConfiguracionProovedorCfd.findAll", query = "SELECT c FROM ConfiguracionProovedorCfd c")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.countAll", query = "SELECT COUNT(c) FROM ConfiguracionProovedorCfd c")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.findById", query = "SELECT c FROM ConfiguracionProovedorCfd c WHERE c.id = :id")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.findBysucursalsucursal", query = "SELECT c FROM ConfiguracionProovedorCfd c WHERE c.sucursalsucursal = :sucursalsucursal")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.findByPrioridad", query = "SELECT c FROM ConfiguracionProovedorCfd c WHERE c.prioridad = :prioridad")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.findByProveedorCfd", query = "SELECT c FROM ConfiguracionProovedorCfd c WHERE c.proveedorCfd = :proveedorCfd")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.findByUsuarioCfd", query = "SELECT c FROM ConfiguracionProovedorCfd c WHERE c.usuarioCfd = :usuarioCfd")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.findByPasswordCfd", query = "SELECT c FROM ConfiguracionProovedorCfd c WHERE c.passwordCfd = :passwordCfd")
    , @NamedQuery(name = "ConfiguracionProovedorCfd.findBySerieCfd", query = "SELECT c FROM ConfiguracionProovedorCfd c WHERE c.serieCfd = :serieCfd")
})
public class ConfiguracionProovedorCfd implements java.io.Serializable {
    private static final long serialVersionUID = 531885035;
    
    /**
    * The 'ID' Maps to COLUMN 'ID'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * The 'SUCURSAL ID' Maps to COLUMN 'SUCURSAL_ID'
    */
    
    @JoinColumn(name = "SUCURSAL_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursalsucursal;
    
    /**
    * The 'PRIORIDAD' Maps to COLUMN 'PRIORIDAD'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PRIORIDAD" , nullable=false)
    private int prioridad;
    
    /**
    * The 'PROVEEDOR CFD' Maps to COLUMN 'PROVEEDOR_CFD'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 128)
    @Column(name = "PROVEEDOR_CFD" , length=128, nullable=false)
    private String proveedorCfd;
    
    /**
    * The 'USUARIO CFD' Maps to COLUMN 'USUARIO_CFD'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 64)
    @Column(name = "USUARIO_CFD" , length=64, nullable=false)
    private String usuarioCfd;
    
    /**
    * The 'PASSWORD CFD' Maps to COLUMN 'PASSWORD_CFD'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 64)
    @Column(name = "PASSWORD_CFD" , length=64, nullable=false)
    private String passwordCfd;
    
    /**
    * The 'SERIE CFD' Maps to COLUMN 'SERIE_CFD'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 4)
    @Column(name = "SERIE_CFD" , length=4, nullable=false)
    private String serieCfd;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public ConfiguracionProovedorCfd() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public Sucursal getSucursalsucursal(){ return this.sucursalsucursal ; }
    public void setSucursalsucursal(Sucursal x){ this.sucursalsucursal = x; }
    
    public int getPrioridad() { return this.prioridad;}
    public void setPrioridad(int v) { this.prioridad = v; }
    
    public String getProveedorCfd() { return this.proveedorCfd;}
    public void setProveedorCfd(String v) { this.proveedorCfd = v; }
    
    public String getUsuarioCfd() { return this.usuarioCfd;}
    public void setUsuarioCfd(String v) { this.usuarioCfd = v; }
    
    public String getPasswordCfd() { return this.passwordCfd;}
    public void setPasswordCfd(String v) { this.passwordCfd = v; }
    
    public String getSerieCfd() { return this.serieCfd;}
    public void setSerieCfd(String v) { this.serieCfd = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(sucursalsucursal).hashCode();
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
        if (!(o instanceof ConfiguracionProovedorCfd)) {
            return false;
        }		
		ConfiguracionProovedorCfd other = (ConfiguracionProovedorCfd ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.sucursalsucursal, other.sucursalsucursal)) { return false; }		
		if (!Objects.equals(this.prioridad, other.prioridad)) { return false; }		
		if (!Objects.equals(this.proveedorCfd, other.proveedorCfd)) { return false; }		
		if (!Objects.equals(this.usuarioCfd, other.usuarioCfd)) { return false; }		
		if (!Objects.equals(this.passwordCfd, other.passwordCfd)) { return false; }		
		if (!Objects.equals(this.serieCfd, other.serieCfd)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ConfiguracionProovedorCfd{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("sucursalsucursal" ).append("=").append(sucursalsucursal).append("|");
		sb.append("prioridad" ).append("=").append(prioridad).append("|");
		sb.append("proveedorCfd" ).append("=").append(proveedorCfd).append("|");
		sb.append("usuarioCfd" ).append("=").append(usuarioCfd).append("|");
		sb.append("passwordCfd" ).append("=").append(passwordCfd).append("|");
		sb.append("serieCfd" ).append("=").append(serieCfd).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
