impor java.HashSet;
impor java.Set;
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
  void asignarAsiento(){
    
  }
  void desocuparAsiento(){
    
  }
  void mostrarAsientosDisponibles(){
    
  }
}
 
