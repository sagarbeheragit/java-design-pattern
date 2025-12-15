package com.designpatterns.creational.prototype;

/**
 * Prototype Pattern - Creates objects by cloning existing instances.
 * Simple example: Cloning shapes with different properties.
 */
public class PrototypeDemo {
    
    // Prototype interface
    interface Shape extends Cloneable {
        Shape clone();
        void draw();
    }
    
    // Concrete prototype
    static class Circle implements Shape {
        private int radius;
        private String color;
        
        public Circle(int radius, String color) {
            this.radius = radius;
            this.color = color;
        }
        
        @Override
        public Shape clone() {
            return new Circle(this.radius, this.color);
        }
        
        @Override
        public void draw() {
            System.out.println("Circle: radius=" + radius + ", color=" + color);
        }
        
        public void setColor(String color) { this.color = color; }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Prototype Pattern ---");
        
        // Create original
        Circle original = new Circle(10, "Red");
        original.draw();
        
        // Clone and modify
        Circle clone = (Circle) original.clone();
        clone.setColor("Blue");
        clone.draw();
        
        System.out.println("Original and clone are different objects: " + (original != clone));
    }
}