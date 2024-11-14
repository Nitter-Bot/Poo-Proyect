import Acceso.*;

class Prueba{
	public static void main(String [] args){
		Autenticacion a = Deserializar.loadUsers();
		a.printMap();

		a.signUpUser("Vale","pass");
		a.signUpUser("Samuel","pass");

		Serializar.saveUsers(a);
	}
}
