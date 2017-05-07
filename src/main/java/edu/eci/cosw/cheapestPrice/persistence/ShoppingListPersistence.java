package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;

/**
 * Created by 2105684 on 5/5/17.
 */
public interface ShoppingListPersistence {

    public ItemLista loadItemListaByLista(int lId, int ilId);
}
