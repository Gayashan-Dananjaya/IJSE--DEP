package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep10.app.model.Student;

import java.util.Optional;

public class ListViewSceneController {

    public Button btnNew;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSave;
    public Button btnDelete;
    public ListView<Student> lstStudents;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblSelectedName;

    @FXML
    private ListView<String> lstNames;

    @FXML
    private TextField txtInput;


    public void initialize() {
        lstNames.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {

            if (current == null) {
                lblSelectedName.setText("No Name has been selected");
                btnRemove.setDisable(true);
                return;
            }

            lblSelectedName.setText("Selected Name : " + current);
            btnRemove.setDisable(false);
        });

        lstStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                btnDelete.setDisable(true);
                return;
            }
            btnDelete.setDisable(false);
            txtId.setText(current.id);
            txtName.setText(current.name);
            txtAddress.setText(current.address);
            txtId.setDisable(true);
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String input = txtInput.getText();
        if (input.isBlank()){
            txtInput.selectAll();
            txtInput.requestFocus();
            return;
        }


        ObservableList<String> names = lstNames.getItems();
        names.add(input.trim());

        lstNames.getSelectionModel().clearSelection();
        txtInput.clear();
        txtInput.requestFocus();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to remove selected item?",ButtonType.NO,ButtonType.YES);
        alert.setTitle("Delete Confirmation");
//        alert.setHeaderText("Do you want to remove selected item?");

        Optional<ButtonType> button = alert.showAndWait();
        if (button.isPresent() && button.get() == ButtonType.YES) {
            int index = lstNames.getSelectionModel().selectedIndexProperty().get();
            lstNames.getItems().remove(index);
        }
        lstNames.getSelectionModel().clearSelection();
        txtInput.requestFocus();
    }

    public void lstNamesOnKeyRelease(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE) {
            btnRemove.fire();
        }
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        btnSave.setDisable(false);

        txtId.clear();
        txtName.clear();
        txtAddress.clear();

        txtId.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");

        lstStudents.getSelectionModel().clearSelection();

        txtId.requestFocus();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        boolean isValid = true;

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        txtId.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");

        /*Data Validation*/
        if (txtAddress.getText().isBlank() || txtAddress.getText().trim().length() < 3) {
            txtAddress.getStyleClass().add("invalid");
            txtAddress.requestFocus();
            txtAddress.selectAll();
            isValid = false;
        }


        if (txtName.getText().isBlank()) {
            txtName.getStyleClass().add("invalid");
            txtName.requestFocus();
            txtName.selectAll();
            isValid = false;
        }

        if (id.isBlank() || id.charAt(0) != 'S' || id.substring(1).length() < 3 || !isNumber(id.substring(1))) {
            txtId.getStyleClass().add("invalid");
            txtId.selectAll();
            txtId.requestFocus();
            isValid = false;
        }

        if (!isValid) return;

        ObservableList<Student> studentList = lstStudents.getItems();

        if (lstStudents.getSelectionModel().getSelectedIndex() == -1) {
            /*Business validation*/
            for (Student student : studentList) {
                if (student.id.equals(id)) {
                    txtId.getStyleClass().add("invalid");
                    txtId.requestFocus();
                    txtId.selectAll();
                    return;
                }
            }

            studentList.add(new Student(id, name, address));
        } else {
            Student student = lstStudents.getSelectionModel().getSelectedItem();
            student.name = txtName.getText();
            student.address = txtAddress.getText();
        }
        btnNew.fire();

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Student student = lstStudents.getSelectionModel().getSelectedItem();
        String id = lstStudents.getSelectionModel().getSelectedItem().id;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete the student ID : " + id, ButtonType.NO, ButtonType.YES);
        Optional<ButtonType> button = alert.showAndWait();
        if (button.isEmpty() || button.get() == ButtonType.NO) return;

        lstStudents.getItems().remove(student);
        btnNew.fire();
    }

    public void txtOnAction(ActionEvent actionEvent) {
        btnSave.fire();
    }

    private boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(Character.isDigit(input.charAt(i)))) return false;
        }
        return true;
    }

    public void lstStudentsOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE) {
            btnDelete.fire();
        }
    }
}
