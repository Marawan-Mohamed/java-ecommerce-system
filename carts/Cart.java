package carts;

import products.ExpirableProduct;
import products.Product;
import products.ShippableProduct;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();


    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clearCart(){
        items.clear();
    }

    public void add(Product product, int quantity){

        if(quantity > product.getQuantity()){
            throw new IllegalArgumentException("Not enough product in stock");
        }

        if (product instanceof ExpirableProduct) {
            ExpirableProduct expirableProduct = (ExpirableProduct) product;
            if (expirableProduct.isExpired()) {
                throw new IllegalArgumentException("Cannot add expired product to cart");
            }
        }

        for (CartItem item : this.items) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isAllInStock(){
        for (CartItem item: items){
            if (!item.isInStock()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllNotExpired (){
        ExpirableProduct expirableProduct;
        for (CartItem item: this.items){
            if (!(item.getProduct() instanceof ExpirableProduct)) {
                continue; // Skip non-expirable products
                
            }

            expirableProduct = (ExpirableProduct) item.getProduct();

            if (expirableProduct.isExpired()){
                return false;
            }
        }
        return true;
    }

        public List<CartItem> getShippableItems() {
        List<CartItem> shippableItems = new ArrayList<>();
        for (CartItem item: this.items){
            if (item.getProduct() instanceof ShippableProduct ){
                shippableItems.add(item);
            }
        }
        return shippableItems;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : this.items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
