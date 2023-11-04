package com.jeongyeon.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeongyeon.boardback.entity.FavoriteEntity;


// pk타입을 지정해줘야하는데 string, int 2개가 있기 때문에 타입을 만들어줘야한다.
// entity 폴더 아래에 primaryKey 폴더를 새로 만들어서 정의해줄 것이다.
// 근데 오류때문에 일단 Interger로 씀
@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Integer>{
    
}


// 오류!!
// FavoritePK에서 자꾸 int로 쓰라고 오류떠서 일단 int로 써놓겠음
// import com.jeongyeon.boardback.entity.primaryKey.FavoritePK;
// @Repository
// public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePK>{
    
// }
