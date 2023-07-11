package ru.job4j.ood.ocp.foul;

/* Нарушает принцип OCP, так как расчет зарплаты осуществляется внутри метода calculateSalary
с использованием условных операторов, проверяющих тип роли сотрудника.
Если добавится новый тип сотрудника, например, Designer, придется изменять код метода.
Получается код не открыт для расширения без модификации */
public class Employee {

    private String name;
    private String role;

    public void calculateSalary() {
        if (role.equals("Manager")) {
            System.out.println("Расчет зарплаты для менеджера");
        } else if (role.equals("Developer")) {
            System.out.println("Расчет зарплаты для разработчика");
        } else if (role.equals("Tester")) {
            System.out.println("Расчет зарплаты для тестировщика");
        }
    }
}
