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

    @Column(name = "hash", nullable = false)
    protected String hash;

    @Column(name = "USUARIOS_correo", nullable = false, insertable = false, updatable = false)
    @Id
    protected String email;

    @Column(name = "rol", nullable = false)
    protected String rol;

    @Column(name = "habilitado", nullable = false)
    protected boolean habilitado;

    public Cuenta(String email, String contraseña, String rol){
        this.email=email;
        this.hash=contraseña;
        this.rol=rol;
        this.habilitado=true;
    }

    public Cuenta(){ this.habilitado=true; }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getRol() { return rol;}

    public void setRol(String rol) { this.rol = rol;}

}
