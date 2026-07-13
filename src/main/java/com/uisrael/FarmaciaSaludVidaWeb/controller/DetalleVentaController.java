package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detalleventa") // url
public class DetalleVentaController {

	@GetMapping
	public String leerPagina() {
		return "/venta/listardetalleventa"; // ruta fisica de la pagina
	}

}
