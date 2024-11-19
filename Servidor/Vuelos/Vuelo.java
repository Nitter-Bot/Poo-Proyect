import java.util.HashSet;
import  java.util.Set;

class Vuelo {
  Set<String>asientos= new HashSet<>();//En el set unicamente contiene los asientos disponibles
  int id;
  double costo;
  String origen,destino,fechaSalida;
  final int capacidad=50;//Aun no entiendo su funcion pero ya esta declarada jaja
   
    Vuelo (){}
  //Siempre al crear un objeto Vuelo, se inicializa el set con los asientos
    Vuelo(){
      for (int i=0; i<10;i++){
        asientos.add("A"+String.valueOf(i));
        asientos.add("B"+String.valueOf(i));
        asientos.add("C"+String.valueOf(i));
        asientos.add("D"+String.valueOf(i));
        asientos.add("E"+String.valueOf(i));
      }
    }
  //CONSTRUCTORES
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
//METODOS
  void asignarAsiento(String lugar){
    if(asientos.contains(lugar)){
      asientos.remove(lugar);
      System.out.println("Se asigno el asiento : "+lugar);
    }else {
      System.out.println("El asiento : "+lugar+" no esta disponible. ");
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
  
  void mostrarAsientosDisponibles(){
     if (asientos.isEmpty()){
       System.out.println("Sin asientos disponibles");
     }else{
       System.out.println("Asientos Disponibles"+asientos);
       
     }
    
  }


}
 
/*class Controladora {
  public static void main (String [] a) {

      Vuelo p1 = new Vuelo(1234324,123.23,"CDMX","ACAPULCO","12/04/2024");
      p1.asignarAsiento("A2");
      p1.mostrarAsientosDisponibles();
      p1.desocuparAsiento("A8");
  }
}*/
