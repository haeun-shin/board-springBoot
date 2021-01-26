package com.jojodu.book.springboot.domain.posts;

import com.jojodu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// lombok 어노테이션
@Getter
@NoArgsConstructor
// JPA 어노테이션
// @Entity: 테이블과 링크될 클래스임을 나타냄. 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭.
@Entity
public class Posts extends BaseTimeEntity {
    // @Id: 해당 테이블의 PK필드를 나타냄.
    // @GeneratedValue: PK의 생성 규칙을 나타냄. 스프링 부트 2.0에서는 GenerationType.IDENTITY를 추가해야 auto_increment가 됨.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: 테이블의 칼럼을 나타내며, 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨.
    // 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
