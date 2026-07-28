package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VehiculoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VehiculoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVehiculoService;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	private final WebClient webClient;

	public VehiculoServiceImpl(WebClient webClient) {

		this.webClient = webClient;
	}

	@Override
	public List<VehiculoResponseDto> listarVehiculo() {
		return webClient.get().uri("/vehiculo").retrieve()
				.bodyToFlux(VehiculoResponseDto.class).collectList().block();
	}

	@Override
	public void guardarVehiculo(VehiculoRequestDto nuevo) {
		webClient.post().uri("/vehiculo")
		.bodyValue(nuevo).retrieve().toBodilessEntity().block();		
	}

	@Override
	public VehiculoResponseDto buscarPorId(int idVehiculo) {
		return webClient.get().uri(UriBuilder -> UriBuilder.path("/vehiculo/buscarId/{idVehiculo}")
				.build(idVehiculo)).retrieve().bodyToMono(VehiculoResponseDto.class).block();
	}

	@Override
	public VehiculoResponseDto eliminarPorId(int idVehiculo) {
		return webClient.post()
	            .uri(uriBuilder -> uriBuilder.path("/vehiculo/eliminarId/{idVehiculo}")
	                    .build(idVehiculo))
	            .retrieve()
	            .bodyToMono(VehiculoResponseDto.class)
	            .block();
	}
}
