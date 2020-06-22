package ru.geekbrains.homework_lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XoWindow extends JFrame {    // наследование от клсасса JFrame  для создания окна

    private static final int WINDOW_WIDTH = 507;     //   ширина окна
    private static final int WINDOW_HEIGHT = 555;    //   высота окна
    private static final int WINDOW_POS_X = 650;     //   позиционирование окна по Х
    private static final int WINDOW_POS_Y = 250;     //   позиционирование окна по Y
    public XoSettingWindow settingWindow;   // делаем глобальную переменную для вызова настроек игры через кнопку старт
    private XoFieldPanel fieldPanel;

    public XoWindow(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);        // передаем значения в конструктор размеры окна
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);     // передаем значения в конструктор  точку начала окна

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // устанавливааем дефолтное поведение для окна
        setTitle("Крестики - Нолики");               // заполнение верхнего поля
        setResizable(false);                         // запрет на изменение окна

        //передаем ссылку на себя чтобы окно настроек игры знала кто вызвал и куда передавать данные
        this.settingWindow = new XoSettingWindow(this);

        JButton buttonStart = createStartButton ();  // создаем кнопку начала игры из класса J через метод
        JButton buttonExit = createExitButton ();    // создаем кнопку выхода из игры из класса J через метод
        // создаем панель для кнопок, чтобы кнопки не перезатирались
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));

        buttonPanel.add(buttonStart);         // добавили кропку старт в панель
        buttonPanel.add(buttonExit);          // добавили кропку выход в панель
        add(buttonPanel, BorderLayout.SOUTH); // добавили панель в нижнию(South) часть окна

        XoFieldPanel fieldPanel = new XoFieldPanel(); // создание игрвого поля
        add(fieldPanel, BorderLayout.CENTER);         // добавялем игровое поле в окно в центр

        this.fieldPanel = new XoFieldPanel();
        add(fieldPanel, BorderLayout.CENTER);

        // отображение окна в видимости экрана, ставится в конце чтобы скрывало все настройки запуска окна
        setVisible(true);
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        this.fieldPanel.startGame(gameMode, fieldSize, winLength);
    }

    private JButton createStartButton (){
        JButton button = new JButton("Начать игру");     //создаем кнопку "Начать игру"

        //создаем анонимный класс для работы с кнопкой Старт, чтобы не создавать отдельный класс
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                settingWindow.setVisible(true);
            }
        };
        button.addActionListener(listener);
        return button;
    }

    private JButton createExitButton (){
        JButton button = new JButton("Выход");  //создаем кнопку "Выход"
        //создаем анонимный класс для работы с кнопкой Выход, чтобы не создавать отдельный класс
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);    // передаем значение штатного выхода из окна
            }
        });
        return button;
    }

}

