package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 2105403 on 3/14/17.
 */
@Embeddable
public class ListaMercado_Item implements Serializable {

    private String nombre;
    private Usuario usuario;

    public ListaMercado_Item(){}

    public ListaMercado_Item(String nombre,Usuario usuario){
        setNombre(nombre);
        this.setUsuario(usuario);
    }

    @Column(name="nombre", nullable = false,insertable=false, updatable=false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="USUARIOS_correo",referencedColumnName = "correo", nullable = false,insertable=false, updatable=false)
    })
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
