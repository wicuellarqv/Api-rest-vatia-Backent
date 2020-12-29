package com.vatia.apirest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.model.EstadosCliente;

public interface EstadosCliRepository extends CrudRepository<EstadosCliente, Long>{

	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "update webapp_tradebalance.dbo.tbl_estados_cliente set nombre =:newName where id =:id ", nativeQuery = true)
	public void updateEstadosClienteNative(@Param("newName") String newName, @Param("id") Long id);
}
