package Actores;
import java.util.ArrayList;
import java.util.List;

public class Vendedor{
  private String nombre;
  private int idTrabajador;
  private String jefeDirecto;
  private List<Vuelo> vuelosDisponibles;

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
  
  public void asignarAsientos(Vuelo vuelo, int numeroAsiento){
    //Pendiente
    //
    //Mandar asientos al servidor, que el diga si se puede asignar
  }

  public void quitarAsientos(Vuelo vuelo, int numeroAsiento){
    //Pendiente
  }  

  public void generarReciboTicket(Vuelo vuelo){
    //Pendiente
    //Tomar de la practica del carrito
  }

}
