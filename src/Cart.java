import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private double totalCost;

    public Cart() {
        this.products = new ArrayList<>();
        this.totalCost = 0;
    }

    public void addProduct(Product product) {
        if (product.getStock() > 0) {
            product.reduceStock();
            products.add(product);
            calculateTotal();
        } else {
            System.out.println("Product out of stock");
        }
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            product.increaseStock();
            calculateTotal();
        } else {
            System.out.println("Product not found in cart");
        }
    }

    public void calculateTotal() {
        totalCost = 0;
        for (Product product : products) {
            totalCost += product.getPrice();
        }
    }

    public void displayCart() {
        System.out.println("Cart contents: ");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total cost: $" + totalCost);
    }
}
