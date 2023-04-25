import java.util.ArrayList;
import java.util.List;

/**
 * La classe Task est un exemple du pattern Composite.
 * Elle permet de créer une structure hiérarchique d'objets Task,
 * où chaque objet peut contenir d'autres objets similaires (sous-tâches).
 */
public class Task extends TaskComponent {
    private String nom;
    private String description;
    private String statut;
    private List<TaskComponent> sousTaches;

    /**
     * Construit une nouvelle instance de Task.
     * @param nom Le nom de la tâche.
     * @param description La description de la tâche.
     * @param statut Le statut de la tâche.
     */
    public Task(String nom, String description, String statut) {
        this.nom = nom;
        this.description = description;
        this.statut = statut;
        sousTaches = new ArrayList<TaskComponent>();
    }

    @Override
    public String getName() {
        return nom;
    }

    @Override
    public List<TaskComponent> getSubtasks() {
        return sousTaches;
    }

    /**
     * Ajoute une sous-tâche à la liste des sous-tâches.
     * @param taskComponent La sous-tâche à ajouter.
     */
    @Override
    public void add(TaskComponent taskComponent) {
        sousTaches.add(taskComponent);
    }

    /**
     * Supprime une sous-tâche de la liste des sous-tâches.
     * @param taskComponent La sous-tâche à supprimer.
     */
    @Override
    public void remove(TaskComponent taskComponent) {
        sousTaches.remove(taskComponent);
    }

    /**
     * Affiche la tâche et ses sous-tâches de manière hiérarchique.
     * @param profondeur La profondeur de la tâche dans la hiérarchie.
     */
    @Override
    public void display(int profondeur) {
        System.out.println("-".repeat(profondeur) + " Nom: " + nom + " ; Description: " + description + " ; Statut: (" + statut + ")");
        for (TaskComponent sousTache : sousTaches) {
            sousTache.display(profondeur + 1);
        }
    }
}
