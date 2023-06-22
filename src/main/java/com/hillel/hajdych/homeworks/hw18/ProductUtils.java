package com.hillel.hajdych.homeworks.hw18;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductUtils {

    public static List<Product> moreThenPrice(List<Product> products, String type, float moreThen) {
        return products.stream()
                .filter(product -> product.getType().equalsIgnoreCase(type))
                .filter(product -> product.getPrice() > moreThen)
                .collect(Collectors.toList());
    }

    public static List<Product> withDiscount(List<Product> products, String type) {
        return products.stream()
                .filter(product -> product.getType().equalsIgnoreCase(type))
                .filter(Product::isDiscountability)
                .map(product -> new Product(product.getIdentifierNumber(), product.getType(),
                        product.getPrice() * 0.9F, product.isDiscountability()))
                .collect(Collectors.toList());
    }

    public static Product chipperProduct(List<Product> products, String type) {
        Optional<Product> minProduct = products.stream()
                .filter(product -> product.getType().equalsIgnoreCase(type))
                .filter(Product::isDiscountability)
                .min((p1, p2) -> (int) (p1.getPrice() - p2.getPrice()));

        Product product = null;
        try {
            product = minProduct.orElseThrow(Exception::new);
        } catch (Exception e) {
            System.out.println("Продукт [категорія: " + type + "] не знайдено");
        }
        return product;
    }

    public static List<Product> threeLastAdded(List<Product> products) {
        return products.stream()
                .sorted((p1, p2) -> p2.getCreateDate().compareTo(p1.getCreateDate()))
                .limit(3)
                .toList();
    }

    public static float sumOfProductPrices(List<Product> products, String type, float lessThan) {
        Optional<Float> sum = products.stream()
                .filter(product -> product.getCreateDate().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getType().equalsIgnoreCase(type))
                .map(Product::getPrice)
                .filter(price -> price <= lessThan)
                .reduce(Float::sum);

        return sum.orElse(0.0F);

    }

    public static Map<String, List<Product>> collectByType(List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

}

