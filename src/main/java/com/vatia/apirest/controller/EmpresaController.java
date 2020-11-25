package com.vatia.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vatia.apirest.model.Empresa;
import com.vatia.apirest.service.EmpresaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@PostMapping("/guardar")
	public void save(@RequestBody Empresa empresa) {
		empresaService.save(empresa);
	}

	@GetMapping("/getAll")
	public List<Empresa> getAll() {
		return empresaService.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		empresaService.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Empresa empresa) {
		empresaService.save(empresa);
	}
	

}
