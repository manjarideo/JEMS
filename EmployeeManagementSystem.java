import java.util.Scanner;

// Define the employee class
class Employee {
    int id;
    String name;
    int age;
    int salary;
    String department;
    Employee next;

    // Constructor
    public Employee(int id, String name, int age, int salary, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.next = null;
    }
}

public class EmployeeManagementSystem {
    // Declare global variables
    static Employee head = null;
    static Employee current = null;

    // Function to insert an employee into the linked list
    static void insertEmployee(int id, String name, int age, int salary, String department) {
        // Create a new employee object
        Employee newEmployee = new Employee(id, name, age, salary, department);

        // If the list is empty, make the new employee the head
        if (head == null) {
            head = newEmployee;
            current = newEmployee;
        }
        // Otherwise, append the new employee to the end of the list
        else {
            current.next = newEmployee;
            current = newEmployee;
        }
        System.out.println("Employee with ID " + id + " has been added successfully.");
    }

    // Function to search for an employee by ID
    static Employee searchEmployee(int id) {
        // Start at the head of the list
        Employee currentEmployee = head;

        // Traverse the list until the employee with the given ID is found
        while (currentEmployee != null) {
            if (currentEmployee.id == id) {
                return currentEmployee;
            }
            currentEmployee = currentEmployee.next;
        }
        // If the employee is not found, return null
        return null;
    }

    // Function to edit an employee's details by ID
    static void editEmployee(int id) {
        // Search for the employee
        Employee employeeToEdit = searchEmployee(id);
        if (employeeToEdit == null) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }

        // Get the new details from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new name for employee " + id + ": ");
        String newName = scanner.next();
        System.out.print("Enter the new age for employee " + id + ": ");
        int newAge = scanner.nextInt();
        System.out.print("Enter the new salary for employee " + id + ": ");
        int newSalary = scanner.nextInt();
        System.out.print("Enter the new department for employee " + id + ": ");
        String newDepartment = scanner.next();

        // Update the employee's details
        employeeToEdit.name = newName;
        employeeToEdit.age = newAge;
        employeeToEdit.salary = newSalary;
        employeeToEdit.department = newDepartment;

        System.out.println("Employee with ID " + id + " has been edited successfully.");
    }

    // Function to delete an employee by ID
    static void deleteEmployee(int id) {
        // Search for the employee to delete
        Employee employeeToDelete = head;
        Employee previousEmployee = null;
        while (employeeToDelete != null) {
            if (employeeToDelete.id == id) {
                break;
            }
            previousEmployee = employeeToDelete;
            employeeToDelete = employeeToDelete.next;
        }

        // If the employee is not found, return
        if (employeeToDelete == null) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }

        // If the employee is the head of the list, update the head pointer
        if (employeeToDelete == head) {
            head = employeeToDelete.next;
        }
        // Otherwise, update the previous employee's next pointer
        else {
            previousEmployee.next = employeeToDelete.next;
        }

        System.out.println("Employee with ID " + id + " has been deleted successfully.");
    }

    // Function to print all employees in the linked list
    static void printEmployees() {
        // Start at the head of the list
        Employee currentEmployee = head;

        // Print each employee's details
        while (currentEmployee != null) {
            System.out.println("ID: " + currentEmployee.id);
            System.out.println("Name: " + currentEmployee.name);
            System.out.println("Age: " + currentEmployee.age);
            System.out.println("Salary: " + currentEmployee.salary);
            System.out.println("Department: " + currentEmployee.department + "\n");
            currentEmployee = currentEmployee.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, id, age, salary;
        String name, department;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("--------------------------");
            System.out.println("1. Add an employee");
            System.out.println("2. Search for an employee");
            System.out.println("3. Edit an employee's details");
            System.out.println("4. Delete an employee");
            System.out.println("5. Print all employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the employee ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter the employee name: ");
                    name = scanner.next();
                    System.out.print("Enter the employee age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter the employee salary: ");
                    salary = scanner.nextInt();
                    System.out.print("Enter the employee department: ");
                    department = scanner.next();
                    insertEmployee(id, name, age, salary, department);
                    break;
                case 2:
                    System.out.print("Enter the employee ID to search for: ");
                    id = scanner.nextInt();
                    Employee foundEmployee = searchEmployee(id);
                    if (foundEmployee == null) {
                        System.out.println("Employee with ID " + id + " not found.");
                    } else {
                        System.out.println("Employee with ID " + id + " found:");
                        System.out.println("Name: " + foundEmployee.name);
                        System.out.println("Age: " + foundEmployee.age);
                        System.out.println("Salary: " + foundEmployee.salary);
                        System.out.println("Department: " + foundEmployee.department);
                    }
                    break;
                case 3:
                    System.out.print("Enter the employee ID to edit: ");
                    id = scanner.nextInt();
                    editEmployee(id);
                    break;
                case 4:
                    System.out.print("Enter the employee ID to delete: ");
                    id = scanner.nextInt();
                    deleteEmployee(id);
                    break;
                case 5:
                    printEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}
