package com.example.employeemanagementsystem;

public class Contractor extends Employee {

    private int maxHours;

    public Contractor(String name, double hourlyRate, int maxHours) {
        super(name, hourlyRate);
        this.maxHours = maxHours;
    }

    @Override
    public double calculateSalary() {
        return getSalary() * maxHours; // Salary is based on max hours
    }
}
