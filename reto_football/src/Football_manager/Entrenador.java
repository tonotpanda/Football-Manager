package Football_manager;

import java.time.LocalDate;

public class Entrenador extends Persona{
    //Atributos
    private int NumTorneosGanados;
    private boolean SeleccionadorNacional;
    private String EquipoActual;

    //Constructor
    public Entrenador(String nombre, String apellido, LocalDate fecha, double motivacionLvl, double sueldoAnual,
                      int numTorneosGanados, boolean seleccionadorNacional, String equipoActual) {
        super(nombre, apellido, fecha, motivacionLvl, sueldoAnual);
        NumTorneosGanados = numTorneosGanados;
        SeleccionadorNacional = seleccionadorNacional;
        EquipoActual = equipoActual;
    }

    //Getters&Setters
    public String getEquipoActual() {
        return this.EquipoActual;
    }
    public void setEquipoActual(String equipoActual) {
        this.EquipoActual = equipoActual;
    }
    public boolean isSeleccionadorNacional() {
        return this.SeleccionadorNacional;
    }

    //Metodos
    @Override
    public void entrenamiento() {
        if (isSeleccionadorNacional()) {
            this.MotivacionLvl += 0.3;
        } else {
            this.MotivacionLvl += 0.15;
        }
    }
    void incrementarDinero() {
        double incremento = this.getSueldoAnual() * 0.0015;
        this.setSueldoAnual((int) (this.getSueldoAnual() + incremento));
    }
}
