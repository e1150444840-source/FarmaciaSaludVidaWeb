package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LaboratorioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILaboratorioService;

@Controller
@RequestMapping("/laboratorio") // url
public class LaboratorioController {

	@Autowired
	private ILaboratorioService servicioLaboratorio;

	// CONSTRUCTOR
	public LaboratorioController(ILaboratorioService servicioLaboratorio) {

		this.servicioLaboratorio = servicioLaboratorio;
	}

	@GetMapping
	public String leerPagina() {
		List<LaboratorioResponseDto> resultadoDB = servicioLaboratorio.listarLaboratorio();
		System.out.println(resultadoDB);
		return "/farmacia/listarlaboratorio"; // ruta fisica de la pagina
	}

}
