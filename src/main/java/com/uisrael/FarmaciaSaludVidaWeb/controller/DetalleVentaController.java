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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.DetalleVentaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.DetalleVentaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IDetalleVentaService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IInventarioService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVentaService;

@Controller
@RequestMapping("/detalleVenta") // url
public class DetalleVentaController {

	@Autowired
	private IDetalleVentaService servicioDetalleVenta;
	
	@Autowired
	private IVentaService servicioVenta;
	
	@Autowired
	private IInventarioService servicioInventario;

	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();
	
	// CONSTRUCTOR
	public DetalleVentaController(IDetalleVentaService servicioDetalleVenta, IVentaService servicioVenta,
			IInventarioService servicioInventario) {

		this.servicioDetalleVenta = servicioDetalleVenta;
		this.servicioVenta = servicioVenta;
		this.servicioInventario = servicioInventario;
	}


	@GetMapping
	public String leerPagina(Model model) {
		List<DetalleVentaResponseDto> resultadoDB = servicioDetalleVenta.listarDetalleVenta();
		// Filtramos para ignorar los IDs que se marcaron como "eliminados"
	    List<DetalleVentaResponseDto> listaFiltrada = resultadoDB.stream()
	            .filter(c -> !eliminadosEnMemoria.contains(c.getIdDetalleVenta())) 
	            .collect(Collectors.toList());
	    
		model.addAttribute("listaDetalleVenta", listaFiltrada);
		return "/venta/listardetalleventa"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoDetalleVenta")
	public String crearDetalleVenta(Model model) {
		model.addAttribute("detalleVenta", new DetalleVentaRequestDto());
		model.addAttribute("listaVenta", servicioVenta.listarVenta());
		model.addAttribute("listaInventario", servicioInventario.listarInventario());
		return "/venta/nuevodetalleventa";
	}

	@PostMapping("/guardar")
	public String guardarDetalleVenta(@ModelAttribute DetalleVentaRequestDto detalleVenta) {

		servicioDetalleVenta.guardarDetalleVenta(detalleVenta);
		return "redirect:/detalleVenta";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idDetalleVenta}")
	public String editarDetalleVenta(@PathVariable int idDetalleVenta, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("detalleVenta", servicioDetalleVenta.buscarPorId(idDetalleVenta));
		// 4.- redireccione al formulario nuevo
		return "/venta/nuevodetalleventa";
	}
	
	// ELIMINAR
	@GetMapping("/eliminar/{idDetalleVenta}")
	public String eliminarDetalleVenta(@PathVariable int idDetalleVenta) {
	    eliminadosEnMemoria.add(idDetalleVenta); 
	    return "redirect:/detalleVenta";
	}

}
