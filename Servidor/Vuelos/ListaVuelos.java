package Vuelos;
import java.io.*;
import java.util.*;

public class ListaVuelos implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Vuelo> vuelos ;

	public ListaVuelos(){
		this.vuelos = Collections.synchronizedList(new LinkedList<>());
	}

	public synchronized void printVuelos(PrintWriter out){
		out.print("\033[H\033[2J"); 
		out.flush();
		if(vuelos.isEmpty()){
			out.flush();
			out.println("No hay vuelos disponibles!!!");
			return;
		}
		int n = 1;
		out.flush();
		out.println("Vuelos disponibles");
		out.println("*-----------------------------------*");
		for(Vuelo v : vuelos){
			out.println("| "+n + " | "+ v.getOrigen() + " -> " 
			+ v.getDestino() + " | " + v.getFecha() );
			n+=1;
			out.println("*-----------------------------------*");
		}
	}
	
	public synchronized void agregarVuelo(Vuelo v){
		vuelos.add(v);
	}

	public synchronized void getVuelo(int index, PrintWriter out){
		Vuelo v = vuelos.get(index-1);
		v.mostrarAsientosDisponibles(out);

	}
}
