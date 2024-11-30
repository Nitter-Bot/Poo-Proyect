package MultiServer;
import java.io.*;
import java.net.*;
import Control.*;
import Vuelos.*;

public class Server{
	private static final int PUERTO = 1234;
	private static ControlUsuarios ctrl = new ControlUsuarios();
	private static ListaVuelos lst = new ListaVuelos();

	public static void main(String[] args){
		ctrl.addUser("admin","admin","admin");
		ctrl.addUser("Vendedor1","pass","vendedor");

		ServerSocket server = null;
        	try{
			server = new ServerSocket(PUERTO);
			server.setReuseAddress(true);
			System.out.println("Servidor iniciado en el puerto " + PUERTO);

			while(true){
				Socket cliente = server.accept();
				System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

				// Asignar la conexión a un nuevo hilo
				ManejadorCliente socketCliente = new ManejadorCliente(cliente);
				new Thread(socketCliente).start();
			}
        	}catch(IOException e){
        		e.printStackTrace();
        	}finally{
			ctrl.save();
        		if(server!=null){
				try{
					server.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
        	}
	}

	private static class ManejadorCliente implements Runnable{
		private Socket cliente;
		private PrintWriter out;
		private BufferedReader in;
		private String nombreCliente;
		private ObjectOutputStream outObj;
		private ObjectInputStream inObj;
		private String user = null;
		public ManejadorCliente(Socket c){
			this.cliente = c;
			try{
				outObj = new ObjectOutputStream(cliente.getOutputStream()); 
				inObj = new ObjectInputStream(cliente.getInputStream());
				out = new PrintWriter(cliente.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			}catch(IOException e){
				System.out.println("Hubo un error D:");
			}

			this.nombreCliente = c.getInetAddress().getHostAddress();
		}

		@Override
		public void run(){
			try{
				VerificarUsuario();

				new Thread(()->{
					try{
						String mensajeRecibido;
						while((mensajeRecibido = in.readLine())!= null){
							if(mensajeRecibido.equals("exit")){
								break;
							}
							System.out.println(nombreCliente + " : "+ mensajeRecibido);
							switch(mensajeRecibido){
								case "dameVuelos":
									lst.printVuelos(out);
									break;
								case "agregaVuelo":
									try{
										lst.agregarVuelo((Vuelo)inObj.readObject());
									}catch(ClassNotFoundException e){
										out.println("De Servidor: No recibi bien tu vuelo ");
									}
									break;
								case "Vuelo":
									lst.getVuelo(Integer.parseInt(in.readLine()),out);
								case "asignar":
									int index = Integer.parseInt(in.readLine());
									int n = Integer.parseInt(in.readLine());
									for(int i=0;i<n;i++){
										lst.asignar(in.readLine(),index);
									}
								default:
									System.out.println("Nada que hacer");
							}
						}
						System.out.println(nombreCliente + " Desconectado");
						ctrl.desconectarUsuario(user);
						cliente.close();

					}catch(IOException e){
						e.printStackTrace();
					}

				}).start();
				



			}catch(IOException e){
				System.out.println("Hubo algun error");
			}catch(UserNotFound us){
				System.out.println(nombreCliente + " No paso la verificacion");
				out.println("Usuario y/o password incorrecta");
				out.println("Cerrando Conexion...");
				out.println("close");
				out.flush();
			}

		}
		
		private void VerificarUsuario() throws UserNotFound,IOException{
			String pass;
			System.out.println("Verificando al usuario "+ nombreCliente );
			out.println("Ingrese Usuario....");
			user = in.readLine();
			out.println("Ingrese Password....");
			pass = in.readLine();

			if(ctrl.accessGranted(user,pass)){
				System.out.println(nombreCliente+" Verificado!");
				out.println(ctrl.rol(user));
				out.println(" ");
			}else{
				throw new UserNotFound();
			}
		}




	}


}

class UserNotFound extends Exception{
	public UserNotFound(){
		super("D:");
	}
}

