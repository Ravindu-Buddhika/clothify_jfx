package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class SupplierEntity {
    @Id
    private String id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
}
