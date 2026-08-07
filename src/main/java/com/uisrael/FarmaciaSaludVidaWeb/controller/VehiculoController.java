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

import com.uisrael.FarmaciaSaludVidaWeb.model.dto.request.VehiculoRequestDto;
import com.uisrael.FarmaciaSaludVidaWeb.model.dto.response.VehiculoResponseDto;
import com.uisrael.FarmaciaSaludVidaWeb.services.IVehiculoService;

@Controller
@RequestMapping("/vehiculo") // url
public class VehiculoController {

	@Autowired
	private IVehiculoService servicioVehiculo;

	private final List<Integer> eliminadosEnMemoria = new ArrayList<>();

	// CONSTRUCTOR
	public VehiculoController(IVehiculoService servicioVehiculo) {

		this.servicioVehiculo = servicioVehiculo;
	}

	@GetMapping
	public String leerPagina(Model model) {
		List<VehiculoResponseDto> resultadoDB = servicioVehiculo.listarVehiculo();
		List<VehiculoResponseDto> listaFiltrada = resultadoDB.stream()
				.filter(c -> !eliminadosEnMemoria.contains(c.getIdVehiculo())).collect(Collectors.toList());

		model.addAttribute("listaVehiculo", listaFiltrada);
		return "/vehiculo/listarvehiculo"; // ruta fisica de la pagina
	}

	@GetMapping("/nuevoVehiculo")
	public String crearVehiculo(Model model) {
		model.addAttribute("vehiculo", new VehiculoRequestDto());
		return "/vehiculo/nuevovehiculo";
	}

	// GUARDAR
	@PostMapping("/guardar")
	public String guardarVehiculo(@ModelAttribute("vehiculo") VehiculoRequestDto vehiculo, BindingResult result,
			Model model) {

		if (vehiculo.getIdVehiculo() == 0) {

			if (servicioVehiculo.existePorPlaca(vehiculo.getPlaca())) {
				result.rejectValue("placa", "error.placa", "Esta placa ya se encuentra registrada.");
			}
		}

		if (result.hasErrors()) {
			return "vehiculo/nuevovehiculo"; 
		}

		servicioVehiculo.guardarVehiculo(vehiculo);
		return "redirect:/vehiculo";
	}

	// EDITAR
	// 1.- recuperar el registro utilizando el id
	@GetMapping("editar/{idVehiculo}")
	public String editarVehiculo(@PathVariable int idVehiculo, Model model) {
		// 2.- buscar registro por id
		// 3.- envio al html el objeto en la BD
		model.addAttribute("vehiculo", servicioVehiculo.buscarPorId(idVehiculo));
		// 4.- redireccione al formulario nuevo
		return "/vehiculo/nuevovehiculo";
	}

	// ELIMINAR
	@GetMapping("/eliminar/{idVehiculo}")
	public String eliminarVehiculo(@PathVariable int idVehiculo) {
		eliminadosEnMemoria.add(idVehiculo);
		return "redirect:/vehiculo";
	}
}
