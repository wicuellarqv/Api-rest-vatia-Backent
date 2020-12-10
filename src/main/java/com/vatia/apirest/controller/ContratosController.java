package com.vatia.apirest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.vatia.apirest.model.EntregasGarantias;
import com.vatia.apirest.model.FechasCorteContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.service.ContratoService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/Contrato")
public class ContratosController {

	@Autowired
	private ContratoService contratoService;
	
	@GetMapping("/getAllTipoMercado")
	public List<TiposMercados> getAllTipoMercado() {
		return contratoService.getAllTipoMercado();
	}
	
	@GetMapping("/getAllTipoContrato")
	public List<TiposContratos> getAllTipoContrato() {
		return contratoService.getAllTipoContrato();
	}
	
	@GetMapping("/getAllModalidadContrato")
	public List<ModalidadesContratos> getAllModalidadContrato() {
		return contratoService.getAllModalidadContrato();
	}
		
	@GetMapping("/getAllTipoGarantia")
	public List<TiposGarantias> getAllTipoGarantia() {
		return contratoService.getAllTipoGarantia();
	}
	
	@GetMapping("/getAllEntregaGarantia")
	public List<EntregasGarantias> getAllEntregaGarantia() {
		return contratoService.getAllEntregaGarantia();
	}
	
	@GetMapping("/getAllTipoCantidad")
	public List<TiposCantidad> getAllTipoCantidad() {
		return contratoService.getAllTipoCantidad();
	}

	@GetMapping("/getAllTipoPrecio")
	public List<TiposPrecio> getAllTipoPrecio() {
		return contratoService.getAllTipoPrecio();
	}

	@GetMapping("/getAllSicAgenteComercial")
	public AgentesComerciales getAllSicAgenteComercial(@RequestParam String valor) {
		return contratoService.getAllSicAgenteComercial(valor);
	}
	
	@GetMapping("/getAllFechaCorte")
	public List<FechasCorteContratos> getAllFechaCorte() {
		return contratoService.getAllFechaCorte();
	}	
	
	@GetMapping("/getAllFormulaPrecio")
	public List<FormulasPrecios> getAllFormulaPrecio() {
		return contratoService.getAllFormulaPrecio();
	}
	
	@PostMapping("/saveContrato")
	public void updateContrato(@RequestBody Map<String, Object> request) {
		this.contratoService.saveContrato(request);
	}
	
}
