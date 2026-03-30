package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierEntity {
    private String id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
}
