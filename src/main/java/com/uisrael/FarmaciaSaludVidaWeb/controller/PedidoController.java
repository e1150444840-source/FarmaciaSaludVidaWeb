package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.PedidoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IPedidoService;

@Controller
@RequestMapping("/pedido") // url
public class PedidoController {

	@Autowired
	private IPedidoService servicioPedido;

	// CONSTRUCTOR
	public PedidoController(IPedidoService servicioPedido) {
		super();
		this.servicioPedido = servicioPedido;
	}

	@GetMapping
	public String leerPagina() {
		List<PedidoResponseDto> resultadoDB = servicioPedido.listarPedido();
		System.out.println(resultadoDB);
		return "/pedido/listarpedido"; // ruta fisica de la pagina
	}
}
