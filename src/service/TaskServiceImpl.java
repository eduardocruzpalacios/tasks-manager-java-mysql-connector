package service;

import java.util.List;

import dao.Db;
import model.Task;
import view.DataForm;
import view.PrintData;
import view.TaskForm;

public class TaskServiceImpl implements TaskService {

	Db db = new Db();

	@Override
	public void create() {
		Task task = TaskForm.create();
		String message;
		if (db.createTask(task)) {
			message = "Task created successfully!";
		} else {
			message = "An error ocurred when creating the task";
		}
		PrintData.string(message);
	}

	@Override
	public void findAll() {
		List<Task> tasks = db.readTasks();
		PrintData.string("TASK LIST");
		if (tasks.size() > 0) {
			PrintData.tasks(tasks);
		} else {
			PrintData.string("No task found");
		}
	}

	@Override
	public void update() {
		int id = DataForm.getInt("id?");
		Task task = db.readTask(id);
		if (task.getId() == id) {
			task = TaskForm.edit(task);
			String message;
			if (db.updateTask(task)) {
				message = "Task updated successfully!";
			} else {
				message = "An error ocurred when updating the task";
			}
			PrintData.string(message);
		} else {
			PrintData.string("No task with id " + id);
		}
	}

	@Override
	public void delete() {
		int id = DataForm.getInt("id?");
		Task task = db.readTask(id);
		if (task.getId() == id) {
			String message;
			if (db.deleteTask(id)) {
				message = "Task deleted successfully!";
			} else {
				message = "An error ocurred when deleting the task";
			}
			PrintData.string(message);
		} else {
			PrintData.string("No task with id " + id);
		}
	}

}
