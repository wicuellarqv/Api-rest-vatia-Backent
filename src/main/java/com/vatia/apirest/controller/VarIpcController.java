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
import com.vatia.apirest.service.VarIpcService;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/varipc")
public class VarIpcController {

	@Autowired
	private VarIpcService varIpcService;
	
	@PostMapping("/guardar")
	public void save(@RequestBody VarIpc varIpc) {
		this.varIpcService.save(varIpc);
	}
	
	@GetMapping("/getAll")
	public List<VarIpc> getAll() {
		return varIpcService.findAll();
	}
	
	@GetMapping("/getAllAnio")
	public List<VarIpc> getAllAnio(@RequestParam Integer desde,@RequestParam Integer hasta) {
		return this.varIpcService.findAllAnio(desde, hasta);
	}
	
	@GetMapping("/getAnio")
	public VarIpc getAnio(@RequestParam Integer anio) {
		return varIpcService.findAnio(anio);
	}
	
	@GetMapping("/calcular")
	public JSONObject calcularVariacionIpcAnio(@RequestParam Integer anio) {
		return varIpcService.calcularVarIpcAnio(anio);
	}
}
