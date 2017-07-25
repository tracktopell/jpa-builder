package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table CLIENTE.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

public class ClienteDTO implements java.io.Serializable {
    private static final long serialVersionUID = 931919113;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * rfc
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=rfc
    private String rfc;
    
    /**
    * razon social
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=razonSocial
    private String razonSocial;
    
    /**
    * nombre establecimiento
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombreEstablecimiento
    private String nombreEstablecimiento;
    
    /**
    * direccion facturacion
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=direccionFacturacion
    private String direccionFacturacion;
    
    /**
    * telefonos
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=telefonos
    private String telefonos;
    
    /**
    * banco
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=banco
    private String banco;
    
    /**
    * num cuenta
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=numCuenta
    private String numCuenta;
    
    /**
    * email
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=email
    private String email;
    
    /**
    * referencia
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=referencia
    private String referencia;
    
    /**
    * contacto
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=contacto
    private String contacto;
    
    /**
    * ubicacion lat
    */
    // Simple: PK?false, FK?false, class=java.lang.Double, o=ubicacionLat
    private Double ubicacionLat;
    
    /**
    * ubicacion lon
    */
    // Simple: PK?false, FK?false, class=java.lang.Double, o=ubicacionLon
    private Double ubicacionLon;

    /** 
     * Default Constructor
     */
    public ClienteDTO() {
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
    public String getRfc() {
        return this.rfc;
    }
    public void setRfc(String v) {
        this.rfc = v;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    public void setRazonSocial(String v) {
        this.razonSocial = v;
    }
    public String getNombreEstablecimiento() {
        return this.nombreEstablecimiento;
    }
    public void setNombreEstablecimiento(String v) {
        this.nombreEstablecimiento = v;
    }
    public String getDireccionFacturacion() {
        return this.direccionFacturacion;
    }
    public void setDireccionFacturacion(String v) {
        this.direccionFacturacion = v;
    }
    public String getTelefonos() {
        return this.telefonos;
    }
    public void setTelefonos(String v) {
        this.telefonos = v;
    }
    public String getBanco() {
        return this.banco;
    }
    public void setBanco(String v) {
        this.banco = v;
    }
    public String getNumCuenta() {
        return this.numCuenta;
    }
    public void setNumCuenta(String v) {
        this.numCuenta = v;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String v) {
        this.email = v;
    }
    public String getReferencia() {
        return this.referencia;
    }
    public void setReferencia(String v) {
        this.referencia = v;
    }
    public String getContacto() {
        return this.contacto;
    }
    public void setContacto(String v) {
        this.contacto = v;
    }
    public Double getUbicacionLat() {
        return this.ubicacionLat;
    }
    public void setUbicacionLat(Double v) {
        this.ubicacionLat = v;
    }
    public Double getUbicacionLon() {
        return this.ubicacionLon;
    }
    public void setUbicacionLon(Double v) {
        this.ubicacionLon = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(rfc).hashCode();
		hash += String.valueOf(razonSocial).hashCode();
		hash += String.valueOf(nombreEstablecimiento).hashCode();
		hash += String.valueOf(direccionFacturacion).hashCode();
		hash += String.valueOf(telefonos).hashCode();
		hash += String.valueOf(banco).hashCode();
		hash += String.valueOf(numCuenta).hashCode();
		hash += String.valueOf(email).hashCode();
		hash += String.valueOf(referencia).hashCode();
		hash += String.valueOf(contacto).hashCode();
		hash += String.valueOf(ubicacionLat).hashCode();
		hash += String.valueOf(ubicacionLon).hashCode();
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
        if (!(o instanceof ClienteDTO)) {
            return false;
        }		
		ClienteDTO  other = (ClienteDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.rfc, other.rfc)) { return false; }		
		if (!Objects.equals(this.razonSocial, other.razonSocial)) { return false; }		
		if (!Objects.equals(this.nombreEstablecimiento, other.nombreEstablecimiento)) { return false; }		
		if (!Objects.equals(this.direccionFacturacion, other.direccionFacturacion)) { return false; }		
		if (!Objects.equals(this.telefonos, other.telefonos)) { return false; }		
		if (!Objects.equals(this.banco, other.banco)) { return false; }		
		if (!Objects.equals(this.numCuenta, other.numCuenta)) { return false; }		
		if (!Objects.equals(this.email, other.email)) { return false; }		
		if (!Objects.equals(this.referencia, other.referencia)) { return false; }		
		if (!Objects.equals(this.contacto, other.contacto)) { return false; }		
		if (!Objects.equals(this.ubicacionLat, other.ubicacionLat)) { return false; }		
		if (!Objects.equals(this.ubicacionLon, other.ubicacionLon)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("ClienteDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("rfc" ).append("=").append(rfc).append("|");
		sb.append("razonSocial" ).append("=").append(razonSocial).append("|");
		sb.append("nombreEstablecimiento" ).append("=").append(nombreEstablecimiento).append("|");
		sb.append("direccionFacturacion" ).append("=").append(direccionFacturacion).append("|");
		sb.append("telefonos" ).append("=").append(telefonos).append("|");
		sb.append("banco" ).append("=").append(banco).append("|");
		sb.append("numCuenta" ).append("=").append(numCuenta).append("|");
		sb.append("email" ).append("=").append(email).append("|");
		sb.append("referencia" ).append("=").append(referencia).append("|");
		sb.append("contacto" ).append("=").append(contacto).append("|");
		sb.append("ubicacionLat" ).append("=").append(ubicacionLat).append("|");
		sb.append("ubicacionLon" ).append("=").append(ubicacionLon).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
