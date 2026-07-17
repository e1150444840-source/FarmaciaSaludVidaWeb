package com.uisrael.FarmaciaSaludVidaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.TipoClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.ITipoClienteService;

@Controller
@RequestMapping("/tipoCliente") // url
public class TipoClienteController {

	@Autowired
	private ITipoClienteService servicioTipoCliente;
	
	@GetMapping
	public String leerPagina() {
		List<TipoClienteResponseDto> resultadoDB = servicioTipoCliente.listarTipoCliente();
		System.out.println(resultadoDB);
		return "/cliente/listartipocliente"; // ruta fisica de la pagina
	}
}
