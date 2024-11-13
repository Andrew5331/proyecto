import javax.swing.*;

class Cliente {
    String nombre;
    String cedula;
    boolean tieneMembresia;
    String tipoMembresia;
    boolean estudiante;
    boolean mujer;
    int edad;



    public Cliente(String nombre, String cedula, boolean tieneMembresia, String tipoMembresia, boolean estudiante, boolean mujer, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tieneMembresia = tieneMembresia;
        this.tipoMembresia = tipoMembresia;
        this.estudiante = estudiante;
        this.edad = edad;
        this.mujer = mujer;
    }


    public void showClientInfo(){
        JOptionPane.showMessageDialog(null, ("Nombre: " + nombre + "\nCédula: " + cedula + "\nMembresia: "+ tipoMembresia + "\nEdad: " + edad + "\nEs mujer? " + mujer + "\nEs estudiante? " + estudiante));
    }

} 
