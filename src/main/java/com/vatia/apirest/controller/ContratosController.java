package com.vatia.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.FechasCorteContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.service.ContratoService;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.response.ResponseHTTP;
import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/Contrato")
public class ContratosController {

	@Autowired
	private ContratoService contratoService;

	@GetMapping("/getAllTipoMercado")
	public ResponseEntity<ResponseHTTP> getAllTipoMercado() {
		List<TiposMercados> tiposMercados = new ArrayList<>();

		try {
			tiposMercados = contratoService.getAllTipoMercado();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return tiposMercados.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), tiposMercados), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), tiposMercados),
						HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/getAllTipoContrato")
	public ResponseEntity<ResponseHTTP>  getAllTipoContrato() {		
		List<TiposContratos> tiposContratos = new ArrayList<>();

		try {
			tiposContratos = contratoService.getAllTipoContrato();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return tiposContratos.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), tiposContratos), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), tiposContratos),
						HttpStatus.NOT_FOUND);		
		
	}
	
	@GetMapping("/getAllModalidadContrato")
	public ResponseEntity<ResponseHTTP> getAllModalidadContrato() {
		List<ModalidadesContratos> modalidadesContratos = new ArrayList<>();

		try {
			modalidadesContratos = contratoService.getAllModalidadContrato();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return modalidadesContratos.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), modalidadesContratos), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), modalidadesContratos),
						HttpStatus.NOT_FOUND);	
	}
		
	@GetMapping("/getAllTipoGarantia")
	public ResponseEntity<ResponseHTTP> getAllTipoGarantia() {
		List<TiposGarantias> tiposGarantias = new ArrayList<>();
		
		try {
			tiposGarantias = contratoService.getAllTipoGarantia();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return tiposGarantias.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), tiposGarantias), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), tiposGarantias),
						HttpStatus.NOT_FOUND);			
	}

	
	@GetMapping("/getAllTipoPrecio")
	public ResponseEntity<ResponseHTTP> getAllTipoPrecio() {
		List<TiposPrecio> tiposPrecio = new ArrayList<>();
		
		try {
			tiposPrecio = contratoService.getAllTipoPrecio();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return tiposPrecio.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), tiposPrecio), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), tiposPrecio),
						HttpStatus.NOT_FOUND);	
	}

	@GetMapping("/getAllTipoCantidad")
	public ResponseEntity<ResponseHTTP> getAllTipoCantidad() {
		List<TiposCantidad> tiposCantidad = new ArrayList<>();
		
		try {
			tiposCantidad = contratoService.getAllTipoCantidad();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return tiposCantidad.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), tiposCantidad), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), tiposCantidad),
						HttpStatus.NOT_FOUND);		
		
	}	
	
	
	
	@GetMapping("/getAllSicAgenteComercial")
	public ResponseEntity<ResponseHTTP> getAllSicAgenteComercial(@RequestParam String valor) {
		AgentesComerciales agentesComerciales = new AgentesComerciales();
		
		try {
			agentesComerciales = contratoService.getAllSicAgenteComercial(valor);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return 	agentesComerciales != null  ? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), agentesComerciales), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), agentesComerciales), HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/getAllFechaCorte")
	public ResponseEntity<ResponseHTTP> getAllFechaCorte() {	
		List<FechasCorteContratos> fechasCorteContratos = new ArrayList<>();
		
		try {
			fechasCorteContratos = contratoService.getAllFechaCorte();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return fechasCorteContratos.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), fechasCorteContratos), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), fechasCorteContratos),
						HttpStatus.NOT_FOUND);		
		
	}	
	
	@GetMapping("/getAllFormulaPrecio")
	public ResponseEntity<ResponseHTTP>  getAllFormulaPrecio() {
		List<FormulasPrecios> formulasPrecios = new ArrayList<>();
		
		try {
			formulasPrecios = contratoService.getAllFormulaPrecio();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return formulasPrecios.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), formulasPrecios), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), formulasPrecios),
						HttpStatus.NOT_FOUND);	
		
	}
	
	@PostMapping("/saveContrato")
	public  ResponseEntity<ResponseHTTP>  updateContrato(@RequestBody ContratosRequest contratosRequest) {
		SaveResponse saveResponse = new SaveResponse();
		
		try {
			saveResponse = contratoService.saveContrato(contratosRequest);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return 	saveResponse != null  
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), saveResponse), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), saveResponse), HttpStatus.NOT_FOUND);
		
	}
		
		
	
	
}
