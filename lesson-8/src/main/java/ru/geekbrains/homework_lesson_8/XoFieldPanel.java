package ru.geekbrains.homework_lesson_8;

import javax.swing.*;
import java.awt.*;

public class XoFieldPanel extends JPanel {

    public static final int GAME_MODE_HVSAI = 0;  // статическиая переменная для режима игры
    public static final int GAME_MODE_HVSH = 1;   // статическиая переменная для режима игры

    public XoFieldPanel(){
        setBackground(Color.LIGHT_GRAY);    // выбираем цвет игорового поля
    }

    public void startGame (int gameMode, int fieldSize, int winLenght){
        //%d для пееревода в десятичную систему, %n равносильно \n для переноса на следующую строку
        System.out.printf("Game mod: %d%n Field size: %d%n Win lenght: %d%n", gameMode, fieldSize, winLenght);


        setVisible(true);
    }
}
