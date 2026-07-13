package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venta") // url
public class VentaController {

	@GetMapping
	public String leerPagina() {
		return "/venta/listarventa"; // ruta fisica de la pagina
	}
}
