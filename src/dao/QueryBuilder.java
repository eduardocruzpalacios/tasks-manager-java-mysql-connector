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

}
