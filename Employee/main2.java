package employee;

import java.util.Scanner;

/*
 *By: Tamer Raed Alnauizi, 120170770
 */
public class main2 {

    public static void showData(Employee[] employees) {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//      creat array of type Employee size 10
        Employee list[] = new Employee[10];
//      Enter Employee data by Scanner 
        for (int i = 0; i < list.length; i++) {
            System.out.println("Enter Employee data");
            Employee emp = new Employee();
            System.out.println("Enter the name Employee");
            emp.setName(in.next());
            System.out.println("Enter the department");
            emp.setDepartment(in.next());
            System.out.println("Enter the salary");
            emp.setSalary(in.nextDouble());
            list[i] = emp;
        }
//        Add bonus to salary
        for (int i = 0; i < list.length; i++) {
            list[i].setSalary(list[i].getSalary(), 1.2);

        }        
//      sort the Employee by the name
        Employee temp;
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i].getName().compareTo(list[j].getName()) > 0) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
//      Print employee data
        System.out.printf("%-10s%-15s%-13s\n", "Name",
                "Department", "Salary");

        for (Employee employee : list) {
            System.out.printf("%-10s%-15s%-10.2f\n",
                    employee.getName(),
                    employee.getDepartment(),
                    employee.getSalary());
        }
    }

}
