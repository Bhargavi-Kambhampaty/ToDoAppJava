# Java To-Do List Application

A command-line based To-Do List application written in Java. It allows users to manage tasks efficiently by adding, viewing, removing, and marking them as completed. The app supports both regular and priority-based tasks with due dates and categories.

## Features

- Add regular tasks with due date and category
- Add priority tasks (High / Medium / Low)
- View all tasks with completion status
- ✔ Mark tasks as completed
- Remove single or multiple tasks by index

## Technologies Used

- Java (Standard Edition)
- Scanner for CLI input
- OOP principles (Abstraction, Inheritance)

## Class Overview

| Class              | Description |
|--------------------|-------------|
| `BaseTask`         | Abstract base class for both `Task` and `PriorityTask` |
| `Task`             | Basic task with description, due date, and category |
| `PriorityTask`     | Extended task with an added priority field |
| `ToDoApp`          | Main class with the command-line interface and logic |

## How to Run

1. **Compile:**
   ```bash
   javac ToDoApp.java

2. **Run:**
    ```bash
    java ToDoApp

Follow the menu to interact with the application.

Sample Menu

To-Do List Application
1. Add Task
2. Add Priority Task
3. View Tasks
4. Mark Task as Done
5. Remove Task
6. Remove Multiple Tasks
7. Exit
Choose an option: 

Example Task Output

1. [✓] Buy groceries (Due: 2024-07-01, Category: Personal)
2. [ ] Finish Java project (Due: 2024-07-05, Category: Work, Priority: High)

License

This project is open-source and available under the MIT License.
