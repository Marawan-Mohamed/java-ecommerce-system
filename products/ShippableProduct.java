package products;

public class ShippableProduct extends Product implements Shippable {
    private double weight; // Weight of the product in grams

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.setWeight(weight);
    }

    public void setWeight(double weight){
        if(weight < 0){
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.weight = weight;

    }

    @Override
    public double getWeight() {
        return weight;
    }
}
