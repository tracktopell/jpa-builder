package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table ENTRDA_SALIDA_ESTADO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class EntrdaSalidaEstadoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 135721597;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * entrada salida id
    */
    // Simple: PK?false, FK?true, class=int, o=entradaSalidaId
    private int entradaSalidaId;
    
    /**
    * fecha
    */
    // Simple: PK?false, FK?false, class=java.lang.Integer, o=fecha
    private Integer fecha;
    
    /**
    * comentarios
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=comentarios
    private String comentarios;
    
    /**
    * estado id
    */
    // Simple: PK?false, FK?true, class=int, o=estadoId
    private int estadoId;
    
    /**
    * usuario id
    */
    // Simple: PK?false, FK?true, class=int, o=usuarioId
    private int usuarioId;

    /** 
     * Default Constructor
     */
    public EntrdaSalidaEstadoDTO() {
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
    public int getEntradaSalidaId() {
        return this.entradaSalidaId;
    }
    public void setEntradaSalidaId(int v) {
        this.entradaSalidaId = v;
    }
    public Integer getFecha() {
        return this.fecha;
    }
    public void setFecha(Integer v) {
        this.fecha = v;
    }
    public String getComentarios() {
        return this.comentarios;
    }
    public void setComentarios(String v) {
        this.comentarios = v;
    }
    public int getEstadoId() {
        return this.estadoId;
    }
    public void setEstadoId(int v) {
        this.estadoId = v;
    }
    public int getUsuarioId() {
        return this.usuarioId;
    }
    public void setUsuarioId(int v) {
        this.usuarioId = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(entradaSalidaId).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(comentarios).hashCode();
		hash += String.valueOf(estadoId).hashCode();
		hash += String.valueOf(usuarioId).hashCode();
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
        if (!(o instanceof EntrdaSalidaEstadoDTO)) {
            return false;
        }		
		EntrdaSalidaEstadoDTO  other = (EntrdaSalidaEstadoDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.entradaSalidaId, other.entradaSalidaId)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.comentarios, other.comentarios)) { return false; }		
		if (!Objects.equals(this.estadoId, other.estadoId)) { return false; }		
		if (!Objects.equals(this.usuarioId, other.usuarioId)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("EntrdaSalidaEstadoDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("entradaSalidaId" ).append("=").append(entradaSalidaId).append("|");
		sb.append("fecha" ).append("=").append(fecha).append("|");
		sb.append("comentarios" ).append("=").append(comentarios).append("|");
		sb.append("estadoId" ).append("=").append(estadoId).append("|");
		sb.append("usuarioId" ).append("=").append(usuarioId).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
