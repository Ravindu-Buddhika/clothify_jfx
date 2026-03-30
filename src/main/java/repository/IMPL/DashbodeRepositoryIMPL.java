package repository.IMPL;

import database.DBConnection;
import repository.DashbodeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashbodeRepositoryIMPL implements DashbodeRepository {
    Connection connection= DBConnection.getInstance().getConnection();

    public DashbodeRepositoryIMPL() throws SQLException {
    }

    @Override
    public int countOfSells() throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT(*) FROM ordersEntity;");
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }else {
            return 0;
        }

    }

    @Override
    public int countOfItems() throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT(*) FROM productEntity;");
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }else {
            return 0;
        }
    }

    @Override
    public int countOfCustomers() throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT(*) FROM customerEntity;");
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }else {
            return 0;
        }
    }

    @Override
    public int countOfSuppliers() throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT(*) FROM supplierEntity;");
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }else {
            return 0;
        }
    }

    @Override
    public int countOfStaff() throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT(*) FROM staffEntity;");
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }else {
            return 0;
        }
    }
}
