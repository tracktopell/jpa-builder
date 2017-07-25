package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table PRODUCTO_SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class ProductoSucursalDTO implements java.io.Serializable {
    private static final long serialVersionUID = 951007336;

    
    /**
    * producto sucursal p k
    */
    // productoSucursalPK EmbedableColumn ID References: FKs {[[SUCURSAL_ID] integer(10,0), [PRODUCTO_CODIGO_BARRAS] varchar(128,0)]}
    
    /**
    * cantidad 1ra
    */
    // Simple: PK?false, FK?false, class=int, o=cantidad1ra
    private int cantidad1ra;
    
    /**
    * precio 1ra
    */
    // Simple: PK?false, FK?false, class=double, o=precio1ra
    private double precio1ra;
    
    /**
    * cantidad opo
    */
    // Simple: PK?false, FK?false, class=int, o=cantidadOpo
    private int cantidadOpo;
    
    /**
    * precio opo
    */
    // Simple: PK?false, FK?false, class=double, o=precioOpo
    private double precioOpo;
    
    /**
    * cantidad reg
    */
    // Simple: PK?false, FK?false, class=int, o=cantidadReg
    private int cantidadReg;
    
    /**
    * precio reg
    */
    // Simple: PK?false, FK?false, class=double, o=precioReg
    private double precioReg;
    
    /**
    * producto codigo barras
    */
    // Simple: PK?true, FK?true, class=java.lang.String, o=productoCodigoBarras
    private String productoCodigoBarras;
    
    /**
    * sucursal id
    */
    // Simple: PK?true, FK?true, class=java.lang.Integer, o=sucursalId
    private Integer sucursalId;

    /** 
     * Default Constructor
     */
    public ProductoSucursalDTO() {
    }

    /**
     * Getters and Setters
     */
    // productoSucursalPK EmbedableColumn ID References: FKs {[[SUCURSAL_ID] integer(10,0), [PRODUCTO_CODIGO_BARRAS] varchar(128,0)]}
    // productoSucursalPK EmbedableColumn ID References: FKs {[[SUCURSAL_ID] integer(10,0), [PRODUCTO_CODIGO_BARRAS] varchar(128,0)]}
    public int getCantidad1ra() {
        return this.cantidad1ra;
    }
    public void setCantidad1ra(int v) {
        this.cantidad1ra = v;
    }
    public double getPrecio1ra() {
        return this.precio1ra;
    }
    public void setPrecio1ra(double v) {
        this.precio1ra = v;
    }
    public int getCantidadOpo() {
        return this.cantidadOpo;
    }
    public void setCantidadOpo(int v) {
        this.cantidadOpo = v;
    }
    public double getPrecioOpo() {
        return this.precioOpo;
    }
    public void setPrecioOpo(double v) {
        this.precioOpo = v;
    }
    public int getCantidadReg() {
        return this.cantidadReg;
    }
    public void setCantidadReg(int v) {
        this.cantidadReg = v;
    }
    public double getPrecioReg() {
        return this.precioReg;
    }
    public void setPrecioReg(double v) {
        this.precioReg = v;
    }
    public String getProductoCodigoBarras() {
        return this.productoCodigoBarras;
    }
    public void setProductoCodigoBarras(String v) {
        this.productoCodigoBarras = v;
    }
    public Integer getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(Integer v) {
        this.sucursalId = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(cantidad1ra).hashCode();
		hash += String.valueOf(precio1ra).hashCode();
		hash += String.valueOf(cantidadOpo).hashCode();
		hash += String.valueOf(precioOpo).hashCode();
		hash += String.valueOf(cantidadReg).hashCode();
		hash += String.valueOf(precioReg).hashCode();
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
        if (!(o instanceof ProductoSucursalDTO)) {
            return false;
        }		
		ProductoSucursalDTO  other = (ProductoSucursalDTO ) o;
		if (!Objects.equals(this.cantidad1ra, other.cantidad1ra)) { return false; }		
		if (!Objects.equals(this.precio1ra, other.precio1ra)) { return false; }		
		if (!Objects.equals(this.cantidadOpo, other.cantidadOpo)) { return false; }		
		if (!Objects.equals(this.precioOpo, other.precioOpo)) { return false; }		
		if (!Objects.equals(this.cantidadReg, other.cantidadReg)) { return false; }		
		if (!Objects.equals(this.precioReg, other.precioReg)) { return false; }		
		if (!Objects.equals(this.productoCodigoBarras, other.productoCodigoBarras)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ProductoSucursalDTO{");
		sb.append("cantidad1ra" ).append("=").append(cantidad1ra).append("|");
		sb.append("precio1ra" ).append("=").append(precio1ra).append("|");
		sb.append("cantidadOpo" ).append("=").append(cantidadOpo).append("|");
		sb.append("precioOpo" ).append("=").append(precioOpo).append("|");
		sb.append("cantidadReg" ).append("=").append(cantidadReg).append("|");
		sb.append("precioReg" ).append("=").append(precioReg).append("|");
		sb.append("productoCodigoBarras" ).append("=").append(productoCodigoBarras).append("|");
		sb.append("sucursalId" ).append("=").append(sucursalId).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
