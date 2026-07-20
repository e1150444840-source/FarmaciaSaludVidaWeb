package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.DetalleVentaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.DetalleVentaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IDetalleVentaService;

@Controller
@RequestMapping("/detalleVenta") // url
public class DetalleVentaController {

	@Autowired
	private IDetalleVentaService servicioDetalleVenta;

	// CONSTRUCTOR
	public DetalleVentaController(IDetalleVentaService servicioDetalleVenta) {

		this.servicioDetalleVenta = servicioDetalleVenta;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<DetalleVentaResponseDto> resultadoDB = servicioDetalleVenta.listarDetalleVenta();
		model.addAttribute("listaDetalleVenta", resultadoDB);
		return "/venta/listardetalleventa"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoDetalleVenta")
	public String crearDetalleVenta(Model model) {
		model.addAttribute("detalleVenta", new DetalleVentaRequestDto());
		return "/venta/nuevodetalleventa";
	}

	@PostMapping("/guardar")
	public String guardarDetalleVenta(@ModelAttribute DetalleVentaRequestDto detalleVenta) {

		servicioDetalleVenta.guardarDetalleVenta(detalleVenta);
		return "redirect:/detalleVenta";
	}

}
