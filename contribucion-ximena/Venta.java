public class Venta {
  String cedulaCliente;
  String JuegoVendido;
  int cantidad;
  double total;
  int ID;
  String estudiante;
  String membresia;
  String mujer;
  int edad;
  Venta(String cedula, String juego, int cantidad,int IDingesado,String estudianteI,String membresiaI,String mujerI,int edadI){
    this.cedulaCliente=cedula;
    this.JuegoVendido=juego;
    this.cantidad=cantidad;
    this.ID=IDingesado;
    this.estudiante=estudianteI;
    this.membresia=membresiaI;
    this.mujer=mujerI;
    this.edad=edadI;
  }
  
  void generarFactura(int precio){
    double descuento=0;
    System.out.println("CEDULA CLIENTE: "+cedulaCliente+ ",JUEGO VENDIDO: "+ JuegoVendido+",CANTIDAD: "+cantidad);
    if (estudiante.equalsIgnoreCase("si")&& (edad<18 || edad>25 )&&(!membresia.equalsIgnoreCase("silver")&& !membresia.equalsIgnoreCase("gold"))) {
      descuento=descuento+0.05;
      System.out.println("APLICA EL DESCUENTO DE SIMPLEMENTE SER ESTUDIANTE =5%");
    } 
    if(membresia.equalsIgnoreCase("silver")){
      descuento=descuento+0.05;
      System.out.println("APLICA DESCUENTO DE SER MEMBRESIA SILVER= 5%");
    } else if (membresia.equalsIgnoreCase("Gold")) {
      descuento=descuento+0.10;
      System.out.println("APLICA DESCUENTO DE SER MEMBRESIA GOLD= 10%");
    } else if (membresia.equalsIgnoreCase("bronze")) {
      descuento=descuento+0.03;
      System.out.println("APLICA DESCUENTO DE SER MEMBRESIA BRONZE= 3%");
    }
    if(mujer.equalsIgnoreCase("si")){
      descuento=descuento+0.1;
      System.out.println("APLICA DESCUENTO DE SER MUJER = 10%");
    }
    if (edad<18){
      descuento=descuento+0.30;
      System.out.println("APLICA DESCUENTO POR SER MENOR DE EDAD = 30%");
    } else if (edad>=18 && edad<=25) {
      if (estudiante.equalsIgnoreCase("si")){
        descuento=descuento+0.6;
        System.out.println(" POR ESTAR ENTRE 18 Y 15 AÑOS Y SER ESTUDIANTE= 60%");
      }
      if(membresia.equalsIgnoreCase("Silver")){
        descuento=descuento+0.3;
        System.out.println("POR ESTAR ENTRE 18 Y 25 AÑOS Y SER MEMBRESIA SILVER= 30%");
      } else if (membresia.equalsIgnoreCase("Gold")) {
        descuento=descuento+0.6;
        System.out.println("POR ESTAR ENTRE 18 Y 25 AÑOS Y SER MEMBRESIA GOLD= 60%");
      } else if (membresia.equalsIgnoreCase("Bronze")) {
        descuento=descuento+0.8;
        System.out.println("POR ESTAR ENTRE 18 Y 25 AÑOS Y SER DE MEMBRESIA BRONZE = 80%");
      }
    } else if (edad>25) {
      if(estudiante.equalsIgnoreCase("si")){
        if(membresia.equalsIgnoreCase("Silver")){
          descuento=descuento+0.3;
          System.out.println("POR SER MAYOR DE 25 AÑOS, SER ESTUDIANTE Y TENER MEMBRESIA SILVER = 30%");
        } else if (membresia.equalsIgnoreCase("gold")) {
          descuento=descuento+0.6;
          System.out.println("POR SER MAYOR DE 25 AÑOS, SER ESTUDIANTE Y TENER MEMBRESIA GOLD");
        }
      }else {
        if (membresia.equalsIgnoreCase("Silver")){
          descuento=descuento+0.30;
          System.out.println("POR SER MAYOR DE 25 AÑOS Y TENER MEMBRESIA SILVER");
        } else if (membresia.equalsIgnoreCase("gold")) {
          descuento=descuento+0.6;
          System.out.println("POR SER MAYOR DE 25 AÑOS Y TENER MEMBRESIA GOLD");
        }
      }
    }
    if(descuento>1.0){
      descuento=1.0;
    }
    total=(precio*cantidad)-((precio*cantidad)*descuento);
    System.out.println("TOTAL: "+total);
  }
}
