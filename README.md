# Java Design Patterns Collection

A comprehensive collection of Java Design Patterns with detailed documentation and working examples.

## Overview

This project demonstrates the 23 Gang of Four Design Patterns with:
- **Detailed Javadoc documentation** explaining each pattern's purpose, structure, and benefits
- **Real-world examples** showing practical applications
- **Comprehensive code comments** highlighting key implementation details
- **Working demonstrations** that can be executed to see patterns in action

## Project Structure

```
JavaDesignPattern/
├── src/main/java/com/designpatterns/
│   ├── MainApp.java                    # Main demonstration application
│   ├── creational/                     # Creational Design Patterns
│   │   ├── singleton/SingletonDemo.java
│   │   ├── factory/FactoryMethodDemo.java
│   │   ├── abstractfactory/AbstractFactoryDemo.java
│   │   ├── builder/BuilderDemo.java
│   │   └── prototype/PrototypeDemo.java
│   ├── structural/                     # Structural Design Patterns
│   │   ├── adapter/AdapterDemo.java
│   │   ├── bridge/BridgeDemo.java
│   │   ├── composite/CompositeDemo.java
│   │   ├── decorator/DecoratorDemo.java
│   │   ├── facade/FacadeDemo.java
│   │   ├── flyweight/FlyweightDemo.java
│   │   └── proxy/ProxyDemo.java
│   └── behavioral/                     # Behavioral Design Patterns
│       ├── chainofresponsibility/ChainOfResponsibilityDemo.java
│       ├── command/CommandDemo.java
│       ├── iterator/IteratorDemo.java
│       ├── mediator/MediatorDemo.java
│       ├── memento/MementoDemo.java
│       ├── observer/ObserverDemo.java
│       ├── state/StateDemo.java
│       ├── strategy/StrategyDemo.java
│       ├── templatemethod/TemplateMethodDemo.java
│       └── visitor/VisitorDemo.java
├── pom.xml                            # Maven configuration
├── run.sh                             # Execution script
└── README.md                          # This file
```

## Quick Reference - Pattern Examples

### Creational Patterns
```java
// Singleton - One instance only
DatabaseConnection.getInstance().query("SELECT * FROM users");

// Factory Method - Create without specifying exact class
DocumentFactory factory = new WordFactory();
factory.openDocument(); // Creates WordDocument

// Abstract Factory - Create families of objects
UIFactory factory = new WindowsFactory();
Button btn = factory.createButton(); // Windows-style button

// Builder - Step-by-step construction
House house = new HouseBuilder()
    .setFoundation("Concrete")
    .setWalls("Brick")
    .setRoof("Tile")
    .build();

// Prototype - Clone existing objects
Shape circle = new Circle();
Shape clonedCircle = circle.clone();
```

### Structural Patterns
```java
// Adapter - Make incompatible interfaces work
ModernPrinter adapter = new PrinterAdapter(oldPrinter);
adapter.printDocument("Hello World!");

// Bridge - Separate abstraction from implementation
Shape redCircle = new Circle(new RedColor());
redCircle.draw();

// Composite - Tree structures
Component folder = new Folder("Documents");
folder.add(new File("resume.pdf"));
folder.display();

// Decorator - Add behavior dynamically
Coffee coffee = new MilkDecorator(new SimpleCoffee());
coffee.getDescription(); // "Simple Coffee, Milk"

// Facade - Simplified interface
HomeTheaterFacade theater = new HomeTheaterFacade();
theater.watchMovie("Inception");

// Flyweight - Share common data
Character c = CharacterFactory.getCharacter('A');
c.display(font, size);

// Proxy - Placeholder/surrogate
Image image = new ProxyImage("photo.jpg");
image.display(); // Loads only when needed
```

### Behavioral Patterns
```java
// Chain of Responsibility - Pass request along chain
Handler chain = new ConcreteHandler1();
chain.setNext(new ConcreteHandler2());
chain.handleRequest(request);

// Command - Encapsulate requests
Command command = new LightOnCommand(light);
RemoteControl remote = new RemoteControl();
remote.setCommand(command);
remote.pressButton();

// Iterator - Sequential access
Iterator<String> iter = collection.createIterator();
while (iter.hasNext()) {
    System.out.println(iter.next());
}

// Mediator - Define object interactions
ChatMediator mediator = new ChatRoom();
User user1 = new ConcreteUser(mediator, "Alice");
user1.send("Hello!");

// Memento - Capture/restore state
Memento memento = editor.save();
editor.restore(memento);

// Observer - Notify multiple objects
NewsAgency agency = new NewsAgency();
agency.attach(subscriber);
agency.setNews("Breaking news!"); // Notifies all

// State - Change behavior based on state
VendingMachine machine = new VendingMachine();
machine.insertCoin(); // Behavior depends on current state

// Strategy - Interchangeable algorithms
Context context = new Context(new ConcreteStrategyA());
context.executeStrategy();

// Template Method - Algorithm skeleton
DataProcessor processor = new CSVProcessor();
processor.process(); // Uses template with CSV-specific steps

// Visitor - Add operations without modifying
Visitor visitor = new ConcreteVisitor();
element.accept(visitor);
```

## Design Patterns Included

### Creational Patterns ✅
- **Singleton Pattern** - Ensures only one instance exists
- **Factory Method Pattern** - Creates objects without specifying exact classes
- **Abstract Factory Pattern** - Creates families of related objects
- **Builder Pattern** - Constructs complex objects step by step
- **Prototype Pattern** - Creates objects by cloning existing instances

### Structural Patterns ✅
- **Adapter Pattern** - Allows incompatible interfaces to work together
- **Bridge Pattern** - Separates abstraction from implementation
- **Composite Pattern** - Composes objects into tree structures
- **Decorator Pattern** - Adds behavior to objects dynamically
- **Facade Pattern** - Provides simplified interface to complex subsystem
- **Flyweight Pattern** - Minimizes memory usage by sharing common data
- **Proxy Pattern** - Provides placeholder/surrogate for another object

### Behavioral Patterns ✅
- **Chain of Responsibility Pattern** - Passes request along chain of handlers
- **Command Pattern** - Encapsulates requests as objects
- **Iterator Pattern** - Provides way to access elements sequentially
- **Mediator Pattern** - Defines how objects interact with each other
- **Memento Pattern** - Captures and restores object state
- **Observer Pattern** - Notifies multiple objects about state changes
- **State Pattern** - Changes object behavior based on internal state
- **Strategy Pattern** - Defines family of algorithms and makes them interchangeable
- **Template Method Pattern** - Defines skeleton of algorithm, subclasses fill in details
- **Visitor Pattern** - Adds new operations to objects without modifying them

## How to Run

### Prerequisites
- Java 8 or higher
- Maven (optional, for dependency management)

### Compilation and Execution

#### Using Java directly:
```bash
# Navigate to project directory
cd JavaDesignPattern

# Create target directory
mkdir -p target/classes

# Compile all Java files
find src -name "*.java" -exec javac -cp src/main/java -d target/classes {} +

# Run the main application
java -cp target/classes com.designpatterns.MainApp
```

#### Using Maven (if available):
```bash
# Compile the project
mvn clean compile

# Run the main application
mvn exec:java
```

## Key Features

### 1. Comprehensive Documentation
Every class includes detailed Javadoc comments explaining:
- Pattern purpose and benefits
- Implementation details
- Real-world use cases
- Code structure and relationships

### 2. Thread-Safe Implementations
Critical patterns like Singleton include thread-safe implementations with:
- Double-checked locking
- Volatile keywords for memory visibility
- Comprehensive thread safety demonstrations

### 3. Real-World Examples
Each pattern uses practical examples:
- **Singleton**: Database connections, configuration managers
- **Factory Method**: Restaurant burger creation system
- Clear analogies to real business scenarios

### 4. Educational Focus
The code is designed for learning with:
- Step-by-step explanations in comments
- Multiple demonstration scenarios
- Clear separation of pattern components
- Extensive cross-references between related classes

## Pattern Demonstrations

### All 23 Gang of Four Patterns
Each pattern includes:
- **Simple, focused examples** that demonstrate core concepts
- **Real-world analogies** (database connections, document creation, etc.)
- **Clear documentation** explaining when and why to use each pattern
- **Minimal code** that highlights the pattern's essence
- **Working demonstrations** showing the pattern in action

## Learning Objectives

After studying this code, you will understand:

1. **All 23 Design Patterns**: Complete coverage of Gang of Four patterns
2. **Pattern Recognition**: How to identify when to use each pattern
3. **Simple Implementations**: Clean, minimal code that focuses on core concepts
4. **Real-World Applications**: Practical examples and use cases
5. **Pattern Categories**: Understanding of Creational, Structural, and Behavioral patterns

## Best Practices Demonstrated

- **SOLID Principles**: Single Responsibility, Open/Closed, Dependency Inversion
- **Thread Safety**: Proper synchronization and memory visibility
- **Performance**: Optimizations like local variable caching
- **Documentation**: Comprehensive Javadoc with examples and cross-references
- **Code Organization**: Clear package structure and separation of concerns

## Contributing

This project serves as an educational resource. The patterns are implemented following best practices and include comprehensive documentation to aid learning.

## License

MIT License - Feel free to use this code for educational purposes.

## References

- Gang of Four: Design Patterns - Elements of Reusable Object-Oriented Software
- Effective Java by Joshua Bloch
- Head First Design Patterns
- Java Concurrency in Practice

---

**Note**: This project prioritizes educational value and code clarity over brevity. Each implementation includes extensive documentation to help developers understand not just *how* patterns work, but *why* and *when* to use them.