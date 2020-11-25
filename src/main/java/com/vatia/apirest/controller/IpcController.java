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
import com.vatia.apirest.model.Ipc;
import com.vatia.apirest.service.IpcService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/ipc")
public class IpcController {
	@Autowired
	private IpcService ipcService;

	@PostMapping("/guardar")
	public void save(@RequestBody Ipc ipc) {
		this.ipcService.save(ipc);
	}

	@GetMapping("/getAll")
	public List<Ipc> getAll() {
		return this.ipcService.findAll();
	}
	
	@GetMapping("/getAllAnio")
	public List<Ipc> getAllAnio(@RequestParam Integer desde,@RequestParam Integer hasta) {
		return this.ipcService.findAllAnio(desde, hasta);
	}
	
	@GetMapping("/getIpcAnio")
	public Ipc getIpcAnio(@RequestParam Integer anio) {
		return this.ipcService.findIpcAnio(anio);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		this.ipcService.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Ipc ipc) {
		this.ipcService.save(ipc);
	}
	
}
