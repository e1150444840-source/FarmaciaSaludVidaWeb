package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.CategoriaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ICategoriaService;

@Controller
@RequestMapping("/categoria") // url
public class CategoriaController {

	@Autowired
	private ICategoriaService servicioCategoria;

	// CONSTRUCTOR
	public CategoriaController(ICategoriaService servicioCategoria) {

		this.servicioCategoria = servicioCategoria;
	}

	@GetMapping
	public String leerPagina() {
		List<CategoriaResponseDto> resultadoDB = servicioCategoria.listarCategoria();
		System.out.println(resultadoDB);
		return "/producto/listarcategoria"; // ruta fisica de la pagina
	}

}
