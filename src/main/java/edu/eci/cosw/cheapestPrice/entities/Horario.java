package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by masterhugo on 2/19/17.
 */
@Entity
@Table(name="HORARIOS")
public class Horario implements Serializable{
    private int horaInicio;
    private int minutosInicio;
    private int horaFin;
    private int minutoFin;
    private String dia;

    public Horario(int horaInicio, int minutosInicio, int horaFin, int minutoFin,String dia) {
        this.setHoraInicio(horaInicio);
        this.setMinutosInicio(minutosInicio);
        this.setHoraFin(horaFin);
        this.setMinutoFin(minutoFin);
        this.setDia(dia);
    }

    public Horario() {
    }


    @Column(name="horaInicio", nullable=false)
    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Column(name="minutosInicio", nullable=false)
    public int getMinutosInicio() {
        return minutosInicio;
    }

    public void setMinutosInicio(int minutosInicio) {
        this.minutosInicio = minutosInicio;
    }

    @Column(name="horaFin", nullable=false)
    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    @Column(name="minutosFin", nullable=false)
    public int getMinutoFin() {
        return minutoFin;
    }

    public void setMinutoFin(int minutoFin) {
        this.minutoFin = minutoFin;
    }

    @Column(name = "dia", nullable = false)
    @Id
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
