package model.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItemDTO {
    private String id;
    private String orderID;
    private String productID;
    private String productName;
    private int dis;
    private double price;
    private int qty;
    private String date;
    private double total;
    private String customerId;
}
