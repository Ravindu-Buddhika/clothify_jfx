package repository;

import java.sql.SQLException;

public interface DashbodeRepository {
    public int countOfSells() throws SQLException;
    public int countOfItems() throws SQLException;
    public int countOfCustomers() throws SQLException;
    public int countOfSuppliers() throws SQLException;
    public int countOfStaff() throws SQLException;
}
