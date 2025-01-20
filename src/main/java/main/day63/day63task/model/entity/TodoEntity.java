package main.day63.day63task.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import main.day63.day63task.model.dto.TodoDto;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor
@Entity @Table(name = "Todo")
public class TodoEntity extends BaseTime {

    @Id
    private int tno;
    private String tcontent;
    private String tstatus;

    public TodoDto toDto(){
        return TodoDto.builder().tno(this.tno).tcontent(this.tcontent).tstatus(this.tstatus).build();
    }



}
