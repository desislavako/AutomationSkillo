package lecture08.examples.exercises.employee;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private double salaryPerMonth;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public double getAnnualSalary() {
        return salaryPerMonth * 12;
    }

    public double raiseSalary(double percentage) {
        double raise = (percentage / 100) * salaryPerMonth;
        salaryPerMonth += raise;
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
