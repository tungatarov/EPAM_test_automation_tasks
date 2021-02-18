package fundamentals.main;

import java.util.Scanner;

class First {

/* 1. Приветствовать любого пользователя при вводе его имени через командную строку. */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, enter your name: ");
		String name = scanner.next();
		System.out.println("Welcome, " + name);
	}
}