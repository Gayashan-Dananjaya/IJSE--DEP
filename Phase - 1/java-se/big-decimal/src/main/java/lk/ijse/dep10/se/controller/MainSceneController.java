package lk.ijse.dep10.se.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.se.model.Item;

import java.math.BigDecimal;

public class MainSceneController {

    public Label lblTotal;
    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblCode;

    @FXML
    private Label lblCode1;

    @FXML
    private Label lblCode11;

    @FXML
    private Label lblCode111;

    @FXML
    private Label lblCode1111;

    @FXML
    private TableView<Item> tblItems;

    @FXML
    private TextField txtBuyingPrice;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtSellingPrice;

    @FXML
    private TextField txtQuantity;

    public void initialize() {
        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        tblItems.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("profit"));
        tblItems.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblItems.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("total"));
        tblItems.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("totalProfit"));
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtCode.setText(generateNewItemCode());

        txtDescription.clear();
        txtBuyingPrice.clear();
        txtSellingPrice.clear();
        txtQuantity.clear();

        tblItems.getSelectionModel().clearSelection();

        txtDescription.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (tblItems.getSelectionModel().isEmpty()) {
            Item item = new Item(
                    txtCode.getText(),
                    txtDescription.getText(),
                    new BigDecimal(txtBuyingPrice.getText()),
                    new BigDecimal(txtSellingPrice.getText()),
                    Integer.parseInt(txtQuantity.getText())
            );
            tblItems.getItems().add(item);

            lblTotal.setText("Est. Total Profit : " + calculateEstimatedProfit());

            btnNew.fire();
        }
    }

    private String generateNewItemCode() {
        ObservableList<Item> itemList = tblItems.getItems();
        int number = itemList.size();
        if (itemList.isEmpty()) return "I001";

        String lastItemCode = itemList.get(itemList.size() - 1).getCode();
        int newItemCode = Integer.parseInt(lastItemCode.substring(1)) + 1;
        return String.format("I%03d", newItemCode);
    }

    private String calculateEstimatedProfit() {
        ObservableList<Item> itemList = tblItems.getItems();
        BigDecimal estimatedTotalProfit = BigDecimal.ZERO;
        for (Item item : itemList) {
            estimatedTotalProfit = estimatedTotalProfit.add(item.getTotalProfit());
        }
        return estimatedTotalProfit.setScale(2).toString();
    }

}
