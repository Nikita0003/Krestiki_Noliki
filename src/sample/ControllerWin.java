package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerWin {

    @FXML
    private Button okButton;

    @FXML
    void initialize() {

        okButton.setOnAction(actionEvent -> {
            okButton.getScene().getWindow().hide();
        });

    }

}
