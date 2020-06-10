package ru.geekbrains.homework_6;

public class Cat extends Animal{

    public static int animalСounterCat;

    public Cat(String name, String color, int youngАge){
        super(name, color, youngАge, 300);

        /*  5. * Добавить подсчет созданных котов, собак и животных. */
        animalСounterCat++;
    }

    public void run(){
    }

    public void jump(){
    }

//    @Override
//    public int maxRun() {
//        return 300;
//    }

    @Override
    public void swim(double maxSwim, double pathLengthSwim, int age){
        System.out.println(name + " не плавает. Кот плывет только тогда, когда иму грозит опастность.");
    }

    @Override
    public void voice(){
        System.out.println(name + " meow");
    }

}
