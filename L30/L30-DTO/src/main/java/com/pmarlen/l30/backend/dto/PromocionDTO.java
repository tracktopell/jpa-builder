package com.pmarlen.l30.backend.dto;

import java.util.Objects;

/**
 * Class for mapping DTO Entity of Table PROMOCION.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

public class PromocionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1705736037;

    
    /**
    * id
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=id
    private Integer id;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * regla aritmetica
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=reglaAritmetica
    private String reglaAritmetica;

    /** 
     * Default Constructor
     */
    public PromocionDTO() {
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
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getReglaAritmetica() {
        return this.reglaAritmetica;
    }
    public void setReglaAritmetica(String v) {
        this.reglaAritmetica = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(reglaAritmetica).hashCode();
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
        if (!(o instanceof PromocionDTO)) {
            return false;
        }		
		PromocionDTO  other = (PromocionDTO ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.reglaAritmetica, other.reglaAritmetica)) { return false; }		
    	return true;
    }

    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("PromocionDTO{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("reglaAritmetica" ).append("=").append(reglaAritmetica).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
    }

}
