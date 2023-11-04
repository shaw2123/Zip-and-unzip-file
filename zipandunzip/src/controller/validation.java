package controller;

import java.util.Scanner;

public class validation {

    public int checkIntLimit(int min, int max) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new IllegalArgumentException("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public String checkString() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.nextLine().trim();
            if (str.isEmpty()) {
                System.err.println("Input cannot be empty. Please enter a valid value.");
            } else {
                return str;
            }
        }
    }
}
