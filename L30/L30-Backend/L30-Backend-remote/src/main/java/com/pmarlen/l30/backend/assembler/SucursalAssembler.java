package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.Sucursal;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/27 19:58
 */

public class SucursalAssembler {    
    
    /** 
     * Private Constructor
     */
    private SucursalAssembler() {
    }

    public static Sucursal buildJpaEntity(SucursalDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Sucursal jpaEntity = new Sucursal();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setTipo( dtoEntity.getTipo()); // normal
        jpaEntity.setClave( dtoEntity.getClave()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setDireccion( dtoEntity.getDireccion()); // normal
        jpaEntity.setTelefonos( dtoEntity.getTelefonos()); // normal
        jpaEntity.setDescuentoMyoreoHabilitado( dtoEntity.getDescuentoMyoreoHabilitado()); // normal
        jpaEntity.setVentaRegHabilitado( dtoEntity.getVentaRegHabilitado()); // normal
        jpaEntity.setVentaOpo( dtoEntity.getVentaOpo()); // normal

        return jpaEntity;
    }

    public static List<Sucursal> buildJpaEntityList(List<SucursalDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Sucursal> jpaEntityList = new ArrayList<>();
		Sucursal jpaEntity = null;
		for(SucursalDTO dtoEntity: dtoEntityList){
			jpaEntity = new Sucursal();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setTipo( dtoEntity.getTipo());
            jpaEntity.setClave( dtoEntity.getClave());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setDireccion( dtoEntity.getDireccion());
            jpaEntity.setTelefonos( dtoEntity.getTelefonos());
            jpaEntity.setDescuentoMyoreoHabilitado( dtoEntity.getDescuentoMyoreoHabilitado());
            jpaEntity.setVentaRegHabilitado( dtoEntity.getVentaRegHabilitado());
            jpaEntity.setVentaOpo( dtoEntity.getVentaOpo());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static SucursalDTO buildDTOEntity(Sucursal jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        SucursalDTO dtoEntity =  new SucursalDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setTipo( jpaEntity.getTipo() ); // primitive
        dtoEntity.setClave( jpaEntity.getClave() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setDireccion( jpaEntity.getDireccion() ); // primitive
        dtoEntity.setTelefonos( jpaEntity.getTelefonos() ); // primitive
        dtoEntity.setDescuentoMyoreoHabilitado( jpaEntity.getDescuentoMyoreoHabilitado() ); // primitive
        dtoEntity.setVentaRegHabilitado( jpaEntity.getVentaRegHabilitado() ); // primitive
        dtoEntity.setVentaOpo( jpaEntity.getVentaOpo() ); // primitive

        return dtoEntity;
    }

	public static List<SucursalDTO> buildDTOEntityList(List<Sucursal> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<SucursalDTO> dtoEntityList = new ArrayList<>();
        SucursalDTO dtoEntity =  null;
		for(Sucursal jpaEntity: jpaEntityList){
			dtoEntity =  new SucursalDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setTipo( jpaEntity.getTipo() );
            dtoEntity.setClave( jpaEntity.getClave() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setDireccion( jpaEntity.getDireccion() );
            dtoEntity.setTelefonos( jpaEntity.getTelefonos() );
            dtoEntity.setDescuentoMyoreoHabilitado( jpaEntity.getDescuentoMyoreoHabilitado() );
            dtoEntity.setVentaRegHabilitado( jpaEntity.getVentaRegHabilitado() );
            dtoEntity.setVentaOpo( jpaEntity.getVentaOpo() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
