package Acceso;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializar{
	public static void saveUsers(Autenticacion a){
		try{
			FileOutputStream listUsers = new FileOutputStream("Usuarios.txt");
			ObjectOutputStream ob = new ObjectOutputStream(listUsers);
			ob.writeObject(a);
			ob.close();
			listUSers.close();
			System.out.println("Datos guardados");
		}catch(IOException e){
			System.out.println("Hubo un error");
		}
	}
}
