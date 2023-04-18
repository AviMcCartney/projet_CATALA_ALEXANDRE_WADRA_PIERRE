# Gestionnaire de tâches en Java

Le gestionnaire de tâches est un projet Java simple qui permet aux utilisateurs de créer et de gérer des tâches et des sous-tâches via une interface console. Les utilisateurs peuvent créer des tâches principales qui peuvent être divisées en sous-tâches. Chaque tâche et sous-tâche a un nom, une description et un statut (à faire, en cours, terminé).

## Choix des patterns

Le projet utilise deux design patterns pour simplifier la création et la gestion des objets et pour rendre le code plus modulaire et extensible : le pattern Builder et le pattern Composite.

### Pattern Builder

Le pattern Builder est utilisé pour simplifier la création d'objets complexes. Dans ce projet, il est utilisé pour créer des instances de la classe `Task`. Le choix de ce pattern permet d'éviter un grand nombre de constructeurs avec différents paramètres et de garantir que l'objet `Task` est construit de manière cohérente.

Exemple de la classe `TaskBuilder` :

```java
public class TaskBuilder {
    private String name;
    private String description;
    private String status;

    public TaskBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public Task build() {
        return new Task(name, description, status);
    }
}
```

Dans cet exemple, le pattern Builder est utilisé pour créer des objets Task de manière fluide et lisible. L'utilisateur peut définir les attributs name, description et status de la tâche en utilisant des méthodes chaînées, puis construire l'objet Task avec la méthode build().

### Pattern Composite
Le pattern Composite est utilisé pour créer une structure hiérarchique d'objets où chaque objet peut contenir d'autres objets similaires. Dans ce projet, il est utilisé pour gérer les tâches et les sous-tâches. La classe Task est conçue pour contenir des instances de la même classe, permettant ainsi de représenter une hiérarchie de tâches.

Exemple de la classe Task utilisant le pattern Composite :

```java
public class Task extends TaskComponent {
    private String name;
    private String description;
    private String status;
    private List<TaskComponent> subtasks;

    public Task(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
        subtasks = new ArrayList<>();
    }

    public void add(TaskComponent taskComponent) {
        subtasks.add(taskComponent);
    }

    public void remove(TaskComponent taskComponent) {
        subtasks.remove(taskComponent);
    }

    public void display(int depth) {
        System.out.println("-".repeat(depth) + " " + name + " (" + status + ")");
        for (TaskComponent subtask : subtasks) {
            subtask.display(depth + 1);
        }
    }
}
``` 

Dans cet exemple, la classe Task étend la classe abstraite TaskComponent et implémente les méthodes add, remove et display pour gérer les sous-tâches. L'utilisation du pattern Composite permet de simplifier la gestion des tâches et des sous-tâches en facilitant l'ajout
