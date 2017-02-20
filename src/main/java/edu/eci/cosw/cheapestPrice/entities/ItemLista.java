package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by 2105403 on 2/20/17.
 */
public class ItemLista extends Item{
    private boolean comprado;
    private boolean favorito;

    public ItemLista(){
        super();
    }

    public ItemLista(Tienda tienda, Producto producto, boolean comprado, boolean favorito){
        super(tienda, producto);
        this.comprado=comprado;
        this.favorito=favorito;
    }
    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
