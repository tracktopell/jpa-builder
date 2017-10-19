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
 * Class for mapping JPA Entity of Table ENTRDA_SALIDA_ESTADO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "ENTRDA_SALIDA_ESTADO")
@NamedQueries({
    @NamedQuery(name = "EntrdaSalidaEstado.findAll", query = "SELECT e FROM EntrdaSalidaEstado e")
    , @NamedQuery(name = "EntrdaSalidaEstado.countAll", query = "SELECT COUNT(e) FROM EntrdaSalidaEstado e")
    , @NamedQuery(name = "EntrdaSalidaEstado.findById", query = "SELECT e FROM EntrdaSalidaEstado e WHERE e.id = :id")
    , @NamedQuery(name = "EntrdaSalidaEstado.findByentradaSalidaentradaSala", query = "SELECT e FROM EntrdaSalidaEstado e WHERE e.entradaSalidaentradaSala = :entradaSalidaentradaSala")
    , @NamedQuery(name = "EntrdaSalidaEstado.findByFecha", query = "SELECT e FROM EntrdaSalidaEstado e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "EntrdaSalidaEstado.findByComentarios", query = "SELECT e FROM EntrdaSalidaEstado e WHERE e.comentarios = :comentarios")
    , @NamedQuery(name = "EntrdaSalidaEstado.findByestadoestado", query = "SELECT e FROM EntrdaSalidaEstado e WHERE e.estadoestado = :estadoestado")
    , @NamedQuery(name = "EntrdaSalidaEstado.findByusuariousuario", query = "SELECT e FROM EntrdaSalidaEstado e WHERE e.usuariousuario = :usuariousuario")
})
public class EntrdaSalidaEstado implements java.io.Serializable {
    private static final long serialVersionUID = 135721597;
    
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
    * The 'ENTRADA SALIDA ID' Maps to COLUMN 'ENTRADA_SALIDA_ID'
    */
    
    @JoinColumn(name = "ENTRADA_SALIDA_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EntradaSalida entradaSalidaentradaSala;
    
    /**
    * The 'FECHA' Maps to COLUMN 'FECHA'
    */
    
    @Basic(optional = true)
    @Column(name = "FECHA" , nullable=true)
    private Integer fecha;
    
    /**
    * The 'COMENTARIOS' Maps to COLUMN 'COMENTARIOS'
    */
    
    @Basic(optional = true)
    //@Size(max = 255)
    @Column(name = "COMENTARIOS" , length=255, nullable=true)
    private String comentarios;
    
    /**
    * The 'ESTADO ID' Maps to COLUMN 'ESTADO_ID'
    */
    
    @JoinColumn(name = "ESTADO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estado estadoestado;
    
    /**
    * The 'USUARIO ID' Maps to COLUMN 'USUARIO_ID'
    */
    
    @JoinColumn(name = "USUARIO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuariousuario;

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public EntrdaSalidaEstado() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public EntradaSalida getEntradaSalidaentradaSala(){ return this.entradaSalidaentradaSala ; }
    public void setEntradaSalidaentradaSala(EntradaSalida x){ this.entradaSalidaentradaSala = x; }
    
    public Integer getFecha() { return this.fecha;}
    public void setFecha(Integer v) { this.fecha = v; }
    
    public String getComentarios() { return this.comentarios;}
    public void setComentarios(String v) { this.comentarios = v; }
    
    public Estado getEstadoestado(){ return this.estadoestado ; }
    public void setEstadoestado(Estado x){ this.estadoestado = x; }
    
    public Usuario getUsuariousuario(){ return this.usuariousuario ; }
    public void setUsuariousuario(Usuario x){ this.usuariousuario = x; }
    
    // O2M <*>    
	// M2M <*>

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(entradaSalidaentradaSala).hashCode();
		hash += String.valueOf(fecha).hashCode();
		hash += String.valueOf(comentarios).hashCode();
		hash += String.valueOf(estadoestado).hashCode();
		hash += String.valueOf(usuariousuario).hashCode();
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
        if (!(o instanceof EntrdaSalidaEstado)) {
            return false;
        }		
		EntrdaSalidaEstado other = (EntrdaSalidaEstado ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.entradaSalidaentradaSala, other.entradaSalidaentradaSala)) { return false; }		
		if (!Objects.equals(this.fecha, other.fecha)) { return false; }		
		if (!Objects.equals(this.comentarios, other.comentarios)) { return false; }		
		if (!Objects.equals(this.estadoestado, other.estadoestado)) { return false; }		
		if (!Objects.equals(this.usuariousuario, other.usuariousuario)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("EntrdaSalidaEstado{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("entradaSalidaentradaSala" ).append("=").append(entradaSalidaentradaSala).append("|");
		sb.append("fecha" ).append("=").append(fecha).append("|");
		sb.append("comentarios" ).append("=").append(comentarios).append("|");
		sb.append("estadoestado" ).append("=").append(estadoestado).append("|");
		sb.append("usuariousuario" ).append("=").append(usuariousuario).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
