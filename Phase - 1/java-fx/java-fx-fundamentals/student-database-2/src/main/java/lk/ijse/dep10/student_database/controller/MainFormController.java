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


    public void initialize() {
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
    }

    @FXML
    void btnNewStudentOnActon(ActionEvent event) {
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
    }

    @FXML
    void btnShiftLeftOnAction(ActionEvent event) {
    }

    @FXML
    void btnShiftRightOnAction(ActionEvent event) {
    }

    @FXML
    void txtStudentNameOnAction(ActionEvent event) {
    }

    @FXML
    void txtStudentContactOnAction(ActionEvent event) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
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
