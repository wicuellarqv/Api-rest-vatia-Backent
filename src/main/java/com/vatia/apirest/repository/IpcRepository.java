package com.vatia.apirest.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.model.Ipc;

public interface IpcRepository extends JpaRepository<Ipc, Integer> {

	@Query(value = "SELECT * FROM IPC I WHERE I.ANIO BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Ipc> getAllAnio(Integer desde, Integer hasta);
	
	@Query(value = "SELECT * FROM IPC I WHERE I.ANIO = ?1 ORDER BY ANIO ASC", nativeQuery = true)
	Ipc getIpcAnio(Integer anio);

	
	@Modifying
	@Transactional
	@Query(value = "UPDATE IPC SET FUENTE = :fuente,INDICE = :variacion,"+
			        "MES1 = CASE WHEN :mes=1 THEN :ipc ELSE MES1 END," + 
					"MES2 = CASE WHEN :mes=2 THEN :ipc ELSE MES2 END," + 
					"MES3 = CASE WHEN :mes=3 THEN :ipc ELSE MES3 END," + 
					"MES4 = CASE WHEN :mes=4 THEN :ipc ELSE MES4 END," + 
					"MES5 = CASE WHEN :mes=5 THEN :ipc ELSE MES5 END," + 
					"MES6 = CASE WHEN :mes=6 THEN :ipc ELSE MES6 END," + 
					"MES7 = CASE WHEN :mes=7 THEN :ipc ELSE MES7 END," + 
					"MES8 = CASE WHEN :mes=8 THEN :ipc ELSE MES8 END," + 
					"MES9 = CASE WHEN :mes=9 THEN :ipc ELSE MES9 END," + 
					"MES10 = CASE WHEN :mes=10 THEN :ipc ELSE MES10 END," + 
					"MES11 = CASE WHEN :mes=11 THEN :ipc ELSE MES11 END," + 
					"MES12 = CASE WHEN :mes=12 THEN :ipc ELSE MES12 END " +
					"WHERE ANIO = :anio",
	nativeQuery = true)	
	int updateIpc(@Param(value = "fuente") Integer fuente,@Param(value = "variacion") float variacion, @Param(value = "ipc") float ipc, @Param(value = "anio") int anio, @Param(value = "mes") int mes);


	@Modifying
	@Transactional
	@Query(value = "UPDATE IPC SET FUENTE = :fuente, INDICE = :variacion "+	
				   "WHERE ANIO = :anio",				   
	nativeQuery = true)	
	int updateIpcVariacion(@Param(value = "fuente") Integer fuente,@Param(value = "variacion") float variacion, @Param(value = "anio") int anio);
	
}
