/**
 * La classe TaskBuilder est un exemple du pattern Builder.
 * Elle permet de créer des objets Task de manière fluide et lisible,
 * en évitant un grand nombre de constructeurs avec différents paramètres.
 */
public class TaskBuilder {
    private String nom;
    private String description;
    private String statut;

    /**
     * Définit le nom de la tâche.
     * @param nom Le nom de la tâche.
     * @return L'instance du builder.
     */
    public TaskBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    /**
     * Définit la description de la tâche.
     * @param description La description de la tâche.
     * @return L'instance du builder.
     */
    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Définit le statut de la tâche.
     * @param statut Le statut de la tâche.
     * @return L'instance du builder.
     */
    public TaskBuilder setStatut(String statut) {
        this.statut = statut;
        return this;
    }

    /**
     * Construit et retourne un nouvel objet Task avec les attributs définis.
     * @return La nouvelle instance de Task.
     */
    public Task build() {
        return new Task(nom, description, statut);
    }
}
