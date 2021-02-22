package collections.optional;

import java.util.Scanner;
import java.util.Stack;

// 2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

public class CollectionsSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number:");
        int number = scanner.nextInt();
        Stack<Integer> stackOfDigits = new Stack<>();
        int base = 10;
        int indicator = getCountOfDigits(number);
        while (indicator != 0) {
            stackOfDigits.push((int) (number / Math.pow(base, --indicator) % base));
        }
        while (!stackOfDigits.empty()) {
            System.out.print(stackOfDigits.pop());
        }
    }

    public static int getCountOfDigits(int number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}
