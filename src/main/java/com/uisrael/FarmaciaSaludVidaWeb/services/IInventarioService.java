package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.InventarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.InventarioResponseDto;

public interface IInventarioService {

	List<InventarioResponseDto> listarInventario();

	void guardarInventario(InventarioRequestDto nuevo);

	InventarioResponseDto buscarPorId(int idInventario);

	InventarioResponseDto eliminarPorId(int idInventario);
}
