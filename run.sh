#!/bin/bash

# Java Design Patterns Runner Script
# This script compiles and runs the Java Design Patterns demonstration

echo "Java Design Patterns Collection"
echo "==============================="

# Create target directory if it doesn't exist
if [ ! -d "target/classes" ]; then
    echo "Creating target directory..."
    mkdir -p target/classes
fi

# Compile all Java files
echo "Compiling Java files..."
find src -name "*.java" -exec javac -cp src/main/java -d target/classes {} +

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo ""
    echo "Running Design Patterns Demonstration..."
    echo "========================================"
    
    # Run the main application
    java -cp target/classes com.designpatterns.MainApp
    
    echo ""
    echo "========================================"
    echo "Demonstration completed!"
else
    echo "Compilation failed. Please check for errors."
    exit 1
fi