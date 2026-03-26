# Book My Stay App

## Overview
**Book My Stay App** is a console-based Hotel Booking Management System developed using **Core Java**.  
The project demonstrates how **data structures and object-oriented design** are applied to solve real-world problems such as booking management, inventory handling, concurrency, and system recovery.

The system is built incrementally through multiple **use cases**, each focusing on a specific software engineering concept.

---

## Objectives
- Apply **Core Java concepts** in a real-world scenario
- Understand the role of **data structures in system design**
- Ensure **data consistency and reliability**
- Simulate **real-world booking workflows**
- Build a **scalable and maintainable system**

---

## Key Concepts Used
- Object-Oriented Programming (OOP)
- Encapsulation & Abstraction
- Data Structures:
    - `List` → Booking History
    - `Queue` → Booking Requests (FIFO)
    - `Stack` → Cancellation Rollback (LIFO)
    - `Set` → Unique Room Allocation
    - `Map` → Inventory & Service Mapping
- Exception Handling (Custom Exceptions)
- File Handling (Persistence)
- Multithreading & Synchronization (Concurrency)

---


---

## Features by Use Case

### Use Case 3: Inventory Management
- Centralized room availability tracking
- Uses `Map<String, Integer>`

---

### Use Case 4: Room Search
- Read-only access to inventory
- Displays only available rooms
- Prevents unintended data modification

---

### Use Case 5: Booking Request Queue
- Handles booking requests using `Queue`
- Ensures FIFO (First-Come-First-Served) fairness

---

### Use Case 6: Room Allocation
- Assigns unique room IDs
- Prevents double booking using `Set`
- Updates inventory immediately

---

### Use Case 7: Add-On Services
- Supports optional services (Breakfast, Spa, etc.)
- Uses `Map<String, List<Service>>`

---

### Use Case 8: Booking History & Reporting
- Stores confirmed bookings using `List`
- Generates reports for admin

---

### Use Case 9: Validation & Error Handling
- Custom exception: `InvalidBookingException`
- Input validation (room type, availability)
- Fail-fast design

---

### Use Case 10: Booking Cancellation
- Uses `Stack` for rollback (LIFO)
- Restores inventory on cancellation

---

### Use Case 11: Concurrent Booking Simulation
- Multi-threaded booking simulation
- Synchronization prevents race conditions
- Ensures thread-safe operations

---

### Use Case 12: Data Persistence & System Recovery
- Saves inventory to file (`inventory.txt`)
- Loads inventory on startup
- Ensures recovery after restart

---

### Built with Core Java to demonstrate scalable and reliable system design.
Designed and developed as part of a structured learning approach to master Core Java and real-world system design.