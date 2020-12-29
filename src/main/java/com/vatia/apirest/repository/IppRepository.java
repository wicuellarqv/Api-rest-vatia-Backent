package com.vatia.apirest.repository;

import java.math.BigDecimal;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vatia.apirest.model.Ipp;

import net.minidev.json.JSONObject;

public interface IppRepository extends JpaRepository<Ipp, Integer> {

	@Query(value = "SELECT * FROM IPP I WHERE I.ANIO BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Ipp> getAllAnio(Integer desde, Integer hasta);

	@Query(value = "SELECT * FROM IPP I WHERE I.ANIO = ?1 ORDER BY ANIO ASC", nativeQuery = true)
	Ipp getIppAnio(Integer anio);
	
	@Query(value = "SELECT * FROM IPP I WHERE I.ANIO = ?1 ORDER BY ANIO ASC", nativeQuery = true)
	JSONObject getIppAnioMes(Integer anio);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE IPP SET FUENTE = :fuente,INDICE = :input_promedio,"
			+ "MES1 = CASE WHEN :mes=1 THEN :ipp ELSE MES1 END," + "MES2 = CASE WHEN :mes=2 THEN :ipp ELSE MES2 END,"
			+ "MES3 = CASE WHEN :mes=3 THEN :ipp ELSE MES3 END," + "MES4 = CASE WHEN :mes=4 THEN :ipp ELSE MES4 END,"
			+ "MES5 = CASE WHEN :mes=5 THEN :ipp ELSE MES5 END," + "MES6 = CASE WHEN :mes=6 THEN :ipp ELSE MES6 END,"
			+ "MES7 = CASE WHEN :mes=7 THEN :ipp ELSE MES7 END," + "MES8 = CASE WHEN :mes=8 THEN :ipp ELSE MES8 END,"
			+ "MES9 = CASE WHEN :mes=9 THEN :ipp ELSE MES9 END," + "MES10 = CASE WHEN :mes=10 THEN :ipp ELSE MES10 END,"
			+ "MES11 = CASE WHEN :mes=11 THEN :ipp ELSE MES11 END,"
			+ "MES12 = CASE WHEN :mes=12 THEN :ipp ELSE MES12 END " + "WHERE ANIO = :anio", nativeQuery = true)

	int updateIpp(@Param(value = "fuente") Integer fuente, @Param(value = "input_promedio") BigDecimal input_promedio,
			@Param(value = "ipp") float ipc, @Param(value = "anio") int anio, @Param(value = "mes") int mes);

	@Query(value = "SELECT (AVG(VAR)*IPC.INDICE)/100 FROM  "
			+ "(SELECT (P.MES12/C.MES12) * 100 AS VAR FROM VARIPC C, VARIPP P WHERE C.ANIO = ?2 AND P.ANIO =  ?2 "
			+ "UNION "
			+ "SELECT (P.MES12/C.MES12) * 100 AS VAR FROM VARIPC C, VARIPP P WHERE C.ANIO = ?3 AND P.ANIO =  ?3 "
			+ "UNION "
			+ "SELECT (P.MES12/C.MES12) * 100 AS VAR FROM VARIPC C, VARIPP P WHERE C.ANIO = ?4 AND P.ANIO =  ?4 "
			+ "UNION "
			+ "SELECT (P.MES12/C.MES12) * 100 AS VAR FROM VARIPC C, VARIPP P WHERE C.ANIO = ?5 AND P.ANIO =  ?5 "
			+ "UNION "
			+ "SELECT (P.MES12/C.MES12) * 100 AS VAR FROM VARIPC C, VARIPP P WHERE C.ANIO = ?6 AND P.ANIO =  ?6) AS VARIACION, "
			+ "IPC WHERE IPC.ANIO = ?1 GROUP BY INDICE", nativeQuery = true)
	float getIndice(int anioActual, int anioProm1, int anioProm2, int anioProm3, int anioProm4, int anioProm5);

}
