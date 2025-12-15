package com.designpatterns.creational.builder;

/**
 * Builder Pattern - Constructs complex objects step by step.
 * Simple example: Building a House with optional components.
 */
public class BuilderDemo {
    
    // Product
    static class House {
        private String foundation;
        private String walls;
        private String roof;
        private boolean hasGarage;
        
        public void setFoundation(String foundation) { this.foundation = foundation; }
        public void setWalls(String walls) { this.walls = walls; }
        public void setRoof(String roof) { this.roof = roof; }
        public void setHasGarage(boolean hasGarage) { this.hasGarage = hasGarage; }
        
        @Override
        public String toString() {
            return "House: " + foundation + ", " + walls + ", " + roof + 
                   (hasGarage ? ", with garage" : "");
        }
    }
    
    // Builder
    static class HouseBuilder {
        private House house = new House();
        
        public HouseBuilder foundation(String foundation) {
            house.setFoundation(foundation);
            return this;
        }
        
        public HouseBuilder walls(String walls) {
            house.setWalls(walls);
            return this;
        }
        
        public HouseBuilder roof(String roof) {
            house.setRoof(roof);
            return this;
        }
        
        public HouseBuilder garage() {
            house.setHasGarage(true);
            return this;
        }
        
        public House build() { return house; }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Builder Pattern ---");
        
        House house = new HouseBuilder()
            .foundation("Concrete")
            .walls("Brick")
            .roof("Tile")
            .garage()
            .build();
            
        System.out.println(house);
    }
}