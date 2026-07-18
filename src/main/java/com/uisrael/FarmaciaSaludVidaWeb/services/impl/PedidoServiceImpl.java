package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.PedidoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService {

	private final WebClient webClient;
	
	public PedidoServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<PedidoResponseDto> listarPedido() {
		return webClient.get().uri("/pedido").retrieve()
				.bodyToFlux(PedidoResponseDto.class).collectList().block();
	}

	
}
