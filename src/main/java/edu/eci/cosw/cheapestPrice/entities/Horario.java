package edu.eci.cosw.cheapestPrice.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by masterhugo on 2/19/17.
 */
@Entity
@Table(name="HORARIOS")
public class Horario implements Serializable{

    @Column(name="horaInicio", nullable=false)
    private int horaInicio;

    @Column(name="minutosInicio", nullable=false)
    private int minutosInicio;

    @Column(name="horaFin", nullable=false)
    private int horaFin;

    @Column(name="minutosFin", nullable=false)
    private int minutoFin;

    @Id
    @GeneratedValue
    private int id;

    @Column(name="dia", nullable=false)
    private String dia;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name="TIENDAS_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
    })
    @JsonIgnore
    private Tienda tienda;

    public Horario(int horaInicio, int minutosInicio, int horaFin, int minutoFin,Tienda tienda,String dia,int id) {
        this.setHoraInicio(horaInicio);
        this.setMinutosInicio(minutosInicio);
        this.setHoraFin(horaFin);
        this.setMinutoFin(minutoFin);
        setTienda(tienda);
        this.id=id;

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

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}