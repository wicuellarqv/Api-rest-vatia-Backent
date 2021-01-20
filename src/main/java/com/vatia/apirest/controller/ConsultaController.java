package com.vatia.apirest.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vatia.apirest.service.ConsultaService;
import com.vatia.apirest.utils.ContratoDetailResponse;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("v1/consultas")
public class ConsultaController {
	@Autowired
	private ConsultaService consultaService;
	
	@PostMapping("/contratos")
	public Object  consultaContratos(@RequestBody JSONObject obj) {
		return  consultaService.contratos(obj);
	}
	
	@PostMapping("/detalle/contrato")
	public ContratoDetailResponse findAllById(@RequestBody JSONObject obj) {
		String idContrato = obj.get("idContrato").toString();
		return consultaService.findById(idContrato);
	}
}
