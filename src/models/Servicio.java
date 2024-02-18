package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Servicio {
    private int servicio;
    private String chofer;
    private int matricula;
    private float ingreso;
    private LocalDate fecha;
    private LocalTime hora;
    public Servicio(int servicio, String chofer, int matricula, float ingreso, LocalDate fecha, LocalTime hora) {
        this.servicio = servicio;
        this.chofer = chofer;
        this.matricula = matricula;
        this.ingreso = ingreso;
        this.fecha = fecha;
        this.hora = hora;
    }
    public int getServicio() {
        return servicio;
    }
    public String getChofer() {
        return chofer;
    }
    public int getMatricula() {
        return matricula;
    }
    public float getIngreso() {
        return ingreso;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    @Override
    public String toString(){
        return "Numero de servicio = " + servicio + " " +
                "Chofer = " + chofer + " " +
                "Mtricula = " + matricula + " " +
                "Ingreso = " + ingreso + " " +
                "Fecha = " + fecha + " " +
                "Hora = " + hora;
    }


}
