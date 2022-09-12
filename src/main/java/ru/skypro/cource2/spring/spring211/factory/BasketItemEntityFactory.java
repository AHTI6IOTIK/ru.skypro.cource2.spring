package ru.skypro.cource2.spring.spring211.factory;

import ru.skypro.cource2.spring.spring211.entity.BasketItemEntity;

public class BasketItemEntityFactory {
    public BasketItemEntity createElement(int id, double count) {
        return (new BasketItemEntity(id, (count > 0 ? count : 1)));
    }
}
