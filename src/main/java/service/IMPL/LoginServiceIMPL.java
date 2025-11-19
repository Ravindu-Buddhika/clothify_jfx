package service.IMPL;

import javafx.scene.control.Alert;
import model.dto.AdminDTO;
import model.dto.LoggingDataDTO;
import model.dto.StaffDTO;
import model.entity.AdminEntity;
import model.entity.StaffEntity;
import model.entity.UserEntity;
import repository.LoginRepository;
import repository.IMPL.LoginRepositoryIMPL;
import service.LoginService;

import java.sql.SQLException;

public class LoginServiceIMPL implements LoginService {
    LoginRepository repository;
    UserEntity userEntity=null;

    {
        try {
            repository = new LoginRepositoryIMPL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String loging(LoggingDataDTO loggingDataDTO) {
        try {
            userEntity = repository.checkUser(loggingDataDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (userEntity == null) {
            // No user found
            Alert alert = new Alert(Alert.AlertType.ERROR); // or CONFIRMATION, WARNING, ERROR
            alert.setTitle("Invalid UserName");
            alert.setHeaderText(null);
            alert.setContentText("Invalid UserName! try again");
            alert.showAndWait();
        }else {
            String password = userEntity.getPassword();
            if (loggingDataDTO.getPassword().equals(password)) {
                String type=checkUserType();
                return type;
                // Success
            } else {
                // Wrong password

                Alert alert = new Alert(Alert.AlertType.ERROR); // or CONFIRMATION, WARNING, ERROR
                alert.setTitle("Incorrect Password");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect password! try again");
                alert.showAndWait();

                return "Error";
            }
        }
        return null;
    }

    public String checkUserType(){

        if(userEntity.getType().equals("Admin")){
            return "Admin";
        } else {
            return "Staff";
        }
    }

    @Override
    public AdminDTO getAdmin(){
        AdminDTO adminDTO=new AdminDTO();
        AdminEntity adminEntity= null;
        try {
            adminEntity = repository.getAdmin();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        adminDTO = new AdminDTO(
                adminEntity.getId(),
                adminEntity.getName(),
                adminEntity.getMobile(),
                adminEntity.getEmail()
        );


        return adminDTO;
    }

    @Override
    public StaffDTO getStaff(){
        StaffDTO staffDTO=new StaffDTO();
        StaffEntity staffEntity = null;
        try {
            staffEntity = repository.getStaff();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        staffDTO=new StaffDTO(
                staffEntity.getId(),
                staffEntity.getName(),
                staffEntity.getMobile(),
                staffEntity.getEmail()
        );

        return staffDTO;
    }

//    @Override
//    public String checkUser(LoggingDataDTO loggingDataDTO) {
//        return repository.checkUser(loggingDataDTO);
//    }
}
