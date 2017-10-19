package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.Cliente;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table CLIENTE.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/10/19 00:02
 */

public class ClienteAssembler {    
    
    /** 
     * Private Constructor
     */
    private ClienteAssembler() {
    }

    public static Cliente buildJpaEntity(ClienteDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		Cliente jpaEntity = new Cliente();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setRfc( dtoEntity.getRfc()); // normal
        jpaEntity.setRazonSocial( dtoEntity.getRazonSocial()); // normal
        jpaEntity.setNombreEstablecimiento( dtoEntity.getNombreEstablecimiento()); // normal
        jpaEntity.setDireccionFacturacion( dtoEntity.getDireccionFacturacion()); // normal
        jpaEntity.setTelefonos( dtoEntity.getTelefonos()); // normal
        jpaEntity.setBanco( dtoEntity.getBanco()); // normal
        jpaEntity.setNumCuenta( dtoEntity.getNumCuenta()); // normal
        jpaEntity.setEmail( dtoEntity.getEmail()); // normal
        jpaEntity.setReferencia( dtoEntity.getReferencia()); // normal
        jpaEntity.setContacto( dtoEntity.getContacto()); // normal
        jpaEntity.setUbicacionLat( dtoEntity.getUbicacionLat()); // normal
        jpaEntity.setUbicacionLon( dtoEntity.getUbicacionLon()); // normal

        return jpaEntity;
    }

    public static List<Cliente> buildJpaEntityList(List<ClienteDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<Cliente> jpaEntityList = new ArrayList<>();
		Cliente jpaEntity = null;
		for(ClienteDTO dtoEntity: dtoEntityList){
			jpaEntity = new Cliente();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setRfc( dtoEntity.getRfc());
            jpaEntity.setRazonSocial( dtoEntity.getRazonSocial());
            jpaEntity.setNombreEstablecimiento( dtoEntity.getNombreEstablecimiento());
            jpaEntity.setDireccionFacturacion( dtoEntity.getDireccionFacturacion());
            jpaEntity.setTelefonos( dtoEntity.getTelefonos());
            jpaEntity.setBanco( dtoEntity.getBanco());
            jpaEntity.setNumCuenta( dtoEntity.getNumCuenta());
            jpaEntity.setEmail( dtoEntity.getEmail());
            jpaEntity.setReferencia( dtoEntity.getReferencia());
            jpaEntity.setContacto( dtoEntity.getContacto());
            jpaEntity.setUbicacionLat( dtoEntity.getUbicacionLat());
            jpaEntity.setUbicacionLon( dtoEntity.getUbicacionLon());
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static ClienteDTO buildDTOEntity(Cliente jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        ClienteDTO dtoEntity =  new ClienteDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setRfc( jpaEntity.getRfc() ); // primitive
        dtoEntity.setRazonSocial( jpaEntity.getRazonSocial() ); // primitive
        dtoEntity.setNombreEstablecimiento( jpaEntity.getNombreEstablecimiento() ); // primitive
        dtoEntity.setDireccionFacturacion( jpaEntity.getDireccionFacturacion() ); // primitive
        dtoEntity.setTelefonos( jpaEntity.getTelefonos() ); // primitive
        dtoEntity.setBanco( jpaEntity.getBanco() ); // primitive
        dtoEntity.setNumCuenta( jpaEntity.getNumCuenta() ); // primitive
        dtoEntity.setEmail( jpaEntity.getEmail() ); // primitive
        dtoEntity.setReferencia( jpaEntity.getReferencia() ); // primitive
        dtoEntity.setContacto( jpaEntity.getContacto() ); // primitive
        dtoEntity.setUbicacionLat( jpaEntity.getUbicacionLat() ); // primitive
        dtoEntity.setUbicacionLon( jpaEntity.getUbicacionLon() ); // primitive

        return dtoEntity;
    }

	public static List<ClienteDTO> buildDTOEntityList(List<Cliente> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<ClienteDTO> dtoEntityList = new ArrayList<>();
        ClienteDTO dtoEntity =  null;
		for(Cliente jpaEntity: jpaEntityList){
			dtoEntity =  new ClienteDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setRfc( jpaEntity.getRfc() );
            dtoEntity.setRazonSocial( jpaEntity.getRazonSocial() );
            dtoEntity.setNombreEstablecimiento( jpaEntity.getNombreEstablecimiento() );
            dtoEntity.setDireccionFacturacion( jpaEntity.getDireccionFacturacion() );
            dtoEntity.setTelefonos( jpaEntity.getTelefonos() );
            dtoEntity.setBanco( jpaEntity.getBanco() );
            dtoEntity.setNumCuenta( jpaEntity.getNumCuenta() );
            dtoEntity.setEmail( jpaEntity.getEmail() );
            dtoEntity.setReferencia( jpaEntity.getReferencia() );
            dtoEntity.setContacto( jpaEntity.getContacto() );
            dtoEntity.setUbicacionLat( jpaEntity.getUbicacionLat() );
            dtoEntity.setUbicacionLon( jpaEntity.getUbicacionLon() );
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
