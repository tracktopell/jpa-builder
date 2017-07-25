package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table MOVIMIENTO_OPERATIVO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class MovimientoOperativoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 81628611;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * motivo
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=motivo
    private String motivo;
    
    /**
    * fecha
    */
    // Simple: PK?false, FK?false, class=java.sql.Timestamp, o=fecha
    private java.sql.Timestamp fecha;
    
    /**
    * sucursal id origen
    */
    // Simple: PK?false, FK?true, class=int, o=sucursalIdOrigen
    private int sucursalIdOrigen;
    
    /**
    * almacen origen
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=almacenOrigen
    private String almacenOrigen;
    
    /**
    * sucursal id destino
    */
    // Simple: PK?false, FK?true, class=int, o=sucursalIdDestino
    private int sucursalIdDestino;
    
    /**
    * almacen destino
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=almacenDestino
    private String almacenDestino;
    
    /**
    * tipo mov
    */
    // Simple: PK?false, FK?false, class=int, o=tipoMov
    private int tipoMov;

    /** 
     * Default Constructor
     */
    public MovimientoOperativoDTO() {
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
    public String getMotivo() {
        return this.motivo;
    }
    public void setMotivo(String v) {
        this.motivo = v;
    }
    public java.sql.Timestamp getFecha() {
        return this.fecha;
    }
    public void setFecha(java.sql.Timestamp v) {
        this.fecha = v;
    }
    public int getSucursalIdOrigen() {
        return this.sucursalIdOrigen;
    }
    public void setSucursalIdOrigen(int v) {
        this.sucursalIdOrigen = v;
    }
    public String getAlmacenOrigen() {
        return this.almacenOrigen;
    }
    public void setAlmacenOrigen(String v) {
        this.almacenOrigen = v;
    }
    public int getSucursalIdDestino() {
        return this.sucursalIdDestino;
    }
    public void setSucursalIdDestino(int v) {
        this.sucursalIdDestino = v;
    }
    public String getAlmacenDestino() {
        return this.almacenDestino;
    }
    public void setAlmacenDestino(String v) {
        this.almacenDestino = v;
    }
    public int getTipoMov() {
        return this.tipoMov;
    }
    public void setTipoMov(int v) {
        this.tipoMov = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(motivo).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(sucursalIdOrigen).hashCode();
		hash += String.valueOf(almacenOrigen).hashCode();
		hash += String.valueOf(sucursalIdDestino).hashCode();
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
        if (!(o instanceof MovimientoOperativoDTO)) {
            return false;
        }		
		MovimientoOperativoDTO  other = (MovimientoOperativoDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.motivo, other.motivo)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.sucursalIdOrigen, other.sucursalIdOrigen)) { return false; }		
		if (!Objects.equals(this.almacenOrigen, other.almacenOrigen)) { return false; }		
		if (!Objects.equals(this.sucursalIdDestino, other.sucursalIdDestino)) { return false; }		
		if (!Objects.equals(this.almacenDestino, other.almacenDestino)) { return false; }		
		if (!Objects.equals(this.tipoMov, other.tipoMov)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MovimientoOperativoDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("motivo" ).append("=").append(motivo).append("|");
		sb.append("fecha" ).append("=").append(fecha).append("|");
		sb.append("sucursalIdOrigen" ).append("=").append(sucursalIdOrigen).append("|");
		sb.append("almacenOrigen" ).append("=").append(almacenOrigen).append("|");
		sb.append("sucursalIdDestino" ).append("=").append(sucursalIdDestino).append("|");
		sb.append("almacenDestino" ).append("=").append(almacenDestino).append("|");
		sb.append("tipoMov" ).append("=").append(tipoMov).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
