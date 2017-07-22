package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.Producto;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/21 18:00
 */

public class ProductoAssembler {    
    
    /** 
     * Private Constructor
     */
    private ProductoAssembler() {
    }

    public static Producto buildJpaEntity(ProductoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Producto jpaEntity = new Producto();

        jpaEntity.setCodigoBarras( dtoEntity.getCodigoBarras()); // normal
        jpaEntity.setCodigoShcp( dtoEntity.getCodigoShcp()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setIndustria( dtoEntity.getIndustria()); // normal
        jpaEntity.setMarca( dtoEntity.getMarca()); // normal
        jpaEntity.setLinea( dtoEntity.getLinea()); // normal
        jpaEntity.setPresentacion( dtoEntity.getPresentacion()); // normal
        jpaEntity.setAbrebiatura( dtoEntity.getAbrebiatura()); // normal
        jpaEntity.setUnidadesXCaja( dtoEntity.getUnidadesXCaja()); // normal
        jpaEntity.setContenido( dtoEntity.getContenido()); // normal
        jpaEntity.setUnidadMedida( dtoEntity.getUnidadMedida()); // normal
        jpaEntity.setUnidadEmpaque( dtoEntity.getUnidadEmpaque()); // normal
        jpaEntity.setCosto( dtoEntity.getCosto()); // normal
        jpaEntity.setCostoVenta( dtoEntity.getCostoVenta()); // normal
        jpaEntity.setHabilitado( dtoEntity.getHabilitado()); // normal
        jpaEntity.setPoco( dtoEntity.getPoco()); // normal

        return jpaEntity;
    }

    public static List<Producto> buildJpaEntityList(List<ProductoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Producto> jpaEntityList = new ArrayList<>();
		Producto jpaEntity = null;
		for(ProductoDTO dtoEntity: dtoEntityList){
			jpaEntity = new Producto();
            jpaEntity.setCodigoBarras( dtoEntity.getCodigoBarras());
            jpaEntity.setCodigoShcp( dtoEntity.getCodigoShcp());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setIndustria( dtoEntity.getIndustria());
            jpaEntity.setMarca( dtoEntity.getMarca());
            jpaEntity.setLinea( dtoEntity.getLinea());
            jpaEntity.setPresentacion( dtoEntity.getPresentacion());
            jpaEntity.setAbrebiatura( dtoEntity.getAbrebiatura());
            jpaEntity.setUnidadesXCaja( dtoEntity.getUnidadesXCaja());
            jpaEntity.setContenido( dtoEntity.getContenido());
            jpaEntity.setUnidadMedida( dtoEntity.getUnidadMedida());
            jpaEntity.setUnidadEmpaque( dtoEntity.getUnidadEmpaque());
            jpaEntity.setCosto( dtoEntity.getCosto());
            jpaEntity.setCostoVenta( dtoEntity.getCostoVenta());
            jpaEntity.setHabilitado( dtoEntity.getHabilitado());
            jpaEntity.setPoco( dtoEntity.getPoco());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ProductoDTO buildDTOEntity(Producto jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ProductoDTO dtoEntity =  new ProductoDTO();		

        dtoEntity.setCodigoBarras( jpaEntity.getCodigoBarras() ); // primitive
        dtoEntity.setCodigoShcp( jpaEntity.getCodigoShcp() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setIndustria( jpaEntity.getIndustria() ); // primitive
        dtoEntity.setMarca( jpaEntity.getMarca() ); // primitive
        dtoEntity.setLinea( jpaEntity.getLinea() ); // primitive
        dtoEntity.setPresentacion( jpaEntity.getPresentacion() ); // primitive
        dtoEntity.setAbrebiatura( jpaEntity.getAbrebiatura() ); // primitive
        dtoEntity.setUnidadesXCaja( jpaEntity.getUnidadesXCaja() ); // primitive
        dtoEntity.setContenido( jpaEntity.getContenido() ); // primitive
        dtoEntity.setUnidadMedida( jpaEntity.getUnidadMedida() ); // primitive
        dtoEntity.setUnidadEmpaque( jpaEntity.getUnidadEmpaque() ); // primitive
        dtoEntity.setCosto( jpaEntity.getCosto() ); // primitive
        dtoEntity.setCostoVenta( jpaEntity.getCostoVenta() ); // primitive
        dtoEntity.setHabilitado( jpaEntity.getHabilitado() ); // primitive
        dtoEntity.setPoco( jpaEntity.getPoco() ); // primitive

        return dtoEntity;
    }

	public static List<ProductoDTO> buildDTOEntityList(List<Producto> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ProductoDTO> dtoEntityList = new ArrayList<>();
        ProductoDTO dtoEntity =  null;
		for(Producto jpaEntity: jpaEntityList){
			dtoEntity =  new ProductoDTO();
            dtoEntity.setCodigoBarras( jpaEntity.getCodigoBarras() );
            dtoEntity.setCodigoShcp( jpaEntity.getCodigoShcp() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setIndustria( jpaEntity.getIndustria() );
            dtoEntity.setMarca( jpaEntity.getMarca() );
            dtoEntity.setLinea( jpaEntity.getLinea() );
            dtoEntity.setPresentacion( jpaEntity.getPresentacion() );
            dtoEntity.setAbrebiatura( jpaEntity.getAbrebiatura() );
            dtoEntity.setUnidadesXCaja( jpaEntity.getUnidadesXCaja() );
            dtoEntity.setContenido( jpaEntity.getContenido() );
            dtoEntity.setUnidadMedida( jpaEntity.getUnidadMedida() );
            dtoEntity.setUnidadEmpaque( jpaEntity.getUnidadEmpaque() );
            dtoEntity.setCosto( jpaEntity.getCosto() );
            dtoEntity.setCostoVenta( jpaEntity.getCostoVenta() );
            dtoEntity.setHabilitado( jpaEntity.getHabilitado() );
            dtoEntity.setPoco( jpaEntity.getPoco() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
