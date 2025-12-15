package com.designpatterns.behavioral.templatemethod;

/**
 * Template Method Pattern - Defines skeleton of algorithm, subclasses fill in details.
 * Simple example: Different beverages with common preparation steps.
 */
public class TemplateMethodDemo {
    
    // Abstract class with template method
    abstract static class Beverage {
        
        // Template method - defines the algorithm skeleton
        public final void prepareBeverage() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }
        
        // Common steps
        private void boilWater() {
            System.out.println("Boiling water");
        }
        
        private void pourInCup() {
            System.out.println("Pouring into cup");
        }
        
        // Abstract steps - subclasses must implement
        protected abstract void brew();
        protected abstract void addCondiments();
    }
    
    // Concrete classes
    static class Tea extends Beverage {
        @Override
        protected void brew() {
            System.out.println("Steeping tea");
        }
        
        @Override
        protected void addCondiments() {
            System.out.println("Adding lemon");
        }
    }
    
    static class Coffee extends Beverage {
        @Override
        protected void brew() {
            System.out.println("Brewing coffee");
        }
        
        @Override
        protected void addCondiments() {
            System.out.println("Adding milk and sugar");
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Template Method Pattern ---");
        
        System.out.println("Making Tea:");
        Beverage tea = new Tea();
        tea.prepareBeverage();
        
        System.out.println("\nMaking Coffee:");
        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
    }
}