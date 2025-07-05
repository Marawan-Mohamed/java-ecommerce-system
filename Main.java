import carts.Cart;
import customers.Customer;
import products.ExpirableProduct;
import products.NonShippableProduct;
import products.ShippableProduct;
import services.Checkout;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Marwan Mohamed", "Giza", 150000000.00);
        Cart cart = new Cart();

        LocalDate cheeseExpiryDate = LocalDate.of(2026, 6, 1);
        ExpirableProduct cheese = new ExpirableProduct("Cheese", 100,9,0.5, cheeseExpiryDate );

        LocalDate biscuitExpiryDate = LocalDate.of(2026, 3, 1);
        ExpirableProduct biscuit = new ExpirableProduct("Biscuits", 150,12,0.5, biscuitExpiryDate );

        ShippableProduct tv = new ShippableProduct("tv", 2500, 5, 0.15);
        NonShippableProduct scratchCard = new NonShippableProduct("ScratchCard", 100, 20);


        cart.add(cheese, 2);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);
        Checkout.checkout(customer,cart);
    }
}
