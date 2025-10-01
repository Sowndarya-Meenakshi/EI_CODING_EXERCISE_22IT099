# Satellite Command System

## Overview

This Java project implements a satellite command system that simulates the control of a satellite in orbit. The satellite initializes in a default state and processes a series of commands to modify its orientation, solar panel status, and data collection capabilities. The implementation adheres to object-oriented programming principles, incorporates design patterns, and follows robust software engineering practices.

## Features

- Terminal-based interface for satellite control.
- Command support for rotation (North, South, East, West), panel activation/deactivation, conditional data collection, status reporting, reset, help, and exit.
- State tracking for orientation, solar panels, and collected data, including validation mechanisms.
- File-based logging of executed commands.
- Application of design patterns including Command and Factory for maintainability.

## Available Commands

- `rotate <direction>`: Rotates the satellite to the specified direction (North, South, East, West).
- `activatePanels`: Activates the solar panels.
- `deactivatePanels`: Deactivates the solar panels.
- `collectData`: Collects data if solar panels are active.
- `status`: Displays the current satellite status.
- `reset`: Resets the satellite to its initial state.
- `help`: Shows this list of available commands.
- `exit`: Exits the application.

## Key Components

### Satellite

Manages the core state attributes: orientation, solar panel status, and data collected. Processes state transitions.

### Commands

Implements specific operations (e.g., Rotate, ActivatePanels, DeactivatePanels, CollectData) through the Command pattern to promote extensibility and decoupling.

### TerminalUI

Processes user input, handles logging, and dispatches commands using the CommandFactory.

## Design Patterns

- Command Pattern: Encapsulates operations as objects to enable queuing and decoupling between the invoker (TerminalUI) and receiver (Satellite).
- Factory Pattern: The CommandFactory instantiates appropriate command objects based on user input.

## OOP and SOLID Principles

- **Encapsulation**: Classes like Satellite encapsulate state (orientation, panels, data) and provide controlled access through methods.
- **Polymorphism**: The Command interface allows different command implementations (RotateCommand, ActivatePanelsCommand, etc.) to be executed uniformly.
- **Inheritance**: Command classes inherit from the Command interface.
- **Abstraction**: The Command interface abstracts the execute operation, hiding implementation details.
- **Single Responsibility Principle (SRP)**: Each command class handles one specific operation.
- **Open/Closed Principle (OCP)**: New commands can be added without modifying existing code.
- **Liskov Substitution Principle (LSP)**: Any Command implementation can replace another in the system.
- **Interface Segregation Principle (ISP)**: The Command interface is minimal and focused.
- **Dependency Inversion Principle (DIP)**: High-level modules (TerminalUI) depend on abstractions (CommandFactory, Command) rather than concretions.

The system processes commands entered via the terminal interface.

### Example

1. Compile and execute the application as described in the "How to Run" section.

2. Sample command sequence:
   - rotate South
   - activatePanels
   - collectData
   - status
   - exit

Sample output:
```
> rotate South
Satellite rotated to South
> activatePanels
Solar panels activated
> collectData
Data collected. Total: Orientation: South | Solar Panels: Active | Data Collected: 10
> status
Orientation: South | Solar Panels: Active | Data Collected: 10
```

## Code Structure

- src/
  - App.java: Application entry point.
  - commands/: Contains command implementations (e.g., RotateCommand, ActivatePanelsCommand) and CommandFactory.java for creating commands.
  - satellite/
    - Satellite.java: Manages satellite state.
    - TerminalUI.java: Manages the command execution loop and logging.

## How to Run

1. To enable UTF-8 encoding (which is required for emojis like ✅ ❌ ↑), run the following command before executing the program:: `chcp 65001`
2. Compile the source files: `javac -d bin src/App.java src/satellite/*.java src/commands/*.java`
3. Execute the application: `java -cp bin App`
4. Input commands such as `rotate North`, `activatePanels`, `status`, or `exit` in the terminal.

## Contact

For inquiries or additional details, contact [sowndaryameenakshi2005@gmail.com](mailto:sowndaryameenakshi2005@gmail.com).
