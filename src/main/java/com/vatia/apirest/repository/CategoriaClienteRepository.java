package com.vatia.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.model.CategoriaCliente;

public interface CategoriaClienteRepository extends CrudRepository<CategoriaCliente, Integer> {

	@Query(value = "SELECT cc.id" + 
			"      ,fecha_presupuesto" + 
			"      ,id_cliente" + 
			"      ,nom_cliente" + 
			"      ,categoria" + 
			"  FROM dbo.tbl_categoria_cliente cc " + 
			"  inner join dbo.tbl_categorias c " + 
			"  on cc.categoria = c.id" + 
			"  where c.tipo =:tipo", nativeQuery = true)
	public List<CategoriaCliente> nativeFindCategCliByTipoCategoria(@Param("tipo") Integer tipo);
}
