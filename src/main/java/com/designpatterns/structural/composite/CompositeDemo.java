package com.designpatterns.structural.composite;

import java.util.*;

/**
 * Composite Pattern - Composes objects into tree structures.
 * Simple example: File system with files and folders.
 */
public class CompositeDemo {
    
    // Component interface
    interface FileSystemItem {
        void display(String indent);
    }
    
    // Leaf
    static class File implements FileSystemItem {
        private String name;
        
        public File(String name) { this.name = name; }
        
        @Override
        public void display(String indent) {
            System.out.println(indent + "File: " + name);
        }
    }
    
    // Composite
    static class Folder implements FileSystemItem {
        private String name;
        private List<FileSystemItem> items = new ArrayList<>();
        
        public Folder(String name) { this.name = name; }
        
        public void add(FileSystemItem item) { items.add(item); }
        
        @Override
        public void display(String indent) {
            System.out.println(indent + "Folder: " + name);
            for (FileSystemItem item : items) {
                item.display(indent + "  ");
            }
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Composite Pattern ---");
        
        Folder root = new Folder("root");
        root.add(new File("file1.txt"));
        
        Folder subFolder = new Folder("documents");
        subFolder.add(new File("doc1.pdf"));
        subFolder.add(new File("doc2.pdf"));
        
        root.add(subFolder);
        root.display("");
    }
}