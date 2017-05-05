package edu.eci.cosw.cheapestPrice.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amoto on 5/4/17.
 */

@Entity
@Table(name="USUARIOS_AUTENTICACION")
public class Cuenta implements Serializable{

    @Id
    @Column(name = "USUARIOS_id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column(name = "hash", nullable = false, insertable = false, updatable = false)
    private String hash;

    @Column(name = "rol", nullable = false, insertable = false, updatable = false)
    private String rol;

    @Column(name = "habilitado", nullable = false, insertable = false, updatable = false)
    private boolean habilitado;

    public Cuenta(int id,String hash, String rol){
        this.id=id;
        this.hash=hash;
        this.rol=rol;
        this.habilitado=true;
    }

    public Cuenta(){ this.habilitado=true; }

    public String getHash() {
        return hash;
    }

    public boolean isHabilitado() {
        return habilitado;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRol() { return rol;}

    public void setRol(String rol) { this.rol = rol;}
}
