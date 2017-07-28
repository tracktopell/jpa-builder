package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.Promocion;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table PROMOCION.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/27 19:58
 */

public class PromocionAssembler {    
    
    /** 
     * Private Constructor
     */
    private PromocionAssembler() {
    }

    public static Promocion buildJpaEntity(PromocionDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Promocion jpaEntity = new Promocion();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setReglaAritmetica( dtoEntity.getReglaAritmetica()); // normal

        return jpaEntity;
    }

    public static List<Promocion> buildJpaEntityList(List<PromocionDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Promocion> jpaEntityList = new ArrayList<>();
		Promocion jpaEntity = null;
		for(PromocionDTO dtoEntity: dtoEntityList){
			jpaEntity = new Promocion();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setReglaAritmetica( dtoEntity.getReglaAritmetica());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static PromocionDTO buildDTOEntity(Promocion jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        PromocionDTO dtoEntity =  new PromocionDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setReglaAritmetica( jpaEntity.getReglaAritmetica() ); // primitive

        return dtoEntity;
    }

	public static List<PromocionDTO> buildDTOEntityList(List<Promocion> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<PromocionDTO> dtoEntityList = new ArrayList<>();
        PromocionDTO dtoEntity =  null;
		for(Promocion jpaEntity: jpaEntityList){
			dtoEntity =  new PromocionDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setReglaAritmetica( jpaEntity.getReglaAritmetica() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
