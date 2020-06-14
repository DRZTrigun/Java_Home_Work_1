package ru.geekbrains.homework_7;

import java.io.*;
/**
 * Рекомендуемое ДЗ:
 * 1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
 * 2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
 *    потом текст из второго в новый файл.
 * 3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово
 *    в файле (работаем только с латиницей).
 * 4. ** Написать метод, проверяющий, есть ли указанное слово в файлах в папке
 * 5. *** Написать метод, добавляющий, указанное слово в файлы в папке
 */

public class MainClass {

    public static void main(String[] args) {

        createFile();
        glueFiles();
        boolean word = scanWord("jaVa");
        System.out.println("Задание №3: проверяем слово 'jaVa' " + word);
        boolean file = scanWordInOtherFile("file");
        System.out.println("Задание №4: проверяем слово 'file' " + file);
        appendWordInOtherFile("Xiaomi");
    }

    public static void createFile() {
        /* 1. Создать 2 текстовых файла, примерно по 50-100 символов
        в каждом (особого значения не имеет); */
        try {
            PrintStream createFile = new PrintStream( new FileOutputStream("CharacterSet.txt"));
            createFile.println("dfgdfsaf   Java fili creation Javafdhgf   hfggdfgJavadftgjfgjf");
            createFile.close();                   // закрываем файл не забываем это делать
        } catch (IOException error) {
            error.printStackTrace();
        }

        try {
            PrintStream lineFileSecond = new PrintStream(new FileOutputStream("AnotherCharacterSet.txt"));
            lineFileSecond.println("Hello world, file creation, dfghdfghdfgdfgdfg Java dfgdfgdfd");
            lineFileSecond.close();    // закрываем файл не забываем это делать
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /* 2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
     *    потом текст из второго в новый файл.*/
    public static void glueFiles() {
        String endLine = "";
        String line;
        String[] files = {"CharacterSet.txt", "AnotherCharacterSet.txt" }; // создал массив файлов
        for (int i = 0; i < files.length; i++){
            try {      // считываю файлы из массива
                File file = new File(files[i]);
                FileReader readFile = new FileReader(file);
                BufferedReader reader = new BufferedReader(readFile);
                line = reader.readLine();
                while (line != null) {
                    endLine = endLine.concat(line);   // перезаписываю строки из файлов в новую строку
                    line = reader.readLine();
                }
                reader.close();              // закрываем reader не забываем это делать
            } catch (IOException error) {
                error.printStackTrace();
            }
        }

        try {     //записываем полученную строку в файл.
            PrintStream lineFile = new PrintStream(new FileOutputStream("NewCharacterSet.txt"));
            lineFile.println(endLine);
            lineFile.close();    // закрываем файл не забываем это делать
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово
     *    в файле (работаем только с латиницей).*/
    public static boolean scanWord(String text){     //передаем проверяющее слово
        String fileLine;
        try {  // считываем данные из файла
            File file = new File("NewCharacterSet.txt");
            FileReader readFile = new FileReader(file);
            BufferedReader reader = new BufferedReader(readFile);
            fileLine = reader.readLine();
            while (fileLine != null){  // прводим строку и проверяемо слово в одному регистру для проверки и проверяем
                if(fileLine.toLowerCase().contains(text.toLowerCase())) {
                    reader.close(); //закрываем reader, чтобы в случае нахождения соответсвия файл был закрыт, а не оставался открытым
                    return true;
                }
                fileLine = reader.readLine();
            }
            reader.close();          // закрываем reader, не забываем это делать, когда прошли весь файл
        } catch(IOException error){
            error.printStackTrace();
        }
        return false;
    }

    /* 4. ** Написать метод, проверяющий, есть ли указанное слово в файлах в папке */
    public static boolean scanWordInOtherFile(String text){
                // создаем массив из всех файлов в корневой папке
        File[] files = new File(".").listFiles();
        for (int i = 0; i < files.length; i++){
            File file = files[i];
            if(file.getName().contains(".txt")){    //проверяем нужные файлы формата .txt
                try {
                    String fileLine;
                    FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fileReader);
                    fileLine = reader.readLine();
                    while (fileLine != null){
                        if (fileLine.contains(text)){   // проверяем есть ли ключевое слово в файле
                            reader.close(); //закрываем reader, чтобы в случае нахождения соответсвия файл был закрыт, а не оставался открытым
                            return true;
                        }
                        fileLine = reader.readLine();
                    }
                    reader.close();       // закрываем reader, не забываем это делать, когда прошли весь файл
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /*5. *** Написать метод, добавляющий, указанное слово в файлы в папке*/
    public static void  appendWordInOtherFile(String text) {
        // создаем массив из всех файлов в корневой папке
        File[] files = new File(".").listFiles();
        for (int i = 0; i < files.length; i++){
            File file = files[i];
            if(file.getName().contains(".txt")){    //проверяем нужные файлы формата .txt
                FileWriter fr = null;
                BufferedWriter br = null;        //создаем буффер
                try {
                    fr = new FileWriter(file, true); // true ставится чтобы не затирались данные в файле
                    br = new BufferedWriter(fr);
                    br.append(text);                   // дописываем слово к файлам формата  .txt
                    br.flush();                       //записываем изменения на диск(в файл)
                } catch (IOException error) {
                    error.printStackTrace();
                } finally {
                    try {
                        if (br != null) {
                            br.close();                  // закрываем буффер не забываем это делать
                        }
                        if(fr != null){
                            fr.close();                  // закрываем файл не забываем это делать
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

