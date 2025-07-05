package products;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.setPrice(price);
        this.increaseQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public boolean isAvailable(int requestedQuantity) {
        if (requestedQuantity < 0) {
            throw new IllegalArgumentException("Requested quantity cannot be negative.");
        }
        return quantity >= requestedQuantity;
    }

    public void reduceQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to reduce cannot be negative.");
        }
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        this.quantity -= quantity;
    }

    public void increaseQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to increase cannot be negative.");
        }
        this.quantity += quantity;
    }
}
