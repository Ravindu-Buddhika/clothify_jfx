package repository.IMPL;

import database.DBConnection;
import model.dto.LoggingDataDTO;
import model.entity.AdminEntity;
import model.entity.StaffEntity;
import model.entity.UserEntity;
import repository.LoginRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepositoryIMPL implements LoginRepository {
    LoggingDataDTO loggingData=null;
    UserEntity userEntity = null;
    Connection connection= DBConnection.getInstance().getConnection();

    public LoginRepositoryIMPL() throws SQLException {
    }

    @Override
    public UserEntity checkUser(LoggingDataDTO loggingDataDTO) throws SQLException {
        loggingData = loggingDataDTO;

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM userentity WHERE name = ?"
        );
        preparedStatement.setString(1, loggingDataDTO.getName());
        ResultSet resultSet = preparedStatement.executeQuery();



        if (resultSet.next()) {
            userEntity = new UserEntity();
            userEntity.setId(resultSet.getString("id"));
            userEntity.setName(resultSet.getString("name"));
            userEntity.setPassword(resultSet.getString("password"));
            userEntity.setType(resultSet.getString("type"));
        }

        return userEntity;

    }

    @Override
    public AdminEntity getAdmin() throws SQLException {
        AdminEntity adminEntity=null;
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM adminentity WHERE user_id = ?");
        preparedStatement.setString(1,userEntity.getId());
        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){
            adminEntity= new AdminEntity();
            adminEntity.setId(resultSet.getString("id"));
            adminEntity.setName(resultSet.getString("name"));
            adminEntity.setMobile(resultSet.getString("mobile"));
            adminEntity.setEmail(resultSet.getString("email"));
            adminEntity.setUser_id(resultSet.getString("user_id"));
        }
        return adminEntity;
    }

    @Override
    public StaffEntity getStaff() throws SQLException {
        StaffEntity staffEntity=null;
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM staffentity WHERE user_id = ?");
        preparedStatement.setString(1,userEntity.getId());
        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){
           staffEntity=new StaffEntity();
            staffEntity.setId(resultSet.getString("id"));
            staffEntity.setName(resultSet.getString("name"));
            staffEntity.setMobile(resultSet.getString("mobile"));
            staffEntity.setEmail(resultSet.getString("email"));
            staffEntity.setUser_id(resultSet.getString("user_id"));
        }

        return staffEntity;
    }
}
