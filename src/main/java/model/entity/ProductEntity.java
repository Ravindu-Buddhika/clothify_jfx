package model.entity;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEntity {
    @Id
    private String code;
    private String name;
    private String category;
    private int qtyOnHand;
}
