package ru.geekbrains.homework_6;

public class Horse extends Animal {

    public static int animalСounterHorse;

    public Horse(String name, String color, int youngАge, int maxRun){
        super(name, color, youngАge, maxRun);

        /*  5. * Добавить подсчет созданных котов, собак и животных. */
        animalСounterHorse++;
    }

    public void run(){
    }

    public void jump(){
    }

    public void swim(double maxSwim, double pathLengthSwim, int age){

        /* 6. * Добавить животным разброс в ограничениях.
        То есть у одной собаки может быть ограничение на бег 400 м., у другой 600 м.. */
        if (youngАge > age){
            maxSwim = maxSwim + maxSwim * 0.3;
            System.out.println("Животное может проплыть: " + maxSwim + "м." + " так как еще молод(а). Возраст: " + age);

        } else {
            maxSwim = maxSwim - maxSwim * 0.3;
            System.out.println("Животное может проплыть: " + maxSwim + "м." + " так как уже не молод(а). Возраст: " + age);
        }

       /* 4. При попытке выполнить одно из действий, оно должно сообщить результат: смогло или нет животное
       выполнить действие, например, dog.run(150); -> результат 'Пес пробежал!';*/
        if (maxSwim >= pathLengthSwim) {
            System.out.println(name + " проплыл(а) " + pathLengthSwim + "м.");;
        } else {
            System.out.println(name + " может проплыть только  = " + maxSwim + "м.");
        }
    }

    @Override
    public void voice(){
        System.out.println(name + " Neigh");
    }
}
