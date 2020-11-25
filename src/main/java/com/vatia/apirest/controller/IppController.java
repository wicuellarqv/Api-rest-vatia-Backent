package com.vatia.apirest.controller;

import java.util.List;
import java.util.Map;

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
import com.vatia.apirest.model.Ipp;
import com.vatia.apirest.service.IppService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/ipp")
public class IppController {
	@Autowired
	private IppService ippService;
	

	@PostMapping("/guardar")
	public void save(@RequestBody Ipp ipp) {
		this.ippService.save(ipp);
	}

	@GetMapping("/getAll")
	public List<Ipp> getAll() {
		return this.ippService.findAll();
	}
	
	@GetMapping("/getAllAnio")
	public List<Ipp> getAllAnio(@RequestParam Integer desde,@RequestParam Integer hasta) {
		return this.ippService.findAllAnio(desde, hasta);
	}
	
	@GetMapping("/getIppAnio")
	public Ipp getIppAnio(@RequestParam Integer anio) {
		return this.ippService.findIppAnio(anio);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		this.ippService.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Ipp Ipp) {
		this.ippService.save(Ipp);
	}
	
}
