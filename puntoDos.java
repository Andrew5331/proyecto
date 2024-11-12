public class puntoDos {
  public static void main(String[] args){
    private static boolean carteraCargada = false;
    private static int saldoCartera = 0;

    private static void menuMembresia() {
        int opcion;
        do {
            if (!carteraCargada) {
                System.out.println("\nDebe cargar saldo en la cartera antes de acceder a las opciones del menú.");
                cargarCartera();
            } else {
                System.out.println("\nMenú de Membresía");
                System.out.println("2.1 Seleccionar Membresía");
                System.out.println("2.2 Consultar Beneficios");
                System.out.println("2.3 Procesar Pago");
                System.out.println("2.4 Cartera");
                System.out.println("2.5 Volver Atrás");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); 
  
              switch (opcion) {
                  case 21 -> seleccionarMembresia();
                  case 22 -> consultarBeneficios();
                  case 23 -> procesarPago();
                  case 24 -> cargarCartera();
                  case 25 -> System.out.println("Saliendo del menú de membresía...");
                  default -> System.out.println("Opción no válida, por favor intente de nuevo.");
              }
          }
      } while (opcion != 25);
  }

  private static void cargarCartera() {
      System.out.println("\nCargar Cartera");
      System.out.print("Ingrese el monto de dinero que desea cargar (en pesos): ");
      saldoCartera = scanner.nextInt();
      scanner.nextLine(); 
  
      System.out.print("Ingrese el nombre de la tarjeta (Visa, MasterCard, etc.): ");
      String tarjeta = scanner.nextLine();
  
      if (saldoCartera > 0) {
          carteraCargada = true;
          System.out.println("Se ha cargado exitosamente $" + saldoCartera + " en la cartera con la tarjeta " + tarjeta + ".");
      } else {
          System.out.println("El monto ingresado no es válido. Por favor, intente de nuevo.");
      }
  }

  private static void procesarPago() {
      if (!carteraCargada) {
          System.out.println("Debe cargar saldo en la cartera antes de procesar un pago.");
          return;
      }
  
      System.out.print("Ingrese la cédula del cliente para procesar el pago: ");
      String cedula = scanner.nextLine();
      Cliente cliente = clientes.get(cedula);
      if (cliente == null) {
          System.out.println("Cliente no encontrado.");
          return;
      }

      System.out.print("Seleccione la membresía adquirida (1. Gold, 2. Silver, 3. Bronze): ");
      int seleccion = scanner.nextInt();
      scanner.nextLine(); 
      int costo = 0;

      switch (seleccion) {
          case 1 -> {
              costo = 140000;
              if (saldoCartera >= costo) {
                  saldoCartera -= costo;
                  cliente.setMembresia("Gold");
                  System.out.println("Membresía Gold adquirida por $" + costo + ". Saldo restante: $" + saldoCartera);
              } else {
                  System.out.println("Saldo insuficiente. Cargue más saldo en la cartera.");
              }
          }
          case 2 -> {
              costo = 100000;
              if (saldoCartera >= costo) {
                  saldoCartera -= costo;
                  cliente.setMembresia("Silver");
                  System.out.println("Membresía Silver adquirida por $" + costo + ". Saldo restante: $" + saldoCartera);
              } else {
                  System.out.println("Saldo insuficiente. Cargue más saldo en la cartera.");
              }
          }
          case 3 -> {
              costo = 30000;
              if (saldoCartera >= costo) {
                  saldoCartera -= costo;
                  cliente.setMembresia("Bronze");
                  System.out.println("Membresía Bronze adquirida por $" + costo + ". Saldo restante: $" + saldoCartera);
              } else {
                  System.out.println("Saldo insuficiente. Cargue más saldo en la cartera.");
              }
          }
          default -> {
              System.out.println("Selección no válida.");
          }
      }
    }
  }
}
