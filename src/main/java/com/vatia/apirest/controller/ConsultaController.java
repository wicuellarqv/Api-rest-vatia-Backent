package com.vatia.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.ConsultaService;
import com.vatia.apirest.utils.ConsultaContratosResponse;
import com.vatia.apirest.utils.ContratoDetailResponse;
import com.vatia.apirest.utils.GarantiasResponse;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("v1/consultas")
public class ConsultaController {
	@Autowired
	private ConsultaService consultaService;
	

	@PostMapping("/contratos")
	public ResponseEntity<ResponseHTTP> consultaContratos(@RequestBody JSONObject obj) {
		List<ConsultaContratosResponse> consultaContratos = new ArrayList<>();

		try {
			consultaContratos = consultaService.contratos(obj);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return consultaContratos.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), consultaContratos), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), consultaContratos),
						HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/detalle/contrato")
	public ResponseEntity<ResponseHTTP> findAllById(@RequestBody JSONObject obj) {
		String idContrato = obj.get("idContrato").toString();

		ContratoDetailResponse contratoDetailResponse = new ContratoDetailResponse(null);

		try {
			contratoDetailResponse = consultaService.findById(idContrato);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return contratoDetailResponse != null
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), contratoDetailResponse), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), ""), HttpStatus.OK);
		
		
	}
	
	@PostMapping("/garantias")
	public List<GarantiasResponse> precios(@RequestBody JSONObject obj){
		String idContrato = obj.get("idContrato").toString();
		return consultaService.garantias(idContrato);
	}
}
