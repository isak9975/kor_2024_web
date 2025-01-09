package main.day60.model;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class WaitingDto {
    private int no;
    private String  number;
    private int count;
}
