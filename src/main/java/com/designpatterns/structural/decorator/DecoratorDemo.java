package com.designpatterns.structural.decorator;

/**
 * Decorator Pattern - Adds behavior to objects dynamically without altering structure.
 * Provides flexible alternative to subclassing for extending functionality.
 */
public class DecoratorDemo {
    
    // Component interface - defines operations that can be decorated
    interface Coffee {
        String getDescription();
        double getCost();
    }
    
    // Concrete Component - base object that can be decorated
    static class SimpleCoffee implements Coffee {
        public String getDescription() { return "Simple coffee"; }
        public double getCost() { return 2.0; }
    }
    
    // Base Decorator - maintains reference to component and delegates calls
    abstract static class CoffeeDecorator implements Coffee {
        protected Coffee coffee; // Reference to decorated object
        
        public CoffeeDecorator(Coffee coffee) { 
            this.coffee = coffee; 
        }
        
        // Default behavior: delegate to wrapped component
        public String getDescription() { return coffee.getDescription(); }
        public double getCost() { return coffee.getCost(); }
    }
    
    // Concrete Decorator 1 - adds milk functionality
    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) { super(coffee); }
        
        // Extends behavior: adds milk to description
        public String getDescription() { 
            return coffee.getDescription() + ", milk"; 
        }
        
        // Extends behavior: adds milk cost
        public double getCost() { 
            return coffee.getCost() + 0.5; 
        }
    }
    
    // Concrete Decorator 2 - adds sugar functionality
    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) { super(coffee); }
        
        // Extends behavior: adds sugar to description
        public String getDescription() { 
            return coffee.getDescription() + ", sugar"; 
        }
        
        // Extends behavior: adds sugar cost
        public double getCost() { 
            return coffee.getCost() + 0.2; 
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Decorator Pattern ---");
        
        // Start with base component
        Coffee coffee = new SimpleCoffee();
        System.out.println("1. " + coffee.getDescription() + " - $" + coffee.getCost());
        
        // Wrap with first decorator - adds milk
        coffee = new MilkDecorator(coffee);
        System.out.println("2. " + coffee.getDescription() + " - $" + coffee.getCost());
        
        // Wrap with second decorator - adds sugar
        coffee = new SugarDecorator(coffee);
        System.out.println("3. " + coffee.getDescription() + " - $" + coffee.getCost());
        
        // Can add multiple decorators of same type
        coffee = new MilkDecorator(coffee); // Extra milk
        System.out.println("4. " + coffee.getDescription() + " - $" + coffee.getCost());
        
        System.out.println();
        System.out.println("Key benefits:");
        System.out.println("- Add responsibilities dynamically");
        System.out.println("- More flexible than inheritance");
        System.out.println("- Can combine decorators in any order");
    }
}