package com.designpatterns.behavioral.chainofresponsibility;

/**
 * Chain of Responsibility Pattern - Passes request along chain of handlers.
 * Simple example: Support ticket handling system.
 */
public class ChainOfResponsibilityDemo {
    
    // Handler interface
    abstract static class SupportHandler {
        protected SupportHandler nextHandler;
        
        public void setNext(SupportHandler handler) {
            this.nextHandler = handler;
        }
        
        public abstract void handleRequest(String issue, int priority);
    }
    
    // Concrete handlers
    static class Level1Support extends SupportHandler {
        public void handleRequest(String issue, int priority) {
            if (priority <= 1) {
                System.out.println("Level 1 Support handled: " + issue);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(issue, priority);
            }
        }
    }
    
    static class Level2Support extends SupportHandler {
        public void handleRequest(String issue, int priority) {
            if (priority <= 2) {
                System.out.println("Level 2 Support handled: " + issue);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(issue, priority);
            }
        }
    }
    
    static class Level3Support extends SupportHandler {
        public void handleRequest(String issue, int priority) {
            System.out.println("Level 3 Support handled: " + issue);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Chain of Responsibility Pattern ---");
        
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();
        
        level1.setNext(level2);
        level2.setNext(level3);
        
        level1.handleRequest("Password reset", 1);
        level1.handleRequest("Software bug", 2);
        level1.handleRequest("System crash", 3);
    }
}