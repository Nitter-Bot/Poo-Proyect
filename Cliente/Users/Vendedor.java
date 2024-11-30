package Actores;
import java.io.*;
import java.util.*;


public class Vendedor{
  private String nombre;
  private int idTrabajador;
  private int ventasRealizadas;
  private Set<String> asientos = new HashSet<>();
  Scanner sc = new Scanner(System.in);

  public boolean emptySet(){
    return asientos.isEmpty();
  }

  public int szSet(){
    return asientos.size();
  }

  public void seats(PrintWriter out){
    for(String s:asientos){
      out.println(s);
    }
  }

  public String getNombre(){
    return nombre;
  }
  
  public void setNombre(String nombre){
    nombre = nombre;
  }

  public int getIdTrabajador(){
    return idTrabajador;
  }

  public void setIdTrabajador(int idTrabajador){
    idTrabajador = idTrabajador;
  }

  public void asignar(){
      System.out.println("Cuantos asientos?");
    int i = elegir(-1);
    for(int j=0;j<i;j++){
      System.out.println("Ingrese asiento "+ (j+1));
      String seat = sc.nextLine();
      asientos.add(seat);
    }
    System.out.println("Asientos asignados correctamente, regresando al menu");
  }

  public void quitar(){
    if(asientos.isEmpty()){
      System.out.println("No has seleccionado ningun asiento");
    }
    clear();
    do{
      for(String s:asientos){
        System.out.print(s+" ");
      }
      System.out.println("Ingrese Asiento a quitar;[0] para regresar");
      String x = sc.nextLine();
      if(x.equals("0"))break;
      if(asientos.contains(x)){
        asientos.remove(x);
        System.out.println("Asiento desocupado exitosamente");
      }else{
        System.out.println("Ingresa un asiento valido xd");
      }
    }while(!(asientos.isEmpty()));
  }

  public void generarReciboTicket(String origen,String Destino,String Fecha,String Costo,String ID) {
    System.out.println("Generando recibo...");
    System.out.println("______________________");
    System.out.println("Vuelo ID: " + ID);
    System.out.println("Origen: " + origen);
    System.out.println("Destino: " + Destino);
    System.out.println("Fecha de salida: " + Fecha);
    System.out.println("Costo: $" + Costo);
    System.out.println("______________________");
  }

  public void realizarVenta(int numAsientos,String id) {
    ventasRealizadas++;
    System.out.println("Venta registrada: Vuelo ID " +id+ ", Asientos vendidos: " + numAsientos);
    registrarVentaEnCSV(id, numAsientos);
    }
  
  private void registrarVentaEnCSV(String vueloID, int numAsientos) {
    String archivo = "ventas.csv";
    try (FileWriter writer = new FileWriter(archivo, true)) {
      writer.append(String.valueOf(ventasRealizadas)).append(",").append(vueloID).append(",").append(String.valueOf(numAsientos)).append("\n");
      System.out.println("Venta registrada en el archivo CSV.");
    }catch(IOException e){
      System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
    }
  }
  protected void clear(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	protected int elegir(int op){
		do{
			try{
				op = Integer.parseInt(sc.nextLine());
                                return op;
			}catch(NumberFormatException e){
				System.out.println("Ingresa solo numeros");
			}
		}while(op==-1);
		return op;
	}

}
