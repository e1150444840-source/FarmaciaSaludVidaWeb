package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.InventarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.InventarioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IInventarioService;

@Service
public class InventarioServiceImpl implements IInventarioService {

	private final WebClient webClient;
	
	public InventarioServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<InventarioResponseDto> listarInventario() {
		return webClient.get().uri("/inventario").retrieve()
				.bodyToFlux(InventarioResponseDto.class).collectList().block();
	}

	@Override
	public void guardarInventario(InventarioRequestDto nuevo) {
		webClient.post().uri("/inventario")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
		
	}

	@Override
	public InventarioResponseDto buscarPorId(int idInventario) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/inventario/buscarId/{idInventario}")
				.build(idInventario)).retrieve().bodyToMono(InventarioResponseDto.class).block();
	}
}
