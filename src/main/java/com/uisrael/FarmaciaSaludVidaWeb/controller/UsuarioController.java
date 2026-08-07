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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.UsuarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.UsuarioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IUsuarioService;

@Controller
@RequestMapping("/usuario") // url
public class UsuarioController {

	@Autowired
	private IUsuarioService servicioUsuario;

	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();

	// CONSTRUCTOR
	public UsuarioController(IUsuarioService servicioUsuario) {

		this.servicioUsuario = servicioUsuario;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<UsuarioResponseDto> resultadoDB = servicioUsuario.listarUsuario();
		List<UsuarioResponseDto> listaFiltrada = resultadoDB.stream()
				.filter(c -> !eliminadosEnMemoria.contains(c.getIdUsuario())).collect(Collectors.toList());

		model.addAttribute("listaUsuario", listaFiltrada);
		return "/usuario/listarusuario"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoUsuario")
	public String crearUsuario(Model model) {
		model.addAttribute("usuario", new UsuarioRequestDto());
		return "/usuario/nuevousuario";
	}

	// GUARDAR
	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute("usuario") UsuarioRequestDto usuario, BindingResult result,
			Model model) {

		if (usuario.getIdUsuario() == 0) {

			if (servicioUsuario.existePorUserName(usuario.getUsername())) {
				result.rejectValue("username", "error.usuario", "Este nombre de usuario ya se encuentra registrado.");
			}
			if (servicioUsuario.existePorPassword(usuario.getPassword())) {
				result.rejectValue("password", "error.password", "Este password ya se encuentra registrado.");
			}
		}

		if (result.hasErrors()) {
			return "usuario/nuevousuario"; 
		}

		servicioUsuario.guardarUsuario(usuario);
		return "redirect:/usuario";
	}

	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idUsuario}")
	public String editarUsuario(@PathVariable int idUsuario, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("usuario", servicioUsuario.buscarPorId(idUsuario));
		// 4.- redireccione al formulario nuevo
		return "/usuario/nuevousuario";
	}

	// ELIMINAR
	@GetMapping("/eliminar/{idUsuario}")
	public String eliminarUsuario(@PathVariable int idUsuario) {
		eliminadosEnMemoria.add(idUsuario);
		return "redirect:/usuario";
	}
}
