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
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Tienda.class)
    @JoinColumns({
            @JoinColumn(name="TIENDAS_id", referencedColumnName="x", nullable=false, insertable=false, updatable=false)
    })
    private Tienda tienda;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Usuario.class)
    @JoinColumns({
            @JoinColumn(name="USUARIOS_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
    })
    private Usuario usuario;

    @Column(name = "USUARIOS_id", nullable = false, insertable = false, updatable = false)
    @Id
    private int id;

    public Tendero(){}

    public Tendero(Usuario usuario,Tienda tienda,int id){
        this.setUsuario(usuario);
        this.setTienda(tienda);
        this.setId(id);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}