package service.IMPL;

import javafx.collections.ObservableList;
import model.dto.CartItemDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailsDTO;
import model.entity.OrderEntity;
import service.OrderDetailsService;
import service.OrderService;
import service.PlaceOrderService;

import java.time.LocalDate;

public class PlaceOrderServiceIMPL implements PlaceOrderService {
    OrderService orderService=new OrdersServiceIMPL();
    OrderDetailsService orderDetailsService=new OrderDetailsServiceIMPL();

    @Override
    public void placeOrder(ObservableList<CartItemDTO> cartItemDTOS) {
        insertOrder(new OrderDTO(
                cartItemDTOS.get(0).getOrderID(),
                LocalDate.parse(cartItemDTOS.get(0).getDate()),
                cartItemDTOS.get(0).getTotal(),
                cartItemDTOS.get(0).getCustomerId()

        ));
        System.out.println("Cart size: " + cartItemDTOS.size());
        for (CartItemDTO item : cartItemDTOS) {
            insterOrderDtails(new OrderDetailsDTO(
                    item.getId(),
                    item.getOrderID(),
                    item.getProductID(),
                    item.getDis(),
                    item.getPrice(),
                    item.getQty()
            ));
        }
    }

    private void insterOrderDtails(OrderDetailsDTO orderDetailsDTO) {
        orderDetailsService.addOrder(orderDetailsDTO);
        System.out.println(orderDetailsDTO);

    }

    private void insertOrder(OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
    }
}
