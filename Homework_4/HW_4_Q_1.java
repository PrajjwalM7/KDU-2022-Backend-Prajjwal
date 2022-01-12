import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class Product {
    private double price;
    private String name;
    private String category;

    Product(double price, String name, String category) {
        this.price = price;
        this.name = name;
        this.category = category;
    }
    public String getCategory() {
        return this.category;
    }
    public double getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name=" + name  +
                ", category=" + category +
                '}';
    }
}
public class HW_4_Q_1 {

    public static void usingStreams(List<Product> products) {
        // Max
        Product maxPrice = products.stream().max((Product p1, Product p2) ->
                (int) (p1.getPrice() - p2.getPrice())).get();
        System.out.println("Product with Max price : " + maxPrice);

        // Min
        Product minPrice = products.stream().max((Product p1, Product p2) ->
                (int) (p2.getPrice() - p1.getPrice())).get();
        System.out.println("Product with Min price : " + minPrice);

        // anyMatch
        boolean is_anyProductBelow1000 = products.stream().anyMatch(p -> p.getPrice() < 1000);
        System.out.println("Products with price less than 1000 exist in the list : " + is_anyProductBelow1000);

        // allMatch
        boolean is_allProductBelow1000 = products.stream().allMatch(p -> p.getPrice() < 1000);
        System.out.println("All the products have a price less than 1000 : " + is_allProductBelow1000);

        // Filter
        List<Product> below1000 = products.stream().filter(p -> p.getPrice() < 1000).collect(toList());
        System.out.println("All products below the price of 1000 : ");
        for (Product p : below1000) {
            System.out.println(p);
        }

        // Sorted
        System.out.println("\n After Sorting by price : ");
        products.stream().sorted((Product p1, Product p2) -> (int) (p1.getPrice() - p2.getPrice())).forEach(System.out::println);

        // GroupingBy
        System.out.println("\nAfter grouping by category : ");
        Map<String, List<String>> categoryItems = products.stream().collect(Collectors.groupingBy(Product::getCategory , Collectors.mapping(Product::getName, toList())));
        for (Map.Entry<String, List<String>> entry: categoryItems.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Average Price
        double averagePrice = products.stream().collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\n Average price : " + averagePrice);

        // Sum after 25% increment
        double sumAfterIncrement = products.stream().reduce(0.0, (a, b) -> (a + (1.25)*b.getPrice()), (a, b) -> {
            return a + b;
        });
        System.out.println("Sum after 25% increment : " + sumAfterIncrement);
    }
    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(100, "Cup", "Home"));
        products.add(new Product(200, "Net", "Sports"));
        products.add(new Product(950, "Shirt", "Fashion"));
        products.add(new Product(330, "Ball", "Sports"));
        products.add(new Product(10000, "Phone Mi", "Electronics"));

        usingStreams(products);
    }
}
