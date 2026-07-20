package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.PedidoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.PedidoResponseDto;

public interface IPedidoService {

	List<PedidoResponseDto> listarPedido();
	
	void guardarPedido(PedidoRequestDto nuevo);
}
