package repository;

import javafx.collections.ObservableList;
import model.entity.CustomerEntity;
import model.entity.OrderEntity;

import java.sql.SQLException;

public interface OrderRepository {
    public ObservableList<OrderEntity> getAllOrders() throws SQLException;
    public int addOrders(OrderEntity orderEntity) throws SQLException;
    public String getLastOrder() throws SQLException;
}
