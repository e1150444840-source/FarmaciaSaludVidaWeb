package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LaboratorioResponseDto;


public interface ILaboratorioService {

	List<LaboratorioResponseDto> listarLaboratorio();
}
