package dao;

import java.sql.Timestamp;

import model.Task;

public class QueryBuilder {

	public static String createTask(Task task) {
		Timestamp timestamp = Timestamp.valueOf(task.getDateCreated());
		String query = "INSERT INTO tasks (id, title, content, is_completed, date_created) VALUES (NULL, '"
				+ task.getTitle() + "', '" + task.getContent() + "', " + task.isCompleted() + ", '" + timestamp + "')";
		return query;
	}

	public static String readAllTasks() {
		return "SELECT * FROM tasks";
	}

	public static String readTaskById(int id) {
		return "SELECT * FROM tasks WHERE id = " + id;
	}

	public static String updateTask(Task task) {
		return "UPDATE tasks SET title = '" + task.getTitle() + "', content = '" + task.getContent()
				+ "', is_completed = " + task.isCompleted() + " WHERE id = " + task.getId();
	}

	public static String deleteTask(int id) {
		return "DELETE FROM tasks WHERE id = " + id;
	}

}
