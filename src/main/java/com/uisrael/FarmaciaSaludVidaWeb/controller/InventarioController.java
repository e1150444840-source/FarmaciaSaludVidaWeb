package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.uisrael.FarmaciaSaludVidaWeb.services.IFarmaciaService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IInventarioService;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILoteService;

@Controller
@RequestMapping("/inventario") // url
public class InventarioController {

	@Autowired
	private IInventarioService servicioInventario;

	@Autowired
	private IFarmaciaService servicioFarmacia;
	
	@Autowired
	private ILoteService servicioLote;
	
	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();
	
	// CONSTRUCTOR
	public InventarioController(IInventarioService servicioInventario, IFarmaciaService servicioFarmacia,
			ILoteService servicioLote) {

		this.servicioInventario = servicioInventario;
		this.servicioFarmacia = servicioFarmacia;
		this.servicioLote = servicioLote;
	}

	// LISTAR CLIENTE
	@GetMapping
	public String leerPagina(Model model) {
		List<InventarioResponseDto> resultadoDB = servicioInventario.listarInventario();
		List<InventarioResponseDto> listaFiltrada = resultadoDB.stream()
	            .filter(c -> !eliminadosEnMemoria.contains(c.getIdInventario())) 
	            .collect(Collectors.toList());
		
		model.addAttribute("listaInventario", listaFiltrada);
		return "/inventario/listarinventario"; // ruta fisica de la pagina
	}

	// CREAR NUEVO
	@GetMapping("/nuevoInventario")
	public String crearInventario(Model model) {
		model.addAttribute("inventario", new InventarioRequestDto());
		model.addAttribute("listaFarmacia", servicioFarmacia.listarFarmacia());
		model.addAttribute("listaLote", servicioLote.listarLote());
		return "/inventario/nuevoinventario";
	}

	// GUARDAR
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
		model.addAttribute("listaFarmacia", servicioFarmacia.listarFarmacia());
		model.addAttribute("listaLote", servicioLote.listarLote());
		
		// 4.- redireccione al formulario nuevo
		return "/inventario/nuevoInventario";
	}

	// ELIMINAR
	@GetMapping("/eliminar/{idInventario}")
	public String eliminarInventario(@PathVariable int idInventario) {
	    eliminadosEnMemoria.add(idInventario); 
	    return "redirect:/inventario";
	}
}
