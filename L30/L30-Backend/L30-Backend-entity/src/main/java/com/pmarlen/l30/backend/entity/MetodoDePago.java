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
 * Class for mapping JPA Entity of Table METODO_DE_PAGO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

@Entity
@Table(name = "METODO_DE_PAGO")
@NamedQueries({
    @NamedQuery(name = "MetodoDePago.findAll", query = "SELECT m FROM MetodoDePago m")
    , @NamedQuery(name = "MetodoDePago.countAll", query = "SELECT COUNT(m) FROM MetodoDePago m")
    , @NamedQuery(name = "MetodoDePago.findById", query = "SELECT m FROM MetodoDePago m WHERE m.id = :id")
    , @NamedQuery(name = "MetodoDePago.findByDescripcion", query = "SELECT m FROM MetodoDePago m WHERE m.descripcion = :descripcion")
})
public class MetodoDePago implements java.io.Serializable {
    private static final long serialVersionUID = 1915318863;
    
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
    * The 'DESCRIPCION' Maps to COLUMN 'DESCRIPCION'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "DESCRIPCION" , length=64, nullable=false)
    private String descripcion;
    /** 
    * Map the relation to ENTRADA_SALIDA table where has METODO_DE_PAGO_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodoDePagometodoDePago")
    // ENTRADA_SALIDA Well know as EntradaSalida
    private List<EntradaSalida> entradaSalidaThatHasThisMetodoDePagometodoDePagoList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public MetodoDePago() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public String getDescripcion() { return this.descripcion;}
    public void setDescripcion(String v) { this.descripcion = v; }
    
    // O2M <*>    
    public List<EntradaSalida> getEntradaSalidaThatHasThisMetodoDePagometodoDePagoList(){ return this.entradaSalidaThatHasThisMetodoDePagometodoDePagoList; }
    public void setEntradaSalidaThatHasThisMetodoDePagometodoDePagoList(List<EntradaSalida> v){ this.entradaSalidaThatHasThisMetodoDePagometodoDePagoList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(descripcion).hashCode();
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
        if (!(o instanceof MetodoDePago)) {
            return false;
        }		
		MetodoDePago other = (MetodoDePago ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MetodoDePago{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("descripcion" ).append("=").append(descripcion).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
