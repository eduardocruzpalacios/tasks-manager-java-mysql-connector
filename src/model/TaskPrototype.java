package model;

public class TaskPrototype extends Task {

	public static Task clone(Task task) {
		return new TaskPrototype(task);
	}

	private TaskPrototype(Task task) {
		this.setId(task.getId());
		this.setTitle(task.getTitle());
		this.setContent(task.getContent());
		this.setCompleted(task.isCompleted());
		this.setDateCreated(getDateCreated());
	}

}
