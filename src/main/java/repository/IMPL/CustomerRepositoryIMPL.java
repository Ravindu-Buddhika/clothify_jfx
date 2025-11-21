package repository.IMPL;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entity.CustomerEntity;
import model.entity.ProductEntity;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryIMPL implements CustomerRepository {

    ObservableList<CustomerEntity> customerList =FXCollections.observableArrayList();
    Connection connection= DBConnection.getInstance().getConnection();

    public CustomerRepositoryIMPL() throws SQLException {
    }

    @Override
    public ObservableList<CustomerEntity> getAllCustomers() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customerEntity");
        ResultSet resultSet=preparedStatement.executeQuery();

        while (resultSet.next()) {
            CustomerEntity customerEntity=new CustomerEntity();
            customerEntity.setId(resultSet.getString("id"));
            customerEntity.setName(resultSet.getString("name"));
            customerEntity.setMobileNumber(resultSet.getString("mobileNumber"));
            customerEntity.setEmail(resultSet.getString("email"));
            customerEntity.setCity(resultSet.getString("city"));
            customerEntity.setLoyalty(resultSet.getInt("loyalty"));

            customerList.add(customerEntity);
        }
        return customerList;
    }

    @Override
    public int addCustomer(CustomerEntity customerEntity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO customerentity (id, name, mobileNumber, email, city, loyalty) VALUES (?, ?, ?, ?, ?, ?)"
        );

        preparedStatement.setString(1, customerEntity.getId());
        preparedStatement.setString(2, customerEntity.getName());
        preparedStatement.setString(3, customerEntity.getMobileNumber());
        preparedStatement.setString(4, customerEntity.getEmail());
        preparedStatement.setString(5, customerEntity.getCity());
        preparedStatement.setInt(6, customerEntity.getLoyalty());

        int status = preparedStatement.executeUpdate();
        return status;

    }

    @Override
    public int deleteCustomer(String id) throws SQLException {
        int status;
        PreparedStatement preparedStatement = null;

        preparedStatement = connection.prepareStatement("DELETE FROM customerentity WHERE id = ?");
        preparedStatement.setString(1, id);

        status = preparedStatement.executeUpdate();
        return status;

    }

    @Override
    public int updateCustomer(CustomerEntity customerEntity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE customerentity SET name = ?, mobileNumber = ?, email = ?, city = ?, loyalty = ? WHERE id = ?"
        );

        preparedStatement.setString(1, customerEntity.getName());
        preparedStatement.setString(2, customerEntity.getMobileNumber());
        preparedStatement.setString(3, customerEntity.getEmail());
        preparedStatement.setString(4, customerEntity.getCity());
        preparedStatement.setInt(5, customerEntity.getLoyalty());
        preparedStatement.setString(6, customerEntity.getId()); // customer's unique ID

        int status = preparedStatement.executeUpdate();
        return status;

    }

    @Override
    public String getLastOrder() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customerentity ORDER BY id DESC LIMIT 1");
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()) {
            String id = resultSet.getString("id");
            return id;
        }else{
            return null;
        }
    }

    @Override
    public ResultSet searchCustomer(String number) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customerentity WHERE mobileNumber = ?");
        preparedStatement.setString(1, number);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;

    }
}
