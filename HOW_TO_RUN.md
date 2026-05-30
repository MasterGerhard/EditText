# How to Run EditText

## Problem Identified
This is an old Eclipse Java project that was configured for Java SE 1.7. The project needed to be compiled before it could run.

## Solution

### Quick Start
The project now compiles and runs successfully! Use one of these methods:

#### Method 1: Using the run script (Recommended)
```bash
./run.sh
```

#### Method 2: Manual compilation and execution
```bash
# Compile the project
javac -d bin -sourcepath src src/main/EditText.java

# Run the application
java -cp bin main.EditText
```

## Project Details
- **Main Class**: `main.EditText`
- **Original Java Version**: Java SE 1.7
- **Current Java Version**: Java 26.0.1 (compatible)
- **Build Output**: `bin/` directory
- **Source Code**: `src/` directory

## Notes
- The project compiles with some deprecation warnings (expected for old code)
- This is a GUI application (Swing-based text editor)
- According to README.txt, Undo/Redo and saving text attributes are not yet implemented

## What Was Fixed
1. The project needed to be compiled first - the `bin/` directory was empty
2. Created a convenient `run.sh` script for easy compilation and execution
3. Verified the project works with modern Java (Java 26)

## Features (from README.txt)
- Text editing with multiple pages
- Bold, Italic, Underline formatting
- Font selection and sizing
- Text color
- Spell checking
- Word count
- Save/Open functionality (saves as .txt without formatting)