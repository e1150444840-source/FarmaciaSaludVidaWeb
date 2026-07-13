package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventario") // url
public class InventarioController {

	@GetMapping
	public String leerPagina() {
		return "/inventario/listarinventario"; // ruta fisica de la pagina
	}

}
