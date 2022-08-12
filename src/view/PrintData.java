package view;

import java.util.List;

import model.Task;

public class PrintData {

	public static void str(String msg) {
		System.out.println(msg);
	}

	public static void tasks(List<Task> tasks) {
		tasks.forEach(e -> {
			System.out.println(e);
		});
	}

}
