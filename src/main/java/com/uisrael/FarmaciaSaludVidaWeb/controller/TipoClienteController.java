package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tipocliente") // url
public class TipoClienteController {

	@GetMapping
	public String leerPagina() {
		return "/cliente/listartipocliente"; // ruta fisica de la pagina
	}
}
