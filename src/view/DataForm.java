package view;

import java.util.Scanner;

public class DataForm {

	private static Scanner scanner;

	public static String getString(String message) {
		PrintData.string(message);
		scanner = new Scanner(System.in, "ISO-8859-1");
		return scanner.nextLine();
	}

	public static boolean getBooleanByYesNoQuestion(String message) {
		String answer;
		boolean exit = false;
		do {
			answer = getString(message).toLowerCase();
			if (answer.equals("yes") || answer.equals("no")) {
				exit = true;
			}
		} while (!exit);
		if (answer.equals("yes")) {
			return true;
		}
		return false;
	}

	public static int getInt(String message) {
		PrintData.string(message);
		int getInt;
		scanner = new Scanner(System.in);
		while (scanner.hasNextInt() == false) {
			PrintData.string(message);
			scanner.next();
		}
		getInt = scanner.nextInt();
		return getInt;
	}

	public static int getIntBetween(int num1, int num2, String message, String errorMessage) {
		if (num1 == num2) {
			return num1;
		}
		if (num1 > num2) {
			int aux = num1;
			num1 = num2;
			num2 = aux;
		}
		boolean exit = false;
		int getIntBetween = 0;
		while (!exit) {
			getIntBetween = DataForm.getInt(message);
			if (getIntBetween >= num1 && getIntBetween <= num2) {
				exit = true;
			} else {
				PrintData.string(errorMessage);
			}
		}
		return getIntBetween;
	}

	public static void closeScanner() {
		scanner.close();
	}

}
