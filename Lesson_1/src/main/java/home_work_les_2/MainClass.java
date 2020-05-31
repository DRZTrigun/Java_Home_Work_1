package home_work_les_2;

import java.util.Arrays;

public class MainClass {

    private static void isSetArrayReplace_0_1() {

         /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        System.out.println("Задание 1");

        int[] arrayReplace = new int[10];
        for (int i = 0; i < arrayReplace.length; i++) {                      //заполняем массив рандомно, значениями 0 и 1
            int variable = (int) (Math.random() * 10);
            if (variable < 5) {
                arrayReplace[i] = 0;
            } else {
                arrayReplace[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arrayReplace)); //вывод массива для сверки замены 0 и 1
        for (int i = 0; i < arrayReplace.length; i++) {
            switch (arrayReplace[i]) {
                case 0:
                    arrayReplace[i] = 1;
                    break;    // замена 0 на 1
                case 1:
                    arrayReplace[i] = 0;
                    break;    // замена 1 на 0
            }
        }
        System.out.println(Arrays.toString(arrayReplace));
    }

    private static void isArrayFilling() {
             /*2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
        System.out.println("Задание 2");
        int[] arrayFilling = new int[8];
        for (int i = 0; i < arrayFilling.length; i++) {
            arrayFilling[i] = i * 3;
        }
        System.out.println(Arrays.toString(arrayFilling));
    }

    private static void isArrayWithMultip6() {
        /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        и числа меньшие 6 умножить на 2;*/
        System.out.println("Задание 3");
        int[] arrayMultip = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayMultip));    //вывод массива для сверки циклов
        for (int i = 0; i < arrayMultip.length; i++) {
            if (arrayMultip[i] < 6) {
                arrayMultip[i] = arrayMultip[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arrayMultip));
    }

    private static void isSquareArray() {
    /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
      и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/
        System.out.println("Задание 4");
        int n = 11;
        int[][] squareArrayDiagonalChange = new int[n][n];
        for (int i = 0; i < squareArrayDiagonalChange.length; i++) {
            for (int j = 0; j < squareArrayDiagonalChange.length; j++) {
                if (i == j) {
                    squareArrayDiagonalChange[i][j] = 1;
                } else if (i + j == n - 1) {
                    squareArrayDiagonalChange[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(squareArrayDiagonalChange[i]));
        }
    }

    private static void isArrayFindingMinMax() {
      /*
      5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
      */
        System.out.println("Задание 5");
        int n = 10;
        int Min = Integer.MAX_VALUE;
        int Max = Integer.MIN_VALUE;
        int[] arrayFindingMinMax = new int[n];
        for (int i = 0; i < arrayFindingMinMax.length; i++) {
            arrayFindingMinMax[i] = (int) (Math.random() * 100);
            if (arrayFindingMinMax[i] < Min) {
                Min = arrayFindingMinMax[i];
            } else if (arrayFindingMinMax[i] > Max) {
                Max = arrayFindingMinMax[i];
            }
        }
        System.out.println(Arrays.toString(arrayFindingMinMax));
        System.out.println("Минимальное значение в цикле: " + Min);
        System.out.println("Максимальное значение в цикле: " + Max);
    }

    public static boolean ischeckBalance() {
            /*  6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
           метод должен вернуть true, если в массиве есть место, в котором сумма левой и
           правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) > true,
            checkBalance([1, 1, 1, || 2, 1]) > true, граница показана символами ||,
            эти символы в массив не входят. */
        int[] checkBalance = {1, 5, 6, 0, 2, 1, 3, 0, 4, 2};
        int sumLeft = 0;
        for (int i = 0; i < checkBalance.length; i++) {
            sumLeft = sumLeft + checkBalance[i];
            int sumRight = 0;
            int j = i;
            for (j = i + 1; j < checkBalance.length; j++) {
                sumRight = sumRight + checkBalance[j];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    private static void isArrayOffset() {
           /* 7.1 **** Написать метод, которому на вход подается одномерный массив и число n
      (может быть положительным, или отрицательным),
      при этом метод должен сместить все элементымассива на n позиций. */
        System.out.println("Задание 7.1");
        int[] arrayOffset = {2, 4, 6, 9, 3, 8, 9, 12};
        System.out.println(Arrays.toString(arrayOffset));
        int[] secondArray = new int[arrayOffset.length];
        int n = -3;
        for (int i = 0; i < arrayOffset.length; i++) {
            int k = i + n;
            if (k >= arrayOffset.length) {                  // определяем новое место значения
                k = k - arrayOffset.length;
            } else if (k < 0) {
                k = arrayOffset.length + k;
            }
            for (int j = k; j < arrayOffset.length; j++) {
                secondArray[j] = arrayOffset[i];
                break;
            }
        }
        System.out.println(Arrays.toString(secondArray));
    }

    private static void isArrayOffsetHard() {
           /* 7.2 **** Написать метод, которому на вход подается одномерный массив и число n
      (может быть положительным, или отрицательным),
      при этом метод должен сместить все элементымассива на n позиций.
      Для усложнения задачи нельзя пользоваться вспомогательными массивами. */
        System.out.println("Задание 7.2");
        int[] arrayOffsetHard = {2, 4, 6, 9, 3, 8, 0, 12, 20, 14};
        System.out.println(Arrays.toString(arrayOffsetHard));
        int[] secondArray = new int[arrayOffsetHard.length];
        int n = -4;
        if (n == 0) {
            System.out.println(Arrays.toString(arrayOffsetHard) + " массив не сдвинулся так как сдвиг равен 0");
        } else if (n > 0) {
            for (int i = 0; i < n; i++) {
                int buff = arrayOffsetHard[0];
                arrayOffsetHard[0] = arrayOffsetHard[arrayOffsetHard.length - 1];
                for (int j = 1; j < arrayOffsetHard.length - 1; j++) {
                    arrayOffsetHard[arrayOffsetHard.length - j] = arrayOffsetHard[arrayOffsetHard.length - j - 1];
                }
                arrayOffsetHard[1] = buff;
            }
            System.out.println(Arrays.toString(arrayOffsetHard));
        } else {
            for (int i = 0; i > n; n++) {
                int buff = arrayOffsetHard[arrayOffsetHard.length - 1];
                arrayOffsetHard[arrayOffsetHard.length - 1] = arrayOffsetHard[0];
                for (int j = 1; j < arrayOffsetHard.length; j++) {
                    arrayOffsetHard[j - 1] = arrayOffsetHard[j];
                }
                arrayOffsetHard[arrayOffsetHard.length - 2] = buff;
            }
            System.out.println(Arrays.toString(arrayOffsetHard));
        }
    }

    public static class HomeWork_Lesson2 {

        public static void main(String[] args) {
            isSetArrayReplace_0_1();
            isArrayFilling();
            isArrayWithMultip6();
            isSquareArray();
            isArrayFindingMinMax();
            System.out.println("Задание 6");
            ischeckBalance();
            boolean result = ischeckBalance();
            System.out.println(result);
            isArrayOffset();
            isArrayOffsetHard();
        }
    }
}

