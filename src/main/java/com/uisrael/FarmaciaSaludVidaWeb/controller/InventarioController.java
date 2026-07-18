package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.InventarioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IInventarioService;

@Controller
@RequestMapping("/inventario") // url
public class InventarioController {

	@Autowired
	private IInventarioService servicioInventario;

	// CONSTRUCTOR
	public InventarioController(IInventarioService servicioInventario) {

		this.servicioInventario = servicioInventario;
	}

	@GetMapping
	public String leerPagina() {
		List<InventarioResponseDto> resultadoDB = servicioInventario.listarInventario();
		System.out.println(resultadoDB);
		return "/inventario/listarinventario"; // ruta fisica de la pagina
	}

}
