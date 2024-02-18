package models;

public class Unidad {
    private int matricula;
    private String modelo;
    private Chofer choferAsignado;
    public Unidad(int matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }
    @Override
    public String toString(){
        return "Unidad{ " +
                "Matricula = " + matricula + " " +
                "Modelo = " + modelo + " }";
    }
}
