import java.util.ArrayList; 

import java.util.Scanner; 
public class Sample { 

    static ArrayList<Cliente> clientes = new ArrayList<>(); 

    static Scanner scanner = new Scanner(System.in); 

    static final String PASSWORD = "BARBIE"; // Nueva contraseña 

    static final int MAX_INTENTOS = 3; // Máximo de intentos 

 

    public static void main(String[] args) { 

        boolean salir = false; 

         

        while (!salir) { 

            System.out.println("\nSistema de Gestión de Clientes:"); 

            System.out.println("1.5 Cargar Cliente"); 

            System.out.println("1.6 Consultar Cliente"); 

            System.out.println("1.7 Volver Atrás"); 

            System.out.print("Elige una opción: "); 

            String opcion = scanner.next(); 

 

            switch (opcion) { 

                case "1.5": 

                    cargarCliente(); 

                    break; 

                case "1.6": 

                    consultarCliente(); 

                    break; 

                case "1.7": 

                    salir = volverAtras(); 

                    break; 

                default: 

                    System.out.println("Opción no válida. Intenta de nuevo."); 

            } 

        } 

    } 

 

    // Método para cargar un cliente 

    public static void cargarCliente() { 

        scanner.nextLine(); // Limpiar el buffer 

        System.out.print("Ingresa el nombre del cliente: "); 

        String nombre = scanner.nextLine(); 

         

        System.out.print("Ingresa la cédula del cliente: "); 

        String cedula = scanner.nextLine(); 

 

        System.out.print("¿Desea adquirir una membresía? (s/n): "); 

        boolean deseaMembresia = scanner.nextLine().equalsIgnoreCase("s"); 

 

        String tipoMembresia = "Ninguna"; 

        if (deseaMembresia) { 

            System.out.println("Beneficios de membresía:"); 

            System.out.println("1. Gold - Beneficios máximos."); 

            System.out.println("2. Silver - Beneficios intermedios."); 

            System.out.println("3. Bronze - Beneficios mínimos."); 

            System.out.print("Elige el tipo de membresía (Gold/Silver/Bronze): "); 

            tipoMembresia = scanner.nextLine(); 

        } 

 

        Cliente nuevoCliente = new Cliente(nombre, cedula, deseaMembresia, tipoMembresia); 

        clientes.add(nuevoCliente); 

        System.out.println("Cliente registrado exitosamente."); 

    } 

 

    // Método para consultar un cliente 

    public static void consultarCliente() { 

        System.out.print("¿Desea buscar por (1) Nombre o (2) Cédula? "); 

        int criterio = scanner.nextInt(); 

        scanner.nextLine(); // Limpiar el buffer 

 

        if (criterio == 1) { 

            System.out.print("Ingrese el nombre del cliente: "); 

            String nombre = scanner.nextLine(); 

            boolean encontrado = false; 

            for (Cliente cliente : clientes) { 

                if (cliente.nombre.contains(nombre)) { 

                    System.out.println("\nCliente encontrado:"); 

                    System.out.println(cliente); 

                    encontrado = true; 

                } 

            } 

            if (!encontrado) { 

                System.out.println("No se encontraron clientes con ese nombre."); 

            } 

        } else if (criterio == 2) { 

            System.out.print("Ingrese la cédula del cliente: "); 

            String cedula = scanner.nextLine(); 

            Cliente clienteExacto = null; 

            for (Cliente cliente : clientes) { 

                if (cliente.cedula.equals(cedula)) { 

                    clienteExacto = cliente; 

                    break; 

                } 

            } 

            if (clienteExacto != null) { 

                System.out.println("\nCliente encontrado:"); 

                System.out.println(clienteExacto); 

            } else { 

                System.out.println("No se encontró un cliente con esa cédula."); 

            } 

        } else { 

            System.out.println("Opción no válida."); 

        } 

    } 

 

    // Método para volver atrás 

    public static boolean volverAtras() { 

        System.out.print("¿Desea salir del sistema? (s/n): "); 

        if (scanner.next().equalsIgnoreCase("s")) { 

            int intentos = 0; 

            while (intentos < MAX_INTENTOS) { 

                System.out.print("Ingrese la contraseña para reingresar al sistema: "); 

                String contrasena = scanner.next(); 

                if (contrasena.equals(PASSWORD)) { 

                    System.out.println("Contraseña correcta. Reingresando..."); 

                    return false; // Regresa al menú principal 

                } else { 

                    intentos++; 

                    System.out.println("Contraseña incorrecta. Intento " + intentos + " de " + MAX_INTENTOS + "."); 

                } 

            } 

            System.out.println("Máximo de intentos alcanzado. Sistema bloqueado."); 

            return true; // Bloquear el sistema 

        } 

        return false; 

    } 

} 
