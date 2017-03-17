package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;

/**
 * Created by ger9410 on 13/03/17.
 */
@Entity
@Table(name="OPINIONES")
public class Opinion implements Serializable {
    private int id;
    private String comentario;
    private boolean like;
    private Timestamp fecha;
    private String correo;

    public Opinion(){}

    public Opinion(int id,String comentario,boolean like,Timestamp fecha){
        this.setId(id);
        this.setComentario(comentario);
        this.setLike(like);
        this.setFecha(fecha);
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="comentario")
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Column(name="like")
    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Column(name="USUARIOS_correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
