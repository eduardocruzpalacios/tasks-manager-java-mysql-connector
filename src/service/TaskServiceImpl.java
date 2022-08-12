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
		String msg;
		if (db.createTask(task)) {
			msg = "Task created successfully!";
		} else {
			msg = "An error ocurred when creating the task";
		}
		PrintData.str(msg);
	}

	@Override
	public void findAll() {
		List<Task> tasks = db.readTasks();
		PrintData.str("TASK LIST");
		if (tasks.size() == 0) {
			PrintData.tasks(tasks);
		} else {
			PrintData.str("No task found");
		}
	}

	@Override
	public void update() {
		int id = DataForm.getInt("id?");
		Task task = db.readTask(id);
		if (task.getId() != id) {
			PrintData.str("No task with id " + id);
		} else {
			task = TaskForm.edit(task);
			String msg;
			if (db.updateTask(task)) {
				msg = "Task updated successfully!";
			} else {
				msg = "An error ocurred when updating the task";
			}
			PrintData.str(msg);
		}
	}

	@Override
	public void delete() {
		int id = DataForm.getInt("id?");
		Task task = db.readTask(id);
		if (task.getId() != id) {
			PrintData.str("No task with id " + id);
		} else {
			String msg;
			if (db.deleteTask(id)) {
				msg = "Task deleted successfully!";
			} else {
				msg = "An error ocurred when deleting the task";
			}
			PrintData.str(msg);
		}
	}

}
