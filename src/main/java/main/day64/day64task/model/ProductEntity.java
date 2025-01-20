package main.day64.day64task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name = "Product")
public class ProductEntity {

    private int pno;
}
