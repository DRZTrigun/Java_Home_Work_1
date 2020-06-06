package homework_lesson_5;


/* 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст. */
public class Employee {
    String surname;
    String name;
    String middleName;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    Employee(String surname, String name, String middleName, String position, String email,
             String phoneNumber, int salary, int age){
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /* 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль. */
    public void printInformation(){
        System.out.printf("Сотрудик: %s", "ФИО " + surname + " " + name + " " + middleName + ". должность: "+ position +
                ". почта: " + email + ". телефон: " + phoneNumber + ". зарплата: " + salary + ". возраст: " + age);
        System.out.println();
    }
    /* проверка возраста сотрудника */
    public boolean ageCheck(){
        return age > 40;
    }

}
