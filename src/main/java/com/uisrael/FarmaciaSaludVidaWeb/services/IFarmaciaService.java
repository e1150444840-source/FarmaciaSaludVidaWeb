package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.FarmaciaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.FarmaciaResponseDto;

public interface IFarmaciaService {

	List<FarmaciaResponseDto> listarFarmacia();

	void guardarFarmacia(FarmaciaRequestDto nuevo);
	
	FarmaciaResponseDto buscarPorId(int idFarmacia);
	
	FarmaciaResponseDto eliminarPorId(int idFarmacia);
	
	boolean existePorNombreFarmacia(String nombreFarmacia);

}
