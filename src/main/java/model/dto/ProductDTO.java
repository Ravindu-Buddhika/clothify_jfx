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
    private String category;
    private int qtyOnHand;
}
