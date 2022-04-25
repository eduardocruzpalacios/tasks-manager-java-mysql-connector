package dao;

import model.Task;

public class QueryBuilder {

	public static String createTask(Task task) {
		return "INSERT INTO tasks (id, title, content, is_completed, date_created) VALUES (NULL, " + task.getTitle()
				+ ", " + task.getContent() + ", " + task.isCompleted() + ", " + task.getDateCreated() + ")";
	}

	public static String readAllTasks() {
		return "SELECT * FROM tasks";
	}

	public static String readTaskById(int id) {
		return "SELECT * FROM tasks WHERE id = " + id;
	}

	public static String updateTask(Task task) {
		return "UPDATE tasks SET title = " + task.getTitle() + ", content = " + task.getContent() + ", is_completed = "
				+ task.isCompleted() + ", date_created = " + task.getDateCreated() + " WHERE id = " + task.getId();
	}

}
