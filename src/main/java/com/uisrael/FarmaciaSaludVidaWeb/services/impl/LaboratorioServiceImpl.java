package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LaboratorioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LaboratorioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILaboratorioService;

import reactor.core.publisher.Mono;

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
		webClient.post().uri("/laboratorio").bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}

	@Override
	public LaboratorioResponseDto buscarPorId(int idLaboratorio) {
		return webClient.get()
				.uri(UriBuilder -> UriBuilder.path("/laboratorio/buscarId/{idLaboratorio}").build(idLaboratorio))
				.retrieve().bodyToMono(LaboratorioResponseDto.class).block();
	}

	@Override
	public LaboratorioResponseDto eliminarPorId(int idLaboratorio) {
		return webClient.post()
				.uri(uriBuilder -> uriBuilder.path("/laboratorio/eliminarId/{idLaboratorio}").build(idLaboratorio))
				.retrieve().bodyToMono(LaboratorioResponseDto.class).block();
	}

	@Override
	public boolean existePorNombreLaboratorio(String nombreLaboratorio) {
		return Boolean.TRUE.equals(webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/laboratorio/existePorNombreLaboratorio/{nombreLaboratorio}")
						.build(nombreLaboratorio))
				.retrieve().bodyToMono(Boolean.class)
				.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false)).onErrorReturn(false).block());
	}

	@Override
	public boolean existePorTelefonoLaboratorio(String telefonoLaboratorio) {
		return Boolean.TRUE.equals(webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/laboratorio/existePorTelefonoLaboratorio/{telefonoLaboratorio}")
						.build(telefonoLaboratorio))
				.retrieve().bodyToMono(Boolean.class)
				.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false)).onErrorReturn(false).block());
	}

}
