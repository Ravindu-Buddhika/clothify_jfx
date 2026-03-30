package repository.IMPL;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.OrderDTO;
import model.entity.CustomerEntity;
import model.entity.OrderEntity;
import model.entity.ProductEntity;
import repository.OrderRepository;

import java.sql.*;

public class OrderRepositoryIMPL implements OrderRepository {
    ObservableList<OrderEntity> orderEntities = FXCollections.observableArrayList();
    Connection connection= DBConnection.getInstance().getConnection();

    public OrderRepositoryIMPL() throws SQLException {
    }

    @Override
    public ObservableList<OrderEntity> getAllOrders() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ordersEntity");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            OrderEntity orderEntity = new OrderEntity(
                    resultSet.getString("id"),
                    resultSet.getDate("date").toLocalDate(),
                    resultSet.getDouble("total"),
                    resultSet.getString("customerId")
            );
            orderEntities.add(orderEntity);
        }
        return orderEntities;

    }

    @Override
    public int addOrders(OrderEntity orderEntity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO ordersEntity (id, date, total, customerId) VALUES (?, ?, ?, ?)"
        );

        preparedStatement.setString(1, orderEntity.getId());
        preparedStatement.setDate(2, Date.valueOf(orderEntity.getDate())); // assuming orderEntity.getDate() returns LocalDate
        preparedStatement.setDouble(3, orderEntity.getTotal());
        preparedStatement.setString(4, orderEntity.getCustomerId());

        int status = preparedStatement.executeUpdate();
        return status;


    }

    @Override
    public String getLastOrder() throws SQLException {
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
