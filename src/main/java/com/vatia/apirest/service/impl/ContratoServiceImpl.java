package com.vatia.apirest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.Contratos;
import com.vatia.apirest.model.FechasCorteContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.repository.ModalidadContratoRepository;
import com.vatia.apirest.repository.TipoCantidadRepository;
import com.vatia.apirest.repository.TipoContratoRepository;
import com.vatia.apirest.repository.TipoGarantiasRepository;
import com.vatia.apirest.repository.TiposMercadosRepository;
import com.vatia.apirest.service.ContratoService;

import net.minidev.json.JSONObject;

@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratosRepository ContratosRepository;

	@Autowired
	private TiposMercadosRepository tiposMercadosRepository;

	@Autowired
	private TipoContratoRepository tipoContratoRepository;

	@Autowired
	private ModalidadContratoRepository modalidadContratoRepository;

	@Autowired
	private TipoGarantiasRepository tipoGarantiasRepository;

	@Autowired
	private TipoCantidadRepository tipoCantidadRepository;

	@Autowired
	private TipoPrecioRepository tipoPrecioRepository;

	@Autowired
	private AgenteComercialRepository agenteComercialRepository;

	@Autowired
	private FechaCorteRepository fechaCorteRepository;

	@Autowired
	private FormulaPrecioRepository formulaPrecioRepository;

	@Override
	public List<TiposMercados> getAllTipoMercado() {
		// TODO Auto-generated method stub
		return this.tiposMercadosRepository.findAll();
	}

	@Override
	public List<TiposContratos> getAllTipoContrato() {
		// TODO Auto-generated method stub
		return this.tipoContratoRepository.findAll();
	}

	@Override
	public List<ModalidadesContratos> getAllModalidadContrato() {
		// TODO Auto-generated method stub
		return this.modalidadContratoRepository.findAll();
	}

	@Override
	public List<TiposGarantias> getAllTipoGarantia() {
		// TODO Auto-generated method stub
		return this.tipoGarantiasRepository.findAll();
	}

	@Override
	public List<TiposCantidad> getAllTipoCantidad() {
		// TODO Auto-generated method stub
		return this.tipoCantidadRepository.findAll();
	}

	@Override
	public List<TiposPrecio> getAllTipoPrecio() {
		// TODO Auto-generated method stub
		return this.tipoPrecioRepository.findAll();
	}

	@Override
	public List<FechasCorteContratos> getAllFechaCorte() {
		// TODO Auto-generated method stub
		return this.fechaCorteRepository.findAll();
	}

	@Override
	public List<FormulasPrecios> getAllFormulaPrecio() {
		// TODO Auto-generated method stub
		return this.formulaPrecioRepository.findAll();
	}

	@Override
	public AgentesComerciales getAllSicAgenteComercial(String valor) {
		// TODO Auto-generated method stub
		return this.agenteComercialRepository.findAllCod(valor);
	}

	public SaveResponse saveContrato(Map<String, Object> request) {

		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject(request);
		Contratos ContratosList = new Contratos();
		SaveResponse saveResponse = new SaveResponse();

		try {

			// Set de campos basicos en la tabla de contratos
			if (obj.get("TipodeMercado").toString() != "") {
				ContratosList.setIdTipoMercado(Integer.parseInt(obj.get("TipodeMercado").toString()));
			}
			if (obj.get("estadoContrato").toString() != "") {
				ContratosList.setEstadoContrato(obj.get("estadoContrato").toString());
			}
			if (obj.get("TipodeContrato").toString() != "") {
				ContratosList.setIdTipoContrato(Integer.parseInt(obj.get("TipodeContrato").toString()));
			}
			if (obj.get("Modalidaddelcontrato").toString() != "") {
				ContratosList.setIdModalidadContrato(Integer.parseInt(obj.get("Modalidaddelcontrato").toString()));
			}
			if (obj.get("fechadeinicioContrato").toString() != "") {
				ContratosList.setFecPeriodoInicio(obj.get("fechadeinicioContrato").toString());
			}
			if (obj.get("fechadefinContrato").toString() != "") {
				ContratosList.setFecPeriodoFin(obj.get("fechadefinContrato").toString());
			}
			if (obj.get("fechaCorte").toString() != "") {
				ContratosList.setIdFechaCorte(Integer.parseInt(obj.get("fechaCorte").toString()));
			}
			if (obj.get("contratoSic").toString() != "") {
				ContratosList.setCodSicContrato(obj.get("contratoSic").toString());
			}

			if (obj.get("Cod_SIC_comprador").toString() != "") {

				AgentesComerciales agentesComerciales = new AgentesComerciales();
				agentesComerciales = agenteComercialRepository.findAllCod(obj.get("Cod_SIC_comprador").toString());
				ContratosList.setIdAgenteComprador(agentesComerciales.getIdAgenteCcial());

			}

			if (obj.get("Cod_SIC_vendedor").toString() != "") {

				AgentesComerciales agentesComerciales = new AgentesComerciales();
				agentesComerciales = agenteComercialRepository.findAllCod(obj.get("Cod_SIC_vendedor").toString());
				ContratosList.setIdAgenteVendedor(agentesComerciales.getIdAgenteCcial());
			}

			if (obj.get("Fechadefirma").toString() != "") {
				ContratosList.setFechaFirmaContrato(obj.get("Fechadefirma").toString());
			}
			if (obj.get("nombreCliente").toString() != "") {
				ContratosList.setNombreContacto(obj.get("nombreCliente").toString());
			}
			if (obj.get("Emailcontacto").toString() != "") {
				ContratosList.setEmailContacto(obj.get("Emailcontacto").toString());
			}
			if (obj.get("Telefonocontacto").toString() != "") {
				ContratosList.setTelContacto(obj.get("Telefonocontacto").toString());
			}
			
			ContratosRepository.save(ContratosList);
			
			Contratos contratos = new Contratos();
			contratos = ContratosRepository.findAllMax();
			
			saveResponse.setCodigoContrato(contratos.getIdContrato());
			saveResponse.setCodigoSicContrato(contratos.getCodSicContrato());
			saveResponse.setMsg("Guardado Correctamente");
			saveResponse.setEstado(true);

		} catch (Exception e) {
			saveResponse.setCodigoContrato(null);
			saveResponse.setCodigoSicContrato(null);
			saveResponse.setMsg(e.getMessage());
			saveResponse.setEstado(false);
		}

		return saveResponse;
	}
}

