package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.dto.AdminDTO;
import model.dto.LoggingDataDTO;
import model.dto.StaffDTO;
import model.dto.UserDTO;
import service.LoginService;
import service.IMPL.LoginServiceIMPL;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    LoginService loginService=new LoginServiceIMPL();
    UserDTO userDTO=new UserDTO();
    Stage stage=new Stage();

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
        checkUser(loggingDataDTO);
    }

    public void checkUser(LoggingDataDTO loggingDataDTO){
        String type=loginService.loging(loggingDataDTO);

        if ("Admin".equals(type)) {
            AdminDTO adminDTO=loginService.getAdmin();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminDashbode.fxml"));
                Parent root = loader.load();

                AdminDashbodeController adminDashbode=loader.getController();
                adminDashbode.loadUser(adminDTO);
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setResizable(false);
            stage.show();
//            System.out.println("hello admin");
        } else if ("Staff".equals(type)) {
            StaffDTO staffDTO=loginService.getStaff();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffDashbode.fxml"));
                Parent root = loader.load();

                StaffDashbodeController staffDashbode=loader.getController();
                staffDashbode.loadUser(staffDTO);
                stage.setScene(new Scene(root));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setResizable(false);
            stage.show();
//          System.out.println("hello staff");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(80);  // Radius X
        clip.setArcHeight(80); // Radius Y
        imageView.setClip(clip);
    }
}
