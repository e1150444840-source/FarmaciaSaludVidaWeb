package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.UsuarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.UsuarioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	private final WebClient webClient;

	public UsuarioServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<UsuarioResponseDto> listarUsuario() {
		return webClient.get().uri("/usuario").retrieve()
				.bodyToFlux(UsuarioResponseDto.class).collectList().block();
	}

	@Override
	public void guardarUsuario(UsuarioRequestDto nuevo) {
		webClient.post().uri("/usuario")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();
		
	}

}
