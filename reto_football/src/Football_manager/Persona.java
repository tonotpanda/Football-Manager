package Football_manager;

import java.time.LocalDate;
import java.util.Date;

public class Persona {
    //Atributos
    protected String Nombre;
    protected String Apellido;
    protected LocalDate fecha;
    protected double MotivacionLvl;
    protected double SueldoAnual;

    //Constructores

    public Persona(String nombre, String apellido, LocalDate fecha, double motivacionLvl, double sueldoAnual) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.fecha = fecha;
        this.MotivacionLvl = motivacionLvl;
        this.SueldoAnual = sueldoAnual;
    }

    //Getters & Setters
    public String getNombre() {
        return Nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public double getSueldoAnual() {
        return SueldoAnual;
    }
    public void setSueldoAnual(int sueldoAnual) {
        SueldoAnual = sueldoAnual;
    }

    //Metodos
    public void entrenamiento() {
    }
}
