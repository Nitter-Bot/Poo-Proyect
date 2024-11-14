package Acceso;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializar{
	public static Autenticacion loadUsers(){
		try{
			FileInputStream file = new FileInputStream("Usuarios.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			return (Autenticacion) in.readObject();
		}catch(IOException e){
			return null;
		}
	}
}
