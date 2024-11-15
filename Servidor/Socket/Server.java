package MultiServer;
import java.io.*;
import java.net.*;

public class Server{
	private static final int PUERTO = 1234;

	public static void main(String[] args){
		ServerSocket server = null;
        	try{
			server = new ServerSocket(PUERTO);
			server.setReuseAddress(true);
			System.out.println("Servidor iniciado en el puerto " + PUERTO);

			while(true){
				Socket cliente = server.accept();
				System.out.println("Cliente conectado: " + cliente.getInetAddress()/*.getHostAdress()*/);

				// Asignar la conexión a un nuevo hilo
				ManejadorCliente socketCliente = new ManejadorCliente(cliente);
				new Thread(socketCliente).start();
			}
        	}catch(IOException e){
        		e.printStackTrace();
        	}finally{
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
        	private final Socket clientSocket;

		public ManejadorCliente(Socket socket){
            		this.clientSocket = socket;
        	}

        	public void run(){
        		PrintWriter out = null;
        		BufferedReader in = null;
			try{
                                out = new PrintWriter(clientSocket.getOutputStream(), true);
        			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                		String line;
                		while ((line = in.readLine()) != null){
					System.out.printf(" Sent from the client: %s\n",line);
					out.println(line);
                		}

                        }catch(IOException e){
                		e.printStackTrace();
        		}
        		finally{
				try{
				    if (out != null){
					out.close();
				    }
				    if(in != null){
					in.close();
					clientSocket.close();
				    }
				}
				catch (IOException e) {
				    e.printStackTrace();
				}
            } 
        } 
    } 

}

