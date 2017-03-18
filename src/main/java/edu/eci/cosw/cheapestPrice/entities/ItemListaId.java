package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 2105684 on 3/17/17.
 */
@Embeddable
public class ItemListaId implements Serializable {
    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "ITEMS_TIENDAS_nit", referencedColumnName = "TIENDAS_nit", nullable = false),
            @JoinColumn(name = "ITEMS_TIENDAS_x", referencedColumnName = "TIENDAS_x", nullable = false),
            @JoinColumn(name = "ITEMS_TIENDAS_y", referencedColumnName = "TIENDAS_y", nullable = false),
            @JoinColumn(name = "ITEMS_PRODUCTOS_id", referencedColumnName = "PRODUCTOS_id", nullable = false)
    })
    private Item item;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "LISTAS_MERCADOS_nombre", referencedColumnName = "nombre", nullable = false),
            @JoinColumn(name = "LISTAS_MERCADOS_USUARIOS_correo", referencedColumnName = "USUARIOS_correo", nullable = false)
    })
    private ListaDeMercado lista;

    public ItemListaId(){}
    public ItemListaId(Item item, ListaDeMercado lista){
        this.setItem(item);
        this.setLista(lista);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ListaDeMercado getLista() {
        return lista;
    }

    public void setLista(ListaDeMercado lista) {
        this.lista = lista;
    }
}
