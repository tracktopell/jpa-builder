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
 * Class for mapping JPA Embedable PK of Table PRODUCTO_SUCURSAL_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Embeddable

@XmlRootElement
public class ProductoSucursalPK implements java.io.Serializable {
    private static final long serialVersionUID = 1880587981;
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 128)
    @Column(name = "PRODUCTO_CODIGO_BARRAS", nullable= false)
    private String productoCodigoBarras;
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "SUCURSAL_ID", nullable= false)
    private Integer sucursalId;

    /** 
     * Default Constructor
     */
    public ProductoSucursalPK() {
    }
    
    /**
     * Getters and Setters
     */
    public String getProductoCodigoBarras() { return this.productoCodigoBarras;}
    public void setProductoCodigoBarras(String v) { this.productoCodigoBarras = v; }
    
    public Integer getSucursalId() { return this.sucursalId;}
    public void setSucursalId(Integer v) { this.sucursalId = v; }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(productoCodigoBarras).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
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
        if (!(o instanceof ProductoSucursalPK)) {
            return false;
        }		
		ProductoSucursalPK other = (ProductoSucursalPK ) o;
		if (!Objects.equals(this.productoCodigoBarras, other.productoCodigoBarras)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ProductoSucursalPK{");
		sb.append("productoCodigoBarras" ).append("=").append(productoCodigoBarras).append("|");
		sb.append("sucursalId" ).append("=").append(sucursalId).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
