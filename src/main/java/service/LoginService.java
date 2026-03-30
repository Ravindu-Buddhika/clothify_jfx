package service;

import model.dto.AdminDTO;
import model.dto.LoggingDataDTO;
import model.dto.StaffDTO;

public interface LoginService {
    public String loging(LoggingDataDTO loggingDataDTO);
    public AdminDTO getAdmin();
    public StaffDTO getStaff();
}
