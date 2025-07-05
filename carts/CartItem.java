package carts;

import products.Product;
import exceptions.InsufficientStockException;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.increaseQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to reduce cannot be negative.");
        }
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Quantity to reduce cannot be less than available in the cart.");
        }
        this.quantity -= quantity;
    }

    public void increaseQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to increase cannot be negative.");
        }
        if(product.getQuantity() < this.quantity + quantity){
            throw new IllegalArgumentException("Total quantity exceeds stock.");
        }
        this.quantity += quantity;
    }

    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }

    public boolean isInStock() {
        return product.getQuantity() >= quantity;
    }
}

