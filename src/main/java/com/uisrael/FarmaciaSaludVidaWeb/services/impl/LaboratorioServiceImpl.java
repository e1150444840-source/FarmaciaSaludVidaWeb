package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LaboratorioRequestDto;
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
		return webClient.get().uri("/laboratorio").retrieve().bodyToFlux(LaboratorioResponseDto.class).collectList()
				.block();
	}

	@Override
	public void guardarLaboratorio(LaboratorioRequestDto nuevo) {
		webClient.post().uri("/laboratorio")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}

	@Override
	public LaboratorioResponseDto buscarPorId(int idLaboratorio) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/laboratorio/buscarId/{idLaboratorio}")
				.build(idLaboratorio)).retrieve().bodyToMono(LaboratorioResponseDto.class).block();
	}

}
