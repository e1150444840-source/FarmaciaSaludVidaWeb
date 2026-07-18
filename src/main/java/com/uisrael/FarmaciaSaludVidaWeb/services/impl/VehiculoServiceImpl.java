package com.uisrael.FarmaciaSaludVidaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
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

}
