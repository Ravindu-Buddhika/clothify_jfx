package repository;

import javafx.collections.ObservableList;
import model.entity.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {
    public ObservableList<CustomerEntity> getAllCustomers() throws SQLException;
    public int addCustomer(CustomerEntity customerEntity) throws SQLException;
    public int deleteCustomer(String id) throws SQLException;
    public int updateCustomer(CustomerEntity customerEntity) throws SQLException;
    public String getLastOrder() throws SQLException;
    public ResultSet searchCustomer(String number) throws SQLException;
}
