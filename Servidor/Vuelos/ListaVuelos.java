package Vuelos;
import java.io.*;
import java.util.*;

public class ListaVuelos implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Vuelo> vuelos ;

	public ListaVuelos(){
		this.vuelos = Collections.synchronizedList(new LinkedList<>());
	}

	public synchronized List<Vuelo> getVuelos(){
		return vuelos;
	}

	public void printVuelos(){
		if(vuelos.isEmpty()){
			System.out.flush();
			System.out.println("No hay vuelos disponibles!!!");
			return;
		}
		int n = 1;
		System.out.flush();
		System.out.println("Vuelos disponibles");
		System.out.println("*-----------------------------------*");
		for(Vuelo v : vuelos){
			System.out.println("| "+n + " | "+ v.getOrigen() + " -> " 
			+ v.getDestino() + " | " + v.getFecha() );
			n+=1;
			System.out.println("*-----------------------------------*");
		}
	}

	public synchronized void sendVuelos(ObjectOutputStream out){
		try{
			FileOutputStream list = new FileOutputStream("CurrentStatus.txt");
			ObjectOutputStream ob = new ObjectOutputStream(list);
			ob.writeObject(list);
			out.writeObject(ob);
			ob.close();
			list.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public synchronized void receiveVuelos(ObjectInputStream in){
		try{
			vuelos = ((ListaVuelos)in.readObject()).getVuelos();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public synchronized void agregarVuelo(Vuelo v){
		vuelos.add(v);
	}

	public synchronized Vuelo getVuelo(int index){
		return vuelos.get(index-1);
	}
}
