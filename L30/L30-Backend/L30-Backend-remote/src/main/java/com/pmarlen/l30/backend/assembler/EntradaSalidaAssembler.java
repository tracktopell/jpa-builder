package com.pmarlen.l30.backend.assembler;

import java.util.List;
import java.util.ArrayList;

import com.pmarlen.l30.backend.dto.*;
import com.pmarlen.l30.backend.entity.EntradaSalida;

/**
 * Class for Asembler DTO Entity and JPA Entity for Table ENTRADA_SALIDA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/UtilProjects/tree/master/jpa-builder
 * @version 0.10.9
 * @date 2017/07/27 19:58
 */

public class EntradaSalidaAssembler {    
    
    /** 
     * Private Constructor
     */
    private EntradaSalidaAssembler() {
    }

    public static EntradaSalida buildJpaEntity(EntradaSalidaDTO dtoEntity){
		if(dtoEntity == null){
			return null;
		}

		EntradaSalida jpaEntity = new EntradaSalida();

        jpaEntity.setId( dtoEntity.getId()); // normal
        jpaEntity.setTipoMov( dtoEntity.getTipoMov()); // normal
        jpaEntity.setFechaCreo( dtoEntity.getFechaCreo()); // normal
        EstadoDTO estadoestadoActualDTO = new EstadoDTO();
        estadoestadoActualDTO.setId( dtoEntity.getEstadoIdActual());
        jpaEntity.setEstadoestadoActual( EstadoAssembler.buildJpaEntity( estadoestadoActualDTO ));
        ClienteDTO clienteclienteDTO = new ClienteDTO();
        clienteclienteDTO.setId( dtoEntity.getClienteId());
        jpaEntity.setClientecliente( ClienteAssembler.buildJpaEntity( clienteclienteDTO ));
        FormaDePagoDTO formaDePagoformaDePagoDTO = new FormaDePagoDTO();
        formaDePagoformaDePagoDTO.setId( dtoEntity.getFormaDePagoId());
        jpaEntity.setFormaDePagoformaDePago( FormaDePagoAssembler.buildJpaEntity( formaDePagoformaDePagoDTO ));
        MetodoDePagoDTO metodoDePagometodoDePagoDTO = new MetodoDePagoDTO();
        metodoDePagometodoDePagoDTO.setId( dtoEntity.getMetodoDePagoId());
        jpaEntity.setMetodoDePagometodoDePago( MetodoDePagoAssembler.buildJpaEntity( metodoDePagometodoDePagoDTO ));
        UsuarioDTO usuariousuarioCreoDTO = new UsuarioDTO();
        usuariousuarioCreoDTO.setId( dtoEntity.getUsuarioIdCreo());
        jpaEntity.setUsuariousuarioCreo( UsuarioAssembler.buildJpaEntity( usuariousuarioCreoDTO ));
        UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
        usuariousuarioDTO.setId( dtoEntity.getUsuarioid());
        jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));

        return jpaEntity;
    }

    public static List<EntradaSalida> buildJpaEntityList(List<EntradaSalidaDTO> dtoEntityList){
		if(dtoEntityList == null){
			return null;
		}
		List<EntradaSalida> jpaEntityList = new ArrayList<>();
		EntradaSalida jpaEntity = null;
		for(EntradaSalidaDTO dtoEntity: dtoEntityList){
			jpaEntity = new EntradaSalida();
            jpaEntity.setId( dtoEntity.getId());
            jpaEntity.setTipoMov( dtoEntity.getTipoMov());
            jpaEntity.setFechaCreo( dtoEntity.getFechaCreo());
            EstadoDTO estadoestadoActualDTO = new EstadoDTO();
            estadoestadoActualDTO.setId( dtoEntity.getEstadoIdActual());
            jpaEntity.setEstadoestadoActual( EstadoAssembler.buildJpaEntity( estadoestadoActualDTO ));
            ClienteDTO clienteclienteDTO = new ClienteDTO();
            clienteclienteDTO.setId( dtoEntity.getClienteId());
            jpaEntity.setClientecliente( ClienteAssembler.buildJpaEntity( clienteclienteDTO ));
            FormaDePagoDTO formaDePagoformaDePagoDTO = new FormaDePagoDTO();
            formaDePagoformaDePagoDTO.setId( dtoEntity.getFormaDePagoId());
            jpaEntity.setFormaDePagoformaDePago( FormaDePagoAssembler.buildJpaEntity( formaDePagoformaDePagoDTO ));
            MetodoDePagoDTO metodoDePagometodoDePagoDTO = new MetodoDePagoDTO();
            metodoDePagometodoDePagoDTO.setId( dtoEntity.getMetodoDePagoId());
            jpaEntity.setMetodoDePagometodoDePago( MetodoDePagoAssembler.buildJpaEntity( metodoDePagometodoDePagoDTO ));
            UsuarioDTO usuariousuarioCreoDTO = new UsuarioDTO();
            usuariousuarioCreoDTO.setId( dtoEntity.getUsuarioIdCreo());
            jpaEntity.setUsuariousuarioCreo( UsuarioAssembler.buildJpaEntity( usuariousuarioCreoDTO ));
            UsuarioDTO usuariousuarioDTO = new UsuarioDTO();
            usuariousuarioDTO.setId( dtoEntity.getUsuarioid());
            jpaEntity.setUsuariousuario( UsuarioAssembler.buildJpaEntity( usuariousuarioDTO ));
			jpaEntityList.add(jpaEntity);
		}
		
        return jpaEntityList;
    }

	public static EntradaSalidaDTO buildDTOEntity(EntradaSalida jpaEntity){
		if(jpaEntity == null){
			return null;
		}

        EntradaSalidaDTO dtoEntity =  new EntradaSalidaDTO();		

        dtoEntity.setId( jpaEntity.getId() ); // primitive
        dtoEntity.setTipoMov( jpaEntity.getTipoMov() ); // primitive
        dtoEntity.setFechaCreo( jpaEntity.getFechaCreo() ); // primitive
        //Not Embedable: EstadoIdActual -> Estado, FTable: ESTADO, HyperName:ESTADOESTADO__ACTUAL
        dtoEntity.setEstadoIdActual( jpaEntity.getEstadoestadoActual()!=null?jpaEntity.getEstadoestadoActual().getId():null);
        //Not Embedable: ClienteId -> Cliente, FTable: CLIENTE, HyperName:CLIENTECLIENTE_
        dtoEntity.setClienteId( jpaEntity.getClientecliente()!=null?jpaEntity.getClientecliente().getId():null);
        //Not Embedable: FormaDePagoId -> FormaDePago, FTable: FORMA_DE_PAGO, HyperName:FORMA_DE_PAGOFORMA_DE_PAGO_
        dtoEntity.setFormaDePagoId( jpaEntity.getFormaDePagoformaDePago()!=null?jpaEntity.getFormaDePagoformaDePago().getId():null);
        //Not Embedable: MetodoDePagoId -> MetodoDePago, FTable: METODO_DE_PAGO, HyperName:METODO_DE_PAGOMETODO_DE_PAGO_
        dtoEntity.setMetodoDePagoId( jpaEntity.getMetodoDePagometodoDePago()!=null?jpaEntity.getMetodoDePagometodoDePago().getId():null);
        //Not Embedable: UsuarioIdCreo -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO__CREO
        dtoEntity.setUsuarioIdCreo( jpaEntity.getUsuariousuarioCreo()!=null?jpaEntity.getUsuariousuarioCreo().getId():null);
        //Not Embedable: Usuarioid -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO
        dtoEntity.setUsuarioid( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);

        return dtoEntity;
    }

	public static List<EntradaSalidaDTO> buildDTOEntityList(List<EntradaSalida> jpaEntityList){
		if(jpaEntityList == null){
			return null;
		}
		List<EntradaSalidaDTO> dtoEntityList = new ArrayList<>();
        EntradaSalidaDTO dtoEntity =  null;
		for(EntradaSalida jpaEntity: jpaEntityList){
			dtoEntity =  new EntradaSalidaDTO();
            dtoEntity.setId( jpaEntity.getId() );
            dtoEntity.setTipoMov( jpaEntity.getTipoMov() );
            dtoEntity.setFechaCreo( jpaEntity.getFechaCreo() );
            //Not Embedable: EstadoIdActual -> Estado, FTable: ESTADO, HyperName:ESTADOESTADO__ACTUAL
            dtoEntity.setEstadoIdActual( jpaEntity.getEstadoestadoActual()!=null?jpaEntity.getEstadoestadoActual().getId():null);
            //Not Embedable: ClienteId -> Cliente, FTable: CLIENTE, HyperName:CLIENTECLIENTE_
            dtoEntity.setClienteId( jpaEntity.getClientecliente()!=null?jpaEntity.getClientecliente().getId():null);
            //Not Embedable: FormaDePagoId -> FormaDePago, FTable: FORMA_DE_PAGO, HyperName:FORMA_DE_PAGOFORMA_DE_PAGO_
            dtoEntity.setFormaDePagoId( jpaEntity.getFormaDePagoformaDePago()!=null?jpaEntity.getFormaDePagoformaDePago().getId():null);
            //Not Embedable: MetodoDePagoId -> MetodoDePago, FTable: METODO_DE_PAGO, HyperName:METODO_DE_PAGOMETODO_DE_PAGO_
            dtoEntity.setMetodoDePagoId( jpaEntity.getMetodoDePagometodoDePago()!=null?jpaEntity.getMetodoDePagometodoDePago().getId():null);
            //Not Embedable: UsuarioIdCreo -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO__CREO
            dtoEntity.setUsuarioIdCreo( jpaEntity.getUsuariousuarioCreo()!=null?jpaEntity.getUsuariousuarioCreo().getId():null);
            //Not Embedable: Usuarioid -> Usuario, FTable: USUARIO, HyperName:USUARIOUSUARIO
            dtoEntity.setUsuarioid( jpaEntity.getUsuariousuario()!=null?jpaEntity.getUsuariousuario().getId():null);
			dtoEntityList.add(dtoEntity);
		}
        return dtoEntityList;
    }
}
