package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lote") // url
public class LoteController {

	@GetMapping
	public String leerPagina() {
		return "/inventario/listarlote"; // ruta fisica de la pagina
	}
}
