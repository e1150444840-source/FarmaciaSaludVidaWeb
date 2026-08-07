package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.UsuarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.UsuarioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IUsuarioService;

import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private final WebClient webClient;

	public UsuarioServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<UsuarioResponseDto> listarUsuario() {
		return webClient.get().uri("/usuario").retrieve().bodyToFlux(UsuarioResponseDto.class).collectList().block();
	}

	@Override
	public void guardarUsuario(UsuarioRequestDto nuevo) {
		webClient.post().uri("/usuario").bodyValue(nuevo).retrieve().toBodilessEntity().block();

	}

	@Override
	public UsuarioResponseDto buscarPorId(int idUsuario) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/usuario/buscarId/{idUsuario}").build(idUsuario))
				.retrieve().bodyToMono(UsuarioResponseDto.class).block();
	}

	@Override
	public UsuarioResponseDto eliminarPorId(int idUsuario) {
		return webClient.post().uri(uriBuilder -> uriBuilder.path("/usuario/eliminarId/{idUsuario}").build(idUsuario))
				.retrieve().bodyToMono(UsuarioResponseDto.class).block();
	}

	@Override
	public boolean existePorPassword(String password) {
		return Boolean.TRUE.equals(webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/usuario/existePorPassword/{password}").build(password)).retrieve()
				.bodyToMono(Boolean.class).onErrorResume(WebClientResponseException.class, ex -> Mono.just(false))
				.onErrorReturn(false).block());
	}

	@Override
	public boolean existePorUserName(String username) {
		return Boolean.TRUE.equals(webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/usuario/existePorUserName/{username}").build(username)).retrieve()
				.bodyToMono(Boolean.class).onErrorResume(WebClientResponseException.class, ex -> Mono.just(false))
				.onErrorReturn(false).block());
	}

}
