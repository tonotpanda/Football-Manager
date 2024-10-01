package Football_manager;

import java.util.ArrayList;

public class Equipo {
    //Atributos
    protected String NombreEquipo;
    protected int AnyoFundacion;
    protected String Ciudad;
    protected String nombreEstadio;
    protected String nombrePresidente;
    protected Entrenador entrenador;
    protected ArrayList<Jugador> jugadores;
    private int puntos;

    //Constructores
    public Equipo(String nombreEquipo, int anyoFundacion, String ciudad, String nombreEstadio,
                  String nombrePresidente, Entrenador entrenador, ArrayList<Jugador> jugadores) {
        NombreEquipo = nombreEquipo;
        AnyoFundacion = anyoFundacion;
        Ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.nombrePresidente = nombrePresidente;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
    }

    //Getters&Setters
    public Entrenador getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    public String getNombreEquipo() {
        return this.NombreEquipo;
    }
    public int getAnyoFundacion() {
        return this.AnyoFundacion;
    }
    public String getCiudad() {
        return this.Ciudad;
    }
    public String getNombreEstadio() {
        return nombreEstadio;
    }
    public String getNombrePresidente() {
        return nombrePresidente;
    }

    public void setNombrePresidente(String nombrePresidente) {
        this.nombrePresidente = nombrePresidente;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    //Metodos
    protected String mosrarAtributos() {
        return "Nombre equipo: " + getNombreEquipo() + "\n" +
                "Año fundacion: " + getAnyoFundacion() + "\n" +
                "Ciudad: " + getCiudad() + "\n" +
                "Nombre del estadio: " + getNombreEstadio() + "\n" +
                "Nombre presidente: " + getNombrePresidente() + "\n";
    }

    @Override
    public String toString() {
        return "Nombre equipo: " + getNombreEquipo() + "\n" +
                "Año fundacion: " + getAnyoFundacion() + "\n" +
                "Ciudad: " + getCiudad() + "\n" +
                "Nombre del estadio: " + getNombreEstadio() + "\n" +
                "Nombre presidente: " + getNombrePresidente() + "\n";
    }

    public void sumarPuntos(int puntosASumar) {
        this.puntos += puntosASumar;
    }


}
