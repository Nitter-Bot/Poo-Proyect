package Control;
import Acceso.*;

public class ControlUsuarios{
	private Autenticacion authControler = Deserializar.loadUsers();

	public String addUser(String user,String password){
		if(!authControler.userExists(user)){
			authControler.signUpUser(user,password);
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


