package ru.skypro.cource2.spring.spring211.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketEntity {
    private final Map<Integer, BasketItemEntity> basketItems = new HashMap<>();

    public void add(BasketItemEntity basketItem) {
        basketItems.merge(basketItem.getId(), basketItem, BasketItemEntity::increaseFromBasketItem);
    }

    public BasketItemEntity get(Integer id) {
        return basketItems.get(id);
    }

    public List<BasketItemEntity> get() {
        return List.of(basketItems.values().toArray(new BasketItemEntity[0]));
    }
}
