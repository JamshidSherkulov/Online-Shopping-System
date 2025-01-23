public class User {
    private String name;
    private Cart cart;

    public User(String name) {
        this.name = name;
        cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }
}
