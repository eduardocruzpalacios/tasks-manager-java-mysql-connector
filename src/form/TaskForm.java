package form;

import java.time.LocalDateTime;

import model.Task;
import utilities.In;

public class TaskForm {

	public static Task create() {
		System.out.println("CREATE TASK FORM");
		String title = In.getString("Title:");
		String content = In.getString("Content:");
		boolean isCompleted = In.getBoolean("Is completed:");
		LocalDateTime dateCreated = LocalDateTime.now();
		Task task = new Task(title, content, isCompleted, dateCreated);
		return task;
	}

	public static Task edit(Task task) {
		System.out.println("EDIT TASK FORM");
		if (In.getBoolean("Do you want to change the title?")) {
			String title = In.getString("new title?");
			task.setTitle(title);
		}
		if (In.getBoolean("Do you want to change the content?")) {
			String content = In.getString("new content?");
			task.setContent(content);
		}
		if (In.getBoolean("Do you want to change whether it is completed?")) {
			boolean isCompleted = In.getBoolean("Is completed?");
			task.setCompleted(isCompleted);
		}
		return task;
	}

}
