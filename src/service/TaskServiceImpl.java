package service;

import java.util.List;

import dao.Db;
import model.Task;
import view.DataForm;
import view.TaskForm;

public class TaskServiceImpl implements TaskService {

	Db db = new Db();

	@Override
	public void create() {
		Task task = TaskForm.create();
		if (db.createTask(task)) {
			System.out.println("Task created successfully!");
		}
	}

	@Override
	public void findAll() {
		List<Task> tasks = db.readTasks();
		System.out.println("TASK LIST");
		if (tasks != null) {
			tasks.forEach(e -> {
				System.out.println(e);
			});
		}
	}

	@Override
	public void update() {
		int id = DataForm.getInt("id?");
		Task task = db.readTask(id);
		if (task.getId() != id) {
			System.out.println("No task with id " + id);
		}
		task = TaskForm.edit(task);
		if (db.updateTask(task)) {
			System.out.println("Task updated successfully!");
		}
	}

	@Override
	public void delete() {
		int id = DataForm.getInt("id?");
		Task task = db.readTask(id);
		if (task.getId() != id) {
			System.out.println("No task with id " + id);
		}
		if (db.deleteTask(id)) {
			System.out.println("Task deleted successfully!");
		}
	}

}
