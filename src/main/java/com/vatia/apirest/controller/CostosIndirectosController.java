package com.vatia.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.vatia.apirest.model.Costos_indirectos;
import com.vatia.apirest.model.Cuentas_CeCos_CostInd;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.CostosIndirectosService;
import com.vatia.apirest.utils.ContratosRequest;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("v1/CostosIndirectos")
public class CostosIndirectosController {
	@Autowired
	private CostosIndirectosService CostosIndirectosService;

	@GetMapping("/getAllPeriodo")
	public List<Costos_indirectos> getAllPeriodo(@RequestParam String mes,@RequestParam String ano) {
		
			return this.CostosIndirectosService.getAllPeriodo(mes, ano);

	}
	
	@PostMapping("/saveCostoInditecto")
	public ResponseEntity<ResponseHTTP> saveCostoInditecto( @RequestBody JSONObject obj) {
		String saveResponse = null;
		try {			
		
			saveResponse = CostosIndirectosService.saveCostoInditecto(obj);			
			
		} catch (Exception e2) {
			e2.printStackTrace();
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return saveResponse != null
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), saveResponse), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), saveResponse),
						HttpStatus.NOT_FOUND);

	}
	
	@PostMapping("/validaCuenCenC")
	public ResponseEntity<ResponseHTTP> validaCuenCenC( @RequestBody JSONObject obj) {
		String status = null;
		try {			
		
			status = CostosIndirectosService.validaCuenCenC(obj);			
			
		} catch (Exception e2) {
			e2.printStackTrace();
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return status != null
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), status), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), status),
						HttpStatus.NOT_FOUND);

	}
	
	@DeleteMapping ("/deleteCenCost")
	public ResponseEntity<ResponseHTTP> deleteCenCost(@RequestParam Integer id) {
		String status = null;
		try {
			
			status = CostosIndirectosService.deleteCenCost(id);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return status != null ? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), status), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), status),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/getAllCuentasCecos")
	public ResponseEntity<ResponseHTTP> getAllCuentasCecos() {
		List<Cuentas_CeCos_CostInd> cuentas_CeCos_CostInd = new ArrayList<>();

		try {
			cuentas_CeCos_CostInd = CostosIndirectosService.getAllCuentasCecos();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return cuentas_CeCos_CostInd.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), cuentas_CeCos_CostInd), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), cuentas_CeCos_CostInd),
						HttpStatus.NOT_FOUND);

	}
	
	
	
}
