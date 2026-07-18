package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VentaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	private final WebClient webClient;

	public VentaServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<VentaResponseDto> listarVenta() {
		return webClient.get().uri("/venta").retrieve()
				.bodyToFlux(VentaResponseDto.class).collectList().block();
	}

}
