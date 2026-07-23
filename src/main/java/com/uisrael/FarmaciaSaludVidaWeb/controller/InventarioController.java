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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.InventarioRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.InventarioResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IInventarioService;

@Controller
@RequestMapping("/inventario") // url
public class InventarioController {

	@Autowired
	private IInventarioService servicioInventario;

	// CONSTRUCTOR
	public InventarioController(IInventarioService servicioInventario) {

		this.servicioInventario = servicioInventario;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<InventarioResponseDto> resultadoDB = servicioInventario.listarInventario();
		model.addAttribute("listaInventario", resultadoDB);
		return "/inventario/listarinventario"; // ruta fisica de la pagina
	}
	
	@GetMapping("/nuevoInventario")
	public String crearInventario(Model model) {
		model.addAttribute("inventario", new InventarioRequestDto());
		return "/inventario/nuevoinventario";
	}

	@PostMapping("/guardar")
	public String guardarInventario(@ModelAttribute InventarioRequestDto inventario) {
		servicioInventario.guardarInventario(inventario);
		return "redirect:/inventario";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idInventario}")
	public String editarInventario(@PathVariable int idInventario, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("inventario", servicioInventario.buscarPorId(idInventario));
		// 4.- redireccione al formulario nuevo
		return "/inventario/nuevoInventario";
	}

}
