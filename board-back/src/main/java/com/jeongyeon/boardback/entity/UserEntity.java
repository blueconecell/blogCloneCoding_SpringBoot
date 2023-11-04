package com.jeongyeon.boardback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

// entity를 사용할 것이디. 이름은user이다
@Entity(name="user")

// 객체인 class와 table을 매핑시켜야한다.
@Table(name = "user")
public class UserEntity {

    @Id
    private String email;
    private String password;
    private String nickname;
    private String telNumber;
    private String address;
    private String addressDetail;
    private String profileImage;
    // 간단하게 entity를 만들어줄 수 있는데. 만들게되면 리포지토리를 추가해줘야함
    

}
