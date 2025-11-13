package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminDTO {
    private String id;
    private String name;
    private String mobile;
    private String email;
}
