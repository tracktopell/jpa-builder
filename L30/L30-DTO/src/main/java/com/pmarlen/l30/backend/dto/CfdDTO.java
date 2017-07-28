package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

public class CfdDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1826771953;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * cfd id origen
    */
    // Simple: PK?false, FK?true, class=java.lang.Integer, o=cfdIdOrigen
    private Integer cfdIdOrigen;
    
    /**
    * entrada salida id
    */
    // Simple: PK?false, FK?true, class=int, o=entradaSalidaId
    private int entradaSalidaId;
    
    /**
    * tipo
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=tipo
    private String tipo;
    
    /**
    * num cfd
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=numCfd
    private String numCfd;
    
    /**
    * ultimo error
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=ultimoError
    private String ultimoError;
    
    /**
    * contenido original
    */
    // Simple: PK?false, FK?false, class=byte[], o=contenidoOriginal
    private byte[] contenidoOriginal;

    /** 
     * Default Constructor
     */
    public CfdDTO() {
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
    public Integer getCfdIdOrigen() {
        return this.cfdIdOrigen;
    }
    public void setCfdIdOrigen(Integer v) {
        this.cfdIdOrigen = v;
    }
    public int getEntradaSalidaId() {
        return this.entradaSalidaId;
    }
    public void setEntradaSalidaId(int v) {
        this.entradaSalidaId = v;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String v) {
        this.tipo = v;
    }
    public String getNumCfd() {
        return this.numCfd;
    }
    public void setNumCfd(String v) {
        this.numCfd = v;
    }
    public String getUltimoError() {
        return this.ultimoError;
    }
    public void setUltimoError(String v) {
        this.ultimoError = v;
    }
    public byte[] getContenidoOriginal() {
        return this.contenidoOriginal;
    }
    public void setContenidoOriginal(byte[] v) {
        this.contenidoOriginal = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(cfdIdOrigen).hashCode();
		hash += String.valueOf(entradaSalidaId).hashCode();
		hash += String.valueOf(tipo).hashCode();
		hash += String.valueOf(numCfd).hashCode();
		hash += String.valueOf(ultimoError).hashCode();
		hash += String.valueOf(contenidoOriginal).hashCode();
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
        if (!(o instanceof CfdDTO)) {
            return false;
        }		
		CfdDTO  other = (CfdDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.cfdIdOrigen, other.cfdIdOrigen)) { return false; }		
		if (!Objects.equals(this.entradaSalidaId, other.entradaSalidaId)) { return false; }		
		if (!Objects.equals(this.tipo, other.tipo)) { return false; }		
		if (!Objects.equals(this.numCfd, other.numCfd)) { return false; }		
		if (!Objects.equals(this.ultimoError, other.ultimoError)) { return false; }		
		if (!Objects.equals(this.contenidoOriginal, other.contenidoOriginal)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("CfdDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("cfdIdOrigen" ).append("=").append(cfdIdOrigen).append("|");
		sb.append("entradaSalidaId" ).append("=").append(entradaSalidaId).append("|");
		sb.append("tipo" ).append("=").append(tipo).append("|");
		sb.append("numCfd" ).append("=").append(numCfd).append("|");
		sb.append("ultimoError" ).append("=").append(ultimoError).append("|");
		sb.append("contenidoOriginal" ).append("=").append(contenidoOriginal).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
