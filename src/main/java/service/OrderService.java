package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;
import model.dto.OrderDTO;

public interface OrderService {
    public ObservableList<OrderDTO> getAllOrders();
    public void addOrder(OrderDTO orderDTO);
    public String getID();
}
