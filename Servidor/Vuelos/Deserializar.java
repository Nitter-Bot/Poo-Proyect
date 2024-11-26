package Vuelos;
import java.io.*;
import java.util.*;

public class Deserializar{
	public static ListaVuelos loadVuelos(){
		try{
			FileInputStream list = new FileInputStream("Vuelos.txt");
			ObjectInputStream ob = new ObjectInputStream(list);
			return (ListaVuelos) ob.readObject();
		}catch(IOException e){
			return new ListaVuelos();
		}catch(ClassNotFoundException e){
			return new ListaVuelos();
		}
		
	}
}
