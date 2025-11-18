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
public class StaffEntity {
    @Id
    private String id;
    private String name;
    private String mobile;
    private String email;
}
