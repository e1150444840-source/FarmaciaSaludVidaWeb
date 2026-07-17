package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.FarmaciaResponseDto;

public interface IFarmaciaService {

	List<FarmaciaResponseDto> listarFarmacia();
}
