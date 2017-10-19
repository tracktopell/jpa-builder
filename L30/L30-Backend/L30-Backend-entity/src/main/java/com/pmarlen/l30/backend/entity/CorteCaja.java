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
 * Class for mapping JPA Entity of Table CORTE_CAJA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "CORTE_CAJA")
@NamedQueries({
    @NamedQuery(name = "CorteCaja.findAll", query = "SELECT c FROM CorteCaja c")
    , @NamedQuery(name = "CorteCaja.countAll", query = "SELECT COUNT(c) FROM CorteCaja c")
    , @NamedQuery(name = "CorteCaja.findById", query = "SELECT c FROM CorteCaja c WHERE c.id = :id")
    , @NamedQuery(name = "CorteCaja.findBysucursalsucursal", query = "SELECT c FROM CorteCaja c WHERE c.sucursalsucursal = :sucursalsucursal")
    , @NamedQuery(name = "CorteCaja.findByTipoEvento", query = "SELECT c FROM CorteCaja c WHERE c.tipoEvento = :tipoEvento")
    , @NamedQuery(name = "CorteCaja.findByusuariousuario", query = "SELECT c FROM CorteCaja c WHERE c.usuariousuario = :usuariousuario")
    , @NamedQuery(name = "CorteCaja.findByFecha", query = "SELECT c FROM CorteCaja c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CorteCaja.findByFechaUap", query = "SELECT c FROM CorteCaja c WHERE c.fechaUap = :fechaUap")
    , @NamedQuery(name = "CorteCaja.findBySaldoInicial", query = "SELECT c FROM CorteCaja c WHERE c.saldoInicial = :saldoInicial")
    , @NamedQuery(name = "CorteCaja.findBySaldoFinal", query = "SELECT c FROM CorteCaja c WHERE c.saldoFinal = :saldoFinal")
    , @NamedQuery(name = "CorteCaja.findByusuariousuarioAutorizo", query = "SELECT c FROM CorteCaja c WHERE c.usuariousuarioAutorizo = :usuariousuarioAutorizo")
    , @NamedQuery(name = "CorteCaja.findByComentarios", query = "SELECT c FROM CorteCaja c WHERE c.comentarios = :comentarios")
    , @NamedQuery(name = "CorteCaja.findByCaja", query = "SELECT c FROM CorteCaja c WHERE c.caja = :caja")
})
public class CorteCaja implements java.io.Serializable {
    private static final long serialVersionUID = 1927950199;
    
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
    * The 'SUCURSAL ID' Maps to COLUMN 'SUCURSAL_ID'
    */
    
    @JoinColumn(name = "SUCURSAL_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursalsucursal;
    
    /**
    * The 'TIPO EVENTO' Maps to COLUMN 'TIPO_EVENTO'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "TIPO_EVENTO" , nullable=false)
    private int tipoEvento;
    
    /**
    * The 'USUARIO ID' Maps to COLUMN 'USUARIO_ID'
    */
    
    @JoinColumn(name = "USUARIO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuariousuario;
    
    /**
    * The 'FECHA' Maps to COLUMN 'FECHA'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "FECHA" , nullable=false)
    private java.sql.Timestamp fecha;
    
    /**
    * The 'FECHA UAP' Maps to COLUMN 'FECHA_UAP'
    */
    
    @Basic(optional = true)
    @Column(name = "FECHA_UAP" , nullable=true)
    private java.sql.Timestamp fechaUap;
    
    /**
    * The 'SALDO INICIAL' Maps to COLUMN 'SALDO_INICIAL'
    */
    
    @Basic(optional = true)
    @Column(name = "SALDO_INICIAL" , nullable=true)
    private Double saldoInicial;
    
    /**
    * The 'SALDO FINAL' Maps to COLUMN 'SALDO_FINAL'
    */
    
    @Basic(optional = true)
    @Column(name = "SALDO_FINAL" , nullable=true)
    private Double saldoFinal;
    
    /**
    * The 'USUARIO ID AUTORIZO' Maps to COLUMN 'USUARIO_ID_AUTORIZO'
    */
    
    @JoinColumn(name = "USUARIO_ID_AUTORIZO" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuariousuarioAutorizo;
    
    /**
    * The 'COMENTARIOS' Maps to COLUMN 'COMENTARIOS'
    */
    
    @Basic(optional = true)
    //@Size(max = 255)
    @Column(name = "COMENTARIOS" , length=255, nullable=true)
    private String comentarios;
    
    /**
    * The 'CAJA' Maps to COLUMN 'CAJA'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "CAJA" , nullable=false)
    private int caja;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public CorteCaja() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public Sucursal getSucursalsucursal(){ return this.sucursalsucursal ; }
    public void setSucursalsucursal(Sucursal x){ this.sucursalsucursal = x; }
    
    public int getTipoEvento() { return this.tipoEvento;}
    public void setTipoEvento(int v) { this.tipoEvento = v; }
    
    public Usuario getUsuariousuario(){ return this.usuariousuario ; }
    public void setUsuariousuario(Usuario x){ this.usuariousuario = x; }
    
    public java.sql.Timestamp getFecha() { return this.fecha;}
    public void setFecha(java.sql.Timestamp v) { this.fecha = v; }
    
    public java.sql.Timestamp getFechaUap() { return this.fechaUap;}
    public void setFechaUap(java.sql.Timestamp v) { this.fechaUap = v; }
    
    public Double getSaldoInicial() { return this.saldoInicial;}
    public void setSaldoInicial(Double v) { this.saldoInicial = v; }
    
    public Double getSaldoFinal() { return this.saldoFinal;}
    public void setSaldoFinal(Double v) { this.saldoFinal = v; }
    
    public Usuario getUsuariousuarioAutorizo(){ return this.usuariousuarioAutorizo ; }
    public void setUsuariousuarioAutorizo(Usuario x){ this.usuariousuarioAutorizo = x; }
    
    public String getComentarios() { return this.comentarios;}
    public void setComentarios(String v) { this.comentarios = v; }
    
    public int getCaja() { return this.caja;}
    public void setCaja(int v) { this.caja = v; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(sucursalsucursal).hashCode();
		hash += String.valueOf(tipoEvento).hashCode();
		hash += String.valueOf(usuariousuario).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(fechaUap).hashCode();
		hash += String.valueOf(saldoInicial).hashCode();
		hash += String.valueOf(saldoFinal).hashCode();
		hash += String.valueOf(usuariousuarioAutorizo).hashCode();
		hash += String.valueOf(comentarios).hashCode();
		hash += String.valueOf(caja).hashCode();
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
        if (!(o instanceof CorteCaja)) {
            return false;
        }		
		CorteCaja other = (CorteCaja ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.sucursalsucursal, other.sucursalsucursal)) { return false; }		
		if (!Objects.equals(this.tipoEvento, other.tipoEvento)) { return false; }		
		if (!Objects.equals(this.usuariousuario, other.usuariousuario)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.fechaUap, other.fechaUap)) { return false; }		
		if (!Objects.equals(this.saldoInicial, other.saldoInicial)) { return false; }		
		if (!Objects.equals(this.saldoFinal, other.saldoFinal)) { return false; }		
		if (!Objects.equals(this.usuariousuarioAutorizo, other.usuariousuarioAutorizo)) { return false; }		
		if (!Objects.equals(this.comentarios, other.comentarios)) { return false; }		
		if (!Objects.equals(this.caja, other.caja)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("CorteCaja{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("sucursalsucursal" ).append("=").append(sucursalsucursal).append("|");
		sb.append("tipoEvento" ).append("=").append(tipoEvento).append("|");
		sb.append("usuariousuario" ).append("=").append(usuariousuario).append("|");
		sb.append("fecha" ).append("=").append(fecha).append("|");
		sb.append("fechaUap" ).append("=").append(fechaUap).append("|");
		sb.append("saldoInicial" ).append("=").append(saldoInicial).append("|");
		sb.append("saldoFinal" ).append("=").append(saldoFinal).append("|");
		sb.append("usuariousuarioAutorizo" ).append("=").append(usuariousuarioAutorizo).append("|");
		sb.append("comentarios" ).append("=").append(comentarios).append("|");
		sb.append("caja" ).append("=").append(caja).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
