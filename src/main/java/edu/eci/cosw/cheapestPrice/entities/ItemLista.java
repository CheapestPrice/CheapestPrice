package edu.eci.cosw.cheapestPrice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name = "ITEMS_LISTA")
public class ItemLista implements Serializable{

    /**
     * @return the lista
     */
    public ListaDeMercado getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaDeMercado lista) {
        this.lista = lista;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    @Column(name = "comprado",nullable = false)
    private boolean comprado;

    @Column(name = "favorito",nullable = false)
    private boolean favorito;

    @EmbeddedId
    @JsonIgnore
    private ItemListaId id;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "ITEMS_TIENDAS_nit", referencedColumnName = "TIENDAS_nit", nullable = false,insertable = false,updatable = false),
            @JoinColumn(name = "ITEMS_TIENDAS_x", referencedColumnName = "TIENDAS_x", nullable = false,insertable = false,updatable = false),
            @JoinColumn(name = "ITEMS_TIENDAS_y", referencedColumnName = "TIENDAS_y", nullable = false,insertable = false,updatable = false),
            @JoinColumn(name = "ITEMS_PRODUCTOS_id", referencedColumnName = "PRODUCTOS_id", nullable = false,insertable = false,updatable = false)
    })
    private Item item;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "LISTAS_MERCADOS_nombre", referencedColumnName = "nombre", nullable = false,insertable = false,updatable = false),
            @JoinColumn(name = "LISTAS_MERCADOS_USUARIOS_correo", referencedColumnName = "USUARIOS_correo", nullable = false,insertable = false,updatable = false)
    })
    @JsonIgnore
    private ListaDeMercado lista;

    public ItemLista(){
        super();
    }

    public ItemLista(ItemListaId id, boolean comprado, boolean favorito){
        this.comprado=comprado;
        this.favorito=favorito;
    }


    public boolean isComprado() {
        return comprado;
    }

    public boolean getComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public ItemListaId getId() {
        return id;
    }

    public void setId(ItemListaId id) {
        this.id = id;
    }
}
