package com.vatia.apirest.service;

import java.util.List;

import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.CondicionTipoContrato;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.NegociacionesContratos;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.vatia.apirest.utils.CantidadRequest;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.utils.FechasPagosRequest;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;

public interface ContratoService {

	public List<TiposMercados> getAllTipoMercado();

	public List<TiposContratos> getAllTipoContrato();

	public List<ModalidadesContratos> getAllModalidadContrato();

	public List<TiposGarantias> getAllTipoGarantia();

	public List<TiposCantidad> getAllTipoCantidad();

	public List<TiposPrecio> getAllTipoPrecio();

	public List<FormulasPrecios> getAllFormulaPrecio();

	public List<CondicionTipoContrato> getAllCTipoContrato();

	public List<NegociacionesContratos> getAllNegocioContrato();

	public AgentesComerciales getAllSicAgenteComercial(String valor);

	public SaveResponse saveContrato(ContratosRequest contratosRequest, List<CantidadRequest> listCantidadRequest,
			List<FechasPagosRequest> listFechaPagosRequest);

}
