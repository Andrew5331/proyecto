import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {
    //Crear a nivel global el frame, la fecha y los intentos para inciar sesión
    private static final JFrame frame = new JFrame();
    public static Date date = new Date();
    private static int intentos = 3;
    private static int factura_id = 0;


    //Base de datos
    private static final HashMap <String, Cliente> clientes = new HashMap<String, Cliente>();
    private static final HashMap<String, Juego> inventario = new HashMap<String, Juego>();
    private static final HashMap <Integer, Venta> facturas = new HashMap<Integer, Venta>();
    private static final ArrayList<Membresia> membresias = new ArrayList<Membresia>();

    //Crear juegos
    private static void inicializarInventario() {
        inventario.put("gta", new Juego("GTA", 120000, 10, 18));
        inventario.put("fifa", new Juego("FIFA", 180000, 1, 10));
        inventario.put("minecraft", new Juego("Minecraft", 50000, 10, 0));
        inventario.put("resident", new Juego("Resident", 110000, 0, 10));
    }

    //Crear membresias
    private static void setMembresias(){
        membresias.add(new Membresia("gold", 140000, new String[]{"- 10% en compras de videojuegos", "- Acceso a promociones exclusivas", "- Acumulable con descuento de estudiante (-5%)", "- Acumulable con descuento por género", "- Acumulable menor de edad (- 30%)", "- Acumulable estudiante 18-25 años (-60%)", "- Acumulable edad +25 años (- 60%)"}));
        membresias.add(new Membresia("silver", 100000, new String[] {" - 5% en compras de videojuegos", "- Acumulable descuento estudiante (-5 %)", "- Acumulable descuento género (- 10%)", "- Acumulable menor de edad (- 30%)", "- Acumulable estudiante 18-25 años (- 30%)", "- Acumulable mayor +25 años (30%)"}));
        membresias.add(new Membresia("bronze", 30000, new String[]{"- 3% en compras de videojuegos", "- Acumulable con descuento por estudiante (- 5%)", "- Acumulable con descuento por género (-10%)", "- Acumulable menor de edad (-30%)","- Acumulable por edad (18-25) y estudiante (- 80%)"}));

    }

    //Función main
    public static void main(String[] args) {

        setMembresias();
        inicializarInventario();
        //Crear int choice para almacenar la opción del menú elegida por el usuario
        int choice;
        Membresia membership = null;
        //boolean para mantenerse dentro del menú 1 o 2
        boolean menuActive;
        //boolean para entrar y permanecer en el menú principal
        boolean active = true;
        // Arreglos de tipo Object que contienen las opciones de cada menú.
        Object [] mainMenu = {"1] Entrar como vendedor." , "2] Comprar membresía.", "3] Consultar fecha.", "4] Salir."};
        Object [] menuVendedor = {"1] Consultar juego.", "2] Realizar venta", "3] Generar factura", "4] Cargar/Actualizar juego", "5] Cargar cliente", "6] Consultar cliente", "7] Volver atrás"};
        Object [] menuMembresia = {"1] Seleccionar membresía", "2] Consultar membresía", "3] Procesar pago", "4] Volver atrás"};

        //Menú principal
        while(active){
            date = new Date();
            //Choice almacena el índice el al opción seleccionada del objeto mainMenu
            choice = JOptionPane.showOptionDialog(frame, "¡Bienvenido a la tienda de videojuegos de Ken!\n¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, mainMenu, mainMenu);
            switch (choice){
                //Caso 0: Entrar como vendedor
                case 0:
                    //Verifica si tiene acceso
                    if(intentos == 0 ){
                        JOptionPane.showMessageDialog(null, "Acceso denegado. Demasiados intentos fallidos", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else{
                        //Solicita usuario y contraseña para acceder al menú del vendedor
                        if(logIn()){
                            // Si el usuario logra acceder
                            menuActive = true;
                            while (menuActive){
                                choice = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuVendedor, menuVendedor);
                                switch (choice){
                                    //Llamar función correspondiente en cada caso
                                    case 0 -> consultarJuego();
                                    case 1 -> realizarVenta();
                                    case 2 -> getFactura();
                                    case 3 -> {
                                        String juego = JOptionPane.showInputDialog(null, "Ingrese el nombre del juego").toLowerCase();
                                        if(inventario.containsKey(juego)){
                                            Juego game = inventario.get(juego);
                                            game.update();
                                        } else{
                                            crearJuego(juego);
                                        }
                                    }
                                    case 4 -> crearCliente();
                                    case 5 -> consultaCliente();
                                    default-> menuActive = false;
                                }
                            }

                        } else{
                            //Si el usuario ingresa datos erróneos, le informa cuántos intentos le quedan
                            intentos -= 1;
                            JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos. Le quedan " + intentos + " intentos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    break;
                case 1:
                    //Caso 1: Menú membresías. No requiere inicio de sesión
                    menuActive = true;
                    while (menuActive){

                        choice = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuMembresia, menuMembresia);
                        switch (choice){
                            //Llama a las funciones correspondientes :)
                            case 0 -> {
                                int num = seleccionarMembresia();
                               membership = membresias.get(num);
                            }
                            case 1 -> consultarMembresias();
                            case 2 -> {
                                String id = JOptionPane.showInputDialog(null, "Ingrese su ID", "Seleccionar cliente", JOptionPane.QUESTION_MESSAGE);
                                if(!clientes.containsKey(id)){
                                    JOptionPane.showMessageDialog(null, "Usted no está registrado, ingrese como vendedor y regístre su id");
                                } else{
                                    try {
                                        comprarMembresia(membership, clientes.get(id));
                                    } catch (NullPointerException E){
                                        JOptionPane.showMessageDialog(null, "Ud no ha seleccionado ninguna membresía");

                                    }
                                }
                            }
                            case 3 -> menuActive = false;
                        }
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, date, "La fecha de hoy", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    active = false;
                    frame.dispose();
                    break;
            }
        }
    }

    public static boolean logIn(){
        JOptionPane.showInputDialog(null, "Ingrese el usuario");
        return (JOptionPane.showInputDialog(null, "Ingrese la contraseña").equals("BARBIE"));
    }

    public static void consultarJuego(){
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del juego que desea consultar", "Consultar juego", JOptionPane.QUESTION_MESSAGE).toLowerCase();
        if(inventario.containsKey(nombre.toLowerCase())){
            //crea un objeto juego
            Juego juego = inventario.get(nombre);
            //imprime la información del juego
            juego.printGameInfo();
        } else {
            JOptionPane.showMessageDialog(null, "El juego que consultó no está registrado en el inventario");
        }
    }

    public static void crearCliente(){
        JOptionPane.showMessageDialog(null, "Para realizar ventas se debe registrar el cliente. Ingrese los datos que se le solicitan a continuación", "Registrar cliente", JOptionPane.INFORMATION_MESSAGE);
        String cedula, nombre, membresia;
        boolean mujer, estudiante;
        int edad;
        cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula: ", "Registro del cliente", JOptionPane.QUESTION_MESSAGE);
        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ", "Registro del cliente", JOptionPane.QUESTION_MESSAGE);
        //Por defecto, el cliente no tiene ninguna membresía
        //Cuando el cliente adquiere la membresía se actualiza este valor
        membresia = "Ninguna";
        estudiante = (JOptionPane.showConfirmDialog(null, "Es estudiante?", "" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0);
        mujer = (JOptionPane.showConfirmDialog(null, "Es usted mujer?", "" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0);
        edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su edad: "));

        Cliente costumer = new Cliente(nombre, cedula, false, membresia, estudiante, mujer, edad);
        clientes.put(cedula, costumer);
    }

    public static void consultaCliente(){
        String id = JOptionPane.showInputDialog(null, "Ingrese el id del cliente a consultar ", "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
        if(clientes.containsKey(id)){
            Cliente cliente = clientes.get(id);
            cliente.showClientInfo();
        } else{
            JOptionPane.showMessageDialog(null, "No existe un cliente con ese id.");
        }
    }

    public static void realizarVenta(){
        String id, juego;
        int cantidad;
        id = JOptionPane.showInputDialog(null, "Ingrese el id del cliente: ", "Ventas", JOptionPane.QUESTION_MESSAGE);
        if(clientes.containsKey(id)){
            Cliente cliente = clientes.get(id);
            int edad = cliente.edad;
            juego = JOptionPane.showInputDialog(null, "Ingrese el nombre del juego:", "Ventas", JOptionPane.QUESTION_MESSAGE).toLowerCase();
            if(inventario.containsKey(juego)) {
                Juego game = inventario.get(juego);
                int minEdad = game.edadMin;
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de unidades que desea:", "Ventas", JOptionPane.QUESTION_MESSAGE));
                if(game.unidades >= cantidad && edad >= minEdad) {
                    game.unidades -= cantidad;
                    facturas.put(factura_id, new Venta(cliente, game, cantidad, factura_id));
                    JOptionPane.showMessageDialog(null, "Compra exitosa. El ID de su factura es " + factura_id);
                    factura_id++;
                } else if(game.unidades >= cantidad){
                    JOptionPane.showMessageDialog(null, "El cliente no cuenta con la edad mínima para adquirir " + game.nombre);
                } else{
                    JOptionPane.showMessageDialog(null, "No hay unidades suficientes");
                }
            } else{
                JOptionPane.showMessageDialog(null, "El juego no se encuentra disponible en el momento");
            }
        } else{
            crearCliente();
            realizarVenta();
        }
    }
    public static void getFactura(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id de la factura"));
        if(facturas.containsKey(id)) {
            Venta venta = facturas.get(id);
            venta.generarFactura();
        } else{
            JOptionPane.showMessageDialog(null, "No existe una factura con  dicho id");
        }

    }

    public static void crearJuego(String nombre){
        int precio, edadMin, unidades;
        JOptionPane.showMessageDialog(null, "Ud va a añadir un nuevo juego al inventario");
        precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio del juego"));
        edadMin = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad mínima"));
        unidades = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad ded unidades disponibles"));
        Juego newGame = new Juego(nombre,precio,unidades,edadMin);
        inventario.put(newGame.nombre,newGame);
    }

    public static void consultarMembresias(){
        Object [] memberships = {"Gold", "Silver","Bronze"};
        int choice = JOptionPane.showOptionDialog(null, "¿Qué membresía desea consultar?", "Elija una membresía", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, memberships, memberships);
        Membresia membership = membresias.get(choice);
        membership.consultarBeneficios();
    }

    public static int seleccionarMembresia(){
        Object [] memberships = {"Gold", "Silver","Bronze"};
        return JOptionPane.showOptionDialog(null, "¿Qué membresía desea seleccionar?", "Elija una membresía", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, memberships, memberships);
    }

    public static void comprarMembresia (Membresia membresia, Cliente cliente){
        cliente.tipoMembresia = membresia.tipo;
        JOptionPane.showMessageDialog(null, "Procesando pago. Presione \"Ok\" para ver su comprobante", "Membresía adquirida", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "ID Cliente: " + cliente.cedula + "\nMembresía adquirida: " + membresia.tipo + "\nCosto: " + membresia.precio , "Comprobante", JOptionPane.INFORMATION_MESSAGE);
    }
}
