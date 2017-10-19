package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.Cfd;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/19 00:02
 */

public class CfdAssembler {    
    
    /** 
     * Private Constructor
     */
    private CfdAssembler() {
    }

    public static Cfd buildJpaEntity(CfdDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Cfd jpaEntity = new Cfd();

        jpaEntity.setId( dtoEntity.getId()); // normal
        CfdDTO cfdcfdOrigenDTO = new CfdDTO();
        cfdcfdOrigenDTO.setId( dtoEntity.getCfdIdOrigen());
        jpaEntity.setCfdcfdOrigen( CfdAssembler.buildJpaEntity( cfdcfdOrigenDTO ));
        EntradaSalidaDTO entradaSalidaentradaSalaDTO = new EntradaSalidaDTO();
        entradaSalidaentradaSalaDTO.setId( dtoEntity.getEntradaSalidaId());
        jpaEntity.setEntradaSalidaentradaSala( EntradaSalidaAssembler.buildJpaEntity( entradaSalidaentradaSalaDTO ));
        jpaEntity.setTipo( dtoEntity.getTipo()); // normal
        jpaEntity.setNumCfd( dtoEntity.getNumCfd()); // normal
        jpaEntity.setUltimoError( dtoEntity.getUltimoError()); // normal
        jpaEntity.setContenidoOriginal( dtoEntity.getContenidoOriginal()); // normal

        return jpaEntity;
    }

    public static List<Cfd> buildJpaEntityList(List<CfdDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Cfd> jpaEntityList = new ArrayList<>();
		Cfd jpaEntity = null;
		for(CfdDTO dtoEntity: dtoEntityList){
			jpaEntity = new Cfd();
            jpaEntity.setId( dtoEntity.getId());
            CfdDTO cfdcfdOrigenDTO = new CfdDTO();
            cfdcfdOrigenDTO.setId( dtoEntity.getCfdIdOrigen());
            jpaEntity.setCfdcfdOrigen( CfdAssembler.buildJpaEntity( cfdcfdOrigenDTO ));
            EntradaSalidaDTO entradaSalidaentradaSalaDTO = new EntradaSalidaDTO();
            entradaSalidaentradaSalaDTO.setId( dtoEntity.getEntradaSalidaId());
            jpaEntity.setEntradaSalidaentradaSala( EntradaSalidaAssembler.buildJpaEntity( entradaSalidaentradaSalaDTO ));
            jpaEntity.setTipo( dtoEntity.getTipo());
            jpaEntity.setNumCfd( dtoEntity.getNumCfd());
            jpaEntity.setUltimoError( dtoEntity.getUltimoError());
            jpaEntity.setContenidoOriginal( dtoEntity.getContenidoOriginal());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static CfdDTO buildDTOEntity(Cfd jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        CfdDTO dtoEntity =  new CfdDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        //Not Embedable: CfdIdOrigen -> Cfd, FTable: CFD, HyperName:CFDCFD__ORIGEN
        dtoEntity.setCfdIdOrigen( jpaEntity.getCfdcfdOrigen()!=null?jpaEntity.getCfdcfdOrigen().getId():null);
        //Not Embedable: EntradaSalidaId -> EntradaSalida, FTable: ENTRADA_SALIDA, HyperName:ENTRADA_SALIDAENTRADA_SALA_
        dtoEntity.setEntradaSalidaId( jpaEntity.getEntradaSalidaentradaSala()!=null?jpaEntity.getEntradaSalidaentradaSala().getId():null);
        dtoEntity.setTipo( jpaEntity.getTipo() ); // primitive
        dtoEntity.setNumCfd( jpaEntity.getNumCfd() ); // primitive
        dtoEntity.setUltimoError( jpaEntity.getUltimoError() ); // primitive
        dtoEntity.setContenidoOriginal( jpaEntity.getContenidoOriginal() ); // primitive

        return dtoEntity;
    }

	public static List<CfdDTO> buildDTOEntityList(List<Cfd> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<CfdDTO> dtoEntityList = new ArrayList<>();
        CfdDTO dtoEntity =  null;
		for(Cfd jpaEntity: jpaEntityList){
			dtoEntity =  new CfdDTO();
            dtoEntity.setId( jpaEntity.getId() );
            //Not Embedable: CfdIdOrigen -> Cfd, FTable: CFD, HyperName:CFDCFD__ORIGEN
            dtoEntity.setCfdIdOrigen( jpaEntity.getCfdcfdOrigen()!=null?jpaEntity.getCfdcfdOrigen().getId():null);
            //Not Embedable: EntradaSalidaId -> EntradaSalida, FTable: ENTRADA_SALIDA, HyperName:ENTRADA_SALIDAENTRADA_SALA_
            dtoEntity.setEntradaSalidaId( jpaEntity.getEntradaSalidaentradaSala()!=null?jpaEntity.getEntradaSalidaentradaSala().getId():null);
            dtoEntity.setTipo( jpaEntity.getTipo() );
            dtoEntity.setNumCfd( jpaEntity.getNumCfd() );
            dtoEntity.setUltimoError( jpaEntity.getUltimoError() );
            dtoEntity.setContenidoOriginal( jpaEntity.getContenidoOriginal() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
