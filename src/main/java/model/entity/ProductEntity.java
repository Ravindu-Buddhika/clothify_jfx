package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEntity {
    private String code;
    private String name;
    private double price;
    private int dis;
    private String category;
    private int qtyOnHand;
}
