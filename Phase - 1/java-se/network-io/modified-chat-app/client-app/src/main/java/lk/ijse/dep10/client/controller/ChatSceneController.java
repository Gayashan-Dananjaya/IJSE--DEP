package lk.ijse.dep10.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatSceneController {

    @FXML
    private Button btnSend;

    @FXML
    private ListView<?> lstUsers;

    @FXML
    private TextArea txtChatHistory;

    @FXML
    private TextField txtMessage;

    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String username;

    public void initData(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, String username) {
        this.socket = socket;
        this.ois = ois;
        this.oos = oos;
        this.username = username;
        System.out.println(this.username);
    }

    @FXML
    void btnSendOnAction(ActionEvent event) {

    }

    private void readServerResponses() {

    }

}
