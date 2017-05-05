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

    @Column(name = "comprado",nullable = false)
    private boolean comprado;

    @Column(name = "favorito",nullable = false)
    private boolean favorito;

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "ITEMS_TIENDAS_id", referencedColumnName = "TIENDAS_id", nullable = false,insertable = false,updatable = false)
    })
    private Item item;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "LISTAS_MERCADOS_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    })
    @JsonIgnore
    private ListaDeMercado lista;

    public ItemLista(){

    }

    public ItemLista(int id, boolean comprado, boolean favorito){
        this.id=id;
        this.comprado=comprado;
        this.favorito=favorito;
    }

    public ListaDeMercado getLista() {
        return lista;
    }

    public void setLista(ListaDeMercado lista) {
        this.lista = lista;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
