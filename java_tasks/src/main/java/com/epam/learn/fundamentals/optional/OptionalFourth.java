package com.epam.learn.fundamentals.optional;

import java.util.Scanner;

class OptionalFourth {

/* 4. Ввести n чисел с консоли. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you want to enter?: ");
        int n = scanner.nextInt();
        long[] numbers  = new long[n];
        System.out.printf("Please enter %s numbers separated by whitespace: \n", n);
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        long min = numbers[0];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (getCountsOfDigits(min) > getCountsOfDigits(numbers[j + 1])) {
                    min = numbers[j + 1];
                }
            }
        } 
        System.out.println(min);
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