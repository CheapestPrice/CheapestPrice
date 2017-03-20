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
    @EmbeddedId
    private HorarioId horarioId;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="TIENDAS_x", referencedColumnName="x", nullable=false, insertable=false, updatable=false),
            @JoinColumn(name="TIENDAS_y", referencedColumnName="y", nullable=false, insertable=false, updatable=false),
            @JoinColumn(name="TIENDAS_nit", referencedColumnName="nit", nullable=false, insertable=false, updatable=false)
    })
    @JsonIgnore
    private Tienda tienda;

    public Horario(int horaInicio, int minutosInicio, int horaFin, int minutoFin,Tienda tienda,String dia) {
        this.setHoraInicio(horaInicio);
        this.setMinutosInicio(minutosInicio);
        this.setHoraFin(horaFin);
        this.setMinutoFin(minutoFin);
        setTienda(tienda);
        setHorarioId(new HorarioId(dia,tienda.getId().getNit(),tienda.getId().getX(),tienda.getId().getY()));

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

    public HorarioId getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(HorarioId horarioId) {
        this.horarioId = horarioId;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}