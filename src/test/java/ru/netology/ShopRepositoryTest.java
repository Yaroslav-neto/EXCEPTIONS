package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    Product product1 = new Product(1, "Хлеб", 70);
    Product product2 = new Product(12, "Молоко", 200);
    Product product3 = new Product(6, "Масло", 300);

    @Test
        // обязательный тест задания 1
    void removeWithNotFoundId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(12);

        assertArrayEquals(new Product[]{product1, product3}, repo.getProducts());
    }

    @Test
        // обязательный тест задания 1
    void removeWithNull() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(123));
    }

    @Test
// обязательный тест задания 2
    void addFoundId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        assertEquals(product3, repo.findById(6));
    }

    @Test
// обязательный тест задания 2
    void addFoundWithExistId() {
        ShopRepository repo = new ShopRepository();
        Product product4 = new Product(12, "Чипсы", 30);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(product4));
    }

    @Test
    void findAll() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product(1, "a", 10);
        Product product2 = new Product(2, "s", 20);

        Assertions.assertEquals(product1.hashCode(), product1.hashCode());
        Assertions.assertNotEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void testEquals() {
        Product product = new Product(1, "a", 10);

        Assertions.assertNotEquals(null, product);
    }

    @Test
    void testEqualsDifferentClass() {
        Product product = new Product(1, "a", 10);
        String feeling = "1, s, 20";

        assertNotEquals(feeling, product);
    }

    @Test
    public void testEqualsNull() {
        Product product = new Product(1, "Молоко", 10);

        Assertions.assertNotEquals(null, product);
    }

    @Test
    public void testEqualsSameInstance() {
        Product product = new Product(1, "Молоко", 10);

        Assertions.assertTrue(product.equals(product));
    }

    @Test
    public void testEqualsIdenticalObjects() {
        Product product1 = new Product(1, "Молоко", 100);
        Product product2 = new Product(1, "Молоко", 100);

        assertEquals(product1, product2);
    }
}



