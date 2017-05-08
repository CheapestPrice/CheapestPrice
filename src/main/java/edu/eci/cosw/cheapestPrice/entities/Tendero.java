package edu.eci.cosw.cheapestPrice.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Paula on 21/02/2017.
 */
@Entity
@Table(name = "TENDEROS")
public class Tendero implements Serializable{
    @OneToOne(targetEntity = Tienda.class)
    @JoinColumns({
            @JoinColumn(name="TIENDAS_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
    })
    private Tienda tienda;

    @OneToOne(targetEntity = Usuario.class)
    @JoinColumns({
            @JoinColumn(name="USUARIOS_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
    })
    private Usuario usuario;

    @Column(name = "USUARIOS_id", nullable = false)
    @Id
    private int usuarioId;

    @Column(name = "TIENDAS_id", nullable = false)
    private int tiendaid;

    public Tendero(){}

    public Tendero(Usuario usuario,Tienda tienda,int usuarioId, int tiendaid){
        this.setUsuario(usuario);
        this.setTienda(tienda);
        this.setUsuarioId(usuarioId);
        this.setTiendaid(tiendaid);
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTiendaid() {
        return tiendaid;
    }

    public void setTiendaid(int tiendaid) {
        this.tiendaid = tiendaid;
    }
}