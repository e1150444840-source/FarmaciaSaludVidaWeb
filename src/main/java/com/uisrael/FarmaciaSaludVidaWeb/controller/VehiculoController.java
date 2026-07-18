package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VehiculoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVehiculoService;

@Controller
@RequestMapping("/vehiculo") // url
public class VehiculoController {

	@Autowired
	private IVehiculoService servicioVehiculo;

	// CONSTRUCTOR
	public VehiculoController(IVehiculoService servicioVehiculo) {

		this.servicioVehiculo = servicioVehiculo;
	}

	@GetMapping
	public String leerPagina() {
		List<VehiculoResponseDto> resultadoDB = servicioVehiculo.listarVehiculo();
		System.out.println(resultadoDB);
		return "/vehiculo/listarvehiculo"; // ruta fisica de la pagina
	}
}
