package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();

	// CONSTRUCTOR
	public LaboratorioController(ILaboratorioService servicioLaboratorio) {

		this.servicioLaboratorio = servicioLaboratorio;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<LaboratorioResponseDto> resultadoDB = servicioLaboratorio.listarLaboratorio();
		List<LaboratorioResponseDto> listaFiltrada = resultadoDB.stream()
				.filter(c -> !eliminadosEnMemoria.contains(c.getIdLaboratorio())).collect(Collectors.toList());

		model.addAttribute("listaLaboratorio", listaFiltrada);
		return "/farmacia/listarlaboratorio"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoLaboratorio")
	public String crearLaboratorio(Model model) {
		model.addAttribute("laboratorio", new LaboratorioRequestDto());
		return "/farmacia/nuevolaboratorio";
	}

	// GUARDAR
	@PostMapping("/guardar")
	public String guardarLaboratorio(@ModelAttribute("laboratorio") LaboratorioRequestDto laboratorio,
			BindingResult result, Model model) {

		if (laboratorio.getIdLaboratorio() == 0) {

			if (servicioLaboratorio.existePorNombreLaboratorio(laboratorio.getNombreLaboratorio())) {
				result.rejectValue("nombreLaboratorio", "error.laboratorio",
						"Este laboratorio ya se encuentra registrado.");
			}
			
			if (servicioLaboratorio.existePorTelefonoLaboratorio(laboratorio.getTelefonoLaboratorio())) {
				result.rejectValue("telefonoLaboratorio", "error.laboratorio",
						"Este telefono ya se encuentra registrado.");
			}
		}

		if (result.hasErrors()) {
			return "laboratorio/nuevolaboratorio"; 
		}

		servicioLaboratorio.guardarLaboratorio(laboratorio);
		return "redirect:/laboratorio";
	}

	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idLaboratorio}")
	public String editarLaboratorio(@PathVariable int idLaboratorio, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("laboratorio", servicioLaboratorio.buscarPorId(idLaboratorio));
		// 4.- redireccione al formulario nuevo
		return "/farmacia/nuevolaboratorio";
	}

	// ELIMINAR
	@GetMapping("/eliminar/{idLaboratorio}")
	public String eliminarLaboratorio(@PathVariable int idLaboratorio) {
		eliminadosEnMemoria.add(idLaboratorio);
		return "redirect:/laboratorio";
	}
}
