package com.vatia.apirest.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.Ipp;
import com.vatia.apirest.model.VarIpp;
import com.vatia.apirest.repository.IppRepository;
import com.vatia.apirest.repository.VarIppRepository;
import com.vatia.apirest.service.IppService;
import net.minidev.json.JSONObject;

@Service
public class IppServiceImpl implements IppService{
	@Autowired
    private IppRepository ippRepository;
	@Autowired
	private VarIppRepository varIppRepository;


	@Override
	public List<Ipp> findAll() {
		// TODO Auto-generated method stub
		return this.ippRepository.findAll();
	}

	@Override
	public void save(Ipp Ipp) {
		// TODO Auto-generated method stub
		this.ippRepository.save(Ipp);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.ippRepository.deleteById(id);
	}

	@Override
	public List<Ipp> findAllAnio(Integer desde, Integer hasta) {
		// TODO Auto-generated method stub
		return this.ippRepository.getAllAnio(desde,hasta);
	}
	
	@Override
	public Ipp findIppAnio(Integer anio) {
		// TODO Auto-generated method stub
		return this.ippRepository.getIppAnio(anio);
	}

	@Override
	public void updateIpp(Integer fuente, float ipp, int anio, int _int_mes) {

		BigDecimal input_promedio    = inputPromedio(anio);
		this.ippRepository.updateIpp(fuente,input_promedio,ipp,anio,_int_mes);
		
		List<Ipp> lista = this.initialize(5, anio);
		printLista(lista);
		
		this.proyeccion(lista, anio, _int_mes, fuente, 10);

	}
	
	private  void proyeccion(List<Ipp> lista, int anio, int mes,int fuente, int proyectado) {

        int anio_actual = anio;
        int mes_actual = mes;
        BigDecimal cierre_anio_ant   = new BigDecimal(0); 
        BigDecimal ipc_mes_ant       = new BigDecimal(0);
        BigDecimal input_promedio    = new BigDecimal(0);
        Ipp ipp_anio;
        for (int i = 0; i <= proyectado; i++) {
        	
        	ipp_anio = this.ippRepository.getIppAnio(anio_actual);
        	
        	if(ipp_anio == null) {
        		ipp_anio = new Ipp();
        		ipp_anio.setAnio(anio_actual);
                input_promedio = inputPromedio(anio_actual);
                ipp_anio.setIndice(input_promedio);
                ipp_anio.setFuente(fuente);
               // cierre_anio_ant = lista.get(lista.size()-1).getMes12();
        	}
        	
            if (anio_actual > anio) {
                input_promedio = inputPromedio(anio_actual);
                ipp_anio.setIndice(input_promedio);
                cierre_anio_ant = lista.get(lista.size()-1).getMes12();
            } else {
                
                input_promedio = ipp_anio.getIndice();
                cierre_anio_ant = lista.get(lista.size()-2).getMes12();
            }
            
            input_promedio = input_promedio.divide(new BigDecimal(100));

            for (int j = (mes_actual + 1); j < 13; j++) {
            	   
            	 /*
                Formula W9+((V$15*(1+W$17))-W9)/$BL10
                W9    = ipc_mes_ant
                V$15  = cierre_anio_ant
                W$17  = input_promedio
                BL10  = diferencia_mes
                */
            	
            	int dif_mes = 13-j;
            	int mes_ant = j-1;
            	if(mes_ant < 1 ) mes_ant = 1;
            	ipc_mes_ant   = getBeforeMonthValue(lista, ipp_anio, mes_ant);
                float ipc_proyectado_formula = ipc_mes_ant.floatValue()+((cierre_anio_ant.floatValue()*(1+input_promedio.floatValue()))-ipc_mes_ant.floatValue())/dif_mes;
                BigDecimal ipc_proyectado = new BigDecimal(ipc_proyectado_formula);
                setCurrentMonthValue(ipp_anio, j, ipc_proyectado.setScale(2, BigDecimal.ROUND_HALF_UP));
                
                
                System.out.println("------> IPP : ".concat(ipp_anio.toString()));
                System.out.println("------> mes : ".concat(String.valueOf(j)));
                System.out.println("------> ipP_mes_ant : ".concat(ipc_mes_ant.toEngineeringString()));
                System.out.println("------> cierre_anio_ant : ".concat(cierre_anio_ant.toEngineeringString()));	
                System.out.println("------> input_promedio : ".concat(input_promedio.toEngineeringString()));
                System.out.println("------> diferencia_mes : ".concat(String.valueOf(dif_mes)));
                System.out.println("------> IpP_pry_mes : ".concat(ipc_proyectado.toEngineeringString()).concat("\n"));

            }  
            
            if (anio_actual > anio) {
            	lista.add(ipp_anio);
            }
            this.ippRepository.save(ipp_anio);

            JSONObject object	=  this.varIppRepository.getVariacionIppAnio(ipp_anio.getAnio()-1, ipp_anio.getAnio());
            VarIpp varIpp = this.varIppRepository.getVarIppAnio(anio_actual);
        	
        	if(varIpp == null) {
        		varIpp = new VarIpp();
        		varIpp.setAnio((int) object.getAsNumber("ANIO"));
        	}
        	varIpp.setMes1((BigDecimal) object.getAsNumber("MES1"));
        	varIpp.setMes2((BigDecimal) object.getAsNumber("MES2"));
        	varIpp.setMes3((BigDecimal) object.getAsNumber("MES3"));
        	varIpp.setMes4((BigDecimal) object.getAsNumber("MES4"));
        	varIpp.setMes5((BigDecimal) object.getAsNumber("MES5"));
        	varIpp.setMes6((BigDecimal) object.getAsNumber("MES6"));
        	varIpp.setMes7((BigDecimal) object.getAsNumber("MES7"));
        	varIpp.setMes8((BigDecimal) object.getAsNumber("MES8"));
        	varIpp.setMes9((BigDecimal) object.getAsNumber("MES9"));
        	varIpp.setMes10((BigDecimal) object.getAsNumber("MES10"));
        	varIpp.setMes11((BigDecimal) object.getAsNumber("MES11"));
        	varIpp.setMes12((BigDecimal) object.getAsNumber("MES12"));
            this.varIppRepository.save(varIpp);
            mes_actual = 0;
            anio_actual++;
        }

    }
	
	private String getMesUpdate(int _mes) {

		String mes = "";
		switch (_mes) {
		case 1:
			 mes = "MES1"; 
			break;
		case 2:
			 mes = "MES2"; 
			break;
		case 3:
			 mes = "MES3"; 
			break;
		case 4:
			 mes = "MES4"; 
			break;
		case 5:
			 mes = "MES5"; 
			break;
		case 6:
			 mes = "MES6"; 
			break;
		case 7:
			 mes = "MES7"; 
			break;
		case 8:
			 mes = "MES8"; 
			break;
		case 9:
			 mes = "MES9"; 
			break;
		case 10:
			 mes = "MES10"; 
			break;
		case 11:
			 mes = "MES11"; 
			break;
		case 12:
			 mes = "MES12"; 
			break;
		default:
			break;
		}
		
		return mes;
	}

    private  void setCurrentMonthValue(Ipp Ipp, int month, BigDecimal value) {
    	 System.out.println("------> setCurrentMonthValue: ".concat(value.toEngineeringString()).concat(" MES ").concat(String.valueOf(month)));	
        switch (month) {
            case 1:
                Ipp.setMes1(value);
                break;
            case 2:
                Ipp.setMes2(value);
                break;
            case 3:
                Ipp.setMes3(value);
                break;
            case 4:
                Ipp.setMes4(value);
                break;
            case 5:
                Ipp.setMes5(value);
                break;
            case 6:
                Ipp.setMes6(value);
                break;
            case 7:
                Ipp.setMes7(value);
                break;
            case 8:
                Ipp.setMes8(value);
                break;
            case 9:
                Ipp.setMes9(value);
                break;
            case 10:
                Ipp.setMes10(value);
                break;
            case 11:
                Ipp.setMes11(value);
                break;
            case 12:
                Ipp.setMes12(value);
                break;
            default:;
        }
    }

    private BigDecimal getBeforeMonthValue(List<Ipp> lista, Ipp Ipp, int month) {
        BigDecimal Ipp_ant = new BigDecimal(0);

        if (month == 1) {
            Ipp_ant = lista.get(lista.size()-1).getMes12();
        } else {
            switch (month) {
                case 1:
                    Ipp_ant = Ipp.getMes1();
                    break;
                case 2:
                    Ipp_ant = Ipp.getMes2();
                    break;
                case 3:
                    Ipp_ant = Ipp.getMes3();
                    break;
                case 4:
                    Ipp_ant = Ipp.getMes4();
                    break;
                case 5:
                    Ipp_ant = Ipp.getMes5();
                    break;
                case 6:
                    Ipp_ant = Ipp.getMes6();
                    break;
                case 7:
                    Ipp_ant = Ipp.getMes7();
                    break;
                case 8:
                    Ipp_ant = Ipp.getMes8();
                    break;
                case 9:
                    Ipp_ant = Ipp.getMes9();
                    break;
                case 10:
                    Ipp_ant = Ipp.getMes10();
                    break;
                case 11:
                    Ipp_ant = Ipp.getMes11();
                    break;
                case 12:
                    Ipp_ant = Ipp.getMes12();
                    break;
                default:;
            }
        }

        return Ipp_ant;
    }

    private List<Ipp> initialize(int cant, int anio) {
    	
    	return this.ippRepository.getAllAnio((anio-cant), anio);

    }

    private  BigDecimal inputPromedio(int anio_actual) {
    	int aniop1 = anio_actual-1;
		int aniop2 = anio_actual-2;
		int aniop3 = anio_actual-3;
		int aniop4 = anio_actual-4;
		int aniop5 = anio_actual-5;
		System.out.println("\n Anio prom: "+anio_actual+" - "+aniop1+" - "+aniop2+" - "+aniop3+" - "+aniop4+" - "+aniop5);
		float variacion = this.ippRepository.getIndice(anio_actual,aniop1,aniop2,aniop3,aniop4,aniop5);
		return new BigDecimal(variacion);
    }

    private  void printLista(List<Ipp> lista) {
        for (Ipp Ipp : lista) {
            System.out.println(Ipp.toString());
        }
    }
}
