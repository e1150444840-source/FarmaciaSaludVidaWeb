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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.ClienteRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.ClienteResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IClienteService;
import com.uisrael.FarmaciaSaludVidaWeb.services.ITipoClienteService;

@Controller
@RequestMapping("/cliente") // url
public class ClienteController {

	@Autowired
	private IClienteService servicioCliente;

	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();

	@Autowired
	private ITipoClienteService servicioTipoCliente;

	// CONSTRUCTOR
	public ClienteController(IClienteService servicioCliente, ITipoClienteService servicioTipoCliente) {

		this.servicioCliente = servicioCliente;
		this.servicioTipoCliente = servicioTipoCliente;
	}

	// LISTAR CLIENTE
	@GetMapping
	public String leerPagina(Model model) {
		List<ClienteResponseDto> resultadoDB = servicioCliente.listarCliente();
		// Filtramos para ignorar los IDs que se marcaron como "eliminados"
		List<ClienteResponseDto> listaFiltrada = resultadoDB.stream()
				.filter(c -> !eliminadosEnMemoria.contains(c.getIdCliente())).collect(Collectors.toList());

		model.addAttribute("listaClientes", listaFiltrada);
		return "/cliente/listarcliente";
	}

	// CREAR NUEVO
	@GetMapping("/nuevoCliente")
	public String crearCliente(Model model) {
		model.addAttribute("cliente", new ClienteRequestDto());
		model.addAttribute("listaTipoCliente", servicioTipoCliente.listarTipoCliente());
		return "/cliente/nuevocliente";
	}

	// GUARDAR
	@PostMapping("/guardar")
	public String guardarCliente(@ModelAttribute("cliente") ClienteRequestDto cliente, BindingResult result,
			Model model) {

		// Validaciones para NUEVO CLIENTE (cuando idCliente es null o 0)
	    if (cliente.getIdCliente() == 0) {
	        
	        if (servicioCliente.existePorCedula(cliente.getCiCliente())) {
	            result.rejectValue("ciCliente", "error.cliente", "Esta cédula ya se encuentra registrada.");
	        }

	        if (servicioCliente.existePorCorreoElectronico(cliente.getCorreoCliente())) {
	            result.rejectValue("correoCliente", "error.cliente", "Este correo electrónico ya está registrado.");
	        }

	        if (servicioCliente.existePorTelefono(cliente.getTelefonoCliente())) {
	            result.rejectValue("telefonoCliente", "error.cliente", "Este número de teléfono ya está registrado.");
	        }
	    }

	    // Si hay errores de validación, recarga la vista
	    if (result.hasErrors()) {
	        model.addAttribute("listaTipoCliente", servicioTipoCliente.listarTipoCliente());
	        return "cliente/nuevocliente";
	    }

		servicioCliente.guardarCliente(cliente);
		return "redirect:/cliente";
	}

	// EDITAR
	@GetMapping("/editar/{idCliente}")
	public String editarCliente(@PathVariable int idCliente, Model model) {
		// 1 y 2. Buscar registro por ID y enviarlo al modelo
		model.addAttribute("cliente", servicioCliente.buscarPorId(idCliente));

		// 3. Enviar la lista con el mismo nombre que en 'nuevoCliente'
		// ("listaTipoCliente")
		model.addAttribute("listaTipoCliente", servicioTipoCliente.listarTipoCliente());

		// 4. Redireccionar al formulario
		return "/cliente/nuevocliente";
	}

	// ELIMINAR
	@GetMapping("/eliminar/{idCliente}")
	public String eliminarCliente(@PathVariable int idCliente) {
		eliminadosEnMemoria.add(idCliente);
		return "redirect:/cliente";
	}

}
