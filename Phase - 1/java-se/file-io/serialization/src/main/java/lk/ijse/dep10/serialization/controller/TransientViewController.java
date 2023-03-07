package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.dep10.serialization.model.Employee;
import lk.ijse.dep10.serialization.model.PersonInfo;
import lk.ijse.dep10.serialization.model.Status;

import java.io.*;
import java.util.ArrayList;

public class TransientViewController {

    public ToggleGroup rdoStatus;
    @FXML
    public Button btnAdd;

    @FXML
    public Button btnDelete;

    @FXML
    public Button btnNewEmployee;

    @FXML
    public Button btnRemove;

    @FXML
    public Button btnSave;

    @FXML
    public Button btnSpouseAdd;

    @FXML
    public Button btnSpouseRemove;

    @FXML
    public TableView<Employee> tblEmployees;

    @FXML
    public TextField txtContacts;



    @FXML
    public TextField txtID;

    @FXML
    public TextField txtName;

    @FXML
    public TextField txtSpouseContact;



    @FXML
    public TextField txtSpouseName;
    public ListView<String> lstSpouseContacts;
    public ListView<String> lstContacts;
    public RadioButton rdoSingle;
    public RadioButton rdoMarried;
    public VBox vBox;
    boolean isValid = true;
    private File employeeDb = new File("employee.db.dep10");
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void initialize() {
        tblEmployees.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmployees.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        tblEmployees.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("spouseName"));

        btnRemove.setDisable(true);
        btnSpouseRemove.setDisable(true);
        btnDelete.setDisable(true);
        vBox.setDisable(true);

        /*Adding Selection Listeners*/
        lstContacts.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnRemove.setDisable(current == null);
        });
        lstSpouseContacts.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnSpouseRemove.setDisable(current == null);
        });
        tblEmployees.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnDelete.setDisable(current == null);
            if (current != null) {
                txtID.setText(current.getId());
                txtName.setText(current.getEmployeeName());
                lstContacts.getItems().addAll(current.getEmployeeInfo().getContacts());
                rdoStatus.selectToggle(current.getStatus() == Status.MARRIED ? rdoMarried : rdoSingle);
                if (current.getStatus() == Status.MARRIED) {
                    vBox.setDisable(false);
                    txtSpouseName.setText(current.getSpouseName());
                    lstSpouseContacts.getItems().addAll(current.getSpouseInfo().getContacts());
                } else {
                    txtSpouseName.clear();
                    txtSpouseContact.clear();
                    lstSpouseContacts.getItems().clear();
                    vBox.setDisable(true);
                }

            }
        });

        rdoStatus.selectedToggleProperty().addListener((value, previous, current) -> {
            if (current != rdoMarried) {
                vBox.setDisable(true);
                txtSpouseName.clear();
                txtSpouseContact.clear();
                lstSpouseContacts.getItems().clear();

            }else vBox.setDisable(false);
        });
        
        /*De-Serialization*/
        try {
            FileInputStream fis = new FileInputStream(employeeDb);
            ObjectInputStream ois = new ObjectInputStream(fis);
            employeeList = (ArrayList<Employee>) ois.readObject();
            tblEmployees.getItems().addAll(employeeList);
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnNewEmployeeOnAction(ActionEvent event) {
        /*Clear text fields, radio buttons and listviews*/
        /*clear selections*/
        /*Focus to id*/
        txtID.clear();
        txtName.clear();
        txtContacts.clear();
        lstContacts.getItems().clear();
        txtSpouseName.clear();
        txtSpouseContact.clear();
        lstSpouseContacts.getItems().clear();
        rdoStatus.selectToggle(null);
        tblEmployees.getSelectionModel().clearSelection();
        txtID.requestFocus();
    }

    @FXML
    void lstContactsOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    @FXML
    void lstContactsOnMouseReleased(MouseEvent event) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String contact = txtContacts.getText();
        if (lstContacts.getItems().contains(contact) || contact.isBlank()) {
            txtContacts.selectAll();
            txtContacts.requestFocus();
            return;
        }
        lstContacts.getItems().add(contact);
        txtContacts.clear();
        txtContacts.requestFocus();

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        lstContacts.getItems().remove(lstContacts.getSelectionModel().getSelectedItem());
        lstContacts.getSelectionModel().clearSelection();
        txtContacts.clear();
        txtContacts.requestFocus();
    }

    @FXML
    void lstSpouseContactsOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnSpouseRemove.fire();
    }

    @FXML
    void lstSpouseContactsOnMouseReleased(MouseEvent event) {

    }

    @FXML
    void btnSpouseAddOnAction(ActionEvent event) {
        String contact = txtSpouseContact.getText();
        if (lstSpouseContacts.getItems().contains(contact) || contact.isBlank()) {
            txtSpouseContact.selectAll();
            txtSpouseContact.requestFocus();
            return;
        }
        lstSpouseContacts.getItems().add(contact);
        txtSpouseContact.clear();
        txtSpouseContact.requestFocus();
    }

    @FXML
    void btnSpouseRemoveOnAction(ActionEvent event) {
        lstSpouseContacts.getItems().remove(lstSpouseContacts.getSelectionModel().getSelectedItem());
        lstSpouseContacts.getSelectionModel().clearSelection();
        txtSpouseContact.clear();
        txtSpouseContact.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        validData();
        if (!isValid) return;

        String id = txtID.getText();
        String name = txtName.getText();
        ArrayList<String> employeeContactList = new ArrayList<>(lstContacts.getItems());

        PersonInfo employeeInfo = new PersonInfo(name, employeeContactList);

        Status status = rdoStatus.getSelectedToggle() == rdoMarried ? Status.MARRIED : Status.SINGLE;

        PersonInfo spouseInfo = null;

        if (status == Status.MARRIED) {
            String spouseName = txtSpouseName.getText();
            ArrayList<String> spouseContactList = new ArrayList<>(lstSpouseContacts.getItems());
            spouseInfo = new PersonInfo(spouseName, spouseContactList);
        }

        Employee employee = new Employee(id, employeeInfo, status, spouseInfo);
        if (tblEmployees.getSelectionModel().isEmpty()) {
            employeeList.add(employee);
        } else {
            Employee selectedEmployee = tblEmployees.getSelectionModel().getSelectedItem();
            selectedEmployee.setId(txtID.getText());
            selectedEmployee.setEmployeeInfo(employeeInfo);
            selectedEmployee.setStatus(status);
            selectedEmployee.setSpouseInfo(spouseInfo);
            tblEmployees.refresh();
            employeeList.clear();
            employeeList.addAll(tblEmployees.getItems());
        }

        try {
            FileOutputStream fos = new FileOutputStream(employeeDb);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
            oos.close();
            if (tblEmployees.getSelectionModel().isEmpty()) {
                tblEmployees.getItems().add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to save the employee").show();
            if (tblEmployees.getSelectionModel().isEmpty()) {
                employeeList.remove(employee);
            }
        }
        btnNewEmployee.fire();

    }
    public void validData() {
        isValid = true;
        if (rdoStatus.getSelectedToggle() == rdoMarried) {
            if (lstSpouseContacts.getItems().isEmpty()) {
                txtSpouseContact.requestFocus();
                isValid = false;
            }
            if (txtSpouseName.getText().isBlank()) {
                txtSpouseName.requestFocus();
                isValid = false;
            }
        }
        if (rdoStatus.getSelectedToggle() == null) {
            rdoSingle.requestFocus();
            isValid = false;
        }
        if (lstContacts.getItems().isEmpty()) {
            txtContacts.requestFocus();
            isValid = false;
        }
        if (txtName.getText().isBlank()) {
            txtName.requestFocus();
            isValid = false;
        }
        if (txtID.getText().isBlank()) {
            txtID.requestFocus();
            isValid = false;
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Employee employee = tblEmployees.getSelectionModel().getSelectedItem();
        tblEmployees.getItems().remove(employee);
        employeeList.remove(employee);

        try {
            FileOutputStream fos = new FileOutputStream(employeeDb);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    @FXML
    void tblEmployeesOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnDelete.fire();
    }

    @FXML
    void tblEmployeesOnMouseReleased(MouseEvent event) {

    }

}
