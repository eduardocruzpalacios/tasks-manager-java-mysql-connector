package controller;

import service.TaskServiceImpl;
import view.DataForm;
import view.Menu;
import view.Window;

public class TasksManagerController {

	public static void run() {
		TaskServiceImpl taskServiceImpl = new TaskServiceImpl();
		Window.start();
		int option;
		boolean exit = false;
		do {
			taskServiceImpl.findAll();
			Menu.taskManagement();
			option = DataForm.getIntBetween(1, 4, "What do you want to do?", "choose an option between 1 and 4");
			switch (option) {
			case 1:
				taskServiceImpl.create();
				break;
			case 2:
				taskServiceImpl.update();
				break;
			case 3:
				taskServiceImpl.delete();
				break;
			case 4:
				exit = true;
				break;
			}
		} while (!exit);
		Window.exit();
	}

}
