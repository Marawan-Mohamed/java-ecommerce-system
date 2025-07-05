package customers;

public class Customer {
    private String name;
    private String address;
    private double balance;

    public Customer(String name, String address, double balance) {
        this.name = name;
        this.address = address;
        this.increaseBalance(balance);
    }

    String getName(){return this.name;}
    public String getAddress() {return address;}
    public double getBalance() {return balance;}

    public void reduceBalance(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Reduce amount cannot be negative.");
        }
        this.balance -= amount;
    }

    public void increaseBalance(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Increase amount cannot be negative.");
        }
        this.balance += amount;
    }
}
