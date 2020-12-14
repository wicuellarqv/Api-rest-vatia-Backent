package com.vatia.apirest.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ResponseHTTP implements Serializable {
	private int status;
	private Object response;
	
	public ResponseHTTP() {
		
	}
	
	public ResponseHTTP(int status, Object response) {
		super();
		this.status = status;
		this.response = response;
	}
		
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}


	private static final long serialVersionUID = 1L;
}
