package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria") // url
public class CategoriaController {

	@GetMapping
	public String leerPagina() {
		return "/producto/listarcategoria"; // ruta fisica de la pagina
	}
}
