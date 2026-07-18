package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.InventarioResponseDto;


public interface IInventarioService {

	List<InventarioResponseDto> listarInventario();
}
