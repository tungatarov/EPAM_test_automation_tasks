package com.epam.learn.fundamentals.main;

import java.util.Scanner;

class Third {

	/* 3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, enter the number of random numbers: ");
		final int n = scanner.nextInt();
		int[] randomNumbers = new int[n];
		for (int i = 0; i < n; i++) {
			randomNumbers[i] = (int) (Math.random() * 10);
		}
		System.out.println("\nRandom numbers with the transition to a new line: ");
		for (int i = 0; i < n; i++) {
			System.out.println(randomNumbers[i]);
		}
		System.out.println("Random numbers without a line break: ");
		for (int i = 0; i < n; i++) {
			System.out.print(randomNumbers[i] + " ");
		}
	}
}