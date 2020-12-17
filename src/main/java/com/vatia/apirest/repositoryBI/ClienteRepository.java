package com.vatia.apirest.repositoryBI;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.modelBI.Cliente;
import com.vatia.apirest.pkBI.ClientePk;

public interface ClienteRepository extends CrudRepository<Cliente,ClientePk> {

	public List<Cliente> findByNombreFacturacionLikeOrderByNombreFacturacionAsc(String nombreLike);
	
	@Query(value = "SELECT ID_CLIENTE,NOMBRE_FACTURACION,FECHA_ESTADO_HIS_MER" + 
			"  FROM STG_TRADEBALANCE.dbo.STG_DIM_CLIENTE " + 
			"  where NOMBRE_FACTURACION like :nombre " + 
			"  group by ID_CLIENTE,NOMBRE_FACTURACION,FECHA_ESTADO_HIS_MER order by NOMBRE_FACTURACION ASC", nativeQuery = true)
	List<Object> nativeFindByLikeCliente(@Param("nombre") String nombreLike);
}
