package ru.geekbrains.homework_6;

public class Bird extends Animal {

    public static int animalСounterBird;

    public Bird(String name, String color, int youngАge, int maxRun){
        super(name, color, youngАge, maxRun);

        /*  5. * Добавить подсчет созданных котов, собак и животных. */
        animalСounterBird++;
    }

    public void run(){
    }

    public void jump(){
    }

    @Override
    public void swim(double maxSwim, double pathLengthSwim, int age){
        System.out.println(name + " не умеет плавать.");
    }

    @Override
    public void voice(){
        System.out.println(name + " tweet");
    }
}
