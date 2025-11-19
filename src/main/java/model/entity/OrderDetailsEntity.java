package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailsEntity {
    private String id;
    private String orderID;
    private String productID;
    private int dis;
    private double price;
    private int qty;
}
