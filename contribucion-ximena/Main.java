import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    String NombreBuscado;
    Scanner leer=new Scanner(System.in);
    //CONSULTAR JUEGO
    System.out.println("CONSULTAR JUEGO");
    System.out.println("Escriba el nombre del juego");
    NombreBuscado=leer.next();
    Juego GTA= new Juego(120000,"GTA",10,"Mayor de 18 años");
    Juego FIFA=new Juego(180000,"FIFA",1,"Mayor de 10 años");
    Juego Minecraft=new Juego(50000,"Minecraft",10,"Todas las edades");
    Juego Resident=new Juego(110000,"Resident",0,"Mayor de 10 años");
    if(NombreBuscado.equalsIgnoreCase("GTA")){
      System.out.println("UNIDADES: "+GTA.unidades+", PRECIO:  "+GTA.precio+", CLasificacion:  "+GTA.clasificacion);
    } else if (NombreBuscado.equalsIgnoreCase("FIFA")) {
      System.out.println("UNIDADES: "+FIFA.unidades+", PRECIO:  "+FIFA.precio+", CLasificacion:  "+FIFA.clasificacion);
    } else if (NombreBuscado.equalsIgnoreCase("Minecraft")) {
      System.out.println("UNIDADES: "+Minecraft.unidades+", PRECIO:  "+Minecraft.precio+", CLasificacion:  "+Minecraft.clasificacion);
    }else if (NombreBuscado.equalsIgnoreCase("Resident")) {            System.out.println("UNIDADES: "+Resident.unidades+", PRECIO:  "+Resident.precio+", CLasificacion:  "+Resident.clasificacion);
    }else{
      System.out.println("El juego no se encuentra en la tienda");
    }
    //REALIZAR VENTA
    int ID;
    System.out.println("REALIZAR VENTA");
    System.out.println("Ingrese la cedula del cliente");
    String cedulaCliente= leer.next();
    System.out.println("Ingrese el juego vendido");
    String juegoVendido=leer.next();
    System.out.println("Ingrese la cantidad");
    int cantidad=leer.nextInt();
    System.out.println("Es estudiante si o no?");
    String estudiante= leer.next();
    System.out.println("Qué membresia tiene activa?");
    String membresia= leer.next();
    System.out.println("Qué edad tiene?");
    int edad= leer.nextInt();
    System.out.println("Es mujer?");
    String mujer=leer.next();
    ID=0;
    ID=ID+1;
    Venta primer=new Venta(cedulaCliente,juegoVendido,cantidad,ID,estudiante,membresia,mujer,edad);
    if(NombreBuscado.equalsIgnoreCase("GTA")){
      GTA.unidades= GTA.unidades-cantidad;
    } else if (NombreBuscado.equalsIgnoreCase("FIFA")) {
      FIFA.unidades=FIFA.unidades-cantidad;
    } else if (NombreBuscado.equalsIgnoreCase("Minecraft")) {
      Minecraft.unidades=Minecraft.unidades-cantidad;
    }else if (NombreBuscado.equalsIgnoreCase("Resident")) {
      Resident.unidades= Resident.unidades-cantidad;
    }else{
      System.out.println("El juego no se encuentra en la tienda");
    }
    System.out.println("Su ID es "+ID);
    //GENERAR FACTURA
    int IDi;
    System.out.println("GENERAR FACTURA");
    System.out.println("Ingrese el ID");
    IDi= leer.nextInt();
    if(IDi== primer.ID){
      if(primer.JuegoVendido.equalsIgnoreCase("GTA")) {
        primer.generarFactura(GTA.precio);
      } else if (primer.JuegoVendido.equalsIgnoreCase("FIFA")) {
        primer.generarFactura(FIFA.precio);
      } else if (primer.JuegoVendido.equalsIgnoreCase("Minecraft")) {
        primer.generarFactura(Minecraft.precio);
      } else if (primer.JuegoVendido.equalsIgnoreCase("Resident")) {
        primer.generarFactura(Resident.precio);
      }
    }else{
      System.out.println("El juego no se encuentra en la tienda");
    }
  }
}
