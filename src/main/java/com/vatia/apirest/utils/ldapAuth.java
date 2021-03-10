package com.vatia.apirest.utils;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;

/**
 * Contiene la Funcionalidad de Autenticacion y busquede de atributos de un
 * usuario en el LDAP
 *
 * @since 1.5
 * @version 1.0
 */
public final class ldapAuth {

	private String server;
	private String usuario;
	private String clave;
	private String servidor;
	private String dn;
	private String tipoAuth;
	private boolean autenticado;
	private String[] atributos;

	private String userName;
	private String password;
	private String[] urlServer;
	private static final String DOMAIN = "VATIACORP.LOCAL";
	private static final String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
	private static final String FILTER1 = "(&(objectCategory=person)(objectClass=user)";
	private static final String SEARCHBASE = "dc=VATIACORP,dc=LOCAL";

	DirContext dc;

	/**
	 * Constructor de la conexion con el Motor de LDAP
	 *
	 * @param server  Servidor en donde se encuentra el LDAP
	 * @param dn      Directoria del arbol del LDAP
	 * @param ta      Tipo de Autenticacion
	 * @param usuario Usuario que desea realizar la conexion
	 * @param clave   Clave del usuario
	 * @throws Exception
	 *
	 */
	public ldapAuth(String userName, String password) throws Exception {
		super();
		this.server = server;
		this.userName = userName;
		this.password = password;
		//this.urlServer = this.nsLookup(DOMAIN);
		inicializarConexion();
	}

	public void inicializarConexion() throws Exception {
		{
			// for (String url : urlServer) {
			String url = "ldap://dcsrv01.vatiacorp.local:389";
			System.out.println("url: " + url);
			String filter2 = "(SAMAccountName=" + this.userName + "))";
			String searchFilter = FILTER1 + filter2;
			String securityAuthentication = "simple";
			String securityPrincipal = this.userName + "@" + DOMAIN;
			String dn = "cn=" + this.userName + "," + SEARCHBASE;

			Hashtable<String, String> environment = new Hashtable<String, String>();
			environment.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			environment.put(Context.PROVIDER_URL, url);
			environment.put(Context.SECURITY_AUTHENTICATION, securityAuthentication);
			environment.put(Context.SECURITY_PRINCIPAL, securityPrincipal);
			environment.put(Context.SECURITY_CREDENTIALS, this.password);

			try {
				DirContext authContext = new InitialDirContext(environment);
				String query = "(&(objectCategory=person)(objectClass=user)(sAMAccountName="+this.userName+"))";
				SearchControls ctrl = new SearchControls();
				ctrl.setSearchScope(SearchControls.SUBTREE_SCOPE);

				NamingEnumeration<SearchResult> enumeration = authContext.search("dc=vatiacorp,dc=local", query, ctrl);

				// while (enumeration.hasMore()) {
				SearchResult result = (SearchResult) enumeration.next();
				Attributes attribs = result.getAttributes();
				NamingEnumeration<String> attribsIDs = attribs.getIDs();
				String nombre = "Undefined", mail = this.userName+"@vatia.com.co", title = "Undefined", company = "Undefined",
						dateCreated = "Undefined";
				while (attribsIDs.hasMore()) {
					String key = attribsIDs.next();
					if (key.equals("displayName")) {
						nombre = (String) attribs.get("displayName").get();
					}
					if (key.equals("mail")) {
						mail = (String) attribs.get("mail").get();
					}
					if (key.equals("title")) {
						title = (String) attribs.get("title").get();
					}
					if (key.equals("company")) {
						company = (String) attribs.get("company").get();
					}
					if (key.equals("whenCreated")) {
						dateCreated = (String) attribs.get("whenCreated").get();
					}
				}
				// }
				String[] atributosUser = new String[] {nombre,mail,title,company,dateCreated};
				setAtributos(atributosUser);
				setAutenticado(true);
			} catch (NamingException ex) {
				System.out.println("Error Autenticando mediante LDAP, Error causado por : " + ex.toString());
				setAutenticado(false);
				setAtributos(new String[] {});
			}

			// }
		}

	}

	/**
	 * Retorna el Atributo de la conexion con LDAP actual
	 * 
	 * @param atributo Nombre del Atributo que se desea obtener
	 * @return Attribute con la informacion correspondiente
	 */

	public Attribute cargarPropiedadConexion(String atributo) {
		Attribute propiedad = null;

		try {
			Attributes attrs = dc.getAttributes(dn);

			if (attrs == null) {
				propiedad = null;
			} else {
				propiedad = attrs.get(atributo);
			}
		} catch (Exception e) {
			propiedad = null;
		}
		return propiedad;
	}

	private String[] nsLookup(String argDomain) throws Exception {
		try {
			Hashtable<Object, Object> env = new Hashtable<Object, Object>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
			env.put("java.naming.provider.url", "dns:");
			DirContext ctx = new InitialDirContext(env);
			Attributes attributes = ctx.getAttributes(String.format("_ldap._tcp.%s", argDomain),
					new String[] { "srv" });
			// try thrice to get the KDC servers before throwing error
			for (int i = 0; i < 3; i++) {
				Attribute a = attributes.get("srv");
				if (a != null) {
					List<String> domainServers = new ArrayList<String>();
					NamingEnumeration<?> enumeration = a.getAll();
					while (enumeration.hasMoreElements()) {
						String srvAttr = (String) enumeration.next();
						// the value are in space separated 0) priority 1)
						// weight 2) port 3) server
						String values[] = srvAttr.toString().split(" ");

						String ldap3 = values[3] = values[3].substring(0, values[3].length() - 1);

						domainServers.add(String.format("ldap://%s:%s", ldap3, values[2]));
					}
					String domainServersArray[] = new String[domainServers.size()];
					domainServers.toArray(domainServersArray);
					return domainServersArray;
				}
			}
			throw new Exception("Unable to find srv attribute for the domain " + argDomain);
		} catch (NamingException exp) {
			throw new Exception("Error while performing nslookup. Root Cause: " + exp.getMessage(), exp);
		}
	}

	/* Get's y Set's */
	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String[] getAtributos() {
		return atributos;
	}

	public void setAtributos(String[] atributos) {
		this.atributos = atributos;
	}
	
}