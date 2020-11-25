package com.vatia.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vatia.apirest.model.VarIpc;
import com.vatia.apirest.model.VarIpp;
import com.vatia.apirest.service.VarIpcService;
import com.vatia.apirest.service.VarIppService;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/varipp")
public class VarIppController {

	@Autowired
	private VarIppService varIppService;
	
	@PostMapping("/guardar")
	public void save(@RequestBody VarIpp varIpp) {
		this.varIppService.save(varIpp);
	}
	
	@GetMapping("/getAll")
	public List<VarIpp> getAll() {
		return varIppService.findAll();
	}
	
	@GetMapping("/getAllAnio")
	public List<VarIpp> getAllAnio(@RequestParam Integer desde,@RequestParam Integer hasta) {
		return this.varIppService.findAllAnio(desde, hasta);
	}
	
	@GetMapping("/getAnio")
	public VarIpp getAnio(@RequestParam Integer anio) {
		return varIppService.findAnio(anio);
	}
	
	@GetMapping("/calcular")
	public JSONObject calcularVariacionIppAnio(@RequestParam Integer anio) {
		return varIppService.calcularVarIppAnio(anio);
	}
}
