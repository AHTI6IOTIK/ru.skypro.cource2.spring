package ru.skypro.cource2.spring.spring211.entity;

import java.util.Objects;

public class BasketItemEntity {
    private int id;
    private double count;

    public BasketItemEntity(int id, double count) {
        this.id = id;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public BasketItemEntity setId(int id) {
        this.id = id;
        return this;
    }

    public double getCount() {
        return count;
    }

    public BasketItemEntity setCount(double count) {
        this.count = count;
        return this;
    }

    public BasketItemEntity increaseFromBasketItem(BasketItemEntity basketItem) {
        count += basketItem.getCount();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasketItemEntity)) return false;
        BasketItemEntity that = (BasketItemEntity) o;
        return id == that.id && Double.compare(that.count, count) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }

    @Override
    public String toString() {
        return "BasketItemEntity{" +
            "id=" + id +
            ", count=" + count +
            '}';
    }
}
