package service.IMPL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.OrderDetailsDTO;
import model.entity.OrderDetailsEntity;
import repository.IMPL.OrderDetailsRepositoriesIMPL;
import repository.OrderDetailsRepository;
import service.OrderDetailsService;
import service.OrderService;

import java.sql.SQLException;

public class OrderDetailsServiceIMPL implements OrderDetailsService {
    OrderDetailsRepository repository;

    {
        try {
            repository = new OrderDetailsRepositoriesIMPL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<OrderDetailsDTO> getAllOrderDetails(String id) {
        ObservableList<OrderDetailsEntity> allOrderDetails = null;
        try {
            allOrderDetails = repository.getAllOrderDetails(id); // your repository call
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ObservableList<OrderDetailsDTO> orderDetailsList = FXCollections.observableArrayList();

        for (OrderDetailsEntity entity : allOrderDetails) {
            OrderDetailsDTO dto = new OrderDetailsDTO(
                    entity.getId(),
                    entity.getOrderID(),
                    entity.getProductID(),
                    entity.getDis(),
                    entity.getPrice(),
                    entity.getQty()
            );
            orderDetailsList.add(dto);
        }
        return orderDetailsList;
    }

    @Override
    public void addOrder(OrderDetailsDTO orderDetailsDTO) {
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity(
                orderDetailsDTO.getId(),
                orderDetailsDTO.getOrderID(),
                orderDetailsDTO.getProductID(),
                orderDetailsDTO.getDis(),
                orderDetailsDTO.getPrice(),
                orderDetailsDTO.getQty()
        );

        int status = 0;
        try {
            status = repository.addOrderDetails(orderDetailsEntity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getID() {
        String lastOrderId = null;
        try {
            lastOrderId = repository.getLastOrderDetail();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(lastOrderId);
        if (lastOrderId != null && lastOrderId.length() > 1) {
            String numericPart = lastOrderId.substring(1);
            int number = Integer.parseInt(numericPart);
            number++;
            String newOrderId = "OD" + String.format("%03d", number);
            return newOrderId;
        } else {
            // First order case or error fallback
            return "OD001";
        }
    }
}
