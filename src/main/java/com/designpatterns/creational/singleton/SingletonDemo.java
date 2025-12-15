package com.designpatterns.creational.singleton;

/**
 * Singleton Pattern - Ensures only one instance exists.
 * Thread-safe implementation with lazy loading using double-checked locking.
 */
public class SingletonDemo {
    
    // Thread-safe singleton with lazy loading
    static class DatabaseConnection {
        // volatile ensures visibility across threads and prevents instruction reordering
        private static volatile DatabaseConnection instance;
        private String connectionString;
        
        // Private constructor prevents external instantiation
        private DatabaseConnection() {
            // Simulate expensive initialization
            connectionString = "Connected to database";
            System.out.println("Database connection initialized");
        }
        
        // Double-checked locking pattern for thread-safe lazy initialization
        public static DatabaseConnection getInstance() {
            // First check without synchronization for performance
            if (instance == null) {
                // Synchronize only when instance is null
                synchronized (DatabaseConnection.class) {
                    // Double-check inside synchronized block
                    if (instance == null) {
                        instance = new DatabaseConnection();
                    }
                }
            }
            return instance;
        }
        
        public void query(String sql) {
            System.out.println("Executing: " + sql + " on " + connectionString);
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Singleton Pattern ---");
        
        // First call triggers lazy initialization
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        // Second call returns existing instance (no initialization)
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        db1.query("SELECT * FROM users");
        db2.query("SELECT * FROM products");
        
        // Verify both references point to same object
        System.out.println("Same instance? " + (db1 == db2));
        
        // Test thread safety
        testThreadSafety();
    }
    
    // Demonstrate thread safety with concurrent access
    private static void testThreadSafety() {
        System.out.println("\nTesting thread safety with 3 concurrent threads:");
        
        // Create multiple threads that try to get singleton instance
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            new Thread(() -> {
                DatabaseConnection db = DatabaseConnection.getInstance();
                System.out.println("Thread " + threadId + " got instance: " + db.hashCode());
            }).start();
        }
        
        // Wait a bit for threads to complete
        try { Thread.sleep(100); } catch (InterruptedException e) {}
    }
}