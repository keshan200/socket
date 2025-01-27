package lk.ijse.controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    @FXML
    private JFXTextArea serverTextArea;

    @FXML
    private TextField serverTextField;


    @FXML
    private Label lblAvailability;

    @FXML
    private Label lblAvailability2;

    DataOutputStream out;
    DataInputStream in;
    Socket socket;
    ServerSocket serverSocket;
    String msg = "";


    public void initialize() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(3001);
                lblAvailability.setText("Started!");


                socket = serverSocket.accept();
                lblAvailability2.setText("Client Connected!");

                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());


                while (!msg.equals("exit")) {
                    serverTextArea.appendText("Client: " + in.readUTF() + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }





    @FXML
    void serverSendBtn(ActionEvent event) throws IOException {

        String text = serverTextField.getText();
        out.writeUTF(text);
        out.flush();
        serverTextField.clear();

    }

}
