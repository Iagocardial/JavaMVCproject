package model;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import view.View;

public class Login {
	private String usuario;
	private String senha;
	
	View v1= new View();
	

	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		
	}


	public Login() {
		// TODO Auto-generated constructor stub
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
