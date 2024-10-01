package Football_manager;

import java.util.ArrayList;
import java.util.Random;

public class Liga {
    //Atributos

    private String nombre;
    private int numeroEquipos;
    private ArrayList<Equipo> equiposliga;
    private Random random = new Random();


    //Constructor

    public Liga(String nombre, int numeroEquipos, ArrayList<Equipo> equiposliga) {
        this.nombre = nombre;
        this.numeroEquipos = numeroEquipos;
        this.equiposliga = equiposliga;
    }

    //Getters&Setters

    //Metodos
    public void meterEquipoLiga(Equipo equipo) {
       this.equiposliga.add(equipo);
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                ", numeroEquipos=" + numeroEquipos +
                ", equiposliga=" + equiposliga +
                '}';
    }

    public void jugarPartidos() {
        int numeroJornadas = numeroEquipos - 1;

        for (int jornada = 1; jornada <= numeroJornadas; jornada++) {
            System.out.println("Jornada " + jornada);
            for (int i = 0; i < equiposliga.size(); i++) {
                for (int j = i + 1; j < equiposliga.size(); j++) {
                    Equipo equipoLocal = equiposliga.get(i);
                    Equipo equipoVisitante = equiposliga.get(j);
                    simularPartido(equipoLocal, equipoVisitante);
                    mostrarResultadoSimulado(equipoLocal, equipoVisitante);
                }
            }
        }
    }

    private void simularPartido(Equipo equipoLocal, Equipo equipoVisitante) {
        int resultadoLocal = random.nextInt(3);
        int resultadoVisitante = 2 - resultadoLocal;

        switch (resultadoLocal) {
            case 0:
                equipoLocal.sumarPuntos(1);
                equipoVisitante.sumarPuntos(1);
                break;
            case 1:
                equipoLocal.sumarPuntos(3);
                break;
            case 2:
                equipoVisitante.sumarPuntos(3);
                break;
        }
    }

    private void mostrarResultadoSimulado(Equipo equipoLocal, Equipo equipoVisitante) {
        System.out.println(equipoLocal.getNombreEquipo() + " vs " + equipoVisitante.getNombreEquipo());
        switch (random.nextInt(3)) {
            case 0:
                System.out.println("Empate");
                break;
            case 1:
                System.out.println(equipoLocal.getNombreEquipo() + " gana");
                break;
            case 2:
                System.out.println(equipoVisitante.getNombreEquipo() + " gana");
                break;
        }
    }




}


