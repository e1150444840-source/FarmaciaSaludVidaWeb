package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.DetalleVentaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.DetalleVentaResponseDto;

public interface IDetalleVentaService {

	List<DetalleVentaResponseDto> listarDetalleVenta();

	void guardarDetalleVenta(DetalleVentaRequestDto nuevo);
	
	DetalleVentaResponseDto buscarPorId(int idDetalleVenta);
	
	DetalleVentaResponseDto eliminarPorId(int idDetalleVenta);
}
