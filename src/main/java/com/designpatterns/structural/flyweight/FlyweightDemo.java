package com.designpatterns.structural.flyweight;

import java.util.*;

/**
 * Flyweight Pattern - Minimizes memory usage by sharing common data.
 * Simple example: Text editor with character formatting.
 */
public class FlyweightDemo {
    
    // Flyweight interface
    interface CharacterFlyweight {
        void display(int fontSize, String color);
    }
    
    // Concrete flyweight
    static class Character implements CharacterFlyweight {
        private char symbol; // Intrinsic state
        
        public Character(char symbol) { this.symbol = symbol; }
        
        @Override
        public void display(int fontSize, String color) {
            System.out.println("Character: " + symbol + ", Size: " + fontSize + ", Color: " + color);
        }
    }
    
    // Flyweight factory
    static class CharacterFactory {
        private static Map<java.lang.Character, CharacterFlyweight> characters = new HashMap<>();
        
        public static CharacterFlyweight getCharacter(char symbol) {
            CharacterFlyweight character = characters.get(symbol);
            if (character == null) {
                character = new Character(symbol);
                characters.put(symbol, character);
                System.out.println("Created new flyweight for: " + symbol);
            }
            return character;
        }
        
        public static int getCreatedFlyweights() {
            return characters.size();
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Flyweight Pattern ---");
        
        String text = "HELLO";
        
        for (char c : text.toCharArray()) {
            CharacterFlyweight character = CharacterFactory.getCharacter(c);
            character.display(12, "Black");
        }
        
        System.out.println("Total flyweights created: " + CharacterFactory.getCreatedFlyweights());
    }
}