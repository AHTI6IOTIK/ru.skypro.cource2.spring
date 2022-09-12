package ru.skypro.cource2.spring.spring211.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.cource2.spring.spring211.entity.BasketItemEntity;
import ru.skypro.cource2.spring.spring211.service.BasketService;

import java.util.List;

@RestController
@RequestMapping("/store/basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(value ="/add")
    public void add(@RequestParam int id, @RequestParam double count) {
        basketService.add(id, count);
    }

    @RequestMapping(value = "/get", params = "id")
    public BasketItemEntity get(@RequestParam Integer id) {
        return basketService.get(id);
    }

    @RequestMapping(value = "/get")
    public List<BasketItemEntity> get() {
        return basketService.get();
    }
}
