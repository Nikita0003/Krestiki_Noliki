package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rb33;

    @FXML
    private ToggleGroup FieldSize;

    @FXML
    private RadioButton rb44;

    @FXML
    private RadioButton rb55;

    @FXML
    private RadioButton rb66;

    @FXML
    private RadioButton rb77;

    @FXML
    private RadioButton rb88;

    @FXML
    private RadioButton rb99;

    @FXML
    private RadioButton rb1010;

    @FXML
    private Button playButton;

    @FXML
    void initialize() {
        rb55.fire();
    playButton.setOnAction(actionEvent -> {
        playButton.getScene().getWindow().hide();

        RadioButton setButton = (RadioButton) FieldSize.getSelectedToggle();

        if (setButton == rb55) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm55.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (setButton == rb33) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm33.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (setButton == rb44) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm44.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (setButton == rb66) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm66.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (setButton == rb77) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm77.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (setButton == rb88) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm88.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (setButton == rb99) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm99.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (setButton == rb1010) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PlayForm1010.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    });

    }
}
