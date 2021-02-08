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
import com.vatia.apirest.model.FechaPresupuesto;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.CostosIndirectosService;
import com.vatia.apirest.service.FechaPresupuestoService;
import com.vatia.apirest.utils.ContratosRequest;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("v1/FechaPresupuesto")
public class FechaPresupuestoController {
	@Autowired
	private FechaPresupuestoService fechaPresupuestoService;

	
	@PostMapping("/saveFechaPresupuesto")
	public ResponseEntity<ResponseHTTP> saveFechaPresupuesto( @RequestBody JSONObject obj) {
		String saveResponse = null;
		try {			
		
			saveResponse = fechaPresupuestoService.saveFechaPresupuesto(obj);			
			
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
	
	@PostMapping("/updateFechaPresupuesto")
	public ResponseEntity<ResponseHTTP> updateFechaPresupuesto( @RequestBody JSONObject obj) {
		String saveResponse = null;
		try {			
		
			saveResponse = fechaPresupuestoService.updateFechaPresupuesto(obj);			
			
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
	
	
	@GetMapping("/getAllFechaPresupuesto")
	public ResponseEntity<ResponseHTTP> getAllFechaPresupuesto(@RequestParam String ano) {
		List<FechaPresupuesto> fechaPresupuesto = new ArrayList<>();

		try {
			fechaPresupuesto = fechaPresupuestoService.getAllFechaPresupuesto(ano);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return fechaPresupuesto.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), fechaPresupuesto), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), fechaPresupuesto),
						HttpStatus.NOT_FOUND);

	}
	
	
	
}
