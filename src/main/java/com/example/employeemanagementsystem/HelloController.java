package com.example.employeemanagementsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class HelloController {

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> typeColumn;

    @FXML
    private TableColumn<Employee, Double> salaryColumn;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField salaryField;

    @FXML
    private TextField hoursField;

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Populate ComboBox with employee types
        typeComboBox.setItems(FXCollections.observableArrayList("FullTime", "PartTime", "Contractor"));

        // Set up the columns in the TableView
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClass().getSimpleName()));
        salaryColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().calculateSalary()).asObject());

        // Set the items for the TableView
        employeeTable.setItems(employeeList);
    }

    // Action for adding an employee
    @FXML
    public void handleAddEmployee() {
        String name = nameField.getText();
        String type = typeComboBox.getValue();
        String salaryText = salaryField.getText();
        String hoursText = hoursField.getText();

        // Validate the inputs
        if (name.isEmpty() || type == null || salaryText.isEmpty()) {
            showAlert("Input Error", "Please fill in all fields correctly.");
            return;
        }

        double salary = Double.parseDouble(salaryText);
        int hours = !hoursText.isEmpty() ? Integer.parseInt(hoursText) : 0;

        Employee employee = null;

        // Create the appropriate employee type
        if (type.equals("FullTime")) {
            employee = new FullTimeEmployee(name, salary);
        } else if (type.equals("PartTime")) {
            employee = new PartTimeEmployee(name, salary, hours);
        } else if (type.equals("Contractor")) {
            employee = new Contractor(name, salary, hours);
        }

        // Add the employee to the list and clear input fields
        if (employee != null) {
            employeeList.add(employee);
            clearInputFields();
        }
    }

    // Action for updating salaries (refresh)
    @FXML
    public void handleUpdateSalaries() {
        employeeTable.refresh();
    }

    // Action for removing the selected employee
    @FXML
    public void handleRemoveEmployee() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employeeList.remove(selectedEmployee);
        }
    }

    // Show an alert if something goes wrong
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Clear the input fields after adding an employee
    private void clearInputFields() {
        nameField.clear();
        typeComboBox.setValue(null);
        salaryField.clear();
        hoursField.clear();
    }
}
