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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.service.MComercialesService;
import com.vatia.apirest.model.Margenes_cciales;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/MComerciales")
public class MComercialesController {
	@Autowired
	private MComercialesService MComercialesService;

	@PostMapping("/save")
	public void save(@RequestBody Margenes_cciales Margenes_cciales) {
		this.MComercialesService.save(Margenes_cciales);
	}

	@GetMapping("/getAllAnio")
	public List<Margenes_cciales> getAllAnio(@RequestParam String desde,@RequestParam String hasta, @RequestParam String version) {
		
		if (version.equals("T")) {
			return this.MComercialesService.findAllAnio(desde, hasta);
		}else {
			return this.MComercialesService.findAllAnioV(desde, hasta, version);
		}

		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		this.MComercialesService.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Margenes_cciales Margenes_cciales) {
		this.MComercialesService.save(Margenes_cciales);
	}
	
}
