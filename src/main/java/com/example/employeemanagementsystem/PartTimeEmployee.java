package com.example.employeemanagementsystem;

public class PartTimeEmployee extends Employee {

    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name, hourlyRate);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return getSalary() * hoursWorked; // Salary is based on hours worked
    }
}
