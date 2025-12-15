package com.designpatterns.behavioral.iterator;

/**
 * Iterator Pattern - Provides way to access elements sequentially.
 * Simple example: Custom list with iterator.
 */
public class IteratorDemo {
    
    // Iterator interface
    interface Iterator<T> {
        boolean hasNext();
        T next();
    }
    
    // Aggregate interface
    interface Container<T> {
        Iterator<T> getIterator();
    }
    
    // Concrete aggregate
    static class SimpleList<T> implements Container<T> {
        private Object[] items = new Object[10];
        private int count = 0;
        
        public void add(T item) {
            if (count < items.length) {
                items[count++] = item;
            }
        }
        
        @Override
        public Iterator<T> getIterator() {
            return new SimpleIterator();
        }
        
        // Concrete iterator
        private class SimpleIterator implements Iterator<T> {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < count;
            }
            
            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) items[index++];
            }
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Iterator Pattern ---");
        
        SimpleList<String> list = new SimpleList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        
        Iterator<String> iterator = list.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}