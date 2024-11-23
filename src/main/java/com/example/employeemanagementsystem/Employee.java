package com.example.employeemanagementsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Employee {

    private SimpleStringProperty name;
    private DoubleProperty salary;

    public Employee(String name, double salary) {
        this.name = new SimpleStringProperty(name);
        this.salary = new SimpleDoubleProperty(salary);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getSalary() {
        return salary.get();
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public abstract double calculateSalary();
}
