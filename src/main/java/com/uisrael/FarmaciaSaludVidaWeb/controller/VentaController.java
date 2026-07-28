package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VentaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VentaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IClienteService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IUsuarioService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVentaService;

@Controller
@RequestMapping("/venta") // url
public class VentaController {

	@Autowired
	private IVentaService servicioVenta;
	
	@Autowired
	private IClienteService servicioCliente;
	
	@Autowired
	private IUsuarioService servicioUsuario;
	
	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();

	// CONSTRUCTOR
	public VentaController(IVentaService servicioVenta, IClienteService servicioCliente,
			IUsuarioService servicioUsuario) {

		this.servicioVenta = servicioVenta;
		this.servicioCliente = servicioCliente;
		this.servicioUsuario = servicioUsuario;
	}

	
	@GetMapping
	public String leerPagina(Model model) {
		List<VentaResponseDto> resultadoDB = servicioVenta.listarVenta();
		List<VentaResponseDto> listaFiltrada = resultadoDB.stream()
	            .filter(c -> !eliminadosEnMemoria.contains(c.getIdVenta())) 
	            .collect(Collectors.toList());
		
		model.addAttribute("listaVenta", listaFiltrada);
		return "/venta/listarventa"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoVenta")
	public String crearVenta(Model model) {
		model.addAttribute("venta", new VentaRequestDto());
		model.addAttribute("listaCliente", servicioCliente.listarCliente());
		model.addAttribute("listaUsuario", servicioUsuario.listarUsuario());
		return "/venta/nuevoventa";
	}

	@PostMapping("/guardar")
	public String guardarVenta(@ModelAttribute VentaRequestDto venta) {
		servicioVenta.guardarVenta(venta);
		return "redirect:/venta";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idVenta}")
	public String editarVenta(@PathVariable int idVenta, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("venta", servicioVenta.buscarPorId(idVenta));
		// 4.- redireccione al formulario nuevo
		return "/venta/nuevoventa";
	}
	
	// ELIMINAR
	@GetMapping("/eliminar/{idVenta}")
	public String eliminarVenta(@PathVariable int idVenta) {
	    eliminadosEnMemoria.add(idVenta); 
	    return "redirect:/venta";
	}
}
