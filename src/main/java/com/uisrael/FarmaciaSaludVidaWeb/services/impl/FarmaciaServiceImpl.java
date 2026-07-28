package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.FarmaciaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.FarmaciaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IFarmaciaService;

@Service
public class FarmaciaServiceImpl implements IFarmaciaService {

	private final WebClient webClient;

	public FarmaciaServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<FarmaciaResponseDto> listarFarmacia() {
		return webClient.get().uri("/farmacia").retrieve()
				.bodyToFlux(FarmaciaResponseDto.class).collectList().block();
	}

	@Override
	public void guardarFarmacia(FarmaciaRequestDto nuevo) {
		webClient.post().uri("/farmacia")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
		
	}

	@Override
	public FarmaciaResponseDto buscarPorId(int idFarmacia) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/farmacia/buscarId/{idFarmacia}")
				.build(idFarmacia)).retrieve().bodyToMono(FarmaciaResponseDto.class).block();
	}

	@Override
	public FarmaciaResponseDto eliminarPorId(int idFarmacia) {
		return webClient.post()
	            .uri(uriBuilder -> uriBuilder.path("/farmacia/eliminarId/{idFarmacia}")
	                    .build(idFarmacia))
	            .retrieve()
	            .bodyToMono(FarmaciaResponseDto.class)
	            .block();
	}
	

}
