package com.vatia.apirest.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vatia.apirest.modelBI.Capains;
import com.vatia.apirest.modelBI.Cliente;
import com.vatia.apirest.service.BIService;
import com.vatia.apirest.response.ResponseCheck;
import com.vatia.apirest.response.ResponseHTTP;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("v1/Bi")
public class BIController {

	@Autowired
	private BIService biService;

	@GetMapping("/getAllClientes")
	public ResponseEntity<ResponseHTTP> getAllClientes() {
		List<Cliente> clientes = new ArrayList<>();

		try {
			clientes = biService.getAllClientes();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return clientes.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), clientes), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), clientes), HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/get_categorias_cliente")
	public ResponseEntity<ResponseHTTP> getCategoriasCliente() {
		List<Object> categorias = new ArrayList<>();

		try {
			categorias = biService.getCagoriasCliente();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return categorias.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), categorias), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), categorias), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/get_clientes_by_id")
	public ResponseEntity<ResponseHTTP> getClienteById(@RequestBody Cliente cliente) {
		List<Cliente> clientes = new ArrayList<>();

		try {
			clientes = biService.getClienteById(cliente.getIdCliente());
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return clientes.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), clientes), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), clientes), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/get_clientes_by_razon_social")
	public ResponseEntity<ResponseHTTP> getLikeClientesByRazonSocial(@RequestBody Cliente cliente) {
		List<Object> clientes = new ArrayList<>();

		try {
			clientes = biService.getLikeClientesByRazonSocial(cliente.getNombreRazonSocial());
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return clientes.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), clientes), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), clientes), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/get_clientes_by_razon_page")
	public ResponseEntity<ResponseHTTP> getLikeClientesByRazPage(@RequestBody clientePageRequest clientePage) {
		try {
			Page<Cliente> clientes = biService.getLikeClientesByRazonPage(clientePage.getPage()-1, clientePage.getSize(),
					clientePage.cliente.getNombreRazonSocial());
			return ResponseCheck._pageable(clientes, clientes.getTotalElements());
		} catch (Exception e) {
			System.out.println("Error getInfoStage: " + e.toString());
			return ResponseCheck._error(e);
		}

	}

	@PostMapping("/get_clientes_by_categoria_page")
	public ResponseEntity<ResponseHTTP> getLikeClientesByCatPage(@RequestBody clientePageRequest clientePage) {

		try {
			Page<Cliente> clientes = biService.getLikeClientesByCategoriaPage(clientePage.getPage()-1, clientePage.getSize(),
					clientePage.cliente.getCategoria());
			return ResponseCheck._pageable(clientes, clientes.getTotalElements());
		} catch (Exception e) {
			System.out.println("Error getInfoStage: " + e.toString());
			return ResponseCheck._error(e);
		}

	}

	@PostMapping("/get_clientes_by_cat_raz_page")
	public ResponseEntity<ResponseHTTP> getLikeClientesByCataAndRazPage(@RequestBody clientePageRequest clientePage) {
		try {
			Page<Cliente> clientes = biService.getLikeClientesByCatAndRazPage(clientePage.getPage()-1, clientePage.getSize(),
					clientePage.cliente.getCategoria(), clientePage.cliente.getNombreRazonSocial());
			return ResponseCheck._pageable(clientes, clientes.getTotalElements());
		} catch (Exception e) {
			System.out.println("Error getInfoStage: " + e.toString());
			return ResponseCheck._error(e);
		}

	}
	
	
	@PostMapping("/get_plantas_like")
	public ResponseEntity<ResponseHTTP> getLikePlantas(@RequestBody Capains capains) {
		List<Capains> plantas = new ArrayList<>();

		try {
			plantas = biService.getPlantasLike(capains.getPlanta());
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return plantas.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), plantas), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), plantas), HttpStatus.NOT_FOUND);

	}
	
	static class clientePageRequest implements Serializable {
		private static final long serialVersionUID = 1L;
		private int page;
		private int size;
		private Cliente cliente;

		public clientePageRequest() {
		}

		public clientePageRequest(int page, int size, Cliente cliente) {
			super();
			this.page = page;
			this.size = size;
			this.cliente = cliente;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		};

	}
}
