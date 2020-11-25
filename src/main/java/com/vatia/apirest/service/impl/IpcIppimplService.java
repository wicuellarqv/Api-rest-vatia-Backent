package com.vatia.apirest.service.impl;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatia.apirest.service.IpcIppService;

import net.minidev.json.JSONObject;

@Service
public class IpcIppimplService implements IpcIppService{

	@Autowired
	private IpcServiceImpl ipcServiceImpl;
	@Autowired
	private IppServiceImpl ippServiceImpl;

	public void updateIpcIpp(Map<String, Object> request) {

		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject(request);
		float ipc=0;
		int anoV=0;
		int anio =0;
		int _int_mes =0;
		Integer fuente = Integer.parseInt(obj.get("fuente").toString());
		float variacion = Float.parseFloat(obj.get("variacion").toString());
		
		if (obj.get("ipc").toString() != "") {
			ipc = Float.parseFloat(obj.get("ipc").toString());
		}else {
			ipc = 0;
		}

		if (obj.get("anoV").toString() != "") {
			anoV = Integer.parseInt(obj.get("anoV").toString());
		}else {
			anoV = 0;
		}
		
		if (obj.get("mes") != null) {
			_int_mes = Integer.parseInt(obj.get("mes").toString());
		}else {
			_int_mes = 0;
		}
		
		if ( obj.get("anio") != null) {
			anio = Integer.parseInt(obj.get("anio").toString());
		}else {
			anio = 0;
		}

		this.ipcServiceImpl.updateIpc(fuente, variacion, ipc, anio, _int_mes, anoV);

		if (obj.get("ipp").toString() != "") {
			float ipp = Float.parseFloat(obj.get("ipp").toString());
			this.ippServiceImpl.updateIpp(fuente, ipp, anio, _int_mes);
		}

		//Date mDate = new Date(System.currentTimeMillis());
		//int _int_mes = mDate.getMonth() + 1;
		

		
	}

}
