# Virtual Classroom - Command Pattern Example

## Overview
This project demonstrates the Command design pattern in Java. The pattern encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests. In this example, a virtual classroom supports muting and unmuting students with undo functionality.

## Structure
- **Command**: An interface defining the `execute` and `undo` methods.
- **MuteCommand**: A concrete command class implementing the `Command` interface to mute or unmute a student in the `Classroom`.
- **Classroom**: The receiver class that performs actual mute/unmute operations and tracks student states.
- **Invoker**: The invoker class that sets, executes, and undoes commands.
- **Main**: The client class that interacts with the `Classroom` and `Invoker` via user input.

## How to Run
1. Ensure you have Java installed on your machine.
2. Compile the Java files: `javac src/*.java Main.java`
3. Run the Main class: `java Main`
4. Follow the on-screen prompts to enter student names (or 'done' to finish), then commands (e.g., `mute Alice`, `unmute all`, `exit`).
