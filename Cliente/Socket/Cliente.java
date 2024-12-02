import java.io.*;
import java.net.*;
import java.util.Scanner;
import VentanasTrabajo.*;

public class Cliente{
	private static String SERVER_ADDRESS;
	private static int SERVER_PORT;
	private static Scanner scanner = new Scanner(System.in);
	private static Socket socket;
	private static String msj;
	private static String userRol;

	public static void main(String[] args) {
		
		do
		    getServer();
		while(!makeConnection());

		try {
			OutputStream OUT = socket.getOutputStream();
			InputStream IN = socket.getInputStream();

			ObjectOutputStream outObj = new ObjectOutputStream(OUT);
			ObjectInputStream inObj = new ObjectInputStream(IN);
			PrintWriter out = new PrintWriter(OUT, true);
			BufferedReader in = new BufferedReader(new InputStreamReader(IN));
			DataOutputStream outFile = new DataOutputStream(OUT);
			DataInputStream inFile = new DataInputStream(IN);
			System.out.flush();
			//Verificacion, un solo intento
			System.out.println(in.readLine());
			out.println(scanner.nextLine());
			System.out.println(in.readLine());
			out.println(scanner.nextLine());
			userRol = in.readLine();
			clearC();
			if(userRol.equals("close")){
				System.out.println("No paso la verificacion\n Cerrando programa ...");
				return;
			}
			//Hilo para leer los msj del servidor
			new Thread(() -> {
				try {
					String serverResponse;
					while ((serverResponse = in.readLine()) != null) {
						if(serverResponse.equals("close"))break;
						System.out.println(serverResponse);
				    }

				} catch (IOException e) {
				    e.printStackTrace();
				}
			}).start();


			if(userRol.equals("vendedor")){
				new TrabajoVendedor(out,in,outObj,inObj,outFile,inFile).mostrarTrabajo();
			}else{
				new TrabajoSupervisor(out,in,outObj,inObj,outFile,inFile).mostrarTrabajo();
			}
			
			out.close();
			in.close();
		} catch (IOException e) {
			System.out.println("Hasta luego");
		}
	}

	public static void getServer(){
		clearC();
		System.out.println("Ingrese IP del servidor");
		SERVER_ADDRESS = scanner.nextLine();
		try{
			System.out.println("Ingrese Puerto");
			SERVER_PORT = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e){
			System.out.println("Ingrese solo numeros");
			SERVER_PORT = -1;
		}
	}
	
	public static boolean makeConnection(){
		try{
			clearC();
			socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
		    System.out.println("Conectado al servidor");
		    return true;
		}catch(ConnectException e){
		    System.out.println("Error al conectar a la ip o puerto\nRevisa que los datos esten correctos");
			return false;
		}catch(UnknownHostException e1){
			System.out.println("No se encontro la Ip proporcionada");
			return false;
		}catch(IOException e2){
			e2.printStackTrace();
			return false;
		}
	}
	private static void clearC(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}

