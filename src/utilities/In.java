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

	public static int getInt(String message) {
		System.out.println(message);
		int getInt;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt() == false) {
			System.out.println(message);
			scanner.next();
		}
		getInt = scanner.nextInt();
		scanner.close();
		return getInt;
	}

	public static int getIntBetween(int num1, int num2, String message, String error) {
		boolean exit = false;
		int getIntBetween = 0;
		while (!exit) {
			getIntBetween = In.getInt(message);
			if (getIntBetween >= num1 && getIntBetween <= num2) {
				exit = true;
			} else {
				System.out.println(error);
			}
		}
		return getIntBetween;
	}

}
