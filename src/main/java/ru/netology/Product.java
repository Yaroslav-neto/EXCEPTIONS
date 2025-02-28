package ru.netology;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Product {
    protected int id;
    @Setter
    protected String title;
    @Setter
    protected int price;

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // Вспомогательные методы для корректной работы equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && title.equals(product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price);
    }

    // геттеры + сеттеры
    // на id только геттер — пусть будет неизменяемым для товара
}
