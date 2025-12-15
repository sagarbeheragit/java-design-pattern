package com.designpatterns.structural.adapter;

/**
 * Adapter Pattern - Allows incompatible interfaces to work together.
 * Simple example: Making old printer work with new computer interface.
 */
public class AdapterDemo {
    
    // Target interface (what client expects)
    interface ModernPrinter {
        void printDocument(String document);
    }
    
    // Adaptee (existing class with incompatible interface)
    static class OldPrinter {
        public void print(String text) {
            System.out.println("Old Printer: " + text);
        }
    }
    
    // Adapter (makes OldPrinter work with ModernPrinter interface)
    static class PrinterAdapter implements ModernPrinter {
        private OldPrinter oldPrinter;
        
        public PrinterAdapter(OldPrinter oldPrinter) {
            this.oldPrinter = oldPrinter;
        }
        
        @Override
        public void printDocument(String document) {
            // Adapt the interface
            oldPrinter.print(document);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Adapter Pattern ---");
        
        OldPrinter oldPrinter = new OldPrinter();
        ModernPrinter adapter = new PrinterAdapter(oldPrinter);
        
        adapter.printDocument("Hello World!");
    }
}