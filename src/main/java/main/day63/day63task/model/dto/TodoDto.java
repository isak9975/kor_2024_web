package main.day63.day63task.model.dto;

import lombok.*;
import main.day61.day61task.model.entity.MemberEntity;
import main.day63.day63task.model.entity.TodoEntity;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor@ToString
public class TodoDto {

    private int tno;
    private String tcontent;
    private String tstatus;

    private String cdate;
    private String update;

    public TodoEntity toEntity(){
        return TodoEntity.builder().tcontent(this.tcontent).tno(this.tno).tstatus(this.tstatus).build();
    }

}
