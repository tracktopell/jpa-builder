/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmarlen.l30.api;

import com.pmarlen.l30.backend.dto.EstadoDTO;
import java.util.List;

/**
 *
 * @author alfredo
 */
public interface CatalogosSimplesService {
	List<EstadoDTO> getEstados();	
}
