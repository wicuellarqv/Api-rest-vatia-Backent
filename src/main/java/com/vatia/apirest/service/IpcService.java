package com.vatia.apirest.service;

import java.util.List;
import java.util.Map;

import com.vatia.apirest.model.Ipc;

public interface IpcService {
	public List<Ipc> findAll();
	
	public List<Ipc> findAllAnio(Integer desde, Integer hasta);
	
	public Ipc findIpcAnio(Integer anio);

	public void save(Ipc ipc);

	public void deleteById(Integer id);

	public void updateIpc(Integer fuente, float variacion, float ipc, int anio, int _int_mes, int anoV);
	
}
