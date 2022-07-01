package form;

import java.time.LocalDateTime;

import model.Task;
import utilities.In;

public class TaskForm {

	public static Task createTask() {
		System.out.println("CREATE TASK FORM");
		String title = In.getString("Title:");
		String content = In.getString("Content:");
		boolean isCompleted = In.getBoolean("Is completed:");
		LocalDateTime dateCreated = LocalDateTime.now();
		Task task = new Task(title, content, isCompleted, dateCreated);
		return task;
	}

}
