package model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailsDTO {
    private String id;
    private String orderID;
    private String productID;
    private int dis;
    private double price;
    private int qty;
}
