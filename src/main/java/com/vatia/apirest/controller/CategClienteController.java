package com.vatia.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vatia.apirest.model.Categoria;
import com.vatia.apirest.model.CategoriaCliente;
import com.vatia.apirest.response.ResponseHTTP;
import com.vatia.apirest.service.CategoriaService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("v1/categorizacion_clientes")
public class CategClienteController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categoria")
	public ResponseEntity<ResponseHTTP> getAllCategorias() {
		List<Categoria> categorias = new ArrayList<>();

		try {
			categorias = categoriaService.getAllCategorias();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return categorias.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), categorias), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), categorias), HttpStatus.NOT_FOUND);

	}
	
	@PostMapping("/categoria_by_tipo")
	public ResponseEntity<ResponseHTTP> getCategoriasByTipo(@RequestBody Categoria categoria) {
		List<Categoria> categorias = new ArrayList<>();

		try {
			categorias = categoriaService.getCategoriasByTipo(categoria);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return categorias.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), categorias), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), categorias), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/categoria")
	public ResponseEntity<ResponseHTTP> createCategoria(@RequestBody Categoria categoria) {
		Categoria ResponseCategoria = new Categoria();

		try {
			ResponseCategoria = categoriaService.saveCategoria(categoria);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseCategoria.getId() == 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la creacion de la categoria"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), ResponseCategoria), HttpStatus.OK);

	}
	
	@DeleteMapping("/categoria")
	public ResponseEntity<ResponseHTTP> deleteCategoria(@RequestBody Categoria categoria) {
		Boolean status = true;
		try {
			status = categoriaService.deleteCategoria(categoria);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return !status
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la eliminacion de la categoria"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
	}
	
	@PutMapping("/categoria")
	public ResponseEntity<ResponseHTTP> updateCategproa(@RequestBody Categoria categoria) {
			Boolean status = true;
		try {
			status = categoriaService.updateCategoria(categoria);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return !status
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la actualizacion de la categoria"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
	}
	
	@GetMapping("/categorias_clientes")
	public ResponseEntity<ResponseHTTP> getAllCategoriasCli() {
		List<CategoriaCliente> categoriasCli = new ArrayList<>();

		try {
			categoriasCli = categoriaService.getAllCategoriasClientes();
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return categoriasCli.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), categoriasCli), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), categoriasCli), HttpStatus.NOT_FOUND);

	}
	
	@PostMapping("/categorias_clientes_by_tipo_cat")
	public ResponseEntity<ResponseHTTP> getCategoriasCliByTipoCateg(@RequestBody Categoria categoria) {
		List<CategoriaCliente> categoriasCli = new ArrayList<>();

		try {
			categoriasCli = categoriaService.getCategCliByTipoCategoria(categoria.getTipo());
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return categoriasCli.size() > 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), categoriasCli), HttpStatus.OK)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), categoriasCli), HttpStatus.NOT_FOUND);

	}
	
	@PostMapping("/categorias_clientes")
	public ResponseEntity<ResponseHTTP> createCategoriaCli(@RequestBody List<CategoriaCliente> ListCategoriaCliente) {
		List<CategoriaCliente> responseCategoriaCliList =  new ArrayList<CategoriaCliente>();
		try {
			if(ListCategoriaCliente.size() > 0) {
				for (CategoriaCliente categoriaCliRequest : ListCategoriaCliente) {
					responseCategoriaCliList.add(categoriaService.saveCategoriaCliente(categoriaCliRequest));
				}
			}else {
				return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Esta enviado una lista vacia"), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseCategoriaCliList.size() == 0
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la creacion de la categoria cliente"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), responseCategoriaCliList), HttpStatus.OK);

	}
	
	@DeleteMapping("/categorias_clientes")
	public ResponseEntity<ResponseHTTP> deleteCategoriaCli(@RequestBody CategoriaCliente categoriaCliente) {
		Boolean status = true;
		try {
			status = categoriaService.deleteCategoriaCliente(categoriaCliente);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return !status
				? new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Hay un error en la eliminacion de la categoria cliente"), HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), null), HttpStatus.OK);
	}
}
