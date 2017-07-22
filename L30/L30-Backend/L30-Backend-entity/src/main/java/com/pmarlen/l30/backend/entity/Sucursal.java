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
 * Class for mapping JPA Entity of Table SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

@Entity
@Table(name = "SUCURSAL")
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.countAll", query = "SELECT COUNT(s) FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findById", query = "SELECT s FROM Sucursal s WHERE s.id = :id")
    , @NamedQuery(name = "Sucursal.findByTipo", query = "SELECT s FROM Sucursal s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Sucursal.findByClave", query = "SELECT s FROM Sucursal s WHERE s.clave = :clave")
    , @NamedQuery(name = "Sucursal.findByNombre", query = "SELECT s FROM Sucursal s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Sucursal.findByDireccion", query = "SELECT s FROM Sucursal s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Sucursal.findByTelefonos", query = "SELECT s FROM Sucursal s WHERE s.telefonos = :telefonos")
    , @NamedQuery(name = "Sucursal.findByDescuentoMyoreoHabilitado", query = "SELECT s FROM Sucursal s WHERE s.descuentoMyoreoHabilitado = :descuentoMyoreoHabilitado")
    , @NamedQuery(name = "Sucursal.findByVentaRegHabilitado", query = "SELECT s FROM Sucursal s WHERE s.ventaRegHabilitado = :ventaRegHabilitado")
    , @NamedQuery(name = "Sucursal.findByVentaOpo", query = "SELECT s FROM Sucursal s WHERE s.ventaOpo = :ventaOpo")
})
public class Sucursal implements java.io.Serializable {
    private static final long serialVersionUID = 2003749087;
    
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
    * The 'TIPO' Maps to COLUMN 'TIPO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO" , nullable=false)
    private int tipo;
    
    /**
    * The 'CLAVE' Maps to COLUMN 'CLAVE'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CLAVE" , length=8, nullable=false)
    private String clave;
    
    /**
    * The 'NOMBRE' Maps to COLUMN 'NOMBRE'
    */
    
    @Basic(optional = true)
    @Size(max = 128)
    @Column(name = "NOMBRE" , length=128, nullable=true)
    private String nombre;
    
    /**
    * The 'DIRECCION' Maps to COLUMN 'DIRECCION'
    */
    
    @Basic(optional = true)
    @Size(max = 255)
    @Column(name = "DIRECCION" , length=255, nullable=true)
    private String direccion;
    
    /**
    * The 'TELEFONOS' Maps to COLUMN 'TELEFONOS'
    */
    
    @Basic(optional = true)
    @Size(max = 128)
    @Column(name = "TELEFONOS" , length=128, nullable=true)
    private String telefonos;
    
    /**
    * The 'DESCUENTO MYOREO HABILITADO' Maps to COLUMN 'DESCUENTO_MYOREO_HABILITADO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO_MYOREO_HABILITADO" , nullable=false)
    private int descuentoMyoreoHabilitado;
    
    /**
    * The 'VENTA REG HABILITADO' Maps to COLUMN 'VENTA_REG_HABILITADO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "VENTA_REG_HABILITADO" , nullable=false)
    private int ventaRegHabilitado;
    
    /**
    * The 'VENTA OPO' Maps to COLUMN 'VENTA_OPO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "VENTA_OPO" , nullable=false)
    private int ventaOpo;
    /** 
    * Map the relation to CORTE_CAJA table where has SUCURSAL_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalsucursal")
    // CORTE_CAJA Well know as CorteCaja
    private List<CorteCaja> corteCajaThatHasThisSucursalsucursalList;
    
    /** 
    * Map the relation to CONFIGURACION_PROOVEDOR_CFD table where has SUCURSAL_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalsucursal")
    // CONFIGURACION_PROOVEDOR_CFD Well know as ConfiguracionProovedorCfd
    private List<ConfiguracionProovedorCfd> configuracionProovedorCfdThatHasThisSucursalsucursalList;
    
    /** 
    * Map the relation to OFERTA_PRODUCTO table where has SUCURSAL_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalsucursal")
    // OFERTA_PRODUCTO Well know as OfertaProducto
    private List<OfertaProducto> ofertaProductoThatHasThisSucursalsucursalList;
    
    /** 
    * Map the relation to USUARIO table where has SUCURSAL_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalsucursal")
    // USUARIO Well know as Usuario
    private List<Usuario> usuarioThatHasThisSucursalsucursalList;
    
    /** 
    * Map the relation to MOVIMIENTO_OPERATIVO table where has SUCURSAL_ID_ORIGEN object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalsucursalOrigen")
    // MOVIMIENTO_OPERATIVO Well know as MovimientoOperativo
    private List<MovimientoOperativo> movimientoOperativoThatHasThisSucursalsucursalOrigenList;
    
    /** 
    * Map the relation to MOVIMIENTO_OPERATIVO table where has SUCURSAL_ID_DESTINO object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalsucursalDestino")
    // MOVIMIENTO_OPERATIVO Well know as MovimientoOperativo
    private List<MovimientoOperativo> movimientoOperativoThatHasThisSucursalsucursalDestinoList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Sucursal() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public int getTipo() { return this.tipo;}
    public void setTipo(int v) { this.tipo = v; }
    
    public String getClave() { return this.clave;}
    public void setClave(String v) { this.clave = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getDireccion() { return this.direccion;}
    public void setDireccion(String v) { this.direccion = v; }
    
    public String getTelefonos() { return this.telefonos;}
    public void setTelefonos(String v) { this.telefonos = v; }
    
    public int getDescuentoMyoreoHabilitado() { return this.descuentoMyoreoHabilitado;}
    public void setDescuentoMyoreoHabilitado(int v) { this.descuentoMyoreoHabilitado = v; }
    
    public int getVentaRegHabilitado() { return this.ventaRegHabilitado;}
    public void setVentaRegHabilitado(int v) { this.ventaRegHabilitado = v; }
    
    public int getVentaOpo() { return this.ventaOpo;}
    public void setVentaOpo(int v) { this.ventaOpo = v; }
    
    // O2M <*>    
    public List<CorteCaja> getCorteCajaThatHasThisSucursalsucursalList(){ return this.corteCajaThatHasThisSucursalsucursalList; }
    public void setCorteCajaThatHasThisSucursalsucursalList(List<CorteCaja> v){ this.corteCajaThatHasThisSucursalsucursalList = v; }
    
    public List<ConfiguracionProovedorCfd> getConfiguracionProovedorCfdThatHasThisSucursalsucursalList(){ return this.configuracionProovedorCfdThatHasThisSucursalsucursalList; }
    public void setConfiguracionProovedorCfdThatHasThisSucursalsucursalList(List<ConfiguracionProovedorCfd> v){ this.configuracionProovedorCfdThatHasThisSucursalsucursalList = v; }
    
    public List<OfertaProducto> getOfertaProductoThatHasThisSucursalsucursalList(){ return this.ofertaProductoThatHasThisSucursalsucursalList; }
    public void setOfertaProductoThatHasThisSucursalsucursalList(List<OfertaProducto> v){ this.ofertaProductoThatHasThisSucursalsucursalList = v; }
    
    public List<Usuario> getUsuarioThatHasThisSucursalsucursalList(){ return this.usuarioThatHasThisSucursalsucursalList; }
    public void setUsuarioThatHasThisSucursalsucursalList(List<Usuario> v){ this.usuarioThatHasThisSucursalsucursalList = v; }
    
    public List<MovimientoOperativo> getMovimientoOperativoThatHasThisSucursalsucursalOrigenList(){ return this.movimientoOperativoThatHasThisSucursalsucursalOrigenList; }
    public void setMovimientoOperativoThatHasThisSucursalsucursalOrigenList(List<MovimientoOperativo> v){ this.movimientoOperativoThatHasThisSucursalsucursalOrigenList = v; }
    
    public List<MovimientoOperativo> getMovimientoOperativoThatHasThisSucursalsucursalDestinoList(){ return this.movimientoOperativoThatHasThisSucursalsucursalDestinoList; }
    public void setMovimientoOperativoThatHasThisSucursalsucursalDestinoList(List<MovimientoOperativo> v){ this.movimientoOperativoThatHasThisSucursalsucursalDestinoList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(tipo).hashCode();
		hash += String.valueOf(clave).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(direccion).hashCode();
		hash += String.valueOf(telefonos).hashCode();
		hash += String.valueOf(descuentoMyoreoHabilitado).hashCode();
		hash += String.valueOf(ventaRegHabilitado).hashCode();
		hash += String.valueOf(ventaOpo).hashCode();
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
        if (!(o instanceof Sucursal)) {
            return false;
        }		
		Sucursal other = (Sucursal ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.tipo, other.tipo)) { return false; }		
		if (!Objects.equals(this.clave, other.clave)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.direccion, other.direccion)) { return false; }		
		if (!Objects.equals(this.telefonos, other.telefonos)) { return false; }		
		if (!Objects.equals(this.descuentoMyoreoHabilitado, other.descuentoMyoreoHabilitado)) { return false; }		
		if (!Objects.equals(this.ventaRegHabilitado, other.ventaRegHabilitado)) { return false; }		
		if (!Objects.equals(this.ventaOpo, other.ventaOpo)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Sucursal{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("tipo" ).append("=").append(tipo).append("|");
		sb.append("clave" ).append("=").append(clave).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("direccion" ).append("=").append(direccion).append("|");
		sb.append("telefonos" ).append("=").append(telefonos).append("|");
		sb.append("descuentoMyoreoHabilitado" ).append("=").append(descuentoMyoreoHabilitado).append("|");
		sb.append("ventaRegHabilitado" ).append("=").append(ventaRegHabilitado).append("|");
		sb.append("ventaOpo" ).append("=").append(ventaOpo).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
