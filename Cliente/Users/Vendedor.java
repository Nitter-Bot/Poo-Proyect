package Actores;
import java.util.ArrayList;
import java.util.List;

public class Vendedor{
  private String nombre;
  private int idTrabajador;
  private int ventasRealizadas;
  private Set<String> asientos = new HashSet<>();

  public boolean emptySet(){
    return asientos.empty();
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
    idTranajador = idTrabajador;
  }

  public String asignar(){
    System.out.println("Cuantos asientos?")
    int i = elegir(-1);
    for(int j=0;j<i;j++){
      asientos.add(user.asignar());
    }
    System.out.println("Asientos asignados correctamente, regresando al menu");
  }

  public void quitar(){
    if(asientos.empty()){
      System.out.println("No has seleccionado ningun asiento");
        break;
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
    }while(!(asientos.empty()))
  }

  public void generarReciboTicket(Vuelo vuelo) {
    System.out.println("Generando recibo...");
    System.out.println("______________________");
    System.out.println("Vuelo ID: " + vuelo.getID());
    System.out.println("Origen: " + vuelo.getOrigen());
    System.out.println("Destino: " + vuelo.getDestino());
    System.out.println("Fecha de salida: " + vuelo.getFecha());
    System.out.println("Costo: $" + vuelo.getCosto());
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
      writer.append(vendedor).append(",").append(String.valueOf(numVenta)).append(",")
      .append(String.valueOf(vueloID)).append(",").append(String.valueOf(numAsientos)).append("\n");
      System.out.println("Venta registrada en el archivo CSV.");
    }catch(IOException e){
      System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
    }
  }
  protected void clear(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
