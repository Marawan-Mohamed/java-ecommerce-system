package services;

import carts.Cart;
import carts.CartItem;
import customers.Customer;

public class Checkout {

    public static void checkout(Customer customer, Cart cart){
        if (cart.isEmpty()){
            throw new IllegalArgumentException("Cart Is Empty!");
        }

        if (!cart.isAllInStock()){
            throw new IllegalArgumentException("Some ordered items are less than stock");
        }

        if (!cart.isAllNotExpired()){
            throw new IllegalArgumentException("Some ordered items are Expired");
        }

        double subTotal = cart.getTotalPrice();

        //send shippable items to shipment service and get the total weight
        double totalWeight = Shipping.ship(cart.getShippableItems());

        //calculate shipping fees
        double shippingFees= Shipping.PER_KG_SHIPPING_COST * totalWeight;

        //calculate the grand total
        double grandTotal = subTotal + shippingFees;

        if (grandTotal > customer.getBalance()){
            throw new IllegalArgumentException("Customer balance is insufficient.");
        }

        // update customer balance
        customer.reduceBalance(grandTotal);

        //update products quantity in stock
        for (CartItem item : cart.getItems()){
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item: cart.getItems()){

            System.out.printf("%2dx %-12s %-6.2f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal \t\t %.2f\n", subTotal);
        System.out.printf("shipping \t\t %.2f\n", shippingFees);
        System.out.printf("Amount   \t\t %.2f\n", grandTotal);





    }


}

