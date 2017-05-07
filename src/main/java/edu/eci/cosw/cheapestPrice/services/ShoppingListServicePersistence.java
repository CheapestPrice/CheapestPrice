package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import edu.eci.cosw.cheapestPrice.persistence.ShoppingListPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 2105684 on 5/5/17.
 */
@Service
public class ShoppingListServicePersistence implements ShoppingListService {
    @Autowired
    ShoppingListPersistence slp;
    public ShoppingListServicePersistence(){}

    @Override
    public ItemLista loadItemListaByLista(int lId, int ilId) {
        return slp.loadItemListaByLista(lId, ilId);
    }
}
