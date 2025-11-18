package service;

import javafx.scene.control.Alert;
import model.dto.LoggingDataDTO;
import model.dto.UserDTO;
import model.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class LoginServiceIMPL implements LoginService{
    UserDTO userDTO=new UserDTO();
    LoggingDataDTO loggingData=null;

    @Override
    public String checkUser(LoggingDataDTO loggingDataDTO){
        loggingData=loggingDataDTO;
        Session session = HibernateUtil.getSession();

        try {
            String hql = "FROM UserEntity u WHERE u.name = :name";
            Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
            query.setParameter("name", loggingDataDTO.getName());

            UserEntity userEntity = query.uniqueResult();

            if (userEntity != null) {
                userDTO = new UserDTO(
                        userEntity.getName(),
                        userEntity.getPassword(),
                        userEntity.getType()
                );
            }

        } finally {
            session.close();
        }

        int status= checkPassword();
        if(status==1){
            return userDTO.getType();
        }

        return null;
    }

    public int checkPassword(){
        String password= userDTO.getPassword();

        if (userDTO != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR); // or CONFIRMATION, WARNING, ERROR
            alert.setTitle("Invalid UserName");
            alert.setHeaderText(null);
            alert.setContentText("Invalid UserName! try again");
            alert.showAndWait();
            return 404;
        } else{
            if (loggingData.getPassword().equals(password)){
                return 1;
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR); // or CONFIRMATION, WARNING, ERROR
                alert.setTitle("Incorrect Password");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect password! try again");
                alert.showAndWait();
                return 0;
            }
        }
    }
}
