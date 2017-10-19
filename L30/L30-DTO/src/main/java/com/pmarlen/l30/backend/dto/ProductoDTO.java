package com.pmarlen.l30.backend.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table PRODUCTO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */

public class ProductoDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1149319664;

    
    /**
    * codigo barras
    */
    private String codigoBarras;
    
    /**
    * codigo shcp
    */
    private String codigoShcp;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * industria
    */
    private String industria;
    
    /**
    * marca
    */
    private String marca;
    
    /**
    * linea
    */
    private String linea;
    
    /**
    * presentacion
    */
    private String presentacion;
    
    /**
    * abrebiatura
    */
    private String abrebiatura;
    
    /**
    * unidades x caja
    */
    private int unidadesXCaja;
    
    /**
    * contenido
    */
    private String contenido;
    
    /**
    * unidad medida
    */
    private String unidadMedida;
    
    /**
    * unidad empaque
    */
    private String unidadEmpaque;
    
    /**
    * costo
    */
    private double costo;
    
    /**
    * costo venta
    */
    private Double costoVenta;
    
    /**
    * habilitado
    */
    private int habilitado;
    
    /**
    * poco
    */
    private Integer poco;

    /** 
     * Default Constructor
     */
    public ProductoDTO() {
    }

    /**
     * Getters and Setters
     */
    public String getCodigoBarras() {
        return this.codigoBarras;
    }
    public void setCodigoBarras(String v) {
        this.codigoBarras = v;
    }
    public String getCodigoShcp() {
        return this.codigoShcp;
    }
    public void setCodigoShcp(String v) {
        this.codigoShcp = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getIndustria() {
        return this.industria;
    }
    public void setIndustria(String v) {
        this.industria = v;
    }
    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String v) {
        this.marca = v;
    }
    public String getLinea() {
        return this.linea;
    }
    public void setLinea(String v) {
        this.linea = v;
    }
    public String getPresentacion() {
        return this.presentacion;
    }
    public void setPresentacion(String v) {
        this.presentacion = v;
    }
    public String getAbrebiatura() {
        return this.abrebiatura;
    }
    public void setAbrebiatura(String v) {
        this.abrebiatura = v;
    }
    public int getUnidadesXCaja() {
        return this.unidadesXCaja;
    }
    public void setUnidadesXCaja(int v) {
        this.unidadesXCaja = v;
    }
    public String getContenido() {
        return this.contenido;
    }
    public void setContenido(String v) {
        this.contenido = v;
    }
    public String getUnidadMedida() {
        return this.unidadMedida;
    }
    public void setUnidadMedida(String v) {
        this.unidadMedida = v;
    }
    public String getUnidadEmpaque() {
        return this.unidadEmpaque;
    }
    public void setUnidadEmpaque(String v) {
        this.unidadEmpaque = v;
    }
    public double getCosto() {
        return this.costo;
    }
    public void setCosto(double v) {
        this.costo = v;
    }
    public Double getCostoVenta() {
        return this.costoVenta;
    }
    public void setCostoVenta(Double v) {
        this.costoVenta = v;
    }
    public int getHabilitado() {
        return this.habilitado;
    }
    public void setHabilitado(int v) {
        this.habilitado = v;
    }
    public Integer getPoco() {
        return this.poco;
    }
    public void setPoco(Integer v) {
        this.poco = v;
    }

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
        if (!(o instanceof ProductoDTO)) {
            return false;
        }		
		ProductoDTO  other = (ProductoDTO ) o;
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
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("codigoBarras", this.codigoBarras);
		jsonObj.put("codigoShcp", this.codigoShcp);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("industria", this.industria);
		jsonObj.put("marca", this.marca);
		jsonObj.put("linea", this.linea);
		jsonObj.put("presentacion", this.presentacion);
		jsonObj.put("abrebiatura", this.abrebiatura);
		jsonObj.put("unidadesXCaja", this.unidadesXCaja);
		jsonObj.put("contenido", this.contenido);
		jsonObj.put("unidadMedida", this.unidadMedida);
		jsonObj.put("unidadEmpaque", this.unidadEmpaque);
		jsonObj.put("costo", this.costo);
		jsonObj.put("costoVenta", this.costoVenta);
		jsonObj.put("habilitado", this.habilitado);
		jsonObj.put("poco", this.poco);
		return jsonObj.toString();
    }

	public static ProductoDTO create(String json) throws IllegalArgumentException{
		ProductoDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.codigoBarras = (jObj.getString("codigoBarras"));
		x.codigoShcp = (jObj.getString("codigoShcp"));
		x.nombre = (jObj.getString("nombre"));
		x.industria = (jObj.getString("industria"));
		x.marca = (jObj.getString("marca"));
		x.linea = (jObj.getString("linea"));
		x.presentacion = (jObj.getString("presentacion"));
		x.abrebiatura = (jObj.getString("abrebiatura"));
		x.unidadesXCaja = (jObj.getInt("unidadesXCaja"));
		x.contenido = (jObj.getString("contenido"));
		x.unidadMedida = (jObj.getString("unidadMedida"));
		x.unidadEmpaque = (jObj.getString("unidadEmpaque"));
		x.costo = (jObj.getDouble("costo"));
		x.costoVenta = (jObj.getDouble("costoVenta"));
		x.habilitado = (jObj.getInt("habilitado"));
		x.poco = (jObj.getInt("poco"));
		
		return x;
	}

}
