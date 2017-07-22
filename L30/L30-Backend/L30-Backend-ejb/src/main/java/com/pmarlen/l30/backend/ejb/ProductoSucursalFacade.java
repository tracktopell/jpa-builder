package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.ProductoSucursal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table PRODUCTO_SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */
@Stateless
public class ProductoSucursalFacade extends AbstractFacade<ProductoSucursal> implements ProductoSucursalFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ProductoSucursalFacade() {
		super(ProductoSucursal.class);
	}

	@Override
	public List<ProductoSucursal> findAllLike(ProductoSucursal x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM ProductoSucursal x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getProductoSucursalPK() != null){
			    paramAsigned++;
			    sbq.append(" and x.productoSucursalPK = :productoSucursalPK");
			}
			if(x.getCantidad1ra() != 0){
			    paramAsigned++;
			    sbq.append(" and x.cantidad1ra = :cantidad1ra");
			}
			if(x.getPrecio1ra() != 0){
			    paramAsigned++;
			    sbq.append(" and x.precio1ra = :precio1ra");
			}
			if(x.getCantidadOpo() != 0){
			    paramAsigned++;
			    sbq.append(" and x.cantidadOpo = :cantidadOpo");
			}
			if(x.getPrecioOpo() != 0){
			    paramAsigned++;
			    sbq.append(" and x.precioOpo = :precioOpo");
			}
			if(x.getCantidadReg() != 0){
			    paramAsigned++;
			    sbq.append(" and x.cantidadReg = :cantidadReg");
			}
			if(x.getPrecioReg() != 0){
			    paramAsigned++;
			    sbq.append(" and x.precioReg = :precioReg");
			}
			if(x.getProductoproducto() != null){
			    paramAsigned++;
			    sbq.append(" and x.productoproducto = :productoproducto");
			}
			if(x.getSucursalsucursal() != null){
			    paramAsigned++;
			    sbq.append(" and x.sucursalsucursal = :sucursalsucursal");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<ProductoSucursal> nq = em.createQuery(sbq.toString(), ProductoSucursal.class);
		
		if(paramAsigned>0){
			if(x.getProductoSucursalPK() != null){
			    nq.setParameter("productoSucursalPK",x.getProductoSucursalPK());
			}
			if(x.getCantidad1ra() != (0) ){
			    nq.setParameter("cantidad1ra",x.getCantidad1ra());
			}
			if(x.getPrecio1ra() != (0) ){
			    nq.setParameter("precio1ra",x.getPrecio1ra());
			}
			if(x.getCantidadOpo() != (0) ){
			    nq.setParameter("cantidadOpo",x.getCantidadOpo());
			}
			if(x.getPrecioOpo() != (0) ){
			    nq.setParameter("precioOpo",x.getPrecioOpo());
			}
			if(x.getCantidadReg() != (0) ){
			    nq.setParameter("cantidadReg",x.getCantidadReg());
			}
			if(x.getPrecioReg() != (0) ){
			    nq.setParameter("precioReg",x.getPrecioReg());
			}
			if(x.getProductoproducto() != null){
			    nq.setParameter("productoproducto",x.getProductoproducto());
			}
			if(x.getSucursalsucursal() != null){
			    nq.setParameter("sucursalsucursal",x.getSucursalsucursal());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<ProductoSucursal> findAll() {
		TypedQuery<ProductoSucursal> nq = em.createNamedQuery("ProductoSucursal.findAll", ProductoSucursal.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("ProductoSucursal.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
