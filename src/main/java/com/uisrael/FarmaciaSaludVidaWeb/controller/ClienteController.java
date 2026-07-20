package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IClienteService;

@Controller
@RequestMapping("/cliente") // url
public class ClienteController {

	@Autowired
	private IClienteService servicioCliente;

	// CONSTRUCTOR
	public ClienteController(IClienteService servicioCliente) {

		this.servicioCliente = servicioCliente;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<ClienteResponseDto> resultadoDB = servicioCliente.listarCliente();
		model.addAttribute("listaClientes", resultadoDB);
		return "/cliente/listarcliente"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoCliente")
	public String crearCliente(Model model) {
		model.addAttribute("cliente", new ClienteRequestDto());
		return "/cliente/nuevocliente";
	}

	@PostMapping("/guardar")
	public String guardarCliente(@ModelAttribute ClienteRequestDto cliente) {

		servicioCliente.guardarCliente(cliente);
		return "redirect:/listarcliente";
	}
}
