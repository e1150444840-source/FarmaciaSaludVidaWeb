package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.DetalleVentaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.DetalleVentaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IDetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

	private final WebClient webClient;

	public DetalleVentaServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<DetalleVentaResponseDto> listarDetalleVenta() {
		return webClient.get().uri("/detalleVenta").retrieve()
				.bodyToFlux(DetalleVentaResponseDto.class).collectList().block();
	}

	@Override
	public void guardarDetalleVenta(DetalleVentaRequestDto nuevo) {
		webClient.post().uri("/detalleVenta")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
		
	}

}
