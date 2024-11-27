package Actores;
import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Vendedor{
  private List<Vuelo> vuelosControlados;
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

  public void reasignarHorarios(Vuelo vuelo, String nuevoHorario){
    vuelo.setHorario(NuevoHorario);
    System.out.println("Vuelo "+vuelo.getIdVuelo()+" reasignar a las "+nuevoHorario);
  }

  public void cancelarVuelos(Vuelo vuelo) {
    if (vuelosControlados.contains(vuelo)) {
      vuelosControlados.remove(vuelo);
      System.out.println("Vuelo " + vuelo.getIdVuelo() + " cancelado.");
    }else{
      System.out.println("Vuelo no encontrado.");
    }
  }

  public void agregarVuelos(Vuelo vuelo){
    vuelosControlados.add(vuelo);
    System.out.println("Vuelo "+vuelo.getIdVuelo()+" agregado.");
  }

  public void contratarDespedirVendedores(Vendedor vendedor, boolean contratar){
    if(contratar) {
      listaVendedores.add(vendedor);
      System.out.println("Vendedor " + vendedor.getNombre() + " ha sido contratado.");
    }
    else{
      if(listaVendedores.remove(vendedor)){
        System.out.println("Vendedor " + vendedor.getNombre() + " ha sido despedido.");
      }
      else{
        System.out.println("El vendedor " + vendedor.getNombre() + " no se encuentra en la lista.");
      }
    }
  }

  public void verVentasRealizadas(){
    System.out.println("Ventas realizadas por los vendedores supervisados:");
    for (Vendedor vendedor : listaVendedores){
      System.out.println("Vendedor: " + vendedor.getNombre() + "Ventas: " + vendedor.getVentasRealizadas());
    }
  }
}
