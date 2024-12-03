package Vuelos;
import java.io.*;

public class Serializar{
	public static void saveVuelos(ListaVuelos a){
		try{
			FileOutputStream list = new FileOutputStream("Vuelos.txt");
			ObjectOutputStream ob = new ObjectOutputStream(list);
			ob.writeObject(a);
			System.out.println("Vuelos guardados en la base de datos");
			ob.close();
			list.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
