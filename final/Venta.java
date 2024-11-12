import javax.swing.*;
import java.util.ArrayList;


public class Venta {
    public JFrame frame = new JFrame();
    Cliente cliente;
    Juego juego;
    String cedulaCliente;
    String JuegoVendido;
    int cantidad;
    double total;
    int ID;
    boolean estudiante;
    String membresia;
    boolean mujer;
    int edad;
    int precio;

    ArrayList<String> descuentos = new ArrayList<>();

    Venta(Cliente cliente, Juego juego, int cantidad, int id){
        this.cedulaCliente = cliente.cedula;
        this.JuegoVendido = juego.nombre;
        this.cantidad= cantidad;
        this.ID = id;
        this.estudiante= cliente.estudiante;
        this.membresia= cliente.tipoMembresia;
        this.mujer= cliente.mujer;
        this.edad= cliente.edad;
        this.precio = juego.precio;
    }



    public void generarFactura(){
        descuentos = new ArrayList<>();
        double descuento=0;

        if (estudiante && (edad<18 || edad>25 )&&(!membresia.equalsIgnoreCase("silver")&& !membresia.equalsIgnoreCase("gold"))) {
            descuento=descuento+0.05;
            descuentos.add("APLICA EL DESCUENTO DE SIMPLEMENTE SER ESTUDIANTE =5%");
        }
        if(membresia.equalsIgnoreCase("silver")){
            descuento=descuento+0.05;
            descuentos.add("APLICA DESCUENTO DE SER MEMBRESIA SILVER= 5%");
        } else if (membresia.equalsIgnoreCase("Gold")) {
            descuento=descuento+0.10;
            descuentos.add("APLICA DESCUENTO DE SER MEMBRESIA GOLD= 10%");
        } else if (membresia.equalsIgnoreCase("bronze")) {
            descuento=descuento+0.03;
            descuentos.add("APLICA DESCUENTO DE SER MEMBRESIA BRONZE= 3%");
        }
        if(mujer){
            descuento=descuento+0.1;
            descuentos.add("APLICA DESCUENTO DE SER MUJER = 10%");
        }
        if (edad<18){
            descuento=descuento+0.30;
            descuentos.add("APLICA DESCUENTO POR SER MENOR DE EDAD = 30%");
        } else if (edad<=25) {
            if (estudiante){
                descuento=descuento+0.6;
                descuentos.add("POR ESTAR ENTRE 18 Y 15 AÑOS Y SER ESTUDIANTE= 60%");
            }
            if(membresia.equalsIgnoreCase("Silver")){
                descuento=descuento+0.3;
                descuentos.add("POR ESTAR ENTRE 18 Y 25 AÑOS Y SER MEMBRESIA SILVER= 30%");
            } else if (membresia.equalsIgnoreCase("Gold")) {
                descuento=descuento+0.6;
                descuentos.add("POR ESTAR ENTRE 18 Y 25 AÑOS Y SER MEMBRESIA GOLD= 60%");
            } else if (membresia.equalsIgnoreCase("Bronze")) {
                descuento=descuento+0.8;
                descuentos.add("POR ESTAR ENTRE 18 Y 25 AÑOS Y SER DE MEMBRESIA BRONZE = 80%");
            }
        } else {
            if(estudiante){
                if(membresia.equalsIgnoreCase("Silver")){
                    descuento=descuento+0.3;
                    descuentos.add("POR SER MAYOR DE 25 AÑOS, SER ESTUDIANTE Y TENER MEMBRESIA SILVER = 30%");
                } else if (membresia.equalsIgnoreCase("gold")) {
                    descuento=descuento+0.6;
                    descuentos.add("POR SER MAYOR DE 25 AÑOS, SER ESTUDIANTE Y TENER MEMBRESIA GOLD");
                }
            } else {
                if (membresia.equalsIgnoreCase("Silver")){
                    descuento=descuento+0.30;
                    descuentos.add("POR SER MAYOR DE 25 AÑOS Y TENER MEMBRESIA SILVER");
                } else if (membresia.equalsIgnoreCase("gold")) {
                    descuento=descuento+0.6;
                    descuentos.add("POR SER MAYOR DE 25 AÑOS Y TENER MEMBRESIA GOLD");
                }
            }
        }
        if(descuento>1.0){
            descuento=1.0;
        }
        total=(precio*cantidad)-((precio*cantidad)*descuento);

        JOptionPane.showMessageDialog(frame, ("Cédula cliente: "+cedulaCliente+ "\nJuego vendido: "+ JuegoVendido+"\n" +
                "Cantidad: "+cantidad+ "\nSubtotal: "+ precio +"\nPorcentaje total de descuentos: " + descuento*100 + "\nTotal costo: " + total), "Factura No " + ID, JOptionPane.INFORMATION_MESSAGE);
        showDiscounts();
        frame.dispose();
    }

    private void showDiscounts(){
        String descuentosFormat = "";
        for(int i = 0; i< descuentos.size(); i++){
            descuentosFormat = descuentosFormat.concat(descuentos.get(i) + "\n");
        }
        JOptionPane.showMessageDialog(null, descuentosFormat, "Sus descuentos provienen de: ", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args){
        Cliente costumer = new Cliente("Cata", "1010", true, "silver", true, true, 25);
        Juego cod = new Juego("Call of Duty", 250000, 3, 17);
        Venta venta = new Venta(costumer, cod, 1, 20 );
        venta.generarFactura();
    }
}
