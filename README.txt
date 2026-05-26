# Wumpus Game - Setup & Run Instructions

## How to Run

### Option A: Double-click launcher (Windows)
1. Double-click `Run_WumpusGame.bat`
   - If Java is installed, the game opens immediately.
   - If you see an error, install Java first (see below).

### Option B: Run from command line
```
java -jar WumpusGame.jar
```

## Requirements
- Java 11 or higher must be installed.
- Download free from: https://www.java.com/en/download/

## Converting to a standalone .exe (no Java required)
1. Install **jpackage** (included with JDK 14+)
2. Run:
   ```
   jpackage --input . --main-jar WumpusGame.jar --name WumpusGame --type exe
   ```
   This bundles Java inside the .exe so anyone can run it.

Alternatively, use **Launch4j** (free): https://launch4j.sourceforge.net/
- Set Output: WumpusGame.exe
- Set Jar: WumpusGame.jar
- Click Build

## Game Controls
- **Start** button — places your player on the board
- **Arrow buttons** (or Left/Right/Up/Down buttons) — move your character
- **Hit Left/Right/Up/Down** — shoot an arrow to kill the Wumpus

## What the symbols mean
- **Stench** — Wumpus is nearby
- **Breeze** — Pit is nearby
- **Gold** — Collect all 8 to win!

Your photo is embedded as the player character. Good luck!
