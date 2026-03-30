package service;

import javafx.collections.ObservableList;
import model.dto.CartItemDTO;

public interface PlaceOrderService {
    void placeOrder(ObservableList<CartItemDTO> cartItemDTOS);
}
