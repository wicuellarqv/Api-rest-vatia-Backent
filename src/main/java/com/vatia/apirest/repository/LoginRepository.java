package com.vatia.apirest.repository;

public interface LoginRepository {

	public static boolean validateLogin(String usuario, String clave) {
		if (usuario.equals("admin") && clave.equals("admin"))
			return true;
		else
			return false;
	}
}
