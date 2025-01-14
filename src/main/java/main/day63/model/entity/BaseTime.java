package main.day63.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@MappedSuperclass // 슈퍼 클래스 목적으로 사용할 클래스( 자체적인 매핑없음 )
@EntityListeners( AuditingEntityListener.class)
public class BaseTime {

    @CreatedDate
    private LocalDateTime cdate; // 엔티티 생성 날짜/시간

    private LocalDateTime update; // 엔티티 수정 날짜/시간
}
