package com.vatia.apirest.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vatia.apirest.model.Ipc;
import com.vatia.apirest.model.VarIpc;
import com.vatia.apirest.repository.IpcRepository;
import com.vatia.apirest.repository.VarIpcRepository;
import com.vatia.apirest.service.IpcService;
import net.minidev.json.JSONObject;

@Service
public class IpcServiceImpl implements IpcService{
	@Autowired
    private IpcRepository ipcRepository;
	@Autowired
	private VarIpcRepository varIpcRepository;

	@Override
	public List<Ipc> findAll() {
		// TODO Auto-generated method stub
		return this.ipcRepository.findAll();
	}

	@Override
	public void save(Ipc ipc) {
		// TODO Auto-generated method stub
		this.ipcRepository.save(ipc);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.ipcRepository.deleteById(id);
	}

	@Override
	public List<Ipc> findAllAnio(Integer desde, Integer hasta) {
		// TODO Auto-generated method stub
		return this.ipcRepository.getAllAnio(desde,hasta);
	}
	
	@Override
	public Ipc findIpcAnio(Integer anio) {
		// TODO Auto-generated method stub
		return this.ipcRepository.getIpcAnio(anio);
	}

	@Override
	public void updateIpc(Integer fuente, float variacion, float ipc, int anio, int _int_mes, int anoV) {
	
		if (ipc != 0.0) {
			this.ipcRepository.updateIpc(fuente, variacion, ipc, anio, _int_mes);
		}
		
		if (anoV != 0) {
			this.ipcRepository.updateIpcVariacion(fuente, variacion, anoV);
		}
		
		if (anio != 0) {
			List<Ipc> lista = this.initialize(5, anio);
			printLista(lista);
			this.proyeccion(lista, lista.get(lista.size() - 1), anio, _int_mes, fuente, 10);
		}
	}
	
	private  void proyeccion(List<Ipc> lista, Ipc ipc, int anio, int mes,int fuente, int proyectado) {

        int anio_actual = anio;
        int mes_actual = mes;
        BigDecimal cierre_anio_ant   = new BigDecimal(0); 
        BigDecimal ipc_mes_ant       = new BigDecimal(0);
        BigDecimal input_promedio    = new BigDecimal(0);
        Ipc ipc_anio;
        for (int i = 0; i <= proyectado; i++) {
        	
        	ipc_anio = this.ipcRepository.getIpcAnio(anio_actual);
        	
        	if(ipc_anio == null) {
        		ipc_anio = new Ipc();
                ipc_anio.setAnio(anio_actual);
                input_promedio = inputPromedio(lista);
                ipc_anio.setIndice(input_promedio);
                ipc_anio.setFuente(fuente);
               // cierre_anio_ant = lista.get(lista.size()-1).getMes12();
        	}
        	
            if (anio_actual > anio) {
                input_promedio = new BigDecimal(3); //inputPromedio(lista);
                ipc_anio.setIndice(input_promedio);
                cierre_anio_ant = lista.get(lista.size()-1).getMes12();
            } else {
                
                input_promedio = ipc_anio.getIndice();
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
            	ipc_mes_ant   = getBeforeMonthValue(lista, ipc_anio, mes_ant);
                float ipc_proyectado_formula = ipc_mes_ant.floatValue()+((cierre_anio_ant.floatValue()*(1+input_promedio.floatValue()))-ipc_mes_ant.floatValue())/dif_mes;
               // BigDecimal ipc_proyectado = new BigDecimal(ipc_proyectado_formula);
                
                BigDecimal ipc_proyectado = BigDecimal.valueOf(ipc_proyectado_formula);
                
                setCurrentMonthValue(ipc_anio, j, ipc_proyectado.setScale(2, BigDecimal.ROUND_HALF_UP));
                
                
                /*System.out.println("------> IPC : ".concat(ipc_anio.toString()));
                System.out.println("------> mes : ".concat(String.valueOf(j)));
                System.out.println("------> ipc_mes_ant : ".concat(ipc_mes_ant.toEngineeringString()));
                System.out.println("------> cierre_anio_ant : ".concat(cierre_anio_ant.toEngineeringString()));	
                System.out.println("------> input_promedio : ".concat(input_promedio.toEngineeringString()));
                System.out.println("------> diferencia_mes : ".concat(String.valueOf(dif_mes)));
                System.out.println("------> Ipc_pry_mes : ".concat(ipc_proyectado.toEngineeringString()).concat("\n"));*/

            }
            
            if (anio_actual > anio) {
            	lista.add(ipc_anio);
            }
            this.ipcRepository.save(ipc_anio);
            
            JSONObject object	=  this.varIpcRepository.getVariacionIpcAnio(ipc_anio.getAnio()-1, ipc_anio.getAnio());
            VarIpc varIpc = this.varIpcRepository.getVarIpcAnio(anio_actual);
        	
        	if(varIpc == null) {
        		varIpc = new VarIpc();
        		 varIpc.setAnio((int) object.getAsNumber("ANIO"));
        	}
            varIpc.setMes1((BigDecimal) object.getAsNumber("MES1"));
            varIpc.setMes2((BigDecimal) object.getAsNumber("MES2"));
            varIpc.setMes3((BigDecimal) object.getAsNumber("MES3"));
            varIpc.setMes4((BigDecimal) object.getAsNumber("MES4"));
            varIpc.setMes5((BigDecimal) object.getAsNumber("MES5"));
            varIpc.setMes6((BigDecimal) object.getAsNumber("MES6"));
            varIpc.setMes7((BigDecimal) object.getAsNumber("MES7"));
            varIpc.setMes8((BigDecimal) object.getAsNumber("MES8"));
            varIpc.setMes9((BigDecimal) object.getAsNumber("MES9"));
            varIpc.setMes10((BigDecimal) object.getAsNumber("MES10"));
            varIpc.setMes11((BigDecimal) object.getAsNumber("MES11"));
            varIpc.setMes12((BigDecimal) object.getAsNumber("MES12"));
            this.varIpcRepository.save(varIpc);
            mes_actual = 0;
            anio_actual++;
        }

    }

    private  void setCurrentMonthValue(Ipc ipc, int month, BigDecimal value) {
	
        switch (month) {
            case 1:
                ipc.setMes1(value);
                break;
            case 2:
                ipc.setMes2(value);
                break;
            case 3:
                ipc.setMes3(value);
                break;
            case 4:
                ipc.setMes4(value);
                break;
            case 5:
                ipc.setMes5(value);
                break;
            case 6:
                ipc.setMes6(value);
                break;
            case 7:
                ipc.setMes7(value);
                break;
            case 8:
                ipc.setMes8(value);
                break;
            case 9:
                ipc.setMes9(value);
                break;
            case 10:
                ipc.setMes10(value);
                break;
            case 11:
                ipc.setMes11(value);
                break;
            case 12:
                ipc.setMes12(value);
                break;
            default:;
        }
    }

    private BigDecimal getBeforeMonthValue(List<Ipc> lista, Ipc ipc, int month) {
        BigDecimal ipc_ant = new BigDecimal(0);

        if (month == 1) {
            ipc_ant = lista.get(lista.size()-1).getMes12();
        } else {
            switch (month) {
                case 1:
                    ipc_ant = ipc.getMes1();
                    break;
                case 2:
                    ipc_ant = ipc.getMes2();
                    break;
                case 3:
                    ipc_ant = ipc.getMes3();
                    break;
                case 4:
                    ipc_ant = ipc.getMes4();
                    break;
                case 5:
                    ipc_ant = ipc.getMes5();
                    break;
                case 6:
                    ipc_ant = ipc.getMes6();
                    break;
                case 7:
                    ipc_ant = ipc.getMes7();
                    break;
                case 8:
                    ipc_ant = ipc.getMes8();
                    break;
                case 9:
                    ipc_ant = ipc.getMes9();
                    break;
                case 10:
                    ipc_ant = ipc.getMes10();
                    break;
                case 11:
                    ipc_ant = ipc.getMes11();
                    break;
                case 12:
                    ipc_ant = ipc.getMes12();
                    break;
                default:;
            }
        }

        return ipc_ant;
    }

    private List<Ipc> initialize(int cant, int anio) {
    	
    	return this.ipcRepository.getAllAnio((anio-cant), anio);
    }

    private  BigDecimal inputPromedio(List<Ipc> lista) {
        BigDecimal inputp = new BigDecimal(0);
        String entradas = "";
        for (int i = lista.size() - 1; (lista.size() - 6) < i; i--) {
            inputp = inputp.add(lista.get(i).getIndice());
            entradas  = entradas+" Año:"+lista.get(i).getAnio()+" Indice: "+lista.get(i).getIndice()+"\n";
        }

        inputp = inputp.divide(new BigDecimal(5));
        return inputp;
    }

    private  void printLista(List<Ipc> lista) {
        for (Ipc ipc : lista) {
            System.out.println(ipc.toString());
        }
    }

}
