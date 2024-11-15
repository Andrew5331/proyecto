import javax.swing.*;

public class Juego {
    JFrame frame = new JFrame();


    int precio;
    String nombre;
    int unidades;
    int edadMin;


    public Juego(String nombreI,int precioI, int unidadesI, int minAge){
        this.precio=precioI;
        this.nombre=nombreI;
        this.unidades=unidadesI;
        this.edadMin = minAge;
    }

    public void printGameInfo(){
        JOptionPane.showMessageDialog(frame, ("Nombre: " + nombre + "\nPrecio:" + precio + "\nUnidades disponibles: " + unidades + "\nEdad mínima: " + edadMin ) ,"Detalles del juego", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    public void update(){
        JOptionPane.showMessageDialog(frame, ("Usted quiere actualizar el juego " + this.nombre));
        int choice;
        choice = JOptionPane.showConfirmDialog(null,  "Quiere actualizar la cantidad?", "Cantidad",JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            try {
                this.unidades += Integer.parseInt(JOptionPane.showInputDialog(null, "Cuántas unidades desea agregar al inventario?"));
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor no corresponde a un número entero, por ende no se actualizará");
            }
        }
        choice = JOptionPane.showConfirmDialog(null, "Quiere actualizar la edad minima?", "Edad mínima", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            try {
                this.edadMin = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuál es la nueva edad mínima?"));
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor no corresponde a un número entero, por ende no se actualizará", "Edad mínima", JOptionPane.WARNING_MESSAGE);
            }
        }
        choice = JOptionPane.showConfirmDialog(null, "Quiere actualizar el precio?", "Precio", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            try {
                this.precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuál es el nuevo precio?"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor ingresado no corresponde a un número entero, por ende no se actualizará");
            }
        }

    }
}
