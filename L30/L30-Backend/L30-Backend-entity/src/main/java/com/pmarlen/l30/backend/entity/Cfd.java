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

// Hibernate Validator 5x is not compatible with validation-api 1.0.x
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 * Class for mapping JPA Entity of Table CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "CFD")
@NamedQueries({
    @NamedQuery(name = "Cfd.findAll", query = "SELECT c FROM Cfd c")
    , @NamedQuery(name = "Cfd.countAll", query = "SELECT COUNT(c) FROM Cfd c")
    , @NamedQuery(name = "Cfd.findById", query = "SELECT c FROM Cfd c WHERE c.id = :id")
    , @NamedQuery(name = "Cfd.findBycfdcfdOrigen", query = "SELECT c FROM Cfd c WHERE c.cfdcfdOrigen = :cfdcfdOrigen")
    , @NamedQuery(name = "Cfd.findByentradaSalidaentradaSala", query = "SELECT c FROM Cfd c WHERE c.entradaSalidaentradaSala = :entradaSalidaentradaSala")
    , @NamedQuery(name = "Cfd.findByTipo", query = "SELECT c FROM Cfd c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Cfd.findByNumCfd", query = "SELECT c FROM Cfd c WHERE c.numCfd = :numCfd")
    , @NamedQuery(name = "Cfd.findByUltimoError", query = "SELECT c FROM Cfd c WHERE c.ultimoError = :ultimoError")
    , @NamedQuery(name = "Cfd.findByContenidoOriginal", query = "SELECT c FROM Cfd c WHERE c.contenidoOriginal = :contenidoOriginal")
})
public class Cfd implements java.io.Serializable {
    private static final long serialVersionUID = 1826771953;
    
    /**
    * The 'ID' Maps to COLUMN 'ID'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID" , nullable=false  )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    /**
    * The 'CFD ID ORIGEN' Maps to COLUMN 'CFD_ID_ORIGEN'
    */
    
    @JoinColumn(name = "CFD_ID_ORIGEN" , referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private Cfd cfdcfdOrigen;
    
    /**
    * The 'ENTRADA SALIDA ID' Maps to COLUMN 'ENTRADA_SALIDA_ID'
    */
    
    @JoinColumn(name = "ENTRADA_SALIDA_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EntradaSalida entradaSalidaentradaSala;
    
    /**
    * The 'TIPO' Maps to COLUMN 'TIPO'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 8)
    @Column(name = "TIPO" , length=8, nullable=false)
    private String tipo;
    
    /**
    * The 'NUM CFD' Maps to COLUMN 'NUM_CFD'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    //@Size(min = 1, max = 128)
    @Column(name = "NUM_CFD" , length=128, nullable=false)
    private String numCfd;
    
    /**
    * The 'ULTIMO ERROR' Maps to COLUMN 'ULTIMO_ERROR'
    */
    
    @Basic(optional = true)
    //@Size(max = 1024)
    @Column(name = "ULTIMO_ERROR" , length=1024, nullable=true)
    private String ultimoError;
    
    /**
    * The 'CONTENIDO ORIGINAL' Maps to COLUMN 'CONTENIDO_ORIGINAL'
    */
    
    @Basic(optional = true)
    @Column(name = "CONTENIDO_ORIGINAL" , nullable=true)
    private byte[] contenidoOriginal;
    /** 
    * Map the relation to CFD table where has CFD_ID_ORIGEN object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cfdcfdOrigen")
    // CFD Well know as Cfd
    private List<Cfd> cfdThatHasThisCfdcfdOrigenList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Cfd() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public Cfd getCfdcfdOrigen(){ return this.cfdcfdOrigen ; }
    public void setCfdcfdOrigen(Cfd x){ this.cfdcfdOrigen = x; }
    
    public EntradaSalida getEntradaSalidaentradaSala(){ return this.entradaSalidaentradaSala ; }
    public void setEntradaSalidaentradaSala(EntradaSalida x){ this.entradaSalidaentradaSala = x; }
    
    public String getTipo() { return this.tipo;}
    public void setTipo(String v) { this.tipo = v; }
    
    public String getNumCfd() { return this.numCfd;}
    public void setNumCfd(String v) { this.numCfd = v; }
    
    public String getUltimoError() { return this.ultimoError;}
    public void setUltimoError(String v) { this.ultimoError = v; }
    
    public byte[] getContenidoOriginal() { return this.contenidoOriginal;}
    public void setContenidoOriginal(byte[] v) { this.contenidoOriginal = v; }
    
    // O2M <*>    
    public List<Cfd> getCfdThatHasThisCfdcfdOrigenList(){ return this.cfdThatHasThisCfdcfdOrigenList; }
    public void setCfdThatHasThisCfdcfdOrigenList(List<Cfd> v){ this.cfdThatHasThisCfdcfdOrigenList = v; }
    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(cfdcfdOrigen).hashCode();
		hash += String.valueOf(entradaSalidaentradaSala).hashCode();
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
        if (!(o instanceof Cfd)) {
            return false;
        }		
		Cfd other = (Cfd ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.cfdcfdOrigen, other.cfdcfdOrigen)) { return false; }		
		if (!Objects.equals(this.entradaSalidaentradaSala, other.entradaSalidaentradaSala)) { return false; }		
		if (!Objects.equals(this.tipo, other.tipo)) { return false; }		
		if (!Objects.equals(this.numCfd, other.numCfd)) { return false; }		
		if (!Objects.equals(this.ultimoError, other.ultimoError)) { return false; }		
		if (!Objects.equals(this.contenidoOriginal, other.contenidoOriginal)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Cfd{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("cfdcfdOrigen" ).append("=").append(cfdcfdOrigen).append("|");
		sb.append("entradaSalidaentradaSala" ).append("=").append(entradaSalidaentradaSala).append("|");
		sb.append("tipo" ).append("=").append(tipo).append("|");
		sb.append("numCfd" ).append("=").append(numCfd).append("|");
		sb.append("ultimoError" ).append("=").append(ultimoError).append("|");
		sb.append("contenidoOriginal" ).append("=").append(contenidoOriginal).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
