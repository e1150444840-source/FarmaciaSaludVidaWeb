package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LoteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILoteService;

@Service
public class LoteServiceImpl implements ILoteService {

	private final WebClient webClient;
	
	public LoteServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<LoteResponseDto> listarLote() {
		return webClient.get().uri("/lote").retrieve()
				.bodyToFlux(LoteResponseDto.class).collectList().block();
	}

}
