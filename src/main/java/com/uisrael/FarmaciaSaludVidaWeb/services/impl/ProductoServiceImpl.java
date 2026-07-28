package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ProductoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ProductoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	private final WebClient webClient;

	public ProductoServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<ProductoResponseDto> listarProducto() {
		return webClient.get().uri("/producto").retrieve()
				.bodyToFlux(ProductoResponseDto.class).collectList().block();
	}

	@Override
	public void guardarProducto(ProductoRequestDto nuevo) {
		webClient.post().uri("/producto")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
	}

	@Override
	public ProductoResponseDto buscarPorId(int idProducto) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/producto/buscarId/{idProducto}")
				.build(idProducto)).retrieve().bodyToMono(ProductoResponseDto.class).block();
	}

	@Override
	public ProductoResponseDto eliminarPorId(int idProducto) {
		return webClient.post()
	            .uri(uriBuilder -> uriBuilder.path("/producto/eliminarId/{idProducto}")
	                    .build(idProducto))
	            .retrieve()
	            .bodyToMono(ProductoResponseDto.class)
	            .block();
	}



}
