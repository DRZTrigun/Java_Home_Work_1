package Home_Work_Lesson_1;

import java.util.Scanner;

public class MainClass {
    byte bt = 127;
    short s = 32767;
    int i = 400000;
    long l = 456464566;
    char ch = '1';
    boolean bool = true;
    String str;

    private static double third(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean fourth(int x, int y) {
        if (x + y >= 10 && x + y <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void fifth(int t) {
        if (t >= 0) {
            System.out.println("Переданное число положительное " + t);
        } else {
            System.out.println("Переданное число отрицательное " + t);
        }
    }

    private static boolean sixth(int z) {
        return z < 0;
    }

    private static void seventh (String fname) {
        System.out.println("Привет, " + fname);
    }

    private static void eighth(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " високосный год");
        } else {
            if (year % 400 == 0) {
                System.out.println(year + " високосный год");
            } else {
                System.out.println(year + " не високосный год");
            }
        }
    }
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание номер 3, вычесилте выражение: a * (b + (c / d))");
        System.out.println("Введите занчения a, b, c, d через пробел в строчку (можно дробные значения, но через запятую!)");
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();
        float d = scanner.nextFloat();
        third(a, b, c, d);
        System.out.println("Ответ: " + third(a, b, c, d));

        System.out.println("Задание номер 4, сумма x и y лежит в пределах от 10 до 20(включительно)");
        System.out.println("Введите занчения x и y (целые числа) через пробел в строчку");
        int x =  scanner.nextInt();
        int y = scanner.nextInt();
        fourth(x, y);
        System.out.println(fourth(x, y));

        System.out.println("Задание номер 5");
        System.out.println("Введите целое положительное или отрицательное число");
        int t = scanner.nextInt();
        fifth(t);

        System.out.println("Задание номер 6, введеное число отрицательное?");
        System.out.println("Введите отрицательное число");
        int z = scanner.nextInt();
        sixth(z);
        System.out.println(sixth(z));

        String fname = scanner.nextLine();
        System.out.println("Задание номер 7, вывести сообщение «Привет, указанное имя!»");
        System.out.println("Введите свое Имя");
        fname = scanner.nextLine();
        seventh(fname);

        System.out.println("Задание номер 8, определить является ли год високосным");
        System.out.println("Введите любой год");
        int year = scanner.nextInt();
        eighth(year);
    }
}