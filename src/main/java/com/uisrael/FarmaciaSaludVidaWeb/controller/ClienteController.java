package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IClienteService;

@Controller
@RequestMapping("/cliente") // url
public class ClienteController {

	@Autowired
	private IClienteService servicioCliente;
	
	@GetMapping
	public String leerPagina() {
		List<ClienteResponseDto> resultadoDB = servicioCliente.listarCliente();
		System.out.println(resultadoDB);
		return "/cliente/listarcliente"; // ruta fisica de la pagina
	}
}
