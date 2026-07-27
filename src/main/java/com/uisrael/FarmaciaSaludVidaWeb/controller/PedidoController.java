package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.PedidoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.PedidoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IPedidoService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVehiculoService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVentaService;

@Controller
@RequestMapping("/pedido") // url
public class PedidoController {

	@Autowired
	private IPedidoService servicioPedido;
	
	@Autowired
	private IVehiculoService servicioVehiculo;
	
	@Autowired
	private IVentaService servicioVenta;

	// CONSTRUCTOR	
	public PedidoController(IPedidoService servicioPedido, IVehiculoService servicioVehiculo,
			IVentaService servicioVenta) {

		this.servicioPedido = servicioPedido;
		this.servicioVehiculo = servicioVehiculo;
		this.servicioVenta = servicioVenta;
	}

	// LISTAR CLIENTE
	@GetMapping
	public String leerPagina(Model model) {
		List<PedidoResponseDto> resultadoDB = servicioPedido.listarPedido();
		model.addAttribute("listaPedido", resultadoDB);
		return "/pedido/listarpedido"; // ruta fisica de la pagina
	}

	// CREAR NUEVO
	@GetMapping("/nuevoPedido")
	public String crearPedido(Model model) {
		model.addAttribute("pedido", new PedidoRequestDto());
		model.addAttribute("listaVehiculo", servicioVehiculo.listarVehiculo());
		model.addAttribute("listaVenta", servicioVenta.listarVenta());
		return "/pedido/nuevopedido";
	}

	// GUARDAR
	@PostMapping("/guardar")
	public String guardarPedido(@ModelAttribute PedidoRequestDto pedido) {
		servicioPedido.guardarPedido(pedido);
		return "redirect:/pedido";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idPedido}")
	public String editarPedido(@PathVariable int idPedido, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("pedido", servicioPedido.buscarPorId(idPedido));
		// 4.- redireccione al formulario nuevo
		return "/pedido/nuevopedido";
	}
}
