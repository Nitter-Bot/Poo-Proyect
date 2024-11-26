package Vuelos;
import java.io.*;

public class Serializar{
	public static void saveVuelos(ListaVuelos a){
		try{
			FileOutputStream list = new FileOutputStream("Vuelos.txt");
			ObjectOutputStream ob = new ObjectOutputStream(list);
			ob.writeObject(a);
			ob.close();
			list.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
