package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table CORTE_CAJA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class CorteCajaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1927950199;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * sucursal id
    */
    // Simple: PK?false, FK?true, class=int, o=sucursalId
    private int sucursalId;
    
    /**
    * tipo evento
    */
    // Simple: PK?false, FK?false, class=int, o=tipoEvento
    private int tipoEvento;
    
    /**
    * usuario id
    */
    // Simple: PK?false, FK?true, class=int, o=usuarioId
    private int usuarioId;
    
    /**
    * fecha
    */
    // Simple: PK?false, FK?false, class=java.sql.Timestamp, o=fecha
    private java.sql.Timestamp fecha;
    
    /**
    * fecha uap
    */
    // Simple: PK?false, FK?false, class=java.sql.Timestamp, o=fechaUap
    private java.sql.Timestamp fechaUap;
    
    /**
    * saldo inicial
    */
    // Simple: PK?false, FK?false, class=java.lang.Double, o=saldoInicial
    private Double saldoInicial;
    
    /**
    * saldo final
    */
    // Simple: PK?false, FK?false, class=java.lang.Double, o=saldoFinal
    private Double saldoFinal;
    
    /**
    * usuario id autorizo
    */
    // Simple: PK?false, FK?true, class=int, o=usuarioIdAutorizo
    private int usuarioIdAutorizo;
    
    /**
    * comentarios
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=comentarios
    private String comentarios;
    
    /**
    * caja
    */
    // Simple: PK?false, FK?false, class=int, o=caja
    private int caja;

    /** 
     * Default Constructor
     */
    public CorteCajaDTO() {
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
    public int getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(int v) {
        this.sucursalId = v;
    }
    public int getTipoEvento() {
        return this.tipoEvento;
    }
    public void setTipoEvento(int v) {
        this.tipoEvento = v;
    }
    public int getUsuarioId() {
        return this.usuarioId;
    }
    public void setUsuarioId(int v) {
        this.usuarioId = v;
    }
    public java.sql.Timestamp getFecha() {
        return this.fecha;
    }
    public void setFecha(java.sql.Timestamp v) {
        this.fecha = v;
    }
    public java.sql.Timestamp getFechaUap() {
        return this.fechaUap;
    }
    public void setFechaUap(java.sql.Timestamp v) {
        this.fechaUap = v;
    }
    public Double getSaldoInicial() {
        return this.saldoInicial;
    }
    public void setSaldoInicial(Double v) {
        this.saldoInicial = v;
    }
    public Double getSaldoFinal() {
        return this.saldoFinal;
    }
    public void setSaldoFinal(Double v) {
        this.saldoFinal = v;
    }
    public int getUsuarioIdAutorizo() {
        return this.usuarioIdAutorizo;
    }
    public void setUsuarioIdAutorizo(int v) {
        this.usuarioIdAutorizo = v;
    }
    public String getComentarios() {
        return this.comentarios;
    }
    public void setComentarios(String v) {
        this.comentarios = v;
    }
    public int getCaja() {
        return this.caja;
    }
    public void setCaja(int v) {
        this.caja = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
		hash += String.valueOf(tipoEvento).hashCode();
		hash += String.valueOf(usuarioId).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(fechaUap).hashCode();
		hash += String.valueOf(saldoInicial).hashCode();
		hash += String.valueOf(saldoFinal).hashCode();
		hash += String.valueOf(usuarioIdAutorizo).hashCode();
		hash += String.valueOf(comentarios).hashCode();
		hash += String.valueOf(caja).hashCode();
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
        if (!(o instanceof CorteCajaDTO)) {
            return false;
        }		
		CorteCajaDTO  other = (CorteCajaDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
		if (!Objects.equals(this.tipoEvento, other.tipoEvento)) { return false; }		
		if (!Objects.equals(this.usuarioId, other.usuarioId)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.fechaUap, other.fechaUap)) { return false; }		
		if (!Objects.equals(this.saldoInicial, other.saldoInicial)) { return false; }		
		if (!Objects.equals(this.saldoFinal, other.saldoFinal)) { return false; }		
		if (!Objects.equals(this.usuarioIdAutorizo, other.usuarioIdAutorizo)) { return false; }		
		if (!Objects.equals(this.comentarios, other.comentarios)) { return false; }		
		if (!Objects.equals(this.caja, other.caja)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("CorteCajaDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("sucursalId" ).append("=").append(sucursalId).append("|");
		sb.append("tipoEvento" ).append("=").append(tipoEvento).append("|");
		sb.append("usuarioId" ).append("=").append(usuarioId).append("|");
		sb.append("fecha" ).append("=").append(fecha).append("|");
		sb.append("fechaUap" ).append("=").append(fechaUap).append("|");
		sb.append("saldoInicial" ).append("=").append(saldoInicial).append("|");
		sb.append("saldoFinal" ).append("=").append(saldoFinal).append("|");
		sb.append("usuarioIdAutorizo" ).append("=").append(usuarioIdAutorizo).append("|");
		sb.append("comentarios" ).append("=").append(comentarios).append("|");
		sb.append("caja" ).append("=").append(caja).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
