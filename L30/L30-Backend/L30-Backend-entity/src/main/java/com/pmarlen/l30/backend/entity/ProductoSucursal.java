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
 * Class for mapping JPA Entity of Table PRODUCTO_SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "PRODUCTO_SUCURSAL")
@NamedQueries({
    @NamedQuery(name = "ProductoSucursal.findAll", query = "SELECT p FROM ProductoSucursal p")
    , @NamedQuery(name = "ProductoSucursal.countAll", query = "SELECT COUNT(p) FROM ProductoSucursal p")
    , @NamedQuery(name = "ProductoSucursal.findByCantidad1ra", query = "SELECT p FROM ProductoSucursal p WHERE p.cantidad1ra = :cantidad1ra")
    , @NamedQuery(name = "ProductoSucursal.findByPrecio1ra", query = "SELECT p FROM ProductoSucursal p WHERE p.precio1ra = :precio1ra")
    , @NamedQuery(name = "ProductoSucursal.findByCantidadOpo", query = "SELECT p FROM ProductoSucursal p WHERE p.cantidadOpo = :cantidadOpo")
    , @NamedQuery(name = "ProductoSucursal.findByPrecioOpo", query = "SELECT p FROM ProductoSucursal p WHERE p.precioOpo = :precioOpo")
    , @NamedQuery(name = "ProductoSucursal.findByCantidadReg", query = "SELECT p FROM ProductoSucursal p WHERE p.cantidadReg = :cantidadReg")
    , @NamedQuery(name = "ProductoSucursal.findByPrecioReg", query = "SELECT p FROM ProductoSucursal p WHERE p.precioReg = :precioReg")
    , @NamedQuery(name = "ProductoSucursal.findByproductoproducto", query = "SELECT p FROM ProductoSucursal p WHERE p.productoproducto = :productoproducto")
    , @NamedQuery(name = "ProductoSucursal.findBysucursalsucursal", query = "SELECT p FROM ProductoSucursal p WHERE p.sucursalsucursal = :sucursalsucursal")
    , @NamedQuery(name = "ProductoSucursal.findByProductoSucursalPK", query = "SELECT p FROM ProductoSucursal p WHERE p.productoSucursalPK = :productoSucursalPK")
})
public class ProductoSucursal implements java.io.Serializable {
    private static final long serialVersionUID = 951007336;
    
    /**
    * The 'CANTIDAD 1RA' Maps to COLUMN 'CANTIDAD_1RA'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "CANTIDAD_1RA" , nullable=false)
    private int cantidad1ra;
    
    /**
    * The 'PRECIO 1RA' Maps to COLUMN 'PRECIO_1RA'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PRECIO_1RA" , nullable=false)
    private double precio1ra;
    
    /**
    * The 'CANTIDAD OPO' Maps to COLUMN 'CANTIDAD_OPO'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "CANTIDAD_OPO" , nullable=false)
    private int cantidadOpo;
    
    /**
    * The 'PRECIO OPO' Maps to COLUMN 'PRECIO_OPO'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PRECIO_OPO" , nullable=false)
    private double precioOpo;
    
    /**
    * The 'CANTIDAD REG' Maps to COLUMN 'CANTIDAD_REG'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "CANTIDAD_REG" , nullable=false)
    private int cantidadReg;
    
    /**
    * The 'PRECIO REG' Maps to COLUMN 'PRECIO_REG'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "PRECIO_REG" , nullable=false)
    private double precioReg;
    
    /**
    * The 'PRODUCTO CODIGO BARRAS' Maps to COLUMN 'PRODUCTO_CODIGO_BARRAS'
    */
    
    @JoinColumn(name = "PRODUCTO_CODIGO_BARRAS" , referencedColumnName = "CODIGO_BARRAS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto productoproducto;
    
    /**
    * The 'SUCURSAL ID' Maps to COLUMN 'SUCURSAL_ID'
    */
    
    @JoinColumn(name = "SUCURSAL_ID" , referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sucursal sucursalsucursal;
    
    /**
    * The 'PRODUCTO SUCURSAL P K' Maps to COLUMN 'PRODUCTO_SUCURSAL_P_K'
    */
    
    @EmbeddedId
    private ProductoSucursalPK productoSucursalPK;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public ProductoSucursal() {
    }
    
    /**
     * Getters and Setters
     */
    public int getCantidad1ra() { return this.cantidad1ra;}
    public void setCantidad1ra(int v) { this.cantidad1ra = v; }
    
    public double getPrecio1ra() { return this.precio1ra;}
    public void setPrecio1ra(double v) { this.precio1ra = v; }
    
    public int getCantidadOpo() { return this.cantidadOpo;}
    public void setCantidadOpo(int v) { this.cantidadOpo = v; }
    
    public double getPrecioOpo() { return this.precioOpo;}
    public void setPrecioOpo(double v) { this.precioOpo = v; }
    
    public int getCantidadReg() { return this.cantidadReg;}
    public void setCantidadReg(int v) { this.cantidadReg = v; }
    
    public double getPrecioReg() { return this.precioReg;}
    public void setPrecioReg(double v) { this.precioReg = v; }
    
    public Producto getProductoproducto(){ return this.productoproducto ; }
    public void setProductoproducto(Producto x){ this.productoproducto = x; }
    
    public Sucursal getSucursalsucursal(){ return this.sucursalsucursal ; }
    public void setSucursalsucursal(Sucursal x){ this.sucursalsucursal = x; }
    
    public ProductoSucursalPK getProductoSucursalPK() { return this.productoSucursalPK;}
    public void setProductoSucursalPK(ProductoSucursalPK v) { this.productoSucursalPK = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(cantidad1ra).hashCode();
		hash += String.valueOf(precio1ra).hashCode();
		hash += String.valueOf(cantidadOpo).hashCode();
		hash += String.valueOf(precioOpo).hashCode();
		hash += String.valueOf(cantidadReg).hashCode();
		hash += String.valueOf(precioReg).hashCode();
		hash += String.valueOf(productoproducto).hashCode();
		hash += String.valueOf(sucursalsucursal).hashCode();
		hash += String.valueOf(productoSucursalPK).hashCode();
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
        if (!(o instanceof ProductoSucursal)) {
            return false;
        }		
		ProductoSucursal other = (ProductoSucursal ) o;
		if (!Objects.equals(this.cantidad1ra, other.cantidad1ra)) { return false; }		
		if (!Objects.equals(this.precio1ra, other.precio1ra)) { return false; }		
		if (!Objects.equals(this.cantidadOpo, other.cantidadOpo)) { return false; }		
		if (!Objects.equals(this.precioOpo, other.precioOpo)) { return false; }		
		if (!Objects.equals(this.cantidadReg, other.cantidadReg)) { return false; }		
		if (!Objects.equals(this.precioReg, other.precioReg)) { return false; }		
		if (!Objects.equals(this.productoproducto, other.productoproducto)) { return false; }		
		if (!Objects.equals(this.sucursalsucursal, other.sucursalsucursal)) { return false; }		
		if (!Objects.equals(this.productoSucursalPK, other.productoSucursalPK)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ProductoSucursal{");
		sb.append("cantidad1ra" ).append("=").append(cantidad1ra).append("|");
		sb.append("precio1ra" ).append("=").append(precio1ra).append("|");
		sb.append("cantidadOpo" ).append("=").append(cantidadOpo).append("|");
		sb.append("precioOpo" ).append("=").append(precioOpo).append("|");
		sb.append("cantidadReg" ).append("=").append(cantidadReg).append("|");
		sb.append("precioReg" ).append("=").append(precioReg).append("|");
		sb.append("productoproducto" ).append("=").append(productoproducto).append("|");
		sb.append("sucursalsucursal" ).append("=").append(sucursalsucursal).append("|");
		sb.append("productoSucursalPK" ).append("=").append(productoSucursalPK).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
