package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LoteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILoteService;

@Controller
@RequestMapping("/lote") // url
public class LoteController {

	@Autowired
	private ILoteService servicioLote;

	// CONSTRUCTOR
	public LoteController(ILoteService servicioLote) {

		this.servicioLote = servicioLote;
	}

	@GetMapping
	public String leerPagina() {
		List<LoteResponseDto> resultadoDB = servicioLote.listarLote();
		System.out.println(resultadoDB);
		return "/inventario/listarlote"; // ruta fisica de la pagina
	}

}
