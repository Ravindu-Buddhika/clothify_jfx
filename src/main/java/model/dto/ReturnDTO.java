package model.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReturnDTO {
    private String id;
    private LocalDate date;
    private double total;
}
