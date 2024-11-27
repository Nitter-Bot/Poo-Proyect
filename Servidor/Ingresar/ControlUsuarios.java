package Control;
import Acceso.*;

public class ControlUsuarios{
	private Autenticacion authControler = Deserializar.loadUsers();

	public String addUser(String user,String password,String rol){
		if(!authControler.userExists(user)){
			authControler.signUpUser(user,password,rol);
			return "Usuario registrado con exito";
		}else return "Usuario no valido, ya existe";
	}

	public boolean accessGranted(String user,String password){
		if (authControler.logIn(user,password)){
			return true;
		}else{
			return false;
		}
	}

	public void save(){
		Serializar.saveUsers(authControler);
	}

	public String rol(String user){
		return authControler.getUser(user).getRol();
	}

	public synchronized void desconectarUsuario(String user){
		authControler.getUser(user).setConnect(false);
	}

	/*public void disconnectUser(){
		authControler.set
	}*/

	/* Prueba marrana
		public static void main(String [] args){
		ControlUsuarios ctrl = new ControlUsuarios();
		System.out.println(ctrl.addUser("admin","Pass"));
		ctrl.addUser("Valecita","Pass");
		Usuario u = ctrl.accessGranted("Valecita","Pass");
		System.out.println(u.getUser());
		Serializar.saveUsers(ctrl.authControler);
	}*/
}


