package ru.geekbrains.homework_lesson_8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XoSettingWindow extends JFrame {

    // отдельный класс для настроек игры(не загружаем основной класс игры)

    private static final int WINDOW_WIDTH = 350;                              //   ширина окна настроек игры
    private static final int WINDOW_HEIGHT = 270;                             //   высота окна настроек игры
    private static final int MIN_WIN_LENGTH = 3;                              //   минимальная длина победа в игре
    private static final int MIN_FIELD_SIZE = 3;                              //   минимальный размер поля игры
    private static final int MAX_FIELD_SIZE = 10;                             //   максимальный размер поля игры
    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Длина победы в символах: ";

    private XoWindowNew xoWindowNew;   //ссылка на основное игровое поле, чтобы передать данные о игре в основное окно игры
    private JRadioButton humVSAI;      //кнопка которая говорит или или (в данном случае выбор между АИ и человеком)
    private JRadioButton humVShum;     //кнопка которая говорит или или (в данном случае выбор между АИ и человеком)
    private JSlider slideWinLen;       //кнопка слайдер для выбора длины победы в игре
    private JSlider slideFieldSize;    //кнопка слайдер для выбора размера игрового поля от 3 до 10

    public XoSettingWindow(XoWindowNew xoWindowNew){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.xoWindowNew = xoWindowNew;
        // вычесляем точку по высоте и по ширине для окна настроек чтобы поместить его в центр основного поля
        Rectangle gameWindowBounds = xoWindowNew.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);                     // распологаем окно настроек в чтоке X и Y
        addGameModeButtons();
        addGameControls();

        setTitle("Создать игру");                    // заполнение верхнего поля названием окна
        setResizable(false);                         // запрет на изменение окна настроек
        setLayout(new GridLayout(8,1));

        JButton btnStart = new JButton("Создать новую игру");    // заголовок кнопки
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classStartGame();
            }
        });
        add(btnStart);
    }

    private void addGameModeButtons(){
        JLabel label = new JLabel("Выберите режим");              // заголовок выбора режима
        add(label);
        humVSAI = new JRadioButton("Человек против компьютера");  //кнопка добавляются на текущее окно
        humVShum = new JRadioButton("Человек против человека");   //кнопка добавляются на текущее окно
        //создаем группу для кнопок чтобы они были зависимы друг от друга,
        // т.е. чтобы нельзя было выбрать обе кнопки одновмерменно
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(humVSAI);                                      // добавляем кнопку в группу
        buttonGroup.add(humVShum);                                     // добавляем кнопку в группу
        humVSAI.setSelected(true);                                     // выбираем режим по дефолту
        add(humVSAI);
        add(humVShum);
    }

    private void addGameControls(){
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);  //заголовок для выбора размера поля
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);  //заголовок для выбора длины победы
        // выбираем заранее минимальное значение поля, максимальное значение поля и размер поля по дефолту
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        // выбираем заранее минимальное значение победы, максимальное значение победы(ранвнятеся значению поля)
        // и значение победы по дефолту
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        //создаем ChangeListener для того чтобы считывались измения слайдера для размера поля
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue(); //считываем текущее значение
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);        //меняем значение для максимум длины победы
            }
        });

        //создаем ChangeListener для того чтобы считывались измения слайдера для длины победы
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        //добавляем слайдера в поле настроек
        add(lbFieldSize);
        add(slideFieldSize);
        add(lbWinLength);
        add(slideWinLen);

    }

    private void classStartGame(){
        int gameMod;
        // передача выбранного режима игры против АИ или Человека
        if(humVSAI.isSelected()){
            gameMod = XoFieldPanel.GAME_MODE_HVSAI;
        } else if (humVShum.isSelected()){
            gameMod = XoFieldPanel.GAME_MODE_HVSH;
        } else{
            throw new RuntimeException("Данный режим игры не поддерживается");
        }

        int fieldSize = slideFieldSize.getValue();        //передаем значения длины поля
        int winLenght = slideWinLen.getValue();           //передаем значение длины победы
        xoWindowNew.startGame(gameMod, fieldSize, winLenght);
        setVisible(false);              //закрываем окно настроек после нажатия на кнопку создать игру
    }


}
