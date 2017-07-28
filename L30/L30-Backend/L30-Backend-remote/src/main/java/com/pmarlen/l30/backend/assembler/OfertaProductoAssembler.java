package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.OfertaProducto;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table OFERTA_PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/27 19:58
 */

public class OfertaProductoAssembler {    
    
    /** 
     * Private Constructor
     */
    private OfertaProductoAssembler() {
    }

    public static OfertaProducto buildJpaEntity(OfertaProductoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		OfertaProducto jpaEntity = new OfertaProducto();

        jpaEntity.setId( dtoEntity.getId()); // normal
        ProductoDTO productoproductoDTO = new ProductoDTO();
        productoproductoDTO.setCodigoBarras( dtoEntity.getProductoCodigoBarras());
        jpaEntity.setProductoproducto( ProductoAssembler.buildJpaEntity( productoproductoDTO ));
        SucursalDTO sucursalsucursalDTO = new SucursalDTO();
        sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
        jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
        PromocionDTO promocionpromocionDTO = new PromocionDTO();
        promocionpromocionDTO.setId( dtoEntity.getPromocionId());
        jpaEntity.setPromocionpromocion( PromocionAssembler.buildJpaEntity( promocionpromocionDTO ));
        jpaEntity.setFechaInicial( dtoEntity.getFechaInicial()); // normal
        jpaEntity.setFechaFinal( dtoEntity.getFechaFinal()); // normal

        return jpaEntity;
    }

    public static List<OfertaProducto> buildJpaEntityList(List<OfertaProductoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<OfertaProducto> jpaEntityList = new ArrayList<>();
		OfertaProducto jpaEntity = null;
		for(OfertaProductoDTO dtoEntity: dtoEntityList){
			jpaEntity = new OfertaProducto();
            jpaEntity.setId( dtoEntity.getId());
            ProductoDTO productoproductoDTO = new ProductoDTO();
            productoproductoDTO.setCodigoBarras( dtoEntity.getProductoCodigoBarras());
            jpaEntity.setProductoproducto( ProductoAssembler.buildJpaEntity( productoproductoDTO ));
            SucursalDTO sucursalsucursalDTO = new SucursalDTO();
            sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
            jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
            PromocionDTO promocionpromocionDTO = new PromocionDTO();
            promocionpromocionDTO.setId( dtoEntity.getPromocionId());
            jpaEntity.setPromocionpromocion( PromocionAssembler.buildJpaEntity( promocionpromocionDTO ));
            jpaEntity.setFechaInicial( dtoEntity.getFechaInicial());
            jpaEntity.setFechaFinal( dtoEntity.getFechaFinal());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static OfertaProductoDTO buildDTOEntity(OfertaProducto jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        OfertaProductoDTO dtoEntity =  new OfertaProductoDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        //Not Embedable: ProductoCodigoBarras -> Producto, FTable: PRODUCTO, HyperName:PRODUCTOPRODUCTO_
        dtoEntity.setProductoCodigoBarras( jpaEntity.getProductoproducto()!=null?jpaEntity.getProductoproducto().getCodigoBarras():null);
        //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
        dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
        //Not Embedable: PromocionId -> Promocion, FTable: PROMOCION, HyperName:PROMOCIONPROMOCION_
        dtoEntity.setPromocionId( jpaEntity.getPromocionpromocion()!=null?jpaEntity.getPromocionpromocion().getId():null);
        dtoEntity.setFechaInicial( jpaEntity.getFechaInicial() ); // primitive
        dtoEntity.setFechaFinal( jpaEntity.getFechaFinal() ); // primitive

        return dtoEntity;
    }

	public static List<OfertaProductoDTO> buildDTOEntityList(List<OfertaProducto> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<OfertaProductoDTO> dtoEntityList = new ArrayList<>();
        OfertaProductoDTO dtoEntity =  null;
		for(OfertaProducto jpaEntity: jpaEntityList){
			dtoEntity =  new OfertaProductoDTO();
            dtoEntity.setId( jpaEntity.getId() );
            //Not Embedable: ProductoCodigoBarras -> Producto, FTable: PRODUCTO, HyperName:PRODUCTOPRODUCTO_
            dtoEntity.setProductoCodigoBarras( jpaEntity.getProductoproducto()!=null?jpaEntity.getProductoproducto().getCodigoBarras():null);
            //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
            dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
            //Not Embedable: PromocionId -> Promocion, FTable: PROMOCION, HyperName:PROMOCIONPROMOCION_
            dtoEntity.setPromocionId( jpaEntity.getPromocionpromocion()!=null?jpaEntity.getPromocionpromocion().getId():null);
            dtoEntity.setFechaInicial( jpaEntity.getFechaInicial() );
            dtoEntity.setFechaFinal( jpaEntity.getFechaFinal() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
