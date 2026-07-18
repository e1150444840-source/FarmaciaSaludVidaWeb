package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.UsuarioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IUsuarioService;

@Controller
@RequestMapping("/usuario") // url
public class UsuarioController {

	@Autowired
	private IUsuarioService servicioUsuario;

	// CONSTRUCTOR
	public UsuarioController(IUsuarioService servicioUsuario) {

		this.servicioUsuario = servicioUsuario;
	}

	@GetMapping
	public String leerPagina() {
		List<UsuarioResponseDto> resultadoDB = servicioUsuario.listarUsuario();
		System.out.println(resultadoDB);
		return "/usuario/listarusuario"; // ruta fisica de la pagina
	}
}
