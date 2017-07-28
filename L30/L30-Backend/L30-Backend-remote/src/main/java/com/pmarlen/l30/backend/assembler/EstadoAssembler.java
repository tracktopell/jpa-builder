package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.Estado;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table ESTADO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/27 19:58
 */

public class EstadoAssembler {    
    
    /** 
     * Private Constructor
     */
    private EstadoAssembler() {
    }

    public static Estado buildJpaEntity(EstadoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Estado jpaEntity = new Estado();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setDescripcion( dtoEntity.getDescripcion()); // normal

        return jpaEntity;
    }

    public static List<Estado> buildJpaEntityList(List<EstadoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Estado> jpaEntityList = new ArrayList<>();
		Estado jpaEntity = null;
		for(EstadoDTO dtoEntity: dtoEntityList){
			jpaEntity = new Estado();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setDescripcion( dtoEntity.getDescripcion());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static EstadoDTO buildDTOEntity(Estado jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        EstadoDTO dtoEntity =  new EstadoDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setDescripcion( jpaEntity.getDescripcion() ); // primitive

        return dtoEntity;
    }

	public static List<EstadoDTO> buildDTOEntityList(List<Estado> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<EstadoDTO> dtoEntityList = new ArrayList<>();
        EstadoDTO dtoEntity =  null;
		for(Estado jpaEntity: jpaEntityList){
			dtoEntity =  new EstadoDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setDescripcion( jpaEntity.getDescripcion() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
