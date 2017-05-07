package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import edu.eci.cosw.cheapestPrice.persistence.ShoppingListPersistence;
import edu.eci.cosw.cheapestPrice.repositories.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 2105684 on 5/5/17.
 */
@Service
public class ShoppingListPersistenceHibernate implements ShoppingListPersistence {

    @Autowired
    ShoppingListRepository slr;

    public ShoppingListPersistenceHibernate(){};

    @Override
    public ItemLista loadItemListaByLista(int lId, int ilId) {
        return slr.loadItemListaByLista(lId, ilId);
    }
}
