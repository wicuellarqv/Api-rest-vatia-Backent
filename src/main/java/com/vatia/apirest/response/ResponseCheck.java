package com.vatia.apirest.response;

//import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import com.google.gson.JsonObject;

public class ResponseCheck {
	public static ResponseEntity<ResponseHTTP> _pageable(Object obj, Long size) {
		/** Verifica tamaño de la lista para dar respuesta */
		try {
			return size > 0L 
					? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), obj), HttpStatus.OK)
					: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return _error(e);
		}
	}
	
	public static ResponseEntity<ResponseHTTP> _object(Object obj){
		/** Verifica objeto para dar respuesta */
		try {			
			return obj == null
					? new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND)
					: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), obj), HttpStatus.OK);
		} catch (Exception e) {
			return _error(e);
		}

	}

	public static ResponseEntity<ResponseHTTP> _list(Object obj, Integer size) {
		/** Verifica tamaño de la lista para dar respuesta */
		try {
			return size > 0 
					? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), obj), HttpStatus.OK)
					: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return _error(e);
		}
	}
	
	public static ResponseEntity<ResponseHTTP> _delete(Boolean del) {
		/** Verifica tipo de respuesta */
		try {
			return del 
					? new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), !del), HttpStatus.NOT_FOUND)
					: new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), !del), HttpStatus.OK);
		} catch (Exception e) {
			return _error(e);
		}
	}
	
	public static ResponseEntity<ResponseHTTP> _queryTrans(Integer rpt) {
		/** Verifica actualizacion */
		try {
			return rpt > 0
					? new ResponseEntity<>(new ResponseHTTP(HttpStatus.OK.value(), rpt), HttpStatus.OK)
					: new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), rpt), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return _error(e);
		}
	}
	
//	public static ResponseEntity<String> _jsonObject(List<JsonObject> rpt) {
//		/** Verifica actualizacion */
//		try {
//			return rpt.size() > 0
//					? new ResponseEntity<>(rpt.toString(), HttpStatus.OK)
//					: new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			return _errorString(e);
//		}
//	}

	public static ResponseEntity<ResponseHTTP> _error(Exception e) {
		/** Responde estatus unicamente */
		System.err.println("Error: " + e.toString());
		return new ResponseEntity<>(new ResponseHTTP(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<String> _errorString(Exception e) {
		/** Responde estatus unicamente */
		System.err.println("Error: " + e.toString());
		return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<ResponseHTTP> _anyResponse(HttpStatus httpStatus) {
		/** Responde estatus unicamente */
		return new ResponseEntity<>(new ResponseHTTP(httpStatus.value(), null), httpStatus);
	}
}
