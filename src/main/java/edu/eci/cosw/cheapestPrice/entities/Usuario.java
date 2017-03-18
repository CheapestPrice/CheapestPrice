package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name="USUARIOS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable {

    protected String nombre;
    protected String correo;
    protected List<ListaDeMercado> listas;
    protected List<Opinion> opiniones;

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
            if(lM.getListaid().getNombre().equals(nombreLista)){
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "listaid.usuario")
    /*@JoinColumns({
            @JoinColumn(name="USUARIOS_correo",referencedColumnName = "correo", nullable = false,insertable=false, updatable=false)
    })*/
    public List<ListaDeMercado> getListas() {
        return listas;
    }

    public void setListas(List<ListaDeMercado> listas) {
        this.listas = listas;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="USUARIOS_correo",referencedColumnName = "correo", nullable = false,insertable=false, updatable=false)
    })
    public List<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(List<Opinion> opiniones) {
        this.opiniones = opiniones;
    }

}
