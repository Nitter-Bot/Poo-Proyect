package VentanasTrabajo;
import java.io.*;
import java.util.*;
import Actores.*;
import java.net.Socket;

public class TrabajoVendedor{
	Scanner sc = new Scanner(System.in);
	private Vendedor user;
	protected InputStream INPUT;
	protected OutputStream OUTPUT;
	protected ObjectOutputStream outObj;
	protected PrintWriter out;
	protected BufferedReader in;
	protected ObjectInputStream inObj;
	protected DataOutputStream outFile;
	protected DataInputStream inFile;

	public TrabajoVendedor(PrintWriter o,BufferedReader in,ObjectOutputStream outObj,ObjectInputStream inObj,DataOutputStream outFile, DataInputStream inFile){
		user = new Vendedor();
		this.out = o;
		this.in = in;
		this.outObj = outObj;
		this.inObj = inObj;
		this.outFile = outFile;
		this.inFile = inFile;
	}
	
	public void mostrarTrabajo(){
		do
			menuPrincipal();
		while(elegirPrincipal());
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
				do{
					clear();
					out.println("dameVuelos");
					menuVuelos();
				}while(elegirVuelos());
				break;
			case 2:
				
				break;
			case 3:
				out.println("exit");
				return false;
			default:
				System.out.println("Opcion Invalida");
		}
		return true;
	}
	
	protected void menuVuelos(){
		System.out.println("\n\n[1] Elegir vuelo");
		System.out.println("[2] Regresar");
		System.out.println("Elige tu opcion: ");
	}

	protected boolean elegirVuelos(){
		int op = elegir(-1);
		switch(op){
			case 1:
				System.out.print("Ingresa numero del vuelo: ");
				int n = elegir(-1);
				clear();
				do{
					out.println("Vuelo");
					out.println(n);
					menuCompra();
				}while(elegirCompra(n));
				
				break;
			case 2:
				return false;
			default:
				System.out.println("Opcion invalida");
		}
		return true;
	}

	protected void menuCompra(){
		System.out.println("\n\n[1] Elegir Asientos ");
		System.out.println("[2] Quitar Asientos ");
		System.out.println("[3] Realizar compra ");
		System.out.println("[4] Regresar");
	}

	protected boolean elegirCompra(int n){
		int op = elegir(-1);
		switch(op){
			case 1:
				user.asignar();
				zzz();
				break;
			case 2:
				user.quitar();
				System.out.println("Regresando...");
				zzz();
				break;
			case 3:
				if(user.emptySet()){
					System.out.println("No se ha asignado nada");
					zzz();
					clear();
				}else{
					out.println("asignar");
					out.println(n);
					out.println(user.szSet());
					user.seats(out);
					System.out.println("Generando recibo, confirmos los datos");
					System.out.println("ID : ");
					String ID = sc.nextLine();
					System.out.println("Origen: ");
					String or = sc.nextLine();
					System.out.println("Destino: ");
					String des = sc.nextLine();
					System.out.println("Fecha: ");
					String date = sc.nextLine();
					System.out.println("Costo:");
					double costo = Double.parseDouble(sc.nextLine())* user.szSet();
					//user.mandarVentas(out);
					user.realizarVenta(user.szSet(),ID);
					//user.GenerarReciboTicket(or,des,date,costo,ID);
					System.out.println("Venta Realiza y registrada");
				}
				break;
			case 4:
				return false;
			default:
				System.out.println("Opcion invalida");
		}
		return true;
	}

	protected void clear(){
		System.out.print("\033[H\033[2J");  
		System.out.flush();
	}

	protected int elegir(int op){
		do{
			try{
				op = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Ingresa solo numeros");
			}
		}while(op==-1);
		return op;
	}

	protected void zzz(){
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
