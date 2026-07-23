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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.CategoriaRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.CategoriaResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ICategoriaService;

@Controller
@RequestMapping("/categoria") // url
public class CategoriaController {

	@Autowired
	private ICategoriaService servicioCategoria;

	// CONSTRUCTOR
	public CategoriaController(ICategoriaService servicioCategoria) {

		this.servicioCategoria = servicioCategoria;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<CategoriaResponseDto> resultadoDB = servicioCategoria.listarCategoria();
		model.addAttribute("listaCategoria", resultadoDB);
		return "/producto/listarcategoria"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoCategoria")
	public String crearCategoria(Model model) {
		model.addAttribute("categoria", new CategoriaRequestDto());
		return "/producto/nuevocategoria";
	}

	@PostMapping("/guardar")
	public String guardarCategoria(@ModelAttribute CategoriaRequestDto categoria) {

		servicioCategoria.guardarCategoria(categoria);
		return "redirect:/categoria";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idCategoria}")
	public String editarCategoria(@PathVariable int idCategoria, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("categoria", servicioCategoria.buscarPorId(idCategoria));
		// 4.- redireccione al formulario nuevo
		return "/producto/nuevocategoria";
	}
}
