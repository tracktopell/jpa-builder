package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.Usuario;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table USUARIO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/21 18:00
 */

public class UsuarioAssembler {    
    
    /** 
     * Private Constructor
     */
    private UsuarioAssembler() {
    }

    public static Usuario buildJpaEntity(UsuarioDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Usuario jpaEntity = new Usuario();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setEmail( dtoEntity.getEmail()); // normal
        jpaEntity.setPassword( dtoEntity.getPassword()); // normal
        jpaEntity.setTelefonos( dtoEntity.getTelefonos()); // normal
        jpaEntity.setHabilitado( dtoEntity.getHabilitado()); // normal
        jpaEntity.setNombre( dtoEntity.getNombre()); // normal
        jpaEntity.setApellidoPaterno( dtoEntity.getApellidoPaterno()); // normal
        jpaEntity.setApellidoMaterno( dtoEntity.getApellidoMaterno()); // normal
        jpaEntity.setFechaRegistro( dtoEntity.getFechaRegistro()); // normal
        jpaEntity.setFechaUltCambio( dtoEntity.getFechaUltCambio()); // normal
        SucursalDTO sucursalsucursalDTO = new SucursalDTO();
        sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
        jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));

        return jpaEntity;
    }

    public static List<Usuario> buildJpaEntityList(List<UsuarioDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Usuario> jpaEntityList = new ArrayList<>();
		Usuario jpaEntity = null;
		for(UsuarioDTO dtoEntity: dtoEntityList){
			jpaEntity = new Usuario();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setEmail( dtoEntity.getEmail());
            jpaEntity.setPassword( dtoEntity.getPassword());
            jpaEntity.setTelefonos( dtoEntity.getTelefonos());
            jpaEntity.setHabilitado( dtoEntity.getHabilitado());
            jpaEntity.setNombre( dtoEntity.getNombre());
            jpaEntity.setApellidoPaterno( dtoEntity.getApellidoPaterno());
            jpaEntity.setApellidoMaterno( dtoEntity.getApellidoMaterno());
            jpaEntity.setFechaRegistro( dtoEntity.getFechaRegistro());
            jpaEntity.setFechaUltCambio( dtoEntity.getFechaUltCambio());
            SucursalDTO sucursalsucursalDTO = new SucursalDTO();
            sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
            jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static UsuarioDTO buildDTOEntity(Usuario jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        UsuarioDTO dtoEntity =  new UsuarioDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setEmail( jpaEntity.getEmail() ); // primitive
        dtoEntity.setPassword( jpaEntity.getPassword() ); // primitive
        dtoEntity.setTelefonos( jpaEntity.getTelefonos() ); // primitive
        dtoEntity.setHabilitado( jpaEntity.getHabilitado() ); // primitive
        dtoEntity.setNombre( jpaEntity.getNombre() ); // primitive
        dtoEntity.setApellidoPaterno( jpaEntity.getApellidoPaterno() ); // primitive
        dtoEntity.setApellidoMaterno( jpaEntity.getApellidoMaterno() ); // primitive
        dtoEntity.setFechaRegistro( jpaEntity.getFechaRegistro() ); // primitive
        dtoEntity.setFechaUltCambio( jpaEntity.getFechaUltCambio() ); // primitive
        //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
        dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);

        return dtoEntity;
    }

	public static List<UsuarioDTO> buildDTOEntityList(List<Usuario> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<UsuarioDTO> dtoEntityList = new ArrayList<>();
        UsuarioDTO dtoEntity =  null;
		for(Usuario jpaEntity: jpaEntityList){
			dtoEntity =  new UsuarioDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setEmail( jpaEntity.getEmail() );
            dtoEntity.setPassword( jpaEntity.getPassword() );
            dtoEntity.setTelefonos( jpaEntity.getTelefonos() );
            dtoEntity.setHabilitado( jpaEntity.getHabilitado() );
            dtoEntity.setNombre( jpaEntity.getNombre() );
            dtoEntity.setApellidoPaterno( jpaEntity.getApellidoPaterno() );
            dtoEntity.setApellidoMaterno( jpaEntity.getApellidoMaterno() );
            dtoEntity.setFechaRegistro( jpaEntity.getFechaRegistro() );
            dtoEntity.setFechaUltCambio( jpaEntity.getFechaUltCambio() );
            //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
            dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
