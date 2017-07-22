package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.ConfiguracionProovedorCfd;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table CONFIGURACION_PROOVEDOR_CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/21 18:00
 */

public class ConfiguracionProovedorCfdAssembler {    
    
    /** 
     * Private Constructor
     */
    private ConfiguracionProovedorCfdAssembler() {
    }

    public static ConfiguracionProovedorCfd buildJpaEntity(ConfiguracionProovedorCfdDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		ConfiguracionProovedorCfd jpaEntity = new ConfiguracionProovedorCfd();

        jpaEntity.setId( dtoEntity.getId()); // normal
        SucursalDTO sucursalsucursalDTO = new SucursalDTO();
        sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
        jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
        jpaEntity.setPrioridad( dtoEntity.getPrioridad()); // normal
        jpaEntity.setProveedorCfd( dtoEntity.getProveedorCfd()); // normal
        jpaEntity.setUsuarioCfd( dtoEntity.getUsuarioCfd()); // normal
        jpaEntity.setPasswordCfd( dtoEntity.getPasswordCfd()); // normal
        jpaEntity.setSerieCfd( dtoEntity.getSerieCfd()); // normal

        return jpaEntity;
    }

    public static List<ConfiguracionProovedorCfd> buildJpaEntityList(List<ConfiguracionProovedorCfdDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<ConfiguracionProovedorCfd> jpaEntityList = new ArrayList<>();
		ConfiguracionProovedorCfd jpaEntity = null;
		for(ConfiguracionProovedorCfdDTO dtoEntity: dtoEntityList){
			jpaEntity = new ConfiguracionProovedorCfd();
            jpaEntity.setId( dtoEntity.getId());
            SucursalDTO sucursalsucursalDTO = new SucursalDTO();
            sucursalsucursalDTO.setId( dtoEntity.getSucursalId());
            jpaEntity.setSucursalsucursal( SucursalAssembler.buildJpaEntity( sucursalsucursalDTO ));
            jpaEntity.setPrioridad( dtoEntity.getPrioridad());
            jpaEntity.setProveedorCfd( dtoEntity.getProveedorCfd());
            jpaEntity.setUsuarioCfd( dtoEntity.getUsuarioCfd());
            jpaEntity.setPasswordCfd( dtoEntity.getPasswordCfd());
            jpaEntity.setSerieCfd( dtoEntity.getSerieCfd());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ConfiguracionProovedorCfdDTO buildDTOEntity(ConfiguracionProovedorCfd jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ConfiguracionProovedorCfdDTO dtoEntity =  new ConfiguracionProovedorCfdDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
        dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
        dtoEntity.setPrioridad( jpaEntity.getPrioridad() ); // primitive
        dtoEntity.setProveedorCfd( jpaEntity.getProveedorCfd() ); // primitive
        dtoEntity.setUsuarioCfd( jpaEntity.getUsuarioCfd() ); // primitive
        dtoEntity.setPasswordCfd( jpaEntity.getPasswordCfd() ); // primitive
        dtoEntity.setSerieCfd( jpaEntity.getSerieCfd() ); // primitive

        return dtoEntity;
    }

	public static List<ConfiguracionProovedorCfdDTO> buildDTOEntityList(List<ConfiguracionProovedorCfd> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ConfiguracionProovedorCfdDTO> dtoEntityList = new ArrayList<>();
        ConfiguracionProovedorCfdDTO dtoEntity =  null;
		for(ConfiguracionProovedorCfd jpaEntity: jpaEntityList){
			dtoEntity =  new ConfiguracionProovedorCfdDTO();
            dtoEntity.setId( jpaEntity.getId() );
            //Not Embedable: SucursalId -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL_
            dtoEntity.setSucursalId( jpaEntity.getSucursalsucursal()!=null?jpaEntity.getSucursalsucursal().getId():null);
            dtoEntity.setPrioridad( jpaEntity.getPrioridad() );
            dtoEntity.setProveedorCfd( jpaEntity.getProveedorCfd() );
            dtoEntity.setUsuarioCfd( jpaEntity.getUsuarioCfd() );
            dtoEntity.setPasswordCfd( jpaEntity.getPasswordCfd() );
            dtoEntity.setSerieCfd( jpaEntity.getSerieCfd() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
