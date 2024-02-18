import models.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner key =  new Scanner(System.in);
    private static Arqueo serv = new Arqueo();
    private static Asignar asignaciones = new Asignar();


    public static void main(String[] args) {

        int opcion;
        do {
            System.out.println("1. Administrador");
            System.out.println("2. Chofer");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = key.nextInt();
            switch (opcion) {
                case 1:
                   do {
                       System.out.println("1. Asignar chofer: ");
                       System.out.println("2. Añadir unidad: ");
                       System.out.println("3. Añadir chofer");
                       System.out.println("4. Salir");
                       System.out.print("Opcion. ");
                       opcion = key.nextInt();
                       switch (opcion) {
                           case 1:
                               asignarUnidad();
                               break;
                           case 2:
                               addUnidad();
                               break;
                           case 3:
                               addChofer();
                               break;
                       }
                   } while (opcion != 4);
                    break;
                case 2:
                    do {
                        System.out.println("1. Registrar servicio: ");
                        System.out.println("2. Arqueo de servicios: ");
                        System.out.println("3. Arqueo de ingresos: ");
                        System.out.println("4. Salir");
                        System.out.print("Opcion: ");
                        opcion = key.nextInt();
                        switch (opcion) {
                            case 1:
                                addServicio();
                                break;
                            case 2:
                                listaServicios();
                                break;
                            case 3:
                                listaIngresos();
                                break;

                        }
                    } while (opcion != 4);
                    break;
            }
        } while(opcion != 3);
    }
    public static void addChofer() {
        int id;
        String nombre;
        String apellido;
        System.out.print("Id: ");
        id = key.nextInt();
        key.nextLine();
        System.out.print("Nombre: ");
        nombre = key.nextLine();
        System.out.print("Apellido: ");
        apellido = key.nextLine();
        Chofer chofers = new Chofer(id, nombre, apellido);
        if (asignaciones.addChofer(chofers)) {
            System.out.println("se agrego corectamente");
        }
    }
    public static void addUnidad(){
        int matricula;
        String modelo;
        System.out.print("Matricula: ");
        matricula = key.nextInt();
        key.nextLine();
        System.out.print("Modelo: ");
        modelo = key.nextLine();
        Unidad unidades = new Unidad(matricula, modelo);
        if (asignaciones.addUnidad(unidades)){
            System.out.println("se agrego correctamenre");
        }
    }
    public static void addServicio(){
        int servicio;
        String chofer;
        int matricula;
        float ingreso;
        LocalDate fecha;
        LocalTime hora;
        System.out.print("Numero de servicio: ");
        servicio = key.nextInt();
        key.nextLine();
        System.out.print("Chofer: ");
        chofer = key.nextLine();
        System.out.print("Matricula de la unidad: ");
        matricula = key.nextInt();
        key.nextLine();
        System.out.print("Costo del viaje: ");
        ingreso = key.nextFloat();
        key.nextLine();
        System.out.print("Fecha del viaje (AAAA-MM-DD): ");
        fecha = LocalDate.parse(key.next());
        key.nextLine();
        System.out.print("Hora del viaje (HH:MM:SS): ");
        hora = LocalTime.parse(key.next());
        Servicio servicios = new Servicio(servicio, chofer, matricula, ingreso, fecha, hora);
        if (serv.addServicio(servicios)){
            System.out.println("Se agrego correctamente");
        }
    }
    public static void listaServicios(){
        ArrayList<Servicio> lista;
        lista = serv.getServicios();
        for (int i=0;i< lista.size();i++) {
            System.out.println(lista.get(i));
        }
    }
    public static void listaIngresos(){
        ArrayList<Float> lista;
        lista = serv.copiarIngresos();
        for (int i=0;i< lista.size();i++) {
            System.out.println("Los ingresos son: " + lista.get(i));
        }
    }
    public static void asignarUnidad() {
        int indiceUnidad;
        int indiceChofer;
        ArrayList<Unidad> unidadesDisponibles;
        unidadesDisponibles = asignaciones.getUnidades();
        for (int i = 0; i < unidadesDisponibles.size(); i++) {
        }
        ArrayList<Chofer> chofersDisponibles;
        chofersDisponibles = asignaciones.getChofers();
        for (int i = 0; i < chofersDisponibles.size(); i++) {
        }
        if (unidadesDisponibles.isEmpty() || chofersDisponibles.isEmpty()) {
            System.out.println("No hay unidades o choferes disponibles para asignar.");
            return;
        }
        System.out.println("Unidades disponibles:");
        for (int i = 0; i < unidadesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + unidadesDisponibles.get(i));
        }
        System.out.print("Seleccione el número de la unidad a la que desea asignar un chofer: ");
        indiceUnidad = key.nextInt();
        if (indiceUnidad <= 0 || indiceUnidad > unidadesDisponibles.size()) {
            System.out.println("La selección de unidad no es válida.");
            return;
        }
        System.out.println("Choferes disponibles:");
        for (int i = 0; i < chofersDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + chofersDisponibles.get(i));
        }
        System.out.print("Seleccione el número del chofer que desea asignar a la unidad: ");
        indiceChofer = key.nextInt();
        if (indiceChofer <= 0 || indiceChofer > chofersDisponibles.size()) {
            System.out.println("La selección de chofer no es válida.");
            return;
        }
        Unidad unidadSeleccionada = unidadesDisponibles.get(indiceUnidad );
        Chofer choferSeleccionado = chofersDisponibles.get(indiceChofer );
        System.out.println("Se ha asignado el chofer '" + choferSeleccionado + "' a la unidad '" + unidadSeleccionada + "'.");
    }



}
