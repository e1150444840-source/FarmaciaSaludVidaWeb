package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VehiculoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VehiculoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVehiculoService;

@Controller
@RequestMapping("/vehiculo") // url
public class VehiculoController {

	@Autowired
	private IVehiculoService servicioVehiculo;

	// CONSTRUCTOR
	public VehiculoController(IVehiculoService servicioVehiculo) {

		this.servicioVehiculo = servicioVehiculo;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<VehiculoResponseDto> resultadoDB = servicioVehiculo.listarVehiculo();
		model.addAttribute("listaVehiculo", resultadoDB);
		return "/vehiculo/listarvehiculo"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoVehiculo")
	public String crearVehiculo(Model model) {
		model.addAttribute("vehiculo", new VehiculoRequestDto());
		return "/vehiculo/nuevovehiculo";
	}

	@PostMapping("/guardar")
	public String guardarVehiculo(@ModelAttribute VehiculoRequestDto vehiculo) {
		servicioVehiculo.guardarVehiculo(vehiculo);
		return "redirect:/vehiculo";
	}
}
