import javax.swing.*;

public class Membresia {
    String tipo;
    int precio;
    String [] beneficios ;

    public Membresia(String type, int precio, String[] beneficios ){
        this.tipo = type;
        this.precio = precio;
        this.beneficios = beneficios;
    }

    void consultarBeneficios(){
        StringBuilder benefits = new StringBuilder();
        for (int i = 0; i < beneficios.length; i++){
            benefits.append(beneficios[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, ("Tipo de membresía: " + tipo + "\nPrecio: " + precio + "\nBeneficios: " + benefits), "Información membresía " + tipo, JOptionPane.INFORMATION_MESSAGE);
    }

    //Sample code
    public static void main(String [] args){
        Membresia membershipA = new Membresia("A", 5, new String[]{"ben a", "ben b"});
        membershipA.consultarBeneficios();
    }

}
