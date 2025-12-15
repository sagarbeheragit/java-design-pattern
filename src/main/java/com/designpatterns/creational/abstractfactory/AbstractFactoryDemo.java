package com.designpatterns.creational.abstractfactory;

/**
 * Abstract Factory Pattern - Creates families of related objects.
 * Simple example: Different UI themes (Windows/Mac) creating buttons and checkboxes.
 */
public class AbstractFactoryDemo {
    
    // Abstract products
    interface Button { void render(); }
    interface Checkbox { void render(); }
    
    // Concrete products for Windows
    static class WindowsButton implements Button {
        public void render() { System.out.println("Windows Button"); }
    }
    static class WindowsCheckbox implements Checkbox {
        public void render() { System.out.println("Windows Checkbox"); }
    }
    
    // Concrete products for Mac
    static class MacButton implements Button {
        public void render() { System.out.println("Mac Button"); }
    }
    static class MacCheckbox implements Checkbox {
        public void render() { System.out.println("Mac Checkbox"); }
    }
    
    // Abstract factory
    interface UIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }
    
    // Concrete factories
    static class WindowsFactory implements UIFactory {
        public Button createButton() { return new WindowsButton(); }
        public Checkbox createCheckbox() { return new WindowsCheckbox(); }
    }
    
    static class MacFactory implements UIFactory {
        public Button createButton() { return new MacButton(); }
        public Checkbox createCheckbox() { return new MacCheckbox(); }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Abstract Factory Pattern ---");
        
        UIFactory factory = new WindowsFactory();
        factory.createButton().render();
        factory.createCheckbox().render();
        
        factory = new MacFactory();
        factory.createButton().render();
        factory.createCheckbox().render();
    }
}