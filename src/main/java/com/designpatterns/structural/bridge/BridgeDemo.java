package com.designpatterns.structural.bridge;

/**
 * Bridge Pattern - Separates abstraction from implementation. Bridge is a structural design pattern that
 * lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction
 * and implementation—which can be developed independently of each other.
 * Simple example: Different shapes that can be drawn with different renderers. or TV (Implementation) and a remote (abstraction).
 * That composition (Remote has-a TV) is the Bridge
 */
public class BridgeDemo {
    
    // Implementation interface
    interface Renderer {
        void renderCircle(int radius);
    }
    
    // Concrete implementations
    static class VectorRenderer implements Renderer {
        public void renderCircle(int radius) {
            System.out.println("Vector circle with radius " + radius);
        }
    }
    
    static class RasterRenderer implements Renderer {
        public void renderCircle(int radius) {
            System.out.println("Raster circle with radius " + radius);
        }
    }
    
    // Abstraction
    abstract static class Shape {
        protected Renderer renderer;
        
        public Shape(Renderer renderer) {
            this.renderer = renderer;
        }
        
        public abstract void draw();
    }
    
    // Refined abstraction
    static class Circle extends Shape {
        private int radius;
        
        public Circle(Renderer renderer, int radius) {
            super(renderer);
            this.radius = radius;
        }
        
        @Override
        public void draw() {
            renderer.renderCircle(radius);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Bridge Pattern ---");
        
        Shape vectorCircle = new Circle(new VectorRenderer(), 5);
        Shape rasterCircle = new Circle(new RasterRenderer(), 10);
        
        vectorCircle.draw();
        rasterCircle.draw();
    }
}