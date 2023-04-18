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