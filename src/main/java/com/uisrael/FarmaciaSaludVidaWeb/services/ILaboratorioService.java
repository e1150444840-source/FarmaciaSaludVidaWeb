package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LaboratorioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LaboratorioResponseDto;


public interface ILaboratorioService {

	List<LaboratorioResponseDto> listarLaboratorio();

	void guardarLaboratorio(LaboratorioRequestDto nuevo);
	
	LaboratorioResponseDto buscarPorId(int idLaboratorio);
	
	LaboratorioResponseDto eliminarPorId(int idLaboratorio);
	
	boolean existePorNombreLaboratorio(String nombreLaboratorio);

	boolean existePorTelefonoLaboratorio(String telefonoLaboratorio);
}
