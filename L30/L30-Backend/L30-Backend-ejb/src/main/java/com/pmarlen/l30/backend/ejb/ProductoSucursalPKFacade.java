package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.ProductoSucursalPK;
import com.pmarlen.l30.backend.remote.ProductoSucursalPKFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table PRODUCTO_SUCURSAL_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class ProductoSucursalPKFacade extends AbstractFacade<ProductoSucursalPK> implements ProductoSucursalPKFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ProductoSucursalPKFacade() {
		super(ProductoSucursalPK.class);
	}

	@Override
	public List<ProductoSucursalPK> findAllLike(ProductoSucursalPK x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM ProductoSucursalPK x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getProductoCodigoBarras() != null){
			    paramAsigned++;
			    sbq.append(" and x.productoCodigoBarras = :productoCodigoBarras");
			}
			if(x.getSucursalId() != null){
			    paramAsigned++;
			    sbq.append(" and x.sucursalId = :sucursalId");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<ProductoSucursalPK> nq = em.createQuery(sbq.toString(), ProductoSucursalPK.class);
		
		if(paramAsigned>0){
			if(x.getProductoCodigoBarras() != null){
			    nq.setParameter("productoCodigoBarras",x.getProductoCodigoBarras());
			}
			if(x.getSucursalId() != null){
			    nq.setParameter("sucursalId",x.getSucursalId());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<ProductoSucursalPK> findAll() {
		TypedQuery<ProductoSucursalPK> nq = em.createNamedQuery("ProductoSucursalPK.findAll", ProductoSucursalPK.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("ProductoSucursalPK.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
