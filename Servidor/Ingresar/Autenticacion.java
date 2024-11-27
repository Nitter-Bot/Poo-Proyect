package Acceso;
import java.io.Serializable;
import java.util.concurrent.*;

public class Autenticacion implements Serializable{
	private static final long serialVersionUID  = 1L;

	private ConcurrentHashMap<String,Usuario> users = new ConcurrentHashMap<>();

	public void signUpUser(String u,String p,String r){
		users.put(u,new Usuario(u,p,r));
	}

	public void printMap(){
		for(Usuario u:users.values()){
			System.out.println("[" + u.getUser() + ":" + u.getPassword()+"]\n");
		}
	}

	public boolean userExists(String userToValidate){
		return users.get(userToValidate)!=null;
	}
	
	public Usuario getUser(String user){
		return users.get(user);
	}

	public boolean logIn(String user,String password){
		Usuario u = users.get(user);
		if( u == null || u.connected())return false;

		if(u.getPassword().equals(password)){
			u.setConnect(true);
			return true;
		}else return false;
	}
}

