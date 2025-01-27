package lk.ijse.controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientController {

    @FXML
    private JFXTextArea clientTextArea;

    @FXML
    private TextField clientTextField;

    @FXML
    private Label lblAvailability;



    DataOutputStream out;
    DataInputStream in;
    Socket socket;
    String message = "";


    public void  initialize() {
        new Thread(() -> {
            try {
                socket = new Socket("localhost",3001);
                lblAvailability.setText("Connected"+"\n");

                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream( socket.getInputStream());

                while (!message.equals("exit")) {
                    clientTextArea.appendText("Server: " + in.readUTF() + "\n");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }




    @FXML
    void clientSendBtn(ActionEvent event) throws IOException {
            String text = clientTextField.getText();
            out.writeUTF(text);
            out.flush();
            clientTextField.clear();
         }
    }


