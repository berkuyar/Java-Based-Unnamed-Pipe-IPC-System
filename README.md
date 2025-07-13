# Java-Based-Unnamed-Pipe-IPC-System
 Unnamed Pipe IPC Simulator

A Java-based simulation of interprocess communication (IPC) using unnamed pipes. This project models how producer and consumer processes interact with a shared pipe under constraints such as limited buffer capacity, blocking when the pipe is full or empty, and waking up when space or data becomes available.

## Features

- **Unnamed Pipe Communication:** Simulates communication between processes using a shared buffer.
- **Producer & Consumer Roles:** Producers can write messages, consumers can read messages.
- **Message Constraints:**
  - Max message length: 20 characters
  - Pipe capacity: 3 messages
- **Blocking Mechanism:** 
  - Producers are blocked when the pipe is full.
  - Consumers are blocked when the pipe is empty.
- **Wake-Up Mechanism:** 
  - When a blocked process's condition is resolved, it is automatically resumed.
- **Time-Based Execution:**
  - Events (write/read calls) are executed second-by-second.
  - Input events are parsed from a file named `girdi.txt`.

## Input File Format

The `girdi.txt` file must include two sections:

1. **Processes Section:**
prosesler:
producer 2 p1 p18
consumer 2 c4 c22

2. **Events Section:**
olaylar:
p1 3 "hello consumer"
c4 4
c4 5
p18 6 "how are you"
c22 8


## Technologies

- Java (JDK 17+)
- Eclipse IDE
- Standard Java collections (`Queue`, `HashMap`, etc.)

## How to Run

1. Make sure `girdi.txt` is located in the project directory.
2. Compile and run the `_22010310073_Main` class.
3. Observe the console output for event execution logs.

---

Developed by 
Berk Uyar
