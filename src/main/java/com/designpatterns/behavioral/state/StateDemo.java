package com.designpatterns.behavioral.state;

/**
 * State Pattern - Changes object behavior based on internal state.
 * Simple example: Traffic light with different states.
 */
public class StateDemo {
    
    // State interface
    interface TrafficLightState {
        void handle(TrafficLight context);
    }
    
    // Concrete states
    static class RedState implements TrafficLightState {
        @Override
        public void handle(TrafficLight context) {
            System.out.println("Red Light - STOP");
            context.setState(new GreenState());
        }
    }
    
    static class GreenState implements TrafficLightState {
        @Override
        public void handle(TrafficLight context) {
            System.out.println("Green Light - GO");
            context.setState(new YellowState());
        }
    }
    
    static class YellowState implements TrafficLightState {
        @Override
        public void handle(TrafficLight context) {
            System.out.println("Yellow Light - CAUTION");
            context.setState(new RedState());
        }
    }
    
    // Context
    static class TrafficLight {
        private TrafficLightState state;
        
        public TrafficLight() {
            state = new RedState();
        }
        
        public void setState(TrafficLightState state) {
            this.state = state;
        }
        
        public void change() {
            state.handle(this);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- State Pattern ---");
        
        TrafficLight light = new TrafficLight();
        
        light.change(); // Red -> Green
        light.change(); // Green -> Yellow
        light.change(); // Yellow -> Red
        light.change(); // Red -> Green
    }
}