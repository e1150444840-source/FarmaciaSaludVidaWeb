package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String leerPagina() {
		List<DetalleVentaResponseDto> resultadoDB = servicioDetalleVenta.listarDetalleVenta();
		System.out.println(resultadoDB);
		return "/venta/listardetalleventa"; // ruta fisica de la pagina
	}

}
