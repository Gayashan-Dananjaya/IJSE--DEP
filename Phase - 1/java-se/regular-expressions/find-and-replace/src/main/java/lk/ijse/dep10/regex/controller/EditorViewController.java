package lk.ijse.dep10.regex.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.dep10.regex.util.SearchResult;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditorViewController {

    public Button btnDown;
    public Button btnReplace;
    public Button btnReplaceAll;
    public Button btnUp;
    public CheckBox chkMatchCase;
    public Label lblResult;
    public TextArea txtEditor;
    public TextField txtFind;
    public TextField txtReplace;
    private ArrayList<SearchResult> searchResultsList = new ArrayList<>();
    private int pos = 0;


    public void initialize() {
        txtFind.textProperty().addListener((value, previous, current) -> {
            calculateSearchResults();
        });
        txtEditor.textProperty().addListener((value, previous, current) -> {
            calculateSearchResults();
        });
    }

    @FXML
    public void btnDownOnAction(ActionEvent event) {
        pos++;
        if (pos == searchResultsList.size()) {
            pos = -1;
            return;
        }
        select();
    }

    @FXML
    public void btnUpOnAction(ActionEvent event) {
        pos--;
        if (pos < 0) {
            pos = searchResultsList.size();
            return;
        }
        select();
    }

    @FXML
    public void btnReplaceAllOnAction(ActionEvent event) {

    }

    @FXML
    public void btnReplaceOnAction(ActionEvent event) {

    }

    @FXML
    public void chkMatchCaseOnAction(ActionEvent event) {

    }

    public void calculateSearchResults() {
        String query = txtFind.getText();
        searchResultsList.clear();
        pos = 0;
        txtEditor.deselect();

        Pattern pattern;
        try {
            pattern = Pattern.compile(query);
        } catch (RuntimeException e) {
            return;
        }
        Matcher matcher = pattern.matcher(txtEditor.getText());

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            SearchResult result = new SearchResult(start, end);
            searchResultsList.add(result);
        }

        lblResult.setText(String.format("%d Results", searchResultsList.size()));

        select();
    }

    private void select() {
        if (searchResultsList.size() == 0) return;
        SearchResult searchResult = searchResultsList.get(pos);
        txtEditor.selectRange(searchResult.getStart(), searchResult.getEnd());
        lblResult.setText(String.format("%d/%d Results", pos+1, searchResultsList.size()));
    }

}
