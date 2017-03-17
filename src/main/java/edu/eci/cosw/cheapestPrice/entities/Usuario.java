package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {

    private String nombre;
    private String correo;
    private List<ListaDeMercado> listas;
    private List<Opinion> opiniones;

    public Usuario(){}

    public Usuario(String nombre, String correo, List<ListaDeMercado> listas){
        this.setNombre(nombre);
        this.correo=correo;
        this.setListas(listas);
    }

    public Usuario(String nombre,String correo){
        this.setNombre(nombre);
        this.correo=correo;
    }

    public Usuario(String nombre, String correo, List<ListaDeMercado> listas, List<Opinion> opiniones){
        this.setNombre(nombre);
        this.correo=correo;
        this.setListas(listas);
        this.setOpiniones(opiniones);
    }

    /**
     * Agregar productos a la lista de mercado seleccionada por el usuario
     * @param iT
     * @param nombreLista
     */
    public void agregarProducto(ItemLista iT, String nombreLista){
        for(ListaDeMercado lM: listas){
            if(lM.getNombre().equals(nombreLista)){
                lM.agregarProducto(iT);
            }
        }
    }

    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="correo")
    @Id
    public String getCorreo() {
        return correo;
    }

    public void setEmail(String correo) {
        this.correo = correo;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="USUARIOS_correo",referencedColumnName = "correo", nullable = false)
    })
    public List<ListaDeMercado> getListas() {
        return listas;
    }

    public void setListas(List<ListaDeMercado> listas) {
        this.listas = listas;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="USUARIOS_correo",referencedColumnName = "correo", nullable = false)
    })
    public List<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(List<Opinion> opiniones) {
        this.opiniones = opiniones;
    }

}
