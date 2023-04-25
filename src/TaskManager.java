import java.util.Scanner;

public class TaskManager {
    private TaskComponent root;

    public TaskManager() {
        root = new Task("Racine", "Tâche racine", "Aucun");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.print("Entré un commande(ajouter, supprimer, afficher, sortir): ");
            command = scanner.nextLine();

            switch (command) {
                case "ajouter":
                    addTask(scanner);
                    break;
                case "supprimer":
                    removeTask(scanner);
                    break;
                case "afficher":
                    displayTasks();
                    break;
                case "sortir":
                    System.out.println("Sortie du manager de tâche...");
                    break;
                default:
                    System.out.println("Commande invalide. Réessayer.");
            }
        } while (!command.equals("sortir"));

        scanner.close();
    }

    private void addTask(Scanner scanner) {
        System.out.print("Entrer le nom de la tâche: ");
        String name = scanner.nextLine();
        System.out.print("Entrer la description de la tâche: ");
        String description = scanner.nextLine();
        System.out.print("Entrer status de la tâche (à faire, en cours, terminé): ");
        String status = scanner.nextLine();

        Task task = new TaskBuilder()
                .setNom(name)
                .setDescription(description)
                .setStatut(status)
                .build();

        root.add(task);
    }

    private void removeTask(Scanner scanner) {
        System.out.print("Entrer un nom de tâche à supprimé: ");
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
            System.out.println("Tâche supprimée.");
        } else {
            System.out.println("Tâche introuvable.");
        }
    }

    private void displayTasks() {
        System.out.println("Liste des tâches");
        root.display(0);
    }
}
