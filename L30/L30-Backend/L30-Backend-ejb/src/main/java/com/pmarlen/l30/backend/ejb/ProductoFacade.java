package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Producto;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ProductoFacade() {
		super(Producto.class);
	}

	@Override
	public List<Producto> findAllLike(Producto x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Producto x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getCodigoBarras() != null){
			    paramAsigned++;
			    sbq.append(" and x.codigoBarras = :codigoBarras");
			}
			if(x.getCodigoShcp() != null){
			    paramAsigned++;
			    sbq.append(" and x.codigoShcp = :codigoShcp");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getIndustria() != null){
			    paramAsigned++;
			    sbq.append(" and x.industria = :industria");
			}
			if(x.getMarca() != null){
			    paramAsigned++;
			    sbq.append(" and x.marca = :marca");
			}
			if(x.getLinea() != null){
			    paramAsigned++;
			    sbq.append(" and x.linea = :linea");
			}
			if(x.getPresentacion() != null){
			    paramAsigned++;
			    sbq.append(" and x.presentacion = :presentacion");
			}
			if(x.getAbrebiatura() != null){
			    paramAsigned++;
			    sbq.append(" and x.abrebiatura = :abrebiatura");
			}
			if(x.getUnidadesXCaja() != 0){
			    paramAsigned++;
			    sbq.append(" and x.unidadesXCaja = :unidadesXCaja");
			}
			if(x.getContenido() != null){
			    paramAsigned++;
			    sbq.append(" and x.contenido = :contenido");
			}
			if(x.getUnidadMedida() != null){
			    paramAsigned++;
			    sbq.append(" and x.unidadMedida = :unidadMedida");
			}
			if(x.getUnidadEmpaque() != null){
			    paramAsigned++;
			    sbq.append(" and x.unidadEmpaque = :unidadEmpaque");
			}
			if(x.getCosto() != 0){
			    paramAsigned++;
			    sbq.append(" and x.costo = :costo");
			}
			if(x.getCostoVenta() != null){
			    paramAsigned++;
			    sbq.append(" and x.costoVenta = :costoVenta");
			}
			if(x.getHabilitado() != 0){
			    paramAsigned++;
			    sbq.append(" and x.habilitado = :habilitado");
			}
			if(x.getPoco() != null){
			    paramAsigned++;
			    sbq.append(" and x.poco = :poco");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Producto> nq = em.createQuery(sbq.toString(), Producto.class);
		
		if(paramAsigned>0){
			if(x.getCodigoBarras() != null){
			    nq.setParameter("codigoBarras",x.getCodigoBarras());
			}
			if(x.getCodigoShcp() != null){
			    nq.setParameter("codigoShcp",x.getCodigoShcp());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getIndustria() != null){
			    nq.setParameter("industria",x.getIndustria());
			}
			if(x.getMarca() != null){
			    nq.setParameter("marca",x.getMarca());
			}
			if(x.getLinea() != null){
			    nq.setParameter("linea",x.getLinea());
			}
			if(x.getPresentacion() != null){
			    nq.setParameter("presentacion",x.getPresentacion());
			}
			if(x.getAbrebiatura() != null){
			    nq.setParameter("abrebiatura",x.getAbrebiatura());
			}
			if(x.getUnidadesXCaja() != (0) ){
			    nq.setParameter("unidadesXCaja",x.getUnidadesXCaja());
			}
			if(x.getContenido() != null){
			    nq.setParameter("contenido",x.getContenido());
			}
			if(x.getUnidadMedida() != null){
			    nq.setParameter("unidadMedida",x.getUnidadMedida());
			}
			if(x.getUnidadEmpaque() != null){
			    nq.setParameter("unidadEmpaque",x.getUnidadEmpaque());
			}
			if(x.getCosto() != (0) ){
			    nq.setParameter("costo",x.getCosto());
			}
			if(x.getCostoVenta() != null){
			    nq.setParameter("costoVenta",x.getCostoVenta());
			}
			if(x.getHabilitado() != (0) ){
			    nq.setParameter("habilitado",x.getHabilitado());
			}
			if(x.getPoco() != null){
			    nq.setParameter("poco",x.getPoco());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Producto> findAll() {
		TypedQuery<Producto> nq = em.createNamedQuery("Producto.findAll", Producto.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Producto.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
