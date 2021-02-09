package com.vatia.apirest.pkBI;

import java.io.Serializable;

public class ClientePk implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String idCliente;
	private String FECHA_ESTADO_HIS_MER;
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getFECHA_ESTADO_HIS_MER() {
		return FECHA_ESTADO_HIS_MER;
	}
	public void setFECHA_ESTADO_HIS_MER(String fECHA_ESTADO_HIS_MER) {
		FECHA_ESTADO_HIS_MER = fECHA_ESTADO_HIS_MER;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FECHA_ESTADO_HIS_MER == null) ? 0 : FECHA_ESTADO_HIS_MER.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePk other = (ClientePk) obj;
		if (FECHA_ESTADO_HIS_MER == null) {
			if (other.FECHA_ESTADO_HIS_MER != null)
				return false;
		} else if (!FECHA_ESTADO_HIS_MER.equals(other.FECHA_ESTADO_HIS_MER))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
	
	
	
}
