package repository;

import javafx.collections.ObservableList;
import model.entity.OrderDetailsEntity;
import model.entity.OrderEntity;

import java.sql.SQLException;

public interface OrderDetailsRepository {
    public ObservableList<OrderDetailsEntity> getAllOrderDetails(String orderId) throws SQLException;
    public int addOrderDetails(OrderDetailsEntity orderDetailsEntity) throws SQLException;
    public String getLastOrderDetail() throws SQLException;
}
