package com.pmarlen.l30.backend.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Embeddable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table PROMOCION.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

@Entity
@Table(name = "PROMOCION")
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p")
    , @NamedQuery(name = "Promocion.countAll", query = "SELECT COUNT(p) FROM Promocion p")
    , @NamedQuery(name = "Promocion.findById", query = "SELECT p FROM Promocion p WHERE p.id = :id")
    , @NamedQuery(name = "Promocion.findByNombre", query = "SELECT p FROM Promocion p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Promocion.findByReglaAritmetica", query = "SELECT p FROM Promocion p WHERE p.reglaAritmetica = :reglaAritmetica")
})
public class Promocion implements java.io.Serializable {
    private static final long serialVersionUID = 1705736037;
    
    /**
    * The 'ID' Maps to COLUMN 'ID'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * The 'NOMBRE' Maps to COLUMN 'NOMBRE'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NOMBRE" , length=64, nullable=false)
    private String nombre;
    
    /**
    * The 'REGLA ARITMETICA' Maps to COLUMN 'REGLA_ARITMETICA'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "REGLA_ARITMETICA" , length=255, nullable=false)
    private String reglaAritmetica;
    /** 
    * Map the relation to OFERTA_PRODUCTO table where has PROMOCION_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocionpromocion")
    // OFERTA_PRODUCTO Well know as OfertaProducto
    private List<OfertaProducto> ofertaProductoThatHasThisPromocionpromocionList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Promocion() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getReglaAritmetica() { return this.reglaAritmetica;}
    public void setReglaAritmetica(String v) { this.reglaAritmetica = v; }
    
    // O2M <*>    
    public List<OfertaProducto> getOfertaProductoThatHasThisPromocionpromocionList(){ return this.ofertaProductoThatHasThisPromocionpromocionList; }
    public void setOfertaProductoThatHasThisPromocionpromocionList(List<OfertaProducto> v){ this.ofertaProductoThatHasThisPromocionpromocionList = v; }
    
	// M2M <*>

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
        if (!(o instanceof Promocion)) {
            return false;
        }		
		Promocion other = (Promocion ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.reglaAritmetica, other.reglaAritmetica)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Promocion{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("reglaAritmetica" ).append("=").append(reglaAritmetica).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
