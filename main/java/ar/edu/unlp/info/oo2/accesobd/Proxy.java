package ar.edu.unlp.info.oo2.accesobd;

import java.util.Collection;
import java.util.List;

public class Proxy implements DatabaseAccess {

	private DatabaseAccess service;
	private boolean loggedIn;
	private String password;
	
	public Proxy(DatabaseAccess service, String password) {
		this.service = service;
		this.password = password;
		this.loggedIn = false;
	}
	
	public boolean checkAuth() {
		return this.loggedIn;
	}
	
	public void logIn(String password) {
		if(!this.loggedIn)
			this.loggedIn = this.password.equals(password);
	}
	
	public void logOut() {
		this.loggedIn = false;
	}
	
	@Override
	public Collection<String> getSearchResults(String queryString) {
		if(this.checkAuth())
			return service.getSearchResults(queryString);
		return null;
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.checkAuth())
			return service.insertNewRow(rowData);
		return -1;
	}

}
