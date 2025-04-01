package org.example.uniformfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    private int cnt = 0;
    @FXML
    private TextField nameInput;

    @FXML
    protected void onHelloButtonClick() {
        cnt++;
        welcomeText.setText("Hello: " + nameInput.getText());
        nameInput.setText("");
    }
}