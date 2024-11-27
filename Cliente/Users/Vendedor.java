package Actores;
import java.util.ArrayList;
import java.util.List;

public class Vendedor{
  private String nombre;
  private int idTrabajador;
  private String jefeDirecto;
  private List<Vuelo> vuelosDisponibles;
  private int ventasRealizadas;

  public Vendedor(String nombre, int idTrabajador, String jefeDirecto) {
    this.nombre = nombre;
    this.idTrabajador = idTrabajador;
    this.jefeDirecto = jefeDirecto;
  }
  
  public String getNombre(){
    return nombre;
  }
  
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public int getIdTrabajador(){
    return idTrabajador;
  }

  public void setIdTrabajador(int idTrabajador){
    this.idTranajador = idTrabajador;
  }

  //Autenticacion para el vendedor. (Sujeto a cambios)
  public boolean iniciarSesion(String usuario, String password){
      return 0;
    //Meter sockets para a autenticacion
  }

  public void verVuelosDisponibles(){
    //Vuelos Dsiponibles = solictar al servidor
    System.out.println("Vuelos disponibles:");
    for(Vuelo vuelo : vuelosDisponibles){
      System.out.println(vuelo);
    }
  }
  
  public void asignarAsientos(Vuelo vuelo, String numeroAsiento){
    vuelo.asignarAsiento(numeroAsiento);
  }

  public void quitarAsientos(Vuelo vuelo, String numeroAsiento){
    vuelo.desocuparAsiento(numeroAsiento);
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

  public void realizarVenta(Vuelo vuelo, int numAsientos) {
    ventasRealizadas++;
    System.out.println("Venta registrada: Vendedor " + nombre + ", Vuelo ID " + vuelo.getID() + ", Asientos vendidos: " + numAsientos);
    registrarVentaEnCSV(nombre, ventasRealizadas, vuelo.getID(), numAsientos);
    }
  
  private void registrarVentaEnCSV(String vendedor, int numVenta, int vueloID, int numAsientos) {
    String archivo = "ventas.csv";
    try (FileWriter writer = new FileWriter(archivo, true)) {
      writer.append(vendedor).append(",").append(String.valueOf(numVenta)).append(",")
      .append(String.valueOf(vueloID)).append(",").append(String.valueOf(numAsientos)).append("\n");
      System.out.println("Venta registrada en el archivo CSV.");
    }catch(IOException e){
      System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
    }
  }
}
