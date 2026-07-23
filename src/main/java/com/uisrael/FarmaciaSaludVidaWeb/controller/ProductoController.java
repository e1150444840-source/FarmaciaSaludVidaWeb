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
import com.uisrael.FarmaciaSaludVidaWeb.services.IProductoService;

@Controller
@RequestMapping("/producto") // url
public class ProductoController {

	@Autowired
	private IProductoService servicioProducto;

	// CONSTRUCTOR
	public ProductoController(IProductoService servicioProducto) {

		this.servicioProducto = servicioProducto;
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
