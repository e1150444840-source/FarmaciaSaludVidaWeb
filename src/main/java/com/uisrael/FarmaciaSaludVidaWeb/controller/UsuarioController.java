package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.UsuarioRequestDto;
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
	public String leerPagina(Model model) {
		List<UsuarioResponseDto> resultadoDB = servicioUsuario.listarUsuario();
		model.addAttribute("listaUsuario", resultadoDB);
		return "/usuario/listarusuario"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoUsuario")
	public String crearUsuario(Model model) {
		model.addAttribute("usuario", new UsuarioRequestDto());
		return "/usuario/nuevousuario";
	}

	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute UsuarioRequestDto usuario) {
		servicioUsuario.guardarUsuario(usuario);
		return "redirect:/usuario";
	}
}
