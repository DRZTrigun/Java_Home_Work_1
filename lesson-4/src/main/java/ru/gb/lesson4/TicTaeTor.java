package ru.gb.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTaeTor {

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final char DOT_HUMAN = 'x';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = ' ';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();


    public static void main (String[] args) {

        /* Задаем параметры игры */
        System.out.println("Задайте размер игрового поля");
        int fieldSize = SCANNER.nextInt();
        fieldSizeX = fieldSize;
        int elemetField;
        do {
            System.out.println("Задйте услвоия победы, сколько нужно элемнтов подряд" +
                    "(кол-во элментов не должно превышать размер поля!):");
            elemetField = SCANNER.nextInt();
            fieldSizeY = elemetField;
        } while (fieldSize < elemetField);

        while (true) {
            init(fieldSize);
            printField();
            playOnce();
            System.out.println("Играть сначала?");
            if (SCANNER.next().equals("no")) {
                break;
            }
        }
    }

    /* playOnce, тело игра */
    private static void playOnce(){
        while(true){
            humanTrun();
            printField();
            if (checkWin(DOT_HUMAN)){
                System.out.println("Победил игрок!");
                break;
            }
            if (isDraw()){
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)){
                System.out.println("Победил компьтюер!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    /*initField создаем поле и заполняем его */
    private static void init(int fieldSize){

        field = new char[fieldSizeX][fieldSizeX];

        for (int y = 0; y < fieldSizeX; y++){
            for (int x = 0; x < fieldSizeX; x++){
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /*printField выводим поле*/
    private static void printField(){
        System.out.println("===============");

        for (int y = 0; y < fieldSizeX; y++){
            System.out.print("| ");
            for (int x = 0; x < fieldSizeX; x++){
                System.out.print(field[y][x] + " | ");
            }
            System.out.println();
        }
    }

    /* isValidField, Проврека, что ячейка находится в допустимом диапазоне */
    private static boolean isEmptyField(int x, int y){
        return  x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeX;
    }

    /* isNotEmpteField
     Проврека, что поле занято (знак в поле не соответствует DOT_EMPTY) */
    private static boolean isValidField(int x, int y){
        return field[x][y] != DOT_EMPTY;
    }

    /* correctCellNumber, проверяем ячейку на правильность ввода */
    private static boolean correctCellNumber(int cell){
        if (cell < fieldSizeX * fieldSizeX ){
            return true;
        }
        System.out.println("Введный номер ячейки несуществует!!!");
        return false;
    }
    /* humanTrun ход игрока */
    private static void humanTrun(){

        int x;
        int y;
        do{
            System.out.println("Введите номер ячейки: ");
            int cell = SCANNER.nextInt();
            correctCellNumber(cell);
            if (cell % fieldSizeX == 0) {    //определяем индексы ячейки х и y
                x = (cell - 1) / fieldSizeX;
                y = (cell - 1) % fieldSizeX;
            } else {
                x = cell / fieldSizeX;
                y = (cell % fieldSizeX) - 1;
            }
        } while ( !isEmptyField(x, y) || isValidField(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /* aiTurn ход компьютера */
    private static void aiTurn(){

        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeX);
        } while (isValidField(x, y));
        field[x][y] = DOT_AI;
    }

    /* isDraw проверка игры на ничью */
    private static boolean isDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeX; y++){
                if (field[x][y] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

        /* checkWin проверка на победу для игры с заданным полем 3х3 */
    private static boolean checkWin(char symb){

        boolean line, column;
        for (int y = 0; y < fieldSizeX; y++){
            line = true;
            column = true;
            for (int x = 0; x < fieldSizeX; x++){
                column = column & (field[y][x] == symb);
                line = line & (field[x][y] == symb);
            }
            if (column || line) return true;
        }
        boolean doiganalLeft = true;
        boolean doiganalRight = true;
        for (int x = 0; x < fieldSizeX; x++){
            doiganalLeft = doiganalLeft & (field[x][x] == symb);
            doiganalRight = doiganalRight & (field[fieldSizeX - x - 1][x] == symb);
        }
        if (doiganalLeft || doiganalRight) return true;
        return false;
    }


    /* Для поля 5х5 и 4 фишки подряд, не хватило вренмени доделать диоганаль.
    Почемуто выдает сразу победу когда ввожу один элемент, проблема именно в диогонале, проверял без нее то все работает.
     */

//    /* checkWin проверка игры для любого поля */
//    private static boolean checkWin (char symb){
//        for (int col = 0; col < fieldSizeX - fieldSizeY + 1; col++ ){
//            for (int row = 0; row < fieldSizeX - fieldSizeY + 1; row++ ){
//                if(checkDiaganal(symb, col, row) || checkCowAndColumn(symb, col, row)) return true;
//            }
//        }
//        return false;
//    }
//
//    /* checkDiaganal Проверяем диагонали */
//    private static boolean checkDiaganal(char symb, int fieldSizeX, int fieldSizeY) {
//        boolean doiganalLeft = true;
//        boolean doiganalRight = true;
//        for (int i = 0; i < fieldSizeY; i++){
//            doiganalRight = doiganalRight && (field[i + fieldSizeX][i + fieldSizeY] == symb);
//            doiganalLeft &= (field[fieldSizeX - i - 1 + fieldSizeX][i + fieldSizeY] == symb);
//        }
//        if (doiganalLeft || doiganalRight) return true;
//
//        return false;
//    }
//
//    /* checkCowAndColumn Проверяем горизонтальные и вертикальные линии */
//    private static boolean checkCowAndColumn(char symb , int x, int y) {
//        boolean line, column;
//        for (int col = x; col < fieldSizeY + x; col++) {
//            line = true;
//            column = true;
//            for (int row = y; row < fieldSizeY + y; row++) {
//                column &= (field[col][row] == symb);
//                line &= (field[row][col] == symb);
//            }
//            if (column || line) return true;
//        }
//        return false;
//    }
//
    /* Для улучшения АИ, берется метод на победу в игре, и уменьшется на один элемент условия проврки победы,
    после чего, АИ ставит фишку в начале или конце 3 фишек игрока.
     Далее данный метод вкладывается в ход АИ, можно сделать услвие чтобы проверка тока начаналась с 3 хода АИ,
     чтобы не прогонять лишний раз метод */

}