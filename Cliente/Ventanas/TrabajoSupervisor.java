package VentanasTrabajo;
import java.io.*;
import java.util.*;
import Actores.Supervisor;

public class TrabajoSupervisor extends TrabajoVendedor{
	private Supervisor user;

	public TrabajoSupervisor(PrintWriter o,BufferedReader in,ObjectOutputStream ob){
		super(o,in,ob);
	}
	/*
	@Override
	protected void menuPrincipal(){
		clear();
		System.out.println("-----------	Sistema de venta de vuelos ------------");
		System.out.println("[1] Ver vuelos disponibles			      |");
		System.out.println("[2] Manage Vendedores			      |");
		System.out.println("[3] Agregar Vuelos				      |");
		System.out.println("[4] Mandar ventas del dia			      |");
		System.out.println("[5] Salir					      |");
		System.out.println("|Elige una opcion_________________________________|");
	}

	@Override
	protected void elegirPrincipal(){
		int op = elegir(-1);
	

		switch(op){
			case 1:
				
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				
				break;
			default:
				System.out.println("Opcion Invalida");
		}
	}*/

	protected void menuVerVendedores(){
		System.out.println("[1] Agregar Vendedor");
		System.out.println("[2] Despedir Vendedor");
		System.out.println("[3] Regresar");
	}

	protected boolean elegirVendedores(){
		int op = elegir(-1);
		switch(op){
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				return false;	
			default:
				System.out.println("Opcion Invalida");
		}
		return true;

	}
}
