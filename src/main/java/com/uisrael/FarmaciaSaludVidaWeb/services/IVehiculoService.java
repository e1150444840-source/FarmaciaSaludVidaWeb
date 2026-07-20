package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VehiculoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VehiculoResponseDto;

public interface IVehiculoService {

	List<VehiculoResponseDto> listarVehiculo();

	void guardarVehiculo(VehiculoRequestDto nuevo);
}
