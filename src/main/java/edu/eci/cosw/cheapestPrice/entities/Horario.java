package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by root on 2/19/17.
 */
public class Horario {
    private int horaInicio;
    private int minutosInicio;
    private int horaFin;
    private int minutoFin;

    public Horario(int horaInicio, int minutosInicio, int horaFin, int minutoFin) {
        this.horaInicio = horaInicio;
        this.minutosInicio = minutosInicio;
        this.horaFin = horaFin;
        this.minutoFin = minutoFin;
    }

    public Horario() {
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinutosInicio() {
        return minutosInicio;
    }

    public void setMinutosInicio(int minutosInicio) {
        this.minutosInicio = minutosInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public int getMinutoFin() {
        return minutoFin;
    }

    public void setMinutoFin(int minutoFin) {
        this.minutoFin = minutoFin;
    }
}
