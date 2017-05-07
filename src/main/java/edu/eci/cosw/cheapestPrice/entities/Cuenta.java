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
    @Column(name = "USUARIOS_id", nullable = false)
    private int id;
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Usuario.class)
    @JoinColumns({
            @JoinColumn(name="USUARIOS_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
    })
    private Usuario usuario;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "hash", nullable = false)
    private String hash;

    @Column(name = "habilitado", nullable = false,insertable = false,updatable = false)
    private boolean habilitado;

    public Cuenta(int id,String hash, String rol,Usuario user, boolean habilitado){
        this.id=id;
        this.rol=rol;
        this.hash=hash;
        this.usuario=user;
        this.habilitado=habilitado;
    }

    public Cuenta(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRol() { return rol;}

    public void setRol(String rol) { this.rol = rol;}

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
