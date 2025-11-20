package model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private String code;
    private String name;
    private double price;
    private int dis;
    private String category;
    private String gender;
    private int qtyOnHand;
    private String supplierID;
}
