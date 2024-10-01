package Football_manager;

import java.time.LocalDate;
import java.util.ArrayList;

public class Jugador extends Persona implements Transferible {
    //Atributos
    private int Dorsal;
    private String Posicion;
    private double MotivacionLvl;
    private double calida;

    //Array
    public static String[] posiciones = {"POR", "DEF", "MIG", "DAV"};


    //Constructor
    public Jugador(String nombre, String apellido, LocalDate fecha, double motivacionLvl,
                   double sueldoAnual, int dorsal, String posicion, double calidad) {
        super(nombre, apellido, fecha, motivacionLvl, sueldoAnual);
        this.Dorsal = dorsal;
        this.Posicion = posicion;
        this.MotivacionLvl = motivacionLvl; // Elimina el parámetro redundante
        this.calida = calidad;
    }

    //Getters&Setters
    public int getDorsal() {
        return this.Dorsal;
    }

    //Metodos
    @Override
    public String toString() {
        return "Jugador{" +
                "Dorsal=" + this.Dorsal +
                ", Posicion='" + this.Posicion + '\'' +
                ", Motivacion=" + this.MotivacionLvl +
                ", Nombre='" + this.Nombre + '\'' +
                ", Apellido='" + this.Apellido + '\'' +
                ", Fecha nacimiento=" + this.fecha +
                ", MotivacionLvl=" + this.MotivacionLvl +
                ", SueldoAnual=" + this.SueldoAnual +
                '}';
    }

    @Override
    public boolean esTransferible() {
        return true;
    }

    @Override
    public void transferirAEquipo(Equipo equipo, String nombreJugador, Equipo equipo2) {
        int numi;
        ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
        jugadoresEquipo.equals(equipo.getJugadores());
        for (int i = 0; i < equipo.getJugadores().size(); i++) {
            if(equipo.getJugadores().get(i).getNombre().equals(nombreJugador)){
                equipo.getJugadores().remove(equipo.getJugadores().get(i));
                equipo2.getJugadores().add(equipo.getJugadores().get(i));
            }
        }

    }

    @Override
    public void entrenamiento() {
        super.entrenamiento();
        double incrementarAleatorio = generarAleatorio(0.1, 0.3);

        if (incrementarAleatorio <= 0.1) {
            this.calida += 0.1;
            getCalida();
        } else if (incrementarAleatorio <= 0.2) {
            this.calida += 0.2;
            getCalida();
        } else {
            calida += 0.3;
            getCalida();
        }
    }

    private double generarAleatorio(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    public double getCalida() {
        return this.calida;
    }

    protected void cambiarPosicion(int respuesta) {
        double valor_aleatorio = Math.random();

        if (valor_aleatorio <= 0.5) {
            String nueva_posicion = nueva_posicion(respuesta);
            this.Posicion = nueva_posicion;
            this.calida += 1.0;
        }
    }

    private String nueva_posicion(int respuesta) {
        boolean salir = false;
        String jugPosicion;
        do {
            if (respuesta < 1 || respuesta > 4) {
                System.out.println("Selecciona una de las opciones");
                respuesta = Teclat.llegirInt();
            } else {
                salir = true;
            }
        } while (!salir);

        jugPosicion = Jugador.posiciones[respuesta - 1];

        return jugPosicion;
    }


}





