package services;

import java.time.LocalDateTime;
import java.util.List;

import dao.Db;
import model.Task;
import utilities.In;

public class TaskServiceImpl implements Crud {

	Db db = new Db();

	@Override
	public boolean create() {
		System.out.println("FORM TO CREATE A NEW TASK");
		String title = In.getString("Title?");
		String content = In.getString("Content?");
		boolean isCompleted = In.getBoolean("Is completed?");
		LocalDateTime dateCreated = LocalDateTime.now();
		Task task = new Task(title, content, isCompleted, dateCreated);
		if (db.createTask(task)) {
			System.out.println("Task created successfully!");
			return true;
		}
		System.out.println("Error in Database!");
		return false;
	}

	@Override
	public boolean findAll() {
		List<Task> tasks = db.readTasks();
		System.out.println("TASK LIST");
		if (tasks != null) {
			tasks.forEach(e -> {
				System.out.println(e);
			});
			return true;
		}
		System.out.println("Error in Database!");
		return false;
	}

	@Override
	public boolean update() {
		int id = In.getInt("id?");
		Task task = db.readTask(id);
		if (task == null) {
			System.out.println("No task with id " + id);
			return false;
		}
		if (In.getBoolean("Do you want to change the title?")) {
			String title = In.getString("new title?");
			task.setTitle(title);
		}
		if (In.getBoolean("Do you want to change the content?")) {
			String content = In.getString("new content?");
			task.setTitle(content);
		}
		if (In.getBoolean("Do you want to change whether it is completed?")) {
			boolean isCompleted = In.getBoolean("Is completed?");
			task.setCompleted(isCompleted);
		}
		if (db.updateTask(task)) {
			System.out.println("Task updated successfully!");
			return true;
		}
		System.out.println("Error in Database!");
		return false;
	}

	@Override
	public boolean delete() {
		int id = In.getInt("id?");
		Task task = db.readTask(id);
		if (task.getId() != id) {
			System.out.println("No task with id " + id);
			return false;
		}
		if (db.deleteTask(id)) {
			System.out.println("Task deleted successfully!");
			return true;
		}
		System.out.println("Error in Database!");
		return false;
	}

}
