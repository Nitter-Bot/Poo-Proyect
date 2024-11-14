package Acceso;
import java.io.Serializable;
import java.util.HashMap;

public class Autenticacion implements Serializable{
	private static final long serialVersionUID  = 1L;

	private HashMap<String,Usuario> users = new HashMap();

	public void signUpUser(String u,String p){
		users.put(u,new Usuario(u,p));
	}

	public void printMap(){
		for(Usuario u:users.values()){
			System.out.println("[" + u.getUser() + ":" + u.getPassword()+"]\n");
		}
	}
}

