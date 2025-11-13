package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String id;
    private String name;
    private String mobileNumber;
    private String email;
    private String city;
    private int loyalty;
}
