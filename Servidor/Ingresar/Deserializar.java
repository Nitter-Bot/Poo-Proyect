package Acceso;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Deserializar{
	public static Autenticacion loadUsers(){
		try{
			FileInputStream file = new FileInputStream("Usuarios.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			return (Autenticacion) in.readObject();
		}catch(IOException e){
			return new Autenticacion();
		}catch(ClassNotFoundException e){
			return new Autenticacion();
		}
	}
}
