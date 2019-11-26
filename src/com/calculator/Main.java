package com.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел: число арифметическое_действие число (в диапазоне от 1 до 10 включительно) \n и нажмите Enter");
        String[] calcArr = new String[3];
//        Boolean isValidString;
        Boolean isValidArabic = false;
        Boolean isValidRoman = false;

        print(scanner, calcArr, isValidArabic, isValidRoman);



    }

    public static void print(Scanner scanner, String[] calcArr, Boolean isValidArabic, Boolean isValidRoman) {
        try {
            String calcStr = scanner.nextLine();

            if (!Is_valid.inputString(calcStr)) {
                throw new InvalidInputException("Надо вводить число пробел знак пробел число");
            }

            calcArr = NormaliseInput.normalize(calcStr);

            if (!Is_valid.action(calcArr[1])) {
                throw new Exception("Неправильно введен математический знак");
            }

            isValidArabic = Is_valid.arabic(calcArr);
            isValidRoman = Is_valid.roman(calcArr);

        }
        catch (InvalidInputException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        catch(Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        if (isValidArabic) {
            SimpleCalc sCalc = new SimpleCalc();

            int result = sCalc.calc(Integer.parseInt(calcArr[0]), calcArr[1], Integer.parseInt(calcArr[2]));

            System.out.println(result);
        }
        else if (isValidRoman) {
            RomanCalc rCalc = new RomanCalc();

            String result = rCalc.calculate(calcArr[0], calcArr[1], calcArr[2]);

            System.out.println(result);
        }
        else {
            try {
                throw new Exception("Вводить надо либо оба числа арабские, либо оба числа римские в диапазоне от 1 до 10 включительно");
            }
            catch (InvalidInputException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        }
    }
}