package com.epam.learn.fundamentals.optional;

import java.util.Scanner;

public class OptionalThird {

/* 3. Ввести n чисел с консоли. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you want to enter?: ");
        double n = scanner.nextInt();
        double averageLength = Math.round(n / 2);
        long[] numbers  = new long[(int) n];
        System.out.printf("Please enter %s numbers separated by whitespace: \n", (int) n);
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            if (getCountsOfDigits(numbers[i]) < averageLength)
            System.out.printf("number: %d, its length: %d.\n", numbers[i], getCountsOfDigits(numbers[i]));
        }
        scanner.close();
    }

    public static int getCountsOfDigits(long number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}
