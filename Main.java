import javax.swing.*;
import java.util.Date;

public class Main {
    public static JFrame frame = new JFrame();
    public static Date date = new Date();
    public static int intentos = 3;

    public static void main(String[] args) {
        int choice;
        String password, user;
        String key = "BARBIE";
        boolean menuActive;
        boolean active = true;
        Object [] mainMenu = {"1] Entrar como vendedor." , "2] Comprar membresía.", "3] Consultar fecha.", "4] Salir."};
        Object [] menuVendedor = {"1] Consultar juego.", "2] Realizar venta", "3] Generar factura", "4] Cargar/Actualizar juego", "5] Cargar cliente", "6] Consultar cliente", "7] Volver atrás"};
        Object [] menuMembresia = {"1] Seleccionar membresía", "2] Consultar membresía", "3] Procesar pago"};
        Object [] membresias = {"1] Gold.", "2] Silver.","3] Bronze"};

        while(active){
            choice = JOptionPane.showOptionDialog(frame, "¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, mainMenu, mainMenu);
            switch (choice){
                case 0:
                    if(intentos == 0 ){
                        JOptionPane.showMessageDialog(null, "Acceso denegado", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else{


                    user = JOptionPane.showInputDialog(null, "Ingrese el usuario", "Input", JOptionPane.INFORMATION_MESSAGE );
                    password = JOptionPane.showInputDialog(null, "Ingrese la contraseña", "Input", JOptionPane.INFORMATION_MESSAGE );
                    if(user.equals(key) && password.equals(key) && (intentos > 0)){
                        menuActive = true;
                        while (menuActive){
                            choice = JOptionPane.showOptionDialog(frame, "¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuVendedor, menuVendedor);
                            switch (choice){
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
                        intentos -= 1;
                        JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos. Le quedan " + intentos + " intentos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                    }


                    break;
                case 1:
                    menuActive = true;
                    while (menuActive){
                        choice = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuMembresia, menuMembresia);
                        switch (choice){
                            //Estoy cansado jefe un pull request y lo termino el domingo
                            
                        }
                    }

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, date, "La fecha de hoy", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    active = false;
                    break;
            }
        }
    }
}
