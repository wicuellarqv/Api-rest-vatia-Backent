
package com.vatia.apirest.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import com.vatia.apirest.utils.FechasPagosRequest;
import com.vatia.apirest.response.ResponseHTTP;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
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
	public ResponseEntity<ResponseHTTP> getAllTipoContrato() {
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
		return agentesComerciales != null
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), agentesComerciales), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), ""), HttpStatus.OK);

	}

	@GetMapping("/getAllFormulaPrecio")
	public ResponseEntity<ResponseHTTP> getAllFormulaPrecio() {
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

	@GetMapping("/getAllCTipoContrato")
	public ResponseEntity<ResponseHTTP> getAllCTipoContrato() {
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
	public ResponseEntity<ResponseHTTP> getAllNegocioContrato() {
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

	/**
	 * @PostMapping("/saveContrato") public ResponseEntity<ResponseHTTP>
	 * saveContrato(
	 * 
	 * @RequestBody ContratosRequest contratosRequest ) { SaveResponse saveResponse
	 *              = new SaveResponse();
	 * 
	 *              try { saveResponse =
	 *              contratoService.saveContrato(contratosRequest);
	 * 
	 *              } catch (Exception e) { return new ResponseEntity<>(new
	 *              ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
	 *              HttpStatus.INTERNAL_SERVER_ERROR); } return saveResponse != null
	 *              ? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(),
	 *              saveResponse), HttpStatus.OK) : new ResponseEntity<>(new
	 *              ResponseHTTP(HttpStatus.NOT_FOUND.value(), saveResponse),
	 *              HttpStatus.NOT_FOUND);
	 * 
	 *              }
	 **/

	@PostMapping("/saveContrato")
	public ResponseEntity<ResponseHTTP> testFile(@RequestParam("files") MultipartFile[] files,
			@RequestParam String obj) {
		SaveResponse saveResponse = new SaveResponse();
		try {
			Gson g = new Gson();
			ContratosRequest cr = g.fromJson(obj, ContratosRequest.class);
			List<CantidadRequest> listCantidad = new ArrayList<CantidadRequest>();
			List<FechasPagosRequest> listFechaPagos = new ArrayList<FechasPagosRequest>();
			Arrays.asList(files).stream().forEach(file -> {
				if (!file.isEmpty()) {
					if ((file.getOriginalFilename().toLowerCase()).substring(0, 8).equals("cantidad")) {
						listCantidad.addAll(createListCantidad(file));
					}
					if ((file.getOriginalFilename().toLowerCase()).substring(0, 10).equals("fechaspago")) {
						listFechaPagos.addAll(createListFechaPagos(file));
					}
				}
			});
			saveResponse = contratoService.saveContrato(cr, listCantidad, listFechaPagos);
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

	@PostMapping("/validate_file")
	public ResponseEntity<ResponseHTTP> validateFile(@RequestParam("files") MultipartFile[] files,
			@RequestParam String obj) {
		String status = null;
		try {
			Gson g = new Gson();
			ContratosRequest cr = g.fromJson(obj, ContratosRequest.class);
			List<CantidadRequest> listCantidad = new ArrayList<CantidadRequest>();
			List<FechasPagosRequest> listFechaPagos = new ArrayList<FechasPagosRequest>();

			Arrays.asList(files).stream().forEach(file -> {
				if (!file.isEmpty()) {
					if ((file.getOriginalFilename().toLowerCase()).substring(0, 8).equals("cantidad")) {
						listCantidad.addAll(createListCantidad(file));
					}
					if ((file.getOriginalFilename().toLowerCase()).substring(0, 10).equals("fechaspago")) {
						listFechaPagos.addAll(createListFechaPagos(file));
					}
				}
			});
			if (listCantidad.size() > 0) {
				status = validateCantidades(cr.getFechaInicioContrato(), cr.getFechaFinContrato(), listCantidad);
			}
			if (listFechaPagos.size() > 0) {
				status = validateFechaPagos(listFechaPagos);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return status == null ? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), status),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public String validateCantidades(String fechaInicio, String fechaFinal, List<CantidadRequest> listCantidad) {
		
		//TODO: VALIDAR CANTIDADES
		return null;
	}

	public String validateFechaPagos(List<FechasPagosRequest> listFechaPagos) {

		// TODO: TODAS LAS VALIDACIONES
		return null;
	}

	public List<CantidadRequest> createListCantidad(MultipartFile file) {
		List<CantidadRequest> listCantidad = new ArrayList<CantidadRequest>();
		try {
			BufferedReader lectura = new BufferedReader(new InputStreamReader(file.getInputStream()));
			String strCurrentLine;
			int i = 0;
			while ((strCurrentLine = lectura.readLine()) != null) {
				String[] data = strCurrentLine.split(";");
				if (i > 0) {
					CantidadRequest newItem = new CantidadRequest(data[0], data[1], data[2], data[3], data[4], data[5],
							data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14],
							data[15], data[16], data[17], data[18], data[19], data[20], data[21], data[22], data[23],
							data[24]);
					System.out.println(newItem.toString());
					listCantidad.add(newItem);
				}
				i++;
			}
			return listCantidad;
		} catch (Exception e) {
			e.printStackTrace();
			return listCantidad;
		}
	}

	public List<FechasPagosRequest> createListFechaPagos(MultipartFile file) {
		List<FechasPagosRequest> listFechaPagos = new ArrayList<FechasPagosRequest>();
		try {
			BufferedReader lectura = new BufferedReader(new InputStreamReader(file.getInputStream()));
			String strCurrentLine;
			int i = 0;
			while ((strCurrentLine = lectura.readLine()) != null) {
				String[] data = strCurrentLine.split(";");
				if (i > 0) {
					FechasPagosRequest newItem = new FechasPagosRequest(data[0], data[1]);
					listFechaPagos.add(newItem);
				}
				i++;
			}
			return listFechaPagos;
		} catch (Exception e) {
			e.printStackTrace();
			return listFechaPagos;
		}
	}

	static class testClass {
		private String campo1;
		private String campo2;

		public testClass(String campo1, String campo2) {
			super();
			this.campo1 = campo1;
			this.campo2 = campo2;
		}

		public String getCampo1() {
			return campo1;
		}

		public void setCampo1(String campo1) {
			this.campo1 = campo1;
		}

		public String getCampo2() {
			return campo2;
		}

		public void setCampo2(String campo2) {
			this.campo2 = campo2;
		}

		@Override
		public String toString() {
			return "testClass [campo1=" + campo1 + ", campo2=" + campo2 + "]";
		}
	}
}
