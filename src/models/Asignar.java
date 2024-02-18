package models;

import java.util.ArrayList;

public class Asignar {
    private ArrayList<Chofer> chofers = new ArrayList<>();
    private ArrayList<Unidad> unidades = new ArrayList<>();
    public ArrayList<Chofer> getChofers(){
        return chofers;
    }
    public boolean addChofer(Chofer chofer){
        boolean status = chofers.add(chofer);
        return status;
    }

    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }


    public boolean addUnidad(Unidad unidad) {
        boolean status = unidades.add(unidad);
        return status;
    }
}
