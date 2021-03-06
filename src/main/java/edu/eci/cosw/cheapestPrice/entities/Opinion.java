package edu.eci.cosw.cheapestPrice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ger9410 on 13/03/17.
 */
@Entity
@Table(name="OPINIONES")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="comentario")
    private String comentario;

    @Column(name="gusta")
    private boolean gusta;

    @Column(name="fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name="USUARIOS_id",referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    })
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name="TIENDAS_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
    })
    @JsonIgnore
    private Tienda tienda;

    public Opinion(){}

    public Opinion(int id,String comentario,boolean like,Date fecha){
        this.id=id;
        this.comentario=comentario;
        this.gusta=like;
        this.fecha=fecha;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isGusta() {
        return gusta;
    }

    public boolean getGusta() {
        return gusta;
    }

    public void setGusta(boolean like) {
        this.gusta = like;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}