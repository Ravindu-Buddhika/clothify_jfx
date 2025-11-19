package service.IMPL;

import repository.DashbodeRepository;
import repository.IMPL.DashbodeRepositoryIMPL;
import service.DashbodeService;

import java.sql.SQLException;

public class DashbodeServiceIMPL implements DashbodeService {
    DashbodeRepository dashbodeRepository;

    {
        try {
            dashbodeRepository = new DashbodeRepositoryIMPL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countOfSells(){
        try {
            return dashbodeRepository.countOfSells();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int countOfItems(){
        try {
            return dashbodeRepository.countOfItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int countOfCustomers(){
        try {
            return dashbodeRepository.countOfCustomers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int countOfSuppliers(){
        try {
            return dashbodeRepository.countOfSuppliers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int countOfStaff(){
        try {
            return dashbodeRepository.countOfStaff();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
