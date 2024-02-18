package models;

public class Chofer {
    private  int id;
    private String nombre;
    private String apellido;

    public Chofer(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    @Override
    public String toString(){
        return "Chofer{ " +
                "Id = " + id + " " +
                "Nombre = " + nombre + " " +
                "Apellido = " + apellido + " }";
    }
}
