import java.HashSet;
import java.Set;
class Vuelo {
  Set<int>asientos= new HashSet<>();
  
  int id;
  double costo;
  String origen,destino,fechaSalida;
  final int capacidad;//Por definir la capacidad del avion
    Vuelo (){}
    Vuelo(int id,double costo,String origen,String destino,String fechaSalida){
      this.id=id;
      this.costo=costo;
      this.origen=origen;
      this.destino=destino;
      this.fechaSalida=fechaSalida;
    }
  Vuelo(int id,double costo, String fechaSalida){
      this.id=id;
      this.costo=costo;
      this.fechaSalida=fechaSalida;
  }
  void asignarAsiento(String lugar){
    if(asientos.contains(lugar)){
      asientos.remove(lugar);
    }else {
      System.out.println("El asiento que eligio no esta disponible. ");
    }    
  }
  void desocuparAsiento(String lugar){
    if(asientos.contains(lugar)){
      System.out.println("El asiento aun no ha sido elegido. ");
    }else {
      asientos.add(lugar);
      System.out.println("El asiento ha sido desocupado. ");
    }
  }
  
  void mostrarAsientosDisponibles(){
     if (asientos.isEmpty()){
       System.out.println("Asientos Disponibles"+asientos);
     }else{
       System.out.println("Sin asientos disponibles");
       
     }
  }
}
 
