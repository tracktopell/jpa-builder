package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

public class SucursalDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2003749087;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * tipo
    */
    // Simple: PK?false, FK?false, class=int, o=tipo
    private int tipo;
    
    /**
    * clave
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=clave
    private String clave;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * direccion
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=direccion
    private String direccion;
    
    /**
    * telefonos
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=telefonos
    private String telefonos;
    
    /**
    * descuento myoreo habilitado
    */
    // Simple: PK?false, FK?false, class=int, o=descuentoMyoreoHabilitado
    private int descuentoMyoreoHabilitado;
    
    /**
    * venta reg habilitado
    */
    // Simple: PK?false, FK?false, class=int, o=ventaRegHabilitado
    private int ventaRegHabilitado;
    
    /**
    * venta opo
    */
    // Simple: PK?false, FK?false, class=int, o=ventaOpo
    private int ventaOpo;

    /** 
     * Default Constructor
     */
    public SucursalDTO() {
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
    public int getTipo() {
        return this.tipo;
    }
    public void setTipo(int v) {
        this.tipo = v;
    }
    public String getClave() {
        return this.clave;
    }
    public void setClave(String v) {
        this.clave = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public void setDireccion(String v) {
        this.direccion = v;
    }
    public String getTelefonos() {
        return this.telefonos;
    }
    public void setTelefonos(String v) {
        this.telefonos = v;
    }
    public int getDescuentoMyoreoHabilitado() {
        return this.descuentoMyoreoHabilitado;
    }
    public void setDescuentoMyoreoHabilitado(int v) {
        this.descuentoMyoreoHabilitado = v;
    }
    public int getVentaRegHabilitado() {
        return this.ventaRegHabilitado;
    }
    public void setVentaRegHabilitado(int v) {
        this.ventaRegHabilitado = v;
    }
    public int getVentaOpo() {
        return this.ventaOpo;
    }
    public void setVentaOpo(int v) {
        this.ventaOpo = v;
    }

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
        if (!(o instanceof SucursalDTO)) {
            return false;
        }		
		SucursalDTO  other = (SucursalDTO ) o;
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

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("SucursalDTO{");
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
