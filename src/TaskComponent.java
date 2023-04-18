import java.util.List;

public abstract class TaskComponent {
    public abstract void add(TaskComponent taskComponent);
    public abstract void remove(TaskComponent taskComponent);
    public abstract void display(int depth);

    // Ajout des méthodes abstraites
    public abstract String getName();
    public abstract List<TaskComponent> getSubtasks();
}
