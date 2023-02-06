package lk.ijse.dep10.exercise2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        studentForm(primaryStage);
    }

    private void studentForm(Stage stage) {
        Label title = new Label("Student Form");
        Font fontTitle = Font.font("", FontWeight.BOLD, 50);
        title.setFont(fontTitle);
        title.setTextFill(Color.BLACK);
        title.setPadding(new Insets(0,0,25,0));
        title.setAlignment(Pos.CENTER);

        Label lblId = new Label("ID :");
        Label lblName = new Label("Name :");
        Label lblNic = new Label("NIC :");
        Label lblContact = new Label("Contact :");

        Font fontLbl = Font.font("", FontWeight.THIN, 20);
        lblId.setFont(fontLbl);
        lblName.setFont(fontLbl);
        lblNic.setFont(fontLbl);
        lblContact.setFont(fontLbl);
        lblContact.setPadding(new Insets(0,0,0,30));

        TextField txtId = new TextField();
        TextField txtName = new TextField();
        TextField txtNic = new TextField();
        TextField txtContact = new TextField();
        txtId.setMaxWidth(Double.MAX_VALUE);
        txtName.setMaxWidth(Double.MAX_VALUE);
        txtNic.setMaxWidth(Double.MAX_VALUE);
        txtContact.setMaxWidth(Double.MAX_VALUE);
        txtContact.setPromptText("Ex: 0XX-XXXXXXX");

        Label lblInvalidId = new Label("Invalid ID! Enter correct ID.");
        Label lblInvalidName = new Label("Invalid Name! Enter correct Name.");
        Label lblInvalidNic = new Label("Invalid NIC! Enter correct NIC.");
        Label lblInvalidContact = new Label("Invalid contact! Enter correct contact number.");

        Font fontInvalidLbl = Font.font("", FontWeight.THIN, 12);
        lblInvalidId.setFont(fontInvalidLbl);
        lblInvalidId.setTextFill(Color.RED);
        lblInvalidId.setVisible(false);
        lblInvalidId.setPadding(new Insets(0,0,20,0));
        lblInvalidName.setFont(fontInvalidLbl);
        lblInvalidName.setTextFill(Color.RED);
        lblInvalidName.setVisible(false);
        lblInvalidName.setPadding(new Insets(0,0,20,0));
        lblInvalidNic.setFont(fontInvalidLbl);
        lblInvalidNic.setTextFill(Color.RED);
        lblInvalidNic.setVisible(false);
        lblInvalidNic.setPadding(new Insets(0,0,20,0));
        lblInvalidContact.setFont(fontInvalidLbl);
        lblInvalidContact.setTextFill(Color.RED);
        lblInvalidContact.setVisible(false);
        lblInvalidContact.setPadding(new Insets(0,0,20,0));

        Button btnValidate = new Button("Validate");
        btnValidate.setTextFill(Color.WHITE);
        btnValidate.setBackground(Background.fill(Color.BLUE));
        btnValidate.setFont(fontLbl);
        btnValidate.setDefaultButton(true);

        GridPane root = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.NEVER);
        column1.setHalignment(HPos.RIGHT);
        column1.setMinWidth(130);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        column2.setHalignment(HPos.LEFT);
        GridPane.setHalignment(title,HPos.CENTER);


        root.getColumnConstraints().add(column1);
        root.getColumnConstraints().add(column2);

        column2.setMaxWidth(Double.MAX_VALUE);

        root.setPadding(new Insets(30));
        root.setHgap(20);
        root.setMinWidth(350);
//        root.setGridLinesVisible(true);

        root.add(title,0,0,2,1);
        root.add(lblId,0,1);
        root.add(txtId, 1, 1);
        root.add(lblInvalidId,1,2);
        root.add(lblName,0,3);
        root.add(txtName, 1, 3);
        root.add(lblInvalidName,1,4);
        root.add(lblNic,0,5);
        root.add(txtNic, 1, 5);
        root.add(lblInvalidNic,1,6);
        root.add(lblContact,0,7);
        root.add(txtContact, 1, 7);
        root.add(lblInvalidContact,1,8);
        root.add(btnValidate,1,9);

        Scene scene = new Scene(root);
        stage.setMinWidth(350);
        stage.setMinHeight(460);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.sizeToScene();

        btnValidate.setOnAction(event -> {
            boolean valid = validate(txtId.getText(),txtName.getText(),txtNic.getText(),txtContact.getText(),lblInvalidId,lblInvalidName,lblInvalidNic,lblInvalidContact);
            if (valid) secondPage(stage);
        });

    }

    private boolean validate(String id, String name, String nic, String contact,Label lblId, Label lblName, Label lblNic, Label lblContact) {
        if (isValidId(id)) lblId.setVisible(false);
        else lblId.setVisible(true);

        if (isValidName(name)) lblName.setVisible(false);
        else lblName.setVisible(true);

        if (isValidNic(nic)) lblNic.setVisible(false);
        else lblNic.setVisible(true);

        if (isValidContact(contact)) lblContact.setVisible(false);
        else lblContact.setVisible(true);

        return (isValidId(id) && isValidName(name) && isValidNic(nic) && isValidContact(contact));
    }
    private boolean isValidId(String id) {
        char[] charArray = id.toCharArray();
        if ((charArray.length == 4) && (Character.toString(charArray[0]).toUpperCase().equals("S")) && (Character.isDigit(charArray[1])) && (Character.isDigit(charArray[2])) && (Character.isDigit(charArray[3]))) {
            return true;
        } else return false;
    }
    private boolean isValidName(String name) {
        if (name.isBlank()) return false;
        return true;
    }
    private boolean isValidNic(String nic) {
        char[] charArray = nic.toCharArray();
        if (charArray.length != 10) return false;
        if (!(Character.toString(charArray[9]).toUpperCase().equals("V"))) return false;
        for (int i = 0; i < 9; i++) {
            if (!(Character.isDigit(charArray[i]))) return false;
        }
        return true;
    }
    private boolean isValidContact(String contact) {
        char[] charArray = contact.toCharArray();
        if (charArray.length != 11) return false;
        for (int i = 0; i < 11; i++) {
            if (i == 3) {
                if (!(charArray[i] == '-')) return false;
                continue;
            }
            if (!(Character.isDigit(charArray[i]))) return false;
        }
        return true;
    }
    private void secondPage(Stage stage) {
        Label lbl = new Label("Validated Successfully");
        Font font = new Font(20);
        lbl.setFont(font);
        Button btn = new Button("Back");

        VBox container = new VBox(lbl, btn);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(50));
        container.setSpacing(25);
        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.sizeToScene();

        btn.setOnAction(event -> {
            studentForm(stage);
        });
    }
}
