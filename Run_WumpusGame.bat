@echo off
java -jar WumpusGame.jar
if %errorlevel% neq 0 (
    echo.
    echo ERROR: Java not found. Please install Java from https://www.java.com
    pause
)
