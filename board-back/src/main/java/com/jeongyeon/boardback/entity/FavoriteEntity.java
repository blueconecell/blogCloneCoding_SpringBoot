package com.jeongyeon.boardback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.jeongyeon.boardback.entity.primaryKey.FavoritePK;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "favorite")
@Table(name = "favorite")

// id가 어떤class를 따르는지 정함 -> 복합키를 표시할 수 있게 됨
@IdClass(FavoritePK.class)

// favorite은 키가 2개인 차이가 있다.
public class FavoriteEntity {
    
    @Id
    private String userEmail;

    @Id
    private int boardNumber;
}
