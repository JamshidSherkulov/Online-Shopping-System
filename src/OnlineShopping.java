import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product product1 = new Product("Laptop", 1000, 5);
        Product product2 = new Product("Smartphone", 500, 10);
        Product product3 = new Product("Headphone", 70, 15);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        User user1 = new User("Jamshid");

        System.out.println("Welcome to the shopping cart system, " + user1.getName() + "!");

        while (true) {
            System.out.println("\n1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable products: ");
                    for (int i  = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    break;
                case 2:
                    System.out.println("\nEnter product number to add to cart");
                    int productChoice = sc.nextInt();
                    if (productChoice > 0 && productChoice <= products.size()) {
                        user1.getCart().addProduct(products.get(productChoice - 1));
                        System.out.println("Product addded to cart!");
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println("\nEnter product name to remove from cart");
                    sc.nextLine();
                    String productName = sc.nextLine();
                    boolean found = false;
                    for (Product product : products) {
                        if (product.getName().equalsIgnoreCase(productName)) {
                            user1.getCart().removeProduct(product);
                            found = true;
                            System.out.println("Product removed from cart");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found in cart");
                    }
                    break;
                case 4:
                    user1.getCart().displayCart();
                    break;
                case 5:
                    System.out.println("Thank you shopping with us");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again");
            }
        }
    }
}