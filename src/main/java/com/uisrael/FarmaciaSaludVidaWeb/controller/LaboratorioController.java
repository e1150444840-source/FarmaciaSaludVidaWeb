package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/laboratorio") // url
public class LaboratorioController {


	@GetMapping
	public String leerPagina() {
		return "/farmacia/listarlaboratorio"; // ruta fisica de la pagina
	}
}
