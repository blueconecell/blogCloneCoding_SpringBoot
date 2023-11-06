package com.jeongyeon.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeongyeon.boardback.entity.UserEntity;


//JpaRepository를 확장받아서 사용할 것인데 generic을 2개를 받는다
// 어떤 엔티티의 리포지토리인지, 그 엔티티의 PK타입을 지정
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    
    // 유저 테이블에서 이 email 값이 하나라도 존재한다면 true를 반환한다.
    // SQL문을 알아서 만들어서 알아서 실행해준다.
    // existBy 이부분 오타주의
    boolean existByEmail(String email);
    boolean existByNickname(String nickname);
    boolean existByTelNumber(String telNumber);
}
