package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StaffDTO {
    private String id;
    private String name;
    private String mobile;
    private String email;
}
