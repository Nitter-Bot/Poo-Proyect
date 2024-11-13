package Acceso;

class Usuario{
	private String user;
	private String password;
	
	public Usuario(String user,String password){
		this.user = user;
		this.password = password;
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
}

