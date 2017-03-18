package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name="ITEMS_LISTA")
public class ItemLista implements Serializable{
    private boolean comprado;
    private boolean favorito;
    private ItemListaId id;

    public ItemLista(){
        super();
    }

    public ItemLista(ItemListaId id, boolean comprado, boolean favorito){
        this.comprado=comprado;
        this.favorito=favorito;
    }

    @Column(name="comprado")
    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    @Column(name="favortio")
    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    @EmbeddedId
    public ItemListaId getId() {
        return id;
    }

    public void setId(ItemListaId id) {
        this.id = id;
    }
}
