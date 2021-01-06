
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
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


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
				status = validateFechaPagos(cr.getFechaInicioContrato(), cr.getFechaFinContrato(), listFechaPagos);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Existen campos vacios o estructura invalida del archivo!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return status == null ? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), status),
						HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public String validateCantidades(String fechaInicio, String fechaFinal, List<CantidadRequest> listCantidad) {
		try {
			Date dateFechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
			Date dateFechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFinal);
			long diff = dateFechaFin.getTime() - dateFechaInicio.getTime();
			long dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			// LE SUMAMOS UNO YA QUE EL CALCULO NO CUENTA LA PRIMERA FECHA SI NO LOS DIAS
			// QUE HAY ENTRE LAS FECHAS
			dias = (dias + 1);
			// validamos que la cantidad de dias sea igual a la cantidad de registros
			if (dias != listCantidad.size()) {
				System.out.println("dias: " + dias + " lista size: " + listCantidad.size());
				return "La cantidad de dias es diferente a la cantidad de registros del archivo";
			} else {
				// validamos que no haya un elemento repetido
				for (int i = 0; i < listCantidad.size(); i++) {
					// VALIDAMOS QUE NO HAYA NINGUNA FECHA VACIA O NULA
					if (listCantidad.get(i).getFecha().equals("") || listCantidad.get(i).getFecha() == null) {
						return "Hay una fecha vacia o nula";
					}
					// VALIDAMOS QUE LA FECHA TENGA EL FORMATO ESPERADO
					if (!(Pattern.matches("^(?:3[01]|[12][0-9]|0?[1-9])([/])(0?[1-9]|1[1-2])\\1\\d{4}$",
							listCantidad.get(i).getFecha()))) {
						return "En la columna fecha hay un valor " + listCantidad.get(i).getFecha()
								+ " que no tiene el formato de fecha esperado dd/MM/yyyy";
					}
					// BUSCAMOS LA DUPLICIDAD
					for (int j = i + 1; j < listCantidad.size(); j++) {
						if (listCantidad.get(i).getFecha().equals(listCantidad.get(j).getFecha())) {
							return "Hay una fecha duplicada en el archivo";
						}
					}
				}
				// validamos si las fechas estan dentro del rango de fecha incio a fin
				for (CantidadRequest cantidadRequest : listCantidad) {
					Date dateFechaItem = new SimpleDateFormat("dd/MM/yyyy").parse(cantidadRequest.getFecha());
					if (!(dateFechaItem.after(dateFechaInicio) && dateFechaItem.before(dateFechaFin))
							&& dateFechaItem.compareTo(dateFechaInicio) != 0
							&& dateFechaItem.compareTo(dateFechaFin) != 0) {
						return "Hay una fecha que no pertenece al rango de las fechas de inicio y fin";
					} else {
						// VALIDAMOS QUE LAS HORAS NO ESTEN VACIAS O SEAN NULAS
						if ((cantidadRequest.getH1() == null || (cantidadRequest.getH1().equals("")))
								|| (cantidadRequest.getH2() == null || (cantidadRequest.getH2().equals("")))
								|| (cantidadRequest.getH3() == null || (cantidadRequest.getH3().equals("")))
								|| (cantidadRequest.getH4() == null || (cantidadRequest.getH4().equals("")))
								|| (cantidadRequest.getH5() == null || (cantidadRequest.getH5().equals("")))
								|| (cantidadRequest.getH6() == null || (cantidadRequest.getH6().equals("")))
								|| (cantidadRequest.getH7() == null || (cantidadRequest.getH7().equals("")))
								|| (cantidadRequest.getH8() == null || (cantidadRequest.getH8().equals("")))
								|| (cantidadRequest.getH9() == null || (cantidadRequest.getH9().equals("")))
								|| (cantidadRequest.getH10() == null || (cantidadRequest.getH10().equals("")))
								|| (cantidadRequest.getH11() == null || (cantidadRequest.getH11().equals("")))
								|| (cantidadRequest.getH12() == null || (cantidadRequest.getH12().equals("")))
								|| (cantidadRequest.getH13() == null || (cantidadRequest.getH13().equals("")))
								|| (cantidadRequest.getH14() == null || (cantidadRequest.getH14().equals("")))
								|| (cantidadRequest.getH15() == null || (cantidadRequest.getH15().equals("")))
								|| (cantidadRequest.getH16() == null || (cantidadRequest.getH16().equals("")))
								|| (cantidadRequest.getH17() == null || (cantidadRequest.getH17().equals("")))
								|| (cantidadRequest.getH18() == null || (cantidadRequest.getH18().equals("")))
								|| (cantidadRequest.getH19() == null || (cantidadRequest.getH19().equals("")))
								|| (cantidadRequest.getH20() == null || (cantidadRequest.getH20().equals("")))
								|| (cantidadRequest.getH21() == null || (cantidadRequest.getH21().equals("")))
								|| (cantidadRequest.getH22() == null || (cantidadRequest.getH22().equals("")))
								|| (cantidadRequest.getH23() == null || (cantidadRequest.getH23().equals("")))
								|| (cantidadRequest.getH24() == null || (cantidadRequest.getH24().equals("")))) {
							return "La fecha " + dateFechaItem.toString() + " tiene horas vacias";
						}

					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return "Hay un error al procesar el archivo " + e.toString();
		}
		return null;
	}

	public String validateFechaPagos(String fechaInicio, String fechaFinal, List<FechasPagosRequest> listFechaPagos) {
		Boolean valida = true;
		String msg1 = "";
		String msg2 = "";
		String msg3 = "";
		String msg4 = "";
		String msg5 = "";
		String msgError = null;
		int contadorPeriodo = 0;
		boolean res=true;
		ArrayList<String> Listado = new ArrayList<String>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		
        try {
			Calendar inicio = new GregorianCalendar();
			Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio));
            fin.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fechaFinal));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            int difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH)+1;
            System.out.println(difM);



			for (FechasPagosRequest fechasPagos : listFechaPagos) {
				contadorPeriodo++;
				if (fechasPagos.getFechaPago() == "") {
					valida = false;
					msg1 = " Fecha de pago vacia !";
				}
				if (fechasPagos.getPeriodo() == "") {
					valida = false;
					msg4 = " Periodo de pago vacio !";
				}
				Listado.add(fechasPagos.getPeriodo());

				if (valida) {
					if (difM != contadorPeriodo) {
						valida = false;
						msg3 = " La cantidad de meses de periodos de pagos, no son iguales a los meses de fecha inicio y fin del contrato !";
					}

					Set<String> miSet = new HashSet<String>(Listado);
					for (String s : miSet) {

						int duplicado = Collections.frequency(Listado, s);
						System.out.print(duplicado);
						if (duplicado > 1) {
							valida = false;
							msg2 = " Existen periodos repetidos !";
						}
					}
				}
			}
		} catch (ParseException ex) {
			System.out.println(ex);
		}

		if (!valida) {
			msgError = "El archivo contiene los siguientes errores: " + msg3 + " " + msg2 + " " + msg1 + "" + msg4 + ""
					+ msg5;
		}

		return msgError;
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
			return null;
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
