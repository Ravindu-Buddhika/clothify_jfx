package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import model.dto.LoggingDataDTO;
import model.dto.UserDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnClickedSingin(ActionEvent event) {
        LoggingDataDTO loggingDataDTO=new LoggingDataDTO(
                txtUsername.getText(),
                txtPassword.getText()
        );
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(80);  // Radius X
        clip.setArcHeight(80); // Radius Y
        imageView.setClip(clip);
    }
}
