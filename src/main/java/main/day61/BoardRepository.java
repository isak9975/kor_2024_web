package main.day61;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// SPRING MVC 패턴 에서 Repository 역활
public interface BoardRepository
        extends JpaRepository<BoardEntity,Integer> {
    //해당하는 인터페이스는 BoardEntity 클래스 조작할 예정이고,
    //pk 필드는 bno 의 타입인 int ---> Integer -->  제네릭에는 기본형 불가

}
