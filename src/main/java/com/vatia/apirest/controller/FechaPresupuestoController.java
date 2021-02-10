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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.model.FechaPresupuesto;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.FechaPresupuestoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("v1/FechaPresupuesto")
public class FechaPresupuestoController {
	@Autowired
	private FechaPresupuestoService fechaPresupuestoService;

	@PostMapping("/save")
	public ResponseEntity<ResponseHTTP> saveFechaPresupuesto(@RequestBody FechaPresupuesto fechaPresupuesto) {
		FechaPresupuesto saveResponse = null;
		try {
			saveResponse = fechaPresupuestoService.saveFechaPresupuesto(fechaPresupuesto);
			if(saveResponse == null) {
				return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), "Ya existe un registro con este anio"),
						HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), saveResponse), HttpStatus.OK);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<ResponseHTTP> updateFechaPresupuesto(@RequestBody FechaPresupuesto fechaPresupuesto) {
		FechaPresupuesto saveResponse = null;
		try {

			saveResponse = fechaPresupuestoService.updateFechaPresupuesto(fechaPresupuesto);

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

	@PostMapping("/delete_by_id")
	public ResponseEntity<ResponseHTTP> deleteById(@RequestBody FechaPresupuesto fechaPresupuesto) {
		try {
			fechaPresupuestoService.deleteFechaPresupuesto(fechaPresupuesto);
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
		} catch (Exception e2) {
			e2.printStackTrace();
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/get_by_anio")
	public ResponseEntity<ResponseHTTP> getAllFechaPresupuestoByAnio(@RequestParam String anio) {
		List<FechaPresupuesto> fechaPresupuesto = new ArrayList<>();

		try {
			fechaPresupuesto = fechaPresupuestoService.getAllFechaPresupuestoByAnio(anio);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return fechaPresupuesto.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), fechaPresupuesto), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), fechaPresupuesto),
						HttpStatus.NOT_FOUND);

	}

	@GetMapping("/get_all")
	public ResponseEntity<ResponseHTTP> getAllFechaPresupuesto() {
		List<FechaPresupuesto> fechaPresupuesto = new ArrayList<>();

		try {
			fechaPresupuesto = fechaPresupuestoService.getAllFechaPresupuesto();

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
