import java.util.ArrayList;
import java.util.Stack;

public class Payroll {

    // DSA - ArrayList to store all employees
    ArrayList<Employee> employees = new ArrayList<>();

    // DSA - Stack to undo last action (stores deleted employees)
    Stack<Employee> undoStack = new Stack<>();

    int nextId = 1;

    // ── ADD ──────────────────────────────────────────────
    public void addEmployee(String name, String department,
                             double hoursWorked, double hourlyRate, double taxRate) {
        Employee e = new Employee(nextId, name, department, hoursWorked, hourlyRate, taxRate);
        employees.add(e);
        nextId++;
        System.out.println("Employee added: " + name + " (ID: " + e.getId() + ")");
    }

    // ── REMOVE ───────────────────────────────────────────
    // DSA - Linear Search O(n) to find employee
    public void removeEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                Employee removed = employees.get(i);
                undoStack.push(removed); // push to stack for undo
                employees.remove(i);
                System.out.println("Removed: " + removed.getName());
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // DSA - Stack undo (LIFO - last removed comes back first)
    public void undoRemove() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        Employee e = undoStack.pop();
        employees.add(e);
        System.out.println("Undo successful! Restored: " + e.getName());
    }

    // ── FIND ─────────────────────────────────────────────
    // DSA - Linear Search O(n)
    public Employee findEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) return e;
        }
        System.out.println("Employee not found.");
        return null;
    }

    // ── UPDATE ───────────────────────────────────────────
    public void updateHours(int id, double newHours) {
        Employee e = findEmployee(id);
        if (e != null) {
            e.setHoursWorked(newHours);
            System.out.println("Hours updated for: " + e.getName());
        }
    }

    public void updateRate(int id, double newRate) {
        Employee e = findEmployee(id);
        if (e != null) {
            e.setHourlyRate(newRate);
            System.out.println("Rate updated for: " + e.getName());
        }
    }

    // ── SEARCH ───────────────────────────────────────────
    // DSA - Linear Search by name O(n)
    public void searchByName(String keyword) {
        boolean found = false;
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(keyword.toLowerCase())) {
                e.printEmployee();
                found = true;
            }
        }
        if (!found) System.out.println("No employee found.");
    }

    // ── SORT ─────────────────────────────────────────────
    // DSA - Bubble Sort by net pay O(n²)
    public void sortByNetPay() {
        for (int i = 0; i < employees.size() - 1; i++) {
            for (int j = 0; j < employees.size() - i - 1; j++) {
                if (employees.get(j).getNetPay() > employees.get(j + 1).getNetPay()) {
                    // Swap
                    Employee temp = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, temp);
                }
            }
        }
        System.out.println("\nEmployees sorted by net pay (low to high):");
        showAllEmployees();
    }

    // ── DISPLAY ──────────────────────────────────────────
    public void printPayslip(int id) {
        Employee e = findEmployee(id);
        if (e != null) e.printPayslip();
    }

    public void printAllPayslips() {
        if (employees.isEmpty()) { System.out.println("No employees."); return; }
        for (Employee e : employees) e.printPayslip();
    }

    public void showAllEmployees() {
        if (employees.isEmpty()) { System.out.println("No employees."); return; }
        System.out.println("\n===== ALL EMPLOYEES =====");
        for (Employee e : employees) e.printEmployee();
    }

    // Total payroll cost
    public void showTotalPayroll() {
        double total = 0;
        for (Employee e : employees) total += e.getNetPay();
        System.out.println("\nTotal payroll this month: $" + total);
    }

    // DSA - Linear Search for highest paid O(n)
    public void showHighestPaid() {
        if (employees.isEmpty()) { System.out.println("No employees."); return; }
        Employee highest = employees.get(0);
        for (Employee e : employees) {
            if (e.getNetPay() > highest.getNetPay()) highest = e;
        }
        System.out.println("\nHighest paid employee:");
        highest.printEmployee();
    }

    // DSA - Linear Search for lowest paid O(n)
    public void showLowestPaid() {
        if (employees.isEmpty()) { System.out.println("No employees."); return; }
        Employee lowest = employees.get(0);
        for (Employee e : employees) {
            if (e.getNetPay() < lowest.getNetPay()) lowest = e;
        }
        System.out.println("\nLowest paid employee:");
        lowest.printEmployee();
    }
}

