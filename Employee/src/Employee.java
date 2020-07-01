import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Employee {
    private static int employeeCount;
    private static Map<Integer, String> positions = new TreeMap<Integer, String>() {{put(1, "CHIEF DESIGNER");
            put(2, "HEAD OF DEPARTMENT"); put(3, "PROJECT MANAGER"); put(4, "DESIGN ENGINEER");
            put(5, "SOFTWARE ENGINEER"); put(6, "DESIGN ENGINEER");}};
    private String name;
    private String position;
    private String email = "no e-mail";
    private String phoneNumber;
    private float salary;
    private int age;
    private int serviceNumber;

    public Employee(String name, String position, String phoneNumber, float salary, int age) {
        setName(name);
        setPosition(position);
        setPhoneNumber(phoneNumber);
        setSalary(salary);
        setAge(age);
        employeeCount++;
        serviceNumber = employeeCount;
    }

    public Employee(String name, String position, String email, String phoneNumber, float salary, int age) {
        setName(name);
        setPosition(position);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setSalary(salary);
        setAge(age);
        employeeCount++;
        serviceNumber = employeeCount;
    }

    public void setName(String name) {
        char[] charName = name.toCharArray();

        charName[0] = Character.toUpperCase(charName[0]);

        for (int i = 0; i < charName.length - 1; i++) {
            if (charName[i] == ' ') {
                charName[i + 1] = Character.toUpperCase(charName[i + 1]);
            }
        }
        this.name = new String(charName);
    }

    public void setPosition(String position) {
        if (positions.containsValue(position.toUpperCase())) {
            this.position = position.toUpperCase();
        } else {
            System.out.printf("The position [%s] is not in the staff list. Add new position in stuff list?\n", position.toUpperCase());
            System.out.println("[Y/N]?");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String answer = null;
            try {
                answer = reader.readLine();
            if (answer.toUpperCase().equals("Y")) {
                addPositionToTheStuffList(position);
                this.position = position.toUpperCase();
            } else {
                System.out.println("Select a position from the staff list:");
                getStuffList();
                System.out.println("Enter the item number:");

                int key;

                while (true) {
                    try {
                        key = Integer.parseInt(reader.readLine());
                        if (positions.containsKey(key)) {
                            this.position = positions.get(key);
                            break;
                        } else {
                            System.out.println("Incorrect item number. Set correct item number");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect item number. Set correct item number");
                        continue;
                    }
                }
                reader.close();
            }
            } catch (IOException e) {
                System.out.println("IOException " +e);
            }
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\+7", "8");
        phoneNumber = phoneNumber.replaceAll("[\\(\\)\\-\\s]", "");

        try {
            Long.parseLong(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect number. Set correct number");
        }

    }

    public void setSalary(float salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Incorrect salary. Set correct salary");
        }
    }

    public void setAge(int age) {
        if (age >= 16) {
            this.age = age;
        } else {
            System.out.println("Incorrect age. Set correct age");
        }
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void getEmployee() {
        System.out.println("***************************");
        System.out.printf("Employee #%d:\n\tName: %s\n\tPosition: %s\n\tE-mail: %s\n\tPhone: %s\n\tSalary: %.2f$\n\tAge: " +
                "%d\n", serviceNumber, name, position, email, phoneNumber, salary, age);
        System.out.println();
    }

    public static void addPositionToTheStuffList(String newPosition) {
        positions.put(positions.size() + 1, newPosition.toUpperCase());
        System.out.printf("[%s] added to the stuff list\n", newPosition.toUpperCase());
    }

    public static void getStuffList() {
        System.out.println("***************************");
        for (Map.Entry map : positions.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
        System.out.println("***************************");
    }
}
