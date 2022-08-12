package view;

import java.time.LocalDateTime;

import model.Task;

public class TaskForm {

	public static Task create() {
		System.out.println("CREATE TASK FORM");
		String title = DataForm.getString("Title:");
		String content = DataForm.getString("Content:");
		boolean isCompleted = DataForm.getBoolean("Is completed:");
		LocalDateTime dateCreated = LocalDateTime.now();
		Task task = new Task(title, content, isCompleted, dateCreated);
		return task;
	}

	public static Task edit(Task task) {
		System.out.println("EDIT TASK FORM");
		if (DataForm.getBoolean("Do you want to change the title?")) {
			String title = DataForm.getString("new title?");
			task.setTitle(title);
		}
		if (DataForm.getBoolean("Do you want to change the content?")) {
			String content = DataForm.getString("new content?");
			task.setContent(content);
		}
		if (DataForm.getBoolean("Do you want to change whether it is completed?")) {
			boolean isCompleted = DataForm.getBoolean("Is completed?");
			task.setCompleted(isCompleted);
		}
		return task;
	}

}
