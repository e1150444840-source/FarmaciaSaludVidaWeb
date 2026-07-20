package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LoteRequestDto;
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
	public String leerPagina(Model model) {
		List<LoteResponseDto> resultadoDB = servicioLote.listarLote();
		model.addAttribute("listaLote", resultadoDB);
		return "/inventario/listarlote"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoLote")
	public String crearLote(Model model) {
		model.addAttribute("lote", new LoteRequestDto());
		return "/inventario/nuevolote";
	}

	@PostMapping("/guardar")
	public String guardarLote(@ModelAttribute LoteRequestDto lote) {
		servicioLote.guardarLote(lote);
		return "redirect:/lote";
	}

}
