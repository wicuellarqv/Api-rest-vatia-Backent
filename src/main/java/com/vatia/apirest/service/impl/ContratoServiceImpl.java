package com.vatia.apirest.service.impl;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.reflect.ListIterator;
import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.CantidadesContratos;
import com.vatia.apirest.model.Contratos;
import com.vatia.apirest.model.FechasCorteContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.GarantiasContratos;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.PreciosContratos;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.repository.AgenteComercialRepository;
import com.vatia.apirest.repository.CantidadRepository;
import com.vatia.apirest.repository.ContratosRepository;
import com.vatia.apirest.repository.FechaCorteRepository;
import com.vatia.apirest.repository.FormulaPrecioRepository;
import com.vatia.apirest.repository.GarantiaRepository;
import com.vatia.apirest.repository.ModalidadContratoRepository;
import com.vatia.apirest.repository.PrecioContratoRepository;
import com.vatia.apirest.repository.TipoCantidadRepository;
import com.vatia.apirest.repository.TipoContratoRepository;
import com.vatia.apirest.repository.TipoGarantiasRepository;
import com.vatia.apirest.repository.TipoPrecioRepository;
import com.vatia.apirest.repository.TiposMercadosRepository;
import com.vatia.apirest.service.ContratoService;
import com.vatia.apirest.utils.CantidadRequest;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.utils.GarantiasRequest;
import com.vatia.apirest.utils.PreciosRequest;

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
	
	@Autowired
	private CantidadRepository cantidadRepository;
	
	@Autowired
	private PrecioContratoRepository precioContratoRepository;	
	

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

	@Override
	public SaveResponse saveContrato(ContratosRequest contratosRequest) {

		// TODO Auto-generated method stub
		Contratos ContratosList = new Contratos();
		SaveResponse saveResponse = new SaveResponse();		
		List<GarantiasRequest> listaGarantiasContratos = new ArrayList<GarantiasRequest>();
		List<PreciosRequest> listaPreciosRequest = new ArrayList<PreciosRequest>();
		List<CantidadRequest> listaCantidadRequest = new ArrayList<CantidadRequest>();		
		PreciosContratos preciosContratoN = new PreciosContratos();	
		CantidadesContratos cantidadesContratosN = new CantidadesContratos();		
		GarantiasContratos garantiasContratosN = new GarantiasContratos();		


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
			if (contratosRequest.getFormaPago() != "") {
				ContratosList.setIdFechaCorte(Integer.parseInt(contratosRequest.getFormaPago()));
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
			
			//inset en la tabla de garantias 
			listaGarantiasContratos = contratosRequest.getGarantiasContratos();
			if (listaGarantiasContratos.size() > 0) {
				for (GarantiasRequest LgarantiasContratos : listaGarantiasContratos) {
					
					if (LgarantiasContratos.getValor() != null) {
					garantiasContratosN.setNum_valor_garantia(LgarantiasContratos.getValor());
					}
					if (LgarantiasContratos.getInicio() != null) {
					garantiasContratosN.setFechaEntregaInicioGarantia(LgarantiasContratos.getInicio());
					}
					if (LgarantiasContratos.getFin() != null) {
					garantiasContratosN.setFechaEntregaFinGarantia(LgarantiasContratos.getFin());
					}
					garantiasContratosN.setIdContrato(contrato.getIdContrato());
					
					garantiasContratosN.setIdTipoGarantia(Integer.parseInt(contratosRequest.getTipogarantia()));
					garantiasContratosN.setFechaEntregaGarantia(contratosRequest.getFechaEntregaGarantia());

					garantiasContratosN.setIdGarantiaContrato(1);
					garantiaRepository.save(garantiasContratosN);
				}
			}
			
			//inset en la tabla de precios por cada mes			
			listaPreciosRequest = contratosRequest.getPreciosRequest();
			if (listaPreciosRequest.size() > 0) {
				for (PreciosRequest LPreciosRequest : listaPreciosRequest) {
					
					if (LPreciosRequest.getMes() != null) {
						preciosContratoN.setFecPeriodoPrecio(LPreciosRequest.getMes());
					}				
					if (contratosRequest.getFormulaPrecio() != null) {
						preciosContratoN.setFormulaPrecio(Integer.parseInt(contratosRequest.getFormulaPrecio()));
					}	
					if (contrato.getIdContrato() != null) {
						preciosContratoN.setIdContrato(contrato.getIdContrato());
					}
					if (contratosRequest.getTipoPrecio() != null) {
						preciosContratoN.setIdTipoPrecio(Integer.parseInt(contratosRequest.getTipoPrecio()));
					}
					if (contratosRequest.getMesBase() != null) {
						preciosContratoN.setMesBase(contratosRequest.getMesBase());
					}
					//pendiente formula
					int big = 1234;
					preciosContratoN.setPrecioPeriodo(new BigDecimal(big));
					
					if (LPreciosRequest.getPrecioReferencia() != null) {
						preciosContratoN.setPrecioReferencia(new BigDecimal(LPreciosRequest.getPrecioReferencia().replaceAll(",", ".")));
					}
					
					 
					
					
					precioContratoRepository.save(preciosContratoN);
				}
			}
			
			//inset en la tabla de Cantidad por cada mes			
			listaCantidadRequest = contratosRequest.getCantidadRequest();
			if (listaCantidadRequest.size() > 0) {
				for (CantidadRequest LCantidadRequest : listaCantidadRequest) {
					
					if (LCantidadRequest.getFecha() != null) {
						cantidadesContratosN.setFechaCantidad(LCantidadRequest.getFecha());
					}
					if (contrato.getIdContrato() != null) {
						cantidadesContratosN.setIdContrato(contrato.getIdContrato());
					}		
					if (contratosRequest.getCantidadContrato() != null) {
						cantidadesContratosN.setIdCantidadContrato(Integer.parseInt(contratosRequest.getCantidadContrato()));
					}
					if (contratosRequest.getTipoCantidad() != null) {
						cantidadesContratosN.setIdTipoCantidad(Integer.parseInt(contratosRequest.getTipoCantidad()));
					}
					if (LCantidadRequest.getH1() != null) {
						cantidadesContratosN.setCantidadH1(new BigDecimal(LCantidadRequest.getH1().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH2() != null) {
						cantidadesContratosN.setCantidadH2(new BigDecimal(LCantidadRequest.getH2().replaceAll(",", ".")));
					}	
					if (LCantidadRequest.getH3() != null) {
						cantidadesContratosN.setCantidadH3(new BigDecimal(LCantidadRequest.getH3().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH4() != null) {
						cantidadesContratosN.setCantidadH4(new BigDecimal(LCantidadRequest.getH4().replaceAll(",", ".")));
					}	
					if (LCantidadRequest.getH5() != null) {
						cantidadesContratosN.setCantidadH5(new BigDecimal(LCantidadRequest.getH5().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH6() != null) {
						cantidadesContratosN.setCantidadH6(new BigDecimal(LCantidadRequest.getH6().replaceAll(",", ".")));
					}	
					if (LCantidadRequest.getH7() != null) {
						cantidadesContratosN.setCantidadH7(new BigDecimal(LCantidadRequest.getH7().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH8() != null) {
						cantidadesContratosN.setCantidadH8(new BigDecimal(LCantidadRequest.getH8().replaceAll(",", ".")));
					}	
					if (LCantidadRequest.getH9() != null) {
						cantidadesContratosN.setCantidadH9(new BigDecimal(LCantidadRequest.getH9().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH10() != null) {
						cantidadesContratosN.setCantidadH10(new BigDecimal(LCantidadRequest.getH10().replaceAll(",", ".")));
					}	
					if (LCantidadRequest.getH11() != null) {
						cantidadesContratosN.setCantidadH11(new BigDecimal(LCantidadRequest.getH11().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH12() != null) {
						cantidadesContratosN.setCantidadH12(new BigDecimal(LCantidadRequest.getH12().replaceAll(",", ".")));
					}	
					if (LCantidadRequest.getH13() != null) {
						cantidadesContratosN.setCantidadH13(new BigDecimal(LCantidadRequest.getH13().replaceAll(",", ".")));
					}	
					if (LCantidadRequest.getH14() != null) {
						cantidadesContratosN.setCantidadH14(new BigDecimal(LCantidadRequest.getH14().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH15() != null) {
						cantidadesContratosN.setCantidadH15(new BigDecimal(LCantidadRequest.getH15().replaceAll(",", ".")));					
					}
					if (LCantidadRequest.getH16() != null) {
						cantidadesContratosN.setCantidadH16(new BigDecimal(LCantidadRequest.getH16().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH17() != null) {
						cantidadesContratosN.setCantidadH17(new BigDecimal(LCantidadRequest.getH17().replaceAll(",", ".")));					
					}
					if (LCantidadRequest.getH18() != null) {
						cantidadesContratosN.setCantidadH18(new BigDecimal(LCantidadRequest.getH18().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH19() != null) {
						cantidadesContratosN.setCantidadH19(new BigDecimal(LCantidadRequest.getH19().replaceAll(",", ".")));					
					}
					if (LCantidadRequest.getH20() != null) {
						cantidadesContratosN.setCantidadH20(new BigDecimal(LCantidadRequest.getH20().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH21() != null) {
						cantidadesContratosN.setCantidadH21(new BigDecimal(LCantidadRequest.getH21().replaceAll(",", ".")));					
					}					
					if (LCantidadRequest.getH22() != null) {
						cantidadesContratosN.setCantidadH22(new BigDecimal(LCantidadRequest.getH22().replaceAll(",", ".")));
					}			
					if (LCantidadRequest.getH23() != null) {
						cantidadesContratosN.setCantidadH23(new BigDecimal(LCantidadRequest.getH23().replaceAll(",", ".")));					
					}
					if (LCantidadRequest.getH24() != null) {
						cantidadesContratosN.setCantidadH24(new BigDecimal(LCantidadRequest.getH24().replaceAll(",", ".")));					
					}
					cantidadRepository.save(cantidadesContratosN);
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

