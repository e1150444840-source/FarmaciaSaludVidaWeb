package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.CategoriaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.CategoriaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	private final WebClient webClient;

	public CategoriaServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<CategoriaResponseDto> listarCategoria() {
		return webClient.get().uri("/categoria").retrieve()
				.bodyToFlux(CategoriaResponseDto.class).collectList().block();
	}

	@Override
	public void guardarCategoria(CategoriaRequestDto nuevo) {
		webClient.post().uri("/categoria")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
				
	}

	@Override
	public CategoriaResponseDto buscarPorId(int idCategoria) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/categoria/buscarId/{idCategoria}")
				.build(idCategoria)).retrieve().bodyToMono(CategoriaResponseDto.class).block();
	}

	@Override
	public CategoriaResponseDto eliminarPorId(int idCategoria) {
		return webClient.post()
	            .uri(uriBuilder -> uriBuilder.path("/categoria/eliminarId/{idCategoria}")
	                    .build(idCategoria))
	            .retrieve()
	            .bodyToMono(CategoriaResponseDto.class)
	            .block();
	}

}
