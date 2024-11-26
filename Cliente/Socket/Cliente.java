import java.io.*;
import java.net.*;
import java.util.Scanner;

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
			ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream()); 
			ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.flush();
			//Verificacion, un solo intento
			System.out.println(in.readLine());
			out.println(scanner.nextLine());
			System.out.println(in.readLine());
			out.println(scanner.nextLine());

			//Hilo para leer los msj del servidor ??
			/*new Thread(() -> {
				try {
				    String serverResponse;
				    while ((serverResponse = in.readLine()) != null) {
					System.out.println(serverResponse);
				    }
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}).start();*/

		    // Read messages from the console and send to the server
		    String userInput;
		    while (true) {
			userInput = scanner.nextLine();
			out.println(userInput);
		    }
		   
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public static void getServer(){
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
}

