package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.FarmaciaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.FarmaciaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IFarmaciaService;

import reactor.core.publisher.Mono;

@Service
public class FarmaciaServiceImpl implements IFarmaciaService {

	private final WebClient webClient;

	public FarmaciaServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<FarmaciaResponseDto> listarFarmacia() {
		return webClient.get().uri("/farmacia").retrieve().bodyToFlux(FarmaciaResponseDto.class).collectList().block();
	}

	@Override
	public void guardarFarmacia(FarmaciaRequestDto nuevo) {
		webClient.post().uri("/farmacia").bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}

	@Override
	public FarmaciaResponseDto buscarPorId(int idFarmacia) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/farmacia/buscarId/{idFarmacia}").build(idFarmacia))
				.retrieve().bodyToMono(FarmaciaResponseDto.class).block();
	}

	@Override
	public FarmaciaResponseDto eliminarPorId(int idFarmacia) {
		return webClient.post()
				.uri(uriBuilder -> uriBuilder.path("/farmacia/eliminarId/{idFarmacia}").build(idFarmacia)).retrieve()
				.bodyToMono(FarmaciaResponseDto.class).block();
	}

	@Override
	public boolean existePorNombreFarmacia(String nombreFarmacia) {
		return Boolean.TRUE.equals(webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/farmacia/existePorNombreFarmacia/{nombreFarmacia}")
						.build(nombreFarmacia))
				.retrieve().bodyToMono(Boolean.class)
				.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false)).onErrorReturn(false).block());

	}

}
