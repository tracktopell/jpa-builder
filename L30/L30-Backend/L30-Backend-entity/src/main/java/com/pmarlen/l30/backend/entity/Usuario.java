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
 * Class for mapping JPA Entity of Table USUARIO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */

@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.countAll", query = "SELECT COUNT(u) FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
    , @NamedQuery(name = "Usuario.findByTelefonos", query = "SELECT u FROM Usuario u WHERE u.telefonos = :telefonos")
    , @NamedQuery(name = "Usuario.findByHabilitado", query = "SELECT u FROM Usuario u WHERE u.habilitado = :habilitado")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellidoPaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Usuario.findByApellidoMaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Usuario.findByFechaRegistro", query = "SELECT u FROM Usuario u WHERE u.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Usuario.findByFechaUltCambio", query = "SELECT u FROM Usuario u WHERE u.fechaUltCambio = :fechaUltCambio")
    , @NamedQuery(name = "Usuario.findBysucursalsucursal", query = "SELECT u FROM Usuario u WHERE u.sucursalsucursal = :sucursalsucursal")
})
public class Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1747585824;
    
    /**
    * The 'ID' Maps to COLUMN 'ID'
    */
    
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "ID" , nullable=false  )
    private Integer id;
    
    /**
    * The 'EMAIL' Maps to COLUMN 'EMAIL'
    */
    
    @Basic(optional = true)
    @Size(max = 128)
    @Column(name = "EMAIL" , length=128, nullable=true)
    private String email;
    
    /**
    * The 'PASSWORD' Maps to COLUMN 'PASSWORD'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "PASSWORD" , length=128, nullable=false)
    private String password;
    
    /**
    * The 'TELEFONOS' Maps to COLUMN 'TELEFONOS'
    */
    
    @Basic(optional = true)
    @Size(max = 64)
    @Column(name = "TELEFONOS" , length=64, nullable=true)
    private String telefonos;
    
    /**
    * The 'HABILITADO' Maps to COLUMN 'HABILITADO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADO" , nullable=false)
    private int habilitado;
    
    /**
    * The 'NOMBRE' Maps to COLUMN 'NOMBRE'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NOMBRE" , length=64, nullable=false)
    private String nombre;
    
    /**
    * The 'APELLIDO PATERNO' Maps to COLUMN 'APELLIDO_PATERNO'
    */
    
    @Basic(optional = true)
    @Size(max = 64)
    @Column(name = "APELLIDO_PATERNO" , length=64, nullable=true)
    private String apellidoPaterno;
    
    /**
    * The 'APELLIDO MATERNO' Maps to COLUMN 'APELLIDO_MATERNO'
    */
    
    @Basic(optional = true)
    @Size(max = 64)
    @Column(name = "APELLIDO_MATERNO" , length=64, nullable=true)
    private String apellidoMaterno;
    
    /**
    * The 'FECHA REGISTRO' Maps to COLUMN 'FECHA_REGISTRO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO" , nullable=false)
    private java.sql.Timestamp fechaRegistro;
    
    /**
    * The 'FECHA ULT  CAMBIO' Maps to COLUMN 'FECHA_ULT__CAMBIO'
    */
    
    @Basic(optional = true)
    @Column(name = "FECHA_ULT__CAMBIO" , nullable=true)
    private java.sql.Timestamp fechaUltCambio;
    
    /**
    * The 'SUCURSAL ID' Maps to COLUMN 'SUCURSAL_ID'
    */
    
    @JoinColumn(name = "SUCURSAL_ID" , referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursalsucursal;
    /** 
    * Map the relation to CORTE_CAJA table where has USUARIO_ID_AUTORIZO object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariousuarioAutorizo")
    // CORTE_CAJA Well know as CorteCaja
    private List<CorteCaja> corteCajaThatHasThisUsuariousuarioAutorizoList;
    
    /** 
    * Map the relation to CORTE_CAJA table where has USUARIO_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariousuario")
    // CORTE_CAJA Well know as CorteCaja
    private List<CorteCaja> corteCajaThatHasThisUsuariousuarioList;
    
    /** 
    * Map the relation to ENTRADA_SALIDA table where has USUARIOID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariousuario")
    // ENTRADA_SALIDA Well know as EntradaSalida
    private List<EntradaSalida> entradaSalidaThatHasThisUsuariousuarioList;
    
    /** 
    * Map the relation to ENTRADA_SALIDA table where has USUARIO_ID_CREO object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariousuarioCreo")
    // ENTRADA_SALIDA Well know as EntradaSalida
    private List<EntradaSalida> entradaSalidaThatHasThisUsuariousuarioCreoList;
    
    /** 
    * Map the relation to ENTRDA_SALIDA_ESTADO table where has USUARIO_ID object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariousuario")
    // ENTRDA_SALIDA_ESTADO Well know as EntrdaSalidaEstado
    private List<EntrdaSalidaEstado> entrdaSalidaEstadoThatHasThisUsuariousuarioList;
    

	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Usuario() {
    }
    
    /**
     * Getters and Setters
     */
    public Integer getId() { return this.id;}
    public void setId(Integer v) { this.id = v; }
    
    public String getEmail() { return this.email;}
    public void setEmail(String v) { this.email = v; }
    
    public String getPassword() { return this.password;}
    public void setPassword(String v) { this.password = v; }
    
    public String getTelefonos() { return this.telefonos;}
    public void setTelefonos(String v) { this.telefonos = v; }
    
    public int getHabilitado() { return this.habilitado;}
    public void setHabilitado(int v) { this.habilitado = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getApellidoPaterno() { return this.apellidoPaterno;}
    public void setApellidoPaterno(String v) { this.apellidoPaterno = v; }
    
    public String getApellidoMaterno() { return this.apellidoMaterno;}
    public void setApellidoMaterno(String v) { this.apellidoMaterno = v; }
    
    public java.sql.Timestamp getFechaRegistro() { return this.fechaRegistro;}
    public void setFechaRegistro(java.sql.Timestamp v) { this.fechaRegistro = v; }
    
    public java.sql.Timestamp getFechaUltCambio() { return this.fechaUltCambio;}
    public void setFechaUltCambio(java.sql.Timestamp v) { this.fechaUltCambio = v; }
    
    public Sucursal getSucursalsucursal(){ return this.sucursalsucursal ; }
    public void setSucursalsucursal(Sucursal x){ this.sucursalsucursal = x; }
    
    // O2M <*>    
    public List<CorteCaja> getCorteCajaThatHasThisUsuariousuarioAutorizoList(){ return this.corteCajaThatHasThisUsuariousuarioAutorizoList; }
    public void setCorteCajaThatHasThisUsuariousuarioAutorizoList(List<CorteCaja> v){ this.corteCajaThatHasThisUsuariousuarioAutorizoList = v; }
    
    public List<CorteCaja> getCorteCajaThatHasThisUsuariousuarioList(){ return this.corteCajaThatHasThisUsuariousuarioList; }
    public void setCorteCajaThatHasThisUsuariousuarioList(List<CorteCaja> v){ this.corteCajaThatHasThisUsuariousuarioList = v; }
    
    public List<EntradaSalida> getEntradaSalidaThatHasThisUsuariousuarioList(){ return this.entradaSalidaThatHasThisUsuariousuarioList; }
    public void setEntradaSalidaThatHasThisUsuariousuarioList(List<EntradaSalida> v){ this.entradaSalidaThatHasThisUsuariousuarioList = v; }
    
    public List<EntradaSalida> getEntradaSalidaThatHasThisUsuariousuarioCreoList(){ return this.entradaSalidaThatHasThisUsuariousuarioCreoList; }
    public void setEntradaSalidaThatHasThisUsuariousuarioCreoList(List<EntradaSalida> v){ this.entradaSalidaThatHasThisUsuariousuarioCreoList = v; }
    
    public List<EntrdaSalidaEstado> getEntrdaSalidaEstadoThatHasThisUsuariousuarioList(){ return this.entrdaSalidaEstadoThatHasThisUsuariousuarioList; }
    public void setEntrdaSalidaEstadoThatHasThisUsuariousuarioList(List<EntrdaSalidaEstado> v){ this.entrdaSalidaEstadoThatHasThisUsuariousuarioList = v; }
    
	// M2M <*>

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
		hash += String.valueOf(sucursalsucursal).hashCode();
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
        if (!(o instanceof Usuario)) {
            return false;
        }		
		Usuario other = (Usuario ) o;
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
		if (!Objects.equals(this.sucursalsucursal, other.sucursalsucursal)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Usuario{");
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
		sb.append("sucursalsucursal" ).append("=").append(sucursalsucursal).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
