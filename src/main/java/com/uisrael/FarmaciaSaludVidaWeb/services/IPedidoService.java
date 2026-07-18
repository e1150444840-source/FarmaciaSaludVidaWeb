package com.uisrael.FarmaciaSaludVidaWeb.services;

import java.util.List;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.PedidoResponseDto;

public interface IPedidoService {

	List<PedidoResponseDto> listarPedido();
}
