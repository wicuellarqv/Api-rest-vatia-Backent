package com.vatia.apirest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatia.apirest.model.Categoria;
import com.vatia.apirest.model.CategoriaCliente;
import com.vatia.apirest.repository.CategoriaClienteRepository;
import com.vatia.apirest.repository.CategoriaRepository;
import com.vatia.apirest.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaClienteRepository categoriaClienteRepository;
	
	@Override
	public Categoria saveCategoria(Categoria categoria) {
			Categoria newCategoria = new Categoria();
		try {
			newCategoria.setNombre(categoria.getNombre());
			newCategoria.setCreateAt(new Date());
			Categoria returnCategoria = new Categoria();
			returnCategoria = categoriaRepository.save(newCategoria);
			return returnCategoria;
		} catch (Exception e) {
			newCategoria.setId(0);
			System.out.println(e.toString());
			return newCategoria;
		}
	}

	@Override
	public Boolean deleteCategoria(Categoria categoria) {
		Boolean status = true;
		try {
			categoriaRepository.deleteById(categoria.getId());
			return status;
		} catch (Exception e) {
			System.out.println(e.toString());
			status = false;
			return status;
		}
		
	}

	@Override
	public Boolean updateCategoria(Categoria categoria) {
		Boolean status = true;
		try {
			categoriaRepository.updateCategoriaNative(categoria.getNombre(),categoria.getId());
			return status;
		} catch (Exception e) {
			System.out.println(e.toString());
			status = false;
			return status;
		}
	}

	@Override
	public List<Categoria> getAllCategorias() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			categorias = (List<Categoria>) categoriaRepository.findAll();
			return categorias;
		} catch (Exception e) {
			System.out.println(e.toString());
			return categorias;
		}
	}

	@Override
	public CategoriaCliente saveCategoriaCliente(CategoriaCliente categoriaCliente) {
		CategoriaCliente newCategoriaCli = new CategoriaCliente();
		try {
			newCategoriaCli.setCategoria(categoriaCliente.getCategoria());
			newCategoriaCli.setFechaPresupuesto(categoriaCliente.getFechaPresupuesto());
			newCategoriaCli.setIdCliente(categoriaCliente.getIdCliente());
			newCategoriaCli.setNombreCliente(categoriaCliente.getNombreCliente());
			CategoriaCliente returnCategoriaCli = new CategoriaCliente();
			returnCategoriaCli = categoriaClienteRepository.save(newCategoriaCli);
			return returnCategoriaCli;
		} catch (Exception e) {
			newCategoriaCli.setId(0);
			System.out.println(e.toString());
			return newCategoriaCli;
		}
	}

	@Override
	public Boolean deleteCategoriaCliente(CategoriaCliente categoriaCliente) {
		Boolean status = true;
		try {
			categoriaClienteRepository.deleteById(categoriaCliente.getId());
			return status;
		} catch (Exception e) {
			System.out.println(e.toString());
			status = false;
			return status;
		}
	}

	@Override
	public List<CategoriaCliente> getAllCategoriasClientes() {
		List<CategoriaCliente> categoriasCli = new ArrayList<CategoriaCliente>();
		try {
			categoriasCli = (List<CategoriaCliente>) categoriaClienteRepository.findAll();
			return categoriasCli;
		} catch (Exception e) {
			System.out.println(e.toString());
			return categoriasCli;
		}
	}
}
