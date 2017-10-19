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
 * Class for mapping JPA Entity of Table MOVIMIENTO_OPERATIVO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "MOVIMIENTO_OPERATIVO")
@NamedQueries({
    @NamedQuery(name = "MovimientoOperativo.findAll", query = "SELECT m FROM MovimientoOperativo m")
    , @NamedQuery(name = "MovimientoOperativo.countAll", query = "SELECT COUNT(m) FROM MovimientoOperativo m")
    , @NamedQuery(name = "MovimientoOperativo.findById", query = "SELECT m FROM MovimientoOperativo m WHERE m.id = :id")
    , @NamedQuery(name = "MovimientoOperativo.findByMotivo", query = "SELECT m FROM MovimientoOperativo m WHERE m.motivo = :motivo")
    , @NamedQuery(name = "MovimientoOperativo.findByFecha", query = "SELECT m FROM MovimientoOperativo m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "MovimientoOperativo.findBysucursalsucursalOrigen", query = "SELECT m FROM MovimientoOperativo m WHERE m.sucursalsucursalOrigen = :sucursalsucursalOrigen")
    , @NamedQuery(name = "MovimientoOperativo.findByAlmacenOrigen", query = "SELECT m FROM MovimientoOperativo m WHERE m.almacenOrigen = :almacenOrigen")
    , @NamedQuery(name = "MovimientoOperativo.findBysucursalsucursalDestino", query = "SELECT m FROM MovimientoOperativo m WHERE m.sucursalsucursalDestino = :sucursalsucursalDestino")
    , @NamedQuery(name = "MovimientoOperativo.findByAlmacenDestino", query = "SELECT m FROM MovimientoOperativo m WHERE m.almacenDestino = :almacenDestino")
    , @NamedQuery(name = "MovimientoOperativo.findByTipoMov", query = "SELECT m FROM MovimientoOperativo m WHERE m.tipoMov = :tipoMov")
})
public class MovimientoOperativo implements java.io.Serializable {
    private static final long serialVersionUID = 81628611;
    
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
    * The 'MOTIVO' Maps to COLUMN 'MOTIVO'
    */
    
    @Basic(optional = true)
    //@Size(max = 128)
    @Column(name = "MOTIVO" , length=128, nullable=true)
    private String motivo;
    
    /**
    * The 'FECHA' Maps to COLUMN 'FECHA'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "FECHA" , nullable=false)
    private java.sql.Timestamp fecha;
    
    /**
    * The 'SUCURSAL ID ORIGEN' Maps to COLUMN 'SUCURSAL_ID_ORIGEN'
    */
    
    @JoinColumn(name = "SUCURSAL_ID_ORIGEN" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursalsucursalOrigen;
    
    /**
    * The 'ALMACEN ORIGEN' Maps to COLUMN 'ALMACEN_ORIGEN'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 1)
    @Column(name = "ALMACEN_ORIGEN" , length=1, nullable=false)
    private String almacenOrigen;
    
    /**
    * The 'SUCURSAL ID DESTINO' Maps to COLUMN 'SUCURSAL_ID_DESTINO'
    */
    
    @JoinColumn(name = "SUCURSAL_ID_DESTINO" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursalsucursalDestino;
    
    /**
    * The 'ALMACEN DESTINO' Maps to COLUMN 'ALMACEN_DESTINO'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 1)
    @Column(name = "ALMACEN_DESTINO" , length=1, nullable=false)
    private String almacenDestino;
    
    /**
    * The 'TIPO MOV' Maps to COLUMN 'TIPO_MOV'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "TIPO_MOV" , nullable=false)
    private int tipoMov;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public MovimientoOperativo() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public String getMotivo() { return this.motivo;}
    public void setMotivo(String v) { this.motivo = v; }
    
    public java.sql.Timestamp getFecha() { return this.fecha;}
    public void setFecha(java.sql.Timestamp v) { this.fecha = v; }
    
    public Sucursal getSucursalsucursalOrigen(){ return this.sucursalsucursalOrigen ; }
    public void setSucursalsucursalOrigen(Sucursal x){ this.sucursalsucursalOrigen = x; }
    
    public String getAlmacenOrigen() { return this.almacenOrigen;}
    public void setAlmacenOrigen(String v) { this.almacenOrigen = v; }
    
    public Sucursal getSucursalsucursalDestino(){ return this.sucursalsucursalDestino ; }
    public void setSucursalsucursalDestino(Sucursal x){ this.sucursalsucursalDestino = x; }
    
    public String getAlmacenDestino() { return this.almacenDestino;}
    public void setAlmacenDestino(String v) { this.almacenDestino = v; }
    
    public int getTipoMov() { return this.tipoMov;}
    public void setTipoMov(int v) { this.tipoMov = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(motivo).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(sucursalsucursalOrigen).hashCode();
		hash += String.valueOf(almacenOrigen).hashCode();
		hash += String.valueOf(sucursalsucursalDestino).hashCode();
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
        if (!(o instanceof MovimientoOperativo)) {
            return false;
        }		
		MovimientoOperativo other = (MovimientoOperativo ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.motivo, other.motivo)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.sucursalsucursalOrigen, other.sucursalsucursalOrigen)) { return false; }		
		if (!Objects.equals(this.almacenOrigen, other.almacenOrigen)) { return false; }		
		if (!Objects.equals(this.sucursalsucursalDestino, other.sucursalsucursalDestino)) { return false; }		
		if (!Objects.equals(this.almacenDestino, other.almacenDestino)) { return false; }		
		if (!Objects.equals(this.tipoMov, other.tipoMov)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MovimientoOperativo{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("motivo" ).append("=").append(motivo).append("|");
		sb.append("fecha" ).append("=").append(fecha).append("|");
		sb.append("sucursalsucursalOrigen" ).append("=").append(sucursalsucursalOrigen).append("|");
		sb.append("almacenOrigen" ).append("=").append(almacenOrigen).append("|");
		sb.append("sucursalsucursalDestino" ).append("=").append(sucursalsucursalDestino).append("|");
		sb.append("almacenDestino" ).append("=").append(almacenDestino).append("|");
		sb.append("tipoMov" ).append("=").append(tipoMov).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
