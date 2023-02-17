package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import lk.ijse.dep10.app.model.Student;
import lk.ijse.dep10.app.util.Gender;

import java.util.ArrayList;

public class MainFormController {

    public ToggleGroup gender;
    public Label lblCode;
    public TableView<Student> tblStudent;
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
    private CheckBox chkPartTime;

    @FXML
    private ComboBox<String> cmbDegree;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblId;

    @FXML
    private ListView<String> lstContact;

    @FXML
    private ListView<String> lstModule;

    @FXML
    private ListView<String> lstSelectedModule;

    @FXML
    private RadioButton rdoFemale;

    @FXML
    private RadioButton rdoMale;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;


    public void initialize() {
        lstContact.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstModule.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstSelectedModule.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        cmbDegree.getItems().addAll("Software Engineering", "Cyber Security", "Network Engineering");

        /*Column Mapping*/
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("degree"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("partTime"));

        txtName.textProperty().addListener((value, previous, current) -> {
            txtName.getStyleClass().remove("invalid");
            if (current.isBlank()) {
                txtName.getStyleClass().add("invalid");
            } else {
                for (char c : current.trim().toCharArray()) {
                    if (!(Character.isLetter(c) || Character.isSpaceChar(c))) {
                        txtName.getStyleClass().add("invalid");
                        return;
                    }
                }
            }
        });
        txtContact.textProperty().addListener((value, previous, current) -> {
            txtContact.getStyleClass().remove("invalid");
            btnAdd.setDisable(true);
            if (current.length() != 11) {
                txtContact.getStyleClass().add("invalid");
                return;
            }
            int count = 0;
            for (char c : current.toCharArray()) {
                if (count == 3) {
                    if (current.charAt(3) != '-') {
                        txtContact.getStyleClass().add("invalid");
                        return;
                    }
                }
                if (!(Character.isDigit(c))) {
                    if (count == 3) continue;
                    txtContact.getStyleClass().add("invalid");
                    return;
                }
                count++;
            }
            btnAdd.setDisable(false);
        });
        lstContact.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnRemove.setDisable(current == null);
        });
        cmbDegree.getSelectionModel().selectedIndexProperty().addListener((value, previous, current) -> {
            if (current.intValue() == -1) {
                lstModule.getItems().clear();
                lstSelectedModule.getItems().clear();
                lblCode.setText("");
            } else if (current.intValue() == 0) {
                lstModule.getItems().clear();
                lstSelectedModule.getItems().clear();
                lstModule.getItems().addAll("Computer Programming", "Algorithms", "Data Structures", "Web Development");
                lblCode.setText("SE");
                cmbDegree.getStyleClass().remove("invalid");
            } else if (current.intValue() == 1) {
                lstModule.getItems().clear();
                lstSelectedModule.getItems().clear();
                lstModule.getItems().addAll("Cyber Threat Intelligence", "Host & Network Security", "Cyber Engineering", "Malware Analysis");
                lblCode.setText("CS");
                cmbDegree.getStyleClass().remove("invalid");
            }else if (current.intValue() == 2) {
                lstModule.getItems().clear();
                lstSelectedModule.getItems().clear();
                lstModule.getItems().addAll("Computer Networks", "Routing and Switching", "Wireless Networks");
                lblCode.setText("NE");
                cmbDegree.getStyleClass().remove("invalid");
            }
        });
        lstModule.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                btnForward.setDisable(true);
            } else {
                btnForward.setDisable(false);
            }
        });
        lstSelectedModule.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                btnBack.setDisable(true);
            } else {
                btnBack.setDisable(false);
            }
        });
        rdoMale.getToggleGroup().selectedToggleProperty().addListener((value, previous, current) -> {
            rdoMale.getStyleClass().remove("invalid");
            rdoFemale.getStyleClass().remove("invalid");
        });
        tblStudent.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (tblStudent.getSelectionModel().isEmpty()) {
                btnDelete.setDisable(true);
                return;
            }
            btnDelete.setDisable(false);

            Student student = tblStudent.getSelectionModel().getSelectedItem();

            lblId.setText(student.getId());
            txtName.setText(student.getName());
            rdoMale.getToggleGroup().selectToggle(
                    (student.getGender() == Gender.MALE) ? rdoMale : rdoFemale
            );
            lstContact.getItems().clear();
            lstContact.getItems().addAll(student.getContact());
            cmbDegree.getSelectionModel().select(student.getDegree());
            lstSelectedModule.getItems().addAll(student.getModules());
            lstModule.getItems().removeAll(lstSelectedModule.getItems());
            chkPartTime.setSelected(student.isPartTime());

        });
    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {

        btnDelete.setDisable(true);
        btnRemove.setDisable(true);

        txtName.setDisable(false);
        txtContact.setDisable(false);
        rdoMale.setDisable(false);
        rdoFemale.setDisable(false);
        cmbDegree.setDisable(false);
        btnSave.setDisable(false);
        chkPartTime.setDisable(false);

        lblId.setText("Save to generate the ID");
        txtName.clear();
        txtContact.clear();
        rdoMale.getToggleGroup().selectToggle(null);
        cmbDegree.getSelectionModel().clearSelection();
        chkPartTime.setSelected(false);
        lstContact.getItems().clear();

        tblStudent.getSelectionModel().clearSelection();

        lstSelectedModule.getStyleClass().remove("invalid");
        cmbDegree.getStyleClass().remove("invalid");
        txtContact.getStyleClass().remove("invalid");
        rdoMale.getStyleClass().remove("invalid");
        rdoFemale.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        lstContact.getItems().add(txtContact.getText());
        txtContact.clear();
        txtContact.requestFocus();
        txtContact.getStyleClass().remove("invalid");
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        lstModule.getItems().addAll(lstSelectedModule.getSelectionModel().getSelectedItems());
        lstSelectedModule.getItems().removeAll(lstSelectedModule.getSelectionModel().getSelectedItems());
        lstSelectedModule.getSelectionModel().clearSelection();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
        tblStudent.getSelectionModel().clearSelection();
        btnNewStudent.fire();
        tblStudent.refresh();
    }

    @FXML
    void btnForwardOnAction(ActionEvent event) {
        lstSelectedModule.getStyleClass().remove("invalid");
        lstSelectedModule.getItems().addAll(lstModule.getSelectionModel().getSelectedItems());
        lstModule.getItems().removeAll(lstModule.getSelectionModel().getSelectedItems());
        lstModule.getSelectionModel().clearSelection();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        lstContact.getItems().removeAll(lstContact.getSelectionModel().getSelectedItems());
        lstContact.getSelectionModel().clearSelection();
        txtContact.clear();
        txtContact.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isValid = true;

        if (lstSelectedModule.getItems().size() < 2) {
            isValid = false;
            lstSelectedModule.getStyleClass().add("invalid");
            lstModule.requestFocus();
        }

        if (cmbDegree.getSelectionModel().isEmpty()) {
            isValid = false;
            cmbDegree.getStyleClass().add("invalid");
            cmbDegree.requestFocus();
        }

        if (lstContact.getItems().isEmpty()) {
            isValid = false;
            txtContact.getStyleClass().add("invalid");
            txtContact.clear();
            txtContact.requestFocus();
        }

        if (rdoFemale.getToggleGroup().getSelectedToggle() == null) {
            isValid = false;
            rdoFemale.getStyleClass().add("invalid");
            rdoMale.getStyleClass().add("invalid");
            rdoMale.requestFocus();
        }

        if (txtName.getStyleClass().contains("invalid") || txtName.getText().isBlank()) {
            isValid = false;
            txtName.selectAll();
            txtName.requestFocus();
            if (!txtName.getStyleClass().contains("invalid")) {
                txtName.getStyleClass().add("invalid");
            }
        }

        if (!isValid) return;


        String generatedId = idGenerate(cmbDegree.getSelectionModel().getSelectedIndex());

        if (tblStudent.getSelectionModel().isEmpty()) {
            Student student = new Student(
                    generatedId,
                    txtName.getText().trim(),
                    (rdoMale.isSelected()) ? Gender.MALE : Gender.FEMALE,
                    new ArrayList<String>(lstContact.getItems()),
                    cmbDegree.getSelectionModel().getSelectedItem(),
                    new ArrayList<String>(lstSelectedModule.getItems()),
                    chkPartTime.isSelected()
            );
            tblStudent.getItems().add(student);
            btnNewStudent.fire();
            tblStudent.getSelectionModel().select(student);
        } else {
            Student student = tblStudent.getSelectionModel().getSelectedItem();
            student.setName(txtName.getText());
            student.setGender((rdoMale.isSelected()) ? Gender.MALE : Gender.FEMALE);
            student.setContact(new ArrayList<String>(lstContact.getItems()));

            if (!(cmbDegree.getSelectionModel().getSelectedItem().equals(student.getDegree()))) {
                student.setId(idGenerate(cmbDegree.getSelectionModel().getSelectedIndex()));
            }

            student.setDegree(cmbDegree.getSelectionModel().getSelectedItem());

            student.setModules(new ArrayList<String>(lstSelectedModule.getItems()));
            student.setPartTime(chkPartTime.isSelected());
            btnNewStudent.fire();
            tblStudent.getSelectionModel().select(student);
            tblStudent.refresh();
        } 

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {
        btnAdd.fire();
    }

    public void lstContactOnKeyReleased(KeyEvent keyEvent) {
        if (lstContact.getSelectionModel().getSelectedItems() == null) return;
        if (keyEvent.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    public void lstModuleOnKeyReleased(KeyEvent keyEvent) {
        if (lstModule.getSelectionModel().isEmpty()) return;
        if (keyEvent.getCode() == KeyCode.ENTER) btnForward.fire();
    }

    public void lstSelectedModuleOnKeyReleased(KeyEvent keyEvent) {
        if (lstSelectedModule.getSelectionModel().isEmpty()) return;
        if (keyEvent.getCode() == KeyCode.DELETE) btnBack.fire();
    }

    public void tblStudentOnKeyReleased(KeyEvent keyEvent) {
    }

    private String idGenerate(int index) {
        String part1 = "S-";
        String part2;
        String part3;
        int num;

        if (index == 0) {
            part2 = "SE-";
        } else if (index == 1) {
            part2 = "CS-";
        } else part2 = "NE-";

        if (tblStudent.getItems().size() == 0) {
            num = 1;
        } else {
            int count = 0;
            for (Student student : tblStudent.getItems()) {
                if (student.getId().substring(2,5).equals(part2)) count++;
            }
            num = ++count;
        }

        part3 = String.format("S%03d", num);

        return part1 + part2 + part3;
    }
}