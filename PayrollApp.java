import java.util.Scanner;

public class PayrollApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // OOP - creating a Payroll object
        Payroll payroll = new Payroll();

        // Demo employees
        payroll.addEmployee("Gurleen Kaur", "IT",      40, 25.00, 0.15);
        payroll.addEmployee("John Smith",   "Finance", 38, 22.00, 0.15);
        payroll.addEmployee("Sara Ahmed",   "HR",      35, 20.00, 0.10);
        payroll.addEmployee("James Brown",  "IT",      45, 30.00, 0.20);
        payroll.addEmployee("Emily Davis",  "Finance", 40, 28.00, 0.18);

        boolean running = true;

        while (running) {
            System.out.println("\n==============================");
            System.out.println("  PAYROLL MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1.  Add employee");
            System.out.println("2.  Remove employee");
            System.out.println("3.  Undo last remove");
            System.out.println("4.  Update hours worked");
            System.out.println("5.  Update hourly rate");
            System.out.println("6.  View one payslip");
            System.out.println("7.  View all payslips");
            System.out.println("8.  View all employees");
            System.out.println("9.  Search by name");
            System.out.println("10. Sort by net pay");
            System.out.println("11. Show total payroll");
            System.out.println("12. Show highest paid");
            System.out.println("13. Show lowest paid");
            System.out.println("0.  Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Full name: ");
                String name = sc.nextLine();
                System.out.print("Department: ");
                String dept = sc.nextLine();
                System.out.print("Hours worked: ");
                double hours = Double.parseDouble(sc.nextLine());
                System.out.print("Hourly rate: $");
                double rate = Double.parseDouble(sc.nextLine());
                System.out.print("Tax rate (e.g. 0.15 for 15%): ");
                double tax = Double.parseDouble(sc.nextLine());
                payroll.addEmployee(name, dept, hours, rate, tax);

            } else if (choice == 2) {
                System.out.print("Employee ID to remove: ");
                int id = Integer.parseInt(sc.nextLine());
                payroll.removeEmployee(id);

            } else if (choice == 3) {
                payroll.undoRemove();

            } else if (choice == 4) {
                System.out.print("Employee ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("New hours: ");
                double hours = Double.parseDouble(sc.nextLine());
                payroll.updateHours(id, hours);

            } else if (choice == 5) {
                System.out.print("Employee ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("New rate: $");
                double rate = Double.parseDouble(sc.nextLine());
                payroll.updateRate(id, rate);

            } else if (choice == 6) {
                System.out.print("Employee ID: ");
                int id = Integer.parseInt(sc.nextLine());
                payroll.printPayslip(id);

            } else if (choice == 7) {
                payroll.printAllPayslips();

            } else if (choice == 8) {
                payroll.showAllEmployees();

            } else if (choice == 9) {
                System.out.print("Search name: ");
                String name = sc.nextLine();
                payroll.searchByName(name);

            } else if (choice == 10) {
                payroll.sortByNetPay();

            } else if (choice == 11) {
                payroll.showTotalPayroll();

            } else if (choice == 12) {
                payroll.showHighestPaid();

            } else if (choice == 13) {
                payroll.showLowestPaid();

            } else if (choice == 0) {
                System.out.println("Goodbye!");
                running = false;
            }
        }
        sc.close();
    }
}
