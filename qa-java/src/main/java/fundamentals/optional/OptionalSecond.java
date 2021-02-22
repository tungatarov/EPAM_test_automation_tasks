package fundamentals.optional;

import java.util.Scanner;

class OptionalSecond {

/* 2. Ввести n чисел с консоли. Вывести числа в порядке возрастания (убывания) значений их длины. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you want to enter?: ");
        int n = scanner.nextInt();
        long[] numbers  = new long[n];
        System.out.printf("Please enter %s numbers separated by whitespace: \n", n);
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (getCountsOfDigits(numbers[j]) > getCountsOfDigits(numbers[j + 1])) {
                    long saved = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = saved;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
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