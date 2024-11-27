package VentanasTrabajo;
import java.io.*;
import java.util.*;

public class TrabajoVendedor(){
	Scanner sc = new Scanner(System.in);
	private Vendedor user;
	protected PrintWriter out;
	protected BufferedReader in;

	public TrabajoVendedor(PrintWriter o,BufferedReade in){
		user = new Vendedor();
		this.out = o;
		this.in = in;
	}
	
	public void mostrarTrabajo(){
		do
			menuPrincipal();
		while(elegirPrincipal())
	}

	protected void menuPrincipal(){
		clear();
		System.out.println("-----------	Sistema de venta de vuelos ------------");
		System.out.println("[1] Ver vuelos disponibles			      |");
		System.out.println("[2] Mandar ventas del dia			      |");
		System.out.println("[3] Salir					      |");
		System.out.println("|Elige una opcion_________________________________|");
	}

	protected boolean elegirPrincipal(){
		int op = elegir(-1);

		switch(op){
			case 1:
				
				break;
			case 2:

				break;
			case 3:
				return false;
				break;
			default:
				System.out.println("Opcion Invalida");
		}
		return true;
	}
	
	protected void menuVuelos(){
		System.out.println("[1] Elegir vuelo");
		System.out.println("[2] Regresar");
	}

	protected void elejirVuelos(){
		int op = elegir(-1);
		switch(op){
			case 1:
				
				break;
			case 2:
				
				break;
			default:
				System.out.println("Opcion invalida");
		}
	}

	protected void menuCompra(){
		System.out.println("[1] Elejir Asientos ");
		System.out.println("[2] Quitar Asientos ");
		System.out.println("[3] Realizar compra ");
		System.out.println("[4] Regresar");
	}

	protected void elegirCompra(){
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
			default:
				System.out.println("Opcion invalida");
		}
	}

	protected void clear(){
		System.out.print("\033[H\033[2J");  
		System.out.flush();
	}

	protected void elegir(int op){
		do{
			try{
				op = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Ingresa solo numeros");
			}
		}while(op==-1)
		return op;
	}

}
