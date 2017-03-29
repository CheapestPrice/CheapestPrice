package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Paula on 18/03/2017.
 */
@Entity
@Table(name="USUARIOS_AUTENTICACION")
public class Cuenta implements Serializable{


    private String hash;

    private String email;


    private String rol;


    private boolean habilitado;

    public Cuenta(String email, String hash, String rol){
        this.email=email;
        this.hash=hash;
        this.rol=rol;
        this.habilitado=true;
    }

    public Cuenta(){ this.habilitado=true; }

    @Column(name = "hash", nullable = false)
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Column(name = "USUARIOS_correo", nullable = false, insertable = false, updatable = false)
    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "habilitado", nullable = false)
    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Column(name = "rol", nullable = false)
    public String getRol() { return rol;}

    public void setRol(String rol) { this.rol = rol;}

}
