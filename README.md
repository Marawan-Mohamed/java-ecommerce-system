# 🛒 Java E-Commerce System

A fully functional object-oriented e-commerce system built in Java, designed to meet the specifications of a coding challenge requiring:

- Support for expirable and shippable products
- Cart operations with stock and expiry validation
- Dynamic shipping calculations
- Checkout with detailed console receipts

---

## 📁 Project Structure

```
.
├── carts
│   ├── CartItem.java                // Represents item added to cart
│   └── Cart.java                    // Manages a customer's cart
├── customers
│   └── Customer.java                // Holds customer details and balance
├── exceptions
│   └── InsufficientStockException.java // Custom exception for invalid cart actions
├── products
│   ├── ExpirableProduct.java       // Product with expiry and weight
│   ├── NonShippableProduct.java    // Product that doesn’t require shipping
│   ├── Product.java                // Abstract base class
│   ├── Shippable.java              // Interface: getName(), getWeight()
│   └── ShippableProduct.java       // Shippable product that’s not expirable
├── services
│   ├── Checkout.java               // Handles validation and prints receipts
│   └── Shipping.java               // Calculates and prints shipment details
└── Main.java                       // Test use-case and demo runner
```

---

## ✅ Challenge Requirements

> **System Design Specification:**

- Products must define:
  - Name, price, quantity
- Products **may expire** (e.g., Cheese, Biscuits) or **may not** (e.g., TV, Mobile)
- Products **may require shipping** (e.g., Cheese, TV) or **not** (e.g., scratch cards)
- Shippable items must expose:
  - `String getName()`
  - `double getWeight()`
- Carts allow:
  - Adding a quantity up to available stock
- Checkout must:
  - Print:
    - Subtotal
    - Shipping fee
    - Total paid
    - Customer balance after payment
  - Validate:
    - Cart is not empty
    - Items are in stock
    - Items are not expired
    - Customer has sufficient funds
  - Ship applicable items through a `ShippingService`

---

## 🚀 How It Works

### 🔧 Sample Test Code

```java
public static void main(String[] args) {
    Customer customer = new Customer("Marwan Mohamed", "Giza", 150000000.00);
    Cart cart = new Cart();

    LocalDate cheeseExpiryDate = LocalDate.of(2026, 6, 1);
    ExpirableProduct cheese = new ExpirableProduct("Cheese", 100, 9, 0.5, cheeseExpiryDate);

    LocalDate biscuitExpiryDate = LocalDate.of(2026, 3, 1);
    ExpirableProduct biscuit = new ExpirableProduct("Biscuits", 150, 12, 0.5, biscuitExpiryDate);

    ShippableProduct tv = new ShippableProduct("tv", 2500, 5, 0.15);
    NonShippableProduct scratchCard = new NonShippableProduct("ScratchCard", 100, 20);

    cart.add(cheese, 2);
    cart.add(tv, 1);
    cart.add(scratchCard, 1);

    Checkout.checkout(customer, cart);
}
```

### 🖨️ Sample Output

```
** Shipment notice **
2x Cheese        1000g
1x tv            150g
Total package weight 1.2kg

** Checkout receipt **
2x Cheese        200.0
1x tv            2500.0
1x ScratchCard   100.0
----------------------
Subtotal         2800.0
Shipping         36.0
Amount           2836.0
Remaining Balance 149997164.0
```

---

## 📦 Features

- ✅ Expirable product enforcement
- ✅ Shippable product interface
- ✅ Shipping fee calculated by weight (`30.0 EGP/kg`)
- ✅ Cart validation: quantity, expiry, availability
- ✅ Clean OOP design using interfaces and inheritance
- ✅ Custom exception handling (`InsufficientStockException`)
- ✅ Receipt printing and shipment notice formatting

---

## 📜 Assumptions

- Expirable products must not be past their expiry date at checkout.
- Products are treated as homogeneous; no serial/batch tracking.
- Shipping cost: `30 EGP` per kilogram.
- Each product's weight is multiplied by its quantity for shipping.
- If an error occurs during checkout, no product quantities are deducted.

---

## 🔍 Example Challenge Reference

> Example:

```java
cart.add(cheese, 2);
cart.add(tv, 3);
cart.add(scratchCard, 1);
checkout(customer, cart);
```

> Output:

```
** Shipment notice **
 2x Cheese       1000.0 g
 1x tv           150.0  g
Total package weight is 1.15Kg

** Checkout receipt **
 2x Cheese       200.00
 1x tv           2500.00
 1x ScratchCard  100.00
----------------------
Subtotal 		2800.00
shipping 		34.50
Amount   		2834.50
```

---

## 🧪 Run and Test

Compile and run with:

```bash
javac Main.java
java Main
```

Or use any Java IDE (like IntelliJ, Eclipse) with this directory layout.

---

## 📌 License

This project is submitted as part of a coding challenge. For educational or demonstration use only.
