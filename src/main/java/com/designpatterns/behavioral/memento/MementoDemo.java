package com.designpatterns.behavioral.memento;

/**
 * Memento Pattern - Captures and restores object state.
 * Simple example: Text editor with undo functionality.
 */
public class MementoDemo {
    
    // Memento
    static class TextMemento {
        private final String state;
        
        public TextMemento(String state) { this.state = state; }
        
        public String getState() { return state; }
    }
    
    // Originator
    static class TextEditor {
        private String content = "";
        
        public void write(String text) {
            content += text;
        }
        
        public String getContent() { return content; }
        
        public TextMemento save() {
            return new TextMemento(content);
        }
        
        public void restore(TextMemento memento) {
            content = memento.getState();
        }
    }
    
    // Caretaker
    static class EditorHistory {
        private java.util.Stack<TextMemento> history = new java.util.Stack<>();
        
        public void save(TextEditor editor) {
            history.push(editor.save());
        }
        
        public void undo(TextEditor editor) {
            if (!history.isEmpty()) {
                editor.restore(history.pop());
            }
        }
    }
    
    public static void demonstrate() {
        System.out.println("\n--- Memento Pattern ---");
        
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();
        
        editor.write("Hello ");
        System.out.println("Content: " + editor.getContent());
        history.save(editor);
        
        editor.write("World!");
        System.out.println("Content: " + editor.getContent());
        
        history.undo(editor);
        System.out.println("After undo: " + editor.getContent());
    }
}