import Acceso.*;

class ControlUsuarios{
	private Autenticacion authControler = Deserializar.loadUsers();
	


	public static void main(String [] args){
		a.printMap();

		a.signUpUser("Vale","pass");
		a.signUpUser("Samuel","pass");

		Serializar.saveUsers(a);
	}
}
