package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julian David Devia Serna on 2/19/17.
 */
@Entity
@Table(name = "ITEMS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item implements Serializable {

    @EmbeddedId
    private ItemId id;
    @Column(name = "precio")
    private long precio;

    public Item(){};

    public Item(ItemId id){
        this.setId(id);
    }

    public Item(ItemId id,long precio){
        this.setId(id);
        setPrecio(precio);
    }

    public ItemId getId() {
        return id;
    }

    public void setId(ItemId id) {
        this.id = id;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }
}
