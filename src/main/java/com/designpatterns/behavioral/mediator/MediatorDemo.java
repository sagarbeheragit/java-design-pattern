package com.designpatterns.behavioral.mediator;

/**
 * Mediator Pattern - Defines how objects interact with each other.
 * Simple example: Chat room where users communicate through mediator.
 */
public class MediatorDemo {
    
    // Mediator interface
    interface ChatMediator {
        void sendMessage(String message, User user);
        void addUser(User user);
    }
    
    // Concrete mediator
    static class ChatRoom implements ChatMediator {
        private java.util.List<User> users = new java.util.ArrayList<>();
        
        @Override
        public void addUser(User user) {
            users.add(user);
        }
        
        @Override
        public void sendMessage(String message, User sender) {
            for (User user : users) {
                if (user != sender) {
                    user.receive(message, sender.getName());
                }
            }
        }
    }
    
    // Colleague
    abstract static class User {
        protected ChatMediator mediator;
        protected String name;
        
        public User(ChatMediator mediator, String name) {
            this.mediator = mediator;
            this.name = name;
        }
        
        public abstract void send(String message);
        public abstract void receive(String message, String from);
        
        public String getName() { return name; }
    }
    
    // Concrete colleague
    static class ChatUser extends User {
        public ChatUser(ChatMediator mediator, String name) {
            super(mediator, name);
        }
        
        @Override
        public void send(String message) {
            System.out.println(name + " sends: " + message);
            mediator.sendMessage(message, this);
        }
        
        @Override
        public void receive(String message, String from) {
            System.out.println(name + " received from " + from + ": " + message);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Mediator Pattern ---");
        
        ChatMediator chatRoom = new ChatRoom();
        
        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        
        user1.send("Hello Bob!");
        user2.send("Hi Alice!");
    }
}