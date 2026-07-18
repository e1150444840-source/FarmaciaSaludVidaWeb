package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LaboratorioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILaboratorioService;

@Service
public class LaboratorioServiceImpl implements ILaboratorioService {

	private final WebClient webClient;

	public LaboratorioServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<LaboratorioResponseDto> listarLaboratorio() {
		return webClient.get().uri("/laboratotio").retrieve()
				.bodyToFlux(LaboratorioResponseDto.class).collectList().block();
	}

}
