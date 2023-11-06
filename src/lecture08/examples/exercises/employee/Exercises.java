package lecture08.examples.exercises.employee;

public class Exercises {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Desislava ", "Koleva");
        employee.setSalaryPerMonth(5000.0);

        System.out.println("Name: " + employee.getName());
        System.out.println("Annual Salary: " + employee.getAnnualSalary());

        double newSalary = employee.raiseSalary(10.0);
        System.out.println("Updated Salary: " + newSalary);

        System.out.println(employee);
    }
}