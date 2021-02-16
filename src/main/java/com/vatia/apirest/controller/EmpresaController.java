package com.vatia.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.model.Empresa;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.EmpresaService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("v1/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@PostMapping("/save")
	public ResponseEntity<ResponseHTTP> saveEmpresa(@RequestBody Empresa empresa) {
		Empresa ResponseEmpresa = null;

		try {
			ResponseEmpresa = empresaService.save(empresa);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEmpresa == null
				? new ResponseEntity<>(
						new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), "hay un error al crear la empresa"),
						HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), ResponseEmpresa), HttpStatus.OK);

	}
	
	@GetMapping("/get_all")
	public ResponseEntity<ResponseHTTP> getAll() {
		List<Empresa> empresas = new ArrayList<>();

		try {
			empresas = empresaService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return empresas.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), empresas), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), empresas), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/delete")
	public ResponseEntity<ResponseHTTP> deleteEmpresa(@RequestBody Empresa empresa) {
		try {
			empresaService.deleteById(empresa.getId());
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
