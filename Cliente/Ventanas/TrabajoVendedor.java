package VentanasTrabajo;
import java.io.*;
import java.util.*;
import Actores.Vendedor;

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
				do{
					clear();
					out.println("dameVuelos");
					menuVuelos();
				}while(elegirVuelos())
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
				while(elegirCompra())
				
				break;
			case 2:
				return false;
				break;
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

	protected boolean elegirCompra(){
		int op = elegir(-1);
		switch(op){
			case 1:
				user.asignar();
				zzz();
				break;
			case 2:
				user.quitar();
				System.out.println("Regresando...")
				zzz();
				break;
			case 3:
				if(user.emptySet()){
					"No se ha asignado nada";
					zzz();
					clear();
				}else{
					out.println("asignar");
					out.println(user.szSet());
					user.seats();
					System.out.println("ID : ");
					String ID = sc.nextLine();
					user.realizarVenta(user.szSet(),ID);
				}
				break;
			case 4:
				return false;
				break;
			default:
				System.out.println("Opcion invalida");
		}
		return true;
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

	protected void zzz(){
		try{
			Thread.sleep(2000);
		}catch(InterruptedException){
			e.printStackTrace();
		}
	}

}
