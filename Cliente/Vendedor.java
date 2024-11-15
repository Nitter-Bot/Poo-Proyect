package Actores;
import Acceso.*;
import java.util.ArrayList;
import java.util.List;

public class Vendedor{
  private String nombre;
  private int idTrabajador;
  private String jefeDirecto;
  private List<Vuelo> vuelosDisponibles;
  private ControlUsuarios controlUsuarios;

  //Constructor :D
  public Vendedor(String nombre, int idTrabajador, String jefeDirecto, ControlUsuarios controlUsuarios) {
    this.nombre = nombre;
    this.idTrabajador = idTrabajador;
    this.jefeDirecto = jefeDirecto;
    this.vuelosDisponibles = new ArrayList<>();
    this.controlUsuarios = controlUsuarios;
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
    Usuario user = controlUsuarios.accessGranted(usuario, password);
    if(user != null){
      System.out.println("Inicio de secsion exitoso para: " + user.getUser());
      return true;
    }else{
      System.out.println("Error de autenticacion.");
      return false;
    }
  }
  
  public void verVuelosDisponibles(){
    System.out.println("Vuelos disponibles:");
    for(Vuelo vuelo : vuelosDisponibles){
      System.out.println(vuelo);
    }
  }
  
  public void asignarAsientos(Vuelo vuelo, int numeroAsiento){
    //Pendiente
  }

  public void quitarAsientos(Vuelo vuelo, int numeroAsiento){
    //Pendiente
  }  

  public void generarReciboTicket(Vuelo vuelo){
    //Pendiente
  }

}
