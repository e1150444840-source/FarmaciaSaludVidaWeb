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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.TipoClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.TipoClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ITipoClienteService;

@Controller
@RequestMapping("/tipoCliente") // url
public class TipoClienteController {

	@Autowired
	private ITipoClienteService servicioTipoCliente;

	// CONSTRUCTOR
	public TipoClienteController(ITipoClienteService servicioTipoCliente) {

		this.servicioTipoCliente = servicioTipoCliente;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<TipoClienteResponseDto> resultadoDB = servicioTipoCliente.listarTipoCliente();
		model.addAttribute("listaTipoCliente", resultadoDB);
		return "/cliente/listartipocliente"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoTipoCliente")
	public String crearCliente(Model model) {
		model.addAttribute("tipoCliente", new TipoClienteRequestDto());
		return "/cliente/nuevotipocliente";
	}

	@PostMapping("/guardar")
	public String guardarTipoCliente(@ModelAttribute TipoClienteRequestDto tipoCliente) {
		
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

}
