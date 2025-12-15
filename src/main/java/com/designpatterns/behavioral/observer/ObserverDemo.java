package com.designpatterns.behavioral.observer;

import java.util.*;

/**
 * Observer Pattern - Defines one-to-many dependency between objects.
 * When subject changes state, all observers are notified automatically.
 */
public class ObserverDemo {
    
    // Observer interface - defines update method for receiving notifications
    interface Observer {
        void update(String news);
    }
    
    // Subject interface - defines methods for managing observers
    interface Subject {
        void attach(Observer observer);   // Subscribe
        void detach(Observer observer);   // Unsubscribe
        void notifyObservers();          // Notify all subscribers
    }
    
    // Concrete Subject - maintains list of observers and notifies them of changes
    static class NewsAgency implements Subject {
        // List of observers - maintains references to all subscribers
        private List<Observer> observers = new ArrayList<>();
        private String news;
        
        @Override
        public void attach(Observer observer) {
            observers.add(observer);
            System.out.println("Observer attached. Total observers: " + observers.size());
        }
        
        @Override
        public void detach(Observer observer) {
            observers.remove(observer);
            System.out.println("Observer detached. Total observers: " + observers.size());
        }
        
        // Push model - subject pushes data to observers
        @Override
        public void notifyObservers() {
            System.out.println("Notifying " + observers.size() + " observers...");
            for (Observer observer : observers) {
                observer.update(news); // Each observer gets the same data
            }
        }
        
        // State change triggers notification
        public void setNews(String news) {
            System.out.println("News agency publishing: " + news);
            this.news = news;
            notifyObservers(); // Automatic notification on state change
        }
    }
    
    // Concrete Observer - implements update method to handle notifications
    static class NewsSubscriber implements Observer {
        private String name;
        
        public NewsSubscriber(String name) { this.name = name; }
        
        // Called by subject when state changes
        @Override
        public void update(String news) {
            System.out.println("[" + name + "] received news: " + news);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Observer Pattern ---");
        
        // Create subject (publisher)
        NewsAgency agency = new NewsAgency();
        
        // Create observers (subscribers)
        NewsSubscriber subscriber1 = new NewsSubscriber("Alice");
        NewsSubscriber subscriber2 = new NewsSubscriber("Bob");
        
        // Subscribe observers to subject
        agency.attach(subscriber1);
        agency.attach(subscriber2);
        
        // State change automatically notifies all observers
        agency.setNews("Breaking: New design pattern discovered!");
        
        // Add another subscriber
        NewsSubscriber subscriber3 = new NewsSubscriber("Charlie");
        agency.attach(subscriber3);
        
        // All three subscribers get notified
        agency.setNews("Update: Pattern implementation completed!");
        
        // Unsubscribe one observer
        agency.detach(subscriber1);
        
        // Only remaining subscribers get notified
        agency.setNews("Final: Observer pattern demonstration finished!");
    }
}