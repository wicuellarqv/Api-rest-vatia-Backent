package com.vatia.apirest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vatia.apirest.model.VarIpc;

import net.minidev.json.JSONObject;

public interface VarIpcRepository extends JpaRepository<VarIpc, Integer> {
	
	@Query(value = "SELECT * FROM VARIPC I WHERE I.ANIO BETWEEN ?1 AND ?2", nativeQuery = true)
	List<VarIpc> getAllAnio(Integer desde, Integer hasta);

	@Query(value = "SELECT * FROM VARIPC I WHERE I.ANIO = ?1 ORDER BY ANIO ASC", nativeQuery = true)
	VarIpc getVarIpcAnio(Integer anio);  
	
	@Query(value = 
			"SELECT " + 
			"?2 AS ANIO," + 
			"((SUM(N1)-SUM(A1))/SUM(A1))*100 AS MES1," + 
			"((SUM(N2)-SUM(A2))/SUM(A2))*100 AS MES2," + 
			"((SUM(N3)-SUM(A3))/SUM(A3))*100 AS MES3," + 
			"((SUM(N4)-SUM(A4))/SUM(A4))*100 AS MES4," +  
			"((SUM(N5)-SUM(A5))/SUM(A5))*100 AS MES5," + 
			"((SUM(N6)-SUM(A6))/SUM(A6))*100 AS MES6," + 
			"((SUM(N7)-SUM(A7))/SUM(A7))*100 AS MES7," + 
			"((SUM(N8)-SUM(A8))/SUM(A8))*100 AS MES8," + 
			"((SUM(N9)-SUM(A9))/SUM(A9))*100 AS MES9," + 
			"((SUM(N10)-SUM(A10))/SUM(A10))*100 AS MES10," + 
			"((SUM(N11)-SUM(A11))/SUM(A10))*100 AS MES11," + 
			"((SUM(N12)-SUM(A12))/SUM(A12))*100 AS MES12 " + 
			"FROM " + 
			"(SELECT MES1 AS A1,MES2 AS A2,MES3 AS A3,MES4 AS A4,MES5 AS A5,MES6 AS A6,MES7 AS A7,MES8 AS A8,MES9 AS A9,MES10 AS A10,MES11 AS A11,MES12 AS A12," + 
			"0 AS N1,0 AS N2,0 AS N3,0 AS N4,0 AS N5,0 AS N6,0 AS N7,0 AS N8,0 AS N9,0 AS N10,0 AS N11,0 AS N12 " + 
			"FROM IPC WHERE ANIO = ?1 " + 
			"UNION " + 
			"SELECT " + 
			"0 AS A1,0 AS A2,0 AS A3,0 AS A4,0 AS A5,0 AS A6,0 AS A7,0 AS A8,0 AS A9,0 AS A10,0 AS A11,0 AS A12," + 
			"MES1 AS N1,MES2 AS N2,MES3 AS N3,MES4 AS N4,MES5 AS N5,MES6 AS N6,MES7 AS N7,MES8 AS N8,MES9 AS N9,MES10 AS N10,MES11 AS N11,MES12 AS N12 " + 
			"FROM IPC WHERE ANIO = ?2) V"
			, nativeQuery = true)
	JSONObject getVariacionIpcAnio(Integer anioAnterior,Integer anioActual);
}
