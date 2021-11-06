package jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("*********************************");
            System.out.println("Select from option below");
            System.out.println("*********************************");
            System.out.println("Press 1: Add Employee");
            System.out.println("Press 2: Update Employee");
            System.out.println("Press 3: Delete Employee");
            System.out.println("Press 4: Get All Employee");
            System.out.println("Press 5: Get Employee by ID");
            System.out.println("Press 6: Exit");


            int input = sc.nextInt();


            switch (input) {
                case 1: {
                    //add
                    System.out.println("Enter your Name: ");
                    String name = sc.next();
                    System.out.println("Enter your Email: ");
                    String email = sc.next();
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setEmail(email);
                    dao.addEmployee(employee);
                    break;
                }
                case 2:
                    //update
                {
                    System.out.println("Enter your new Name: ");
                    String name = sc.next();
                    System.out.println("Enter your new Email: ");
                    String email = sc.next();
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setEmail(email);
                    System.out.println("Enter your ID: ");
                    int id = sc.nextInt();
                    employee.setId(id);
                    dao.updateEmployee(employee);
                    break;
                }
                case 3:
                    //delete
                {
                    System.out.println("Enter your ID: ");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                    break;
                }
                case 4:
                    //get all
                {
                    List<Employee> employees = dao.getEmployees();
                    for (Employee employee : employees) {
                        System.out.print("ID " + employee.getId());
                        System.out.print(", Name: " + employee.getName());
                        System.out.println(", Email: " + employee.getEmail());

                    }
                    break;

                }
                case 5: {
                    //get by id

                    System.out.println("Enter your ID: ");
                    int id = sc.nextInt();
                    Employee employee = dao.getEmployeeById(id);
                    if (employee.getId() == -1){
                        System.out.println("No record");
                    }else {

                        System.out.print("ID " + employee.getId());
                        System.out.print(", Name: " + employee.getName());
                        System.out.println(", Email: " + employee.getEmail());
                    }
                    break;

                }
                case 6:
                    //exit
                {
                    System.out.println("Thank you!");
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                default:
                    System.out.println("Invalid input. Choose option 1 - 6. Thank you");
            }
        }
        flag = false;

//        Employee employee = new Employee();
//        employee.setName("John");
//        employee.setEmail("j@mail.com");
//        dao.addEmployee(employee);
//
//        employee.setName("Mike");
//        employee.setEmail("m@mail.com");
//        dao.addEmployee(employee);
//
//        employee.setName("Bob");
//        employee.setEmail("B@mail.com");
//        dao.addEmployee(employee);
//
//        employee.setName("Tom");
//        employee.setEmail("t@mail.com");
//        dao.addEmployee(employee);
//
//        employee.setName("William");
//        dao.updateEmployee(employee);
//
//        dao.deleteEmployee(employee.getId());
//        ;


    }
}
