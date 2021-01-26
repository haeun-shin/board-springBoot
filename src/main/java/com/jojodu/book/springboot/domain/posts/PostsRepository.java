package com.jojodu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long>{

    // springDataJpa에서 제공해주는 CRUD 외에도 추가로 쿼리를 작성을 해도 된다.
    // 그럴때는 @Query로 사용해주면 된다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
