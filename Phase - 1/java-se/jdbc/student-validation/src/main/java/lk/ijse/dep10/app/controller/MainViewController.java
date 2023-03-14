package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.app.model.Gender;
import lk.ijse.dep10.app.model.Student;

import java.io.Serializable;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainViewController implements Serializable {
    public Button btnDelete;
    public Button btnNewStudent;
    public Button btnSave;
    public ComboBox<String> cmbGender;
    public DatePicker dtpDateOfBirth;
    public TableView<Student> tblStudentDetails;
    public TextField txtFirstName;
    public TextField txtId;
    public TextField txtLastName;
    public TextField txtAddress;
    public String url = "jdbc:mysql://dep10.lk:3306/dep_10_hello";
    public String username = "root";
    public String password = "Gayashan@1996";
    public Label lblMessage;


    public MainViewController() {
    }

    public void initialize() {
        btnDelete.setDisable(true);

        /*Combo Box fields*/
        ObservableList<String> genderList = cmbGender.getItems();
        genderList.add("MALE");
        genderList.add("FEMALE");

        /*TableView column mapping*/
        tblStudentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblStudentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("lastname"));
        tblStudentDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudentDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudentDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("dob"));

        /*Fetching from database*/
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Student");

            while (rst.next()) {
                int id = rst.getInt("id");
                String firstName = rst.getString("first_name");
                String lastName = rst.getString("last_name");
                String address = rst.getString("address");
                Gender gender = (rst.getString("gender").equals("MALE")) ? (Gender.MALE) : (Gender.FEMALE);
                LocalDate dob = LocalDate.parse(rst.getString("dob"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                Student student = new Student(id, firstName, lastName, address, gender, dob);
                tblStudentDetails.getItems().add(student);
            }
            tblStudentDetails.refresh();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*Fill the fields when select student from table*/
        tblStudentDetails.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            lblMessage.setText("");
            if (tblStudentDetails.getSelectionModel().isEmpty()) {
                btnDelete.setDisable(true);
                return;
            }
            btnDelete.setDisable(false);

            txtId.setText(Integer.toString(current.getId()));
            txtFirstName.setText(current.getFirstName());
            txtLastName.setText(current.getLastname());
            txtAddress.setText(current.getAddress());
            cmbGender.getSelectionModel().select((current.getGender() == Gender.MALE) ? 0 : 1);
            dtpDateOfBirth.setValue(current.getDob());
        });

    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {
        txtFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        cmbGender.getSelectionModel().clearSelection();
        dtpDateOfBirth.setValue(null);
        txtId.setText(Integer.toString(tblStudentDetails.getItems().get(tblStudentDetails.getItems().size() - 1).getId() + 1));

        tblStudentDetails.getSelectionModel().clearSelection();
        btnDelete.setDisable(true);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM Student WHERE id=");
            sb.append(txtId.getText());

            statement.executeUpdate(sb.toString());

        } catch (SQLException e) {
            lblMessage.setText("Record did not deleted, Try again");
            e.printStackTrace();
            return;
        }
        tblStudentDetails.getItems().remove(tblStudentDetails.getSelectionModel().getSelectedItem());
        btnNewStudent.fire();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!validate()) return;

        /*Update new student*/
        if (!tblStudentDetails.getSelectionModel().isEmpty()) {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                StringBuilder sb = new StringBuilder();

                sb.append("UPDATE Student SET id='");
                sb.append(txtId.getText());
                sb.append("', first_name='");
                sb.append(txtFirstName.getText());
                sb.append("', last_name='");
                sb.append(txtLastName.getText());
                sb.append("', address='");
                sb.append(txtAddress.getText());
                sb.append("', gender='");
                sb.append(cmbGender.getSelectionModel().getSelectedItem());
                sb.append("', dob='");
                sb.append(dtpDateOfBirth.getValue().toString());
                sb.append("' WHERE id='");
                sb.append(txtId.getText());
                sb.append("'");

                int affectedRows = statement.executeUpdate(sb.toString());
            } catch (SQLException e) {
                lblMessage.setText("Record update did not happen, Try again");
                e.printStackTrace();
                return;
            }
            Student student = tblStudentDetails.getSelectionModel().getSelectedItem();
            student.setFirstName(txtFirstName.getText());
            student.setLastname(txtLastName.getText());
            student.setAddress(txtAddress.getText());
            student.setGender((cmbGender.getSelectionModel().getSelectedIndex() == 0) ? Gender.MALE : Gender.FEMALE);
            student.setDob(dtpDateOfBirth.getValue());
            tblStudentDetails.refresh();

            btnNewStudent.fire();
        } else {
            /*Adding new Student*/
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                StringBuilder sb = new StringBuilder();

                sb.append("INSERT INTO Student VALUES (");
                sb.append(txtId.getText());
                sb.append(", '");
                sb.append(txtFirstName.getText());
                sb.append("', '");
                sb.append(txtLastName.getText());
                sb.append("', '");
                sb.append(txtAddress.getText());
                sb.append("', '");
                sb.append(cmbGender.getSelectionModel().getSelectedItem());
                sb.append("', '");
                sb.append(dtpDateOfBirth.getValue().toString());
                sb.append("')");

                int affectedRows = statement.executeUpdate(sb.toString());
            } catch (SQLException e) {
                lblMessage.setText("New student did not add, Try again");
                e.printStackTrace();
                return;
            }
            Student student = new Student(Integer.parseInt(txtId.getText()), txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), (cmbGender.getSelectionModel().getSelectedIndex() == 0) ? Gender.MALE : Gender.FEMALE, dtpDateOfBirth.getValue());
            tblStudentDetails.getItems().add(student);
        }

    }

    private boolean validate() {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String address = txtAddress.getText();
        Gender gender = (cmbGender.getSelectionModel().getSelectedIndex() == 0) ? (Gender.MALE) : (Gender.FEMALE);
        LocalDate dob = dtpDateOfBirth.getValue();
        LocalDate startDate = LocalDate.parse("1980-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse("2010-12-31", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        /*First Name validation*/
        if (!firstName.matches("[A-z]{3,}")) {
            txtFirstName.selectAll();
            txtFirstName.requestFocus();
            return false;
        }

        /*Second Name validation*/
        if (!lastName.matches("[A-z]{3,}")) {
            txtLastName.selectAll();
            txtLastName.requestFocus();
            return false;
        }

        /*Address validation*/
        if (!address.matches("[\\w,/]{3,}")) {
            txtAddress.selectAll();
            txtAddress.requestFocus();
            return false;
        }

        /*Gender validation*/
        if (cmbGender.getSelectionModel().isEmpty()) {
            cmbGender.requestFocus();
            return false;
        }

        /*Date of Birth validation*/
        if (dob.isAfter(endDate) || dob.isBefore(startDate)) {
            dtpDateOfBirth.requestFocus();
            return false;
        }

        return true;
    }

}
