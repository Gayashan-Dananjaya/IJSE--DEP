package lk.ijse.dep10.app.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextInputDialog;
import lk.ijse.dep10.app.util.SinglyLinkedList;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

public class MainFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnContains;

    @FXML
    private Button btnPrint;

    @FXML
    private Button btnPrintAll;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSize;

    @FXML
    private TextField txtNumber;
//    private LinkedList numbers = new LinkedList();
    private SinglyLinkedList numbers = new SinglyLinkedList();
    @FXML
    void btnAddOnAction(ActionEvent event) {
        String value = txtNumber.getText();
        numbers.add(value);
        txtNumber.clear();
        txtNumber.requestFocus();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        numbers.clear();
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter the value");
        prompt.setHeaderText("Enter the value");
        Optional<String> optInput = prompt.showAndWait();
        if (optInput.isEmpty() || optInput.get().isBlank()) return;

        String input = optInput.get();
        System.out.println(numbers.contains(input));
    }

    @FXML
    void btnPrintAlOnAction(ActionEvent event) {
        System.out.println(numbers);
    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter the index");
        prompt.setHeaderText("Enter the index");
        Optional<String> optInput = prompt.showAndWait();
        if (optInput.isEmpty() || optInput.get().isBlank()) return;

        int index = Integer.parseInt(optInput.get());
        if (index < 0 || index > numbers.size()) {
            System.out.println("Invalid Index");
            return;
        }
        System.out.println(numbers.get(index));
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter the index to remove");
        prompt.setHeaderText("Enter the index to remove");
        Optional<String> optInput = prompt.showAndWait();
        if (optInput.isEmpty() || optInput.get().isBlank()) return;

        String input = optInput.get();
        int index = Integer.parseInt(input);
        if (index < 0 || index > numbers.size()) {
            System.err.println("Invalid Index");
            return;
        }
        numbers.remove(index);
    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        System.out.println("Size : " + numbers.size());
    }

}
