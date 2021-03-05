package com.vatia.apirest.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.vatia.apirest.model.PlantaCantContrato;
import com.vatia.apirest.repository.ConsultaRepository;
import com.vatia.apirest.repository.PlantaCantContratoRepository;
import com.vatia.apirest.service.ConsultaService;
import com.vatia.apirest.utils.ConsultaContratosResponse;
import com.vatia.apirest.utils.ContratoDetailResponse;
import com.vatia.apirest.utils.ContratosRequest;
import com.vatia.apirest.utils.GarantiasResponse;
import com.vatia.apirest.utils.PreciosResponse;
import com.vatia.apirest.utils.TipoCantidadResponse;
import com.vatia.apirest.utils.fechaPagoResponse;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private PlantaCantContratoRepository plantaCantContratoRepository;
	
	// @Autowired
	static String dbURL = "jdbc:sqlserver://10.112.201.35\\PROGENERAL;databaseName=webapp_tradebalance;user=webapp_tradebalance;password=W3b4pp.Tr4de$$";
	public static void conected() {
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
			    System.out.println("Connected");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Connection close");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}
	

	public List<ConsultaContratosResponse> contratos (JSONObject obj) {	
		
		List<ConsultaContratosResponse> Contratos = new ArrayList<>();
	
		String query = "select "
				+ "c.num_id_contrato id_contrato, "
				+ "c.num_contrato num_contrato, "
				+ "c.str_codigo_sic_contrato cod_sic_contrato, "
				+ "nc.str_desc_negoc_contrato negociacion, "
				+ "tc.str_desc_tipo_contrato tipo_contrato, "
				+ "ctc.str_desc_condicion_tipo_contrato condicion, "
				+ "tm.str_desc_tipo_mercado tipo_mercado, "
				+ "c.num_id_agnte_ccial_comp id_comprador, "
				+ "a.str_nombre_agente_ccial comprador, "
				+ "c.num_id_agnte_ccial_vend id_vendedor, "
				+ "ag.str_nombre_agente_ccial vendedor, "
				+ "c.dtm_periodo_fin fecha_fin, "
				+ "c.dtm_periodo_inicio fecha_inicio, "
				+ "c.str_estado estado "
				+ "from tbl_contratos c "
				+ "left join tbl_condiciones_tipos_contratos ctc on c.num_id_condicion_tipo_contrato=ctc.num_id_condicion_tipo_contrato "
				+ "left join tbl_negoc_contratos nc on c.num_id_negoc_contrato=nc.num_id_negoc_contrato "
				+ "left join tbl_tipos_contratos tc on c.num_id_tipo_contrato=tc.num_id_tipo_contrato "
				+ "left join tbl_agentes_comerciales a on c.num_id_agnte_ccial_comp=a.num_id_agente_ccial "
				+ "left join tbl_agentes_comerciales ag on c.num_id_agnte_ccial_vend= ag.num_id_agente_ccial "
				+ "left join tbl_tipos_mercados tm on c.num_id_tipo_mercado=tm.num_id_tipo_mercado "
				+ "where 1=1 ";
		
		if(obj.get("numContrato") != null) {
			query+=" and c.num_contrato = " + obj.get("numContrato").toString();
		}
		
		if(obj.get("contratoSic") != null) {
			query+=" and str_codigo_sic_contrato = " + obj.get("contratoSic").toString();
		}
		
		if(obj.get("idContrato") != null) {
			query+=" and c.num_id_contrato = " + obj.get("idContrato").toString();
		}
		
		if(obj.get("estadoContrato") != null) {
			String estadoContrato = obj.get("estadoContrato").toString();
			query+=" and c.str_estado =  '"+estadoContrato+"'";
		}
		
		if(obj.get("cod_SIC_vendedor") != null) {
			query+=" and ag.str_codigo_sic_agente_ccial = " + obj.get("cod_SIC_vendedor").toString();
		}
		
		if(obj.get("cod_SIC_comprador") != null) {
			query+=" and a.str_codigo_sic_agente_ccial = " + obj.get("cod_SIC_comprador").toString();
		}		
		
		Connection conn = null;
		Statement stmt = null;
		
		try {

			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected");
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				System.out.println(rs);

				while (rs.next()) {
					
					ConsultaContratosResponse Contrato = new ConsultaContratosResponse(); 
					Contrato.setIdContrato(rs.getString("id_contrato"));
					Contrato.setNumContrato(rs.getString("num_contrato"));
					Contrato.setCodSic(rs.getString("cod_sic_contrato"));					
					Contrato.setNegociacionContrato(rs.getString("negociacion"));
					Contrato.setTipoContrato(rs.getString("tipo_contrato"));
					Contrato.setCondicion(rs.getString("condicion"));
					Contrato.setTipoMercado(rs.getString("tipo_mercado"));
					Contrato.setNombreComprador(rs.getString("comprador"));
					Contrato.setNombreVendedor(rs.getString("vendedor"));
					Contrato.setPeriodoInicio(rs.getString("fecha_inicio"));
					Contrato.setPeriodoFinalizacion(rs.getString("fecha_fin"));
					Contrato.setEstado(rs.getString("estado"));
					Contratos.add(Contrato);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
					stmt.close();
					System.out.println("Connection close");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return Contratos;

	}
	


	/**
	 * 
	 */
	@Override
	public ContratoDetailResponse findById(String idContrato) {
		try {
			String queryResult = this.consultaRepository.detalle(idContrato);
			String[] args = queryResult.split(",");
			ContratoDetailResponse cdr = new ContratoDetailResponse(args);
			cdr.setPrecios(this.preciosContrato(idContrato));
			cdr.setCantidad(this.tipoCantidad(idContrato));
			cdr.setGarantias(this.garantias(idContrato));
			cdr.setFechaPago(this.fechaPago(idContrato));
			System.out.println("consulte el contrato: " + idContrato);
			cdr.setPlantaCantContratos(this.plantaCatContrato(idContrato));
			return cdr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<PlantaCantContrato> plantaCatContrato(String idContrato) {
		List<PlantaCantContrato> plantaCatContratos = new ArrayList<>();
		System.out.println("busque el objeto de planta cantidad contrato");
		plantaCatContratos = plantaCantContratoRepository.nativeFindByIdContrato(Integer.parseInt(idContrato));
		System.out.println("encontre: " + plantaCatContratos.size() + " elementos");
		return plantaCatContratos;
	}

	@Override
	public List<PreciosResponse> preciosContrato(String idContrato) {
		List<PreciosResponse> precios = new ArrayList<>();
		List<String> resulQuery = this.consultaRepository.precios(idContrato);
		for (String object : resulQuery) {
			precios.add(new PreciosResponse(object.split(",")));
		}
		return precios;
	}
	
	@Override
	public List<TipoCantidadResponse> tipoCantidad(String idContrato) {
		List<TipoCantidadResponse> cantidad = new ArrayList<>();
		List<String> resulQuery = this.consultaRepository.cantidad(idContrato);
		for (String object : resulQuery) {
			cantidad.add(new TipoCantidadResponse(object.split(",")));
		}
		return cantidad;
	}
	
	@Override
	public List<GarantiasResponse> garantias(String idContrato) {
		List<GarantiasResponse> garantia = new ArrayList<>();
		List<String> resulQuery = this.consultaRepository.garantia(idContrato);
		for (String object : resulQuery) {
			garantia.add(new GarantiasResponse(object.split(",")));
		}
		return garantia;
	}
	
	@Override
	public List<fechaPagoResponse> fechaPago (String idContrato) {
		List<fechaPagoResponse> fechaPago = new ArrayList<>();
		List<String> resulQuery = this.consultaRepository.fechaPago(idContrato);
		for (String object : resulQuery) {
			fechaPago.add(new fechaPagoResponse(object.split(",")));
		}
		return fechaPago;
	}
	
}
