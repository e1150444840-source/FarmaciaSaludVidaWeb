package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.TipoClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.TipoClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ITipoClienteService;

import reactor.core.publisher.Mono;

@Service
public class TipoClienteServiceImpl implements ITipoClienteService {

	private final WebClient webClient;

	public TipoClienteServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<TipoClienteResponseDto> listarTipoCliente() {
		return webClient.get().uri("/tipoCliente").retrieve().bodyToFlux(TipoClienteResponseDto.class).collectList()
				.block();
	}

	@Override
	public void guardarTipoCliente(TipoClienteRequestDto nuevo) {
		webClient.post().uri("/tipoCliente").bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}

	@Override
	public TipoClienteResponseDto buscarPorId(int idTipoCliente) {
		return webClient.get()
				.uri(UriBuilder -> UriBuilder.path("/tipoCliente/buscarId/{idTipoCliente}").build(idTipoCliente))
				.retrieve().bodyToMono(TipoClienteResponseDto.class).block();
	}

	@Override
	public TipoClienteResponseDto eliminarPorId(int idTipoCliente) {
		return webClient.post()
				.uri(uriBuilder -> uriBuilder.path("/tipoCliente/eliminarId/{idTipoCliente}").build(idTipoCliente))
				.retrieve().bodyToMono(TipoClienteResponseDto.class).block();
	}

	@Override
	public boolean existePorNombreTipoCliente(String nombreTipoCliente) {
		return Boolean.TRUE.equals(webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/tipoCliente/existePorNombreTipoCliente/{nombreTipoCliente}")
						.build(nombreTipoCliente))
				.retrieve().bodyToMono(Boolean.class)
				.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false)).onErrorReturn(false).block());
	}

}
