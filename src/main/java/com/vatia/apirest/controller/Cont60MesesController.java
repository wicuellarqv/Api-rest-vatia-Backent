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

import com.vatia.apirest.model.Cantidad60Meses;
import com.vatia.apirest.model.Contratos60Meses;
import com.vatia.apirest.model.Precios60Meses;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.Contratos60MesesService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("v1/contratos_60_meses")
public class Cont60MesesController {

	@Autowired
	private Contratos60MesesService contratos60MesesService;

	@GetMapping("/contratos")
	public ResponseEntity<ResponseHTTP> getCantidadesByIdContrato() {
		List<Contratos60Meses> contratos = new ArrayList<>();

		try {
			contratos = contratos60MesesService.getAllContrato60Meses();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return contratos.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), contratos), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), contratos), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/cantidades_by_id_contrato")
	public ResponseEntity<ResponseHTTP> getAllCategorias(@RequestBody Contratos60Meses contratos60MesesRequest) {
		List<Cantidad60Meses> cantidades = new ArrayList<>();

		try {
			cantidades = contratos60MesesService.getCantidad60MesesByContrato(contratos60MesesRequest.getId());
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return cantidades.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), cantidades), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), cantidades),
						HttpStatus.NOT_FOUND);

	}

	@PostMapping("/contratos")
	public ResponseEntity<ResponseHTTP> saveInfoFileContratos60Meses(
			@RequestBody List<Contratos60Meses> listContratos60MesesRequest) {
		Contratos60Meses newContratos60Meses = new Contratos60Meses();
		try {
			for (Contratos60Meses contratos60MesesRequest : listContratos60MesesRequest) {
				System.out.println("valores basicos del contrato");
				System.out.println(contratos60MesesRequest.toString());
				System.out.println("tamaño precios " + contratos60MesesRequest.getPrecios60Meses().size());
				System.out.println("tamaño cantidad " + contratos60MesesRequest.getCantidad60Meses().size());
				Contratos60Meses findContratos60Meses = contratos60MesesService
						.Contrato60MesesFindByCodContrato(contratos60MesesRequest.getNumCodContrato());
				if (findContratos60Meses == null) {
					System.out.println("crear nuevo contrato");
					// CREAR EL OBJETO CONTRATO
					newContratos60Meses = contratos60MesesService.saveContrato60Meses(contratos60MesesRequest);
					// CREAR LA LISTA DE PRECIOS
					if (contratos60MesesRequest.getPrecios60Meses().size() > 0) {
						for (Precios60Meses itemPrecio : contratos60MesesRequest.getPrecios60Meses()) {
							itemPrecio.setContratos60Meses(newContratos60Meses);
							contratos60MesesService.savePrecios60Meses(itemPrecio);
						}
					}

					// CREAR LA LISTA DE CANTIDADES
					if (contratos60MesesRequest.getCantidad60Meses().size() > 0) {
						for (Cantidad60Meses itemCantidad : contratos60MesesRequest.getCantidad60Meses()) {
							itemCantidad.setContratos60Meses(newContratos60Meses);
							contratos60MesesService.saveCantidad60Meses(itemCantidad);
						}
					}
				} else {
					Integer idContrato = findContratos60Meses.getId();
					Contratos60Meses contrato = new Contratos60Meses();
					contrato.setId(idContrato);
					System.out.println("actualizar contrato " + idContrato);
					if (contratos60MesesRequest.getCantidad60Meses().size() > 0) {
						for (Cantidad60Meses cantidad60MesesRequest : contratos60MesesRequest.getCantidad60Meses()) {
							Cantidad60Meses cantidad60MesesFind = contratos60MesesService
									.getCantidad60MesesByPeriodoAndContrato(cantidad60MesesRequest.getDtmPeriodo(),
											idContrato);
							if (cantidad60MesesFind == null) {
								Cantidad60Meses newCantidad60Meses = cantidad60MesesRequest;
								newCantidad60Meses.setContratos60Meses(contrato);
								contratos60MesesService.saveCantidad60Meses(newCantidad60Meses);
							} else {
								if (!(cantidad60MesesFind.getNumCantidadPeriodo()
										.equals(cantidad60MesesRequest.getNumCantidadPeriodo()))) {
									Cantidad60Meses updateCantidad60Meses = new Cantidad60Meses();
									updateCantidad60Meses.setDtmPeriodo(cantidad60MesesFind.getDtmPeriodo());
									updateCantidad60Meses.setId(cantidad60MesesFind.getId());
									updateCantidad60Meses
											.setNumCantidadPeriodo(cantidad60MesesRequest.getNumCantidadPeriodo());
									updateCantidad60Meses.setContratos60Meses(contrato);
									contratos60MesesService.saveCantidad60Meses(updateCantidad60Meses);
								}
							}
						}
					}
					if (contratos60MesesRequest.getPrecios60Meses().size() > 0) {
						for (Precios60Meses precios60MesesRequest : contratos60MesesRequest.getPrecios60Meses()) {
							Precios60Meses precio60MesesFind = contratos60MesesService
									.getPrecios60MesesByPeriodoAndContrato(precios60MesesRequest.getDtmPeriodo(),
											idContrato);
							if (precio60MesesFind == null) {
								Precios60Meses newPrecios60Meses = precios60MesesRequest;
								newPrecios60Meses.setContratos60Meses(contrato);
								contratos60MesesService.savePrecios60Meses(newPrecios60Meses);
							} else {
								if (!(precio60MesesFind.getNumPrecioPeriodo()
										.equals(precios60MesesRequest.getNumPrecioPeriodo()))) {
									Precios60Meses updatePrecios60Meses = new Precios60Meses();
									updatePrecios60Meses.setDtmPeriodo(precio60MesesFind.getDtmPeriodo());
									updatePrecios60Meses.setId(precio60MesesFind.getId());
									updatePrecios60Meses
											.setNumPrecioPeriodo(precios60MesesRequest.getNumPrecioPeriodo());
									updatePrecios60Meses.setContratos60Meses(contrato);
									contratos60MesesService.savePrecios60Meses(updatePrecios60Meses);
								}
							}
						}
					}
					newContratos60Meses = contratos60MesesService
							.Contrato60MesesFindByCodContrato(contratos60MesesRequest.getNumCodContrato());
				}
			}
		} catch (Exception e) {
			newContratos60Meses.setId(0);
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return newContratos60Meses.getId() == 0
				? new ResponseEntity<>(
						new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
								"Hay un error en el procesamiento de la data de 60 meses"),
						HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);

	}
}
