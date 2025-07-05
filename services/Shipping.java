package services;

import carts.CartItem;
import products.Shippable;

import java.util.List;

public class Shipping {
    public static final Double PER_KG_SHIPPING_COST = 30.0;

    public static double ship(List<CartItem> shippableItems){
        System.out.println("** Shipment notice **");
        Shippable shippable;
        double totalWeight = 0;
        for (CartItem item: shippableItems){
            shippable = (Shippable) item.getProduct();
            totalWeight += shippable.getWeight() * item.getQuantity();
            System.out.printf("%2dx %-12s %-6.1f g\n", item.getQuantity(), shippable.getName(), item.getQuantity()*shippable.getWeight()*1000);
        }
        System.out.println("Total package weight is " + totalWeight + "Kg\n");
        return totalWeight;
    }
}
