package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.MetodoDePago;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table METODO_DE_PAGO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/27 19:58
 */

public class MetodoDePagoAssembler {    
    
    /** 
     * Private Constructor
     */
    private MetodoDePagoAssembler() {
    }

    public static MetodoDePago buildJpaEntity(MetodoDePagoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		MetodoDePago jpaEntity = new MetodoDePago();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setDescripcion( dtoEntity.getDescripcion()); // normal

        return jpaEntity;
    }

    public static List<MetodoDePago> buildJpaEntityList(List<MetodoDePagoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<MetodoDePago> jpaEntityList = new ArrayList<>();
		MetodoDePago jpaEntity = null;
		for(MetodoDePagoDTO dtoEntity: dtoEntityList){
			jpaEntity = new MetodoDePago();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setDescripcion( dtoEntity.getDescripcion());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static MetodoDePagoDTO buildDTOEntity(MetodoDePago jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        MetodoDePagoDTO dtoEntity =  new MetodoDePagoDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setDescripcion( jpaEntity.getDescripcion() ); // primitive

        return dtoEntity;
    }

	public static List<MetodoDePagoDTO> buildDTOEntityList(List<MetodoDePago> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<MetodoDePagoDTO> dtoEntityList = new ArrayList<>();
        MetodoDePagoDTO dtoEntity =  null;
		for(MetodoDePago jpaEntity: jpaEntityList){
			dtoEntity =  new MetodoDePagoDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setDescripcion( jpaEntity.getDescripcion() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
