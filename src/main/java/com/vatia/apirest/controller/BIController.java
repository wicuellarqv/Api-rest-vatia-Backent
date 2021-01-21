package com.vatia.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.modelBI.Cliente;
import com.vatia.apirest.service.BIService;
import com.vatia.apirest.response.ResponseHTTP;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("v1/Bi")
public class BIController {

	@Autowired
	private BIService biService;

	@GetMapping("/getAllClientes")
	public ResponseEntity<ResponseHTTP> getAllClientes() {
		List<Cliente> clientes = new ArrayList<>();

		try {
			clientes = biService.getAllClientes();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return clientes.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), clientes), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), clientes), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/get_clientes_by_razon_social")
	public ResponseEntity<ResponseHTTP> getLikeClientes(@RequestBody Cliente cliente) {
		List<Object> clientes = new ArrayList<>();

		try {
			clientes = biService.getLikeClientesByRazonSocial(cliente.getNombreRazonSocial());
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return clientes.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), clientes), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), clientes), HttpStatus.NOT_FOUND);

	}
}
