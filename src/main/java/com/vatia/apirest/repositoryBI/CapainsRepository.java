package com.vatia.apirest.repositoryBI;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.modelBI.Capains;
import com.vatia.apirest.modelBI.Cliente;
import com.vatia.apirest.pkBI.ClientePk;

public interface CapainsRepository extends CrudRepository<Capains, String> {

	@Query(value = "SELECT PLANTA, AGENTE, NOMBRE" + 
			"  FROM STG_TRADEBALANCE.dbo.STG_CAPAINS " + 
			"  where NOMBRE like :nombre order by NOMBRE", nativeQuery = true)
	public List<Object> nativeFindLikePlantaByNombre(@Param("nombre") String nombreLike);
	
	@Query(value = "SELECT *" + 
			"  FROM STG_TRADEBALANCE.dbo.STG_CAPAINS " + 
			"  where PLANTA like :planta order by NOMBRE", nativeQuery = true)
	public List<Capains> nativeFindLikeByPlanta(@Param("planta") String planta);

}
