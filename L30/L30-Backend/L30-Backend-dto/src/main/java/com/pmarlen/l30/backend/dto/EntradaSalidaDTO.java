package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table ENTRADA_SALIDA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class EntradaSalidaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 791452441;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * tipo mov
    */
    // Simple: PK?false, FK?false, class=int, o=tipoMov
    private int tipoMov;
    
    /**
    * fecha creo
    */
    // Simple: PK?false, FK?false, class=java.sql.Timestamp, o=fechaCreo
    private java.sql.Timestamp fechaCreo;
    
    /**
    * estado id actual
    */
    // Simple: PK?false, FK?true, class=int, o=estadoIdActual
    private int estadoIdActual;
    
    /**
    * cliente id
    */
    // Simple: PK?false, FK?true, class=int, o=clienteId
    private int clienteId;
    
    /**
    * forma de pago id
    */
    // Simple: PK?false, FK?true, class=int, o=formaDePagoId
    private int formaDePagoId;
    
    /**
    * metodo de pago id
    */
    // Simple: PK?false, FK?true, class=int, o=metodoDePagoId
    private int metodoDePagoId;
    
    /**
    * usuario id creo
    */
    // Simple: PK?false, FK?true, class=int, o=usuarioIdCreo
    private int usuarioIdCreo;
    
    /**
    * usuarioid
    */
    // Simple: PK?false, FK?true, class=int, o=usuarioid
    private int usuarioid;

    /** 
     * Default Constructor
     */
    public EntradaSalidaDTO() {
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
    public int getTipoMov() {
        return this.tipoMov;
    }
    public void setTipoMov(int v) {
        this.tipoMov = v;
    }
    public java.sql.Timestamp getFechaCreo() {
        return this.fechaCreo;
    }
    public void setFechaCreo(java.sql.Timestamp v) {
        this.fechaCreo = v;
    }
    public int getEstadoIdActual() {
        return this.estadoIdActual;
    }
    public void setEstadoIdActual(int v) {
        this.estadoIdActual = v;
    }
    public int getClienteId() {
        return this.clienteId;
    }
    public void setClienteId(int v) {
        this.clienteId = v;
    }
    public int getFormaDePagoId() {
        return this.formaDePagoId;
    }
    public void setFormaDePagoId(int v) {
        this.formaDePagoId = v;
    }
    public int getMetodoDePagoId() {
        return this.metodoDePagoId;
    }
    public void setMetodoDePagoId(int v) {
        this.metodoDePagoId = v;
    }
    public int getUsuarioIdCreo() {
        return this.usuarioIdCreo;
    }
    public void setUsuarioIdCreo(int v) {
        this.usuarioIdCreo = v;
    }
    public int getUsuarioid() {
        return this.usuarioid;
    }
    public void setUsuarioid(int v) {
        this.usuarioid = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(tipoMov).hashCode();
		hash += String.valueOf(fechaCreo).hashCode();
		hash += String.valueOf(estadoIdActual).hashCode();
		hash += String.valueOf(clienteId).hashCode();
		hash += String.valueOf(formaDePagoId).hashCode();
		hash += String.valueOf(metodoDePagoId).hashCode();
		hash += String.valueOf(usuarioIdCreo).hashCode();
		hash += String.valueOf(usuarioid).hashCode();
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
        if (!(o instanceof EntradaSalidaDTO)) {
            return false;
        }		
		EntradaSalidaDTO  other = (EntradaSalidaDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.tipoMov, other.tipoMov)) { return false; }		
		if (!Objects.equals(this.fechaCreo, other.fechaCreo)) { return false; }		
		if (!Objects.equals(this.estadoIdActual, other.estadoIdActual)) { return false; }		
		if (!Objects.equals(this.clienteId, other.clienteId)) { return false; }		
		if (!Objects.equals(this.formaDePagoId, other.formaDePagoId)) { return false; }		
		if (!Objects.equals(this.metodoDePagoId, other.metodoDePagoId)) { return false; }		
		if (!Objects.equals(this.usuarioIdCreo, other.usuarioIdCreo)) { return false; }		
		if (!Objects.equals(this.usuarioid, other.usuarioid)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("EntradaSalidaDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("tipoMov" ).append("=").append(tipoMov).append("|");
		sb.append("fechaCreo" ).append("=").append(fechaCreo).append("|");
		sb.append("estadoIdActual" ).append("=").append(estadoIdActual).append("|");
		sb.append("clienteId" ).append("=").append(clienteId).append("|");
		sb.append("formaDePagoId" ).append("=").append(formaDePagoId).append("|");
		sb.append("metodoDePagoId" ).append("=").append(metodoDePagoId).append("|");
		sb.append("usuarioIdCreo" ).append("=").append(usuarioIdCreo).append("|");
		sb.append("usuarioid" ).append("=").append(usuarioid).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
