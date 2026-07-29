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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.LoteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.LoteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILoteService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IProductoService;

@Controller
@RequestMapping("/lote") // url
public class LoteController {

	@Autowired
	private ILoteService servicioLote;
	
	@Autowired
	private IProductoService servicioProducto;
	

	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();

	// CONSTRUCTOR
	public LoteController(ILoteService servicioLote, IProductoService servicioProducto) {
		
		this.servicioLote = servicioLote;
		this.servicioProducto = servicioProducto;
	}


	// LISTAR CLIENTE
	@GetMapping
	public String leerPagina(Model model) {
		List<LoteResponseDto> resultadoDB = servicioLote.listarLote();
		List<LoteResponseDto> listaFiltrada = resultadoDB.stream()
	            .filter(c -> !eliminadosEnMemoria.contains(c.getIdLote())) 
	            .collect(Collectors.toList());
		
		model.addAttribute("listaLote", listaFiltrada);
		return "/inventario/listarlote"; // ruta fisica de la pagina
	}

	// CREAR NUEVO
	@GetMapping("/nuevoLote")
	public String crearLote(Model model) {
		model.addAttribute("lote", new LoteRequestDto());
		model.addAttribute("listaProducto", servicioProducto.listarProducto());
		return "/inventario/nuevolote";
	}

	// GUARDAR
	@PostMapping("/guardar")
	public String guardarLote(@ModelAttribute LoteRequestDto lote) {
		servicioLote.guardarLote(lote);
		return "redirect:/lote";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idLote}")
	public String editarLote(@PathVariable int idLote, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("lote", servicioLote.buscarPorId(idLote));
		model.addAttribute("listaProducto", servicioProducto.listarProducto());
		// 4.- redireccione al formulario nuevo
		return "/inventario/nuevolote";
	}
	
	// ELIMINAR
	@GetMapping("/eliminar/{idLote}")
	public String eliminarLote(@PathVariable int idLote) {
	    eliminadosEnMemoria.add(idLote); 
	    return "redirect:/lote";
	}
}
