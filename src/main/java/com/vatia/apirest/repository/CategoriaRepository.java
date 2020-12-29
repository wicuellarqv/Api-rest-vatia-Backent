package com.vatia.apirest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	public Categoria findById(int id);
	
	public List<Categoria> findByTipo(Integer tipo);
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "update webapp_tradebalance.dbo.tbl_categorias set nombre =:newName where id =:id ", nativeQuery = true)
	public void updateCategoriaNative(@Param("newName") String newName, @Param("id") Long id);
}
