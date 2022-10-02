package view;

import java.time.LocalDateTime;

import model.Task;
import model.TaskPrototype;

public class TaskForm {

	public static Task create() {
		PrintData.string("CREATE TASK FORM");
		String title = DataForm.getString("Title:");
		String content = DataForm.getString("Content:");
		boolean isCompleted = DataForm.getBooleanByYesNoQuestion("Is completed:");
		LocalDateTime dateCreated = LocalDateTime.now();
		Task task = new Task(title, content, isCompleted, dateCreated);
		return task;
	}

	public static Task edit(Task task) {
		PrintData.string("EDIT TASK FORM");
		Task taskEdited = TaskPrototype.clone(task);
		if (DataForm.getBooleanByYesNoQuestion("Do you want to change the title?")) {
			String title = DataForm.getString("new title?");
			taskEdited.setTitle(title);
		}
		if (DataForm.getBooleanByYesNoQuestion("Do you want to change the content?")) {
			String content = DataForm.getString("new content?");
			taskEdited.setContent(content);
		}
		if (DataForm.getBooleanByYesNoQuestion("Do you want to change whether it is completed?")) {
			boolean isCompleted = DataForm.getBooleanByYesNoQuestion("Is completed?");
			taskEdited.setCompleted(isCompleted);
		}
		return taskEdited;
	}

}
