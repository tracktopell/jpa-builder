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
 * Class for mapping JPA Entity of Table OFERTA_PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "OFERTA_PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "OfertaProducto.findAll", query = "SELECT o FROM OfertaProducto o")
    , @NamedQuery(name = "OfertaProducto.countAll", query = "SELECT COUNT(o) FROM OfertaProducto o")
    , @NamedQuery(name = "OfertaProducto.findById", query = "SELECT o FROM OfertaProducto o WHERE o.id = :id")
    , @NamedQuery(name = "OfertaProducto.findByproductoproducto", query = "SELECT o FROM OfertaProducto o WHERE o.productoproducto = :productoproducto")
    , @NamedQuery(name = "OfertaProducto.findBysucursalsucursal", query = "SELECT o FROM OfertaProducto o WHERE o.sucursalsucursal = :sucursalsucursal")
    , @NamedQuery(name = "OfertaProducto.findBypromocionpromocion", query = "SELECT o FROM OfertaProducto o WHERE o.promocionpromocion = :promocionpromocion")
    , @NamedQuery(name = "OfertaProducto.findByFechaInicial", query = "SELECT o FROM OfertaProducto o WHERE o.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "OfertaProducto.findByFechaFinal", query = "SELECT o FROM OfertaProducto o WHERE o.fechaFinal = :fechaFinal")
})
public class OfertaProducto implements java.io.Serializable {
    private static final long serialVersionUID = 1096979270;
    
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
    * The 'PRODUCTO CODIGO BARRAS' Maps to COLUMN 'PRODUCTO_CODIGO_BARRAS'
    */
    
    @JoinColumn(name = "PRODUCTO_CODIGO_BARRAS" , referencedColumnName = "CODIGO_BARRAS")
    @ManyToOne(optional = false)
    private Producto productoproducto;
    
    /**
    * The 'SUCURSAL ID' Maps to COLUMN 'SUCURSAL_ID'
    */
    
    @JoinColumn(name = "SUCURSAL_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursalsucursal;
    
    /**
    * The 'PROMOCION ID' Maps to COLUMN 'PROMOCION_ID'
    */
    
    @JoinColumn(name = "PROMOCION_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Promocion promocionpromocion;
    
    /**
    * The 'FECHA INICIAL' Maps to COLUMN 'FECHA_INICIAL'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "FECHA_INICIAL" , nullable=false)
    private java.sql.Date fechaInicial;
    
    /**
    * The 'FECHA FINAL' Maps to COLUMN 'FECHA_FINAL'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "FECHA_FINAL" , nullable=false)
    private java.sql.Date fechaFinal;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public OfertaProducto() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public Producto getProductoproducto(){ return this.productoproducto ; }
    public void setProductoproducto(Producto x){ this.productoproducto = x; }
    
    public Sucursal getSucursalsucursal(){ return this.sucursalsucursal ; }
    public void setSucursalsucursal(Sucursal x){ this.sucursalsucursal = x; }
    
    public Promocion getPromocionpromocion(){ return this.promocionpromocion ; }
    public void setPromocionpromocion(Promocion x){ this.promocionpromocion = x; }
    
    public java.sql.Date getFechaInicial() { return this.fechaInicial;}
    public void setFechaInicial(java.sql.Date v) { this.fechaInicial = v; }
    
    public java.sql.Date getFechaFinal() { return this.fechaFinal;}
    public void setFechaFinal(java.sql.Date v) { this.fechaFinal = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(productoproducto).hashCode();
		hash += String.valueOf(sucursalsucursal).hashCode();
		hash += String.valueOf(promocionpromocion).hashCode();
		hash += String.valueOf(fechaInicial).hashCode();
		hash += String.valueOf(fechaFinal).hashCode();
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
        if (!(o instanceof OfertaProducto)) {
            return false;
        }		
		OfertaProducto other = (OfertaProducto ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.productoproducto, other.productoproducto)) { return false; }		
		if (!Objects.equals(this.sucursalsucursal, other.sucursalsucursal)) { return false; }		
		if (!Objects.equals(this.promocionpromocion, other.promocionpromocion)) { return false; }		
		if (!Objects.equals(this.fechaInicial, other.fechaInicial)) { return false; }		
		if (!Objects.equals(this.fechaFinal, other.fechaFinal)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("OfertaProducto{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("productoproducto" ).append("=").append(productoproducto).append("|");
		sb.append("sucursalsucursal" ).append("=").append(sucursalsucursal).append("|");
		sb.append("promocionpromocion" ).append("=").append(promocionpromocion).append("|");
		sb.append("fechaInicial" ).append("=").append(fechaInicial).append("|");
		sb.append("fechaFinal" ).append("=").append(fechaFinal).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
