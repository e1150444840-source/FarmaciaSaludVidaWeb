package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farmacia") // url
public class FarmaciaController {

	@GetMapping
	public String leerPagina() {
		return "/farmacia/listarfarmacia"; // ruta fisica de la pagina
	}
}
