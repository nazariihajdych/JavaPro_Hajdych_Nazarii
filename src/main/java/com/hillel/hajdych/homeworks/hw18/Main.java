package com.hillel.hajdych.homeworks.hw18;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product book1 = new Product( "Book", 277, true);
        Product book2 = new Product( "Book", 33);
        Product book3 = new Product( "Book", 33, true);
        Product book4 = new Product( "Book", 33);
        Product pen = new Product( "Pen", 12);
        Product pen2 = new Product( "Pen", 21);
        Product copybook = new Product( "Copybook", 6);
        Product copybook2 = new Product( "Copybook", 5);

        List<Product> productList = new ArrayList<>();
        productList.add(book1);
        productList.add(book2);
        productList.add(book3);
        productList.add(book4);
        productList.add(pen);
        productList.add(pen2);
        productList.add(copybook);
        productList.add(copybook2);



        System.out.println("Усі продукти:");
        productList.forEach(System.out::println);

        System.out.println();
        System.out.println("Вибірка продуктів певної катигорії з ціною більшою за вказане значення:");
        System.out.println(ProductUtils.moreThenPrice(productList, "book", 250));

        System.out.println();
        System.out.println("Вибірка продуктів певної категорії із застосуванням знижки:");
        System.out.println(ProductUtils.withDiscount(productList, "book"));

        System.out.println();
        System.out.println("Найдешевший продукт певної категорії враховуючи знижку:");
        System.out.println(ProductUtils.chipperProduct(productList, "book"));

        System.out.println();
        System.out.println("Три останні додаті товари за датою:");
        System.out.println(ProductUtils.threeLastAdded(productList));

        System.out.println();
        System.out.println("Сума продуктів певної категорії ціна яких не перевищує вказане значення:");
        System.out.println(ProductUtils.sumOfProductPrices(productList, "book", 75));

        System.out.println();
        System.out.println("Словник згрупованих за типом продуктів");
        System.out.println(ProductUtils.collectByType(productList));
    }
}
