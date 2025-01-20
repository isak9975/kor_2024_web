package main.day63.day63task.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter@Setter@Builder
@AllArgsConstructor@NoArgsConstructor

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    @CreatedDate
    private LocalDateTime cdate; // 엔티티 생성 날짜/시간

    @LastModifiedDate
    private LocalDateTime update; // 엔티티 수정 날짜/시간

}
