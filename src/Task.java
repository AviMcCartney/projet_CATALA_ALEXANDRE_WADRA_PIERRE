import java.util.ArrayList;
import java.util.List;

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

    // Ajout des getters
    public String getName() {
        return name;
    }

    public List<TaskComponent> getSubtasks() {
        return subtasks;
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
