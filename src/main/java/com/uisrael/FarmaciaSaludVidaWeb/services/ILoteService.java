package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LoteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LoteResponseDto;


public interface ILoteService {

	List<LoteResponseDto> listarLote();
	
	void guardarLote(LoteRequestDto nuevo);
	
	LoteResponseDto buscarPorId(int idLote);
}
