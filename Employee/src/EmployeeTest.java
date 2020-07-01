public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("ivanov ivan Ivanovich", "DESIGN ENGINEER",
                "89167786402", 1000, 25);
        employeesArray[1] = new Employee("Petrov Sergey Olegivich", "DESIGN ENGINEER", "psv@mail.ru",
                "+79168526891", 1500, 46);
        employeesArray[2] = new Employee("Sidorov Maksim Victotovich", "head of department", "smv@yandex.ru",
                "8 (925) 364 88 99", 2500, 28);
        employeesArray[3] = new Employee("Shishkina Marina Aleksandrovna", "Project manager", "sma@yandex.ru",
                "+79168526891", 1500, 30);
        employeesArray[4] = new Employee("Bogatirev Petr Sergeevich", "CHIEF DESIGNER",
                "8-916-225-87-09", 4000, 47);

        System.out.println("Employees older than 40:");
        for (Employee person : employeesArray) {
            if (person.getAge() > 40) {
                person.getEmployee();
            }
        }

//        Employee person = new Employee("ivanov ivan Ivanovich", "DESIGN ENGINEER",
//                "89167786402", 1000, 25);
//        //person.getEmployee();
//        Employee.getStuffList();
//        Employee.addPositionToTheStuffList("designer");
//        Employee.getStuffList();
    }
}