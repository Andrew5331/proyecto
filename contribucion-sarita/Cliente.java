class Cliente { 

    String nombre; 

    String cedula; 

    boolean tieneMembresia; 

    String tipoMembresia; 

 

    public Cliente(String nombre, String cedula, boolean tieneMembresia, String tipoMembresia) { 

        this.nombre = nombre; 

        this.cedula = cedula; 

        this.tieneMembresia = tieneMembresia; 

        this.tipoMembresia = tipoMembresia; 

    } 

 

    @Override 

    public String toString() { 

        return "Nombre: " + nombre + "\n" + 

               "Cédula: " + cedula + "\n" + 

               "Tiene membresía: " + (tieneMembresia ? "Sí" : "No") + "\n" + 

               "Tipo de membresía: " + (tieneMembresia ? tipoMembresia : "Ninguna"); 

    } 

} 
