public class Employee {

    // Encapsulation - private fields
    private int id;
    private String name;
    private String department;
    private double hoursWorked;
    private double hourlyRate;
    private double taxRate;

    // Constructor
    public Employee(int id, String name, String department,
                    double hoursWorked, double hourlyRate, double taxRate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.taxRate = taxRate;
    }

    // Getters
    public int    getId()          { return id; }
    public String getName()        { return name; }
    public String getDepartment()  { return department; }
    public double getHoursWorked() { return hoursWorked; }
    public double getHourlyRate()  { return hourlyRate; }

    // Setters
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public void setHourlyRate(double hourlyRate)   { this.hourlyRate = hourlyRate; }

    // Calculate gross pay (before tax)
    public double getGrossPay() {
        return hoursWorked * hourlyRate;
    }

    // Calculate tax amount
    public double getTaxAmount() {
        return getGrossPay() * taxRate;
    }

    // Calculate net pay (after tax)
    public double getNetPay() {
        return getGrossPay() - getTaxAmount();
    }

    // Print full payslip
    public void printPayslip() {
        System.out.println("\n=============================");
        System.out.println("         PAY SLIP");
        System.out.println("=============================");
        System.out.println("Employee ID  : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Hours Worked : " + hoursWorked);
        System.out.println("Hourly Rate  : $" + hourlyRate);
        System.out.println("-----------------------------");
        System.out.println("Gross Pay    : $" + getGrossPay());
        System.out.println("Tax (" + (int)(taxRate * 100) + "%)     : $" + getTaxAmount());
        System.out.println("-----------------------------");
        System.out.println("NET PAY      : $" + getNetPay());
        System.out.println("=============================");
    }

    // Print short summary
    public void printEmployee() {
        System.out.println("ID: " + id
                + " | Name: " + name
                + " | Dept: " + department
                + " | Hours: " + hoursWorked
                + " | Rate: $" + hourlyRate
                + " | Net Pay: $" + getNetPay());
    }
}
