package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name="ITEMS_LISTA")
public class ItemLista extends Item{
    private boolean comprado;
    private boolean favorito;
    private Item item;
    private ItemLista_Item itemId;
    private Usuario user;

    public ItemLista(){
        super();
    }

    public ItemLista(Tienda tienda, Producto producto, boolean comprado, boolean favorito){
        super(tienda, producto);
        this.comprado=comprado;
        this.favorito=favorito;
    }

    public ItemLista(Tienda tienda, Producto producto, boolean comprado, boolean favorito,Item item,ItemLista_Item itemId){
        super(tienda, producto);
        this.comprado=comprado;
        this.favorito=favorito;
        this.item=item;
        this.itemId=itemId;
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
    public Item getItemId() {
        return getItem();
    }

    public void setItemId(Item itemId) {
        this.setItem(itemId);
    }

    @JoinColumns({
            @JoinColumn(name="ITEMS_PRODUCTOS_id", referencedColumnName="PRODUCTOS_id", nullable=false),
            @JoinColumn(name="ITEMS_TIENDAS_x", referencedColumnName="TIENDAS_x", nullable=false),
            @JoinColumn(name="ITEMS_TIENDAS_y", referencedColumnName="TIENDAS_y", nullable=false),
            @JoinColumn(name="ITEMS_TIENDAS_nit", referencedColumnName="TIENDAS_nit", nullable=false),
    })
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @JoinColumn(name="correo",referencedColumnName = "USUARIOS_correo", nullable = false)
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
