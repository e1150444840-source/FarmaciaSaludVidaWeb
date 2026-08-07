package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LoteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LoteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILoteService;

import reactor.core.publisher.Mono;

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

	@Override
	public void guardarLote(LoteRequestDto nuevo) {
		webClient.post().uri("/lote")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
		
	}

	@Override
	public LoteResponseDto buscarPorId(int idLote) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/lote/buscarId/{idLote}")
				.build(idLote)).retrieve().bodyToMono(LoteResponseDto.class).block();
	}

	@Override
	public LoteResponseDto eliminarPorId(int idLote) {
		return webClient.post()
	            .uri(uriBuilder -> uriBuilder.path("/lote/eliminarId/{idLote}")
	                    .build(idLote))
	            .retrieve()
	            .bodyToMono(LoteResponseDto.class)
	            .block();
	}

	@Override
	public boolean existePorNumeroLote(String numeroLote) {
		return Boolean.TRUE.equals(webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/lote/existePorNumeroLote/{numeroLote}").build(numeroLote))
				.retrieve()
				.bodyToMono(Boolean.class)
				.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false))
				.onErrorReturn(false)
				.block());
	}

}
