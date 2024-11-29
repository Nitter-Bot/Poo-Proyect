package VentanasTrabajo;
import java.io.*;
import java.util.*;
import Actores.Supervisor;

public class TrabajoSupervisor extends TrabajoVendedor{
	private Supervisor user;

	public TrabajoSupervisor(PrintWriter o,BufferedReade in){
		user = new Supervisor();
		this.out = o;
		this.in = in;
	}

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
		int op = -1;
		do{
			try{
				op = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Ingresa solo numeros");
			}
		}while(op!=-1)

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
	}

	protected void menuVerVendedores(){
		System.out.println("[1] Agregar Vendedor");
		System.out.println("[2] Despedir Vendedor");
		System.out.println("[3] Regresar");
	}

	protected void elegirVendedores(){
		int op = elegir(-1);
		switch(op){
			case:
				
				break;
			case:
				
				break;
			case:
				
				break;
			default:
				System.out.println("Opcion Invalida");
		}

	}
}
