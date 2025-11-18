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
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String mobileNumber;
    private String email;
    private String city;
    private int loyalty;
}
