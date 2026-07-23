package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VentaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VentaResponseDto;


public interface IVentaService {

	List<VentaResponseDto> listarVenta();
	
	void guardarVenta(VentaRequestDto nuevo);
	
	VentaResponseDto buscarPorId(int idVenta);
}
