package control;

import gui.Menu;
import gui.Window;
import services.TaskServiceImpl;
import utilities.In;

public class Main {

	public static void main(String[] args) {
		TaskServiceImpl taskServiceImpl = new TaskServiceImpl();
		Window.start();
		int option;
		boolean exit = false;
		do {
			taskServiceImpl.findAll();
			Menu.taskManagement();
			option = In.getIntBetween(1, 4, "What do you want to do?", "choose an option between 1 and 4");
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
