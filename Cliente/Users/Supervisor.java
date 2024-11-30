package Actores;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Supervisor extends Vendedor{
  private List<Vuelo> vuelosControlados;
  Scanner sc = new Scanner(System.in);
  //Constructor :D
  public Supervisor(String nombre, int idTrabajador, String jefeDirecto, ControlUsuarios controlUsuarios){
    super(nombre, idTrabajador, jefeDirecto, controlUsuarios);
    this.vuelosControlados = new ArrayList<>();
  }

  //Autenticacion para el supervisor
  public boolean iniciarSesion(String usuario, String password){
    Usuario user = controlUsuarios.accessGranted(usuario, password);
    if(user != null){
      System.out.println("Inicio de sesion exitoso para el supervisor: "+user.getUser());
      return true;
    }else{
      System.out.println("Error de autenticacion.")
        return false;
    }
  }

  public void agregarVuelos(Vuelo vuelo){
    System.out.println("Ingre Id");
    System.out.println("Ingrese Origen");
    System.out.println("Ingrese Destino");
    System.out.println("Ingrese Fecah de Salida");
    vuelosControlados.add(vuelo);
    System.out.println("Vuelo "+vuelo.getIdVuelo()+" agregado.");
  }

  public void contratarVendedores(PrintWriter out){
      System.out.println("Ingrese nombre");
      String user = sc.nextLine();
    out.println(user);
      System.out.println("Ingrese pass");
      String pass = sc.nextLine();
    out.println(pass);
}
