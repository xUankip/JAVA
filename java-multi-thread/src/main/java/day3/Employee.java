package day3;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private double salary;
    private int workingDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public Employee(int id, String name, double salary, int workingDay) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.workingDay = workingDay;
    }

    @Override
    public int compareTo(Employee employee) {
        if (employee.getId() == this.getId()){
            return 0;
        } else if (this.getId()>employee.getId()){
            return 1;
        } else{
            return -1;
        }
    }
}
