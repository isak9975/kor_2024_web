package main.day65.model.dto;

import lombok.*;
import main.day65.model.entity.BoardEntity;
@Getter@Setter@Builder@ToString
@AllArgsConstructor@NoArgsConstructor
public class BoardDto {
    private int bno;
    private String btitle;
    private String bcontent;

    //Dto =====> entity
    public BoardEntity toEntity(){
        return BoardEntity.builder().btitle(this.btitle).bcontent(this.bcontent).bno(this.bno).build();
    }
}
