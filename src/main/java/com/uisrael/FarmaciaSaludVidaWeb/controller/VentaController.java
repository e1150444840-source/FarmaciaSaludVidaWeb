package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String leerPagina() {
		List<VentaResponseDto> resultadoDB = servicioVenta.listarVenta();
		System.out.println(resultadoDB);
		return "/venta/listarventa"; // ruta fisica de la pagina
	}
}
