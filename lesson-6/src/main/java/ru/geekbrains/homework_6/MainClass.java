package ru.geekbrains.homework_6;

/* 1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
   2. Животные могут выполнять действия: бежать, плыть и прыгать.
   В качестве параметра каждому методу передается величина, обозначающая или длину (для бега и плавания),
   или высоту (для прыжков).
   3. У каждого животного есть ограничения на действия: бег: кот = 200 м., собака = 500 м., лошадь = 1500 м, птица = 5 м;
   плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.
   прыжок: кот = 2 м., собака 0.4 м., лошадь 3 м., птица 0.1 м.
   4. При попытке выполнить одно из действий, оно должно сообщить результат: смогло или нет животное выполнить действие,
    например, dog.run(150); -> результат 'Пес пробежал!';
   5. * Добавить подсчет созданных котов, собак и животных.
   6. * Добавить животным разброс в ограничениях. То есть у одной собаки может быть ограничение на бег 400 м.,
    у другой 600 м..
 */

public class MainClass {

    public static void main (String[] args){

        Dog dog1 = new Dog("Pit", "White", 8, 500);
        Dog dog2 = new Dog("Jack", "Brown", 8,500);
        Horse horse1 = new Horse("Avgust","Brown", 12,1500);
        Horse horse2 = new Horse("Verba","White and Black", 12, 1500);
        Bird bird1 = new Bird("Kesha","Green", 4, 5);
        Bird bird2 = new Bird("Socrat","Blue and Red",4, 5);
        Cat cat1 = new Cat("Semen", "Black", 8);
        Cat cat2 = new Cat("Simka", "White and Brown", 8);

//        System.out.println("Animal " + dog1.name + " of color " + dog1.color + " age " + dog1.age);
//        System.out.println("Animal " + dog2.name + " of color " + dog2.color + " age " + dog2.age);
//        System.out.println("Animal " + horse1.name + " of color " + horse1.color + " age " + horse1.age);
//        System.out.println("Animal " + horse2.name + " of color " + horse2.color + " age " + horse2.age);
//        System.out.println("Animal " + bird1.name + " of color " + bird1.color + " age " + bird1.age);
//        System.out.println("Animal " + bird2.name + " of color " + bird2.color + " age " + bird2.age);
//        System.out.println("Animal " + cat1.name + " of color " + cat1.color + " age " + cat1.age);
//        System.out.println("Animal " + cat2.name + " of color " + cat2.color + " age " + cat2.age);


  /*  У каждого животного есть ограничения на действия: бег: кот = 200 м., собака = 500 м., лошадь = 1500 м, птица = 5 м;
   плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.
    прыжок: кот = 2 м., собака 0.4 м., лошадь 3 м., птица 0.1 м. */

        dog1.run( 350,6);
        dog1.jump(0.4, 0.35,6);
        dog2.run( 450,10);
        dog2.jump(0.4, 0.35,10);
        System.out.println();
        horse1.run( 1200,13);
        horse1.jump(3, 3.5, 13);
        horse1.swim(100,80, 13);
        horse2.run(1700,8);
        horse2.jump(3, 3.2,8);
        System.out.println();
        bird1.jump(0.1,0.05, 3);
        bird2.swim(0,0,5);
        bird2.run( 3,5);
        System.out.println();
        cat1.run(150, 10);
        cat1.jump(2,1.8,10);
        cat2.jump(2,2.2,5);
        cat2.run(250, 5);
        cat2.swim(0,0, 5);

        System.out.println("Количество животных: " + Animal.animalСounter);
        System.out.println("Количество собак: " + Dog.animalСounterDog);
        System.out.println("Количество лошадей: " + Horse.animalСounterHorse);
        System.out.println("Количество птиц: " + Bird.animalСounterBird);
        System.out.println("Количество котов: " + Cat.animalСounterCat);
    }
}
