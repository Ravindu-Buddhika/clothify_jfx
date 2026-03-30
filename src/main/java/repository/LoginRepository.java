package repository;

import model.dto.AdminDTO;
import model.dto.LoggingDataDTO;
import model.entity.AdminEntity;
import model.entity.StaffEntity;
import model.entity.UserEntity;

import java.sql.SQLException;

public interface LoginRepository {
    public UserEntity checkUser(LoggingDataDTO loggingDataDTO) throws SQLException;
    public AdminEntity getAdmin() throws SQLException;
    public StaffEntity getStaff() throws SQLException;
}
