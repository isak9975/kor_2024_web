package main.day65.model.entity;

import jakarta.persistence.*;
import lombok.*;
import main.day65.model.dto.BoardDto;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor
@Entity @Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String btitle;

    @Column(columnDefinition = "Longtext")
    private String bcontent;

    //단방향
    @ManyToOne
    @JoinColumn(name = "mno") //FK 필드명
    private MemberEntity memberEntity;

    // entity ======> Dto
    public BoardDto toDto(){
        return BoardDto.builder().bno(this.bno).btitle(this.btitle).bcontent(this.bcontent).build();
    }


}
