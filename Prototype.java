import javax.swing.*;
import java.util.Date;

public class Prototype {
    //Crear a nivel global el frame, la fecha y los intentos para inciar sesión
    public static JFrame frame = new JFrame();
    public static Date date = new Date();
    public static int intentos = 3;

    //Función main
    public static void main(String[] args) {
        //Crear int choice para almacenar la opción del menú elegida por el usuario
        int choice;
        //Crear strings para almacenar los datos proporcionados por el usuario al iniciar como vendedor
        String password, user;
        //Clave de acceso
        String key = "BARBIE";
        //boolean para mantenerse dentro del menú 1 o 2
        boolean menuActive;
        //boolean para entrar y permanecer en el menú principal
        boolean active = true;
        // Arreglos de tipo Object que contienen las opciones de cada menú.
        Object [] mainMenu = {"1] Entrar como vendedor." , "2] Comprar membresía.", "3] Consultar fecha.", "4] Salir."};
        Object [] menuVendedor = {"1] Consultar juego.", "2] Realizar venta", "3] Generar factura", "4] Cargar/Actualizar juego", "5] Cargar cliente", "6] Consultar cliente", "7] Volver atrás"};
        Object [] menuMembresia = {"1] Seleccionar membresía", "2] Consultar membresía", "3] Procesar pago", "4] Volver atrás"};
        Object [] membresias = {"1] Gold.", "2] Silver.","3] Bronze"};
        //Menú principal
        while(active){
            //Choice almacena el índice el al opción seleccionada del objeto mainMenu
            choice = JOptionPane.showOptionDialog(frame, "¡Bienvenido a la tienda de videojuegos de Ken!\n¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, mainMenu, mainMenu);
            switch (choice){
                //Caso 0: Entrar como vendedor
                case 0:
                    //Verifica si tiene acceso
                    if(intentos == 0 ){
                        JOptionPane.showMessageDialog(null, "Acceso denegado", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else{
                        //Solicita usuario y contraseña para acceder al menú del vendedor
                        user = JOptionPane.showInputDialog(null, "Ingrese el usuario", "Input", JOptionPane.INFORMATION_MESSAGE );
                        password = JOptionPane.showInputDialog(null, "Ingrese la contraseña", "Input", JOptionPane.INFORMATION_MESSAGE );
                        if(user.equals(key) && password.equals(key) && (intentos > 0)){
                            // Si el usuario logra acceder
                            menuActive = true;
                            while (menuActive){
                                choice = JOptionPane.showOptionDialog(frame, "¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuVendedor, menuVendedor);
                                switch (choice){
                                    //Llamar función correspondiente en cada caso
                                    case 0:
                                        JOptionPane.showMessageDialog(null, "Ud quiere consultar un juego", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                   case 1:
                                        JOptionPane.showMessageDialog(null, "Ud quiere realizar una venta", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                case 2:
                                    JOptionPane.showMessageDialog(null, "Ud quiere generar una factura", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, "Ud quiere actualizar un juego", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                case 4:
                                    JOptionPane.showMessageDialog(null, "Ud quiere cargar un cliente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                case 5:
                                    JOptionPane.showMessageDialog(null, "Ud quiere consultar un cliente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                default:
                                    menuActive = false;
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
                            case 0:
                                JOptionPane.showMessageDialog(null, "Ud quiere seleccionar su membresía");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(null, "Ud quiere consultar las membresías");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Ud quiere procesar el pago de su membresía");
                                break;
                            case 3:
                                menuActive = false;
                                break;

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
}
