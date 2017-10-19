package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.ProductoSucursal;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table PRODUCTO_SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/19 00:02
 */

public class ProductoSucursalAssembler {    
    
    /** 
     * Private Constructor
     */
    private ProductoSucursalAssembler() {
    }

    public static ProductoSucursal buildJpaEntity(ProductoSucursalDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		ProductoSucursal jpaEntity = new ProductoSucursal();

        // ProductoSucursalPK is Embeddable. Begin nested settings
        jpaEntity.getProductoSucursalPK().setSucursalId( dtoEntity.getSucursalId() );  // nested FKs > BUG
        jpaEntity.getProductoSucursalPK().setProductoCodigoBarras( dtoEntity.getProductoCodigoBarras() );  // nested FKs > BUG
        // End nested settings
        jpaEntity.setCantidad1ra( dtoEntity.getCantidad1ra()); // normal
        jpaEntity.setPrecio1ra( dtoEntity.getPrecio1ra()); // normal
        jpaEntity.setCantidadOpo( dtoEntity.getCantidadOpo()); // normal
        jpaEntity.setPrecioOpo( dtoEntity.getPrecioOpo()); // normal
        jpaEntity.setCantidadReg( dtoEntity.getCantidadReg()); // normal
        jpaEntity.setPrecioReg( dtoEntity.getPrecioReg()); // normal
        ProductoDTO productoproductoDTO = new ProductoDTO();
        productoproductoDTO.setCodigoBarras( dtoEntity.getProductoCodigoBarras());
        jpaEntity.setProductoproducto( ProductoAssembler.buildJpaEntity( productoproductoDTO ));
        SucursalDTO sucursalsucursalDTO = new SucursalDTO();
        sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
        jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));

        return jpaEntity;
    }

    public static List<ProductoSucursal> buildJpaEntityList(List<ProductoSucursalDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<ProductoSucursal> jpaEntityList = new ArrayList<>();
		ProductoSucursal jpaEntity = null;
		for(ProductoSucursalDTO dtoEntity: dtoEntityList){
			jpaEntity = new ProductoSucursal();
            // ProductoSucursalPK is Embeddable. Begin nested settings
            jpaEntity.getProductoSucursalPK().setSucursalId( dtoEntity.getSucursalId() );  // nested FKs > BUG
            jpaEntity.getProductoSucursalPK().setProductoCodigoBarras( dtoEntity.getProductoCodigoBarras() );  // nested FKs > BUG
            // End nested settings
            jpaEntity.setCantidad1ra( dtoEntity.getCantidad1ra());
            jpaEntity.setPrecio1ra( dtoEntity.getPrecio1ra());
            jpaEntity.setCantidadOpo( dtoEntity.getCantidadOpo());
            jpaEntity.setPrecioOpo( dtoEntity.getPrecioOpo());
            jpaEntity.setCantidadReg( dtoEntity.getCantidadReg());
            jpaEntity.setPrecioReg( dtoEntity.getPrecioReg());
            ProductoDTO productoproductoDTO = new ProductoDTO();
            productoproductoDTO.setCodigoBarras( dtoEntity.getProductoCodigoBarras());
            jpaEntity.setProductoproducto( ProductoAssembler.buildJpaEntity( productoproductoDTO ));
            SucursalDTO sucursalsucursalDTO = new SucursalDTO();
            sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
            jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ProductoSucursalDTO buildDTOEntity(ProductoSucursal jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ProductoSucursalDTO dtoEntity =  new ProductoSucursalDTO();		

        // Embedable: ProductoSucursalPK, begin nested settings
        dtoEntity.setSucursalId( jpaEntity.getProductoSucursalPK().getSucursalId() ); // bug 3 ?
        dtoEntity.setProductoCodigoBarras( jpaEntity.getProductoSucursalPK().getProductoCodigoBarras() ); // bug 3 ?
        // End nested settings
        dtoEntity.setCantidad1ra( jpaEntity.getCantidad1ra() ); // primitive
        dtoEntity.setPrecio1ra( jpaEntity.getPrecio1ra() ); // primitive
        dtoEntity.setCantidadOpo( jpaEntity.getCantidadOpo() ); // primitive
        dtoEntity.setPrecioOpo( jpaEntity.getPrecioOpo() ); // primitive
        dtoEntity.setCantidadReg( jpaEntity.getCantidadReg() ); // primitive
        dtoEntity.setPrecioReg( jpaEntity.getPrecioReg() ); // primitive
        //Not Embedable: ProductoCodigoBarras -> Producto, FTable: PRODUCTO, HyperName:PRODUCTOPRODUCTO_
        dtoEntity.setProductoCodigoBarras( jpaEntity.getProductoproducto()!=null?jpaEntity.getProductoproducto().getCodigoBarras():null);
        //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
        dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);

        return dtoEntity;
    }

	public static List<ProductoSucursalDTO> buildDTOEntityList(List<ProductoSucursal> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ProductoSucursalDTO> dtoEntityList = new ArrayList<>();
        ProductoSucursalDTO dtoEntity =  null;
		for(ProductoSucursal jpaEntity: jpaEntityList){
			dtoEntity =  new ProductoSucursalDTO();
            // Embedable: ProductoSucursalPK, begin nested settings
            dtoEntity.setSucursalId( jpaEntity.getProductoSucursalPK().getSucursalId() );
            dtoEntity.setProductoCodigoBarras( jpaEntity.getProductoSucursalPK().getProductoCodigoBarras() );
            // End nested settings
            dtoEntity.setCantidad1ra( jpaEntity.getCantidad1ra() );
            dtoEntity.setPrecio1ra( jpaEntity.getPrecio1ra() );
            dtoEntity.setCantidadOpo( jpaEntity.getCantidadOpo() );
            dtoEntity.setPrecioOpo( jpaEntity.getPrecioOpo() );
            dtoEntity.setCantidadReg( jpaEntity.getCantidadReg() );
            dtoEntity.setPrecioReg( jpaEntity.getPrecioReg() );
            //Not Embedable: ProductoCodigoBarras -> Producto, FTable: PRODUCTO, HyperName:PRODUCTOPRODUCTO_
            dtoEntity.setProductoCodigoBarras( jpaEntity.getProductoproducto()!=null?jpaEntity.getProductoproducto().getCodigoBarras():null);
            //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
            dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
