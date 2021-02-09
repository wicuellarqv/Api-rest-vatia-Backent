package com.vatia.apirest.repositoryBI;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.modelBI.Cliente;
import com.vatia.apirest.pkBI.ClientePk;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, ClientePk> {

	public List<Cliente> findByNombreFacturacionLikeOrderByNombreFacturacionAsc(String nombreLike);

	@Query(value = "SELECT ID_CLIENTE,NOMBRE_FACTURACION,FECHA_ESTADO_HIS_MER"
			+ "  FROM STG_TRADEBALANCE.dbo.STG_DIM_CLIENTE " + "  where NOMBRE_FACTURACION like :nombre "
			+ "  group by ID_CLIENTE,NOMBRE_FACTURACION,FECHA_ESTADO_HIS_MER order by NOMBRE_FACTURACION ASC", nativeQuery = true)
	public List<Object> nativeFindByLikeClienteNombreFacturacion(@Param("nombre") String nombreLike);

	@Query(value = "SELECT ID_CLIENTE,NOMBRE_FACTURACION,FECHA_ESTADO_HIS_MER  "
			+ "			  FROM STG_TRADEBALANCE.dbo.STG_DIM_CLIENTE   "
			+ "			  where NOMBRE_RAZON_SOCIAL like :razon   "
			+ "			  group by ID_CLIENTE,NOMBRE_FACTURACION,FECHA_ESTADO_HIS_MER order by NOMBRE_FACTURACION ASC", nativeQuery = true)
	public List<Object> nativeFindByLikeClienteRazonSocial(@Param("razon") String razon);

	@Query(value = "SELECT DISTINCT CATEGORIA_CLIENTE  "
			+ "			  FROM STG_TRADEBALANCE.dbo.STG_DIM_CLIENTE WHERE CATEGORIA_CLIENTE IS NOT NULL", nativeQuery = true)
	public List<Object> nativeCategoriasCliente();

	public List<Cliente> findByIdCliente(String id);

	@Query(value = "SELECT * FROM STG_TRADEBALANCE.dbo.STG_DIM_CLIENTE   "
			+ "			  where NOMBRE_RAZON_SOCIAL like :razon   "
			+ "			  order by NOMBRE_FACTURACION ASC", nativeQuery = true)
	public Page<Cliente> nativeFindByLikeClienteRazonPage(Pageable page, @Param("razon") String razon);

	@Query(value = "SELECT * FROM STG_TRADEBALANCE.dbo.STG_DIM_CLIENTE   "
			+ "			  where CATEGORIA_CLIENTE like :categoria   "
			+ "			  order by NOMBRE_FACTURACION ASC", nativeQuery = true)
	public Page<Cliente> nativeFindByLikeClienteCatPage(Pageable page, @Param("categoria") String categoria);

	@Query(value = "SELECT * FROM STG_TRADEBALANCE.dbo.STG_DIM_CLIENTE   "
			+ "			  where CATEGORIA_CLIENTE like :categoria and   "
			+ "			  NOMBRE_RAZON_SOCIAL like :razon   "
			+ "			  order by NOMBRE_FACTURACION ASC", nativeQuery = true)
	public Page<Cliente> nativeFindByLikeClienteCatAndRazPage(Pageable page, @Param("categoria") String categoria,
			@Param("razon") String razon);
}
