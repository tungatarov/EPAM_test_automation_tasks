package fundamentals;

import java.util.Random;
import java.util.Scanner;

class MainFundamentals {


	private final Random random = new Random(5);


	/* 1. Приветствовать любого пользователя при вводе его имени через командную строку. */

	public void greetUserEnteringNameViaCli() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, enter your name: ");
		String name = scanner.next();
		System.out.println("Welcome, " + name + "!");
		scanner.close();
	}

	/* 2. Отобразить в окне консоли аргументы командной строки в обратном порядке. */

	public void printCliArgumentsInReverseOrder(String[] args) {
		for (int i = args.length - 1; i >= 0; i--) {
			System.out.print(i != 0 ? args[i] + " " : args[i]);
		}
	}

	/* 3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку */

	public void printRandomNumbersWithAndWithoutNewLine() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, enter the number of random numbers: ");
		final int n = scanner.nextInt();
		int[] randomNumbers = new int[n];
		for (int i = 0; i < n; i++) {
			randomNumbers[i] = 1 + random.nextInt(9);
		}
		scanner.close();
		System.out.println("Random numbers with the transition to a new line: ");
		for (int i = 0; i < n; i++) {
			System.out.println(randomNumbers[i]);
		}
		System.out.println("Random numbers without a line break: ");
		for (int i = 0; i < n; i++) {
			System.out.print(randomNumbers[i] + " ");
		}
	}

	/* 4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль. */

	public void printSumAndCompositionOfCliArgs(String[] args) {
		int sum = 0;
		int com = 1;
		for (int i = 0; i < args.length; i++) {
			sum += Integer.parseInt(args[i]);
			com *= Integer.parseInt(args[i]);
		}
		System.out.println("sum: " + sum);
		System.out.println("composition: "+ com);
	}

	/* 5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел. */

	public void printNameOfMonthCorrespondingToSpecifiedDate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, enter a number from 1 to 12: ");
		switch (scanner.nextInt()) {
			case 1:
				System.out.print("January");
				break;
			case 2:
				System.out.print("February");
				break;
			case 3:
				System.out.print("March");
				break;
			case 4:
				System.out.print("April");
				break;
			case 5:
				System.out.print("May");
				break;
			case 6:
				System.out.print("June");
				break;
			case 7:
				System.out.print("July");
				break;
			case 8:
				System.out.print("August");
				break;
			case 9:
				System.out.print("September");
				break;
			case 10:
				System.out.print("October");
				break;
			case 11:
				System.out.print("November");
				break;
			case 12:
				System.out.print("December");
				break;
			default:
				System.out.println("Wrong number. Please enter the date corresponding to the month of the year.");
		}
	}
}