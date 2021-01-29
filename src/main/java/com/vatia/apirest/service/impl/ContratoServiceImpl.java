package com.vatia.apirest.service.impl;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.reflect.ListIterator;
import com.vatia.apirest.model.AgentesComerciales;
import com.vatia.apirest.model.Cantidad60Meses;
import com.vatia.apirest.model.CantidadesContratos;
import com.vatia.apirest.model.CondicionTipoContrato;
import com.vatia.apirest.model.Contratos;
import com.vatia.apirest.model.FechasPagoContratos;
import com.vatia.apirest.model.FormulasPrecios;
import com.vatia.apirest.model.GarantiasContratos;
import com.vatia.apirest.model.ModalidadesContratos;
import com.vatia.apirest.model.NegociacionesContratos;
import com.vatia.apirest.model.PreciosContratos;
import com.vatia.apirest.model.SaveResponse;
import com.vatia.apirest.model.TiposCantidad;
import com.vatia.apirest.model.TiposMercados;
import com.vatia.apirest.model.TiposPrecio;
import com.vatia.apirest.model.TiposContratos;
import com.vatia.apirest.model.TiposGarantias;
import com.vatia.apirest.repository.AgenteComercialRepository;
import com.vatia.apirest.repository.CTContratoRepository;
import com.vatia.apirest.repository.CantidadRepository;
import com.vatia.apirest.repository.ConsultaRepository;
import com.vatia.apirest.repository.ContratosRepository;
import com.vatia.apirest.repository.FechaPagoContratoRepository;
import com.vatia.apirest.repository.FormulaPrecioRepository;
import com.vatia.apirest.repository.GarantiaRepository;
import com.vatia.apirest.repository.ModalidadContratoRepository;
import com.vatia.apirest.repository.NegocioContratoRepository;
import com.vatia.apirest.repository.PrecioContratoRepository;
import com.vatia.apirest.repository.TipoCantidadRepository;
import com.vatia.apirest.repository.TipoContratoRepository;
import com.vatia.apirest.repository.TipoGarantiasRepository;
import com.vatia.apirest.repository.TipoPrecioRepository;
import com.vatia.apirest.repository.TiposMercadosRepository;
import com.vatia.apirest.service.ContratoService;
import com.vatia.apirest.utils.CantidadRequest;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.utils.FechasPagosRequest;
import com.vatia.apirest.utils.GarantiasRequest;
import com.vatia.apirest.utils.PreciosRequest;

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
	private FormulaPrecioRepository formulaPrecioRepository;
	
	@Autowired
	private GarantiaRepository garantiaRepository;
	
	@Autowired
	private CantidadRepository cantidadRepository;
	
	@Autowired
	private PrecioContratoRepository precioContratoRepository;	
		
	@Autowired
	private CTContratoRepository cTContratoRepository;	
	
	@Autowired
	private NegocioContratoRepository negocioContratoRepository;	
	
	@Autowired
	private FechaPagoContratoRepository fechaPagoContratoRepository;

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
	public List<FormulasPrecios> getAllFormulaPrecio() {
		// TODO Auto-generated method stub
		return this.formulaPrecioRepository.findAll();
	}
	
	@Override
	public List<CondicionTipoContrato> getAllCTipoContrato() {
		// TODO Auto-generated method stub
		return this.cTContratoRepository.findAll();
	}

	@Override
	public AgentesComerciales getAllSicAgenteComercial(String valor) {
		// TODO Auto-generated method stub
		return this.agenteComercialRepository.findAllCod(valor);
	}	

	@Override
	public String deleteContrato(Integer id) {
		// TODO Auto-generated method stub
		try {
			if (id != null) {
				garantiaRepository.deleteId(id);
				cantidadRepository.deleteId(id);
				fechaPagoContratoRepository.deleteId(id);
				precioContratoRepository.deleteId(id);
				ContratosRepository.deleteId(id);
			}
		} catch (Exception e) {
			return "Error al eliminar el contrato : "+id + " causa: " + e;
		}
		return null;
	}
	
	@Override
	public List<NegociacionesContratos> getAllNegocioContrato(){
		// TODO Auto-generated method stub
		return this.negocioContratoRepository.findAll();
	}
	
	@Override
	public SaveResponse updateContrato(ContratosRequest contratosRequest, List<CantidadRequest> listCantidadRequestFile,			
		List<FechasPagosRequest> listFechaPagosRequestFile) {
		
		List<CantidadRequest> listaCantidadRequest = null;
		Contratos ContratosList = new Contratos();
	    Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate
		SaveResponse saveResponse = new SaveResponse();		
		List<GarantiasRequest> listaGarantiasContratos = new ArrayList<GarantiasRequest>();
		List<PreciosRequest> listaPreciosRequest = new ArrayList<PreciosRequest>();
		PreciosContratos preciosContratoN = new PreciosContratos();	
		CantidadesContratos cantidadesContratosN = new CantidadesContratos();
		FechasPagoContratos fechasPagoContratosN = new FechasPagoContratos();
		GarantiasContratos garantiasContratosN = new GarantiasContratos();	

		
		
		try {
			
			Contratos ContratosNew = new Contratos();
			ContratosNew = ContratosRepository.findIdCodC(Integer.parseInt(contratosRequest.getIdContrato()));
			
			//Valida si existe contrato
			if (ContratosNew != null) {	

			// Set de campos basicos en la tabla de contratos
			
			if (ContratosNew.getIdContrato() != null) {
				ContratosList.setIdContrato(ContratosNew.getIdContrato());
			}
			
			if (contratosRequest.getTipoMercado() != null) {
				ContratosList.setIdTipoMercado(Integer.parseInt(contratosRequest.getTipoMercado()));
			}
			if (contratosRequest.getEstadoContrato() != null) {
				ContratosList.setEstadoContrato(contratosRequest.getEstadoContrato());
			}
			if (contratosRequest.getTipoContrato() != null) {
				ContratosList.setIdTipoContrato(Integer.parseInt(contratosRequest.getTipoContrato()));
			}
			if (contratosRequest.getNegociacionContrato() != null) {
				ContratosList.setIdNegContrato(Integer.parseInt(contratosRequest.getNegociacionContrato()));
			}
			if (contratosRequest.getFechaInicioContrato() != null) {
				ContratosList.setFecPeriodoInicio(contratosRequest.getFechaInicioContrato());
			}
			if (contratosRequest.getFechaFinContrato() != null) {
				ContratosList.setFecPeriodoFin(contratosRequest.getFechaFinContrato());
			}		
			if (contratosRequest.getContratoSic() != null) {
				ContratosList.setCodSicContrato(contratosRequest.getContratoSic());
			}			
			if (contratosRequest.getContratoDocumento() != null) {
				ContratosList.setDocContacto(contratosRequest.getContratoDocumento());
			}	
			if (contratosRequest.getNumContrato() != null) {
				ContratosList.setNumContrato(Integer.parseInt(contratosRequest.getNumContrato()));
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
			
			if (contratosRequest.getCondicionTipoContrato() != null) {
				ContratosList.setIdCondicionTipoContrato(Integer.parseInt(contratosRequest.getCondicionTipoContrato()));
			}
			if (contratosRequest.getFechaFirma() != null) {
				ContratosList.setFechaFirmaContrato(contratosRequest.getFechaFirma());
			}
			if (contratosRequest.getNombreCliente() != null) {
				ContratosList.setNombreContacto(contratosRequest.getNombreCliente());
			}
			if (contratosRequest.getEmailContacto() != null) {
				ContratosList.setEmailContacto(contratosRequest.getEmailContacto());
			}
			if (contratosRequest.getTelefonoContacto() != null) {
				ContratosList.setTelContacto(contratosRequest.getTelefonoContacto());
			}			
			
			//update en la tabla contratos 
			ContratosRepository.save(ContratosList);			
			
			listaGarantiasContratos = contratosRequest.getGarantiasContratos();
			if (listaGarantiasContratos.size() > 0) {
				
				garantiaRepository.deleteId(ContratosNew.getIdContrato());

				for (GarantiasRequest LgarantiasContratos : listaGarantiasContratos) {									
					garantiasContratosN.setIdGarantiaContrato(0);
					if (LgarantiasContratos.getCantidad() != null) {
					garantiasContratosN.setCantidadGarantia(LgarantiasContratos.getCantidad());
					}
					if (LgarantiasContratos.getInicio() != null) {
					garantiasContratosN.setFechaEntregaInicioGarantia(LgarantiasContratos.getInicio());
					}
					if (LgarantiasContratos.getFin() != null) {
					garantiasContratosN.setFechaEntregaFinGarantia(LgarantiasContratos.getFin());
					}					
					if (LgarantiasContratos.getIpp() != null) {
					garantiasContratosN.setIppActGarantia(LgarantiasContratos.getIpp());
					}					
					if (LgarantiasContratos.getTasa() != null) {
					garantiasContratosN.setTasaGarantia(LgarantiasContratos.getTasa());
					}					
					if (LgarantiasContratos.getIva() != null) {
					garantiasContratosN.setIvaGarantia(LgarantiasContratos.getIva());
					}					
					if (LgarantiasContratos.getValor() != null) {
					garantiasContratosN.setValorGarantia(LgarantiasContratos.getValor());
					}
					if (LgarantiasContratos.getPrima() != null) {
					garantiasContratosN.setPrimaGarantia(LgarantiasContratos.getPrima());
					}
					if (LgarantiasContratos.getCosto() != null) {
					garantiasContratosN.setCostoGarantia(LgarantiasContratos.getCosto());
					}
					if (ContratosNew.getIdContrato() != null) {
					garantiasContratosN.setIdContrato(ContratosNew.getIdContrato());
					}
					if (contratosRequest.getTipoGarantia() != null) {
					garantiasContratosN.setIdTipoGarantia(Integer.parseInt(contratosRequest.getTipoGarantia()));
					}
					if (contratosRequest.getFechaEntregaGarantia() != null) {
					garantiasContratosN.setFechaEntregaGarantia(contratosRequest.getFechaEntregaGarantia());
					}		
					//update en la tabla de garantias 
					garantiaRepository.save(garantiasContratosN);
					
				}
			}
					
			listaPreciosRequest = contratosRequest.getPreciosRequest();
			
			if (listaPreciosRequest.size() > 0) {				
				
				//Busca los precios contratos con id contrato
				List<PreciosContratos> PreciosContratosNew = precioContratoRepository.getAllPrecio(ContratosNew.getIdContrato());	

				for (PreciosContratos preciosContratosNew : PreciosContratosNew) {
					
					Date dateFechaPeriodoNew = new SimpleDateFormat("yyyy-MM").parse(preciosContratosNew.getFecPeriodoPrecio());

					// Verifica si la fecha actual es posterior al periodo para eliminar
					if (objDate.after(dateFechaPeriodoNew)) {
						precioContratoRepository.deleteIdPrecio(preciosContratosNew.getIdPrecioContrato());
					}
				}				
				
				for (PreciosRequest LPreciosRequest : listaPreciosRequest) {
					Date dateFechaPeriodo = new SimpleDateFormat("yyyy-MM").parse(LPreciosRequest.getMes());
					
					// Verifica si la fecha actual es posterior al periodo para hacer el insert
					if (objDate.after(dateFechaPeriodo)) {
						
						preciosContratoN.setIdPrecioContrato(0);
						if (LPreciosRequest.getMes() != null) {
							preciosContratoN.setFecPeriodoPrecio(LPreciosRequest.getMes());
						}
						if (contratosRequest.getFormulaPrecio() != null) {
							preciosContratoN.setFormulaPrecio(Integer.parseInt(contratosRequest.getFormulaPrecio()));
						}
						if (ContratosNew.getIdContrato() != null) {
							preciosContratoN.setIdContrato(ContratosNew.getIdContrato());
						}
						if (contratosRequest.getTipoPrecio() != null) {
							preciosContratoN.setIdTipoPrecio(Integer.parseInt(contratosRequest.getTipoPrecio()));
						}
						if (contratosRequest.getMesBase() != null) {
							preciosContratoN.setMesBase(contratosRequest.getMesBase());
						}

						// pendiente formula
						int big = 1234;
						preciosContratoN.setPrecioPeriodo(new BigDecimal(big));

						if (LPreciosRequest.getPrecioReferencia() != null) {
							preciosContratoN.setPrecioReferencia(
									new BigDecimal(LPreciosRequest.getPrecioReferencia().replaceAll(",", ".")));
						}
						precioContratoRepository.save(preciosContratoN);
					}
				}
			}
			
		
			listaCantidadRequest = contratosRequest.getCantidadRequest();	
			
			if (listaCantidadRequest.size() > 0) {
				
				//Busca las cantidades contratos con id contrato
				List<CantidadesContratos> CantidadesContratosNew = cantidadRepository.getAllCantidad(ContratosNew.getIdContrato());	

				for (CantidadesContratos cantidadesContratosNew : CantidadesContratosNew) {
					
					Date dateFechaNew = new SimpleDateFormat("yyyy-MM-dd").parse(cantidadesContratosNew.getFechaCantidad());

					// Verifica si la fecha actual es posterior al periodo para eliminar
					if (objDate.after(dateFechaNew)) {
						cantidadRepository.deleteIdCant(cantidadesContratosNew.getIdCantidadContrato());
					}
				}				

				for (CantidadRequest LCantidadRequest : listaCantidadRequest) {

					Date dateFechaN = new SimpleDateFormat("yyyy-MM-dd").parse(LCantidadRequest.getFecha());

					// Verifica si la fecha actual es posterior al periodo para hacer el insert
					if (objDate.after(dateFechaN)) {
						
						cantidadesContratosN.setIdCantidadContrato(0);
						if (LCantidadRequest.getFecha() != null) {
							cantidadesContratosN.setFechaCantidad(LCantidadRequest.getFecha());
						}
						if (contratosRequest.getTipoCantidad() != null) {
							cantidadesContratosN
									.setIdTipoCantidad(Integer.parseInt(contratosRequest.getTipoCantidad()));
						}
						if (ContratosNew.getIdContrato() != null) {
							cantidadesContratosN.setIdContrato(ContratosNew.getIdContrato());
						}
						if (LCantidadRequest.getH1() != null) {
							cantidadesContratosN
									.setCantidadH1(new BigDecimal(LCantidadRequest.getH1().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH2() != null) {
							cantidadesContratosN
									.setCantidadH2(new BigDecimal(LCantidadRequest.getH2().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH3() != null) {
							cantidadesContratosN
									.setCantidadH3(new BigDecimal(LCantidadRequest.getH3().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH4() != null) {
							cantidadesContratosN
									.setCantidadH4(new BigDecimal(LCantidadRequest.getH4().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH5() != null) {
							cantidadesContratosN
									.setCantidadH5(new BigDecimal(LCantidadRequest.getH5().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH6() != null) {
							cantidadesContratosN
									.setCantidadH6(new BigDecimal(LCantidadRequest.getH6().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH7() != null) {
							cantidadesContratosN
									.setCantidadH7(new BigDecimal(LCantidadRequest.getH7().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH8() != null) {
							cantidadesContratosN
									.setCantidadH8(new BigDecimal(LCantidadRequest.getH8().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH9() != null) {
							cantidadesContratosN
									.setCantidadH9(new BigDecimal(LCantidadRequest.getH9().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH10() != null) {
							cantidadesContratosN
									.setCantidadH10(new BigDecimal(LCantidadRequest.getH10().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH11() != null) {
							cantidadesContratosN
									.setCantidadH11(new BigDecimal(LCantidadRequest.getH11().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH12() != null) {
							cantidadesContratosN
									.setCantidadH12(new BigDecimal(LCantidadRequest.getH12().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH13() != null) {
							cantidadesContratosN
									.setCantidadH13(new BigDecimal(LCantidadRequest.getH13().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH14() != null) {
							cantidadesContratosN
									.setCantidadH14(new BigDecimal(LCantidadRequest.getH14().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH15() != null) {
							cantidadesContratosN
									.setCantidadH15(new BigDecimal(LCantidadRequest.getH15().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH16() != null) {
							cantidadesContratosN
									.setCantidadH16(new BigDecimal(LCantidadRequest.getH16().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH17() != null) {
							cantidadesContratosN
									.setCantidadH17(new BigDecimal(LCantidadRequest.getH17().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH18() != null) {
							cantidadesContratosN
									.setCantidadH18(new BigDecimal(LCantidadRequest.getH18().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH19() != null) {
							cantidadesContratosN
									.setCantidadH19(new BigDecimal(LCantidadRequest.getH19().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH20() != null) {
							cantidadesContratosN
									.setCantidadH20(new BigDecimal(LCantidadRequest.getH20().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH21() != null) {
							cantidadesContratosN
									.setCantidadH21(new BigDecimal(LCantidadRequest.getH21().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH22() != null) {
							cantidadesContratosN
									.setCantidadH22(new BigDecimal(LCantidadRequest.getH22().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH23() != null) {
							cantidadesContratosN
									.setCantidadH23(new BigDecimal(LCantidadRequest.getH23().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH24() != null) {
							cantidadesContratosN
									.setCantidadH24(new BigDecimal(LCantidadRequest.getH24().replaceAll(",", ".")));
						}
						// Inset cantidad
						cantidadRepository.save(cantidadesContratosN);
					}
					
				}
				
				//Actualiza tipo cantidad sin importar fechas cantidades				
				int tipoCantidad = Integer.parseInt(contratosRequest.getTipoCantidad());
				int idcontratocan = Integer.parseInt(contratosRequest.getIdContrato());
				cantidadRepository.updateTipoCan(tipoCantidad,idcontratocan);
				
				
			}


			if (listFechaPagosRequestFile.size() > 0) {
				
				//Busca las cantidades contratos con id contrato
				List<FechasPagoContratos> FechasPagoContratosNew = fechaPagoContratoRepository.getAllFechaP(ContratosNew.getIdContrato());	

				for (FechasPagoContratos fechasPagoContratosNew : FechasPagoContratosNew) {
					
					Date dateFechaNew = new SimpleDateFormat("MM/yy").parse(fechasPagoContratosNew.getPeriodoPago());

					// Verifica si la fecha actual es posterior al periodo para eliminar
					if (objDate.after(dateFechaNew)) {
						fechaPagoContratoRepository.deleteIdFecha(fechasPagoContratosNew.getIdFechaPago());
					}
				}

				for (FechasPagosRequest fechasPagosRequest : listFechaPagosRequestFile) {

					Date datePeriodo = new SimpleDateFormat("MM/yy").parse(fechasPagosRequest.getPeriodo());

					// Verifica si la fecha actual es posterior al periodo para hacer el insert
					if (objDate.after(datePeriodo)) {

						fechasPagoContratosN.setIdFechaPago(0);
						if (fechasPagosRequest.getFechaPago() != null) {
							fechasPagoContratosN.setFechaPagoPeriodo(fechasPagosRequest.getFechaPago());
						}
						if (fechasPagosRequest.getPeriodo() != null) {
							fechasPagoContratosN.setPeriodoPago(fechasPagosRequest.getPeriodo());
						}
						if (ContratosNew.getIdContrato() != null) {
							fechasPagoContratosN.setIdContrato(ContratosNew.getIdContrato());
						}

						// Inset fecha pago
						fechaPagoContratoRepository.save(fechasPagoContratosN);
					}
				}
			}

			if (listCantidadRequestFile.size() > 0) {

				// Busca las cantidades contratos con id contrato
				List<CantidadesContratos> CantidadesContratosNew = cantidadRepository.getAllCantidad(ContratosNew.getIdContrato());

				for (CantidadesContratos cantidadesContratosNew : CantidadesContratosNew) {

					Date dateFechaNew = new SimpleDateFormat("yyyy-MM-dd").parse(cantidadesContratosNew.getFechaCantidad());

					// Verifica si la fecha actual es posterior al periodo para eliminar
					if (objDate.after(dateFechaNew)) {
						cantidadRepository.deleteIdCant(cantidadesContratosNew.getIdCantidadContrato());
					}
				}

				for (CantidadRequest LCantidadRequest : listCantidadRequestFile) {

					Date dateFechaN = new SimpleDateFormat("dd/MM/yyyy").parse(LCantidadRequest.getFecha());

					// Verifica si la fecha actual es posterior al periodo para hacer el insert
					if (objDate.after(dateFechaN)) {

						cantidadesContratosN.setIdCantidadContrato(0);
						if (LCantidadRequest.getFecha() != null) {
							Date date = new SimpleDateFormat("dd/MM/yyyy").parse(LCantidadRequest.getFecha());					
							String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);						
							cantidadesContratosN.setFechaCantidad(formattedDate);	
						}
						if (contratosRequest.getTipoCantidad() != null) {
							cantidadesContratosN
									.setIdTipoCantidad(Integer.parseInt(contratosRequest.getTipoCantidad()));
						}
						if (ContratosNew.getIdContrato() != null) {
							cantidadesContratosN.setIdContrato(ContratosNew.getIdContrato());
						}
						if (LCantidadRequest.getH1() != null) {
							cantidadesContratosN
									.setCantidadH1(new BigDecimal(LCantidadRequest.getH1().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH2() != null) {
							cantidadesContratosN
									.setCantidadH2(new BigDecimal(LCantidadRequest.getH2().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH3() != null) {
							cantidadesContratosN
									.setCantidadH3(new BigDecimal(LCantidadRequest.getH3().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH4() != null) {
							cantidadesContratosN
									.setCantidadH4(new BigDecimal(LCantidadRequest.getH4().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH5() != null) {
							cantidadesContratosN
									.setCantidadH5(new BigDecimal(LCantidadRequest.getH5().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH6() != null) {
							cantidadesContratosN
									.setCantidadH6(new BigDecimal(LCantidadRequest.getH6().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH7() != null) {
							cantidadesContratosN
									.setCantidadH7(new BigDecimal(LCantidadRequest.getH7().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH8() != null) {
							cantidadesContratosN
									.setCantidadH8(new BigDecimal(LCantidadRequest.getH8().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH9() != null) {
							cantidadesContratosN
									.setCantidadH9(new BigDecimal(LCantidadRequest.getH9().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH10() != null) {
							cantidadesContratosN
									.setCantidadH10(new BigDecimal(LCantidadRequest.getH10().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH11() != null) {
							cantidadesContratosN
									.setCantidadH11(new BigDecimal(LCantidadRequest.getH11().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH12() != null) {
							cantidadesContratosN
									.setCantidadH12(new BigDecimal(LCantidadRequest.getH12().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH13() != null) {
							cantidadesContratosN
									.setCantidadH13(new BigDecimal(LCantidadRequest.getH13().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH14() != null) {
							cantidadesContratosN
									.setCantidadH14(new BigDecimal(LCantidadRequest.getH14().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH15() != null) {
							cantidadesContratosN
									.setCantidadH15(new BigDecimal(LCantidadRequest.getH15().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH16() != null) {
							cantidadesContratosN
									.setCantidadH16(new BigDecimal(LCantidadRequest.getH16().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH17() != null) {
							cantidadesContratosN
									.setCantidadH17(new BigDecimal(LCantidadRequest.getH17().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH18() != null) {
							cantidadesContratosN
									.setCantidadH18(new BigDecimal(LCantidadRequest.getH18().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH19() != null) {
							cantidadesContratosN
									.setCantidadH19(new BigDecimal(LCantidadRequest.getH19().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH20() != null) {
							cantidadesContratosN
									.setCantidadH20(new BigDecimal(LCantidadRequest.getH20().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH21() != null) {
							cantidadesContratosN
									.setCantidadH21(new BigDecimal(LCantidadRequest.getH21().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH22() != null) {
							cantidadesContratosN
									.setCantidadH22(new BigDecimal(LCantidadRequest.getH22().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH23() != null) {
							cantidadesContratosN
									.setCantidadH23(new BigDecimal(LCantidadRequest.getH23().replaceAll(",", ".")));
						}
						if (LCantidadRequest.getH24() != null) {
							cantidadesContratosN
									.setCantidadH24(new BigDecimal(LCantidadRequest.getH24().replaceAll(",", ".")));
						}
						cantidadRepository.save(cantidadesContratosN);
					}
				}
			}
			
			saveResponse.setCodigoContrato(ContratosNew.getIdContrato());
			saveResponse.setCodigoSicContrato(ContratosNew.getCodSicContrato());			
			saveResponse.setMsg("Actualizado Correctamente !");
			saveResponse.setEstado(true);
			
			}else
			{
				saveResponse.setCodigoContrato(null);
				saveResponse.setCodigoSicContrato(null);
				saveResponse.setMsg("El codigo de contrato no existe !");
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
	
	@Override
	public SaveResponse saveContrato(ContratosRequest contratosRequest, List<CantidadRequest> listCantidadRequestFile,
			List<FechasPagosRequest> listFechaPagosRequestFile) {
		List<CantidadRequest> listaCantidadRequest = null;
		
		Contratos ContratosList = new Contratos();
		SaveResponse saveResponse = new SaveResponse();		
		List<GarantiasRequest> listaGarantiasContratos = new ArrayList<GarantiasRequest>();
		List<PreciosRequest> listaPreciosRequest = new ArrayList<PreciosRequest>();
		PreciosContratos preciosContratoN = new PreciosContratos();	
		CantidadesContratos cantidadesContratosN = new CantidadesContratos();
		FechasPagoContratos fechasPagoContratosN = new FechasPagoContratos();
		GarantiasContratos garantiasContratosN = new GarantiasContratos();		


		try {

			// Set de campos basicos en la tabla de contratos
			
			
			if (contratosRequest.getTipoMercado() != null) {
				ContratosList.setIdTipoMercado(Integer.parseInt(contratosRequest.getTipoMercado()));
			}
			if (contratosRequest.getEstadoContrato() != null) {
				ContratosList.setEstadoContrato(contratosRequest.getEstadoContrato());
			}
			if (contratosRequest.getTipoContrato() != null) {
				ContratosList.setIdTipoContrato(Integer.parseInt(contratosRequest.getTipoContrato()));
			}
			if (contratosRequest.getNegociacionContrato() != null) {
				ContratosList.setIdNegContrato(Integer.parseInt(contratosRequest.getNegociacionContrato()));
			}
			if (contratosRequest.getFechaInicioContrato() != null) {
				ContratosList.setFecPeriodoInicio(contratosRequest.getFechaInicioContrato());
			}
			if (contratosRequest.getFechaFinContrato() != null) {
				ContratosList.setFecPeriodoFin(contratosRequest.getFechaFinContrato());
			}		
			if (contratosRequest.getContratoSic() != null) {
				ContratosList.setCodSicContrato(contratosRequest.getContratoSic());
			}			
			if (contratosRequest.getContratoDocumento() != null) {
				ContratosList.setDocContacto(contratosRequest.getContratoDocumento());
			}	
			if (contratosRequest.getNumContrato() != null) {
				ContratosList.setNumContrato(Integer.parseInt(contratosRequest.getNumContrato()));
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
			
			if (contratosRequest.getCondicionTipoContrato() != null) {
				ContratosList.setIdCondicionTipoContrato(Integer.parseInt(contratosRequest.getCondicionTipoContrato()));
			}
			if (contratosRequest.getFechaFirma() != null) {
				ContratosList.setFechaFirmaContrato(contratosRequest.getFechaFirma());
			}
			if (contratosRequest.getNombreCliente() != null) {
				ContratosList.setNombreContacto(contratosRequest.getNombreCliente());
			}
			if (contratosRequest.getEmailContacto() != null) {
				ContratosList.setEmailContacto(contratosRequest.getEmailContacto());
			}
			if (contratosRequest.getTelefonoContacto() != null) {
				ContratosList.setTelContacto(contratosRequest.getTelefonoContacto());
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
					garantiasContratosN.setIdGarantiaContrato(0);
					if (LgarantiasContratos.getCantidad() != null) {
					garantiasContratosN.setCantidadGarantia(LgarantiasContratos.getCantidad());
					}
					if (LgarantiasContratos.getInicio() != null) {
					garantiasContratosN.setFechaEntregaInicioGarantia(LgarantiasContratos.getInicio());
					}
					if (LgarantiasContratos.getFin() != null) {
					garantiasContratosN.setFechaEntregaFinGarantia(LgarantiasContratos.getFin());
					}					
					if (LgarantiasContratos.getIpp() != null) {
					garantiasContratosN.setIppActGarantia(LgarantiasContratos.getIpp());
					}					
					if (LgarantiasContratos.getTasa() != null) {
					garantiasContratosN.setTasaGarantia(LgarantiasContratos.getTasa());
					}					
					if (LgarantiasContratos.getIva() != null) {
					garantiasContratosN.setIvaGarantia(LgarantiasContratos.getIva());
					}					
					if (LgarantiasContratos.getValor() != null) {
					garantiasContratosN.setValorGarantia(LgarantiasContratos.getValor());
					}
					if (LgarantiasContratos.getPrima() != null) {
					garantiasContratosN.setPrimaGarantia(LgarantiasContratos.getPrima());
					}
					if (LgarantiasContratos.getCosto() != null) {
					garantiasContratosN.setCostoGarantia(LgarantiasContratos.getCosto());
					}
					if (contrato.getIdContrato() != null) {
					garantiasContratosN.setIdContrato(contrato.getIdContrato());
					}
					if (contratosRequest.getTipoGarantia() != null) {
					garantiasContratosN.setIdTipoGarantia(Integer.parseInt(contratosRequest.getTipoGarantia()));
					}
					if (contratosRequest.getFechaEntregaGarantia() != null) {
					garantiasContratosN.setFechaEntregaGarantia(contratosRequest.getFechaEntregaGarantia());
					}		
					garantiaRepository.save(garantiasContratosN);
					
				}
			}
			
			//inset en la tabla de precios por cada mes			
			listaPreciosRequest = contratosRequest.getPreciosRequest();
			if (listaPreciosRequest.size() > 0) {
				for (PreciosRequest LPreciosRequest : listaPreciosRequest) {
					preciosContratoN.setIdPrecioContrato(0);
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
					cantidadesContratosN.setIdCantidadContrato(0);
					if (LCantidadRequest.getFecha() != null) {
						
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(LCantidadRequest.getFecha());
					String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);						
						
						cantidadesContratosN.setFechaCantidad(formattedDate);
					}
					if (contratosRequest.getTipoCantidad() != null) {
						cantidadesContratosN.setIdTipoCantidad(Integer.parseInt(contratosRequest.getTipoCantidad()));
					}		
					if (contrato.getIdContrato() != null) {
						cantidadesContratosN.setIdContrato(contrato.getIdContrato());
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
			
			// inset tabla fechas de pago
			if (listFechaPagosRequestFile.size() > 0) {
				for (FechasPagosRequest fechasPagosRequest : listFechaPagosRequestFile) {
					fechasPagoContratosN.setIdFechaPago(0);
					if (fechasPagosRequest.getFechaPago() != null) {
						fechasPagoContratosN.setFechaPagoPeriodo(fechasPagosRequest.getFechaPago());
					}
					if (fechasPagosRequest.getPeriodo() != null) {
						fechasPagoContratosN.setPeriodoPago(fechasPagosRequest.getPeriodo());
					}
					if (contrato.getIdContrato() != null) {
						fechasPagoContratosN.setIdContrato(contrato.getIdContrato());
					}
					fechaPagoContratoRepository.save(fechasPagoContratosN);
				}
			}
			
			if(listCantidadRequestFile.size() > 0) {
				for (CantidadRequest LCantidadRequest : listCantidadRequestFile) {
					cantidadesContratosN.setIdCantidadContrato(0);
					if (LCantidadRequest.getFecha() != null) {					
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(LCantidadRequest.getFecha());					
					String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);						
					cantidadesContratosN.setFechaCantidad(formattedDate);					
					}
					if (contratosRequest.getTipoCantidad() != null) {
						cantidadesContratosN.setIdTipoCantidad(Integer.parseInt(contratosRequest.getTipoCantidad()));
					}		
					if (contrato.getIdContrato() != null) {
						cantidadesContratosN.setIdContrato(contrato.getIdContrato());
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

	@Override
	public String getIdSic(JSONObject obj) {
		
		String msg = null;

		if (obj.get("idContrato") != null) {
			int idContrato = (int) obj.get("idContrato");
			String contratoN = ContratosRepository.idContrato(idContrato);
			if (contratoN != null ) {
				return msg = "Existe el codigo de contrato numero: "+ contratoN;					
			}
		}
		
		if (obj.get("contratoSic") != null) {
			String contratoSic = obj.get("contratoSic").toString();
			String contratoS = ContratosRepository.contratoSic(contratoSic);
			if (contratoS  != null ) {
			return msg = "Existe el codigo SIC numero: "+ contratoS ;
			}
		}
		return msg = "No existe ningun codigo";
	}
}

