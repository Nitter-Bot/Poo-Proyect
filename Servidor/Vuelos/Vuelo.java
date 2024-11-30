package Vuelos;
import java.util.*;
import java.io.*;

public class Vuelo implements Serializable{
  private static final long serialVersionUID = 1L;
  private Set<String>asientos= new HashSet<>();//En el set unicamente contiene los asientos disponibles
  private String id;
  private double costo;
  private String origen,destino,fechaSalida;
  
  public String getOrigen(){
    return origen;
  }

  public String getDestino(){
    return destino;
  }
  public String getFecha(){
    return fechaSalida;
  }
  public double getCosto(){
    return costo;
  }
  public String getID(){
    return id;
  }

  int capacidad=50;//Aun no entiendo su funcion pero ya esta declarada jaja
    Vuelo (){}
  //CONSTRUCTORES
    public Vuelo(String id,double costo,String origen,String destino,String fechaSalida){
      this.id=id;
      this.costo=costo;
      this.origen=origen;
      this.destino=destino;
      this.fechaSalida=fechaSalida;
        for (int i=1; i<=10;i++){
          asientos.add("A"+String.valueOf(i));
          asientos.add("B"+String.valueOf(i));
          asientos.add("C"+String.valueOf(i));
          asientos.add("D"+String.valueOf(i));
          asientos.add("E"+String.valueOf(i));
        }
    }

  public Vuelo(String id,double costo, String fechaSalida){
      this.id=id;
      this.costo=costo;
      this.fechaSalida=fechaSalida;
      for (int i=1; i<=10;i++){
          asientos.add("A"+String.valueOf(i));
          asientos.add("B"+String.valueOf(i));
          asientos.add("C"+String.valueOf(i));
          asientos.add("D"+String.valueOf(i));
          asientos.add("E"+String.valueOf(i));
      }
  }
//METODOS
  void asignarAsiento(String lugar){
    if(asientos.contains(lugar)){
      asientos.remove(lugar);
      System.out.println("Se asigno el asiento : "+lugar);
    }else {
      System.out.println("El asiento : "+lugar+" no esta disponible. ");
      System.out.println("Mensaje al cliente de que el lugar tuvo error");
    }    
  }
  
  void desocuparAsiento(String lugar){
    if(asientos.contains(lugar)){
      System.out.println("El asiento : "+lugar+" aun no ha sido elegido. ");
    }else {
      asientos.add(lugar);
      System.out.println("El asiento: "+lugar+" ha sido desocupado. ");
    }
  }
  
  public synchronized void mostrarAsientosDisponibles(PrintWriter out){
    out.print("\033[H\033[2J");  
    out.flush();
    out.printf("Vuelo %d\nOrigen: %s \tDestino %s \tFecha Programada del vuelo %s",id,origen,destino,fechaSalida);
    out.println("Costo del boleto : " + costo);
     if (asientos.isEmpty()){
       out.println("El avion ya esta lleno\n");
     }else{
        out.println("\n\n-------------Asientos ------------");
        out.println("|           Zona Turista          ");
        for(int c = 0; c<2;c++)
        for(int i=1;i<=10;i++){
          if(asientos.contains(S(c,i)))out.printf("| %c%d |",(char)('A'+c),i);
          else out.print("|  X  |");
        }
        out.println("|           Zona Economica        ");
        for(int c = 2; c<4;c++)
        for(int i=1;i<=10;i++){
          if(asientos.contains(S(c,i)))out.printf("| %c%d |",(char)('A'+c),i);
          else out.print("|  X  |");
        }
        out.println("|            Zona VIP             ");
        for(int i=1;i<=10;i++){
          if(asientos.contains(S(5,i)))out.printf("| %c%d |","E",i);
          else out.print("|  X  |");
        }
     }
    
  }

  private String S(int c,int i){
    return (char) ('A' + c) + "" + i;
  }


}
 
/*DESCOMENTA ESTOS SI QUIERES PROBAR QUE FUNCIONE
class Controladora {
  public static void main (String [] a) {

      Vuelo p1 = new Vuelo(1234324,123.23,"CDMX","ACAPULCO","12/04/2024");
      p1.asignarAsiento("A2");
      p1.mostrarAsientosDisponibles();
      p1.desocuparAsiento("A8");
  }
}*/
