package employee;

public class Employee {

    private String name;
    private String department;
    private double salary;
    public static int count;

    public Employee() {
        ++count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void setSalary(double salary,double bounas) {
        this.salary = salary*bounas;
    }
}
