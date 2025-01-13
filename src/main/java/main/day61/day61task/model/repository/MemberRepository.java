package main.day61.day61task.model.repository;

import main.day61.day61task.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository
        extends JpaRepository<MemberEntity,String> {

}
