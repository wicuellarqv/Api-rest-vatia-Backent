package com.vatia.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vatia.apirest.model.Fuente;
import com.vatia.apirest.service.FuenteService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/fuente")
public class FuenteController {

	@Autowired
	private FuenteService fuenteService;
	
	@GetMapping("/getAll")
	public List<Fuente> getAll() {
		return fuenteService.findAll();
	}
}
