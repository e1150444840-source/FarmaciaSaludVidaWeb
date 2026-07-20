package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.PedidoRequestDto;
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
	public String leerPagina(Model model) {
		List<PedidoResponseDto> resultadoDB = servicioPedido.listarPedido();
		model.addAttribute("listaPedido", resultadoDB);
		return "/pedido/listarpedido"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoPedido")
	public String crearPedido(Model model) {
		model.addAttribute("pedido", new PedidoRequestDto());
		return "/pedido/nuevopedido";
	}

	@PostMapping("/guardar")
	public String guardarPedido(@ModelAttribute PedidoRequestDto pedido) {
		servicioPedido.guardarPedido(pedido);
		return "redirect:/pedido";
	}
}
