package products;
import java.time.LocalDate;

public class ExpirableProduct extends ShippableProduct{
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate){
        super(name, price, quantity, weight);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate.toString();
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
