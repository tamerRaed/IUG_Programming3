package employee;

import javax.swing.JOptionPane;

/*
 *By: Tamer Raed Alnauizi, 120170770
 */
public class main {

    public static void main(String[] args) {
//      creat array of type Employee size 10
        Employee list[] = new Employee[10];
//      Enter Employee data by JOptionPane 
        Employee emp;
        for (int i = 0; i < list.length; i++) {
            System.out.println("Enter Employee data");
            emp = new Employee();
            emp.setName(JOptionPane.
                    showInputDialog(null, "Enter the name Employee",
                            "Employee " + i, JOptionPane.INFORMATION_MESSAGE));
            emp.setDepartment(JOptionPane.
                    showInputDialog(null, "Enter the department",
                            "Employee " + i, JOptionPane.INFORMATION_MESSAGE));
            emp.setSalary(Double.parseDouble(JOptionPane.
                    showInputDialog(null, "Enter salary",
                            "Employee " + i, JOptionPane.INFORMATION_MESSAGE)));
            list[i] = emp;

        }

//        Add bonus to salary
        for (int i = 0; i < list.length; i++) {
            list[i].setSalary(list[i].getSalary(), 1.2);

        }
//      Store employee data in a String variable
        String string = "Name     Department      Salary\n";
        for (int i = 0; i < list.length; i++) {
            string += list[i].getName() + "         " + list[i].getDepartment() + "         " + list[i].getSalary() + "\n";
        }
//      sort the Employee by the name        
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].getSalary() > list[i].getSalary()) {
                    Employee temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
//      Print employee data by JOptionPane       
        JOptionPane.showMessageDialog(null, string);

    }
}
