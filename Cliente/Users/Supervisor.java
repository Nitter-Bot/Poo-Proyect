package Actores;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import Vuelos.Vuelo;

public class Supervisor extends Vendedor{
  private List<Vuelo> vuelosControlados;
  Scanner sc = new Scanner(System.in);

  public void agregarVuelos(){
    System.out.println("Ingre Id");
    String id = sc.nextLine();
    System.out.println("Ingrese Origen");
    String origen = sc.nextLine();
    System.out.println("Ingrese Destino");
    String destino = sc.nextLine();
    System.out.println("Ingrese Fecha de Salida");
    String fecha = sc.nextLine();
    System.out.println("Ingrese costo del boleto");
    double costo = Double.parseDouble(sc.nextLine());
    Vuelo v = new Vuelo(id,costo,origen,destino,fecha);

  }

  public void contratarVendedores(PrintWriter out){
      System.out.println("Ingrese nombre");
      String user = sc.nextLine();
      out.println(user);
      System.out.println("Ingrese pass");
      String pass = sc.nextLine();
      out.println(pass);
  }
}

