# Custom-List-Implementation
# Custom List Implementations – COMP 352 Assignment 2

## 📚 Course Info
**Course**: COMP 352 – Data Structures and Algorithms  
**Term**: Winter 2025  
**Assignment**: Programming Assignment 2  

## 👥 Team Members
- Karim Mikhaeil – 40233685  
- Karim Hanna – 40245600  

---

## 🧠 Project Description

This project focuses on building and comparing two custom list implementations from scratch:

- **MyArrayList** – a dynamic array-based list similar to Java's `ArrayList`
- **MyLinkedList** – a singly linked list structure

Each list supports standard list operations like:
- Adding/removing elements
- Retrieving elements by index
- Inserting at specific positions
- Comparing performance on common tasks

The project includes a driver class (`ListTester.java`) that runs a set of functional and performance tests to evaluate the behavior and efficiency of both list implementations.

---

---

## ✅ Features

### MyArrayList
- Uses a dynamic resizing strategy
- Supports `add()`, `remove()`, `get()`, and `set()` methods
- Automatic resizing when capacity is reached

### MyLinkedList
- Node-based singly linked structure
- Supports element insertion/removal from any position
- Efficient memory use for frequent insertions

### ListTester
- Runs tests for correctness and timing
- Demonstrates differences in efficiency between the two implementations

---

## 🚀 How to Run

1. Compile the files:

```bash
javac src/*.java
java -cp src ListTester
