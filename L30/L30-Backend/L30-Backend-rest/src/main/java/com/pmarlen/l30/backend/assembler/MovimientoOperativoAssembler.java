package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.MovimientoOperativo;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table MOVIMIENTO_OPERATIVO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/19 00:02
 */

public class MovimientoOperativoAssembler {    
    
    /** 
     * Private Constructor
     */
    private MovimientoOperativoAssembler() {
    }

    public static MovimientoOperativo buildJpaEntity(MovimientoOperativoDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		MovimientoOperativo jpaEntity = new MovimientoOperativo();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setMotivo( dtoEntity.getMotivo()); // normal
        jpaEntity.setFecha( dtoEntity.getFecha()); // normal
        SucursalDTO sucursalsucursalOrigenDTO = new SucursalDTO();
        sucursalsucursalOrigenDTO.setId( dtoEntity.getSucursalIdOrigen());
        jpaEntity.setSucursalsucursalOrigen( SucursalAssembler.buildJpaEntity( sucursalsucursalOrigenDTO ));
        jpaEntity.setAlmacenOrigen( dtoEntity.getAlmacenOrigen()); // normal
        SucursalDTO sucursalsucursalDestinoDTO = new SucursalDTO();
        sucursalsucursalDestinoDTO.setId( dtoEntity.getSucursalIdDestino());
        jpaEntity.setSucursalsucursalDestino( SucursalAssembler.buildJpaEntity( sucursalsucursalDestinoDTO ));
        jpaEntity.setAlmacenDestino( dtoEntity.getAlmacenDestino()); // normal
        jpaEntity.setTipoMov( dtoEntity.getTipoMov()); // normal

        return jpaEntity;
    }

    public static List<MovimientoOperativo> buildJpaEntityList(List<MovimientoOperativoDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<MovimientoOperativo> jpaEntityList = new ArrayList<>();
		MovimientoOperativo jpaEntity = null;
		for(MovimientoOperativoDTO dtoEntity: dtoEntityList){
			jpaEntity = new MovimientoOperativo();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setMotivo( dtoEntity.getMotivo());
            jpaEntity.setFecha( dtoEntity.getFecha());
            SucursalDTO sucursalsucursalOrigenDTO = new SucursalDTO();
            sucursalsucursalOrigenDTO.setId( dtoEntity.getSucursalIdOrigen());
            jpaEntity.setSucursalsucursalOrigen( SucursalAssembler.buildJpaEntity( sucursalsucursalOrigenDTO ));
            jpaEntity.setAlmacenOrigen( dtoEntity.getAlmacenOrigen());
            SucursalDTO sucursalsucursalDestinoDTO = new SucursalDTO();
            sucursalsucursalDestinoDTO.setId( dtoEntity.getSucursalIdDestino());
            jpaEntity.setSucursalsucursalDestino( SucursalAssembler.buildJpaEntity( sucursalsucursalDestinoDTO ));
            jpaEntity.setAlmacenDestino( dtoEntity.getAlmacenDestino());
            jpaEntity.setTipoMov( dtoEntity.getTipoMov());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static MovimientoOperativoDTO buildDTOEntity(MovimientoOperativo jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        MovimientoOperativoDTO dtoEntity =  new MovimientoOperativoDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setMotivo( jpaEntity.getMotivo() ); // primitive
        dtoEntity.setFecha( jpaEntity.getFecha() ); // primitive
        //Not Embedable: SucursalIdOrigen -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL__ORIGEN
        dtoEntity.setSucursalIdOrigen( jpaEntity.getSucursalsucursalOrigen()!=null?jpaEntity.getSucursalsucursalOrigen().getId():null);
        dtoEntity.setAlmacenOrigen( jpaEntity.getAlmacenOrigen() ); // primitive
        //Not Embedable: SucursalIdDestino -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL__DESTINO
        dtoEntity.setSucursalIdDestino( jpaEntity.getSucursalsucursalDestino()!=null?jpaEntity.getSucursalsucursalDestino().getId():null);
        dtoEntity.setAlmacenDestino( jpaEntity.getAlmacenDestino() ); // primitive
        dtoEntity.setTipoMov( jpaEntity.getTipoMov() ); // primitive

        return dtoEntity;
    }

	public static List<MovimientoOperativoDTO> buildDTOEntityList(List<MovimientoOperativo> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<MovimientoOperativoDTO> dtoEntityList = new ArrayList<>();
        MovimientoOperativoDTO dtoEntity =  null;
		for(MovimientoOperativo jpaEntity: jpaEntityList){
			dtoEntity =  new MovimientoOperativoDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setMotivo( jpaEntity.getMotivo() );
            dtoEntity.setFecha( jpaEntity.getFecha() );
            //Not Embedable: SucursalIdOrigen -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL__ORIGEN
            dtoEntity.setSucursalIdOrigen( jpaEntity.getSucursalsucursalOrigen()!=null?jpaEntity.getSucursalsucursalOrigen().getId():null);
            dtoEntity.setAlmacenOrigen( jpaEntity.getAlmacenOrigen() );
            //Not Embedable: SucursalIdDestino -> Sucursal, FTable: SUCURSAL, HyperName:SUCURSALSUCURSAL__DESTINO
            dtoEntity.setSucursalIdDestino( jpaEntity.getSucursalsucursalDestino()!=null?jpaEntity.getSucursalsucursalDestino().getId():null);
            dtoEntity.setAlmacenDestino( jpaEntity.getAlmacenDestino() );
            dtoEntity.setTipoMov( jpaEntity.getTipoMov() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
