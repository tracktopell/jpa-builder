package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.EntrdaSalidaEstado;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table ENTRDA_SALIDA_ESTADO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/21 18:00
 */

public class EntrdaSalidaEstadoAssembler {    
    
    /** 
     * Private Constructor
     */
    private EntrdaSalidaEstadoAssembler() {
    }

    public static EntrdaSalidaEstado buildJpaEntity(EntrdaSalidaEstadoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		EntrdaSalidaEstado jpaEntity = new EntrdaSalidaEstado();

        jpaEntity.setId( dtoEntity.getId()); // normal
        EntradaSalidaDTO entradaSalidaentradaSalaDTO = new EntradaSalidaDTO();
        entradaSalidaentradaSalaDTO.setId( dtoEntity.getEntradaSalidaId());
        jpaEntity.setEntradaSalidaentradaSala( EntradaSalidaAssembler.buildJpaEntity( entradaSalidaentradaSalaDTO ));
        jpaEntity.setFecha( dtoEntity.getFecha()); // normal
        jpaEntity.setComentarios( dtoEntity.getComentarios()); // normal
        EstadoDTO estadoestadoDTO = new EstadoDTO();
        estadoestadoDTO.setId( dtoEntity.getEstadoId());
        jpaEntity.setEstadoestado( EstadoAssembler.buildJpaEntity( estadoestadoDTO ));
        UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
        usuariousuarioDTO.setId( dtoEntity.getUsuarioId());
        jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));

        return jpaEntity;
    }

    public static List<EntrdaSalidaEstado> buildJpaEntityList(List<EntrdaSalidaEstadoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<EntrdaSalidaEstado> jpaEntityList = new ArrayList<>();
		EntrdaSalidaEstado jpaEntity = null;
		for(EntrdaSalidaEstadoDTO dtoEntity: dtoEntityList){
			jpaEntity = new EntrdaSalidaEstado();
            jpaEntity.setId( dtoEntity.getId());
            EntradaSalidaDTO entradaSalidaentradaSalaDTO = new EntradaSalidaDTO();
            entradaSalidaentradaSalaDTO.setId( dtoEntity.getEntradaSalidaId());
            jpaEntity.setEntradaSalidaentradaSala( EntradaSalidaAssembler.buildJpaEntity( entradaSalidaentradaSalaDTO ));
            jpaEntity.setFecha( dtoEntity.getFecha());
            jpaEntity.setComentarios( dtoEntity.getComentarios());
            EstadoDTO estadoestadoDTO = new EstadoDTO();
            estadoestadoDTO.setId( dtoEntity.getEstadoId());
            jpaEntity.setEstadoestado( EstadoAssembler.buildJpaEntity( estadoestadoDTO ));
            UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
            usuariousuarioDTO.setId( dtoEntity.getUsuarioId());
            jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static EntrdaSalidaEstadoDTO buildDTOEntity(EntrdaSalidaEstado jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        EntrdaSalidaEstadoDTO dtoEntity =  new EntrdaSalidaEstadoDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        //Not Embedable: EntradaSalidaId -> EntradaSalida, FTable: ENTRADA_SALIDA, HyperName:ENTRADA_SALIDAENTRADA_SALA_
        dtoEntity.setEntradaSalidaId( jpaEntity.getEntradaSalidaentradaSala()!=null?jpaEntity.getEntradaSalidaentradaSala().getId():null);
        dtoEntity.setFecha( jpaEntity.getFecha() ); // primitive
        dtoEntity.setComentarios( jpaEntity.getComentarios() ); // primitive
        //Not Embedable: EstadoId -> Estado, FTable: ESTADO, HyperName:ESTADOESTADO_
        dtoEntity.setEstadoId( jpaEntity.getEstadoestado()!=null?jpaEntity.getEstadoestado().getId():null);
        //Not Embedable: UsuarioId -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO_
        dtoEntity.setUsuarioId( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);

        return dtoEntity;
    }

	public static List<EntrdaSalidaEstadoDTO> buildDTOEntityList(List<EntrdaSalidaEstado> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<EntrdaSalidaEstadoDTO> dtoEntityList = new ArrayList<>();
        EntrdaSalidaEstadoDTO dtoEntity =  null;
		for(EntrdaSalidaEstado jpaEntity: jpaEntityList){
			dtoEntity =  new EntrdaSalidaEstadoDTO();
            dtoEntity.setId( jpaEntity.getId() );
            //Not Embedable: EntradaSalidaId -> EntradaSalida, FTable: ENTRADA_SALIDA, HyperName:ENTRADA_SALIDAENTRADA_SALA_
            dtoEntity.setEntradaSalidaId( jpaEntity.getEntradaSalidaentradaSala()!=null?jpaEntity.getEntradaSalidaentradaSala().getId():null);
            dtoEntity.setFecha( jpaEntity.getFecha() );
            dtoEntity.setComentarios( jpaEntity.getComentarios() );
            //Not Embedable: EstadoId -> Estado, FTable: ESTADO, HyperName:ESTADOESTADO_
            dtoEntity.setEstadoId( jpaEntity.getEstadoestado()!=null?jpaEntity.getEstadoestado().getId():null);
            //Not Embedable: UsuarioId -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO_
            dtoEntity.setUsuarioId( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
