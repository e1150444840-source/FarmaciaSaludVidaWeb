package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.FarmaciaRequestDto;
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
	public String leerPagina(Model model) {
		List<FarmaciaResponseDto> resultadoDB = servicioFarmacia.listarFarmacia();
		model.addAttribute("listaFarmacia", resultadoDB);
		return "/farmacia/listarfarmacia"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoFarmacia")
	public String crearFarmacia(Model model) {
		model.addAttribute("farmacia", new FarmaciaRequestDto());
		return "/farmacia/nuevofarmacia";
	}

	@PostMapping("/guardar")
	public String guardarFarmacia(@ModelAttribute FarmaciaRequestDto farmacia) {

		servicioFarmacia.guardarFarmacia(farmacia);
		return "redirect:/farmacia";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idFarmacia}")
	public String editarFarmacia(@PathVariable int idFarmacia, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("farmacia", servicioFarmacia.buscarPorId(idFarmacia));
		// 4.- redireccione al formulario nuevo
		return "/farmacia/nuevofarmacia";
	}


}
