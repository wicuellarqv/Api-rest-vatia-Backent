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
import com.vatia.apirest.model.EmpresaPlanta;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.EmpresaPlantaService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("v1/empresa_planta")
public class EmpresaPlantaController {

	@Autowired
	private EmpresaPlantaService empresaPlantaService;

	@PostMapping("/save")
	public ResponseEntity<ResponseHTTP> createCategoriaCli(@RequestBody List<EmpresaPlanta> ListEmpresaPlanta) {
		List<EmpresaPlanta> responseListEmpresaPlanta =  new ArrayList<EmpresaPlanta>();
		try {
			if(ListEmpresaPlanta.size() > 0) {
				for (EmpresaPlanta empresaPlanta : ListEmpresaPlanta) {
					responseListEmpresaPlanta.add(empresaPlantaService.save(empresaPlanta));
				}
			}else {
				return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Esta enviado una lista vacia"), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseListEmpresaPlanta.size() == 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la creacion de la categoria cliente"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), responseListEmpresaPlanta), HttpStatus.OK);

	}
	
	@GetMapping("/get_all")
	public ResponseEntity<ResponseHTTP> getAll() {
		List<EmpresaPlanta> empresaPlantas = new ArrayList<>();

		try {
			empresaPlantas = empresaPlantaService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return empresaPlantas.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), empresaPlantas), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), empresaPlantas), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/delete")
	public ResponseEntity<ResponseHTTP> deleteEmpresa(@RequestBody EmpresaPlanta empresaPlanta) {
		try {
			empresaPlantaService.deleteById(empresaPlanta.getId());
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
