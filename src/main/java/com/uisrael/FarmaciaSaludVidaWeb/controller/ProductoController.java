package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto") // url
public class ProductoController {

	@GetMapping
	public String leerPagina() {
		return "/producto/listarproducto"; // ruta fisica de la pagina
	}
}
