package Main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;


    public static void main(String[] args) {
        String startMessage;
        startMessage = "Приветсвую!";
        System.out.println(startMessage);
        System.out.println("Ввидите два числа");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];

        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        num1 = romeToNum(stable00);
        num2 = romeToNum(string03);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calkulator(num1, num2, operation);
            System.out.println("Результат римских цифр");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + "  " + operation + "  " + string03 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(string03);
        num2 = Integer.parseInt(string03);
        result = calkulator(num1, num2, operation);
        System.out.println("Результат арабских цифр");
        System.out.println(num1 + " " + operation + " " + num2 + "=" + result);
    }

    private static String convertNumToRoman(int numArab) {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
    };

        final String s = roman[numArab];
        return s;
}
    private static int romeToNum (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неправильный формат данных");
        }
        return -1;
    }

    public static int calkulator (int num1, int num2 , char op) {
    int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Исключение: " + e);
                    System.out.println("Только целое не нулевое число");

                    break;

                }
                break;
            default:
        throw new InputMismatchException("Не верный знак");
        }
    return result;
}
}














