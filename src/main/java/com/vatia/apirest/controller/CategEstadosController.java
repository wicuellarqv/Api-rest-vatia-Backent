package com.vatia.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.model.EstadosCliente;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.EstadosCliService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("v1/categorizacion_estados")
public class CategEstadosController {

	@Autowired
	private EstadosCliService EstadosCliService;
	
	@GetMapping("/estados_cli")
	public ResponseEntity<ResponseHTTP> getAllEstadosCli() {
		List<EstadosCliente> estados = new ArrayList<>();

		try {
			estados = EstadosCliService.getAllEstadosCli();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return estados.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), estados), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), estados), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/estados_cli")
	public ResponseEntity<ResponseHTTP> createEstadoCli(@RequestBody EstadosCliente estadosCliente) {
		EstadosCliente ResponseEstadoCli = new EstadosCliente();

		try {
			ResponseEstadoCli = EstadosCliService.createEstado(estadosCliente);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEstadoCli.getId() == 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la creacion del estado cliente"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), ResponseEstadoCli), HttpStatus.OK);

	}
	
	@DeleteMapping("/estados_cli")
	public ResponseEntity<ResponseHTTP> deleteEstadoCli(@RequestBody EstadosCliente estadosCliente) {
		Boolean status = true;
		try {
			status = EstadosCliService.deleteEstado(estadosCliente);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return !status
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la eliminacion del estado cliente"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
	}
	
	@PutMapping("/estados_cli")
	public ResponseEntity<ResponseHTTP> updateEstadoCliente(@RequestBody EstadosCliente estadosCliente) {
			Boolean status = true;
		try {
			status = EstadosCliService.updateEstado(estadosCliente);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return !status
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la actualizacion del estado cliente"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
	}
}
