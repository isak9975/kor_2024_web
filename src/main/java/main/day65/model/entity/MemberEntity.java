package main.day65.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor
@Entity @Table(name="member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;

    @Column(columnDefinition = "varchar(30)", unique = true, nullable = false)
    private String mid;

    @Column(columnDefinition = "varchar(50)")
    private String mpwd;

    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL)
    @Builder.Default
    private List<BoardEntity> boardEntityArrayList = new ArrayList<>();


}
