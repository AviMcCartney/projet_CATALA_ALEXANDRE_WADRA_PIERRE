import java.util.Scanner;

public class TaskManager {
    private TaskComponent root;

    public TaskManager() {
        root = new Task("Root", "Root task", "N/A");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.print("Enter command (add, remove, display, exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    addTask(scanner);
                    break;
                case "remove":
                    removeTask(scanner);
                    break;
                case "display":
                    displayTasks();
                    break;
                case "exit":
                    System.out.println("Exiting Task Manager...");
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }

    private void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task status (todo, inprogress, done): ");
        String status = scanner.nextLine();

        Task task = new TaskBuilder()
                .setName(name)
                .setDescription(description)
                .setStatus(status)
                .build();

        root.add(task);
    }

    private void removeTask(Scanner scanner) {
        System.out.print("Enter task name to remove: ");
        String name = scanner.nextLine();

        TaskComponent taskToRemove = null;

        for (TaskComponent task : root.getSubtasks()) {
            if (task.getName().equals(name)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            root.remove(taskToRemove);
            System.out.println("Task removed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private void displayTasks() {
        System.out.println("Task List:");
        root.display(0);
    }
}
