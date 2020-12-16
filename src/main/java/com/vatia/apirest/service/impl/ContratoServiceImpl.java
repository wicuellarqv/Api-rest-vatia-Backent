package com.vatia.apirest.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.reflect.ListIterator;
import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.Contratos;
import com.vatia.apirest.model.FechasCorteContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.GarantiasContratos;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.repository.AgenteComercialRepository;
import com.vatia.apirest.repository.ContratosRepository;
import com.vatia.apirest.repository.FechaCorteRepository;
import com.vatia.apirest.repository.FormulaPrecioRepository;
import com.vatia.apirest.repository.GarantiaRepository;
import com.vatia.apirest.repository.ModalidadContratoRepository;
import com.vatia.apirest.repository.TipoCantidadRepository;
import com.vatia.apirest.repository.TipoContratoRepository;
import com.vatia.apirest.repository.TipoGarantiasRepository;
import com.vatia.apirest.repository.TipoPrecioRepository;
import com.vatia.apirest.repository.TiposMercadosRepository;
import com.vatia.apirest.service.ContratoService;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.utils.GarantiasRequest;

import io.jsonwebtoken.lang.Arrays;
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
	
	@Autowired
	private GarantiaRepository garantiaRepository;
	

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

	@SuppressWarnings("unchecked")
	public SaveResponse saveContrato(ContratosRequest contratosRequest) {

		// TODO Auto-generated method stub
		Contratos ContratosList = new Contratos();
		GarantiasContratos garantiasContratos = new GarantiasContratos();
		SaveResponse saveResponse = new SaveResponse();

		try {

			// Set de campos basicos en la tabla de contratos
			if (contratosRequest.getTipodeMercado() != "") {
				ContratosList.setIdTipoMercado(Integer.parseInt(contratosRequest.getTipodeMercado()));
			}
			if (contratosRequest.getEstadoContrato() != "") {
				ContratosList.setEstadoContrato(contratosRequest.getEstadoContrato());
			}
			if (contratosRequest.getTipodeContrato() != "") {
				ContratosList.setIdTipoContrato(Integer.parseInt(contratosRequest.getTipodeContrato()));
			}
			if (contratosRequest.getModalidaddelcontrato() != "") {
				ContratosList.setIdModalidadContrato(Integer.parseInt(contratosRequest.getModalidaddelcontrato()));
			}
			if (contratosRequest.getFechadeinicioContrato() != "") {
				ContratosList.setFecPeriodoInicio(contratosRequest.getFechadeinicioContrato());
			}
			if (contratosRequest.getFechadefinContrato() != "") {
				ContratosList.setFecPeriodoFin(contratosRequest.getFechadefinContrato());
			}
			if (contratosRequest.getFechaCorte() != "") {
				ContratosList.setIdFechaCorte(Integer.parseInt(contratosRequest.getFechaCorte()));
			}
			if (contratosRequest.getContratoSic() != "") {
				ContratosList.setCodSicContrato(contratosRequest.getContratoSic());
			}

			if (contratosRequest.getCod_SIC_comprador()!= "") {

				AgentesComerciales agentesComerciales = new AgentesComerciales();
				agentesComerciales = agenteComercialRepository.findAllCod(contratosRequest.getCod_SIC_comprador());
				ContratosList.setIdAgenteComprador(agentesComerciales.getIdAgenteCcial());

			}

			if (contratosRequest.getCod_SIC_vendedor()!= "") {

				AgentesComerciales agentesComerciales = new AgentesComerciales();
				agentesComerciales = agenteComercialRepository.findAllCod(contratosRequest.getCod_SIC_vendedor());
				ContratosList.setIdAgenteVendedor(agentesComerciales.getIdAgenteCcial());
			}

			if (contratosRequest.getFechadefirma() != "") {
				ContratosList.setFechaFirmaContrato(contratosRequest.getFechadefirma());
			}
			if (contratosRequest.getNombreCliente() != "") {
				ContratosList.setNombreContacto(contratosRequest.getNombreCliente());
			}
			if (contratosRequest.getEmailcontacto() != "") {
				ContratosList.setEmailContacto(contratosRequest.getEmailcontacto());
			}
			if (contratosRequest.getTipodeContrato() != "") {
				ContratosList.setTelContacto(contratosRequest.getTipodeContrato());
			}
			
	        String llave="";
	         
	        for(int i = 1 ; i <= 10 ; i++) {
	            switch((int) Math.floor(Math.random() * (3 - 1 + 1) + 1)) {
	                case 1:
	                	llave += mayuscula();
	                break;
	                case 2:
	                	llave += minuscula();
	                break;
	                case 3:
	                	llave += numero();
	                break;
	            }
	        }
	         
	        ContratosList.setLlave(llave);			
			ContratosRepository.save(ContratosList);		
			Contratos contrato = new Contratos();
			contrato = ContratosRepository.findAllMax(llave);				
			Integer valor = ContratosRepository.findIdCod(contrato.getIdContrato());
			
			List<GarantiasRequest> listaGarantiasContratos = new ArrayList<GarantiasRequest>();
			GarantiasContratos garantiasContratosN = new GarantiasContratos();
			
			listaGarantiasContratos = contratosRequest.getGarantiasContratos();
			
			if (listaGarantiasContratos.size() > 0) {
				for (GarantiasRequest LgarantiasContratos : listaGarantiasContratos) {
					
					if (LgarantiasContratos.getNum_valor_garantia() != null) {
					garantiasContratosN.setNum_valor_garantia(LgarantiasContratos.getNum_valor_garantia());
					}
					if (LgarantiasContratos.getFechaEntregaInicioGarantia() != null) {
					garantiasContratosN.setFechaEntregaInicioGarantia(LgarantiasContratos.getFechaEntregaInicioGarantia());
					}
					if (LgarantiasContratos.getFechaEntregaFinGarantia() != null) {
					garantiasContratosN.setFechaEntregaFinGarantia(LgarantiasContratos.getFechaEntregaFinGarantia());
					}
					garantiasContratosN.setIdContrato(contrato.getIdContrato());
					
					garantiasContratosN.setIdTipoGarantia(Integer.parseInt(contratosRequest.getTipogarantia()));
					garantiasContratosN.setFechaEntregaGarantia(contratosRequest.getFechaEntregaGarantia());

					garantiasContratosN.setIdGarantiaContrato(1);
					garantiaRepository.save(garantiasContratosN);
				}
			}

			
			if (valor != 0) {			
			saveResponse.setCodigoContrato(contrato.getIdContrato());
			saveResponse.setCodigoSicContrato(contrato.getCodSicContrato());			
			saveResponse.setMsg("Guardado Correctamente");
			saveResponse.setEstado(true);
			}else {
				saveResponse.setCodigoContrato(null);
				saveResponse.setCodigoSicContrato(null);
				saveResponse.setMsg("Error al guardar id de contrato");
				saveResponse.setEstado(false);
			}
			
		} catch (Exception e) {
			saveResponse.setCodigoContrato(null);
			saveResponse.setCodigoSicContrato(null);
			saveResponse.setMsg(e.getMessage());
			saveResponse.setEstado(false);
		}

		return saveResponse;
	}
	
    public static char mayuscula() {
        return (char) Math.floor(Math.random() * (90 - 65 + 1) + 65);
    }
 
    public static char minuscula() {
        return (char) Math.floor(Math.random() * (122 - 97 + 1) + 97);
    }
 
    public static int numero() {
        return (int) Math.floor(Math.random() * (9 + 1));
    }
}

