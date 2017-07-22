package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table OFERTA_PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class OfertaProductoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1096979270;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * producto codigo barras
    */
    // Simple: PK?false, FK?true, class=java.lang.String, o=productoCodigoBarras
    private String productoCodigoBarras;
    
    /**
    * sucursal id
    */
    // Simple: PK?false, FK?true, class=int, o=sucursalId
    private int sucursalId;
    
    /**
    * promocion id
    */
    // Simple: PK?false, FK?true, class=int, o=promocionId
    private int promocionId;
    
    /**
    * fecha inicial
    */
    // Simple: PK?false, FK?false, class=java.sql.Date, o=fechaInicial
    private java.sql.Date fechaInicial;
    
    /**
    * fecha final
    */
    // Simple: PK?false, FK?false, class=java.sql.Date, o=fechaFinal
    private java.sql.Date fechaFinal;

    /** 
     * Default Constructor
     */
    public OfertaProductoDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer v) {
        this.id = v;
    }
    public String getProductoCodigoBarras() {
        return this.productoCodigoBarras;
    }
    public void setProductoCodigoBarras(String v) {
        this.productoCodigoBarras = v;
    }
    public int getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(int v) {
        this.sucursalId = v;
    }
    public int getPromocionId() {
        return this.promocionId;
    }
    public void setPromocionId(int v) {
        this.promocionId = v;
    }
    public java.sql.Date getFechaInicial() {
        return this.fechaInicial;
    }
    public void setFechaInicial(java.sql.Date v) {
        this.fechaInicial = v;
    }
    public java.sql.Date getFechaFinal() {
        return this.fechaFinal;
    }
    public void setFechaFinal(java.sql.Date v) {
        this.fechaFinal = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(productoCodigoBarras).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
		hash += String.valueOf(promocionId).hashCode();
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
        if (!(o instanceof OfertaProductoDTO)) {
            return false;
        }		
		OfertaProductoDTO  other = (OfertaProductoDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.productoCodigoBarras, other.productoCodigoBarras)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
		if (!Objects.equals(this.promocionId, other.promocionId)) { return false; }		
		if (!Objects.equals(this.fechaInicial, other.fechaInicial)) { return false; }		
		if (!Objects.equals(this.fechaFinal, other.fechaFinal)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("OfertaProductoDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("productoCodigoBarras" ).append("=").append(productoCodigoBarras).append("|");
		sb.append("sucursalId" ).append("=").append(sucursalId).append("|");
		sb.append("promocionId" ).append("=").append(promocionId).append("|");
		sb.append("fechaInicial" ).append("=").append(fechaInicial).append("|");
		sb.append("fechaFinal" ).append("=").append(fechaFinal).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
