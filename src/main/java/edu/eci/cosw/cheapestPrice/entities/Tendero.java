package edu.eci.cosw.cheapestPrice.entities;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Paula on 21/02/2017.
 */
@Entity
@Table(name = "TENDEROS")
//@PrimaryKeyJoinColumn(name="USUARIOS_correo",referencedColumnName = "correo")
//@AttributeOverride(name="correo", column=@Column(name="USUARIOS_correo"))
public class Tendero implements Serializable, Persona{

    @Column(name = "USUARIOS_correo", nullable = false, insertable = false, updatable = false)
    @Id
    protected String correo;

    @Column(name = "nombre", nullable = false)
    protected String nombre;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Tienda.class)
    @JoinColumns({
            @JoinColumn(name="TIENDAS_x", referencedColumnName="x", nullable=false, insertable=false, updatable=false),
            @JoinColumn(name="TIENDAS_y", referencedColumnName="y", nullable=false, insertable=false, updatable=false),
            @JoinColumn(name="TIENDAS_nit", referencedColumnName="nit", nullable=false, insertable=false, updatable=false)
    })
    private Tienda tienda;

    @Column(name="TIENDAS_nit", nullable=false, insertable=false,updatable=false)
    private String nit;

    @Column(name="TIENDAS_x", nullable=false ,insertable=false,updatable=false)
    private double x;

    @Column(name="TIENDAS_y", nullable=false ,insertable=false,updatable=false)
    private double y;

    public Tendero(){}

    public Tendero(String nombre,String correo, String nit, double x, double y){
        //super(nombre,correo);
        this.nombre = nombre;
        this.correo = correo;
        this.nit=nit;
        this.x=x;
        this.y=y;
    }

    @Override
    public String getCorreo(){
        return correo;
    }

    @Override
    public String getNombre(){
        return nombre;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}