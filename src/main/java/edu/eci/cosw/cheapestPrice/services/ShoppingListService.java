package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;

/**
 * Created by 2105684 on 5/5/17.
 */
public interface ShoppingListService {
    public ItemLista loadItemListaByLista(int lId, int ilId);
}
