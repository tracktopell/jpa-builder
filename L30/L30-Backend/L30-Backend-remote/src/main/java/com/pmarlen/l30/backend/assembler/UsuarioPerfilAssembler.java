package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.UsuarioPerfil;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table USUARIO_PERFIL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/27 19:58
 */

public class UsuarioPerfilAssembler {    
    
    /** 
     * Private Constructor
     */
    private UsuarioPerfilAssembler() {
    }

    public static UsuarioPerfil buildJpaEntity(UsuarioPerfilDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		UsuarioPerfil jpaEntity = new UsuarioPerfil();

        // UsuarioPerfilPK is Embeddable. Begin nested settings
        jpaEntity.getUsuarioPerfilPK().setUsuarioId( dtoEntity.getUsuarioId() );  // nested FKs > BUG
        // End nested settings
        UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
        usuariousuarioDTO.setId( dtoEntity.getUsuarioId());
        jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));

        return jpaEntity;
    }

    public static List<UsuarioPerfil> buildJpaEntityList(List<UsuarioPerfilDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<UsuarioPerfil> jpaEntityList = new ArrayList<>();
		UsuarioPerfil jpaEntity = null;
		for(UsuarioPerfilDTO dtoEntity: dtoEntityList){
			jpaEntity = new UsuarioPerfil();
            // UsuarioPerfilPK is Embeddable. Begin nested settings
            jpaEntity.getUsuarioPerfilPK().setUsuarioId( dtoEntity.getUsuarioId() );  // nested FKs > BUG
            // End nested settings
            UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
            usuariousuarioDTO.setId( dtoEntity.getUsuarioId());
            jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static UsuarioPerfilDTO buildDTOEntity(UsuarioPerfil jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        UsuarioPerfilDTO dtoEntity =  new UsuarioPerfilDTO();		

        // Embedable: UsuarioPerfilPK, begin nested settings
        dtoEntity.setUsuarioId( jpaEntity.getUsuarioPerfilPK().getUsuarioId() ); // bug 3 ?
        // End nested settings
        //Not Embedable: UsuarioId -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO_
        dtoEntity.setUsuarioId( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);

        return dtoEntity;
    }

	public static List<UsuarioPerfilDTO> buildDTOEntityList(List<UsuarioPerfil> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<UsuarioPerfilDTO> dtoEntityList = new ArrayList<>();
        UsuarioPerfilDTO dtoEntity =  null;
		for(UsuarioPerfil jpaEntity: jpaEntityList){
			dtoEntity =  new UsuarioPerfilDTO();
            // Embedable: UsuarioPerfilPK, begin nested settings
            dtoEntity.setUsuarioId( jpaEntity.getUsuarioPerfilPK().getUsuarioId() );
            // End nested settings
            //Not Embedable: UsuarioId -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO_
            dtoEntity.setUsuarioId( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
