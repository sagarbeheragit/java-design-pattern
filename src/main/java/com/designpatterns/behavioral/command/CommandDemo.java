package com.designpatterns.behavioral.command;

/**
 * Command Pattern - Encapsulates requests as objects.
 * Decouples sender from receiver, enables undo/redo, queuing, logging.
 */
public class CommandDemo {
    
    // Receiver - knows how to perform operations
    static class Light {
        private boolean isOn = false;
        
        public void turnOn() { 
            isOn = true;
            System.out.println("Light is ON"); 
        }
        
        public void turnOff() { 
            isOn = false;
            System.out.println("Light is OFF"); 
        }
        
        public boolean isOn() { return isOn; }
    }
    
    // Command interface - declares execution method
    interface Command {
        void execute();   // Perform the action
        void undo();      // Reverse the action (optional)
    }
    
    // Concrete Command 1 - encapsulates turn on request
    static class TurnOnCommand implements Command {
        private Light light; // Reference to receiver
        
        public TurnOnCommand(Light light) { this.light = light; }
        
        // Execute: delegate to receiver
        public void execute() { light.turnOn(); }
        
        // Undo: reverse the operation
        public void undo() { light.turnOff(); }
    }
    
    // Concrete Command 2 - encapsulates turn off request
    static class TurnOffCommand implements Command {
        private Light light; // Reference to receiver
        
        public TurnOffCommand(Light light) { this.light = light; }
        
        // Execute: delegate to receiver
        public void execute() { light.turnOff(); }
        
        // Undo: reverse the operation
        public void undo() { light.turnOn(); }
    }
    
    // Invoker - asks command to carry out request
    static class RemoteControl {
        private Command command;
        private Command lastCommand; // For undo functionality
        
        // Set command to execute
        public void setCommand(Command command) { 
            this.command = command; 
        }
        
        // Execute current command
        public void pressButton() {
            if (command != null) {
                command.execute();
                lastCommand = command; // Remember for undo
            }
        }
        
        // Undo last command
        public void pressUndo() {
            if (lastCommand != null) {
                System.out.print("Undoing: ");
                lastCommand.undo();
            }
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Command Pattern ---");
        
        // Create receiver and invoker
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        
        // Create commands
        Command turnOn = new TurnOnCommand(light);
        Command turnOff = new TurnOffCommand(light);
        
        // Execute commands through invoker
        System.out.println("Turning light on:");
        remote.setCommand(turnOn);
        remote.pressButton();
        
        System.out.println("\nTurning light off:");
        remote.setCommand(turnOff);
        remote.pressButton();
        
        System.out.println("\nUsing undo functionality:");
        remote.pressUndo(); // Should turn light back on
        
        System.out.println("\nKey benefits:");
        System.out.println("- Decouples invoker from receiver");
        System.out.println("- Supports undo/redo operations");
        System.out.println("- Commands can be stored, queued, logged");
    }
}