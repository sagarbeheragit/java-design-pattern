package com.designpatterns.structural.facade;

/**
 * Facade Pattern - Provides simplified interface to complex subsystem.
 * Simple example: Home theater system with multiple components.
 */
public class FacadeDemo {
    
    // Complex subsystem classes
    static class TV {
        public void on() { System.out.println("TV is on"); }
        public void off() { System.out.println("TV is off"); }
    }
    
    static class SoundSystem {
        public void on() { System.out.println("Sound system is on"); }
        public void off() { System.out.println("Sound system is off"); }
        public void setVolume(int volume) { System.out.println("Volume set to " + volume); }
    }
    
    static class DVDPlayer {
        public void on() { System.out.println("DVD player is on"); }
        public void off() { System.out.println("DVD player is off"); }
        public void play() { System.out.println("Playing DVD"); }
    }
    
    // Facade
    static class HomeTheaterFacade {
        private TV tv;
        private SoundSystem soundSystem;
        private DVDPlayer dvdPlayer;
        
        public HomeTheaterFacade() {
            this.tv = new TV();
            this.soundSystem = new SoundSystem();
            this.dvdPlayer = new DVDPlayer();
        }
        
        public void watchMovie() {
            System.out.println("Getting ready to watch movie...");
            tv.on();
            soundSystem.on();
            soundSystem.setVolume(10);
            dvdPlayer.on();
            dvdPlayer.play();
        }
        
        public void endMovie() {
            System.out.println("Shutting down...");
            dvdPlayer.off();
            soundSystem.off();
            tv.off();
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Facade Pattern ---");
        
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie();
        System.out.println();
        homeTheater.endMovie();
    }
}