package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierDTO {
    private String id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
}
