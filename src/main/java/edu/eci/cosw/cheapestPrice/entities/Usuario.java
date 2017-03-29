package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name = "USUARIOS")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Persona,Serializable {

    @Column(name = "nombre", nullable = false)
    protected String nombre;

    @Column(name = "correo", nullable = false, insertable = false, updatable = false)
    @Id
    protected String correo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    protected List<ListaDeMercado> listas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    protected List<Opinion> opiniones;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, List<ListaDeMercado> listas) {
        this.nombre = nombre;
        this.correo = correo;
        this.listas=new ArrayList<>();
    }

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public Usuario(String nombre, String correo, List<ListaDeMercado> listas, List<Opinion> opiniones) {
        this.nombre = nombre;
        this.correo = correo;
        this.setListas(listas);
        this.setOpiniones(opiniones);
    }

    /**
     * Agregar productos a la lista de mercado seleccionada por el usuario
     *
     **/
    public void agregarProducto(ItemLista iT, String nombreLista){
        for(ListaDeMercado lM: listas){
            if(lM.getListaid().getNombre().equals(nombreLista)){
                lM.agregarProducto(iT);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<ListaDeMercado> getListas() {
        return listas;
    }

    public void setListas(List<ListaDeMercado> listas) {
        this.listas = listas;
    }

    public List<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(List<Opinion> opiniones) {
        this.opiniones = opiniones;
    }

}