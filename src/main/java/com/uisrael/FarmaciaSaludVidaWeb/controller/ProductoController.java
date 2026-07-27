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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ProductoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ProductoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ICategoriaService;
import com.uisrael.FarmaciaSaludVidaWeb.services.ILaboratorioService;
import com.uisrael.FarmaciaSaludVidaWeb.services.IProductoService;

@Controller
@RequestMapping("/producto") // url
public class ProductoController {

	@Autowired
	private IProductoService servicioProducto;

	@Autowired
	private ICategoriaService servicioCategoria;
	
	@Autowired
	private ILaboratorioService servicioLaboratorio;
	
	// CONSTRUCTOR
	public ProductoController(IProductoService servicioProducto, ICategoriaService servicioCategoria,
			ILaboratorioService servicioLaboratorio) {

		this.servicioProducto = servicioProducto;
		this.servicioCategoria = servicioCategoria;
		this.servicioLaboratorio = servicioLaboratorio;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<ProductoResponseDto> resultadoDB = servicioProducto.listarProducto();
		model.addAttribute("listaProducto", resultadoDB);
		return "/producto/listarproducto"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoProducto")
	public String crearProducto(Model model) {
		model.addAttribute("producto", new ProductoRequestDto());
		model.addAttribute("listaCategoria", servicioCategoria.listarCategoria());
		model.addAttribute("listaLaboratorio", servicioLaboratorio.listarLaboratorio());
		return "/producto/nuevoproducto";
	}

	@PostMapping("/guardar")
	public String guardarPedido(@ModelAttribute ProductoRequestDto producto) {
		servicioProducto.guardarProducto(producto);
		return "redirect:/producto";
	}
	
	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idProducto}")
	public String editarProducto(@PathVariable int idProducto, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("producto", servicioProducto.buscarPorId(idProducto));
		// 4.- redireccione al formulario nuevo
		return "/producto/nuevoproducto";
	}
}
