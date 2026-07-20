package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LaboratorioRequestDto;
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
	public String leerPagina(Model model) {
		List<LaboratorioResponseDto> resultadoDB = servicioLaboratorio.listarLaboratorio();
		model.addAttribute("listaLaboratorio", resultadoDB);
		return "/farmacia/listarlaboratorio"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoLaboratorio")
	public String crearLaboratorio(Model model) {
		model.addAttribute("laboratorio", new LaboratorioRequestDto());
		return "/farmacia/nuevolaboratorio";
	}

	@PostMapping("/guardar")
	public String guardarLaboratorio(@ModelAttribute LaboratorioRequestDto laboratorio) {
		servicioLaboratorio.guardarLaboratorio(laboratorio);
		return "redirect:/laboratorio";
	}

}
