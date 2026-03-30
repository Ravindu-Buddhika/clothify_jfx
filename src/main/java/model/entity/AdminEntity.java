package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminEntity {
    private String id;
    private String name;
    private String mobile;
    private String email;
    private String user_id;
}
