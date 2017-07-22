package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.FormaDePago;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table FORMA_DE_PAGO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/21 18:00
 */

public class FormaDePagoAssembler {    
    
    /** 
     * Private Constructor
     */
    private FormaDePagoAssembler() {
    }

    public static FormaDePago buildJpaEntity(FormaDePagoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		FormaDePago jpaEntity = new FormaDePago();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setDescripcion( dtoEntity.getDescripcion()); // normal

        return jpaEntity;
    }

    public static List<FormaDePago> buildJpaEntityList(List<FormaDePagoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<FormaDePago> jpaEntityList = new ArrayList<>();
		FormaDePago jpaEntity = null;
		for(FormaDePagoDTO dtoEntity: dtoEntityList){
			jpaEntity = new FormaDePago();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setDescripcion( dtoEntity.getDescripcion());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static FormaDePagoDTO buildDTOEntity(FormaDePago jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        FormaDePagoDTO dtoEntity =  new FormaDePagoDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setDescripcion( jpaEntity.getDescripcion() ); // primitive

        return dtoEntity;
    }

	public static List<FormaDePagoDTO> buildDTOEntityList(List<FormaDePago> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<FormaDePagoDTO> dtoEntityList = new ArrayList<>();
        FormaDePagoDTO dtoEntity =  null;
		for(FormaDePago jpaEntity: jpaEntityList){
			dtoEntity =  new FormaDePagoDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setDescripcion( jpaEntity.getDescripcion() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
