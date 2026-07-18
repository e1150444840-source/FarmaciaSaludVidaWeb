package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ProductoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IProductoService;

@Controller
@RequestMapping("/producto") // url
public class ProductoController {

	@Autowired
	private IProductoService servicioProducto;

	// CONSTRUCTOR
	public ProductoController(IProductoService servicioProducto) {

		this.servicioProducto = servicioProducto;
	}

	@GetMapping
	public String leerPagina() {
		List<ProductoResponseDto> resultadoDB = servicioProducto.listarProducto();
		System.out.println(resultadoDB);
		return "/producto/listarproducto"; // ruta fisica de la pagina
	}
}
