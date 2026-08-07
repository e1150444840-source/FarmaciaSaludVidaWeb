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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.TipoClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.TipoClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ITipoClienteService;

@Controller
@RequestMapping("/tipoCliente") // url
public class TipoClienteController {

	@Autowired
	private ITipoClienteService servicioTipoCliente;

	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();

	// CONSTRUCTOR
	public TipoClienteController(ITipoClienteService servicioTipoCliente) {

		this.servicioTipoCliente = servicioTipoCliente;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<TipoClienteResponseDto> resultadoDB = servicioTipoCliente.listarTipoCliente();
		List<TipoClienteResponseDto> listaFiltrada = resultadoDB.stream()
				.filter(c -> !eliminadosEnMemoria.contains(c.getIdTipoCliente())).collect(Collectors.toList());

		model.addAttribute("listaTipoCliente", listaFiltrada);
		return "/cliente/listartipocliente"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoTipoCliente")
	public String crearCliente(Model model) {
		model.addAttribute("tipoCliente", new TipoClienteRequestDto());
		return "/cliente/nuevotipocliente";
	}

	// GUARDAR
	@PostMapping("/guardar")
	public String guardarTipoCliente(@ModelAttribute("tipoCliente") TipoClienteRequestDto tipoCliente,
			BindingResult result, Model model) {

		if (tipoCliente.getIdTipoCliente() == 0) {

			if (servicioTipoCliente.existePorNombreTipoCliente(tipoCliente.getNombreTipoCliente())) {
				result.rejectValue("nombreTipoCliente", "error.tipoCliente",
						"Este tipo de cliente ya se encuentra registrado.");
			}
		}

		if (result.hasErrors()) {
			return "cliente/nuevotipocliente";
		}

		servicioTipoCliente.guardarTipoCliente(tipoCliente);
		return "redirect:/tipoCliente";
	}

	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idTipoCliente}")
	public String editarTipoCliente(@PathVariable int idTipoCliente, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("tipoCliente", servicioTipoCliente.buscarPorId(idTipoCliente));
		// 4.- redireccione al formulario nuevo
		return "/cliente/nuevotipocliente";
	}

	// ELIMINAR
	@GetMapping("/eliminar/{idTipoCliente}")
	public String eliminarTipoCliente(@PathVariable int idTipoCliente) {
		eliminadosEnMemoria.add(idTipoCliente);
		return "redirect:/tipoCliente";
	}
}
