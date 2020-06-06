package homework_lesson_5;

public class MainClass {
/* общее задание
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
5. *С помощью цикла вывести информацию только о сотрудниках старше 40 лет. */

    public static void main(String[] args) {

        /* 2. Конструктор класса должен заполнять эти поля при создании объекта. */
        /* 4. Создать массив из 5 сотрудников. */
        Employee[] departmentITperson = new Employee[5];
        departmentITperson[0] = new Employee("Petrov", "Sergei", "Ivanovich",
                "Начальник службы", "petrov@mail.ru", "8-495-445-56-65", 50000, 50);
        departmentITperson[1] = new Employee("Ivanov", "Alexsei", "Igorevich",
                "Заместитель начальника службы", "ivanov@mail.ru", "8-495-445-56-66", 45000, 52);
        departmentITperson[2] = new Employee("Sidorov", "Vasilii", "Genadevich",
                "Ведущий эксперт", "sidorov@mail.ru", "8-495-445-56-67", 40000, 24);
        departmentITperson[3] = new Employee("Titova", "Natalay", "Alexandrovna",
                "Ведущий специалист", "titova@mail.ru", "8-495-445-56-68", 37000, 38);
        departmentITperson[4] = new Employee("Perevozov", "Ruslan", "Vladimirovich",
                "специалист 1-ой категории", "perevozov@mail.ru", "8-498-445-56-59", 35000, 42);

        /*  Вывод всех сотрудников отдела */
        System.out.println("Вывод всех сотрудников отдела");
        for (int i = 0; i < 5; i++) {
            departmentITperson[i].printInformation();
        }

        /*5. *С помощью цикла вывести информацию только о сотрудниках старше 40 лет. */
        System.out.println("Вывод всех сотрудников отдела кому за 40");
        for (int i = 0; i < 5; i++) {
            if(departmentITperson[i].age > 40) {
                departmentITperson[i].printInformation();
            }
        }

        System.out.println("Вывод всех сотрудников отдела кому за 40");
        for (int i = 0; i < 5; i++) {
            Employee employee = departmentITperson[i];
            if(employee.ageCheck()) {
                employee.printInformation();
            }
        }

    }
}
