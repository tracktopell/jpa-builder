package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table CONFIGURACION_PROOVEDOR_CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

public class ConfiguracionProovedorCfdDTO implements java.io.Serializable {
    private static final long serialVersionUID = 531885035;

    
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
    * prioridad
    */
    // Simple: PK?false, FK?false, class=int, o=prioridad
    private int prioridad;
    
    /**
    * proveedor cfd
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=proveedorCfd
    private String proveedorCfd;
    
    /**
    * usuario cfd
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=usuarioCfd
    private String usuarioCfd;
    
    /**
    * password cfd
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=passwordCfd
    private String passwordCfd;
    
    /**
    * serie cfd
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=serieCfd
    private String serieCfd;

    /** 
     * Default Constructor
     */
    public ConfiguracionProovedorCfdDTO() {
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
    public int getPrioridad() {
        return this.prioridad;
    }
    public void setPrioridad(int v) {
        this.prioridad = v;
    }
    public String getProveedorCfd() {
        return this.proveedorCfd;
    }
    public void setProveedorCfd(String v) {
        this.proveedorCfd = v;
    }
    public String getUsuarioCfd() {
        return this.usuarioCfd;
    }
    public void setUsuarioCfd(String v) {
        this.usuarioCfd = v;
    }
    public String getPasswordCfd() {
        return this.passwordCfd;
    }
    public void setPasswordCfd(String v) {
        this.passwordCfd = v;
    }
    public String getSerieCfd() {
        return this.serieCfd;
    }
    public void setSerieCfd(String v) {
        this.serieCfd = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(sucursalId).hashCode();
		hash += String.valueOf(prioridad).hashCode();
		hash += String.valueOf(proveedorCfd).hashCode();
		hash += String.valueOf(usuarioCfd).hashCode();
		hash += String.valueOf(passwordCfd).hashCode();
		hash += String.valueOf(serieCfd).hashCode();
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
        if (!(o instanceof ConfiguracionProovedorCfdDTO)) {
            return false;
        }		
		ConfiguracionProovedorCfdDTO  other = (ConfiguracionProovedorCfdDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
		if (!Objects.equals(this.prioridad, other.prioridad)) { return false; }		
		if (!Objects.equals(this.proveedorCfd, other.proveedorCfd)) { return false; }		
		if (!Objects.equals(this.usuarioCfd, other.usuarioCfd)) { return false; }		
		if (!Objects.equals(this.passwordCfd, other.passwordCfd)) { return false; }		
		if (!Objects.equals(this.serieCfd, other.serieCfd)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ConfiguracionProovedorCfdDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("sucursalId" ).append("=").append(sucursalId).append("|");
		sb.append("prioridad" ).append("=").append(prioridad).append("|");
		sb.append("proveedorCfd" ).append("=").append(proveedorCfd).append("|");
		sb.append("usuarioCfd" ).append("=").append(usuarioCfd).append("|");
		sb.append("passwordCfd" ).append("=").append(passwordCfd).append("|");
		sb.append("serieCfd" ).append("=").append(serieCfd).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
