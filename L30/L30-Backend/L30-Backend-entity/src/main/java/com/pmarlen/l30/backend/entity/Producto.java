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
 * Class for mapping JPA Entity of Table PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

@Entity
@Table(name = "PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.countAll", query = "SELECT COUNT(p) FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodigoBarras", query = "SELECT p FROM Producto p WHERE p.codigoBarras = :codigoBarras")
    , @NamedQuery(name = "Producto.findByCodigoShcp", query = "SELECT p FROM Producto p WHERE p.codigoShcp = :codigoShcp")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByIndustria", query = "SELECT p FROM Producto p WHERE p.industria = :industria")
    , @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca")
    , @NamedQuery(name = "Producto.findByLinea", query = "SELECT p FROM Producto p WHERE p.linea = :linea")
    , @NamedQuery(name = "Producto.findByPresentacion", query = "SELECT p FROM Producto p WHERE p.presentacion = :presentacion")
    , @NamedQuery(name = "Producto.findByAbrebiatura", query = "SELECT p FROM Producto p WHERE p.abrebiatura = :abrebiatura")
    , @NamedQuery(name = "Producto.findByUnidadesXCaja", query = "SELECT p FROM Producto p WHERE p.unidadesXCaja = :unidadesXCaja")
    , @NamedQuery(name = "Producto.findByContenido", query = "SELECT p FROM Producto p WHERE p.contenido = :contenido")
    , @NamedQuery(name = "Producto.findByUnidadMedida", query = "SELECT p FROM Producto p WHERE p.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "Producto.findByUnidadEmpaque", query = "SELECT p FROM Producto p WHERE p.unidadEmpaque = :unidadEmpaque")
    , @NamedQuery(name = "Producto.findByCosto", query = "SELECT p FROM Producto p WHERE p.costo = :costo")
    , @NamedQuery(name = "Producto.findByCostoVenta", query = "SELECT p FROM Producto p WHERE p.costoVenta = :costoVenta")
    , @NamedQuery(name = "Producto.findByHabilitado", query = "SELECT p FROM Producto p WHERE p.habilitado = :habilitado")
    , @NamedQuery(name = "Producto.findByPoco", query = "SELECT p FROM Producto p WHERE p.poco = :poco")
})
public class Producto implements java.io.Serializable {
    private static final long serialVersionUID = 1149319664;
    
    /**
    * The 'CODIGO BARRAS' Maps to COLUMN 'CODIGO_BARRAS'
    */
    
    @Id
    //@Basic(optional = false)
    @Size(min = 1, max = 128)
    //@NotNull
    @Column(name = "CODIGO_BARRAS" , length=128, nullable=false  )
    private String codigoBarras;
    
    /**
    * The 'CODIGO SHCP' Maps to COLUMN 'CODIGO_SHCP'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "CODIGO_SHCP" , length=128, nullable=false)
    private String codigoShcp;
    
    /**
    * The 'NOMBRE' Maps to COLUMN 'NOMBRE'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMBRE" , length=255, nullable=false)
    private String nombre;
    
    /**
    * The 'INDUSTRIA' Maps to COLUMN 'INDUSTRIA'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "INDUSTRIA" , length=255, nullable=false)
    private String industria;
    
    /**
    * The 'MARCA' Maps to COLUMN 'MARCA'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MARCA" , length=255, nullable=false)
    private String marca;
    
    /**
    * The 'LINEA' Maps to COLUMN 'LINEA'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LINEA" , length=255, nullable=false)
    private String linea;
    
    /**
    * The 'PRESENTACION' Maps to COLUMN 'PRESENTACION'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "PRESENTACION" , length=128, nullable=false)
    private String presentacion;
    
    /**
    * The 'ABREBIATURA' Maps to COLUMN 'ABREBIATURA'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ABREBIATURA" , length=32, nullable=false)
    private String abrebiatura;
    
    /**
    * The 'UNIDADES X CAJA' Maps to COLUMN 'UNIDADES_X_CAJA'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIDADES_X_CAJA" , nullable=false)
    private int unidadesXCaja;
    
    /**
    * The 'CONTENIDO' Maps to COLUMN 'CONTENIDO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CONTENIDO" , length=16, nullable=false)
    private String contenido;
    
    /**
    * The 'UNIDAD MEDIDA' Maps to COLUMN 'UNIDAD_MEDIDA'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "UNIDAD_MEDIDA" , length=8, nullable=false)
    private String unidadMedida;
    
    /**
    * The 'UNIDAD EMPAQUE' Maps to COLUMN 'UNIDAD_EMPAQUE'
    */
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "UNIDAD_EMPAQUE" , length=10, nullable=false)
    private String unidadEmpaque;
    
    /**
    * The 'COSTO' Maps to COLUMN 'COSTO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO" , nullable=false)
    private double costo;
    
    /**
    * The 'COSTO VENTA' Maps to COLUMN 'COSTO_VENTA'
    */
    
    @Basic(optional = true)
    @Column(name = "COSTO_VENTA" , nullable=true)
    private Double costoVenta;
    
    /**
    * The 'HABILITADO' Maps to COLUMN 'HABILITADO'
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADO" , nullable=false)
    private int habilitado;
    
    /**
    * The 'POCO' Maps to COLUMN 'POCO'
    */
    
    @Basic(optional = true)
    @Column(name = "POCO" , nullable=true)
    private Integer poco;
    /** 
    * Map the relation to OFERTA_PRODUCTO table where has PRODUCTO_CODIGO_BARRAS object mapped column of for this class.
    */ 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoproducto")
    // OFERTA_PRODUCTO Well know as OfertaProducto
    private List<OfertaProducto> ofertaProductoThatHasThisProductoproductoList;
    

    
    @JoinTable(name               = "ENTRADA_SALIDA_DETALLE",
               joinColumns        = {@JoinColumn(name = "PRODUCTO_CODIGO_BARRAS", referencedColumnName ="CODIGO_BARRAS")},
               inverseJoinColumns = {@JoinColumn(name = "ENTRADA_SALIDA_ID", referencedColumnName ="ID")}
               )
    @ManyToMany //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EntradaSalida> entradaSalidaList;
    
	// =========================================================================
    // =========================================================================
    /** 
     * Default Constructor
     */
    public Producto() {
    }
    
    /**
     * Getters and Setters
     */
    public String getCodigoBarras() { return this.codigoBarras;}
    public void setCodigoBarras(String v) { this.codigoBarras = v; }
    
    public String getCodigoShcp() { return this.codigoShcp;}
    public void setCodigoShcp(String v) { this.codigoShcp = v; }
    
    public String getNombre() { return this.nombre;}
    public void setNombre(String v) { this.nombre = v; }
    
    public String getIndustria() { return this.industria;}
    public void setIndustria(String v) { this.industria = v; }
    
    public String getMarca() { return this.marca;}
    public void setMarca(String v) { this.marca = v; }
    
    public String getLinea() { return this.linea;}
    public void setLinea(String v) { this.linea = v; }
    
    public String getPresentacion() { return this.presentacion;}
    public void setPresentacion(String v) { this.presentacion = v; }
    
    public String getAbrebiatura() { return this.abrebiatura;}
    public void setAbrebiatura(String v) { this.abrebiatura = v; }
    
    public int getUnidadesXCaja() { return this.unidadesXCaja;}
    public void setUnidadesXCaja(int v) { this.unidadesXCaja = v; }
    
    public String getContenido() { return this.contenido;}
    public void setContenido(String v) { this.contenido = v; }
    
    public String getUnidadMedida() { return this.unidadMedida;}
    public void setUnidadMedida(String v) { this.unidadMedida = v; }
    
    public String getUnidadEmpaque() { return this.unidadEmpaque;}
    public void setUnidadEmpaque(String v) { this.unidadEmpaque = v; }
    
    public double getCosto() { return this.costo;}
    public void setCosto(double v) { this.costo = v; }
    
    public Double getCostoVenta() { return this.costoVenta;}
    public void setCostoVenta(Double v) { this.costoVenta = v; }
    
    public int getHabilitado() { return this.habilitado;}
    public void setHabilitado(int v) { this.habilitado = v; }
    
    public Integer getPoco() { return this.poco;}
    public void setPoco(Integer v) { this.poco = v; }
    
    // O2M <*>    
    public List<OfertaProducto> getOfertaProductoThatHasThisProductoproductoList(){ return this.ofertaProductoThatHasThisProductoproductoList; }
    public void setOfertaProductoThatHasThisProductoproductoList(List<OfertaProducto> v){ this.ofertaProductoThatHasThisProductoproductoList = v; }
    
	// M2M <*>
    public List<EntradaSalida> getEntradaSalidaList() { return this.entradaSalidaList; }
    public void setEntradaSalidaList(List<EntradaSalida>  v) { this.entradaSalidaList = v; }
    

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(codigoBarras).hashCode();
		hash += String.valueOf(codigoShcp).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(industria).hashCode();
		hash += String.valueOf(marca).hashCode();
		hash += String.valueOf(linea).hashCode();
		hash += String.valueOf(presentacion).hashCode();
		hash += String.valueOf(abrebiatura).hashCode();
		hash += String.valueOf(unidadesXCaja).hashCode();
		hash += String.valueOf(contenido).hashCode();
		hash += String.valueOf(unidadMedida).hashCode();
		hash += String.valueOf(unidadEmpaque).hashCode();
		hash += String.valueOf(costo).hashCode();
		hash += String.valueOf(costoVenta).hashCode();
		hash += String.valueOf(habilitado).hashCode();
		hash += String.valueOf(poco).hashCode();
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
        if (!(o instanceof Producto)) {
            return false;
        }		
		Producto other = (Producto ) o;
		if (!Objects.equals(this.codigoBarras, other.codigoBarras)) { return false; }		
		if (!Objects.equals(this.codigoShcp, other.codigoShcp)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.industria, other.industria)) { return false; }		
		if (!Objects.equals(this.marca, other.marca)) { return false; }		
		if (!Objects.equals(this.linea, other.linea)) { return false; }		
		if (!Objects.equals(this.presentacion, other.presentacion)) { return false; }		
		if (!Objects.equals(this.abrebiatura, other.abrebiatura)) { return false; }		
		if (!Objects.equals(this.unidadesXCaja, other.unidadesXCaja)) { return false; }		
		if (!Objects.equals(this.contenido, other.contenido)) { return false; }		
		if (!Objects.equals(this.unidadMedida, other.unidadMedida)) { return false; }		
		if (!Objects.equals(this.unidadEmpaque, other.unidadEmpaque)) { return false; }		
		if (!Objects.equals(this.costo, other.costo)) { return false; }		
		if (!Objects.equals(this.costoVenta, other.costoVenta)) { return false; }		
		if (!Objects.equals(this.habilitado, other.habilitado)) { return false; }		
		if (!Objects.equals(this.poco, other.poco)) { return false; }		
    	return true;
    }

	/**
	* to-do override using commons
	*/
    @Override
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Producto{");
		sb.append("codigoBarras" ).append("=").append(codigoBarras).append("|");
		sb.append("codigoShcp" ).append("=").append(codigoShcp).append("|");
		sb.append("nombre" ).append("=").append(nombre).append("|");
		sb.append("industria" ).append("=").append(industria).append("|");
		sb.append("marca" ).append("=").append(marca).append("|");
		sb.append("linea" ).append("=").append(linea).append("|");
		sb.append("presentacion" ).append("=").append(presentacion).append("|");
		sb.append("abrebiatura" ).append("=").append(abrebiatura).append("|");
		sb.append("unidadesXCaja" ).append("=").append(unidadesXCaja).append("|");
		sb.append("contenido" ).append("=").append(contenido).append("|");
		sb.append("unidadMedida" ).append("=").append(unidadMedida).append("|");
		sb.append("unidadEmpaque" ).append("=").append(unidadEmpaque).append("|");
		sb.append("costo" ).append("=").append(costo).append("|");
		sb.append("costoVenta" ).append("=").append(costoVenta).append("|");
		sb.append("habilitado" ).append("=").append(habilitado).append("|");
		sb.append("poco" ).append("=").append(poco).append("|");
		sb.append("serialVersionUID=").append(serialVersionUID).append("}");
		return sb.toString();
	}

}
