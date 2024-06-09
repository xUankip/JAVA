package day3;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Employee> queue = new PriorityQueue<>();
        queue.add(new Employee (5,"Hung", 10, 20));
        queue.add(new Employee (4,"Hung", 12, 22)) ;
        queue.add(new Employee (2, "Hung", 11, 23));
        queue. add(new Employee (2, "Hung", 30, 32));
        queue. add(new Employee (6, "Hung", 22, 29)) ;
        while (true){
            Employee employee = queue.poll();
            if (employee == null){
                break;
            }
            System.out.printf(" %d  - %s - %f\n", employee.getId(), employee.getName(), employee.getSalary(), employee.getWorkingDay());
        }
    }
}
