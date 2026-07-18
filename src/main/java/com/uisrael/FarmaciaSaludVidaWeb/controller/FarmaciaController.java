package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.FarmaciaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IFarmaciaService;

@Controller
@RequestMapping("/farmacia") // url
public class FarmaciaController {

	@Autowired
	private IFarmaciaService servicioFarmacia;

	// CONSTRUCTOR
	public FarmaciaController(IFarmaciaService servicioFarmacia) {

		this.servicioFarmacia = servicioFarmacia;
	}

	@GetMapping
	public String leerPagina() {
		List<FarmaciaResponseDto> resultadoDB = servicioFarmacia.listarFarmacia();
		System.out.println(resultadoDB);
		return "/farmacia/listarfarmacia"; // ruta fisica de la pagina
	}

}
