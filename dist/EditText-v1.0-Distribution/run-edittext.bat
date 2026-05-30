@echo off
REM Launcher script for EditText application (Windows)

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java Runtime Environment (JRE) to run this application
    pause
    exit /b 1
)

REM Check if JAR file exists
if not exist "EditText.jar" (
    echo ERROR: EditText.jar not found!
    echo Please run build-jar.sh first to create the JAR file
    pause
    exit /b 1
)

REM Run the application
java -jar EditText.jar

@REM Made with Bob
