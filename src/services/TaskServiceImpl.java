package services;

import java.time.LocalDateTime;

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
		} else {
			System.out.println("Error!");
			return false;
		}
	}

}
