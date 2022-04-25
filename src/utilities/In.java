package utilities;

import java.util.Scanner;

public class In {

	private static Scanner scanner;

	public static String getString(String message) {
		System.out.println(message);
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static boolean getBoolean(String message) {
		String answer;
		boolean exit = false;
		do {
			answer = getString(message).toLowerCase();
			if (answer.equals("yes") || answer.equals("no")) {
				exit = true;
			}
		} while (!exit);
		if (answer.equals("yes") || answer.equals("no")) {
			return true;
		} else {
			return false;
		}
	}

}
