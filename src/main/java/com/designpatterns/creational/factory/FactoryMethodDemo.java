package com.designpatterns.creational.factory;

/**
 * Factory Method Pattern - Creates objects without specifying exact classes.
 * Delegates object creation to subclasses, promoting loose coupling.
 */
public class FactoryMethodDemo {
    
    // Product interface - defines contract for all products
    interface Document {
        void open();
    }
    
    // Concrete products - specific implementations of the product interface
    static class WordDocument implements Document {
        public void open() { System.out.println("Opening Word document"); }
    }
    
    static class PDFDocument implements Document {
        public void open() { System.out.println("Opening PDF document"); }
    }
    
    // Abstract Creator - declares factory method that subclasses must implement
    abstract static class DocumentFactory {
        // Factory method - subclasses decide which concrete product to create
        public abstract Document createDocument();
        
        // Template method - uses factory method but doesn't know concrete type
        public void openDocument() {
            Document doc = createDocument(); // Delegates to subclass
            doc.open(); // Works with abstract interface
        }
    }
    
    // Concrete Creators - implement factory method to create specific products
    static class WordFactory extends DocumentFactory {
        // Returns specific product type
        public Document createDocument() { return new WordDocument(); }
    }
    
    static class PDFFactory extends DocumentFactory {
        // Returns different product type using same interface
        public Document createDocument() { return new PDFDocument(); }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Factory Method Pattern ---");
        
        // Client code works with abstract factory, not concrete classes
        DocumentFactory wordFactory = new WordFactory();
        wordFactory.openDocument(); // Creates WordDocument internally
        
        DocumentFactory pdfFactory = new PDFFactory();
        pdfFactory.openDocument(); // Creates PDFDocument internally
        
        // Key benefit: Easy to add new document types without changing client code
        System.out.println("Factory method promotes extensibility and loose coupling");
    }
}