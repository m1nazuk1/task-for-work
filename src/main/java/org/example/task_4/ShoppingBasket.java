package org.example.task_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket implements Basket {

    private Map<String, Integer> products;

    public ShoppingBasket() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(String product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            if (quantity > 0) {
                products.put(product, quantity);
            } else {
                removeProduct(product);
            }
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        return products.getOrDefault(product, 0);
    }

    public static void main(String[] args) {
        Basket basket = new ShoppingBasket();
        basket.addProduct("Яблоки", 10);
        basket.addProduct("Бананы", 5);

        System.out.println("Товары в корзине:");
        basket.getProducts().forEach(System.out::println);

        System.out.println("Количество яблок: " + basket.getProductQuantity("Яблоки"));

        basket.updateProductQuantity("Яблоки", 5);
        System.out.println("Обновленное количество яблок: " + basket.getProductQuantity("Яблоки"));

        basket.removeProduct("Бананы");
        System.out.println("Бананы удалены. Товары в корзине теперь:");
        basket.getProducts().forEach(System.out::println);

        basket.clear();
        System.out.println("Корзина очищена. Товары в корзине:");
        basket.getProducts().forEach(System.out::println);
    }

}