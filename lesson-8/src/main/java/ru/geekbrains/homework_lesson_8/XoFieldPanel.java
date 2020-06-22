package ru.geekbrains.homework_lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class XoFieldPanel extends JPanel {

    private XoController controller;         // ссылка на контреллер

    private static final int IN_FIELD_DOT_PADDING = 5;  //отступ символа от границ

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";

    private int fieldSize;                   // размер поля
    private int fieldWidth;                  // ширина поля
    private int fieldHeight;                 // высота поля
    private int cellWidth;                   // ширина ячейки
    private int cellHeight;                  // высота ячейки

    public XoFieldPanel(){
        // панелька связанна с логикой игры крестики нолики(контроллером) и говорит когда надо перерисовать панельку
        this.controller = new XoController(this);
        //setBackground(Color.LIGHT_GRAY);                // выбираем цвет игорового поля
        addMouseListener(new MouseAdapter() {   //создаем слушателя, т.е. ждем какое-то событие пр. нажатие кнопки мыши
            @Override
            public void mouseReleased(MouseEvent e) {  //событие происходит тогда когда отпускаем кнопку мыши!!!
                super.mouseReleased(e);
                System.out.printf("Mouse button %s was clicked at X=%d, Y=%d%n", e.getButton(), e.getX(), e.getY());
                update(e);
            }
        });
    }

    public void startGame (int gameMode, int fieldSize, int winLength){
        //%d для пееревода в десятичную систему, %n равносильно \n для переноса на следующую строку
        //System.out.printf("Game mod: %d%n Field size: %d%n Win lenght: %d%n", gameMode, fieldSize, winLenght);
        this.fieldWidth = getWidth();                         // получение ширины поля
        this.fieldHeight = getHeight();                      // получение высоты поля
        this.cellWidth = this.fieldWidth / fieldSize;         // получение ширины ячейки
        this.cellHeight = this.fieldHeight / fieldSize;       // получение высоты ячейки
        this.fieldSize = fieldSize;                           // получение размера поля
        controller.initialize(gameMode, fieldSize, winLength);
    }

    // метод который высчитывает номер ячейки
    private void update(MouseEvent e) {
        if (!controller.isGameActive()) return;  //проверка что игра не стартанула
        if (controller.isGameOver()) return;     //проверка окончания игры
        int cellX = e.getX() / cellWidth;      //делим координату точки по X (куда нажали на поле)
        int cellY = e.getY() / cellHeight;     //делим координату точки по Y (куда нажали на поле)
        controller.processMove(cellX, cellY);  // переадресовываем информацию в контреллер
        repaint();                             //перерисовываем панельку
    }

    // метод который перерисовывает компонент(всегда вызывается если надо перерисовать какой-то компонент)
    // вызывается платформой
    @Override
    protected void paintComponent(Graphics g){ // Graphics - это объект который создается для всех элементов
        // для всех классов которые могут как либо менять свою графику
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g){
        if (!controller.isGameActive()) return;         // проверка активности игры
        g.setColor(Color.BLACK);                         //все чертиться черным цветом(цвет можно задать)
        for (int i = 0; i < fieldSize; i++) {            //чертим поле с помощью горизонтальных и вертикальных линий
            int x = i * cellWidth;                       // в зависимости от размера поля
            g.drawLine(x, 0, x, this.fieldHeight);
            int y = i * cellHeight;
            g.drawLine(0, y, this.fieldWidth, y);
        }

        int[][] field = controller.getField();         //получили наше поле

        for (int y = 0; y < fieldSize; y++) {          // идем по всему полю
            for (int x = 0; x < fieldSize; x++) {
                if (controller.isEmptyCell(x, y)) continue;//проверяем свободна ли ячейка, если да то ни чего не делаем

                if (field[y][x] == XoConstants.DOT_O) {    //проверяем стоит ли нолик в ячеке
                    g.setColor(new Color(1, 1, 255));    // задаем цвет нолика
                    g.drawOval(x * cellWidth + IN_FIELD_DOT_PADDING,      //рисуем овал в цетре ячейки
                            y * cellHeight + IN_FIELD_DOT_PADDING,
                            cellWidth - IN_FIELD_DOT_PADDING * 2,
                            cellHeight - IN_FIELD_DOT_PADDING * 2);

                } else if (field[y][x] == XoConstants.DOT_X) { //если стоит крестик
                    g.setColor(new Color(255, 0 ,0)); //задаем цвет крестика
                    /* Отрисовка линии \ */
                    g.drawLine(x * cellWidth + IN_FIELD_DOT_PADDING, //рисуем диоганаль слева на право свреху вниз
                            y * cellHeight + IN_FIELD_DOT_PADDING,
                            (x + 1) * cellWidth - IN_FIELD_DOT_PADDING,
                            (y + 1) * cellHeight - IN_FIELD_DOT_PADDING);
                    /* Отрисовка линии / */
                    g.drawLine((x + 1) * cellWidth - IN_FIELD_DOT_PADDING,//рисуем диоганаль справа на лево свреху вниз
                            y * cellHeight + IN_FIELD_DOT_PADDING,
                            x * cellWidth + IN_FIELD_DOT_PADDING,
                            (y + 1) * cellHeight - IN_FIELD_DOT_PADDING);
                } else {
                    throw new RuntimeException(           //исключения если что-то пошло не так
                            String.format("Can't recognize cell field[%d][%d]: %d", y, x, field[y][x]));
                }
            }
        }
        if (controller.isGameOver()) {        // условие если игра окончена то отрисуй кто победил
            showMessageGameOver(g);
        }
    }
    private void showMessageGameOver(Graphics g) {  //метод по выводу сообщения кто победил
        g.setColor(new Color(211,211, 211));  //устанавливаем цвет поля сообщения
        g.fillRect(0, 200, getWidth(), 70);  //рисуем прямоуголное поле по середине игрового поля
        g.setColor(new Color(255,165,0));    //устанавливаем цвет
        g.setFont(new Font("Times new roman", Font.BOLD, 48));  //устанавливаем шрифт сообщения и размер
        switch (controller.getStateGameOver()) {      //выводим сообщения кто победил или ничья
            case XoConstants.STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2); // drawString рисует текст,
                break;                                             //далее размеры отступа поля сообщения и середина
            case XoConstants.STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            case XoConstants.STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + controller.getStateGameOver());
        }
    }
}
