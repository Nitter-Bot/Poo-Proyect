package MultiServer;
import java.io.*;
import java.net.*;
import Control.*;

public class Server{
	private static final int PUERTO = 1234;
	private static ControlUsuarios ctrl = new ControlUsuarios();

	public static void main(String[] args){
		ctrl.addUser("admin","admin");
		ctrl.addUser("Vendedor1","pass");

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
		
		public ManejadorCliente(Socket c){
			this.cliente = c;
			try{
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
							if(mensajeRecibido.equals("exit"))break;
							System.out.println(nombreCliente + " : "+ mensajeRecibido);
						}
						out.println("close");
						cliente.close();

					}catch(IOException e){
						e.printStackTrace();
					}

				}).start();
				



			}catch(IOException e){
				System.out.println("Hubo algun error");
			}catch(UserNotFound us){
				out.println("Usuario y/o password incorrecta");
				out.println("Cerrando Conexion...");
				out.println("close");
				out.flush();
			}

		}
		
		private void VerificarUsuario() throws UserNotFound,IOException{
			String user, pass;
			out.println("Ingrese Usuario....");
			user = in.readLine();
			out.println("Ingrese Password....");
			pass = in.readLine();

			if(ctrl.accessGranted(user,pass)){
				out.println("ok");
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

