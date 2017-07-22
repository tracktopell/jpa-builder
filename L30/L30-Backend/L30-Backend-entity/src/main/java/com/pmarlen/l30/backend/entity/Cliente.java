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
 * Class for mapping JPA Entity of Table CLIENTE.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

@Entity
@Table(name = "CLIENTE")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.countAll", query = "SELECT COUNT(c) FROM Cliente c")
    , @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id")
    , @NamedQuery(name = "Cliente.findByRfc", query = "SELECT c FROM Cliente c WHERE c.rfc = :rfc")
    , @NamedQuery(name = "Cliente.findByRazonSocial", query = "SELECT c FROM Cliente c WHERE c.razonSocial = :razonSocial")
    , @NamedQuery(name = "Cliente.findByNombreEstablecimiento", query = "SELECT c FROM Cliente c WHERE c.nombreEstablecimiento = :nombreEstablecimiento")
    , @NamedQuery(name = "Cliente.findByDireccionFacturacion", query = "SELECT c FROM Cliente c WHERE c.direccionFacturacion = :direccionFacturacion")
    , @NamedQuery(name = "Cliente.findByTelefonos", query = "SELECT c FROM Cliente c WHERE c.telefonos = :telefonos")
    , @NamedQuery(name = "Cliente.findByBanco", query = "SELECT c FROM Cliente c WHERE c.banco = :banco")
    , @NamedQuery(name = "Cliente.findByNumCuenta", query = "SELECT c FROM Cliente c WHERE c.numCuenta = :numCuenta")
    , @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")
    , @NamedQuery(name = "Cliente.findByReferencia", query = "SELECT c FROM Cliente c WHERE c.referencia = :referencia")
    , @NamedQuery(name = "Cliente.findByContacto", query = "SELECT c FROM Cliente c WHERE c.contacto = :contacto")
    , @NamedQuery(name = "Cliente.findByUbicacionLat", query = "SELECT c FROM Cliente c WHERE c.ubicacionLat = :ubicacionLat")
    , @NamedQuery(name = "Cliente.findByUbicacionLon", query = "SELECT c FROM Cliente c WHERE c.ubicacionLon = :ubicacionLon")
})
public class Cliente implements java.io.Serializable {
    private static final long serialVersionUID = 931919113;
    
    /**
    * The 'ID' Maps to COLUMN 'ID'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * The 'RFC' Maps to COLUMN 'RFC'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "RFC" , length=16, nullable=false)
    private String rfc;
    
    /**
    * The 'RAZON SOCIAL' Maps to COLUMN 'RAZON_SOCIAL'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RAZON_SOCIAL" , length=255, nullable=false)
    private String razonSocial;
    
    /**
    * The 'NOMBRE ESTABLECIMIENTO' Maps to COLUMN 'NOMBRE_ESTABLECIMIENTO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMBRE_ESTABLECIMIENTO" , length=255, nullable=false)
    private String nombreEstablecimiento;
    
    /**
    * The 'DIRECCION FACTURACION' Maps to COLUMN 'DIRECCION_FACTURACION'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIRECCION_FACTURACION" , length=255, nullable=false)
    private String direccionFacturacion;
    
    /**
    * The 'TELEFONOS' Maps to COLUMN 'TELEFONOS'
    */
    
    @Basic(optional = true)
    @Size(max = 64)
    @Column(name = "TELEFONOS" , length=64, nullable=true)
    private String telefonos;
    
    /**
    * The 'BANCO' Maps to COLUMN 'BANCO'
    */
    
    @Basic(optional = true)
    @Size(max = 128)
    @Column(name = "BANCO" , length=128, nullable=true)
    private String banco;
    
    /**
    * The 'NUM CUENTA' Maps to COLUMN 'NUM_CUENTA'
    */
    
    @Basic(optional = true)
    @Size(max = 32)
    @Column(name = "NUM_CUENTA" , length=32, nullable=true)
    private String numCuenta;
    
    /**
    * The 'EMAIL' Maps to COLUMN 'EMAIL'
    */
    
    @Basic(optional = true)
    @Size(max = 128)
    @Column(name = "EMAIL" , length=128, nullable=true)
    private String email;
    
    /**
    * The 'REFERENCIA' Maps to COLUMN 'REFERENCIA'
    */
    
    @Basic(optional = true)
    @Size(max = 255)
    @Column(name = "REFERENCIA" , length=255, nullable=true)
    private String referencia;
    
    /**
    * The 'CONTACTO' Maps to COLUMN 'CONTACTO'
    */
    
    @Basic(optional = true)
    @Size(max = 64)
    @Column(name = "CONTACTO" , length=64, nullable=true)
    private String contacto;
    
    /**
    * The 'UBICACION LAT' Maps to COLUMN 'UBICACION_LAT'
    */
    
    @Basic(optional = true)
    @Column(name = "UBICACION_LAT" , nullable=true)
    private Double ubicacionLat;
    
    /**
    * The 'UBICACION LON' Maps to COLUMN 'UBICACION_LON'
    */
    
    @Basic(optional = true)
    @Column(name = "UBICACION_LON" , nullable=true)
    private Double ubicacionLon;
    /** 
    * Map the relation to ENTRADA_SALIDA table where has CLIENTE_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientecliente")
    // ENTRADA_SALIDA Well know as EntradaSalida
    private List<EntradaSalida> entradaSalidaThatHasThisClienteclienteList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Cliente() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public String getRfc() { return this.rfc;}
    public void setRfc(String v) { this.rfc = v; }
    
    public String getRazonSocial() { return this.razonSocial;}
    public void setRazonSocial(String v) { this.razonSocial = v; }
    
    public String getNombreEstablecimiento() { return this.nombreEstablecimiento;}
    public void setNombreEstablecimiento(String v) { this.nombreEstablecimiento = v; }
    
    public String getDireccionFacturacion() { return this.direccionFacturacion;}
    public void setDireccionFacturacion(String v) { this.direccionFacturacion = v; }
    
    public String getTelefonos() { return this.telefonos;}
    public void setTelefonos(String v) { this.telefonos = v; }
    
    public String getBanco() { return this.banco;}
    public void setBanco(String v) { this.banco = v; }
    
    public String getNumCuenta() { return this.numCuenta;}
    public void setNumCuenta(String v) { this.numCuenta = v; }
    
    public String getEmail() { return this.email;}
    public void setEmail(String v) { this.email = v; }
    
    public String getReferencia() { return this.referencia;}
    public void setReferencia(String v) { this.referencia = v; }
    
    public String getContacto() { return this.contacto;}
    public void setContacto(String v) { this.contacto = v; }
    
    public Double getUbicacionLat() { return this.ubicacionLat;}
    public void setUbicacionLat(Double v) { this.ubicacionLat = v; }
    
    public Double getUbicacionLon() { return this.ubicacionLon;}
    public void setUbicacionLon(Double v) { this.ubicacionLon = v; }
    
    // O2M <*>    
    public List<EntradaSalida> getEntradaSalidaThatHasThisClienteclienteList(){ return this.entradaSalidaThatHasThisClienteclienteList; }
    public void setEntradaSalidaThatHasThisClienteclienteList(List<EntradaSalida> v){ this.entradaSalidaThatHasThisClienteclienteList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(rfc).hashCode();
		hash += String.valueOf(razonSocial).hashCode();
		hash += String.valueOf(nombreEstablecimiento).hashCode();
		hash += String.valueOf(direccionFacturacion).hashCode();
		hash += String.valueOf(telefonos).hashCode();
		hash += String.valueOf(banco).hashCode();
		hash += String.valueOf(numCuenta).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(referencia).hashCode();
		hash += String.valueOf(contacto).hashCode();
		hash += String.valueOf(ubicacionLat).hashCode();
		hash += String.valueOf(ubicacionLon).hashCode();
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
        if (!(o instanceof Cliente)) {
            return false;
        }		
		Cliente other = (Cliente ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.rfc, other.rfc)) { return false; }		
		if (!Objects.equals(this.razonSocial, other.razonSocial)) { return false; }		
		if (!Objects.equals(this.nombreEstablecimiento, other.nombreEstablecimiento)) { return false; }		
		if (!Objects.equals(this.direccionFacturacion, other.direccionFacturacion)) { return false; }		
		if (!Objects.equals(this.telefonos, other.telefonos)) { return false; }		
		if (!Objects.equals(this.banco, other.banco)) { return false; }		
		if (!Objects.equals(this.numCuenta, other.numCuenta)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.referencia, other.referencia)) { return false; }		
		if (!Objects.equals(this.contacto, other.contacto)) { return false; }		
		if (!Objects.equals(this.ubicacionLat, other.ubicacionLat)) { return false; }		
		if (!Objects.equals(this.ubicacionLon, other.ubicacionLon)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Cliente{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("rfc" ).append("=").append(rfc).append("|");
		sb.append("razonSocial" ).append("=").append(razonSocial).append("|");
		sb.append("nombreEstablecimiento" ).append("=").append(nombreEstablecimiento).append("|");
		sb.append("direccionFacturacion" ).append("=").append(direccionFacturacion).append("|");
		sb.append("telefonos" ).append("=").append(telefonos).append("|");
		sb.append("banco" ).append("=").append(banco).append("|");
		sb.append("numCuenta" ).append("=").append(numCuenta).append("|");
		sb.append("email" ).append("=").append(email).append("|");
		sb.append("referencia" ).append("=").append(referencia).append("|");
		sb.append("contacto" ).append("=").append(contacto).append("|");
		sb.append("ubicacionLat" ).append("=").append(ubicacionLat).append("|");
		sb.append("ubicacionLon" ).append("=").append(ubicacionLon).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
