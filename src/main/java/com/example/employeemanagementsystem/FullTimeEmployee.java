package com.example.employeemanagementsystem;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateSalary() {
        return getSalary(); // For full-time employees, salary is fixed
    }
}
