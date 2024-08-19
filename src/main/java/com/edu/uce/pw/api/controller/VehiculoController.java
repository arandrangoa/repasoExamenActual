package com.edu.uce.pw.api.controller;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.uce.pw.api.service.IVehiculoService;
import com.edu.uce.pw.api.service.to.VehiculoCompletoTO;
import com.edu.uce.pw.api.service.to.VehiculoTO;

@Controller
@CrossOrigin
@RequestMapping(path = "/vehiculos")
public class VehiculoController {
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoCompletoTO> guardar(@RequestBody VehiculoCompletoTO vehiculo){
		this.iVehiculoService.guardar(vehiculo);
		return ResponseEntity.status(HttpStatus.OK).body(this.iVehiculoService.buscarPorPlaca(vehiculo.getPlaca()));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> buscarTodos(){
		List<VehiculoTO> lista =this.iVehiculoService.buscarTodos();
		for(VehiculoTO v:lista) {
			Link link=linkTo(methodOn(VehiculoController.class)
					.buscarPorPlaca(v.getPlaca()))
					.withSelfRel();
			v.add(link);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoCompletoTO> buscarPorPlaca(@PathVariable String placa){
		VehiculoCompletoTO v= this.iVehiculoService.buscarPorPlaca(placa);
		return ResponseEntity.status(HttpStatus.OK).body(v);
	}
	
	@DeleteMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrar(@PathVariable String placa){
		this.iVehiculoService.eliminar(placa);
		return ResponseEntity.status(HttpStatus.OK).body("Borrado");
	}
	

}
