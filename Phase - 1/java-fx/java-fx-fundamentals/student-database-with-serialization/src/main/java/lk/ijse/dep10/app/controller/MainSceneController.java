package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.app.model.Student;

import java.io.*;
import java.util.ArrayList;

public class MainSceneController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Student> tblStudent;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAddress;
    private boolean idIsBlank = true;
    private boolean nameIsBlank = true;
    private boolean addressIsBlank = true;
    File file = new File("/home/gayashan/Documents/DEP/Phase - 1/java-fx/java-fx-fundamentals/student-database-with-serialization/student-database.dep");;
    private ArrayList<Student> studentList = new ArrayList<>();

    public void initialize() {
        /*Disabling and enabling save and delete button*/
        txtId.textProperty().addListener((value, previous, current) -> {
            if (current.isBlank()) {
                idIsBlank = true;
            } else {
                idIsBlank = false;
            }

            if (!(current.isBlank() || nameIsBlank || addressIsBlank)) {
                btnSave.setDisable(false);
                return;
            }
            btnSave.setDisable(true);
        });
        txtName.textProperty().addListener((value, previous, current) -> {
            if (current.isBlank()) {
                nameIsBlank = true;
            } else {
                nameIsBlank = false;
            }

            if (!(current.isBlank() || idIsBlank || addressIsBlank)) {
                btnSave.setDisable(false);
                return;
            }
            btnSave.setDisable(true);
        });
        txtAddress.textProperty().addListener((value, previous, current) -> {
            if (current.isBlank()) {
                addressIsBlank = true;
            } else {
                addressIsBlank = false;
            }

            if (!(current.isBlank() || idIsBlank || nameIsBlank)) {
                btnSave.setDisable(false);
                return;
            }
            btnSave.setDisable(true);
        });

        /*Column mapping*/
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        tblStudent.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            Student student = current;

            if (student == null) {
                btnDelete.setDisable(true);
                return;
            }

            btnDelete.setDisable(false);
            txtId.setText(student.getId());
            txtName.setText(student.getName());
            txtAddress.setText(student.getAddress());
        });

        /*Importing students from saved file*/
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                studentList = (ArrayList<Student>) ois.readObject();
                ois.close();

                tblStudent.getItems().addAll(studentList);
            }

        } catch (IOException | ClassNotFoundException e) {
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Student deletingStudent = tblStudent.getSelectionModel().getSelectedItem();
        tblStudent.getItems().remove(deletingStudent);
        studentList.remove(deletingStudent);
        btnNewStudent.fire();
        writeToFile();
    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {
        idIsBlank = true;
        nameIsBlank = true;
        addressIsBlank = true;

        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtId.requestFocus();

        btnDelete.setDisable(true);
        btnSave.setDisable(true);
        tblStudent.getSelectionModel().clearSelection();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Student student = new Student(txtId.getText(), txtName.getText(), txtAddress.getText());
        tblStudent.getItems().add(student);
        btnNewStudent.fire();
        studentList.add(student);
        writeToFile();
    }

    private void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
        } catch (IOException e) {
        }
    }

}
