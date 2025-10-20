package Day2Coding;

import java.util.Scanner;

public class CodingChallenges {

    public static int reverseNumber(int n) {
        boolean isNegative = n < 0;
        n = Math.abs(n);

        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return isNegative ? -reversed : reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer to reverse: ");
        int input = scanner.nextInt();

        int result = reverseNumber(input);
        System.out.println("Reversed number: " + result);
    }
}
