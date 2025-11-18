package service;

import model.dto.LoggingDataDTO;

public interface LoginService {
    public String checkUser(LoggingDataDTO loggingDataDTO);
}
