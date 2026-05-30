#!/bin/bash
# Build and run the EditText application

# Compile the project
echo "Compiling EditText..."
javac -d bin -sourcepath src src/main/EditText.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Running EditText..."
    java -cp bin main.EditText
else
    echo "Compilation failed!"
    exit 1
fi

# Made with Bob
