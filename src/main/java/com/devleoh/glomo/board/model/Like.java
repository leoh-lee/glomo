package com.devleoh.glomo.board.model;

import com.devleoh.glomo.member.model.Member;
import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.devleoh.glomo.board.model
 * fileName       : Like
 * author         : nimoh
 * date           : 2024/08/18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/08/18        nimoh       최초 생성
 */
@Entity
@Table(name = "LIKES")
@Getter
@NoArgsConstructor
public class Like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIKE_ID")
    private Long likeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;
}
