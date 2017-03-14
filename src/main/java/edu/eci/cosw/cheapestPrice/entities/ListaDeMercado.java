package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name="LISTAS_MERCADOS")
public class ListaDeMercado {

    private String nombre;
    private Date fechaCreacion;
    private boolean revisado;
    private List<ItemLista> items;
    private String correo;

    public ListaDeMercado(){}

    public ListaDeMercado(String nombre, Date fechaCreacion, boolean revisado){
        this.setNombre(nombre);
        this.setFechaCreacion(fechaCreacion);
        this.setRevisado(revisado);
        setItems(new ArrayList<>());
    }

    /**
     * Agrega items a la lista de mercado
     * @param ite
     */
    public void agregarProducto(ItemLista ite){
        items.add(ite);
    }

    /**
     * Marca items como comprados
     * @param id
     */
    public void marcarProductoComprado(long id){
        for(ItemLista i: items){
            if(i.getProducto().getId()==id){
                i.setComprado(true);
            }
        }
    }

    /**
     * Marca items como favoritos
     * @param id
     */
    public void marcarProductoFavorito(long id){
        for(ItemLista i: items){
            if(i.getProducto().getId()==id){
                i.setFavorito(true);
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

    @Temporal(TemporalType.DATE)
    @Column(name="fechaCreacion")
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Column(name="realizado")
    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<ItemLista> getItems() {
        return items;
    }

    public void setItems(List<ItemLista> items) {
        this.items = items;
    }

    @Column(name="USUARIOS_correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
