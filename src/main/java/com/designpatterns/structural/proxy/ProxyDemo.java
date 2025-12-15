package com.designpatterns.structural.proxy;

/**
 * Proxy Pattern - Provides placeholder/surrogate for another object.
 * Simple example: Image loading with lazy initialization.
 */
public class ProxyDemo {
    
    // Subject interface
    interface Image {
        void display();
    }
    
    // Real subject
    static class RealImage implements Image {
        private String filename;
        
        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }
        
        private void loadFromDisk() {
            System.out.println("Loading image: " + filename);
        }
        
        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }
    
    // Proxy
    static class ImageProxy implements Image {
        private String filename;
        private RealImage realImage;
        
        public ImageProxy(String filename) {
            this.filename = filename;
        }
        
        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // Lazy loading
            }
            realImage.display();
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Proxy Pattern ---");
        
        Image image = new ImageProxy("photo.jpg");
        
        System.out.println("Image created (not loaded yet)");
        image.display(); // Now it loads
        image.display(); // Uses cached version
    }
}