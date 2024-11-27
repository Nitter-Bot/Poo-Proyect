package Acceso;
import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	private boolean connect;
	
	public Usuario(String user,String password){
		this.user = user;
		this.password = password;
		this.connect = false;
	}

	public void setUser(String u){
		user = u;
	}
	
	public String getUser(){
		return user;
	}
	public void setPassword(String p){
		password = p;
	}
	
	public String getPassword(){
		return password;
	}

	public void setConnect(boolean c){
		connect = c;
	}

	public boolean connected(){
		return connect;
	}
}

