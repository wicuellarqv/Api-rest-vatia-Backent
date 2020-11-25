package com.vatia.apirest.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.vatia.apirest.repository.LoginRepository;
import com.vatia.apirest.utils.ldapAuth;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1")
public class LoginController {
	

	//@CrossOrigin(origins = "http://10.112.201.220:80")
	@PostMapping("/auth")
	public Response login(@RequestParam String user, @RequestParam String password) throws Exception {
	//	Boolean status = LoginRepository.validateLogin(user, password);
		ldapAuth ldapAuth = new ldapAuth(user, password);
		if (ldapAuth.isAutenticado()) {
			System.out.println("Usuario " + user + " Autenticado Correctamente");
			String token = getJWTToken("admin");
			// System.out.print(token);
			JSONObject json = new JSONObject();
			json.appendField("token", token);
			// json.appendField("token", "Token");
			return Response.status(Response.Status.ACCEPTED).entity(json).build();
		} else {
			System.out.println("Usuario " + user + " No se Puedo Autenticar");
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("Este_es_mi_id")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 21600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
}
