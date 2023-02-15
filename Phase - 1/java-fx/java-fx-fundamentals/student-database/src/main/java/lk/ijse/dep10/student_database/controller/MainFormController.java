package lk.ijse.dep10.student_database.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.dep10.student_database.model.Student;

import java.util.Optional;

public class MainFormController {

    public Button btnAdd;
    public Button btnRemove;
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnShiftLeft;

    @FXML
    private Button btnShiftRight;

    @FXML
    private ListView<String> lstRemainingModules;

    @FXML
    private ListView<String> lstSelectedModules;

    @FXML
    private ListView<String> lstStudentContact;

    @FXML
    private ListView<Student> lstStudentDetails;

    @FXML
    private TextField txtStudentContact;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;
    public int id = 1;
    public boolean isSelected = false;
//    String j;

    public void initialize() {
        String idText = String.format("S%03d", id);
        txtStudentId.setText(idText);

        lstStudentContact.getSelectionModel().selectedItemProperty().addListener(((value, previous, current) -> {
            if (lstStudentContact.getSelectionModel().getSelectedIndex() == -1) {
                btnRemove.setDisable(true);
                return;
            }
            btnRemove.setDisable(false);
            txtStudentContact.clear();
        }));

        lstRemainingModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                btnShiftRight.setDisable(true);
                return;
            }
            lstSelectedModules.getSelectionModel().clearSelection();
            btnShiftRight.setDisable(false);
        });

        lstSelectedModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                btnShiftLeft.setDisable(true);
                return;
            }
            lstRemainingModules.getSelectionModel().clearSelection();
            btnShiftLeft.setDisable(false);
        });

        lstStudentDetails.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                isSelected = false;
                btnDelete.setDisable(true);
                return;
            }
            isSelected = true;
            btnDelete.setDisable(false);

            Student student = lstStudentDetails.getSelectionModel().getSelectedItem();

            String id = student.id;
            String name = student.name;
            ObservableList<String> contact = student.contact;
            ObservableList<String> modules = student.modules;
            ObservableList<String> remainingModules = student.remainingModules;

            txtStudentId.setText(id);
            txtStudentName.setText(name);
            lstStudentContact.setItems(contact);
            lstSelectedModules.setItems(modules);
            lstRemainingModules.setItems(remainingModules);

//            ObservableList<String> remainingModules = lstRemainingModules.getItems();
//            ObservableList<String> remainingModules = FXCollections.observableArrayList();// lstRemainingModules.getItems();
//            remainingModules.clear();
//            remainingModules.addAll("React", "OOP", "DBMS", "PF", "Analysis");

//            for (String i : modules) {
//                System.out.println("--------------"+i);
//                for (String j : remainingModules) {
//                    System.out.println(j);
//                    if (i.equals(j)){
//                        remainingModules.remove(j);
//                        System.out.println("Done");
//                    }
//
//                }
//            }

        });

        lstRemainingModules.getItems().addAll("React", "OOP", "DBMS", "PF", "Analysis");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Student student = lstStudentDetails.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to remove student ID : " + student.id + " Name : " + student.name + "?", ButtonType.NO, ButtonType.YES);
        Optional<ButtonType> button = alert.showAndWait();

        if (button.isEmpty() || button.get() == ButtonType.NO) return;

        lstStudentDetails.getItems().remove(student);
        btnNewStudent.fire();
    }

    @FXML
    void btnNewStudentOnActon(ActionEvent event) {
        String idText = String.format("S%03d", id);
        txtStudentId.setText(idText);
        txtStudentName.clear();
        txtStudentContact.clear();

        txtStudentName.getStyleClass().remove("invalid");
        txtStudentContact.getStyleClass().remove("invalid");

        /*new ObservableLists*/
        ObservableList<String> newContact = FXCollections.observableArrayList();
        ObservableList<String> newModules = FXCollections.observableArrayList();
        ObservableList<String> newRemainingModules = FXCollections.observableArrayList();

        /*Assigning those new ObservableLists to istView*/
        lstStudentContact.setItems(newContact);
        lstSelectedModules.setItems(newModules);
        lstRemainingModules.setItems(newRemainingModules);

        lstRemainingModules.getItems().addAll("React", "OOP", "DBMS", "PF", "Analysis");
        lstStudentDetails.getSelectionModel().clearSelection();

        btnRemove.setDisable(true);
        btnDelete.setDisable(true);
        btnShiftLeft.setDisable(true);

        txtStudentName.requestFocus();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isValid = true;

        String studentId = txtStudentId.getText();
        String name = txtStudentName.getText();
        ObservableList<String> contact = lstStudentContact.getItems();
        ObservableList<String> modules = lstSelectedModules.getItems();
        ObservableList<String> remainingModules = lstRemainingModules.getItems();

        txtStudentName.getStyleClass().remove("invalid");
        txtStudentContact.getStyleClass().remove("invalid");

        /*Selected module validation*/
        if (lstSelectedModules.getItems().size() < 3) {
            lstRemainingModules.getSelectionModel().selectFirst();
            isValid = false;
        }

        /*Contact validation*/
        if (lstStudentContact.getItems().size() == 0) {
            txtStudentContact.getStyleClass().add("invalid");
            txtStudentContact.requestFocus();
            isValid = false;
        }

        /*name validation*/
        if (name.isBlank() || !isLetters(name)) {
            txtStudentName.requestFocus();
            txtStudentName.selectAll();
            txtStudentName.getStyleClass().add("invalid");
            isValid = false;
        }

        if (!isValid) return;

        if (!isSelected) {
            Student student = new Student(studentId, name, contact, modules, remainingModules);
            lstStudentDetails.getItems().add(student);
            id++;
        } else {
            Student student = lstStudentDetails.getSelectionModel().getSelectedItem();
            student.name = name;
            student.contact = contact;
            student.modules = modules;
        }
        btnNewStudent.fire();
    }

    @FXML
    void btnShiftLeftOnAction(ActionEvent event) {
        String selectedModule = lstSelectedModules.getSelectionModel().getSelectedItem();
        lstRemainingModules.getItems().add(selectedModule);
        lstSelectedModules.getItems().remove(selectedModule);
        lstSelectedModules.requestFocus();
    }

    @FXML
    void btnShiftRightOnAction(ActionEvent event) {
        String selectedModule = lstRemainingModules.getSelectionModel().getSelectedItem();
        lstSelectedModules.getItems().add(selectedModule);
        lstRemainingModules.getItems().remove(selectedModule);
        lstRemainingModules.requestFocus();
    }

    @FXML
    void txtStudentNameOnAction(ActionEvent event) {
        btnSave.fire();
    }

    @FXML
    void txtStudentContactOnAction(ActionEvent event) {
        btnAdd.fire();
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String input = txtStudentContact.getText();

        /*Data Validation*/
        if (input.length() != 11 || input.charAt(3) != '-' || !isNumber(input.substring(0, 3)) || !isNumber(input.substring(4))) {
            txtStudentContact.getStyleClass().add("invalid");
            txtStudentContact.selectAll();
            txtStudentContact.requestFocus();
            return;
        }

        /*Business validation*/
        ObservableList<String> contacts = lstStudentContact.getItems();
        for (int i = 0; i < contacts.size(); i++) {
            if (input.equals(contacts.get(i))) {
                txtStudentContact.getStyleClass().add("invalid");
                txtStudentContact.selectAll();
                txtStudentContact.requestFocus();
                return;
            }
        }

        contacts.add(input);
        txtStudentContact.getStyleClass().remove("invalid");
        txtStudentContact.requestFocus();
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to remove Contact No : " + lstStudentContact.getSelectionModel().getSelectedItem() + "?", ButtonType.NO, ButtonType.YES);
        Optional<ButtonType> button = alert.showAndWait();

        if (button.isEmpty() || button.get() == ButtonType.NO) {
            lstStudentContact.getSelectionModel().clearSelection();
            txtStudentContact.requestFocus();
            txtStudentContact.clear();
            return;
        }


        lstStudentContact.getItems().remove(lstStudentContact.getSelectionModel().getSelectedItem());
        lstStudentContact.getSelectionModel().clearSelection();
        txtStudentContact.getStyleClass().remove("invalid");
        txtStudentContact.requestFocus();
    }

    private boolean isNumber(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (!(Character.isDigit(c))) return false;
        }
        return true;
    }

    private boolean isLetters(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) return false;
        }
        return true;
    }
}
