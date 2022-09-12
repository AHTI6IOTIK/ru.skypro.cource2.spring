package ru.skypro.cource2.spring.spring211.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.skypro.cource2.spring.spring211.entity.BasketEntity;
import ru.skypro.cource2.spring.spring211.entity.BasketItemEntity;
import ru.skypro.cource2.spring.spring211.factory.BasketItemEntityFactory;

import java.util.List;

@Service
@SessionScope
public class BasketService {
    private final BasketEntity basketEntity = new BasketEntity();
    private final BasketItemEntityFactory basketItemEntityFactory = new BasketItemEntityFactory();

    public void add(int id, double count) {
        basketEntity.add(
            basketItemEntityFactory.createElement(id, count)
        );
    }

    public BasketItemEntity get(Integer id) {
        return basketEntity.get(id);
    }

    public List<BasketItemEntity> get() {
        return basketEntity.get();
    }
}
