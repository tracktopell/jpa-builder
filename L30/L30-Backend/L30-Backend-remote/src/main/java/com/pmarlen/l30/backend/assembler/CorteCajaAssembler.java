package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.CorteCaja;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table CORTE_CAJA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/21 18:00
 */

public class CorteCajaAssembler {    
    
    /** 
     * Private Constructor
     */
    private CorteCajaAssembler() {
    }

    public static CorteCaja buildJpaEntity(CorteCajaDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		CorteCaja jpaEntity = new CorteCaja();

        jpaEntity.setId( dtoEntity.getId()); // normal
        SucursalDTO sucursalsucursalDTO = new SucursalDTO();
        sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
        jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
        jpaEntity.setTipoEvento( dtoEntity.getTipoEvento()); // normal
        UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
        usuariousuarioDTO.setId( dtoEntity.getUsuarioId());
        jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));
        jpaEntity.setFecha( dtoEntity.getFecha()); // normal
        jpaEntity.setFechaUap( dtoEntity.getFechaUap()); // normal
        jpaEntity.setSaldoInicial( dtoEntity.getSaldoInicial()); // normal
        jpaEntity.setSaldoFinal( dtoEntity.getSaldoFinal()); // normal
        UsuarioDTO usuariousuarioAutorizoDTO = new UsuarioDTO();
        usuariousuarioAutorizoDTO.setId( dtoEntity.getUsuarioIdAutorizo());
        jpaEntity.setUsuariousuarioAutorizo( UsuarioAssembler.buildJpaEntity( usuariousuarioAutorizoDTO ));
        jpaEntity.setComentarios( dtoEntity.getComentarios()); // normal
        jpaEntity.setCaja( dtoEntity.getCaja()); // normal

        return jpaEntity;
    }

    public static List<CorteCaja> buildJpaEntityList(List<CorteCajaDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<CorteCaja> jpaEntityList = new ArrayList<>();
		CorteCaja jpaEntity = null;
		for(CorteCajaDTO dtoEntity: dtoEntityList){
			jpaEntity = new CorteCaja();
            jpaEntity.setId( dtoEntity.getId());
            SucursalDTO sucursalsucursalDTO = new SucursalDTO();
            sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
            jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
            jpaEntity.setTipoEvento( dtoEntity.getTipoEvento());
            UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
            usuariousuarioDTO.setId( dtoEntity.getUsuarioId());
            jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));
            jpaEntity.setFecha( dtoEntity.getFecha());
            jpaEntity.setFechaUap( dtoEntity.getFechaUap());
            jpaEntity.setSaldoInicial( dtoEntity.getSaldoInicial());
            jpaEntity.setSaldoFinal( dtoEntity.getSaldoFinal());
            UsuarioDTO usuariousuarioAutorizoDTO = new UsuarioDTO();
            usuariousuarioAutorizoDTO.setId( dtoEntity.getUsuarioIdAutorizo());
            jpaEntity.setUsuariousuarioAutorizo( UsuarioAssembler.buildJpaEntity( usuariousuarioAutorizoDTO ));
            jpaEntity.setComentarios( dtoEntity.getComentarios());
            jpaEntity.setCaja( dtoEntity.getCaja());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static CorteCajaDTO buildDTOEntity(CorteCaja jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        CorteCajaDTO dtoEntity =  new CorteCajaDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
        dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
        dtoEntity.setTipoEvento( jpaEntity.getTipoEvento() ); // primitive
        //Not Embedable: UsuarioId -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO_
        dtoEntity.setUsuarioId( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);
        dtoEntity.setFecha( jpaEntity.getFecha() ); // primitive
        dtoEntity.setFechaUap( jpaEntity.getFechaUap() ); // primitive
        dtoEntity.setSaldoInicial( jpaEntity.getSaldoInicial() ); // primitive
        dtoEntity.setSaldoFinal( jpaEntity.getSaldoFinal() ); // primitive
        //Not Embedable: UsuarioIdAutorizo -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO__AUTORIZO
        dtoEntity.setUsuarioIdAutorizo( jpaEntity.getUsuariousuarioAutorizo()!=null?jpaEntity.getUsuariousuarioAutorizo().getId():null);
        dtoEntity.setComentarios( jpaEntity.getComentarios() ); // primitive
        dtoEntity.setCaja( jpaEntity.getCaja() ); // primitive

        return dtoEntity;
    }

	public static List<CorteCajaDTO> buildDTOEntityList(List<CorteCaja> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<CorteCajaDTO> dtoEntityList = new ArrayList<>();
        CorteCajaDTO dtoEntity =  null;
		for(CorteCaja jpaEntity: jpaEntityList){
			dtoEntity =  new CorteCajaDTO();
            dtoEntity.setId( jpaEntity.getId() );
            //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
            dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
            dtoEntity.setTipoEvento( jpaEntity.getTipoEvento() );
            //Not Embedable: UsuarioId -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO_
            dtoEntity.setUsuarioId( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);
            dtoEntity.setFecha( jpaEntity.getFecha() );
            dtoEntity.setFechaUap( jpaEntity.getFechaUap() );
            dtoEntity.setSaldoInicial( jpaEntity.getSaldoInicial() );
            dtoEntity.setSaldoFinal( jpaEntity.getSaldoFinal() );
            //Not Embedable: UsuarioIdAutorizo -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO__AUTORIZO
            dtoEntity.setUsuarioIdAutorizo( jpaEntity.getUsuariousuarioAutorizo()!=null?jpaEntity.getUsuariousuarioAutorizo().getId():null);
            dtoEntity.setComentarios( jpaEntity.getComentarios() );
            dtoEntity.setCaja( jpaEntity.getCaja() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
