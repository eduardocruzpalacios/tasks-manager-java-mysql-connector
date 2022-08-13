package view;

import java.util.List;

import model.Task;

public class PrintData {

	public static void string(String string) {
		System.out.println(string);
	}

	public static void tasks(List<Task> tasks) {
		tasks.forEach(e -> {
			System.out.println(e);
		});
	}

}
