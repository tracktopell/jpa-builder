package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class ProductoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1149319664;

    
    /**
    * codigo barras
    */
    // Simple: PK?true, FK?false, class=java.lang.String, o=codigoBarras
    private String codigoBarras;
    
    /**
    * codigo shcp
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=codigoShcp
    private String codigoShcp;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * industria
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=industria
    private String industria;
    
    /**
    * marca
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=marca
    private String marca;
    
    /**
    * linea
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=linea
    private String linea;
    
    /**
    * presentacion
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=presentacion
    private String presentacion;
    
    /**
    * abrebiatura
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=abrebiatura
    private String abrebiatura;
    
    /**
    * unidades x caja
    */
    // Simple: PK?false, FK?false, class=int, o=unidadesXCaja
    private int unidadesXCaja;
    
    /**
    * contenido
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=contenido
    private String contenido;
    
    /**
    * unidad medida
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=unidadMedida
    private String unidadMedida;
    
    /**
    * unidad empaque
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=unidadEmpaque
    private String unidadEmpaque;
    
    /**
    * costo
    */
    // Simple: PK?false, FK?false, class=double, o=costo
    private double costo;
    
    /**
    * costo venta
    */
    // Simple: PK?false, FK?false, class=java.lang.Double, o=costoVenta
    private Double costoVenta;
    
    /**
    * habilitado
    */
    // Simple: PK?false, FK?false, class=int, o=habilitado
    private int habilitado;
    
    /**
    * poco
    */
    // Simple: PK?false, FK?false, class=java.lang.Integer, o=poco
    private Integer poco;

    /** 
     * Default Constructor
     */
    public ProductoDTO() {
    }

    /**
     * Getters and Setters
     */
    public String getCodigoBarras() {
        return this.codigoBarras;
    }
    public void setCodigoBarras(String v) {
        this.codigoBarras = v;
    }
    public String getCodigoShcp() {
        return this.codigoShcp;
    }
    public void setCodigoShcp(String v) {
        this.codigoShcp = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getIndustria() {
        return this.industria;
    }
    public void setIndustria(String v) {
        this.industria = v;
    }
    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String v) {
        this.marca = v;
    }
    public String getLinea() {
        return this.linea;
    }
    public void setLinea(String v) {
        this.linea = v;
    }
    public String getPresentacion() {
        return this.presentacion;
    }
    public void setPresentacion(String v) {
        this.presentacion = v;
    }
    public String getAbrebiatura() {
        return this.abrebiatura;
    }
    public void setAbrebiatura(String v) {
        this.abrebiatura = v;
    }
    public int getUnidadesXCaja() {
        return this.unidadesXCaja;
    }
    public void setUnidadesXCaja(int v) {
        this.unidadesXCaja = v;
    }
    public String getContenido() {
        return this.contenido;
    }
    public void setContenido(String v) {
        this.contenido = v;
    }
    public String getUnidadMedida() {
        return this.unidadMedida;
    }
    public void setUnidadMedida(String v) {
        this.unidadMedida = v;
    }
    public String getUnidadEmpaque() {
        return this.unidadEmpaque;
    }
    public void setUnidadEmpaque(String v) {
        this.unidadEmpaque = v;
    }
    public double getCosto() {
        return this.costo;
    }
    public void setCosto(double v) {
        this.costo = v;
    }
    public Double getCostoVenta() {
        return this.costoVenta;
    }
    public void setCostoVenta(Double v) {
        this.costoVenta = v;
    }
    public int getHabilitado() {
        return this.habilitado;
    }
    public void setHabilitado(int v) {
        this.habilitado = v;
    }
    public Integer getPoco() {
        return this.poco;
    }
    public void setPoco(Integer v) {
        this.poco = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(codigoBarras).hashCode();
		hash += String.valueOf(codigoShcp).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(industria).hashCode();
		hash += String.valueOf(marca).hashCode();
		hash += String.valueOf(linea).hashCode();
		hash += String.valueOf(presentacion).hashCode();
		hash += String.valueOf(abrebiatura).hashCode();
		hash += String.valueOf(unidadesXCaja).hashCode();
		hash += String.valueOf(contenido).hashCode();
		hash += String.valueOf(unidadMedida).hashCode();
		hash += String.valueOf(unidadEmpaque).hashCode();
		hash += String.valueOf(costo).hashCode();
		hash += String.valueOf(costoVenta).hashCode();
		hash += String.valueOf(habilitado).hashCode();
		hash += String.valueOf(poco).hashCode();
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
        if (!(o instanceof ProductoDTO)) {
            return false;
        }		
		ProductoDTO  other = (ProductoDTO ) o;
		if (!Objects.equals(this.codigoBarras, other.codigoBarras)) { return false; }		
		if (!Objects.equals(this.codigoShcp, other.codigoShcp)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.industria, other.industria)) { return false; }		
		if (!Objects.equals(this.marca, other.marca)) { return false; }		
		if (!Objects.equals(this.linea, other.linea)) { return false; }		
		if (!Objects.equals(this.presentacion, other.presentacion)) { return false; }		
		if (!Objects.equals(this.abrebiatura, other.abrebiatura)) { return false; }		
		if (!Objects.equals(this.unidadesXCaja, other.unidadesXCaja)) { return false; }		
		if (!Objects.equals(this.contenido, other.contenido)) { return false; }		
		if (!Objects.equals(this.unidadMedida, other.unidadMedida)) { return false; }		
		if (!Objects.equals(this.unidadEmpaque, other.unidadEmpaque)) { return false; }		
		if (!Objects.equals(this.costo, other.costo)) { return false; }		
		if (!Objects.equals(this.costoVenta, other.costoVenta)) { return false; }		
		if (!Objects.equals(this.habilitado, other.habilitado)) { return false; }		
		if (!Objects.equals(this.poco, other.poco)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ProductoDTO{");
		sb.append("codigoBarras" ).append("=").append(codigoBarras).append("|");
		sb.append("codigoShcp" ).append("=").append(codigoShcp).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("industria" ).append("=").append(industria).append("|");
		sb.append("marca" ).append("=").append(marca).append("|");
		sb.append("linea" ).append("=").append(linea).append("|");
		sb.append("presentacion" ).append("=").append(presentacion).append("|");
		sb.append("abrebiatura" ).append("=").append(abrebiatura).append("|");
		sb.append("unidadesXCaja" ).append("=").append(unidadesXCaja).append("|");
		sb.append("contenido" ).append("=").append(contenido).append("|");
		sb.append("unidadMedida" ).append("=").append(unidadMedida).append("|");
		sb.append("unidadEmpaque" ).append("=").append(unidadEmpaque).append("|");
		sb.append("costo" ).append("=").append(costo).append("|");
		sb.append("costoVenta" ).append("=").append(costoVenta).append("|");
		sb.append("habilitado" ).append("=").append(habilitado).append("|");
		sb.append("poco" ).append("=").append(poco).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
