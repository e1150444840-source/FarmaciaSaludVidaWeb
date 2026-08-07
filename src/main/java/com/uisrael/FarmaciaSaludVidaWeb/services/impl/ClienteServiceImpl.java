package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IClienteService;

import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements IClienteService {

	private final WebClient webClient;

	public ClienteServiceImpl(WebClient webClient) {
	
		this.webClient = webClient;
	}

	//LISTAR
	@Override
	public List<ClienteResponseDto> listarCliente() {
		return webClient.get().uri("/cliente").retrieve()
				.bodyToFlux(ClienteResponseDto.class).collectList().block();
	}

	//GUARDAR
	@Override
	public void guardarCliente(ClienteRequestDto nuevo) {
		webClient.post().uri("/cliente")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
		
	}

	//BUSCAR
	@Override
	public ClienteResponseDto buscarPorId(int idCliente) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/cliente/buscarId/{idCliente}")
				.build(idCliente)).retrieve().bodyToMono(ClienteResponseDto.class).block();
	}
	
	//ELIMINAR
	@Override
	public ClienteResponseDto eliminarPorId(int idCliente) {
		return webClient.post()
	            .uri(uriBuilder -> uriBuilder.path("/cliente/eliminarId/{idCliente}")
	                    .build(idCliente))
	            .retrieve()
	            .bodyToMono(ClienteResponseDto.class)
	            .block();
	}

	// VALIDACIONES CON CAPTURA ROBUSTA DE ERRORES (404 Not Found)
		@Override
		public boolean existePorCedula(String ciCliente) {
			return Boolean.TRUE.equals(webClient.get()
					.uri(uriBuilder -> uriBuilder.path("/cliente/existeCedula/{ciCliente}").build(ciCliente))
					.retrieve()
					.bodyToMono(Boolean.class)
					.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false))
					.onErrorReturn(false)
					.block());
		}

		@Override
		public boolean existePorCorreoElectronico(String correoCliente) {
			return Boolean.TRUE.equals(webClient.get()
					.uri(uriBuilder -> uriBuilder.path("/cliente/existeCorreo/{correoCliente}").build(correoCliente))
					.retrieve()
					.bodyToMono(Boolean.class)
					.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false))
					.onErrorReturn(false)
					.block());
		}

		@Override
		public boolean existePorTelefono(String telefonoCliente) {
			return Boolean.TRUE.equals(webClient.get()
					.uri(uriBuilder -> uriBuilder.path("/cliente/existeTelefono/{telefonoCliente}").build(telefonoCliente))
					.retrieve()
					.bodyToMono(Boolean.class)
					.onErrorResume(WebClientResponseException.class, ex -> Mono.just(false))
					.onErrorReturn(false)
					.block());
		}
	
}
