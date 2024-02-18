package models;

import java.util.ArrayList;

public class Arqueo {
    private ArrayList<Servicio> servicios = new ArrayList<>();


    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public boolean addServicio(Servicio servicio){
        boolean status = servicios.add(servicio);
        return status;
    }
    public ArrayList<Float> copiarIngresos() {
        ArrayList<Float> ingresosCopiados = new ArrayList<>();
        for (Servicio servicio : servicios) {
            ingresosCopiados.add(servicio.getIngreso());
        }
        return ingresosCopiados;
    }

}
