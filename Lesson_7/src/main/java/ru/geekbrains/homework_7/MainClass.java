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
        System.out.println(word);
        boolean file = scanWordInOtherFile("file");
        System.out.println(file);
        appendWordInOtherFile();
    }

    public static void createFile() {
        /* 1. Создать 2 текстовых файла, примерно по 50-100 символов
        в каждом (особого значения не имеет); */
        try {
            PrintStream createFile = new PrintStream( new FileOutputStream("CharacterSet.txt"));
            // true ставится чтобы не затирались данные в файле
            createFile.println("dfgdfsaf   Java fili creation Javafdhgf   hfggdfgJavadftgjfgjf");
            createFile.close();
        } catch (IOException error) {
            error.printStackTrace();
        }

        try {
            // true ставится чтобы не затирались данные в файле
            PrintStream lineFileSecond = new PrintStream(new FileOutputStream("AnotherCharacterSet.txt"));
            lineFileSecond.println("Hello world, file creation, dfghdfghdfgdfgdfg Java dfgdfgdfd");
            lineFileSecond.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /* 2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
     *    потом текст из второго в новый файл.*/
    public static void glueFiles() {
        String endLine = "";
        String line;
        String[] files = {"CharacterSet.txt", "AnotherCharacterSet.txt" };
        for (int i = 0; i < files.length; i++){
            try {      // считываю файлы
                File file = new File(files[i]);
                FileReader readFile = new FileReader(file);
                BufferedReader reader = new BufferedReader(readFile);
                line = reader.readLine();
                while (line != null) {
                    endLine = endLine.concat(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }

        try {     //записываем полученную строку в файл.
            PrintStream lineFile = new PrintStream(new FileOutputStream("NewCharacterSet.txt"));
            lineFile.println(endLine);
            lineFile.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово
     *    в файле (работаем только с латиницей).*/
    public static boolean scanWord(String text){
        String fileLine;
        try {
            File file = new File("NewCharacterSet.txt");
            FileReader readFile = new FileReader(file);
            BufferedReader reader = new BufferedReader(readFile);
            fileLine = reader.readLine();
            while (fileLine != null){
                if(fileLine.toLowerCase().contains(text.toLowerCase())) {
                    reader.close();
                    return true;
                }
                fileLine = reader.readLine();
            }
            reader.close();
        } catch(IOException error){
            error.printStackTrace();
        }
        return false;
    }

    /* 4. ** Написать метод, проверяющий, есть ли указанное слово в файлах в папке */
    public static boolean scanWordInOtherFile(String text){

        File[] files = new File(".").listFiles();
        for (int i = 0; i < files.length; i++){
            File file = files[i];
            if(file.getName().contains(".txt")){
                try {
                    String fileLine;
                    FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fileReader);
                    fileLine = reader.readLine();
                    while (fileLine != null){
                        if (fileLine.contains(text)){
                            reader.close();
                            return true;
                        }
                        fileLine = reader.readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /*5. *** Написать метод, добавляющий, указанное слово в файлы в папке*/
    public static void  appendWordInOtherFile() {

        File[] files = new File(".").listFiles();
        for (int i = 0; i < files.length; i++){
            File file = files[i];
            if(file.getName().contains(".txt")){
                FileWriter fr = null;
                BufferedWriter br = null;
                try {
                    fr = new FileWriter(file, true);
                    br = new BufferedWriter(fr);
                    br.append("Xiaomi");
                } catch (IOException error) {
                    error.printStackTrace();
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                        if(fr != null){
                            fr.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

