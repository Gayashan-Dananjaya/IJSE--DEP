package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import lk.ijse.dep10.app.model.StudentInfo;
import lk.ijse.dep10.app.util.Gender;

import java.util.ArrayList;
import java.util.Optional;

public class ListViewExerciseController {

    public RadioButton rdoMale;
    public RadioButton rdoFemale;
    public Label lblGender;
    @FXML
    private ToggleGroup Gender;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnForward;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ListView<String> lstContacts;

    @FXML
    private ListView<String> lstModules;

    @FXML
    private ListView<String> lstSelectedModules;

    @FXML
    private ListView<StudentInfo> lstStudents;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize() {
        lstModules.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstSelectedModules.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        txtName.textProperty().addListener((value, previous, current) -> {
            char[] chars = current.toCharArray();
            txtName.getStyleClass().remove("invalid");
            for (char c : chars) {
                if (!(Character.isLetter(c)) && !(Character.isSpaceChar(c))) {
                    txtName.getStyleClass().add("invalid");
                    return;
                }
            }
        });

        txtContact.textProperty().addListener((value, previous, current) -> {
            txtContact.getStyleClass().remove("invalid");
            btnAdd.setDisable(false);

            if (current.length() != 11) btnAdd.setDisable(true);
            if (current.length() > 11) {
                txtContact.getStyleClass().add("invalid");
                return;
            }

            char[] chars = current.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (i == 3) {
                    if (chars[3] != '-') {
                        txtContact.getStyleClass().add("invalid");
                        btnAdd.setDisable(true);
                        return;
                    }
                } else {
                    if (!(Character.isDigit(chars[i]))) {
                        txtContact.getStyleClass().add("invalid");
                        btnAdd.setDisable(true);
                        return;
                    }
                }
            }

        });
        lstContacts.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnRemove.setDisable(current == null);
        });

        lstModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnForward.setDisable(current==null);
        });

        lstSelectedModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnBack.setDisable(current==null);
        });

        lstStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnDelete.setDisable(current == null);

            if (current == null) return;

            txtId.setText(current.id);
            txtName.setText(current.name);

            if (current.gender == lk.ijse.dep10.app.util.Gender.MALE) {
                rdoMale.getToggleGroup().selectToggle(rdoMale);
            } else rdoFemale.getToggleGroup().selectToggle(rdoFemale);

            txtContact.clear();
            lstContacts.getItems().addAll(current.contacts);
            lstSelectedModules.getItems().addAll(current.modules);
            lstModules.getItems().removeAll(current.modules);

        });
    }
    @FXML
    void btnAddOnAction(ActionEvent event) {
        ObservableList<String> contactList = lstContacts.getItems();
        lstContacts.getSelectionModel().clearSelection();

        for (String contact : contactList) {
            if ((txtContact.getText().trim()).equals(contact)) {
                txtContact.getStyleClass().add("invalid");
                return;
            }
        }

        contactList.add(txtContact.getText().strip());
        txtContact.clear();
        txtContact.requestFocus();
        lstContacts.getSelectionModel().clearSelection();
        lstContacts.getStyleClass().remove("invalid");
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        ObservableList<String> modules = lstModules.getItems();
        modules.addAll(lstSelectedModules.getSelectionModel().getSelectedItems());
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        selectedModules.removeAll(lstSelectedModules.getSelectionModel().getSelectedItems());
        lstSelectedModules.getSelectionModel().clearSelection();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure to delete this student?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> button = alert.showAndWait();
        if (button.isEmpty() || button.get() == ButtonType.NO) return;
        lstStudents.getItems().remove(lstStudents.getSelectionModel().getSelectedItem());

    }

    @FXML
    void btnForwardOnAction(ActionEvent event) {
        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        selectedModules.addAll(lstModules.getSelectionModel().getSelectedItems());
        ObservableList<String> modules = lstModules.getItems();
        modules.removeAll(lstModules.getSelectionModel().getSelectedItems());
        lstModules.getSelectionModel().clearSelection();
        lstSelectedModules.getStyleClass().remove("invalid");
    }

    @FXML
    void btnNewStudentOnActon(ActionEvent event) {
        lstStudents.getSelectionModel().clearSelection();
        txtId.setText(generateNewStudentId());
        lblGender.setTextFill(Color.BLACK);

        txtName.getStyleClass().remove("invalid");
        txtContact.getStyleClass().remove("invalid");
        lstContacts.getStyleClass().remove("invalid");
        lstSelectedModules.getStyleClass().remove("invalid");

//        txtId.setDisable(false);
        txtName.setDisable(false);
        txtContact.setDisable(false);
        btnSave.setDisable(false);
        rdoMale.setDisable(false);
        rdoFemale.setDisable(false);

        txtName.clear();
        txtContact.clear();
        rdoMale.getToggleGroup().selectToggle(null);

        ObservableList<String> moduleList = lstModules.getItems();
        moduleList.clear();
        moduleList.addAll("ObjectOriented Programming", "Programming Fundamentals", "Database Management System",
                "Angular", "RxJS", "React JS", "Docker", "Mongo DB", "Cloud Native Applications");

        ObservableList<String> contactList = lstContacts.getItems();
        contactList.clear();

        ObservableList<String> selectedModulesList = lstSelectedModules.getItems();
        selectedModulesList.clear();

        txtName.requestFocus();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        ObservableList<String> contactList = lstContacts.getItems();
        contactList.remove(lstContacts.getSelectionModel().getSelectedItem());
        lstContacts.getSelectionModel().clearSelection();
        txtContact.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isDataValid = true;

        lblGender.setTextFill(Color.BLACK);
        lstContacts.getStyleClass().remove("invalid");
        lstSelectedModules.getStyleClass().remove("invalid");

        String name = txtName.getText();
        String contact = txtContact.getText();

        /*Module Validation*/
        if (lstSelectedModules.getItems().size() < 3) {
            isDataValid = false;
            lstSelectedModules.getStyleClass().add("invalid");
            lstModules.requestFocus();
        }

        /*Contact Validation*/
        if (lstContacts.getItems().isEmpty()) {
            isDataValid = false;
            lstContacts.getStyleClass().add("invalid");
            txtContact.selectAll();
            txtContact.requestFocus();
        }

        /*Gender validation*/
        if (rdoMale.getToggleGroup().getSelectedToggle() == null) {
            isDataValid = false;
            rdoMale.requestFocus();
            lblGender.setTextFill(Color.RED);
        }

        /*Name validation*/
        if (name.isEmpty() || txtName.getStyleClass().contains("invalid")) {
            new Alert(Alert.AlertType.ERROR, "Name is invalid or empty").showAndWait();
            isDataValid = false;
            if (!txtName.getStyleClass().contains("invalid")) {
                txtName.getStyleClass().add("invalid");
            }
            txtName.selectAll();
            txtName.requestFocus();
        }

        if (!isDataValid) return;

        StudentInfo selectedStudent = lstStudents.getSelectionModel().getSelectedItem();

        /*Business Validation*/
        ObservableList<StudentInfo> studentList = lstStudents.getItems();
        for (StudentInfo student : studentList) {
            if (student == selectedStudent) continue;
            for (String cont : student.contacts) {
                if (isDuplicate(cont)) {
                    new Alert(Alert.AlertType.ERROR,
                            String.format("Contact number %s is already exists", cont)).showAndWait();
                    lstContacts.getStyleClass().add("invalid");
                    lstContacts.requestFocus();
                    return;
                }
            }
        }

        if (selectedStudent == null) { // add
            StudentInfo student = new StudentInfo(txtId.getText(),
                    txtName.getText(),
                    rdoMale.isSelected() ? lk.ijse.dep10.app.util.Gender.MALE : lk.ijse.dep10.app.util.Gender.FEMALE,
                    new ArrayList<>(lstContacts.getItems()),
                    new ArrayList<>(lstSelectedModules.getItems()));
            studentList.add(student);
        } else { // Update
            selectedStudent.name = txtName.getText().strip();
            selectedStudent.gender = rdoMale.isSelected() ? lk.ijse.dep10.app.util.Gender.MALE : lk.ijse.dep10.app.util.Gender.FEMALE;
            selectedStudent.contacts.clear();
            selectedStudent.contacts.addAll(new ArrayList<>(lstContacts.getItems()));
            selectedStudent.modules.clear();
            selectedStudent.modules.addAll(new ArrayList<>(lstSelectedModules.getItems()));
        }
        btnNewStudent.fire();
    }

    @FXML
    void lstContactsOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    @FXML
    void lstModulesOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) btnForward.fire();
    }

    @FXML
    void lstSelectedModulesOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnBack.fire();
    }

    @FXML
    void lstStudentsOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {
        btnAdd.fire();
    }

    private String generateNewStudentId() {
        ObservableList<StudentInfo> studentList = lstStudents.getItems();
        if (studentList.isEmpty()) return "S001";
        String lastStudentId = studentList.get(studentList.size() - 1).id;
        int newId = Integer.parseInt(lastStudentId.substring(1));
        return String.format("S%03d", newId);
    }

    private boolean isDuplicate(String contact) {
        for (String enteredContact : lstContacts.getItems()) {
            if (enteredContact.equals(contact)) return true;
        }
        return false;
    }

}
