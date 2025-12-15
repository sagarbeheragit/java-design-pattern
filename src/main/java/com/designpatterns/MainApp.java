/*
 * MIT License
 *
 * Copyright (c) 2023 Java Design Patterns Collection
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.designpatterns;

import com.designpatterns.creational.singleton.SingletonDemo;
import com.designpatterns.creational.factory.FactoryMethodDemo;
import com.designpatterns.creational.abstractfactory.AbstractFactoryDemo;
import com.designpatterns.creational.builder.BuilderDemo;
import com.designpatterns.creational.prototype.PrototypeDemo;
import com.designpatterns.structural.adapter.AdapterDemo;
import com.designpatterns.structural.bridge.BridgeDemo;
import com.designpatterns.structural.composite.CompositeDemo;
import com.designpatterns.structural.decorator.DecoratorDemo;
import com.designpatterns.structural.facade.FacadeDemo;
import com.designpatterns.structural.flyweight.FlyweightDemo;
import com.designpatterns.structural.proxy.ProxyDemo;
import com.designpatterns.behavioral.chainofresponsibility.ChainOfResponsibilityDemo;
import com.designpatterns.behavioral.command.CommandDemo;
import com.designpatterns.behavioral.iterator.IteratorDemo;
import com.designpatterns.behavioral.mediator.MediatorDemo;
import com.designpatterns.behavioral.memento.MementoDemo;
import com.designpatterns.behavioral.observer.ObserverDemo;
import com.designpatterns.behavioral.state.StateDemo;
import com.designpatterns.behavioral.strategy.StrategyDemo;
import com.designpatterns.behavioral.templatemethod.TemplateMethodDemo;
import com.designpatterns.behavioral.visitor.VisitorDemo;

/**
 * Main application demonstrating all 23 Gang of Four Design Patterns.
 * 
 * <p>Design patterns are reusable solutions to commonly occurring problems
 * in software design. They represent best practices and provide a common
 * vocabulary for developers.</p>
 * 
 * <p>The patterns are categorized into three types:</p>
 * <ul>
 *   <li><strong>Creational Patterns:</strong> Deal with object creation mechanisms</li>
 *   <li><strong>Structural Patterns:</strong> Deal with object composition</li>
 *   <li><strong>Behavioral Patterns:</strong> Deal with communication between objects</li>
 * </ul>
 * 
 * <p>Each pattern demonstration includes:</p>
 * <ul>
 *   <li>Detailed documentation explaining the pattern's purpose</li>
 *   <li>Real-world use cases and examples</li>
 *   <li>Implementation with best practices</li>
 *   <li>Key benefits and trade-offs</li>
 * </ul>
 */
public class MainApp {

    /**
     * Demonstrates all design patterns with clear separation and explanation.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("JAVA DESIGN PATTERNS DEMONSTRATION");
        System.out.println("================================================================================");
        
        demonstrateCreationalPatterns();
        demonstrateStructuralPatterns();
        demonstrateBehavioralPatterns();
        
        System.out.println("\n" + "================================================================================");
        System.out.println("All design patterns demonstrated successfully!");
        System.out.println("================================================================================");
    }
    
    /**
     * Demonstrates all creational design patterns.
     * Creational patterns abstract the instantiation process and help make
     * systems independent of how objects are created, composed, and represented.
     */
    private static void demonstrateCreationalPatterns() {
        System.out.println("\n" + "==================================================");
        System.out.println("CREATIONAL PATTERNS");
        System.out.println("==================================================");
        
        // Demonstrate all creational patterns
        SingletonDemo.demonstrate();
        FactoryMethodDemo.demonstrate();
        AbstractFactoryDemo.demonstrate();
        BuilderDemo.demonstrate();
        PrototypeDemo.demonstrate();
    }
    
    /**
     * Demonstrates all structural design patterns.
     * Structural patterns deal with object composition and typically identify
     * simple ways to realize relationships between different objects.
     */
    private static void demonstrateStructuralPatterns() {
        System.out.println("\n" + "==================================================");
        System.out.println("STRUCTURAL PATTERNS");
        System.out.println("==================================================");
        
        // Demonstrate all structural patterns
        AdapterDemo.demonstrate();
        BridgeDemo.demonstrate();
        CompositeDemo.demonstrate();
        DecoratorDemo.demonstrate();
        FacadeDemo.demonstrate();
        FlyweightDemo.demonstrate();
        ProxyDemo.demonstrate();
    }
    
    /**
     * Demonstrates all behavioral design patterns.
     * Behavioral patterns focus on communication between objects and the
     * assignment of responsibilities between objects.
     */
    private static void demonstrateBehavioralPatterns() {
        System.out.println("\n" + "==================================================");
        System.out.println("BEHAVIORAL PATTERNS");
        System.out.println("==================================================");
        
        // Demonstrate all behavioral patterns
        ChainOfResponsibilityDemo.demonstrate();
        CommandDemo.demonstrate();
        IteratorDemo.demonstrate();
        MediatorDemo.demonstrate();
        MementoDemo.demonstrate();
        ObserverDemo.demonstrate();
        StateDemo.demonstrate();
        StrategyDemo.demonstrate();
        TemplateMethodDemo.demonstrate();
        VisitorDemo.demonstrate();
    }
}