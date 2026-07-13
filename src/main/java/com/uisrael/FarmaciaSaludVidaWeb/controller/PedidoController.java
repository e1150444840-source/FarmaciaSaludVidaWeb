package com.uisrael.FarmaciaSaludVidaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido") // url
public class PedidoController {

	@GetMapping
	public String leerPagina() {
		return "/pedido/listarpedido"; // ruta fisica de la pagina
	}
}
