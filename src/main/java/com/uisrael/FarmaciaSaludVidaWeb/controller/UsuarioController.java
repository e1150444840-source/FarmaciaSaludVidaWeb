package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario") // url
public class UsuarioController {

	@GetMapping
	public String leerPagina() {
		return "/usuario/listarusuario"; // ruta fisica de la pagina
	}
}
