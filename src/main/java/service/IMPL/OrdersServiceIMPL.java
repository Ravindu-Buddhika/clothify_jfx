package service.IMPL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.dto.OrderDTO;
import model.entity.OrderEntity;
import repository.IMPL.OrderRepositoryIMPL;
import repository.OrderRepository;
import service.OrderService;

import java.sql.SQLException;

public class OrdersServiceIMPL implements OrderService {
    OrderRepository orderRepository;

    {
        try {
            orderRepository = new OrderRepositoryIMPL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<OrderDTO> getAllOrders() {
        ObservableList<OrderEntity> allOrders = null;
        try {
            allOrders = orderRepository.getAllOrders(); // your repository call
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ObservableList<OrderDTO> orders = FXCollections.observableArrayList();

        for (OrderEntity entity : allOrders) {
            OrderDTO dto = new OrderDTO(
                    entity.getId(),
                    entity.getDate(),
                    entity.getTotal(),
                    entity.getCustomerId()
            );
            orders.add(dto);
        }

        return orders;

    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity(
                orderDTO.getId(),
                orderDTO.getDate(),
                orderDTO.getTotal(),
                orderDTO.getCustomerId()
        );

        int status = 0;
        try {
            status = orderRepository.addOrders(orderEntity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getID() {
        String lastOrderId = null;
        try {
            lastOrderId = orderRepository.getLastOrder();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lastOrderId);
        if (lastOrderId != null && lastOrderId.length() > 1) {
            String numericPart = lastOrderId.substring(1);
            int number = Integer.parseInt(numericPart);
            number++;
            String newOrderId = "O" + String.format("%03d", number);
            return newOrderId;
        } else {
            // First order case or error fallback
            return "O001";
        }
    }
}
