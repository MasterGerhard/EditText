#!/bin/bash
# Launcher script for EditText application (Linux/Mac)

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "ERROR: Java is not installed or not in PATH"
    echo "Please install Java Runtime Environment (JRE) to run this application"
    exit 1
fi

# Check if JAR file exists
if [ ! -f "EditText.jar" ]; then
    echo "ERROR: EditText.jar not found!"
    echo "Please run build-jar.sh first to create the JAR file"
    exit 1
fi

# Run the application
java -jar EditText.jar

# Made with Bob
