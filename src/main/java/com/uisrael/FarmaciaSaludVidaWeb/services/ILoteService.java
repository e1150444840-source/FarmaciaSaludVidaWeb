package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LoteResponseDto;


public interface ILoteService {

	List<LoteResponseDto> listarLote();
}
