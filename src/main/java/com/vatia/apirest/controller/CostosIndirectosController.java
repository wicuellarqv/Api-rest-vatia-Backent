package com.vatia.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.model.Costos_indirectos;
import com.vatia.apirest.service.CostosIndirectosService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/CostosIndirectos")
public class CostosIndirectosController {
	@Autowired
	private CostosIndirectosService CostosIndirectosService;

	@GetMapping("/getAllPeriodo")
	public List<Costos_indirectos> getAllPeriodo(@RequestParam String mes,@RequestParam String ano) {
		
			return this.CostosIndirectosService.getAllPeriodo(mes, ano);

	}
	
}
