package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VentaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VentaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVentaService;

@Controller
@RequestMapping("/venta") // url
public class VentaController {

	@Autowired
	private IVentaService servicioVenta;

	// CONSTRUCTOR
	public VentaController(IVentaService servicioVenta) {

		this.servicioVenta = servicioVenta;
	}
	
	@GetMapping
	public String leerPagina(Model model) {
		List<VentaResponseDto> resultadoDB = servicioVenta.listarVenta();
		model.addAttribute("listaVenta", resultadoDB);
		return "/venta/listarventa"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoVenta")
	public String crearVenta(Model model) {
		model.addAttribute("venta", new VentaRequestDto());
		return "/venta/nuevoventa";
	}

	@PostMapping("/guardar")
	public String guardarVenta(@ModelAttribute VentaRequestDto venta) {
		servicioVenta.guardarVenta(venta);
		return "redirect:/venta";
	}
}
