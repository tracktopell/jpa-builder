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
 * Class for mapping JPA Entity of Table ENTRADA_SALIDA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

@Entity
@Table(name = "ENTRADA_SALIDA")
@NamedQueries({
    @NamedQuery(name = "EntradaSalida.findAll", query = "SELECT e FROM EntradaSalida e")
    , @NamedQuery(name = "EntradaSalida.countAll", query = "SELECT COUNT(e) FROM EntradaSalida e")
    , @NamedQuery(name = "EntradaSalida.findById", query = "SELECT e FROM EntradaSalida e WHERE e.id = :id")
    , @NamedQuery(name = "EntradaSalida.findByTipoMov", query = "SELECT e FROM EntradaSalida e WHERE e.tipoMov = :tipoMov")
    , @NamedQuery(name = "EntradaSalida.findByFechaCreo", query = "SELECT e FROM EntradaSalida e WHERE e.fechaCreo = :fechaCreo")
    , @NamedQuery(name = "EntradaSalida.findByestadoestadoActual", query = "SELECT e FROM EntradaSalida e WHERE e.estadoestadoActual = :estadoestadoActual")
    , @NamedQuery(name = "EntradaSalida.findByclientecliente", query = "SELECT e FROM EntradaSalida e WHERE e.clientecliente = :clientecliente")
    , @NamedQuery(name = "EntradaSalida.findByformaDePagoformaDePago", query = "SELECT e FROM EntradaSalida e WHERE e.formaDePagoformaDePago = :formaDePagoformaDePago")
    , @NamedQuery(name = "EntradaSalida.findBymetodoDePagometodoDePago", query = "SELECT e FROM EntradaSalida e WHERE e.metodoDePagometodoDePago = :metodoDePagometodoDePago")
    , @NamedQuery(name = "EntradaSalida.findByusuariousuarioCreo", query = "SELECT e FROM EntradaSalida e WHERE e.usuariousuarioCreo = :usuariousuarioCreo")
    , @NamedQuery(name = "EntradaSalida.findByusuariousuario", query = "SELECT e FROM EntradaSalida e WHERE e.usuariousuario = :usuariousuario")
})
public class EntradaSalida implements java.io.Serializable {
    private static final long serialVersionUID = 791452441;
    
    /**
    * The 'ID' Maps to COLUMN 'ID'
    */
    
    @Id
    //@Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "ID" , nullable=false  )
    private Integer id;
    
    /**
    * The 'TIPO MOV' Maps to COLUMN 'TIPO_MOV'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "TIPO_MOV" , nullable=false)
    private int tipoMov;
    
    /**
    * The 'FECHA CREO' Maps to COLUMN 'FECHA_CREO'
    */
    
    @Basic(optional = false)
    // Hibernate Validator 5x is not compatible with validation-api 1.0.x
    //@NotNull
    @Column(name = "FECHA_CREO" , nullable=false)
    private java.sql.Timestamp fechaCreo;
    
    /**
    * The 'ESTADO ID ACTUAL' Maps to COLUMN 'ESTADO_ID_ACTUAL'
    */
    
    @JoinColumn(name = "ESTADO_ID_ACTUAL" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estado estadoestadoActual;
    
    /**
    * The 'CLIENTE ID' Maps to COLUMN 'CLIENTE_ID'
    */
    
    @JoinColumn(name = "CLIENTE_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente clientecliente;
    
    /**
    * The 'FORMA DE PAGO ID' Maps to COLUMN 'FORMA_DE_PAGO_ID'
    */
    
    @JoinColumn(name = "FORMA_DE_PAGO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FormaDePago formaDePagoformaDePago;
    
    /**
    * The 'METODO DE PAGO ID' Maps to COLUMN 'METODO_DE_PAGO_ID'
    */
    
    @JoinColumn(name = "METODO_DE_PAGO_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private MetodoDePago metodoDePagometodoDePago;
    
    /**
    * The 'USUARIO ID CREO' Maps to COLUMN 'USUARIO_ID_CREO'
    */
    
    @JoinColumn(name = "USUARIO_ID_CREO" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuariousuarioCreo;
    
    /**
    * The 'USUARIOID' Maps to COLUMN 'USUARIOID'
    */
    
    @JoinColumn(name = "USUARIOID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuariousuario;
    /** 
    * Map the relation to ENTRDA_SALIDA_ESTADO table where has ENTRADA_SALIDA_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaSalidaentradaSala")
    // ENTRDA_SALIDA_ESTADO Well know as EntrdaSalidaEstado
    private List<EntrdaSalidaEstado> entrdaSalidaEstadoThatHasThisEntradaSalidaentradaSalaList;
    
    /** 
    * Map the relation to CFD table where has ENTRADA_SALIDA_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaSalidaentradaSala")
    // CFD Well know as Cfd
    private List<Cfd> cfdThatHasThisEntradaSalidaentradaSalaList;
    

    
    @ManyToMany(mappedBy = "entradaSalidaList")
    private List<Producto> productoList;
    
	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public EntradaSalida() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public int getTipoMov() { return this.tipoMov;}
    public void setTipoMov(int v) { this.tipoMov = v; }
    
    public java.sql.Timestamp getFechaCreo() { return this.fechaCreo;}
    public void setFechaCreo(java.sql.Timestamp v) { this.fechaCreo = v; }
    
    public Estado getEstadoestadoActual(){ return this.estadoestadoActual ; }
    public void setEstadoestadoActual(Estado x){ this.estadoestadoActual = x; }
    
    public Cliente getClientecliente(){ return this.clientecliente ; }
    public void setClientecliente(Cliente x){ this.clientecliente = x; }
    
    public FormaDePago getFormaDePagoformaDePago(){ return this.formaDePagoformaDePago ; }
    public void setFormaDePagoformaDePago(FormaDePago x){ this.formaDePagoformaDePago = x; }
    
    public MetodoDePago getMetodoDePagometodoDePago(){ return this.metodoDePagometodoDePago ; }
    public void setMetodoDePagometodoDePago(MetodoDePago x){ this.metodoDePagometodoDePago = x; }
    
    public Usuario getUsuariousuarioCreo(){ return this.usuariousuarioCreo ; }
    public void setUsuariousuarioCreo(Usuario x){ this.usuariousuarioCreo = x; }
    
    public Usuario getUsuariousuario(){ return this.usuariousuario ; }
    public void setUsuariousuario(Usuario x){ this.usuariousuario = x; }
    
    // O2M <*>    
    public List<EntrdaSalidaEstado> getEntrdaSalidaEstadoThatHasThisEntradaSalidaentradaSalaList(){ return this.entrdaSalidaEstadoThatHasThisEntradaSalidaentradaSalaList; }
    public void setEntrdaSalidaEstadoThatHasThisEntradaSalidaentradaSalaList(List<EntrdaSalidaEstado> v){ this.entrdaSalidaEstadoThatHasThisEntradaSalidaentradaSalaList = v; }
    
    public List<Cfd> getCfdThatHasThisEntradaSalidaentradaSalaList(){ return this.cfdThatHasThisEntradaSalidaentradaSalaList; }
    public void setCfdThatHasThisEntradaSalidaentradaSalaList(List<Cfd> v){ this.cfdThatHasThisEntradaSalidaentradaSalaList = v; }
    
	// M2M <*>
    public List<Producto> getProductoList() { return this.productoList; }
    public void setProductoList(List<Producto>  v) { this.productoList = v; }
    

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(id).hashCode();
		hash += String.valueOf(tipoMov).hashCode();
		hash += String.valueOf(fechaCreo).hashCode();
		hash += String.valueOf(estadoestadoActual).hashCode();
		hash += String.valueOf(clientecliente).hashCode();
		hash += String.valueOf(formaDePagoformaDePago).hashCode();
		hash += String.valueOf(metodoDePagometodoDePago).hashCode();
		hash += String.valueOf(usuariousuarioCreo).hashCode();
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
        if (!(o instanceof EntradaSalida)) {
            return false;
        }		
		EntradaSalida other = (EntradaSalida ) o;
		if (!Objects.equals(this.id, other.id)) { return false; }		
		if (!Objects.equals(this.tipoMov, other.tipoMov)) { return false; }		
		if (!Objects.equals(this.fechaCreo, other.fechaCreo)) { return false; }		
		if (!Objects.equals(this.estadoestadoActual, other.estadoestadoActual)) { return false; }		
		if (!Objects.equals(this.clientecliente, other.clientecliente)) { return false; }		
		if (!Objects.equals(this.formaDePagoformaDePago, other.formaDePagoformaDePago)) { return false; }		
		if (!Objects.equals(this.metodoDePagometodoDePago, other.metodoDePagometodoDePago)) { return false; }		
		if (!Objects.equals(this.usuariousuarioCreo, other.usuariousuarioCreo)) { return false; }		
		if (!Objects.equals(this.usuariousuario, other.usuariousuario)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("EntradaSalida{");
		sb.append("id" ).append("=").append(id).append("|");
		sb.append("tipoMov" ).append("=").append(tipoMov).append("|");
		sb.append("fechaCreo" ).append("=").append(fechaCreo).append("|");
		sb.append("estadoestadoActual" ).append("=").append(estadoestadoActual).append("|");
		sb.append("clientecliente" ).append("=").append(clientecliente).append("|");
		sb.append("formaDePagoformaDePago" ).append("=").append(formaDePagoformaDePago).append("|");
		sb.append("metodoDePagometodoDePago" ).append("=").append(metodoDePagometodoDePago).append("|");
		sb.append("usuariousuarioCreo" ).append("=").append(usuariousuarioCreo).append("|");
		sb.append("usuariousuario" ).append("=").append(usuariousuario).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
