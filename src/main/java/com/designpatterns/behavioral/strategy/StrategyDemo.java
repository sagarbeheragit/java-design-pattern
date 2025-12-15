package com.designpatterns.behavioral.strategy;

/**
 * Strategy Pattern - Encapsulates algorithms and makes them interchangeable.
 * Allows algorithm selection at runtime without changing client code.
 */
public class StrategyDemo {
    
    // Strategy interface - defines common interface for all algorithms
    interface PaymentStrategy {
        void pay(double amount);
        // Could add validation, fee calculation, etc.
    }
    
    // Concrete Strategy 1 - implements specific algorithm
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        
        public CreditCardPayment(String cardNumber) { this.cardNumber = cardNumber; }
        
        @Override
        public void pay(double amount) {
            // Credit card specific payment logic
            System.out.println("Processing credit card payment...");
            System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
        }
    }
    
    // Concrete Strategy 2 - different algorithm, same interface
    static class PayPalPayment implements PaymentStrategy {
        private String email;
        
        public PayPalPayment(String email) { this.email = email; }
        
        @Override
        public void pay(double amount) {
            // PayPal specific payment logic
            System.out.println("Redirecting to PayPal...");
            System.out.println("Paid $" + amount + " using PayPal: " + email);
        }
    }
    
    // Context - uses strategy without knowing concrete implementation
    static class ShoppingCart {
        private PaymentStrategy paymentStrategy;
        
        // Strategy can be changed at runtime
        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.paymentStrategy = strategy;
            System.out.println("Payment method updated");
        }
        
        // Context delegates algorithm execution to strategy
        public void checkout(double amount) {
            if (paymentStrategy != null) {
                System.out.println("Processing checkout for $" + amount);
                paymentStrategy.pay(amount); // Delegates to concrete strategy
            } else {
                System.out.println("No payment method selected");
            }
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Strategy Pattern ---");
        
        ShoppingCart cart = new ShoppingCart();
        
        // Strategy can be selected at runtime
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100.0);
        
        System.out.println();
        
        // Change strategy without changing context
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(50.0);
        
        System.out.println();
        
        // Key benefit: Easy to add new payment methods without modifying existing code
        // Could add: BitcoinPayment, ApplePayPayment, etc.
        System.out.println("Strategy pattern enables runtime algorithm selection");
    }
}