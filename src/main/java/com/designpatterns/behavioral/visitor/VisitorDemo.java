package com.designpatterns.behavioral.visitor;

/**
 * Visitor Pattern - Adds new operations to objects without modifying them.
 * Simple example: Different operations on geometric shapes.
 */
public class VisitorDemo {
    
    // Visitor interface
    interface ShapeVisitor {
        void visit(Circle circle);
        void visit(Rectangle rectangle);
    }
    
    // Element interface
    interface Shape {
        void accept(ShapeVisitor visitor);
    }
    
    // Concrete elements
    static class Circle implements Shape {
        private double radius;
        
        public Circle(double radius) { this.radius = radius; }
        
        public double getRadius() { return radius; }
        
        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visit(this);
        }
    }
    
    static class Rectangle implements Shape {
        private double width, height;
        
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        
        public double getWidth() { return width; }
        public double getHeight() { return height; }
        
        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visit(this);
        }
    }
    
    // Concrete visitors
    static class AreaCalculator implements ShapeVisitor {
        @Override
        public void visit(Circle circle) {
            double area = Math.PI * circle.getRadius() * circle.getRadius();
            System.out.println("Circle area: " + area);
        }
        
        @Override
        public void visit(Rectangle rectangle) {
            double area = rectangle.getWidth() * rectangle.getHeight();
            System.out.println("Rectangle area: " + area);
        }
    }
    
    static class PerimeterCalculator implements ShapeVisitor {
        @Override
        public void visit(Circle circle) {
            double perimeter = 2 * Math.PI * circle.getRadius();
            System.out.println("Circle perimeter: " + perimeter);
        }
        
        @Override
        public void visit(Rectangle rectangle) {
            double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
            System.out.println("Rectangle perimeter: " + perimeter);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Visitor Pattern ---");
        
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6)
        };
        
        AreaCalculator areaCalc = new AreaCalculator();
        PerimeterCalculator perimeterCalc = new PerimeterCalculator();
        
        for (Shape shape : shapes) {
            shape.accept(areaCalc);
            shape.accept(perimeterCalc);
            System.out.println();
        }
    }
}