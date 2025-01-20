package main.day64.day64task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor
@Entity @Table(name = "Category")
public class CategoryEntity {

    @Id
    private int cno;

}
