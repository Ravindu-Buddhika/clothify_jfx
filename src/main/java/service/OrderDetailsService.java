package service;

import javafx.collections.ObservableList;
import model.dto.OrderDTO;
import model.dto.OrderDetailsDTO;

public interface OrderDetailsService {
    public ObservableList<OrderDetailsDTO> getAllOrderDetails(String id);
    public void addOrder(OrderDetailsDTO orderDetailsDTO);
    public String getID();
}
