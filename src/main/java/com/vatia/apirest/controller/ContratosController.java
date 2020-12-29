package com.vatia.apirest.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
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
import org.springframework.web.multipart.MultipartFile;

import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.CondicionTipoContrato;
import com.vatia.apirest.model.FechasCorteContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.NegociacionesContratos;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.service.ContratoService;
import com.vatia.apirest.utils.CantidadRequest;
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
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), ""), HttpStatus.OK);
		
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
<<<<<<< Updated upstream
	
	
	@GetMapping("/getAllCTipoContrato")
	public ResponseEntity<ResponseHTTP>  getAllCTipoContrato() {
		List<CondicionTipoContrato> condicionTipoContrato = new ArrayList<>();
		
		try {
			condicionTipoContrato = contratoService.getAllCTipoContrato();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return condicionTipoContrato.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), condicionTipoContrato), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), condicionTipoContrato),
						HttpStatus.NOT_FOUND);	
		
	}
	
	@GetMapping("/getAllNegocioContrato")
	public ResponseEntity<ResponseHTTP>  getAllNegocioContrato() {
		List<NegociacionesContratos> negociacionesContratos = new ArrayList<>();
		
		try {
			negociacionesContratos = contratoService.getAllNegocioContrato();

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return negociacionesContratos.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), negociacionesContratos), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), negociacionesContratos),
						HttpStatus.NOT_FOUND);	
		
	}
	
	
=======
	/**
>>>>>>> Stashed changes
	@PostMapping("/saveContrato")
	public  ResponseEntity<ResponseHTTP>  saveContrato(
			@RequestBody ContratosRequest contratosRequest
			) {
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
	**/
	
	@PostMapping("/saveContrato")
	public ResponseEntity<ResponseHTTP> test(@RequestParam("files") MultipartFile file, @RequestParam String obj  ){
		Gson g = new Gson();
		ContratosRequest cr = g.fromJson(obj, ContratosRequest.class);
		SaveResponse saveResponse = new SaveResponse();
		// lectura del archivo a CantidadReuqest
			if(file.isEmpty()) {
				saveResponse.setMsg("Por favor escoja un archivo CSV valido");
			}
			else {
				try {
					Reader lectura = new BufferedReader(new InputStreamReader(file.getInputStream()));
					CsvToBean<CantidadRequest> cantReq = new CsvToBeanBuilder(lectura).withType(CantidadRequest.class).withIgnoreLeadingWhiteSpace(true).build();
					List<CantidadRequest> cantRequest = cantReq.parse();
					if (cantRequest.size() >0){
						saveResponse = contratoService.saveContrato(cr,cantRequest);
					}
				} catch (Exception e) {
					return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		
		
		
		return 	cr != null  
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), file), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), file), HttpStatus.NOT_FOUND);
	}
		
		
	
	
}
