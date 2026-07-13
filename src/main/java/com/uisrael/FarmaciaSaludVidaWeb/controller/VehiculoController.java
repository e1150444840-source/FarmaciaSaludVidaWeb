package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiculo") // url
public class VehiculoController {

	@GetMapping
	public String leerPagina() {
		return "/vehiculo/listarvehiculo"; // ruta fisica de la pagina
	}
}
