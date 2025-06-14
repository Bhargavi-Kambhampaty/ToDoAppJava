import java.util.ArrayList;
import java.util.Scanner;

abstract class BaseTask {
    protected String description;
    protected boolean isCompleted;
    protected String dueDate;
    protected String category;

    BaseTask(String description, String dueDate, String category) {
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.isCompleted = false;
    }

    void markAsDone() {
        this.isCompleted = true;
    }

    abstract String getDetails();

    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + getDetails();
    }
}

class Task extends BaseTask {
    Task(String description, String dueDate, String category) {
        super(description, dueDate, category);
    }

    @Override
    String getDetails() {
        return description + " (Due: " + dueDate + ", Category: " + category + ")";
    }
}

class PriorityTask extends BaseTask {
    private String priority;

    PriorityTask(String description, String dueDate, String category, String priority) {
        super(description, dueDate, category);
        this.priority = priority;
    }

    @Override
    String getDetails() {
        return description + " (Due: " + dueDate + ", Category: " + category + ", Priority: " + priority + ")";
    }
}

public class ToDoApp {
    private static final ArrayList<BaseTask> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Add Priority Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Mark Task as Done");
            System.out.println("5. Remove Task");
            System.out.println("6. Remove Multiple Tasks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> addPriorityTask();
                case 3 -> viewTasks();
                case 4 -> markTaskAsDone();
                case 5 -> removeTask();
                case 6 -> removeMultipleTasks();
                case 7 -> {
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        tasks.add(new Task(description, dueDate, category));
        System.out.println("Task added successfully!");
    }

    private static void addPriorityTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();
        tasks.add(new PriorityTask(description, dueDate, category, priority));
        System.out.println("Priority Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTo-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void markTaskAsDone() {
        viewTasks();
        System.out.print("Enter task number to mark as done: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            System.out.println("Task marked as done!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeTask() {
        viewTasks();
        System.out.print("Enter task number to remove: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeMultipleTasks() {
        viewTasks();
        System.out.print("Enter task numbers to remove (comma-separated): ");
        String[] indices = scanner.nextLine().split(",");
        ArrayList<Integer> toRemove = new ArrayList<>();
        
        for (String index : indices) {
            try {
                int taskIndex = Integer.parseInt(index.trim()) - 1;
                if (taskIndex >= 0 && taskIndex < tasks.size()) {
                    toRemove.add(taskIndex);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + index);
            }
        }
        
        toRemove.sort((a, b) -> b - a); // Remove in reverse order to avoid shifting issues
        for (int index : toRemove) {
            tasks.remove(index);
        }
        
        System.out.println("Selected tasks removed successfully!");
    }
}

