package repository.IMPL;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entity.OrderDetailsEntity;
import repository.OrderDetailsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsRepositoriesIMPL implements OrderDetailsRepository {
    Connection connection= DBConnection.getInstance().getConnection();

    public OrderDetailsRepositoriesIMPL() throws SQLException {
    }

    @Override
    public ObservableList<OrderDetailsEntity> getAllOrderDetails(String orderId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM orderdetailsentity WHERE orderID = ?"
        );
        preparedStatement.setString(1, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<OrderDetailsEntity> orderDetailsEntities = FXCollections.observableArrayList();

        while (resultSet.next()) {
            OrderDetailsEntity detailsEntity = new OrderDetailsEntity(
                    resultSet.getString("id"),
                    resultSet.getString("orderID"),
                    resultSet.getString("productID"),
                    resultSet.getInt("dis"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("qty")
            );
            orderDetailsEntities.add(detailsEntity);
        }
        return orderDetailsEntities;

    }

    @Override
    public int addOrderDetails(OrderDetailsEntity orderDetailsEntity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO orderdetailsentity (id, orderID, productID, dis, price, qty) VALUES (?, ?, ?, ?, ?, ?)"
        );

        preparedStatement.setString(1, orderDetailsEntity.getId());
        preparedStatement.setString(2, orderDetailsEntity.getOrderID());
        preparedStatement.setString(3, orderDetailsEntity.getProductID());
        preparedStatement.setInt(4, orderDetailsEntity.getDis());
        preparedStatement.setDouble(5, orderDetailsEntity.getPrice());
        preparedStatement.setInt(6, orderDetailsEntity.getQty());

        int status = preparedStatement.executeUpdate();
        return status;

    }

    @Override
    public String getLastOrderDetail() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ordersEntity ORDER BY id DESC LIMIT 1");
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()) {
            String id = resultSet.getString("id");
            return id;
        }else{
            return null;
        }
    }
}
