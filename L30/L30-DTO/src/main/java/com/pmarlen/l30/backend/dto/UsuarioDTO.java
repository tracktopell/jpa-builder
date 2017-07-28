package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table USUARIO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

public class UsuarioDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1747585824;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * email
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=email
    private String email;
    
    /**
    * password
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=password
    private String password;
    
    /**
    * telefonos
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=telefonos
    private String telefonos;
    
    /**
    * habilitado
    */
    // Simple: PK?false, FK?false, class=int, o=habilitado
    private int habilitado;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * apellido paterno
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=apellidoPaterno
    private String apellidoPaterno;
    
    /**
    * apellido materno
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=apellidoMaterno
    private String apellidoMaterno;
    
    /**
    * fecha registro
    */
    // Simple: PK?false, FK?false, class=java.sql.Timestamp, o=fechaRegistro
    private java.sql.Timestamp fechaRegistro;
    
    /**
    * fecha ult  cambio
    */
    // Simple: PK?false, FK?false, class=java.sql.Timestamp, o=fechaUltCambio
    private java.sql.Timestamp fechaUltCambio;
    
    /**
    * sucursal id
    */
    // Simple: PK?false, FK?true, class=int, o=sucursalId
    private int sucursalId;

    /** 
     * Default Constructor
     */
    public UsuarioDTO() {
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
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String v) {
        this.email = v;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String v) {
        this.password = v;
    }
    public String getTelefonos() {
        return this.telefonos;
    }
    public void setTelefonos(String v) {
        this.telefonos = v;
    }
    public int getHabilitado() {
        return this.habilitado;
    }
    public void setHabilitado(int v) {
        this.habilitado = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    public void setApellidoPaterno(String v) {
        this.apellidoPaterno = v;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    public void setApellidoMaterno(String v) {
        this.apellidoMaterno = v;
    }
    public java.sql.Timestamp getFechaRegistro() {
        return this.fechaRegistro;
    }
    public void setFechaRegistro(java.sql.Timestamp v) {
        this.fechaRegistro = v;
    }
    public java.sql.Timestamp getFechaUltCambio() {
        return this.fechaUltCambio;
    }
    public void setFechaUltCambio(java.sql.Timestamp v) {
        this.fechaUltCambio = v;
    }
    public int getSucursalId() {
        return this.sucursalId;
    }
    public void setSucursalId(int v) {
        this.sucursalId = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(password).hashCode();
		hash += String.valueOf(telefonos).hashCode();
		hash += String.valueOf(habilitado).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(apellidoPaterno).hashCode();
		hash += String.valueOf(apellidoMaterno).hashCode();
		hash += String.valueOf(fechaRegistro).hashCode();
		hash += String.valueOf(fechaUltCambio).hashCode();
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
        if (!(o instanceof UsuarioDTO)) {
            return false;
        }		
		UsuarioDTO  other = (UsuarioDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.password, other.password)) { return false; }		
		if (!Objects.equals(this.telefonos, other.telefonos)) { return false; }		
		if (!Objects.equals(this.habilitado, other.habilitado)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) { return false; }		
		if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) { return false; }		
		if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) { return false; }		
		if (!Objects.equals(this.fechaUltCambio, other.fechaUltCambio)) { return false; }		
		if (!Objects.equals(this.sucursalId, other.sucursalId)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("UsuarioDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("email" ).append("=").append(email).append("|");
		sb.append("password" ).append("=").append(password).append("|");
		sb.append("telefonos" ).append("=").append(telefonos).append("|");
		sb.append("habilitado" ).append("=").append(habilitado).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("apellidoPaterno" ).append("=").append(apellidoPaterno).append("|");
		sb.append("apellidoMaterno" ).append("=").append(apellidoMaterno).append("|");
		sb.append("fechaRegistro" ).append("=").append(fechaRegistro).append("|");
		sb.append("fechaUltCambio" ).append("=").append(fechaUltCambio).append("|");
		sb.append("sucursalId" ).append("=").append(sucursalId).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
