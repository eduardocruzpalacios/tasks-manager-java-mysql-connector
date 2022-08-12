package service;

import java.util.List;

import dao.Db;
import model.Task;
import view.In;
import view.TaskForm;

public class TaskServiceImpl implements TaskService {

	Db db = new Db();

	@Override
	public boolean create() {
		Task task = TaskForm.create();
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
		if (task.getId() != id) {
			System.out.println("No task with id " + id);
			return false;
		}
		task = TaskForm.edit(task);
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
