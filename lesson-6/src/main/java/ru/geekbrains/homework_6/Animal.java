package ru.geekbrains.homework_6;

public abstract class Animal {

    public String name;
    public String color;
    public int youngАge;
    public int maxRun;
    public static int animalСounter;

    public Animal(String name, String color, int youngАge, int maxRun){
        this.name = name;
        this.color = color;
        this.youngАge = youngАge;
        this.maxRun = maxRun;

        /*  5. * Добавить подсчет созданных котов, собак и животных. */
        animalСounter++;
    }

//    public abstract int maxRun();

    public void run(int pathLength, int age){

        double distanceRun =  maxRun;
//      double distanceRun =  maxRun();

        /* 6. * Добавить животным разброс в ограничениях.
        То есть у одной собаки может быть ограничение на бег 400 м., у другой 600 м.. */
        if (youngАge > age){
            distanceRun = maxRun + maxRun * 0.3;
            System.out.println("Животное может пробежать: " + distanceRun + "м." + " так как еще молод(а). Возраст: " + age);
        } else {
            distanceRun = maxRun - maxRun * 0.3;
            System.out.println("Животное может пробежать: " + distanceRun + "м." + " так как уже не молод(а) возраст " + age);
        }

          /* 4. При попытке выполнить одно из действий, оно должно сообщить результат:
           смогло или нет животное выполнить действие, например, dog.run(150); -> результат 'Пес пробежал!';*/
        if (distanceRun >= pathLength) {
            System.out.println(name + " пробежал(а) " + pathLength + "м.");
        } else {
            System.out.println(name + " может пробежать максимально только = " + distanceRun + "м.");
        }
    }

    public void jump(double maxJump, double jumpHight, int age){

        double hightJump = maxJump;
        /* 6. * Добавить животным разброс в ограничениях. То есть у одной собаки может
         быть ограничение на бег 400 м., у другой 600 м.. */
        if (youngАge > age){
            hightJump = maxJump + maxJump * 0.3;
            System.out.println("Животное может прыгнуть на высоту: " + hightJump + "м." + " так как еще молод(а). Возраст: " + age);
        } else {
            hightJump = maxJump - maxJump * 0.3;
            System.out.println("Животное может прыгнуть на высоту: " + hightJump + "м." + " так как уже не молод(а). Возраст: " + age);
        }

          /* 4. При попытке выполнить одно из действий, оно должно сообщить результат:
          смогло или нет животное выполнить действие, например, dog.run(150); -> результат 'Пес пробежал!';*/
        if (hightJump >= jumpHight) {
            System.out.println(name + " прыгул(а) на высоту " + jumpHight + "м.");
        } else {
            System.out.println(name + " может прыгнуть только на высоту = " + hightJump + "м.");
        }
    }

    public abstract void swim(double maxSwim, double pathLengthSwim, int age);

    public abstract void voice();

}
